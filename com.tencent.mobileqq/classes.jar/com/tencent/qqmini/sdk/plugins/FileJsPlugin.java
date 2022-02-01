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
import com.tencent.qqmini.sdk.core.utils.SecurityUtil;
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
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
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
  private static final Map<String, String> correctType = new FileJsPlugin.1();
  private static Set<String> sSupportEncodingRead = new FileJsPlugin.2();
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
      label71:
      break label71;
    }
    QMLog.e("FileJsPlugin", "download onDownloadSucceed callback fail exception.", paramException);
  }
  
  private void checkUsrFileSize(int paramInt)
  {
    if (((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).isFolderCanWrite(2, paramInt, this.mIsMiniGame, this.mMiniAppInfo, this.mMiniAppContext.getAttachedActivity())) {
      return;
    }
    throw new IOException("the maximum size of the file storage is exceeded");
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
      paramString = new StringBuilder();
      paramString.append("onDownloadSucceed headerJson error.");
      paramString.append(paramMap);
      QMLog.e("FileJsPlugin", paramString.toString());
    }
  }
  
  private int doUpload(RequestEvent paramRequestEvent, long paramLong, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, File paramFile)
  {
    int i = paramRequestEvent.callbackId;
    Object localObject = paramJSONObject.optJSONObject("header");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("formData");
    boolean bool = TextUtils.isEmpty(paramString2);
    paramJSONObject = "";
    if (!bool) {
      paramJSONObject = paramString2.replace("wxfile://", "");
    }
    paramString2 = StringUtil.json2map((JSONObject)localObject);
    paramString2.put("Referer", getRequestReferer());
    localObject = StringUtil.json2map(localJSONObject);
    ((UploaderProxy)ProxyManager.get(UploaderProxy.class)).upload(paramString1, paramString2, paramString4, paramString3, paramJSONObject, (Map)localObject, 60, new FileJsPlugin.4(this, i, paramRequestEvent, paramLong, paramFile));
    return i;
  }
  
  private String execFileTask(String paramString, FileJsPlugin.FileTask paramFileTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramFileTask.run();
    }
    ThreadManager.executeOnDiskIOThreadPool(new FileJsPlugin.18(this, paramFileTask));
    return "";
  }
  
  public static String getOutFilePath(DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult, String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = MimeTypeMap.getFileExtensionFromUrl(paramString);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramDownloadResult = (List)paramDownloadResult.headers.get("Content-Type");
          if ((paramDownloadResult == null) || (paramDownloadResult.size() <= 0)) {
            break label183;
          }
          paramDownloadResult = (String)paramDownloadResult.get(0);
          if (!TextUtils.isEmpty(paramDownloadResult))
          {
            paramDownloadResult = paramDownloadResult.trim().split("/");
            if ((paramDownloadResult.length > 1) && ("image".equalsIgnoreCase(paramDownloadResult[0])))
            {
              paramDownloadResult = getString((String)localObject, paramDownloadResult[1]);
              if (!TextUtils.isEmpty(paramDownloadResult))
              {
                localObject = new StringBuilder(paramString);
                ((StringBuilder)localObject).append(".");
                ((StringBuilder)localObject).append(paramDownloadResult);
                paramDownloadResult = ((StringBuilder)localObject).toString();
                if (FileUtils.copyFile(paramString, paramDownloadResult))
                {
                  FileUtils.deleteFile(paramString);
                  return paramDownloadResult;
                }
              }
            }
          }
        }
      }
      catch (Throwable paramDownloadResult)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("create file extension failed! ");
        ((StringBuilder)localObject).append(paramDownloadResult);
        QMLog.e("FileJsPlugin", ((StringBuilder)localObject).toString());
      }
      return paramString;
      label183:
      paramDownloadResult = "";
    }
  }
  
  private String getRequestReferer()
  {
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    Object localObject2;
    if (localMiniAppInfo != null)
    {
      localObject3 = localMiniAppInfo.appId;
      localObject1 = localMiniAppInfo.version;
      localObject2 = localObject3;
      if (localMiniAppInfo.verType != 3)
      {
        localObject1 = "0";
        localObject2 = localObject3;
      }
    }
    else
    {
      localObject2 = "";
      localObject1 = "debug";
    }
    Object localObject3 = localObject1;
    if (!MiniappHttpUtil.isRefererVersionValid((String)localObject1)) {
      localObject3 = "invalidVersion";
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://appservice.qq.com/");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append((String)localObject3);
    ((StringBuilder)localObject1).append("/page-frame.html");
    return ((StringBuilder)localObject1).toString();
  }
  
  private static String getString(String paramString1, String paramString2)
  {
    if ("jpeg".equalsIgnoreCase(paramString2)) {
      return "jpg";
    }
    if ("png".equalsIgnoreCase(paramString2)) {
      return "png";
    }
    if ("gif".equalsIgnoreCase(paramString2)) {
      return "gif";
    }
    if ("svg+xml".equalsIgnoreCase(paramString2)) {
      return "svg";
    }
    if ("webp".equalsIgnoreCase(paramString2)) {
      paramString1 = "webp";
    }
    return paramString1;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isEncodingSupport exception,e:");
      localStringBuilder.append(paramString.getMessage());
      QMLog.e("FileJsPlugin", localStringBuilder.toString(), paramString);
    }
    return false;
  }
  
  private void onDownloadSucceed(int paramInt1, String paramString1, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult, String paramString2, MiniAppFileManager paramMiniAppFileManager, int paramInt2, String paramString3, RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString4, long paramLong, String paramString5)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = retryCopyFile(paramString1, paramString2, new File(paramString2));
        boolean bool = paramString1.exists();
        if ((bool) && (paramString1.canRead()))
        {
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
          try
          {
            paramDownloadResult = JSONUtil.headerToJson(paramDownloadResult.headers);
            paramString1 = paramDownloadResult;
          }
          catch (Exception paramDownloadResult)
          {
            paramString4 = new StringBuilder();
            paramString4.append("onDownloadSucceed headerJson error.");
            paramString4.append(paramDownloadResult);
            QMLog.e("FileJsPlugin", paramString4.toString());
          }
          this.downloadMap.remove(paramString3);
          paramDownloadResult = new JSONObject();
          paramDownloadResult.put("statusCode", 200);
          paramDownloadResult.put("downloadTaskId", paramString3);
          if ((!paramJSONObject.isNull("filePath")) && (!TextUtils.isEmpty(paramJSONObject.optString("filePath")))) {
            paramDownloadResult.put("filePath", paramJSONObject.optString("filePath"));
          } else {
            paramDownloadResult.put("tempFilePath", paramMiniAppFileManager.getWxFilePath(paramString2));
          }
          paramDownloadResult.put("header", paramString1);
          paramDownloadResult.put("state", "success");
          paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", paramDownloadResult.toString(), 0);
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append("download failed, filepath not exists, tmpFile:");
          paramString1.append(paramString4);
          QMLog.d("FileJsPlugin", paramString1.toString());
          this.downloadMap.remove(paramString3);
          paramString1 = new JSONObject();
          paramString1.put("downloadTaskId", paramString3);
          paramString1.put("state", "fail");
          paramString1.put("errMsg", "Download Failed: file not exists or can not read.");
          paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", paramString1.toString(), 0);
        }
      }
    }
    catch (Exception paramString1)
    {
      QMLog.e("FileJsPlugin", "download onDownloadSucceed exception.", paramString1);
      callbackDownloadFailed(paramString3, paramRequestEvent, paramString1);
    }
    reportDownloadFileResult(System.currentTimeMillis() - paramLong, paramInt1);
    MiniProgramLpReportDC05115.reportDownloadResult(this.mMiniAppInfo, 0, System.currentTimeMillis() - paramLong, false);
    MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.mMiniAppInfo, paramString5, System.currentTimeMillis() - paramLong, paramInt1, 0);
  }
  
  private void onEventFinish(String paramString1, boolean paramBoolean, long paramLong1, long paramLong2, String paramString2)
  {
    paramLong1 = paramLong2 - paramLong1;
    paramLong2 = System.currentTimeMillis() - paramLong2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    String str;
    if (paramBoolean) {
      str = " succeed!";
    } else {
      str = " fail!";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" [minigame timecost: waitingTime=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("ms workingTime=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("ms ], filePath:");
    localStringBuilder.append(paramString2);
    QMLog.d("FileJsPlugin", localStringBuilder.toString());
    if (!this.mIsMiniGame) {
      return;
    }
    if (shouldReport < 0)
    {
      int i;
      if (new Random(System.currentTimeMillis()).nextInt(100) < 10) {
        i = 1;
      } else {
        i = 0;
      }
      shouldReport = i;
    }
    if (shouldReport == 0) {
      return;
    }
    ThreadManager.executeOnComputationThreadPool(new FileJsPlugin.19(this, paramString1, paramBoolean, paramLong1, paramLong2));
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
    String str;
    if (this.mIsMiniGame) {
      str = "1";
    } else {
      str = "0";
    }
    MiniReportManager.reportEventType(this.mMiniAppInfo, 640, null, null, null, paramInt, str, paramLong, null);
  }
  
  @NotNull
  private File retryCopyFile(String paramString1, String paramString2, File paramFile)
  {
    Object localObject1 = paramFile;
    Object localObject2;
    if (!paramFile.exists())
    {
      localObject1 = paramFile;
      if (!TextUtils.isEmpty(paramString1))
      {
        try
        {
          File localFile = new File(paramString1);
          localObject1 = paramFile;
          if (!localFile.exists()) {
            break label276;
          }
          localObject1 = paramFile;
          if (!localFile.isFile()) {
            break label276;
          }
          localObject1 = paramFile;
          if (localFile.length() <= 0L) {
            break label276;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("download Succeed but target file not exists, try copy from download tmp file:");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(", length:");
          ((StringBuilder)localObject1).append(localFile.length());
          ((StringBuilder)localObject1).append(", to:");
          ((StringBuilder)localObject1).append(paramString2);
          QMLog.w("FileJsPlugin", ((StringBuilder)localObject1).toString());
          paramString2 = FileUtils.createFile(paramString2);
          try
          {
            if ((FileUtils.copyFile(localFile, paramString2)) && (paramString2.exists()) && (paramString2.length() == localFile.length()))
            {
              paramFile = new StringBuilder();
              paramFile.append("copy from download tmp file:");
              paramFile.append(paramString1);
              paramFile.append(" success");
              QMLog.i("FileJsPlugin", paramFile.toString());
            }
            else if (paramString2.exists())
            {
              paramString2.delete();
            }
            return paramString2;
          }
          catch (Throwable localThrowable)
          {
            paramFile = paramString2;
            paramString2 = localThrowable;
          }
          localObject2 = new StringBuilder();
        }
        catch (Throwable paramString2) {}
        ((StringBuilder)localObject2).append("try copy from download tmp file exception! tmp file:");
        ((StringBuilder)localObject2).append(paramString1);
        QMLog.e("FileJsPlugin", ((StringBuilder)localObject2).toString(), paramString2);
        localObject2 = paramFile;
      }
    }
    label276:
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
        if (!writeUsrFile(paramArrayOfByte, paramString2, paramString3, str, false))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("writeFile failed! path:");
          localStringBuilder.append(str);
          localStringBuilder.append(",encoding:");
          localStringBuilder.append(paramString3);
          localStringBuilder.append(",nativeBufferBytes:");
          if (paramArrayOfByte == null) {
            break label289;
          }
          paramString1 = Integer.valueOf(paramArrayOfByte.length);
          localStringBuilder.append(paramString1);
          localStringBuilder.append(",data:");
          if (paramString2 == null) {
            break label296;
          }
          paramString1 = Integer.valueOf(paramString2.length());
          localStringBuilder.append(paramString1);
          QMLog.e("FileJsPlugin", localStringBuilder.toString());
          onEventFinish(paramRequestEvent.event, false, paramLong2, paramLong1, str);
          paramString1 = new StringBuilder();
          paramString1.append("failed to  write file");
          paramString1.append(str);
          paramString1 = handleCallbackFail(paramRequestEvent, null, paramString1.toString());
          return paramString1;
        }
        onEventFinish(paramRequestEvent.event, true, paramLong2, paramLong1, str);
        return handleCallbackOK(paramRequestEvent, null);
      }
      catch (IOException paramString1)
      {
        onEventFinish(paramRequestEvent.event, false, paramLong2, paramLong1, str);
        return handleCallbackFail(paramRequestEvent, null, paramString1.getMessage());
      }
      onEventFinish(paramRequestEvent.event, false, paramLong2, paramLong1, str);
      return handleCallbackFail(paramRequestEvent, null, "the maximum size of the file storage is exceeded");
      label289:
      paramString1 = "0";
      continue;
      label296:
      paramString1 = "null";
    }
  }
  
  private boolean writeUsrFile(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    long l2;
    if (paramArrayOfByte != null)
    {
      checkUsrFileSize(paramArrayOfByte.length);
      l1 = FileUtils.getFileSizes(paramString3);
      paramBoolean = FileUtils.writeFile(paramString3, paramArrayOfByte, paramBoolean);
      if (paramBoolean)
      {
        l2 = FileUtils.getFileSizes(paramString3);
        this.fileManager.updateFolderSize(2, l2 - l1);
      }
      return paramBoolean;
    }
    if ("base64".equals(paramString2)) {
      paramArrayOfByte = Base64.decode(paramString1, 2);
    } else if ("hex".equals(paramString2)) {
      paramArrayOfByte = StringUtil.hexStr2Bytes(paramString1);
    } else {
      paramArrayOfByte = paramString1.getBytes();
    }
    if ((!paramString2.equals("binary")) && (!paramString2.equals("hex")) && (!paramString2.equals("base64")))
    {
      paramArrayOfByte = Charset.forName(paramString2).encode(new String(paramArrayOfByte, Charset.forName("utf8")));
      paramString1 = paramArrayOfByte.array();
      checkUsrFileSize(paramArrayOfByte.limit());
      l1 = FileUtils.getFileSizes(paramString3);
      paramBoolean = FileUtils.writeFile(paramString3, paramString1, paramBoolean, paramArrayOfByte.limit());
      if (paramBoolean)
      {
        l2 = FileUtils.getFileSizes(paramString3);
        this.fileManager.updateFolderSize(2, l2 - l1);
      }
      return paramBoolean;
    }
    checkUsrFileSize(paramArrayOfByte.length);
    long l1 = FileUtils.getFileSizes(paramString3);
    paramBoolean = FileUtils.writeFile(paramString3, paramArrayOfByte, paramBoolean);
    if (paramBoolean)
    {
      l2 = FileUtils.getFileSizes(paramString3);
      this.fileManager.updateFolderSize(2, l2 - l1);
    }
    return paramBoolean;
  }
  
  @JsEvent({"access", "accessSync"})
  public String access(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    return execFileTask(paramRequestEvent.event, new FileJsPlugin.5(this, paramRequestEvent, l));
  }
  
  @JsEvent({"fs_appendFile", "fs_appendFileSync"})
  public String appendFile(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        localObject = new JSONObjectFix(paramRequestEvent.jsonParams);
        String str1 = ((JSONObject)localObject).optString("filePath");
        String str2 = ((JSONObject)localObject).optString("data");
        String str3 = ((JSONObject)localObject).optString("encoding", "utf8");
        localObject = NativeBuffer.unpackNativeBuffer(paramRequestEvent.jsService, (JSONObject)localObject, "data");
        if (localObject != null)
        {
          localObject = ((NativeBuffer)localObject).buf;
          paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.6(this, str3, paramRequestEvent, l, str1, str2, (byte[])localObject));
          return paramRequestEvent;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return "{}";
      }
      Object localObject = null;
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
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.8(this, str, paramRequestEvent, l, (String)localObject));
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
    for (;;)
    {
      Object localObject4;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(localJSONObject);
        String str2 = String.valueOf(this.downloadTaskId.getAndIncrement());
        localObject4 = localJSONObject.optString("url");
        if (localJSONObject.has("origin_url"))
        {
          Object localObject1 = localJSONObject.optString("origin_url");
          boolean bool1 = localJSONObject.optBoolean("__skipDomainCheck__", false);
          Object localObject5 = localJSONObject.optJSONObject("header");
          MiniAppFileManager localMiniAppFileManager = (MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class);
          String str1 = localMiniAppFileManager.getUsrPath(localJSONObject.optString("filePath"));
          boolean bool2 = TextUtils.isEmpty((CharSequence)localObject4);
          if (bool2)
          {
            QMLog.e("FileJsPlugin", "download url is null");
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "download url is null.").toString();
          }
          MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
          int i = 2;
          if (!DomainUtil.isDomainValid(localMiniAppInfo, bool1, (String)localObject1, 2))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("download url Domain not configured.");
            ((StringBuilder)localObject4).append((String)localObject1);
            QMLog.e("FileJsPlugin", ((StringBuilder)localObject4).toString());
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "Domain not configured.").toString();
          }
          if (TextUtils.isEmpty(str1)) {
            i = 0;
          }
          if (TextUtils.isEmpty(str1)) {
            localObject1 = localMiniAppFileManager.getTmpPathByUrl((String)localObject4);
          } else {
            localObject1 = str1;
          }
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject4 = getDownloadUrl((String)localObject4);
              this.downloadMap.put(str2, localObject4);
              localObject5 = StringUtil.json2map((JSONObject)localObject5);
              ((Map)localObject5).put("Referer", getRequestReferer());
              doDownload(paramRequestEvent, localJSONObject, str2, localMiniAppFileManager, str1, i, (String)localObject1, (Map)localObject5, (String)localObject4);
            }
            else
            {
              QMLog.d("FileJsPlugin", "download failed, savepath is null.");
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("downloadTaskId", str2);
              ((JSONObject)localObject1).put("state", "fail");
              ((JSONObject)localObject1).put("errMsg", "Download Failed, savepath is null");
              paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", ((JSONObject)localObject1).toString(), 0);
            }
          }
          catch (Exception localException)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("download failed.");
            ((StringBuilder)localObject4).append(localException);
            QMLog.e("FileJsPlugin", ((StringBuilder)localObject4).toString());
          }
          try
          {
            Object localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("downloadTaskId", str2);
            localObject2 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject2).toString();
            return localObject2;
          }
          catch (Throwable localThrowable)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramRequestEvent.event);
            ((StringBuilder)localObject4).append(" return error.");
            QMLog.e("FileJsPlugin", ((StringBuilder)localObject4).toString(), localThrowable);
          }
          return "";
        }
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
      }
      Object localObject3 = localObject4;
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
    for (;;)
    {
      Object localObject3;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(localJSONObject);
        localObject3 = localJSONObject.optString("url");
        if (localJSONObject.has("origin_url"))
        {
          Object localObject1 = localJSONObject.optString("origin_url");
          boolean bool1 = localJSONObject.optBoolean("__skipDomainCheck__", false);
          String str3 = localJSONObject.optString("filePath");
          String str1 = localJSONObject.optString("name");
          String str2 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str3);
          File localFile = new File(str2);
          boolean bool2 = TextUtils.isEmpty((CharSequence)localObject3);
          if (bool2)
          {
            QMLog.w("FileJsPlugin", "upload url is empty.");
            paramRequestEvent = paramRequestEvent.event;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(":upload url is empty : ");
            ((StringBuilder)localObject1).append((String)localObject3);
            return ApiUtil.wrapCallbackFail(paramRequestEvent, null, ((StringBuilder)localObject1).toString()).toString();
          }
          if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool1, (String)localObject1, 3))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("check upload DomainValid fail, callbackFail, event:");
            ((StringBuilder)localObject1).append(paramRequestEvent.event);
            ((StringBuilder)localObject1).append(", callbackId:");
            ((StringBuilder)localObject1).append(paramRequestEvent.callbackId);
            ((StringBuilder)localObject1).append(", url:");
            ((StringBuilder)localObject1).append((String)localObject3);
            QMLog.w("FileJsPlugin", ((StringBuilder)localObject1).toString());
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "url not in domain list, 请求域名不合法").toString();
          }
          if (TextUtils.isEmpty(str2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("upload file error. ");
            ((StringBuilder)localObject1).append(str2);
            QMLog.w("FileJsPlugin", ((StringBuilder)localObject1).toString());
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, ":file doesn't exist").toString();
          }
          if (TextUtils.isEmpty(str1))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("upload file name error. ");
            ((StringBuilder)localObject1).append(str1);
            QMLog.w("FileJsPlugin", ((StringBuilder)localObject1).toString());
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, ":file name is error").toString();
          }
          int i = doUpload(paramRequestEvent, l, localJSONObject, (String)localObject3, str3, str1, str2, localFile);
          this.uploadMap.put(Integer.valueOf(i), localObject3);
          try
          {
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("uploadTaskId", i);
            localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject1).toString();
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramRequestEvent.event);
            ((StringBuilder)localObject3).append(" return error.");
            QMLog.e("FileJsPlugin", ((StringBuilder)localObject3).toString(), localThrowable);
          }
          return "";
        }
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
      }
      Object localObject2 = localObject3;
    }
  }
  
  public void doDownload(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString1, MiniAppFileManager paramMiniAppFileManager, String paramString2, int paramInt, String paramString3, Map paramMap, String paramString4)
  {
    ThreadManager.executeOnNetworkIOThreadPool(new FileJsPlugin.3(this, paramString1, paramRequestEvent, System.currentTimeMillis(), paramString4, paramString3, paramMiniAppFileManager, paramInt, paramJSONObject, paramString2, paramMap));
  }
  
  public String getDownloadUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = paramString.indexOf("?");
    Object localObject = paramString;
    if (i != -1)
    {
      String str = paramString.substring(0, i);
      localObject = paramString.substring(i, paramString.length());
      paramString = (String)localObject;
      if (((String)localObject).contains("|")) {
        paramString = ((String)localObject).replace("|", "%7C");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return ((String)localObject).replace(" ", "%20");
  }
  
  @JsEvent({"getFileInfo"})
  public void getFileInfo(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        localObject2 = ((JSONObject)localObject1).optString("filePath");
        localObject1 = ((JSONObject)localObject1).optString("digestAlgorithm", "md5");
        str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject2);
        bool = "md5".equals(localObject1);
        if (bool) {
          break label310;
        }
        if (!"sha1".equals(localObject1)) {
          break label305;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        Object localObject1;
        Object localObject2;
        String str;
        boolean bool;
        File localFile;
        JSONObject localJSONObject;
        paramRequestEvent.printStackTrace();
        return;
      }
      bool = TextUtils.isEmpty(str);
      localObject2 = null;
      if ((!bool) && (i != 0))
      {
        localFile = new File(str);
        localJSONObject = new JSONObject();
        try
        {
          if ("sha1".equals(localObject1)) {
            localObject1 = SecurityUtil.getFileSHA1(str);
          } else {
            localObject1 = MD5Utils.encodeFileHexStr(str);
          }
          if (localObject1 != null) {
            localObject2 = ((String)localObject1).toLowerCase();
          }
          localJSONObject.put("digest", localObject2);
          localJSONObject.put("size", localFile.length());
          onEventFinish(paramRequestEvent.event, true, l, l, str);
          paramRequestEvent.ok(localJSONObject);
          return;
        }
        catch (Throwable localThrowable)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getFileInfo exception:");
          ((StringBuilder)localObject2).append(localThrowable.getMessage());
          QMLog.e("FileJsPlugin", ((StringBuilder)localObject2).toString());
          onEventFinish(paramRequestEvent.event, false, l, l, str);
          paramRequestEvent.fail();
          return;
        }
      }
      onEventFinish(paramRequestEvent.event, false, l, l, str);
      paramRequestEvent.fail(null, "invalid data");
      return;
      label305:
      int i = 0;
      continue;
      label310:
      i = 1;
    }
  }
  
  @JsEvent({"getSavedFileInfo"})
  public String getSavedFileInfo(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams).optString("filePath");
      Object localObject2 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject1);
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
      if (!bool)
      {
        File localFile = new File((String)localObject2);
        if (localFile.exists())
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("size", localFile.length());
            ((JSONObject)localObject1).put("createTime", localFile.lastModified() / 1000L);
            onEventFinish(paramRequestEvent.event, true, l, l, (String)localObject2);
            paramRequestEvent.ok((JSONObject)localObject1);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            onEventFinish(paramRequestEvent.event, false, l, l, (String)localObject2);
            paramRequestEvent.fail();
          }
        }
        else
        {
          onEventFinish(paramRequestEvent.event, false, l, l, (String)localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("no such file");
          ((StringBuilder)localObject2).append(localThrowable);
          paramRequestEvent.fail(null, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        onEventFinish(paramRequestEvent.event, false, l, l, localThrowable);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("no such file");
        ((StringBuilder)localObject2).append(localThrowable);
        paramRequestEvent.fail(null, ((StringBuilder)localObject2).toString());
      }
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
  }
  
  @JsEvent({"getSavedFileList"})
  public String getSavedFileList(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getSaveFileList();
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 == null) || (!localObject2.exists()) || (!localObject2.isFile())) {
              break label223;
            }
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("filePath", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(localObject2.getAbsolutePath()));
            localJSONObject.put("size", localObject2.length());
            localJSONObject.put("createTime", localObject2.lastModified() / 1000L);
            localJSONArray.put(localJSONObject);
            break label223;
          }
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("fileList", localJSONArray);
        paramRequestEvent.ok((JSONObject)localObject1);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        paramRequestEvent.fail();
      }
      onEventFinish(paramRequestEvent.event, true, l, l, "");
      return "";
      label223:
      i += 1;
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
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.9(this, str, localJSONObject, paramRequestEvent, l));
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
      paramIMiniAppContext = this.mMiniAppInfo;
      String str = SDKMiniProgramLpReportDC04239.getAppType(this.mMiniAppInfo);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mMiniAppInfo.usrFileSizeLimit);
      localStringBuilder.append("");
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramIMiniAppContext, str, null, "buffer_space", "", "", localStringBuilder.toString());
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
        break label106;
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
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
  }
  
  @JsEvent({"readFile", "readFileSync"})
  public String readFile(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObjectFix(paramRequestEvent.jsonParams);
        String str = ((JSONObjectFix)localObject).optString("filePath");
        localObject = ((JSONObjectFix)localObject).optString("encoding", "__internal__array_buffer");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = "__internal__array_buffer";
          paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.10(this, str, paramRequestEvent, l, (String)localObject));
          return paramRequestEvent;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return "{}";
      }
    }
  }
  
  @JsEvent({"readdir", "readdirSync"})
  public String readdir(RequestEvent paramRequestEvent)
  {
    long l = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("dirPath");
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.11(this, str, localJSONObject, paramRequestEvent, l));
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
    long l1 = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("filePath");
      if ((!TextUtils.isEmpty(str)) && (!((JSONObject)localObject).isNull("filePath")))
      {
        int i = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(str);
        if (i == 1)
        {
          localObject = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
          if (FileUtils.fileExists((String)localObject))
          {
            long l2 = FileUtils.delete((String)localObject, false);
            this.fileManager.updateFolderSize(1, -l2);
            onEventFinish(paramRequestEvent.event, true, l1, l1, (String)localObject);
            paramRequestEvent.ok();
          }
          else
          {
            onEventFinish(paramRequestEvent.event, false, l1, l1, (String)localObject);
            paramRequestEvent.fail(null, "not a store filePath");
          }
        }
        else
        {
          onEventFinish(paramRequestEvent.event, false, l1, l1, str);
          paramRequestEvent.fail(null, "not a store filePath");
        }
      }
      else
      {
        onEventFinish(paramRequestEvent.event, false, l1, l1, str);
        paramRequestEvent = handleCallbackFail(paramRequestEvent, null, "fail parameter error: parameter.dirPath should be String instead of Null;");
        return paramRequestEvent;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
    return "";
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
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.12(this, str, paramRequestEvent, l, (String)localObject));
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
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.13(this, str, localJSONObject, paramRequestEvent, l, bool));
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
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.7(this, str, paramRequestEvent, l, (String)localObject));
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
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.14(this, str, paramRequestEvent, l, bool));
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
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.15(this, str, paramRequestEvent, l));
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
      paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.16(this, str, paramRequestEvent, l, (String)localObject));
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
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramRequestEvent.jsonParams);
        String str2 = ((JSONObject)localObject).optString("filePath");
        String str1;
        if (((JSONObject)localObject).isNull("data")) {
          str1 = null;
        } else {
          str1 = ((JSONObject)localObject).optString("data");
        }
        String str3 = ((JSONObject)localObject).optString("encoding", "utf8");
        localObject = NativeBuffer.unpackNativeBuffer(paramRequestEvent.jsService, (JSONObject)localObject, "data");
        if (localObject != null)
        {
          localObject = ((NativeBuffer)localObject).buf;
          paramRequestEvent = execFileTask(paramRequestEvent.event, new FileJsPlugin.17(this, str1, (byte[])localObject, paramRequestEvent, l, str2, str3));
          return paramRequestEvent;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return "";
      }
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin
 * JD-Core Version:    0.7.0.1
 */