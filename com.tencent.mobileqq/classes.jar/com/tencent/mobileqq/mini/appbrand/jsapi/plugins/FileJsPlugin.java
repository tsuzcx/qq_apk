package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import anzj;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.app.PreCacheManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.network.RequestStrategy;
import com.tencent.mobileqq.mini.network.http.MiniappHttpUtil;
import com.tencent.mobileqq.mini.network.http.MiniappHttpUtil.UploadTask;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONObjectFix;
import com.tencent.mobileqq.mini.util.StringUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.MiniGameStorageExceedManager;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class FileJsPlugin
  extends BaseJsPlugin
{
  private static final String API_ACCESS = "access";
  private static final String API_ACCESS_SYNC = "accessSync";
  private static final String API_APPEND = "fs_appendFile";
  private static final String API_APPEND_SYNC = "fs_appendFileSync";
  private static final String API_COPY_FILE = "fs_copyFile";
  private static final String API_COPY_FILE_SYNC = "fs_copyFileSync";
  private static final String API_CREATE_DOWNLOAD_TASK = "createDownloadTask";
  private static final String API_CREATE_UPLOAD_TASK = "createUploadTask";
  private static final String API_CTREATE_FILE_SYSTEM = "createFileSystemInstance";
  private static final String API_GET_FILE_INFO = "getFileInfo";
  private static final String API_GET_SAVE_FILE_INFO = "getSavedFileInfo";
  private static final String API_GET_SAVE_FILE_LIST = "getSavedFileList";
  private static final String API_MKDIR = "mkdir";
  private static final String API_MKDIR_SYNC = "mkdirSync";
  private static final String API_OPEN_DOCUMENT = "openDocument";
  private static final String API_OPERATE_DOWNLOAD_TASK = "operateDownloadTask";
  private static final String API_OPERATE_UPLOAD_TASK = "operateUploadTask";
  private static final String API_READDIR = "readdir";
  private static final String API_READDIR_SYNC = "readdirSync";
  private static final String API_READ_FILE = "readFile";
  private static final String API_READ_FILE_SYNC = "readFileSync";
  private static final String API_REMOVE_SAVE_FILE = "removeSavedFile";
  private static final String API_RENAME = "fs_rename";
  private static final String API_RENAME_SYNC = "fs_renameSync";
  private static final String API_RMDIR = "rmdir";
  private static final String API_RMDIR_SYNC = "rmdirSync";
  private static final String API_SAVE_FILE = "saveFile";
  private static final String API_SAVE_FILE_SYNC = "saveFileSync";
  private static final String API_STAT = "stat";
  private static final String API_STAT_SYNC = "statSync";
  private static final String API_UNLINK = "unlink";
  private static final String API_UNLINK_SYNC = "unlinkSync";
  private static final String API_UNZIP = "unzip";
  private static final String API_WRITE_FILE = "writeFile";
  private static final String API_WRITE_FILE_SYNC = "writeFileSync";
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
  public static final String EVENT_DOWNLOAD_TASK_STATE_CHANGE = "onDownloadTaskStateChange";
  private static final String PRIVATE_API_DOWNLOAD_WITH_CACHE = "downloadWithCache";
  private static final Set<String> S_EVENT_MAP = new FileJsPlugin.1();
  private static final String TAG = "[mini] FileJsPlugin";
  private static Set<String> sSupportEncodingRead = new FileJsPlugin.2();
  private static int shouldReport = -1;
  public int curPreloadTaskId;
  private ConcurrentHashMap<String, String> downloadMap = new ConcurrentHashMap();
  private AtomicInteger downloadTaskId = new AtomicInteger(0);
  private ConcurrentHashMap<Integer, MiniappHttpUtil.UploadTask> uploadMap = new ConcurrentHashMap();
  
  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void checkUsrFileSize(@NonNull String paramString, int paramInt)
  {
    if (!MiniAppFileManager.getInstance().isFolderCanWrite(2, paramInt)) {
      throw new IOException("the maximum size of the file storage is exceeded");
    }
  }
  
  private String doDownloadWithCache(String paramString, int paramInt, JsRuntime paramJsRuntime, JSONObject paramJSONObject)
  {
    return execFileTask(paramString, new FileJsPlugin.20(this, paramJSONObject, paramString, paramJsRuntime, paramInt));
  }
  
  private String execFileTask(String paramString, FileJsPlugin.FileTask paramFileTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramFileTask.run();
    }
    ThreadPools.getDiskIOThreadPool().execute(new FileJsPlugin.21(this, paramFileTask));
    return "";
  }
  
  private String getDownloadUrl(String paramString)
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
  
  private String handleCallbackFail(JsRuntime paramJsRuntime, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    if (!paramString1.endsWith("Sync"))
    {
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, paramJSONObject, paramString2, paramInt);
      return "";
    }
    return ApiUtil.wrapCallbackFail(paramString1, paramJSONObject, paramString2).toString();
  }
  
  private String handleCallbackOK(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (!paramString.endsWith("Sync"))
    {
      this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString, paramJSONObject, paramInt);
      return "";
    }
    return ApiUtil.wrapCallbackOk(paramString, paramJSONObject).toString();
  }
  
  public static byte hexToByte(String paramString)
  {
    return (byte)Integer.parseInt(paramString, 16);
  }
  
  public static byte[] hexToByteArray(String paramString)
  {
    int j = 0;
    int i = paramString.length();
    byte[] arrayOfByte;
    if (i % 2 == 1)
    {
      i += 1;
      arrayOfByte = new byte[i / 2];
      paramString = "0" + paramString;
    }
    for (;;)
    {
      int k = 0;
      while (j < i)
      {
        arrayOfByte[k] = hexToByte(paramString.substring(j, j + 2));
        k += 1;
        j += 2;
      }
      arrayOfByte = new byte[i / 2];
    }
    return arrayOfByte;
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
      QLog.e("[mini] FileJsPlugin", 1, "isEncodingSupport exception,e:" + paramString.getMessage(), paramString);
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
      QLog.d("[mini] FileJsPlugin", 1, str + " [minigame timecost: waitingTime=" + paramLong1 + "ms workingTime=" + paramLong2 + "ms ], filePath:" + paramString2);
      if (isMiniGameRuntime()) {
        break;
      }
      return;
    }
    if (shouldReport < 0) {
      if (new Random(System.currentTimeMillis()).nextInt(100) >= 10) {
        break label161;
      }
    }
    label161:
    for (int i = 1;; i = 0)
    {
      shouldReport = i;
      if (shouldReport == 0) {
        break;
      }
      ThreadPools.getComputationThreadPool().execute(new FileJsPlugin.22(this, paramString1, paramBoolean, paramLong1, paramLong2));
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
      return StringUtil.toHexString(paramString2);
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
      QLog.e("[mini] FileJsPlugin", 2, "read file err", paramString1);
    }
    return null;
  }
  
  private void reportDownloadWithCache(long paramLong, int paramInt, String paramString)
  {
    MiniAppConfig localMiniAppConfig = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
    if (isMiniGameRuntime()) {}
    for (String str = "1";; str = "0")
    {
      MiniReportManager.reportEventType(localMiniAppConfig, 1044, null, null, null, paramInt, str, paramLong, paramString);
      return;
    }
  }
  
  private boolean writeUsrFile(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    long l1;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      checkUsrFileSize(paramString3, paramArrayOfByte.length);
      l1 = FileUtils.getFileSizes(paramString3);
      bool = FileUtils.writeFile(paramArrayOfByte, paramString3, paramBoolean);
      paramBoolean = bool;
      if (bool)
      {
        l2 = FileUtils.getFileSizes(paramString3);
        MiniAppFileManager.getInstance().updateFolderSize(2, l2 - l1);
        paramBoolean = bool;
      }
    }
    label192:
    do
    {
      return paramBoolean;
      if ("base64".equals(paramString2)) {
        paramArrayOfByte = Base64.decode(paramString1, 2);
      }
      for (;;)
      {
        if ((!paramString2.equals("binary")) && (!paramString2.equals("hex")) && (!paramString2.equals("base64"))) {
          break label192;
        }
        checkUsrFileSize(paramString3, paramArrayOfByte.length);
        l1 = FileUtils.getFileSizes(paramString3);
        bool = FileUtils.writeFile(paramArrayOfByte, paramString3, paramBoolean);
        paramBoolean = bool;
        if (!bool) {
          break;
        }
        l2 = FileUtils.getFileSizes(paramString3);
        MiniAppFileManager.getInstance().updateFolderSize(2, l2 - l1);
        return bool;
        if ("hex".equals(paramString2)) {
          paramArrayOfByte = StringUtil.hexStr2Bytes(paramString1);
        } else {
          paramArrayOfByte = paramString1.getBytes();
        }
      }
      paramArrayOfByte = Charset.forName(paramString2).encode(new String(paramArrayOfByte, Charset.forName("utf8")));
      paramString1 = paramArrayOfByte.array();
      checkUsrFileSize(paramString3, paramArrayOfByte.limit());
      l1 = FileUtils.getFileSizes(paramString3);
      bool = FileUtils.writeFile(paramString1, paramString3, paramBoolean, paramArrayOfByte.limit());
      paramBoolean = bool;
    } while (!bool);
    long l2 = FileUtils.getFileSizes(paramString3);
    MiniAppFileManager.getInstance().updateFolderSize(2, l2 - l1);
    return bool;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1;
    try
    {
      JSONObjectFix localJSONObjectFix = new JSONObjectFix(paramString2);
      if ("createFileSystemInstance".equals(paramString1)) {
        return "{}";
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        localObject1 = new JSONObjectFix();
      }
    }
    Object localObject8;
    Object localObject10;
    boolean bool;
    Object localObject9;
    Object localObject7;
    int i;
    Object localObject5;
    if ("createDownloadTask".equals(paramString1))
    {
      RequestStrategy.g.addHttpForwardingInfo((JSONObject)localObject1);
      localObject8 = String.valueOf(this.downloadTaskId.getAndIncrement());
      localObject10 = ((JSONObject)localObject1).optString("url");
      bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
      localObject9 = ((JSONObject)localObject1).optJSONObject("header");
      localObject7 = MiniAppFileManager.getInstance().getUsrPath(((JSONObject)localObject1).optString("filePath"));
      if (TextUtils.isEmpty((CharSequence)localObject10))
      {
        QLog.e("[mini] FileJsPlugin", 1, "download url is null");
        return ApiUtil.wrapCallbackFail(paramString1, null, "download url is null.").toString();
      }
      if (!this.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool, (String)localObject10, 2))
      {
        QLog.e("[mini] FileJsPlugin", 1, "download url Domain not configured." + (String)localObject10);
        return ApiUtil.wrapCallbackFail(paramString1, null, "Domain not configured.").toString();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject10))
      {
        if (TextUtils.isEmpty((CharSequence)localObject7)) {
          i = 0;
        }
        for (;;)
        {
          localObject5 = localObject7;
          if (TextUtils.isEmpty((CharSequence)localObject7)) {
            localObject5 = MiniAppFileManager.getInstance().getTmpPathByUrl((String)localObject10);
          }
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject5))
            {
              localObject7 = getDownloadUrl((String)localObject10);
              this.downloadMap.put(localObject8, localObject7);
              localObject1 = new FileJsPlugin.3(this, l1, (String)localObject8, paramJsRuntime, (String)localObject5, i, (JSONObject)localObject1);
              localObject10 = PreCacheManager.g().getResourcePreCachePath(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appId, (String)localObject7);
              if ((!TextUtils.isEmpty((CharSequence)localObject10)) && (new File((String)localObject10).exists()))
              {
                localObject5 = new DownloadResult((String)localObject7);
                ((DownloadResult)localObject5).getStatus().setSucceed();
                ((DownloadResult)localObject5).setPath((String)localObject10);
                QLog.i("[mini] FileJsPlugin", 1, "[Resource Cache] download hint precache! url=" + (String)localObject7 + " cachePath=" + (String)localObject10);
                ((Downloader.DownloadListener)localObject1).onDownloadSucceed((String)localObject7, (DownloadResult)localObject5);
              }
              for (;;)
              {
                try
                {
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("downloadTaskId", localObject8);
                  localObject1 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject1).toString();
                  return localObject1;
                }
                catch (Throwable localThrowable2)
                {
                  JSONObject localJSONObject1;
                  QLog.e("[mini] FileJsPlugin", 1, paramString1 + " return error.", localThrowable2);
                }
                i = 2;
                break;
                ThreadPools.getNetworkIOThreadPool().execute(new FileJsPlugin.4(this, (String)localObject7, (String)localObject5, (Downloader.DownloadListener)localObject1, (JSONObject)localObject9));
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("[mini] FileJsPlugin", 1, "download failed." + localException);
              continue;
              QLog.e("[mini] FileJsPlugin", 1, new Object[] { "download failed, savepath is null. downloadTaskId:", localObject8, ", url:", localObject10 });
              localJSONObject1 = new JSONObject();
              localJSONObject1.put("downloadTaskId", localObject8);
              localJSONObject1.put("state", "fail");
              localJSONObject1.put("errMsg", "Download Failed, savepath is null");
              paramJsRuntime.evaluateSubcribeJS("onDownloadTaskStateChange", localJSONObject1.toString(), 0);
            }
          }
        }
      }
    }
    long l2;
    label1533:
    Object localObject3;
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      QLog.w("[mini] FileJsPlugin", 1, "check download DomainValid fail, callbackFail, event:" + paramString1 + ", callbackId:" + paramInt + ", url:" + (String)localObject10);
      return ApiUtil.wrapCallbackFail(paramString1, null, "download url error.").toString();
      Object localObject2;
      if ("operateDownloadTask".equals(paramString1))
      {
        localObject5 = localThrowable2.optString("downloadTaskId");
        if ((!"abort".equals(localThrowable2.optString("operationType"))) || (!this.downloadMap.containsKey(localObject5))) {
          continue;
        }
        MiniappDownloadUtil.getInstance().abort((String)this.downloadMap.get(localObject5));
        localObject2 = new JSONObject();
      }
      label1695:
      label1705:
      try
      {
        ((JSONObject)localObject2).put("downloadTaskId", localObject5);
        localObject2 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject2).toString();
        return localObject2;
      }
      catch (Throwable localThrowable6) {}
      if ("createUploadTask".equals(paramString1))
      {
        RequestStrategy.g.addHttpForwardingInfo((JSONObject)localObject2);
        localObject5 = ((JSONObject)localObject2).optString("url");
        bool = ((JSONObject)localObject2).optBoolean("__skipDomainCheck__", false);
        String str2 = ((JSONObject)localObject2).optString("filePath");
        localObject7 = ((JSONObject)localObject2).optString("name");
        localObject8 = MiniAppFileManager.getInstance().getAbsolutePath(str2);
        localObject9 = new File((String)localObject8);
        if (TextUtils.isEmpty((CharSequence)localObject5))
        {
          QLog.w("[mini] FileJsPlugin", 1, "upload url is empty.");
          return ApiUtil.wrapCallbackFail(paramString1, null, ":upload url is empty : " + (String)localObject5).toString();
        }
        if (!this.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool, (String)localObject5, 3))
        {
          QLog.w("[mini] FileJsPlugin", 1, "check upload DomainValid fail, callbackFail, event:" + paramString1 + ", callbackId:" + paramInt + ", url:" + (String)localObject5);
          return ApiUtil.wrapCallbackFail(paramString1, null, anzj.a(2131703418)).toString();
        }
        if (TextUtils.isEmpty((CharSequence)localObject8))
        {
          QLog.w("[mini] FileJsPlugin", 1, "upload file error. " + (String)localObject8);
          return ApiUtil.wrapCallbackFail(paramString1, null, ":file doesn't exist").toString();
        }
        if (TextUtils.isEmpty((CharSequence)localObject7))
        {
          QLog.w("[mini] FileJsPlugin", 1, "upload file name error. " + (String)localObject7);
          return ApiUtil.wrapCallbackFail(paramString1, null, ":file name is error").toString();
        }
        localObject10 = ((JSONObject)localObject2).optJSONObject("header");
        JSONObject localJSONObject2 = ((JSONObject)localObject2).optJSONObject("formData");
        if (TextUtils.isEmpty(str2)) {}
        for (localObject2 = "";; localObject2 = str2.replace(MiniAppGlobal.STR_WXFILE, ""))
        {
          localObject2 = MiniappHttpUtil.httpUpload("POST", (String)localObject5, (String)localObject8, (JSONObject)localObject10, localJSONObject2, (String)localObject7, (String)localObject2, new FileJsPlugin.5(this, paramInt, paramJsRuntime, l1, (File)localObject9));
          this.uploadMap.put(Integer.valueOf(paramInt), localObject2);
          try
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("uploadTaskId", paramInt);
            localObject2 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject2).toString();
            return localObject2;
          }
          catch (Throwable localThrowable3)
          {
            localThrowable3.printStackTrace();
            QLog.e("[mini] FileJsPlugin", 1, paramString1 + " return error.", localThrowable3);
          }
        }
      }
      else if ("operateUploadTask".equals(paramString1))
      {
        i = localThrowable3.optInt("uploadTaskId");
        if (("abort".equals(localThrowable3.optString("operationType"))) && (this.uploadMap.containsKey(Integer.valueOf(i)))) {
          ((MiniappHttpUtil.UploadTask)this.uploadMap.get(Integer.valueOf(i))).abort();
        }
      }
      else
      {
        if (("saveFile".equals(paramString1)) || ("saveFileSync".equals(paramString1))) {
          return execFileTask(paramString1, new FileJsPlugin.6(this, localThrowable3.optString("tempFilePath"), paramString1, l1, paramJsRuntime, paramInt, localThrowable3.optString("filePath")));
        }
        if (("mkdir".equals(paramString1)) || ("mkdirSync".equals(paramString1))) {
          return execFileTask(paramString1, new FileJsPlugin.7(this, localThrowable3.optString("dirPath"), localThrowable3, paramString1, l1, paramJsRuntime, paramInt));
        }
        if ("getFileInfo".equals(paramString1))
        {
          l2 = System.currentTimeMillis();
          localObject7 = localThrowable3.optString("filePath");
          String str1 = localThrowable3.optString("digestAlgorithm", "md5");
          localObject5 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject7);
          if (("md5".equals(str1)) || ("sha1".equals(str1)))
          {
            i = 1;
            if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (i != 0))
            {
              localObject7 = new File((String)localObject5);
              localObject8 = new JSONObject();
            }
          }
          else
          {
            for (;;)
            {
              try
              {
                if (!"sha1".equals(str1)) {
                  break label1695;
                }
                str1 = FileUtils.getFileSHA1((String)localObject5);
                if (str1 == null) {
                  break label1705;
                }
                str1 = str1.toLowerCase();
                ((JSONObject)localObject8).put("digest", str1);
                ((JSONObject)localObject8).put("size", ((File)localObject7).length());
                onEventFinish(paramString1, true, l1, l2, (String)localObject5);
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject8, paramInt);
              }
              catch (Throwable localThrowable4)
              {
                QLog.e("[mini] FileJsPlugin", 1, "getFileInfo exception:", localThrowable4);
                onEventFinish(paramString1, false, l1, l2, (String)localObject5);
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
              }
              break;
              i = 0;
              break label1533;
              localObject3 = FileUtils.encodeFile2HexStr((String)localObject5);
              continue;
              localObject3 = null;
            }
          }
          QLog.e("[mini] FileJsPlugin", 1, "file : " + (String)localObject7 + "; realFilePath : " + (String)localObject5 + "; digestAlgorithm : " + (String)localObject3);
          onEventFinish(paramString1, false, l1, l2, (String)localObject5);
          localObject7 = this.jsPluginEngine;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {}
          for (localObject3 = "path is null";; localObject3 = "invalid digestAlgorithm")
          {
            ((BaseJsPluginEngine)localObject7).callbackJsEventFail(paramJsRuntime, paramString1, null, (String)localObject3, paramInt);
            break;
          }
        }
        if (!"getSavedFileInfo".equals(paramString1)) {
          break;
        }
        l2 = System.currentTimeMillis();
        localObject7 = ((JSONObject)localObject3).optString("filePath");
        localObject3 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject7);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject5 = new File((String)localObject3);
          if (((File)localObject5).exists())
          {
            localObject7 = new JSONObject();
            try
            {
              ((JSONObject)localObject7).put("size", ((File)localObject5).length());
              ((JSONObject)localObject7).put("createTime", ((File)localObject5).lastModified() / 1000L);
              onEventFinish(paramString1, true, l1, l2, (String)localObject3);
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject7, paramInt);
            }
            catch (Throwable localThrowable7)
            {
              QLog.e("[mini] FileJsPlugin", 1, "getSaveFileInfo exception:", localThrowable7);
              onEventFinish(paramString1, false, l1, l2, (String)localObject3);
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            }
          }
          else
          {
            onEventFinish(paramString1, false, l1, l2, (String)localObject7);
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "no such file" + (String)localObject7, paramInt);
          }
        }
        else
        {
          onEventFinish(paramString1, false, l1, l2, (String)localObject7);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "no such file" + (String)localObject7, paramInt);
        }
      }
    }
    Object localObject6;
    if ("getSavedFileList".equals(paramString1))
    {
      l2 = System.currentTimeMillis();
      localObject6 = MiniAppFileManager.getInstance().getSaveFileList();
    }
    for (;;)
    {
      try
      {
        localObject3 = new JSONArray();
        if (localObject6 != null)
        {
          int j = localObject6.length;
          i = 0;
          if (i < j)
          {
            localObject7 = localObject6[i];
            if ((localObject7 == null) || (!((File)localObject7).exists()) || (!((File)localObject7).isFile())) {
              break label3287;
            }
            localObject8 = new JSONObject();
            ((JSONObject)localObject8).put("filePath", MiniAppFileManager.getInstance().getWxFilePath(((File)localObject7).getAbsolutePath()));
            ((JSONObject)localObject8).put("size", ((File)localObject7).length());
            ((JSONObject)localObject8).put("createTime", ((File)localObject7).lastModified() / 1000L);
            ((JSONArray)localObject3).put(localObject8);
            break label3287;
          }
        }
        localObject6 = new JSONObject();
        ((JSONObject)localObject6).put("fileList", localObject3);
        onEventFinish(paramString1, true, l1, l2, "");
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject6, paramInt);
      }
      catch (Throwable localThrowable5)
      {
        QLog.e("[mini] FileJsPlugin", 1, "getSavedFileList exception:", localThrowable5);
        onEventFinish(paramString1, false, l1, l2, "");
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
      }
      break;
      Object localObject4;
      if ("removeSavedFile".equals(paramString1))
      {
        l2 = System.currentTimeMillis();
        localObject6 = localThrowable5.optString("filePath");
        if ((TextUtils.isEmpty((CharSequence)localObject6)) || (localThrowable5.isNull("filePath")))
        {
          onEventFinish(paramString1, false, l1, l2, (String)localObject6);
          return handleCallbackFail(paramJsRuntime, paramString1, null, "fail parameter error: parameter.dirPath should be String instead of Null;", paramInt);
        }
        if (MiniAppFileManager.getInstance().getWxFileType((String)localObject6) == 1)
        {
          localObject4 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject6);
          if (FileUtils.fileExists((String)localObject4))
          {
            long l3 = FileUtils.delete((String)localObject4, false);
            MiniAppFileManager.getInstance().updateFolderSize(1, l3);
            onEventFinish(paramString1, true, l1, l2, (String)localObject4);
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
            break;
          }
          onEventFinish(paramString1, false, l1, l2, (String)localObject4);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "not a store filePath", paramInt);
          break;
        }
        onEventFinish(paramString1, false, l1, l2, (String)localObject6);
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "not a store filePath", paramInt);
        break;
      }
      if ("openDocument".equals(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new FileJsPlugin.8(this, ((JSONObject)localObject4).optString("filePath"), paramJsRuntime, paramString1, paramInt));
        break;
      }
      if (("writeFile".equals(paramString1)) || ("writeFileSync".equals(paramString1)))
      {
        localObject6 = ((JSONObject)localObject4).optString("filePath");
        if (((JSONObject)localObject4).isNull("data"))
        {
          paramString2 = null;
          localObject7 = ((JSONObject)localObject4).optString("encoding", "utf8");
          localObject4 = NativeBuffer.unpackNativeBuffer((JSONObject)localObject4, "data", paramJsRuntime);
          if (localObject4 == null) {
            break label2671;
          }
        }
        label2671:
        for (localObject4 = ((NativeBuffer)localObject4).buf;; localObject4 = null)
        {
          return execFileTask(paramString1, new FileJsPlugin.9(this, paramString2, (byte[])localObject4, paramString1, l1, (String)localObject6, paramJsRuntime, paramInt, (String)localObject7));
          paramString2 = ((JSONObject)localObject4).optString("data");
          break;
        }
      }
      if (("readFile".equals(paramString1)) || ("readFileSync".equals(paramString1)))
      {
        localObject6 = ((JSONObject)localObject4).optString("filePath");
        localObject4 = ((JSONObject)localObject4).optString("encoding", "__internal__array_buffer");
        paramString2 = (String)localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          paramString2 = "__internal__array_buffer";
        }
        return execFileTask(paramString1, new FileJsPlugin.10(this, (String)localObject6, paramString1, l1, paramJsRuntime, paramInt, paramString2));
      }
      if (("access".equals(paramString1)) || ("accessSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.11(this, ((JSONObject)localObject4).optString("path"), paramString1, l1, paramJsRuntime, paramInt));
      }
      if (("unlink".equals(paramString1)) || ("unlinkSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.12(this, ((JSONObject)localObject4).optString("filePath"), paramString1, l1, paramJsRuntime, paramInt));
      }
      if (("readdir".equals(paramString1)) || ("readdirSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.13(this, ((JSONObject)localObject4).optString("dirPath"), (JSONObject)localObject4, paramString1, l1, paramJsRuntime, paramInt));
      }
      if (("fs_copyFile".equals(paramString1)) || ("fs_copyFileSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.14(this, ((JSONObject)localObject4).optString("srcPath"), paramString1, l1, paramJsRuntime, paramInt, ((JSONObject)localObject4).optString("destPath")));
      }
      if (("fs_appendFile".equals(paramString1)) || ("fs_appendFileSync".equals(paramString1)))
      {
        localObject6 = ((JSONObject)localObject4).optString("filePath");
        localObject7 = ((JSONObject)localObject4).optString("data");
        localObject8 = ((JSONObject)localObject4).optString("encoding", "utf8");
        paramString2 = NativeBuffer.unpackNativeBuffer((JSONObject)localObject4, "data", paramJsRuntime);
        if (paramString2 != null) {}
        for (paramString2 = paramString2.buf;; paramString2 = null) {
          return execFileTask(paramString1, new FileJsPlugin.15(this, (String)localObject8, paramString1, l1, (String)localObject6, paramJsRuntime, paramInt, (String)localObject7, paramString2));
        }
      }
      if ("unzip".equals(paramString1)) {
        return execFileTask(paramString1, new FileJsPlugin.16(this, ((JSONObject)localObject4).optString("zipFilePath"), paramString1, l1, paramJsRuntime, paramInt, ((JSONObject)localObject4).optString("targetPath")));
      }
      if (("rmdir".equals(paramString1)) || ("rmdirSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.17(this, ((JSONObject)localObject4).optString("dirPath"), (JSONObject)localObject4, paramString1, l1, paramJsRuntime, paramInt, ((JSONObject)localObject4).optBoolean("recursive")));
      }
      if (("fs_rename".equals(paramString1)) || ("fs_renameSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.18(this, ((JSONObject)localObject4).optString("oldPath"), paramString1, l1, paramJsRuntime, paramInt, ((JSONObject)localObject4).optString("newPath")));
      }
      if (("stat".equals(paramString1)) || ("statSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.19(this, ((JSONObject)localObject4).optString("path"), paramString1, l1, paramJsRuntime, paramInt, ((JSONObject)localObject4).optBoolean("recursive")));
      }
      if (!"downloadWithCache".equals(paramString1)) {
        break;
      }
      doDownloadWithCache(paramString1, paramInt, paramJsRuntime, (JSONObject)localObject4);
      break;
      break;
      label3287:
      i += 1;
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    MiniAppFileManager.getInstance().setBaseActivity(paramBaseJsPluginEngine.getActivityContext());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MiniGameStorageExceedManager.resetStorageExceedDialogStatus();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin
 * JD-Core Version:    0.7.0.1
 */