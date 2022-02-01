package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.JSONObjectFix;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.MiniappHttpUtil;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.MiniGameStorageExceedManager;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05116;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class FileJsPlugin
  extends BaseJsPlugin
{
  private static final String ENCODING_ARRAYBUFFER_ = "__internal__array_buffer";
  private static final String ERR_ACCESS_NO_FILE = "no such file or directory ";
  private static final String ERR_FILE_ALREADY_EXIST = "file already exists ";
  private static final String ERR_INVALID_DATA = "invalid data ";
  private static final String ERR_INVALID_ENCODE = "invalid encoding ";
  private static final String ERR_INVALID_PATH = "invalid path";
  private static final String ERR_NOT_DIR = "not a directory ";
  private static final String ERR_NOT_STORE_FILE_PATH = "not a store filePath";
  private static final String ERR_NO_SUCH_FILE = "no such file or directory, open ";
  private static final String ERR_PARAMS_DIR_PATH_IS_NULL = "fail parameter error: parameter.dirPath should be String instead of Null;";
  private static final String ERR_PERMISSION_DENIED = "permission denied, open ";
  private static final String ERR_READ_ZIP_DATA = "read zip data";
  private static final String ERR_STORAGE_EXCEEDED = "the maximum size of the file storage is exceeded";
  private static final String ERR_TEMP_FILE_NOT_EXIST = "tempFilePath file not exist";
  private static final String ERR_UNLINK_OPERATION_BAN = "operation not permitted, unlink ";
  private static final String ERR_WRITEFILE_ERROR = "failed to  write file";
  private static final String TAG = "FileJsPlugin";
  private static Set<String> sSupportEncodingRead = new FileJsPlugin.1();
  private static int shouldReport = -1;
  public int curPreloadTaskId = 0;
  private ConcurrentHashMap<String, String> downloadMap = new ConcurrentHashMap();
  private AtomicInteger downloadTaskId = new AtomicInteger(0);
  private MiniAppFileManager fileManager;
  private ConcurrentHashMap<Integer, String> uploadMap = new ConcurrentHashMap();
  
  private void callbackDownloadFailed(String paramString, RequestEvent paramRequestEvent, Exception paramException)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      this.downloadMap.remove(paramString);
      localJSONObject.put("downloadTaskId", paramString);
      localJSONObject.put("state", "fail");
      localJSONObject.put("errMsg", "Download Failed.");
      paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramString)
    {
      QMLog.e("FileJsPlugin", "download onDownloadSucceed callback fail exception.", paramException);
    }
  }
  
  private void checkUsrFileSize(int paramInt)
  {
    if (!((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).isFolderCanWrite(2, paramInt, this.mIsMiniGame, this.mMiniAppInfo, this.mMiniAppContext.getAttachedActivity())) {
      throw new IOException("the maximum size of the file storage is exceeded");
    }
  }
  
  private void doOnDownloadHeadersReceived(Map<String, List<String>> paramMap, String paramString, RequestEvent paramRequestEvent)
  {
    new JSONObject();
    try
    {
      paramMap = JSONUtil.headerToJson(paramMap);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", paramString);
      localJSONObject.put("statusCode", 200);
      localJSONObject.put("header", paramMap);
      localJSONObject.put("state", "headersReceived");
      paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception paramMap)
    {
      QMLog.e("FileJsPlugin", "onDownloadSucceed headerJson error." + paramMap);
    }
  }
  
  private int doUpload(RequestEvent paramRequestEvent, long paramLong, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, File paramFile)
  {
    int i = paramRequestEvent.callbackId;
    Object localObject = paramJSONObject.optJSONObject("header");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("formData");
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramJSONObject = "";; paramJSONObject = paramString2.replace("wxfile://", ""))
    {
      paramString2 = StringUtil.json2map((JSONObject)localObject);
      paramString2.put("Referer", getRequestReferer());
      localObject = StringUtil.json2map(localJSONObject);
      ((UploaderProxy)ProxyManager.get(UploaderProxy.class)).upload(paramString1, paramString2, paramString4, paramString3, paramJSONObject, (Map)localObject, 60, new FileJsPlugin.3(this, i, paramRequestEvent, paramLong, paramFile));
      return i;
    }
  }
  
  private String execFileTask(String paramString, FileJsPlugin.FileTask paramFileTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramFileTask.run();
    }
    ThreadManager.executeOnDiskIOThreadPool(new FileJsPlugin.17(this, paramFileTask));
    return "";
  }
  
  public static String getOutFilePath(DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult, String paramString)
  {
    try
    {
      String str = MimeTypeMap.getFileExtensionFromUrl(paramString);
      if (TextUtils.isEmpty(str))
      {
        paramDownloadResult = (List)paramDownloadResult.headers.get("Content-Type");
        if ((paramDownloadResult != null) && (paramDownloadResult.size() > 0)) {}
        for (paramDownloadResult = (String)paramDownloadResult.get(0); !TextUtils.isEmpty(paramDownloadResult); paramDownloadResult = "")
        {
          paramDownloadResult = paramDownloadResult.trim().split("/");
          if ((paramDownloadResult.length <= 1) || (!"image".equalsIgnoreCase(paramDownloadResult[0]))) {
            break;
          }
          paramDownloadResult = getString(str, paramDownloadResult[1]);
          if (TextUtils.isEmpty(paramDownloadResult)) {
            break;
          }
          paramDownloadResult = paramString + "." + paramDownloadResult;
          if (!FileUtils.copyFile(paramString, paramDownloadResult)) {
            break;
          }
          FileUtils.deleteFile(paramString);
          return paramDownloadResult;
        }
      }
      return paramString;
    }
    catch (Throwable paramDownloadResult)
    {
      QMLog.e("FileJsPlugin", "create file extension failed! " + paramDownloadResult);
    }
  }
  
  private String getRequestReferer()
  {
    Object localObject = "";
    String str1 = "debug";
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    if (localMiniAppInfo != null)
    {
      str2 = localMiniAppInfo.appId;
      str1 = localMiniAppInfo.version;
      localObject = str2;
      if (localMiniAppInfo.verType != 3)
      {
        str1 = "0";
        localObject = str2;
      }
    }
    String str2 = str1;
    if (!MiniappHttpUtil.isRefererVersionValid(str1)) {
      str2 = "invalidVersion";
    }
    return "https://appservice.qq.com/" + (String)localObject + "/" + str2 + "/page-frame.html";
  }
  
  private static String getString(String paramString1, String paramString2)
  {
    if ("jpeg".equalsIgnoreCase(paramString2)) {
      paramString1 = "jpg";
    }
    do
    {
      return paramString1;
      if ("png".equalsIgnoreCase(paramString2)) {
        return "png";
      }
      if ("gif".equalsIgnoreCase(paramString2)) {
        return "gif";
      }
      if ("svg+xml".equalsIgnoreCase(paramString2)) {
        return "svg";
      }
    } while (!"webp".equalsIgnoreCase(paramString2));
    return "webp";
  }
  
  private String handleCallbackFail(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    if (!paramRequestEvent.event.endsWith("Sync"))
    {
      paramRequestEvent.fail(paramJSONObject, paramString);
      return "";
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, paramJSONObject, paramString).toString();
  }
  
  private String handleCallbackOK(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (!paramRequestEvent.event.endsWith("Sync"))
    {
      paramRequestEvent.ok(paramJSONObject);
      return "";
    }
    return ApiUtil.wrapCallbackOk(paramRequestEvent.event, paramJSONObject).toString();
  }
  
  private boolean isEncodingSupport(String paramString)
  {
    try
    {
      if (sSupportEncodingRead.contains(paramString)) {
        return true;
      }
      boolean bool = Charset.isSupported(paramString);
      return bool;
    }
    catch (Throwable paramString)
    {
      QMLog.e("FileJsPlugin", "isEncodingSupport exception,e:" + paramString.getMessage(), paramString);
    }
    return false;
  }
  
  private void onDownloadSucceed(int paramInt1, String paramString1, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult, String paramString2, MiniAppFileManager paramMiniAppFileManager, int paramInt2, String paramString3, RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString4, long paramLong, String paramString5)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = retryCopyFile(paramString1, paramString2, new File(paramString2));
          if ((!paramString1.exists()) || (!paramString1.canRead())) {
            continue;
          }
          paramString2 = getOutFilePath(paramDownloadResult, paramString2);
          paramMiniAppFileManager.updateFolderSize(paramInt2, paramString1.length());
          paramString4 = new JSONObject();
          paramString4.put("downloadTaskId", paramString3);
          paramString4.put("progress", 100);
          paramString4.put("totalBytesWritten", paramString1.length());
          paramString4.put("totalBytesExpectedToWrite", paramString1.length());
          paramString4.put("state", "progressUpdate");
          paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", paramString4.toString(), 0);
          QMLog.d("FileJsPlugin", "download success.");
          paramString1 = new JSONObject();
        }
      }
      catch (Exception paramString1)
      {
        QMLog.e("FileJsPlugin", "download onDownloadSucceed exception.", paramString1);
        callbackDownloadFailed(paramString3, paramRequestEvent, paramString1);
        continue;
        QMLog.d("FileJsPlugin", "download failed, filepath not exists, tmpFile:" + paramString4);
        this.downloadMap.remove(paramString3);
        paramString1 = new JSONObject();
        paramString1.put("downloadTaskId", paramString3);
        paramString1.put("state", "fail");
        paramString1.put("errMsg", "Download Failed: file not exists or can not read.");
        paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", paramString1.toString(), 0);
        continue;
      }
      try
      {
        paramDownloadResult = JSONUtil.headerToJson(paramDownloadResult.headers);
        paramString1 = paramDownloadResult;
      }
      catch (Exception paramDownloadResult)
      {
        QMLog.e("FileJsPlugin", "onDownloadSucceed headerJson error." + paramDownloadResult);
        continue;
        paramDownloadResult.put("filePath", paramJSONObject.optString("filePath"));
      }
    }
    this.downloadMap.remove(paramString3);
    paramDownloadResult = new JSONObject();
    paramDownloadResult.put("statusCode", 200);
    paramDownloadResult.put("downloadTaskId", paramString3);
    if ((paramJSONObject.isNull("filePath")) || (TextUtils.isEmpty(paramJSONObject.optString("filePath"))))
    {
      paramDownloadResult.put("tempFilePath", paramMiniAppFileManager.getWxFilePath(paramString2));
      paramDownloadResult.put("header", paramString1);
      paramDownloadResult.put("state", "success");
      paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", paramDownloadResult.toString(), 0);
      reportDownloadFileResult(System.currentTimeMillis() - paramLong, paramInt1);
      MiniProgramLpReportDC05115.reportDownloadResult(this.mMiniAppInfo, 0, System.currentTimeMillis() - paramLong, false);
      MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.mMiniAppInfo, paramString5, System.currentTimeMillis() - paramLong, paramInt1, 0);
      return;
    }
  }
  
  private void onEventFinish(String paramString1, boolean paramBoolean, long paramLong1, long paramLong2, String paramString2)
  {
    paramLong1 = paramLong2 - paramLong1;
    paramLong2 = System.currentTimeMillis() - paramLong2;
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramBoolean) {}
    for (String str = " succeed!";; str = " fail!")
    {
      QMLog.d("FileJsPlugin", str + " [minigame timecost: waitingTime=" + paramLong1 + "ms workingTime=" + paramLong2 + "ms ], filePath:" + paramString2);
      if (this.mIsMiniGame) {
        break;
      }
      return;
    }
    if (shouldReport < 0) {
      if (new Random(System.currentTimeMillis()).nextInt(100) >= 10) {
        break label155;
      }
    }
    label155:
    for (int i = 1;; i = 0)
    {
      shouldReport = i;
      if (shouldReport == 0) {
        break;
      }
      ThreadManager.executeOnComputationThreadPool(new FileJsPlugin.18(this, paramString1, paramBoolean, paramLong1, paramLong2));
      return;
    }
  }
  
  private Object readFile(String paramString1, String paramString2)
  {
    paramString2 = FileUtils.fileToBytes(new File(paramString2));
    if (paramString2 == null) {
      return null;
    }
    if ("base64".equals(paramString1)) {
      return Base64.encodeToString(paramString2, 2);
    }
    if ("binary".equals(paramString1)) {
      return StringUtil.to8BitAsciiString(paramString2);
    }
    if ("hex".equals(paramString1)) {
      return StringUtil.toHexString(new String(paramString2));
    }
    if ("__internal__array_buffer".equals(paramString1)) {
      return paramString2;
    }
    try
    {
      paramString1 = Charset.forName(paramString1).decode(ByteBuffer.wrap(paramString2));
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      QMLog.e("FileJsPlugin", "read file err", paramString1);
    }
    return null;
  }
  
  private void reportDownloadFileResult(long paramLong, int paramInt)
  {
    if (this.mIsMiniGame) {}
    for (String str = "1";; str = "0")
    {
      MiniReportManager.reportEventType(this.mMiniAppInfo, 640, null, null, null, paramInt, str, paramLong, null);
      return;
    }
  }
  
  @NotNull
  private File retryCopyFile(String paramString1, String paramString2, File paramFile)
  {
    Object localObject2 = paramFile;
    if (!paramFile.exists())
    {
      localObject2 = paramFile;
      if (!TextUtils.isEmpty(paramString1))
      {
        Object localObject1 = paramFile;
        try
        {
          File localFile = new File(paramString1);
          localObject1 = paramFile;
          localObject2 = paramFile;
          if (localFile.exists())
          {
            localObject1 = paramFile;
            localObject2 = paramFile;
            if (localFile.isFile())
            {
              localObject1 = paramFile;
              localObject2 = paramFile;
              if (localFile.length() > 0L)
              {
                localObject1 = paramFile;
                QMLog.w("FileJsPlugin", "download Succeed but target file not exists, try copy from download tmp file:" + paramString1 + ", length:" + localFile.length() + ", to:" + paramString2);
                localObject1 = paramFile;
                paramString2 = FileUtils.createFile(paramString2);
                localObject1 = paramString2;
                if (FileUtils.copyFile(localFile, paramString2))
                {
                  localObject1 = paramString2;
                  if (paramString2.exists())
                  {
                    localObject1 = paramString2;
                    if (paramString2.length() == localFile.length())
                    {
                      localObject1 = paramString2;
                      QMLog.i("FileJsPlugin", "copy from download tmp file:" + paramString1 + " success");
                      return paramString2;
                    }
                  }
                }
                localObject1 = paramString2;
                localObject2 = paramString2;
                if (paramString2.exists())
                {
                  localObject1 = paramString2;
                  paramString2.delete();
                  return paramString2;
                }
              }
            }
          }
        }
        catch (Throwable paramString2)
        {
          QMLog.e("FileJsPlugin", "try copy from download tmp file exception! tmp file:" + paramString1, paramString2);
          localObject2 = localObject1;
        }
      }
    }
    return localObject2;
  }
  
  private String writeUsrFile(long paramLong1, String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, RequestEvent paramRequestEvent, long paramLong2)
  {
    String str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getUsrPath(paramString1);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        if (writeUsrFile(paramArrayOfByte, paramString2, paramString3, str, false)) {
          break label239;
        }
        paramString3 = new StringBuilder().append("writeFile failed! path:").append(str).append(",encoding:").append(paramString3).append(",nativeBufferBytes:");
        if (paramArrayOfByte == null) {
          break label262;
        }
        paramString1 = Integer.valueOf(paramArrayOfByte.length);
        paramArrayOfByte = paramString3.append(paramString1).append(",data:");
        if (paramString2 != null)
        {
          paramString1 = Integer.valueOf(paramString2.length());
          QMLog.e("FileJsPlugin", paramString1);
          onEventFinish(paramRequestEvent.event, false, paramLong2, paramLong1, str);
          return handleCallbackFail(paramRequestEvent, null, "failed to  write file" + str);
        }
        paramString1 = "null";
        continue;
        onEventFinish(paramRequestEvent.event, false, paramLong2, paramLong1, str);
      }
      catch (IOException paramString1)
      {
        onEventFinish(paramRequestEvent.event, false, paramLong2, paramLong1, str);
        return handleCallbackFail(paramRequestEvent, null, paramString1.getMessage());
      }
      return handleCallbackFail(paramRequestEvent, null, "the maximum size of the file storage is exceeded");
      label239:
      onEventFinish(paramRequestEvent.event, true, paramLong2, paramLong1, str);
      return handleCallbackOK(paramRequestEvent, null);
      label262:
      paramString1 = "0";
    }
  }
  
  private boolean writeUsrFile(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    long l1;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      checkUsrFileSize(paramArrayOfByte.length);
      l1 = FileUtils.getFileSizes(paramString3);
      bool = FileUtils.writeFile(paramString3, paramArrayOfByte, paramBoolean);
      paramBoolean = bool;
      if (bool)
      {
        l2 = FileUtils.getFileSizes(paramString3);
        this.fileManager.updateFolderSize(2, l2 - l1);
        paramBoolean = bool;
      }
    }
    label190:
    do
    {
      return paramBoolean;
      if ("base64".equals(paramString2)) {
        paramArrayOfByte = Base64.decode(paramString1, 2);
      }
      for (;;)
      {
        if ((!paramString2.equals("binary")) && (!paramString2.equals("hex")) && (!paramString2.equals("base64"))) {
          break label190;
        }
        checkUsrFileSize(paramArrayOfByte.length);
        l1 = FileUtils.getFileSizes(paramString3);
        bool = FileUtils.writeFile(paramString3, paramArrayOfByte, paramBoolean);
        paramBoolean = bool;
        if (!bool) {
          break;
        }
        l2 = FileUtils.getFileSizes(paramString3);
        this.fileManager.updateFolderSize(2, l2 - l1);
        return bool;
        if ("hex".equals(paramString2)) {
          paramArrayOfByte = StringUtil.hexStr2Bytes(paramString1);
        } else {
          paramArrayOfByte = paramString1.getBytes();
        }
      }
      paramArrayOfByte = Charset.forName(paramString2).encode(new String(paramArrayOfByte, Charset.forName("utf8")));
      paramString1 = paramArrayOfByte.array();
      checkUsrFileSize(paramArrayOfByte.limit());
      l1 = FileUtils.getFileSizes(paramString3);
      bool = FileUtils.writeFile(paramString3, paramString1, paramBoolean, paramArrayOfByte.limit());
      paramBoolean = bool;
    } while (!bool);
    long l2 = FileUtils.getFileSizes(paramString3);
    this.fileManager.updateFolderSize(2, l2 - l1);
    return bool;
  }
  
  @JsEvent({"access", "accessSync"})
  public String access(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    return execFileTask(paramRequestEvent.event, new FileJsPlugin.4(this, paramRequestEvent, l));
  }
  
  @JsEvent({"fs_appendFile", "fs_appendFileSync"})
  public String appendFile(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObjectFix(paramRequestEvent.jsonParams);
      String str1 = ((JSONObject)localObject).optString("filePath");
      String str2 = ((JSONObject)localObject).optString("data");
      String str3 = ((JSONObject)localObject).optString("encoding", "utf8");
      localObject = NativeBuffer.unpackNativeBuffer(paramRequestEvent.jsService, (JSONObject)localObject, "data");
      if (localObject != null) {}
      for (localObject = ((NativeBuffer)localObject).buf;; localObject = null)
      {
        paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.5(this, str3, paramRequestEvent, l, str1, str2, (byte[])localObject));
        return paramRequestEvent;
      }
      return "{}";
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"fs_copyFile", "fs_copyFileSync"})
  public String copyFile(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("srcPath");
      localObject = ((JSONObject)localObject).optString("destPath");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.7(this, str, paramRequestEvent, l, (String)localObject));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
  }
  
  @JsEvent({"createDownloadTask"})
  public String createDownloadTask(RequestEvent paramRequestEvent)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(localJSONObject);
        String str4 = String.valueOf(this.downloadTaskId.getAndIncrement());
        String str2 = localJSONObject.optString("url");
        if (localJSONObject.has("origin_url"))
        {
          Object localObject1 = localJSONObject.optString("origin_url");
          boolean bool = localJSONObject.optBoolean("__skipDomainCheck__", false);
          Object localObject2 = localJSONObject.optJSONObject("header");
          MiniAppFileManager localMiniAppFileManager = (MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class);
          String str3 = localMiniAppFileManager.getUsrPath(localJSONObject.optString("filePath"));
          if (TextUtils.isEmpty(str2))
          {
            QMLog.e("FileJsPlugin", "download url is null");
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "download url is null.").toString();
          }
          if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, (String)localObject1, 2))
          {
            QMLog.e("FileJsPlugin", "download url Domain not configured." + (String)localObject1);
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "Domain not configured.").toString();
          }
          if (TextUtils.isEmpty(str3))
          {
            if (!TextUtils.isEmpty(str3)) {
              continue;
            }
            localObject1 = localMiniAppFileManager.getTmpPathByUrl(str2);
          }
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              str2 = getDownloadUrl(str2);
              this.downloadMap.put(str4, str2);
              localObject2 = StringUtil.json2map((JSONObject)localObject2);
              ((Map)localObject2).put("Referer", getRequestReferer());
              doDownload(paramRequestEvent, localJSONObject, str4, localMiniAppFileManager, str3, i, (String)localObject1, (Map)localObject2, str2);
            }
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("downloadTaskId", str4);
              localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject1).toString();
              return localObject1;
            }
            catch (Throwable localThrowable)
            {
              QMLog.e("FileJsPlugin", paramRequestEvent.event + " return error.", localThrowable);
              continue;
            }
            i = 2;
            continue;
            localObject1 = str3;
            continue;
            QMLog.d("FileJsPlugin", "download failed, savepath is null.");
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("downloadTaskId", str4);
            ((JSONObject)localObject1).put("state", "fail");
            ((JSONObject)localObject1).put("errMsg", "Download Failed, savepath is null");
            paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", ((JSONObject)localObject1).toString(), 0);
            continue;
          }
          catch (Exception localException)
          {
            QMLog.e("FileJsPlugin", "download failed." + localException);
            continue;
          }
        }
        String str1 = str2;
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return "";
      }
    }
  }
  
  @JsEvent({"createFileSystemInstance"})
  public String createFileSystemInstance(RequestEvent paramRequestEvent)
  {
    return "{}";
  }
  
  @JsEvent({"createUploadTask"})
  public String createUploadTask(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(localJSONObject);
      str2 = localJSONObject.optString("url");
      if (localJSONObject.has("origin_url"))
      {
        Object localObject = localJSONObject.optString("origin_url");
        boolean bool = localJSONObject.optBoolean("__skipDomainCheck__", false);
        String str3 = localJSONObject.optString("filePath");
        String str4 = localJSONObject.optString("name");
        String str5 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str3);
        File localFile = new File(str5);
        if (TextUtils.isEmpty(str2))
        {
          QMLog.w("FileJsPlugin", "upload url is empty.");
          return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, ":upload url is empty : " + str2).toString();
        }
        if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, (String)localObject, 3))
        {
          QMLog.w("FileJsPlugin", "check upload DomainValid fail, callbackFail, event:" + paramRequestEvent.event + ", callbackId:" + paramRequestEvent.callbackId + ", url:" + str2);
          return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "url not in domain list, 请求域名不合法").toString();
        }
        if (TextUtils.isEmpty(str5))
        {
          QMLog.w("FileJsPlugin", "upload file error. " + str5);
          return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, ":file doesn't exist").toString();
        }
        if (TextUtils.isEmpty(str4))
        {
          QMLog.w("FileJsPlugin", "upload file name error. " + str4);
          return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, ":file name is error").toString();
        }
        int i = doUpload(paramRequestEvent, l, localJSONObject, str2, str3, str4, str5, localFile);
        this.uploadMap.put(Integer.valueOf(i), str2);
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("uploadTaskId", i);
          localObject = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject).toString();
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          QMLog.e("FileJsPlugin", paramRequestEvent.event + " return error.", localThrowable);
        }
        return "";
      }
    }
    catch (JSONException paramRequestEvent)
    {
      for (;;)
      {
        String str2;
        paramRequestEvent.printStackTrace();
        continue;
        String str1 = str2;
      }
    }
  }
  
  public void doDownload(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString1, MiniAppFileManager paramMiniAppFileManager, String paramString2, int paramInt, String paramString3, Map paramMap, String paramString4)
  {
    ThreadManager.executeOnNetworkIOThreadPool(new FileJsPlugin.2(this, paramString1, paramRequestEvent, System.currentTimeMillis(), paramString4, paramString3, paramMiniAppFileManager, paramInt, paramJSONObject, paramString2, paramMap));
  }
  
  public String getDownloadUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = paramString.indexOf("?");
    String str1 = paramString;
    if (i != -1)
    {
      String str2 = paramString.substring(0, i);
      str1 = paramString.substring(i, paramString.length());
      paramString = str1;
      if (str1.contains("|")) {
        paramString = str1.replace("|", "%7C");
      }
      str1 = str2 + paramString;
    }
    return str1.replace(" ", "%20");
  }
  
  /* Error */
  @JsEvent({"getFileInfo"})
  public void getFileInfo(RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: invokestatic 625	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 245	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 843	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   12: invokespecial 873	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: ldc_w 607
    //   22: invokevirtual 613	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 6
    //   27: aload 5
    //   29: ldc_w 1008
    //   32: ldc_w 1010
    //   35: invokevirtual 850	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 5
    //   40: aload_0
    //   41: getfield 133	com/tencent/qqmini/sdk/plugins/FileJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   44: ldc_w 292
    //   47: invokeinterface 298 2 0
    //   52: checkcast 292	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   55: aload 6
    //   57: invokevirtual 948	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 6
    //   62: ldc_w 1010
    //   65: aload 5
    //   67: invokevirtual 684	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +220 -> 290
    //   73: ldc_w 1012
    //   76: aload 5
    //   78: invokevirtual 684	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +214 -> 295
    //   84: goto +206 -> 290
    //   87: aload 6
    //   89: invokestatic 363	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +175 -> 267
    //   95: iload_2
    //   96: ifeq +171 -> 267
    //   99: new 567	java/io/File
    //   102: dup
    //   103: aload 6
    //   105: invokespecial 568	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore 7
    //   110: new 245	org/json/JSONObject
    //   113: dup
    //   114: invokespecial 246	org/json/JSONObject:<init>	()V
    //   117: astore 8
    //   119: ldc_w 1012
    //   122: aload 5
    //   124: invokevirtual 684	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +68 -> 195
    //   130: aload 6
    //   132: invokestatic 1017	com/tencent/qqmini/sdk/core/utils/SecurityUtil:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +66 -> 205
    //   142: aload 5
    //   144: invokevirtual 1020	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   147: astore 5
    //   149: aload 8
    //   151: ldc_w 1022
    //   154: aload 5
    //   156: invokevirtual 255	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload 8
    //   162: ldc_w 1023
    //   165: aload 7
    //   167: invokevirtual 585	java/io/File:length	()J
    //   170: invokevirtual 596	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload_0
    //   175: aload_1
    //   176: getfield 532	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   179: iconst_1
    //   180: lload_3
    //   181: lload_3
    //   182: aload 6
    //   184: invokespecial 239	com/tencent/qqmini/sdk/plugins/FileJsPlugin:onEventFinish	(Ljava/lang/String;ZJJLjava/lang/String;)V
    //   187: aload_1
    //   188: aload 8
    //   190: invokevirtual 545	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   193: pop
    //   194: return
    //   195: aload 6
    //   197: invokestatic 1028	com/tencent/qqmini/sdk/launcher/utils/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 5
    //   202: goto -65 -> 137
    //   205: aconst_null
    //   206: astore 5
    //   208: goto -59 -> 149
    //   211: astore 5
    //   213: ldc 57
    //   215: new 330	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 1030
    //   225: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 5
    //   230: invokevirtual 565	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 344	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload_0
    //   243: aload_1
    //   244: getfield 532	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   247: iconst_0
    //   248: lload_3
    //   249: lload_3
    //   250: aload 6
    //   252: invokespecial 239	com/tencent/qqmini/sdk/plugins/FileJsPlugin:onEventFinish	(Ljava/lang/String;ZJJLjava/lang/String;)V
    //   255: aload_1
    //   256: invokevirtual 1032	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   259: pop
    //   260: return
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 868	org/json/JSONException:printStackTrace	()V
    //   266: return
    //   267: aload_0
    //   268: aload_1
    //   269: getfield 532	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   272: iconst_0
    //   273: lload_3
    //   274: lload_3
    //   275: aload 6
    //   277: invokespecial 239	com/tencent/qqmini/sdk/plugins/FileJsPlugin:onEventFinish	(Ljava/lang/String;ZJJLjava/lang/String;)V
    //   280: aload_1
    //   281: aconst_null
    //   282: ldc_w 1034
    //   285: invokevirtual 535	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   288: pop
    //   289: return
    //   290: iconst_1
    //   291: istore_2
    //   292: goto -205 -> 87
    //   295: iconst_0
    //   296: istore_2
    //   297: goto -210 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	FileJsPlugin
    //   0	300	1	paramRequestEvent	RequestEvent
    //   95	202	2	i	int
    //   3	272	3	l	long
    //   15	192	5	localObject	Object
    //   211	18	5	localThrowable	Throwable
    //   25	251	6	str	String
    //   108	58	7	localFile	File
    //   117	72	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   119	137	211	java/lang/Throwable
    //   142	149	211	java/lang/Throwable
    //   149	194	211	java/lang/Throwable
    //   195	202	211	java/lang/Throwable
    //   4	84	261	org/json/JSONException
    //   87	95	261	org/json/JSONException
    //   99	119	261	org/json/JSONException
    //   119	137	261	org/json/JSONException
    //   142	149	261	org/json/JSONException
    //   149	194	261	org/json/JSONException
    //   195	202	261	org/json/JSONException
    //   213	260	261	org/json/JSONException
    //   267	289	261	org/json/JSONException
  }
  
  @JsEvent({"getSavedFileInfo"})
  public String getSavedFileInfo(RequestEvent paramRequestEvent)
  {
    l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramRequestEvent.jsonParams).optString("filePath");
        str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject);
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localFile = new File(str);
        if (!localFile.exists()) {
          continue;
        }
        localObject = new JSONObject();
      }
      catch (JSONException paramRequestEvent)
      {
        Object localObject;
        String str;
        File localFile;
        paramRequestEvent.printStackTrace();
        continue;
        onEventFinish(paramRequestEvent.event, false, l, l, str);
        paramRequestEvent.fail(null, "no such file" + (String)localObject);
        continue;
        onEventFinish(paramRequestEvent.event, false, l, l, (String)localObject);
        paramRequestEvent.fail(null, "no such file" + (String)localObject);
        continue;
      }
      try
      {
        ((JSONObject)localObject).put("size", localFile.length());
        ((JSONObject)localObject).put("createTime", localFile.lastModified() / 1000L);
        onEventFinish(paramRequestEvent.event, true, l, l, str);
        paramRequestEvent.ok((JSONObject)localObject);
        return "";
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        onEventFinish(paramRequestEvent.event, false, l, l, str);
        paramRequestEvent.fail();
      }
    }
  }
  
  @JsEvent({"getSavedFileList"})
  public String getSavedFileList(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getSaveFileList();
    try
    {
      localJSONArray = new JSONArray();
      if (localObject1 == null) {
        break label161;
      }
      j = localObject1.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        int j;
        int i;
        Object localObject2;
        JSONObject localJSONObject;
        label161:
        localThrowable.printStackTrace();
        paramRequestEvent.fail();
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      localObject2 = localObject1[i];
      if ((localObject2 != null) && (localObject2.exists()) && (localObject2.isFile()))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("filePath", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(localObject2.getAbsolutePath()));
        localJSONObject.put("size", localObject2.length());
        localJSONObject.put("createTime", localObject2.lastModified() / 1000L);
        localJSONArray.put(localJSONObject);
      }
    }
    else
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("fileList", localJSONArray);
      paramRequestEvent.ok((JSONObject)localObject1);
      onEventFinish(paramRequestEvent.event, true, l, l, "");
      return "";
    }
  }
  
  @JsEvent({"mkdir", "mkdirSync"})
  public String mkdir(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("dirPath");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.8(this, str, localJSONObject, paramRequestEvent, l));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "{}";
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    if (this.mMiniAppInfo != null)
    {
      this.fileManager = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class));
      this.fileManager.setStorageLimit(this.mMiniAppInfo.usrFileSizeLimit);
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.mMiniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.mMiniAppInfo), null, "buffer_space", "", "", this.mMiniAppInfo.usrFileSizeLimit + "");
    }
  }
  
  public void onDestroy()
  {
    MiniGameStorageExceedManager.resetStorageExceedDialogStatus();
    super.onDestroy();
  }
  
  @JsEvent({"operateDownloadTask"})
  public String operateDownloadTask(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("downloadTaskId");
      if (("abort".equals(localJSONObject.optString("operationType"))) && (this.downloadMap.containsKey(str)))
      {
        ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).abort((String)this.downloadMap.get(str));
        localJSONObject = new JSONObject();
      }
      return "";
    }
    catch (JSONException paramRequestEvent)
    {
      try
      {
        localJSONObject.put("downloadTaskId", str);
        paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
        return paramRequestEvent;
      }
      catch (Throwable paramRequestEvent)
      {
        break label104;
      }
      paramRequestEvent = paramRequestEvent;
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"operateUploadTask"})
  public String operateUploadTask(RequestEvent paramRequestEvent)
  {
    try
    {
      paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
      int i = paramRequestEvent.optInt("uploadTaskId");
      if (("abort".equals(paramRequestEvent.optString("operationType"))) && (this.uploadMap.containsKey(Integer.valueOf(i)))) {
        ((UploaderProxy)ProxyManager.get(UploaderProxy.class)).abort((String)this.uploadMap.get(Integer.valueOf(i)));
      }
      return "";
    }
    catch (JSONException paramRequestEvent)
    {
      for (;;)
      {
        paramRequestEvent.printStackTrace();
      }
    }
  }
  
  @JsEvent({"readFile", "readFileSync"})
  public String readFile(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObjectFix(paramRequestEvent.jsonParams);
      String str2 = ((JSONObjectFix)localObject).optString("filePath");
      String str1 = ((JSONObjectFix)localObject).optString("encoding", "__internal__array_buffer");
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "__internal__array_buffer";
      }
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.9(this, str2, paramRequestEvent, l, (String)localObject));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "{}";
  }
  
  @JsEvent({"readdir", "readdirSync"})
  public String readdir(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("dirPath");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.10(this, str, localJSONObject, paramRequestEvent, l));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
  }
  
  @JsEvent({"removeSavedFile"})
  public String removeSavedFile(RequestEvent paramRequestEvent)
  {
    l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramRequestEvent.jsonParams);
        str = ((JSONObject)localObject).optString("filePath");
        if ((TextUtils.isEmpty(str)) || (((JSONObject)localObject).isNull("filePath")))
        {
          onEventFinish(paramRequestEvent.event, false, l1, l1, str);
          return handleCallbackFail(paramRequestEvent, null, "fail parameter error: parameter.dirPath should be String instead of Null;");
        }
        if (((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(str) != 1) {
          continue;
        }
        localObject = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
        if (!FileUtils.fileExists((String)localObject)) {
          continue;
        }
        long l2 = FileUtils.delete((String)localObject, false);
        this.fileManager.updateFolderSize(1, -l2);
        onEventFinish(paramRequestEvent.event, true, l1, l1, (String)localObject);
        paramRequestEvent.ok();
      }
      catch (JSONException paramRequestEvent)
      {
        Object localObject;
        String str;
        paramRequestEvent.printStackTrace();
        continue;
        onEventFinish(paramRequestEvent.event, false, l1, l1, str);
        paramRequestEvent.fail(null, "not a store filePath");
        continue;
      }
      return "";
      onEventFinish(paramRequestEvent.event, false, l1, l1, (String)localObject);
      paramRequestEvent.fail(null, "not a store filePath");
    }
  }
  
  @JsEvent({"fs_rename", "fs_renameSync"})
  public String rename(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("oldPath");
      localObject = ((JSONObject)localObject).optString("newPath");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.11(this, str, paramRequestEvent, l, (String)localObject));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
  }
  
  @JsEvent({"rmdir", "rmdirSync"})
  public String rmdir(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("dirPath");
      boolean bool = localJSONObject.optBoolean("recursive");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.12(this, str, localJSONObject, paramRequestEvent, l, bool));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
  }
  
  @JsEvent({"saveFile", "saveFileSync"})
  public String saveFile(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("tempFilePath");
      localObject = ((JSONObject)localObject).optString("filePath");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.6(this, str, paramRequestEvent, l, (String)localObject));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
  }
  
  @JsEvent({"stat", "statSync"})
  public String stat(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("path");
      boolean bool = localJSONObject.optBoolean("recursive");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.13(this, str, paramRequestEvent, l, bool));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "{}";
  }
  
  @JsEvent({"unlink", "unlinkSync"})
  public String unlink(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("filePath");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.14(this, str, paramRequestEvent, l));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
  }
  
  @JsEvent({"unzip"})
  public String unzip(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("zipFilePath");
      localObject = ((JSONObject)localObject).optString("targetPath");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.15(this, str, paramRequestEvent, l, (String)localObject));
      return paramRequestEvent;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
  }
  
  @JsEvent({"writeFile", "writeFileSync"})
  public String writeFile(RequestEvent paramRequestEvent)
  {
    byte[] arrayOfByte = null;
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str2 = ((JSONObject)localObject).optString("filePath");
      if (((JSONObject)localObject).isNull("data")) {}
      for (String str1 = null;; str1 = ((JSONObject)localObject).optString("data"))
      {
        String str3 = ((JSONObject)localObject).optString("encoding", "utf8");
        localObject = NativeBuffer.unpackNativeBuffer(paramRequestEvent.jsService, (JSONObject)localObject, "data");
        if (localObject != null) {
          arrayOfByte = ((NativeBuffer)localObject).buf;
        }
        return execFileTask(paramRequestEvent.event, new FileJsPlugin.16(this, str1, arrayOfByte, paramRequestEvent, l, str2, str3));
      }
      return "";
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin
 * JD-Core Version:    0.7.0.1
 */