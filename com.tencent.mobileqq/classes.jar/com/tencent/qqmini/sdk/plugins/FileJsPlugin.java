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
    for (;;)
    {
      try
      {
        String str = MimeTypeMap.getFileExtensionFromUrl(paramString);
        if (!TextUtils.isEmpty(str)) {
          break label251;
        }
        paramDownloadResult = (List)paramDownloadResult.headers.get("Content-Type");
        if ((paramDownloadResult == null) || (paramDownloadResult.size() <= 0)) {
          break label253;
        }
        paramDownloadResult = (String)paramDownloadResult.get(0);
        if (TextUtils.isEmpty(paramDownloadResult)) {
          break label251;
        }
        paramDownloadResult = paramDownloadResult.trim().split("/");
        if ((paramDownloadResult.length <= 1) || (!"image".equalsIgnoreCase(paramDownloadResult[0]))) {
          break label251;
        }
        paramDownloadResult = paramDownloadResult[1];
        if ("jpeg".equalsIgnoreCase(paramDownloadResult))
        {
          paramDownloadResult = "jpg";
          if (TextUtils.isEmpty(paramDownloadResult)) {
            break label251;
          }
          paramDownloadResult = paramString + "." + paramDownloadResult;
          if (!FileUtils.copyFile(paramString, paramDownloadResult)) {
            break label251;
          }
          FileUtils.deleteFile(paramString);
          return paramDownloadResult;
        }
        if ("png".equalsIgnoreCase(paramDownloadResult))
        {
          paramDownloadResult = "png";
          continue;
        }
        if ("gif".equalsIgnoreCase(paramDownloadResult))
        {
          paramDownloadResult = "gif";
          continue;
        }
        if ("svg+xml".equalsIgnoreCase(paramDownloadResult))
        {
          paramDownloadResult = "svg";
          continue;
        }
        if ("webp".equalsIgnoreCase(paramDownloadResult))
        {
          paramDownloadResult = "webp";
          continue;
        }
        paramDownloadResult = str;
      }
      catch (Throwable paramDownloadResult)
      {
        QMLog.e("FileJsPlugin", "create file extension failed! " + paramDownloadResult);
        return paramString;
      }
      continue;
      label251:
      return paramString;
      label253:
      paramDownloadResult = "";
    }
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
        JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
        ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(localJSONObject1);
        String str4 = String.valueOf(this.downloadTaskId.getAndIncrement());
        String str2 = localJSONObject1.optString("url");
        if (localJSONObject1.has("origin_url"))
        {
          Object localObject = localJSONObject1.optString("origin_url");
          boolean bool = localJSONObject1.optBoolean("__skipDomainCheck__", false);
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("header");
          MiniAppFileManager localMiniAppFileManager = (MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class);
          String str3 = localMiniAppFileManager.getUsrPath(localJSONObject1.optString("filePath"));
          if (TextUtils.isEmpty(str2))
          {
            QMLog.e("FileJsPlugin", "download url is null");
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "download url is null.").toString();
          }
          if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, (String)localObject, 2))
          {
            QMLog.e("FileJsPlugin", "download url Domain not configured." + (String)localObject);
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "Domain not configured.").toString();
          }
          if (TextUtils.isEmpty(str3))
          {
            if (!TextUtils.isEmpty(str3)) {
              continue;
            }
            localObject = localMiniAppFileManager.getTmpPathByUrl(str2);
          }
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              str2 = getDownloadUrl(str2);
              this.downloadMap.put(str4, str2);
              doDownload(paramRequestEvent, localJSONObject1, str4, localMiniAppFileManager, str3, i, (String)localObject, StringUtil.json2map(localJSONObject2), str2);
            }
            try
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("downloadTaskId", str4);
              localObject = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject).toString();
              return localObject;
            }
            catch (Throwable localThrowable)
            {
              QMLog.e("FileJsPlugin", paramRequestEvent.event + " return error.", localThrowable);
              continue;
            }
            i = 2;
            continue;
            localObject = str3;
            continue;
            QMLog.d("FileJsPlugin", "download failed, savepath is null.");
            localObject = new JSONObject();
            ((JSONObject)localObject).put("downloadTaskId", str4);
            ((JSONObject)localObject).put("state", "fail");
            ((JSONObject)localObject).put("errMsg", "Download Failed, savepath is null");
            paramRequestEvent.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", ((JSONObject)localObject).toString(), 0);
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
      Object localObject3 = new JSONObject(paramRequestEvent.jsonParams);
      ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo((JSONObject)localObject3);
      str2 = ((JSONObject)localObject3).optString("url");
      if (((JSONObject)localObject3).has("origin_url"))
      {
        Object localObject1 = ((JSONObject)localObject3).optString("origin_url");
        boolean bool = ((JSONObject)localObject3).optBoolean("__skipDomainCheck__", false);
        String str5 = ((JSONObject)localObject3).optString("filePath");
        String str3 = ((JSONObject)localObject3).optString("name");
        String str4 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str5);
        File localFile = new File(str4);
        if (TextUtils.isEmpty(str2))
        {
          QMLog.w("FileJsPlugin", "upload url is empty.");
          return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, ":upload url is empty : " + str2).toString();
        }
        if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, (String)localObject1, 3))
        {
          QMLog.w("FileJsPlugin", "check upload DomainValid fail, callbackFail, event:" + paramRequestEvent.event + ", callbackId:" + paramRequestEvent.callbackId + ", url:" + str2);
          return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "url not in domain list, 请求域名不合法").toString();
        }
        if (TextUtils.isEmpty(str4))
        {
          QMLog.w("FileJsPlugin", "upload file error. " + str4);
          return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, ":file doesn't exist").toString();
        }
        if (TextUtils.isEmpty(str3))
        {
          QMLog.w("FileJsPlugin", "upload file name error. " + str3);
          return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, ":file name is error").toString();
        }
        int i = paramRequestEvent.callbackId;
        Object localObject2 = ((JSONObject)localObject3).optJSONObject("header");
        localObject3 = ((JSONObject)localObject3).optJSONObject("formData");
        if (TextUtils.isEmpty(str5)) {}
        for (localObject1 = "";; localObject1 = str5.replace("wxfile://", ""))
        {
          localObject2 = StringUtil.json2map((JSONObject)localObject2);
          localObject3 = StringUtil.json2map((JSONObject)localObject3);
          ((UploaderProxy)ProxyManager.get(UploaderProxy.class)).upload(str2, (Map)localObject2, str4, str3, (String)localObject1, (Map)localObject3, 60, new FileJsPlugin.3(this, i, paramRequestEvent, l, localFile));
          this.uploadMap.put(Integer.valueOf(i), str2);
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
            QMLog.e("FileJsPlugin", paramRequestEvent.event + " return error.", localThrowable);
          }
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
    //   0: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 253	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 618	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   12: invokespecial 654	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: ldc_w 621
    //   22: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 6
    //   27: aload 5
    //   29: ldc_w 841
    //   32: ldc_w 843
    //   35: invokevirtual 631	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 5
    //   40: aload_0
    //   41: getfield 115	com/tencent/qqmini/sdk/plugins/FileJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   44: ldc 230
    //   46: invokeinterface 236 2 0
    //   51: checkcast 230	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   54: aload 6
    //   56: invokevirtual 750	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 6
    //   61: ldc_w 843
    //   64: aload 5
    //   66: invokevirtual 514	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifne +220 -> 289
    //   72: ldc_w 845
    //   75: aload 5
    //   77: invokevirtual 514	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +214 -> 294
    //   83: goto +206 -> 289
    //   86: aload 6
    //   88: invokestatic 358	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +175 -> 266
    //   94: iload_2
    //   95: ifeq +171 -> 266
    //   98: new 504	java/io/File
    //   101: dup
    //   102: aload 6
    //   104: invokespecial 505	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore 7
    //   109: new 253	org/json/JSONObject
    //   112: dup
    //   113: invokespecial 254	org/json/JSONObject:<init>	()V
    //   116: astore 8
    //   118: ldc_w 845
    //   121: aload 5
    //   123: invokevirtual 514	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   126: ifeq +68 -> 194
    //   129: aload 6
    //   131: invokestatic 850	com/tencent/qqmini/sdk/core/utils/SecurityUtil:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 5
    //   136: aload 5
    //   138: ifnull +66 -> 204
    //   141: aload 5
    //   143: invokevirtual 853	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   146: astore 5
    //   148: aload 8
    //   150: ldc_w 855
    //   153: aload 5
    //   155: invokevirtual 265	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   158: pop
    //   159: aload 8
    //   161: ldc_w 856
    //   164: aload 7
    //   166: invokevirtual 858	java/io/File:length	()J
    //   169: invokevirtual 861	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   172: pop
    //   173: aload_0
    //   174: aload_1
    //   175: getfield 426	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   178: iconst_1
    //   179: lload_3
    //   180: lload_3
    //   181: aload 6
    //   183: invokespecial 121	com/tencent/qqmini/sdk/plugins/FileJsPlugin:onEventFinish	(Ljava/lang/String;ZJJLjava/lang/String;)V
    //   186: aload_1
    //   187: aload 8
    //   189: invokevirtual 440	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   192: pop
    //   193: return
    //   194: aload 6
    //   196: invokestatic 866	com/tencent/qqmini/sdk/launcher/utils/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   199: astore 5
    //   201: goto -65 -> 136
    //   204: aconst_null
    //   205: astore 5
    //   207: goto -59 -> 148
    //   210: astore 5
    //   212: ldc 57
    //   214: new 296	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 868
    //   224: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 5
    //   229: invokevirtual 460	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   232: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 313	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: aload_1
    //   243: getfield 426	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   246: iconst_0
    //   247: lload_3
    //   248: lload_3
    //   249: aload 6
    //   251: invokespecial 121	com/tencent/qqmini/sdk/plugins/FileJsPlugin:onEventFinish	(Ljava/lang/String;ZJJLjava/lang/String;)V
    //   254: aload_1
    //   255: invokevirtual 870	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   258: pop
    //   259: return
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 649	org/json/JSONException:printStackTrace	()V
    //   265: return
    //   266: aload_0
    //   267: aload_1
    //   268: getfield 426	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   271: iconst_0
    //   272: lload_3
    //   273: lload_3
    //   274: aload 6
    //   276: invokespecial 121	com/tencent/qqmini/sdk/plugins/FileJsPlugin:onEventFinish	(Ljava/lang/String;ZJJLjava/lang/String;)V
    //   279: aload_1
    //   280: aconst_null
    //   281: ldc_w 872
    //   284: invokevirtual 430	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   287: pop
    //   288: return
    //   289: iconst_1
    //   290: istore_2
    //   291: goto -205 -> 86
    //   294: iconst_0
    //   295: istore_2
    //   296: goto -210 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	FileJsPlugin
    //   0	299	1	paramRequestEvent	RequestEvent
    //   94	202	2	i	int
    //   3	271	3	l	long
    //   15	191	5	localObject	Object
    //   210	18	5	localThrowable	Throwable
    //   25	250	6	str	String
    //   107	58	7	localFile	File
    //   116	72	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   118	136	210	java/lang/Throwable
    //   141	148	210	java/lang/Throwable
    //   148	193	210	java/lang/Throwable
    //   194	201	210	java/lang/Throwable
    //   4	83	260	org/json/JSONException
    //   86	94	260	org/json/JSONException
    //   98	118	260	org/json/JSONException
    //   118	136	260	org/json/JSONException
    //   141	148	260	org/json/JSONException
    //   148	193	260	org/json/JSONException
    //   194	201	260	org/json/JSONException
    //   212	259	260	org/json/JSONException
    //   266	288	260	org/json/JSONException
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
        break label159;
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
        label159:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin
 * JD-Core Version:    0.7.0.1
 */