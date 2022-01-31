package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alud;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOp;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.PreCacheManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.http.MiniappHttpUtil;
import com.tencent.mobileqq.mini.http.MiniappHttpUtil.UploadTask;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONObjectFix;
import com.tencent.mobileqq.mini.util.StringUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.MiniGameStorageExceedManager;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
  private static final Set<String> S_EVENT_MAP = new FileJsPlugin.1();
  private static final String TAG = "[mini] FileJsPlugin";
  private static Set<String> sSupportEncodingRead = new FileJsPlugin.2();
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
  
  private String execFileTask(String paramString, FileJsPlugin.FileTask paramFileTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramFileTask.run();
    }
    TTHandleThread.getInstance().execute_FILE(new FileJsPlugin.19(this, paramFileTask));
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
  
  private Object readFile(String paramString1, String paramString2)
  {
    paramString2 = FileUtils.fileToBytes(new VFSFile(paramString2));
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
  
  private boolean writeUsrFile(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      checkUsrFileSize(paramString3, paramArrayOfByte.length);
      return FileUtils.writeFile(paramArrayOfByte, paramString3, paramBoolean);
    }
    if ("base64".equals(paramString2)) {
      paramArrayOfByte = Base64.decode(paramString1, 2);
    }
    while ((paramString2.equals("binary")) || (paramString2.equals("hex")) || (paramString2.equals("base64")))
    {
      checkUsrFileSize(paramString3, paramArrayOfByte.length);
      return FileUtils.writeFile(paramArrayOfByte, paramString3, paramBoolean);
      if ("hex".equals(paramString2)) {
        paramArrayOfByte = StringUtil.hexStr2Bytes(paramString1);
      } else {
        paramArrayOfByte = paramString1.getBytes();
      }
    }
    paramArrayOfByte = Charset.forName(paramString2).encode(new String(paramArrayOfByte, Charset.forName("utf8")));
    paramString1 = paramArrayOfByte.array();
    checkUsrFileSize(paramString3, paramArrayOfByte.limit());
    return FileUtils.writeFile(paramString1, paramString3, paramBoolean, paramArrayOfByte.limit());
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    Object localObject7 = new WeakReference(paramJsRuntime);
    long l = System.currentTimeMillis();
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
    String str2;
    Object localObject9;
    boolean bool;
    Object localObject8;
    Object localObject6;
    Object localObject5;
    if ("createDownloadTask".equals(paramString1))
    {
      str2 = String.valueOf(this.downloadTaskId.getAndIncrement());
      localObject9 = ((JSONObject)localObject1).optString("url");
      bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
      localObject8 = ((JSONObject)localObject1).optJSONObject("header");
      localObject6 = MiniAppFileManager.getInstance().getUsrPath(((JSONObject)localObject1).optString("filePath"));
      if (TextUtils.isEmpty((CharSequence)localObject9))
      {
        QLog.e("[mini] FileJsPlugin", 1, "download url is null");
        return ApiUtil.wrapCallbackFail(paramString1, null, "download url is null.").toString();
      }
      if (!this.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool, (String)localObject9, 2))
      {
        QLog.e("[mini] FileJsPlugin", 1, "download url Domain not configured." + (String)localObject9);
        return ApiUtil.wrapCallbackFail(paramString1, null, "Domain not configured.").toString();
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject9)) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool, (String)localObject9, 2)))
      {
        localObject5 = localObject6;
        if (TextUtils.isEmpty((CharSequence)localObject6)) {
          localObject5 = MiniAppFileManager.getInstance().getTmpPathByUrl((String)localObject9);
        }
        localObject5 = VFSFileOp.exportExternalPath((String)localObject5, true);
        localObject7 = (JsRuntime)((WeakReference)localObject7).get();
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject5))
          {
            localObject6 = getDownloadUrl((String)localObject9);
            this.downloadMap.put(str2, localObject6);
            localObject1 = new FileJsPlugin.3(this, l, str2, (JsRuntime)localObject7, (String)localObject5, (JSONObject)localObject1);
            localObject7 = PreCacheManager.g().getResourcePreCachePath(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appId, (String)localObject6);
            if ((!TextUtils.isEmpty((CharSequence)localObject7)) && (new File((String)localObject7).exists()))
            {
              localObject5 = new DownloadResult((String)localObject6);
              ((DownloadResult)localObject5).getStatus().setSucceed();
              ((DownloadResult)localObject5).setPath((String)localObject7);
              QLog.i("[mini] FileJsPlugin", 1, "[Resource Cache] download hint precache! url=" + (String)localObject6 + " cachePath=" + (String)localObject7);
              ((Downloader.DownloadListener)localObject1).onDownloadSucceed((String)localObject6, (DownloadResult)localObject5);
            }
            for (;;)
            {
              try
              {
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("downloadTaskId", str2);
                localObject1 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject1).toString();
                return localObject1;
              }
              catch (Throwable localThrowable2)
              {
                JSONObject localJSONObject1;
                QLog.e("[mini] FileJsPlugin", 1, paramString1 + " return error.", localThrowable2);
              }
              MiniappDownloadUtil.getInstance().download((String)localObject6, (String)localObject5, false, (Downloader.DownloadListener)localObject1, Downloader.DownloadMode.StrictMode, (JSONObject)localObject8);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("[mini] FileJsPlugin", 1, "download failed." + localException);
            continue;
            QLog.d("[mini] FileJsPlugin", 1, "download failed, savepath is null.");
            localJSONObject1 = new JSONObject();
            localJSONObject1.put("downloadTaskId", str2);
            localJSONObject1.put("state", "fail");
            localJSONObject1.put("errMsg", "Download Failed, savepath is null");
            ((JsRuntime)localObject7).evaluateSubcribeJS("onDownloadTaskStateChange", localJSONObject1.toString(), 0);
          }
        }
      }
    }
    int i;
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      QLog.w("[mini] FileJsPlugin", 1, "check download DomainValid fail, callbackFail, event:" + paramString1 + ", callbackId:" + paramInt + ", url:" + (String)localObject9);
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
      label1525:
      try
      {
        ((JSONObject)localObject2).put("downloadTaskId", localObject5);
        localObject2 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject2).toString();
        return localObject2;
      }
      catch (Throwable localThrowable7) {}
      if ("createUploadTask".equals(paramString1))
      {
        localObject5 = ((JSONObject)localObject2).optString("url");
        bool = ((JSONObject)localObject2).optBoolean("__skipDomainCheck__", false);
        String str3 = ((JSONObject)localObject2).optString("filePath");
        localObject6 = ((JSONObject)localObject2).optString("name");
        str2 = MiniAppFileManager.getInstance().getAbsolutePath(str3);
        localObject8 = new VFSFile(str2);
        if (TextUtils.isEmpty((CharSequence)localObject5))
        {
          QLog.w("[mini] FileJsPlugin", 1, "upload url is empty.");
          return ApiUtil.wrapCallbackFail(paramString1, null, ":upload url is empty : " + (String)localObject5).toString();
        }
        if (!this.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool, (String)localObject5, 3))
        {
          QLog.w("[mini] FileJsPlugin", 1, "check upload DomainValid fail, callbackFail, event:" + paramString1 + ", callbackId:" + paramInt + ", url:" + (String)localObject5);
          return ApiUtil.wrapCallbackFail(paramString1, null, alud.a(2131704914)).toString();
        }
        if (TextUtils.isEmpty(str2))
        {
          QLog.w("[mini] FileJsPlugin", 1, "upload file error. " + str2);
          return ApiUtil.wrapCallbackFail(paramString1, null, ":file doesn't exist").toString();
        }
        if (TextUtils.isEmpty((CharSequence)localObject6))
        {
          QLog.w("[mini] FileJsPlugin", 1, "upload file name error. " + (String)localObject6);
          return ApiUtil.wrapCallbackFail(paramString1, null, ":file name is error").toString();
        }
        localObject9 = ((JSONObject)localObject2).optJSONObject("header");
        JSONObject localJSONObject2 = ((JSONObject)localObject2).optJSONObject("formData");
        if (TextUtils.isEmpty(str3)) {}
        for (localObject2 = "";; localObject2 = str3.replace(MiniAppGlobal.STR_WXFILE, ""))
        {
          localObject2 = MiniappHttpUtil.httpUpload("POST", (String)localObject5, str2, (JSONObject)localObject9, localJSONObject2, (String)localObject6, (String)localObject2, new FileJsPlugin.4(this, paramInt, paramJsRuntime, l, (WeakReference)localObject7, (VFSFile)localObject8));
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
        localObject5 = (JsRuntime)((WeakReference)localObject7).get();
        i = localThrowable3.optInt("uploadTaskId");
        if (("abort".equals(localThrowable3.optString("operationType"))) && (this.uploadMap.containsKey(Integer.valueOf(i)))) {
          ((MiniappHttpUtil.UploadTask)this.uploadMap.get(Integer.valueOf(i))).abort();
        }
      }
      else
      {
        if (("saveFile".equals(paramString1)) || ("saveFileSync".equals(paramString1))) {
          return execFileTask(paramString1, new FileJsPlugin.5(this, localThrowable3.optString("tempFilePath"), paramJsRuntime, paramString1, paramInt, localThrowable3.optString("filePath"), l));
        }
        if (("mkdir".equals(paramString1)) || ("mkdirSync".equals(paramString1))) {
          return execFileTask(paramString1, new FileJsPlugin.6(this, localThrowable3.optString("dirPath"), localThrowable3, paramJsRuntime, paramString1, paramInt));
        }
        if ("getFileInfo".equals(paramString1))
        {
          localObject5 = localThrowable3.optString("filePath");
          localObject7 = localThrowable3.optString("digestAlgorithm", "md5");
          String str1 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject5);
          if (("md5".equals(localObject7)) || ("sha1".equals(localObject7)))
          {
            i = 1;
            if ((!TextUtils.isEmpty(str1)) && (i != 0))
            {
              localObject5 = new VFSFile(str1);
              localObject6 = new JSONObject();
            }
          }
          else
          {
            for (;;)
            {
              try
              {
                if (!"sha1".equals(localObject7)) {
                  break label1682;
                }
                str1 = FileUtils.getFileSHA1(str1);
                if (str1 == null) {
                  break label1692;
                }
                str1 = str1.toLowerCase();
                ((JSONObject)localObject6).put("digest", str1);
                ((JSONObject)localObject6).put("size", ((VFSFile)localObject5).length());
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject6, paramInt);
              }
              catch (Throwable localThrowable4)
              {
                QLog.e("[mini] FileJsPlugin", 1, "getFileInfo exception:" + localThrowable4.getMessage());
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
              }
              break;
              i = 0;
              break label1525;
              label1682:
              localObject3 = FileUtils.encodeFile2HexStr(localThrowable4);
              continue;
              label1692:
              localObject3 = null;
            }
          }
          QLog.e("[mini] FileJsPlugin", 1, "file : " + (String)localObject5 + "; realFilePath : " + (String)localObject3 + "; digestAlgorithm : " + (String)localObject7);
          localObject5 = this.jsPluginEngine;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {}
          for (localObject3 = "path is null";; localObject3 = "invalid digestAlgorithm")
          {
            ((BaseJsPluginEngine)localObject5).callbackJsEventFail(paramJsRuntime, paramString1, null, (String)localObject3, paramInt);
            break;
          }
        }
        if (!"getSavedFileInfo".equals(paramString1)) {
          break;
        }
        Object localObject3 = ((JSONObject)localObject3).optString("filePath");
        localObject5 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          localObject5 = new VFSFile((String)localObject5);
          if (((VFSFile)localObject5).exists())
          {
            localObject3 = new JSONObject();
            try
            {
              ((JSONObject)localObject3).put("size", ((VFSFile)localObject5).length());
              ((JSONObject)localObject3).put("createTime", ((VFSFile)localObject5).lastModified() / 1000L);
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject3, paramInt);
            }
            catch (Throwable localThrowable5)
            {
              localThrowable5.printStackTrace();
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            }
          }
          else
          {
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "no such file" + localThrowable5, paramInt);
          }
        }
        else
        {
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "no such file" + localThrowable5, paramInt);
        }
      }
    }
    if ("getSavedFileList".equals(paramString1)) {
      localObject5 = MiniAppFileManager.getInstance().getSaveFileList();
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        if (localObject5 != null)
        {
          int j = localObject5.length;
          i = 0;
          if (i < j)
          {
            localObject6 = localObject5[i];
            if ((localObject6 == null) || (!((VFSFile)localObject6).exists()) || (!((VFSFile)localObject6).isFile())) {
              break label3085;
            }
            localObject7 = new JSONObject();
            ((JSONObject)localObject7).put("filePath", MiniAppFileManager.getInstance().getWxFilePath(((VFSFile)localObject6).getAbsolutePath()));
            ((JSONObject)localObject7).put("size", ((VFSFile)localObject6).length());
            ((JSONObject)localObject7).put("createTime", ((VFSFile)localObject6).lastModified() / 1000L);
            localJSONArray.put(localObject7);
            break label3085;
          }
        }
        localObject5 = new JSONObject();
        ((JSONObject)localObject5).put("fileList", localJSONArray);
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject5, paramInt);
      }
      catch (Throwable localThrowable6)
      {
        localThrowable6.printStackTrace();
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
      }
      break;
      Object localObject4;
      if ("removeSavedFile".equals(paramString1))
      {
        localObject5 = localThrowable6.optString("filePath");
        if ((TextUtils.isEmpty((CharSequence)localObject5)) || (localThrowable6.isNull("filePath"))) {
          return handleCallbackFail(paramJsRuntime, paramString1, null, "fail parameter error: parameter.dirPath should be String instead of Null;", paramInt);
        }
        if (MiniAppFileManager.getInstance().getWxFileType((String)localObject5) == 1)
        {
          localObject4 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject5);
          if (FileUtils.fileExists((String)localObject4))
          {
            FileUtils.delete((String)localObject4, false);
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
            break;
          }
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "not a store filePath", paramInt);
          break;
        }
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "not a store filePath", paramInt);
        break;
      }
      if ("openDocument".equals(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new FileJsPlugin.7(this, ((JSONObject)localObject4).optString("filePath"), paramJsRuntime, paramString1, paramInt));
        break;
      }
      if (("writeFile".equals(paramString1)) || ("writeFileSync".equals(paramString1)))
      {
        localObject5 = ((JSONObject)localObject4).optString("filePath");
        if (((JSONObject)localObject4).isNull("data"))
        {
          paramString2 = null;
          localObject6 = ((JSONObject)localObject4).optString("encoding", "utf8");
          localObject4 = NativeBuffer.unpackNativeBuffer((JSONObject)localObject4, "data", (ITNativeBufferPool)this.jsPluginEngine.getNativeBufferPool());
          if (localObject4 == null) {
            break label2495;
          }
        }
        label2495:
        for (localObject4 = ((NativeBuffer)localObject4).buf;; localObject4 = null)
        {
          return execFileTask(paramString1, new FileJsPlugin.8(this, paramString2, (byte[])localObject4, paramJsRuntime, paramString1, paramInt, (String)localObject6, (String)localObject5, l));
          paramString2 = ((JSONObject)localObject4).optString("data");
          break;
        }
      }
      if (("readFile".equals(paramString1)) || ("readFileSync".equals(paramString1)))
      {
        localObject5 = ((JSONObject)localObject4).optString("filePath");
        localObject4 = ((JSONObject)localObject4).optString("encoding", "__internal__array_buffer");
        paramString2 = (String)localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          paramString2 = "__internal__array_buffer";
        }
        return execFileTask(paramString1, new FileJsPlugin.9(this, (String)localObject5, paramJsRuntime, paramString1, paramInt, paramString2, l));
      }
      if (("access".equals(paramString1)) || ("accessSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.10(this, ((JSONObject)localObject4).optString("path"), l, paramJsRuntime, paramString1, paramInt));
      }
      if (("unlink".equals(paramString1)) || ("unlinkSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.11(this, ((JSONObject)localObject4).optString("filePath"), paramJsRuntime, paramString1, paramInt));
      }
      if (("readdir".equals(paramString1)) || ("readdirSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.12(this, ((JSONObject)localObject4).optString("dirPath"), (JSONObject)localObject4, paramJsRuntime, paramString1, paramInt));
      }
      if (("fs_copyFile".equals(paramString1)) || ("fs_copyFileSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.13(this, ((JSONObject)localObject4).optString("srcPath"), paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject4).optString("destPath"), l));
      }
      if (("fs_appendFile".equals(paramString1)) || ("fs_appendFileSync".equals(paramString1)))
      {
        localObject5 = ((JSONObject)localObject4).optString("filePath");
        localObject6 = ((JSONObject)localObject4).optString("data");
        localObject7 = ((JSONObject)localObject4).optString("encoding", "utf8");
        paramString2 = NativeBuffer.unpackNativeBuffer((JSONObject)localObject4, "data", (ITNativeBufferPool)this.jsPluginEngine.getNativeBufferPool());
        if (paramString2 != null) {}
        for (paramString2 = paramString2.buf;; paramString2 = null) {
          return execFileTask(paramString1, new FileJsPlugin.14(this, (String)localObject7, paramJsRuntime, paramString1, paramInt, (String)localObject5, (String)localObject6, paramString2));
        }
      }
      if ("unzip".equals(paramString1)) {
        return execFileTask(paramString1, new FileJsPlugin.15(this, ((JSONObject)localObject4).optString("zipFilePath"), paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject4).optString("targetPath"), l));
      }
      if (("rmdir".equals(paramString1)) || ("rmdirSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.16(this, ((JSONObject)localObject4).optString("dirPath"), (JSONObject)localObject4, paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject4).optBoolean("recursive")));
      }
      if (("fs_rename".equals(paramString1)) || ("fs_renameSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.17(this, ((JSONObject)localObject4).optString("oldPath"), paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject4).optString("newPath")));
      }
      if ((!"stat".equals(paramString1)) && (!"statSync".equals(paramString1))) {
        break;
      }
      return execFileTask(paramString1, new FileJsPlugin.18(this, ((JSONObject)localObject4).optString("path"), paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject4).optBoolean("recursive")));
      break;
      label3085:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin
 * JD-Core Version:    0.7.0.1
 */