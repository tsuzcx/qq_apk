package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajjy;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import bace;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.http.MiniappHttpUtil;
import com.tencent.mobileqq.mini.http.MiniappHttpUtil.UploadTask;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.StringUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mpr;
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
  private static final String API_CREATE_LOAD_SUBPACKAGE_TASK = "createLoadSubPackageTask";
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
  private ITTEngine mTTEngine = GameLoadManager.g().getGameEngine();
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
    TTHandleThread.getInstance().execute_FILE(new FileJsPlugin.20(this, paramFileTask));
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
    paramString2 = bace.a(new File(paramString2));
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
      return bace.a(paramArrayOfByte, paramString3, paramBoolean);
    }
    if ("base64".equals(paramString2)) {
      paramArrayOfByte = Base64.decode(paramString1, 2);
    }
    while ((paramString2.equals("binary")) || (paramString2.equals("hex")) || (paramString2.equals("base64")))
    {
      checkUsrFileSize(paramString3, paramArrayOfByte.length);
      return bace.a(paramArrayOfByte, paramString3, paramBoolean);
      if ("hex".equals(paramString2)) {
        paramArrayOfByte = StringUtil.hexStr2Bytes(paramString1);
      } else {
        paramArrayOfByte = paramString1.getBytes();
      }
    }
    paramArrayOfByte = Charset.forName(paramString2).encode(new String(paramArrayOfByte, Charset.forName("utf8")));
    paramString1 = paramArrayOfByte.array();
    checkUsrFileSize(paramString3, paramArrayOfByte.limit());
    return bace.a(paramString1, paramString3, paramBoolean, paramArrayOfByte.limit());
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    Object localObject8 = new WeakReference(paramJsRuntime);
    long l = System.currentTimeMillis();
    Object localObject1;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString2);
      if ("createFileSystemInstance".equals(paramString1)) {
        return "{}";
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        localObject1 = new JSONObject();
      }
    }
    int i;
    Object localObject6;
    if ("createLoadSubPackageTask".equals(paramString1))
    {
      localObject1 = ((JSONObject)localObject1).optString("moduleName");
      i = this.curPreloadTaskId + 1;
      this.curPreloadTaskId = i;
      localObject6 = new JSONObject();
      try
      {
        this.jsPluginEngine.appBrandRuntime.getApkgInfo().downloadSubPack((String)localObject1, new FileJsPlugin.3(this, (WeakReference)localObject8, i, (String)localObject1));
        ((JSONObject)localObject6).put("loadTaskId", i);
        localObject1 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject6).toString();
        return localObject1;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
    }
    Object localObject7;
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      String str2;
      Object localObject10;
      boolean bool;
      Object localObject9;
      Object localObject3;
      if ("createDownloadTask".equals(paramString1))
      {
        str2 = String.valueOf(this.downloadTaskId.getAndIncrement());
        localObject10 = localThrowable2.optString("url");
        bool = localThrowable2.optBoolean("__skipDomainCheck__", false);
        localObject9 = localThrowable2.optJSONObject("header");
        localObject7 = MiniAppFileManager.getInstance().getUsrPath(localThrowable2.optString("filePath"));
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
        if ((!TextUtils.isEmpty((CharSequence)localObject10)) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool, (String)localObject10, 2)))
        {
          localObject6 = localObject7;
          if (TextUtils.isEmpty((CharSequence)localObject7)) {
            localObject6 = MiniAppFileManager.getInstance().getTmpPathByUrl((String)localObject10);
          }
          localObject7 = (JsRuntime)((WeakReference)localObject8).get();
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject6))
            {
              localObject8 = getDownloadUrl((String)localObject10);
              this.downloadMap.put(str2, localObject8);
              MiniappDownloadUtil.getInstance().download((String)localObject8, (String)localObject6, false, new FileJsPlugin.4(this, l, str2, (JsRuntime)localObject7, (String)localObject6, localThrowable2), Downloader.DownloadMode.StrictMode, (JSONObject)localObject9);
            }
            for (;;)
            {
              try
              {
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("downloadTaskId", str2);
                localObject2 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject2).toString();
                return localObject2;
              }
              catch (Throwable localThrowable3)
              {
                Object localObject2;
                QLog.e("[mini] FileJsPlugin", 1, paramString1 + " return error.", localThrowable3);
              }
              QLog.d("[mini] FileJsPlugin", 1, "download failed, savepath is null.");
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("downloadTaskId", str2);
              ((JSONObject)localObject2).put("state", "fail");
              ((JSONObject)localObject2).put("errMsg", "Download Failed, savepath is null");
              ((JsRuntime)localObject7).evaluateSubcribeJS("onDownloadTaskStateChange", ((JSONObject)localObject2).toString(), 0);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("[mini] FileJsPlugin", 1, "download failed." + localException);
            }
          }
        }
        else
        {
          QLog.w("[mini] FileJsPlugin", 1, "check download DomainValid fail, callbackFail, event:" + paramString1 + ", callbackId:" + paramInt + ", url:" + (String)localObject10);
          return ApiUtil.wrapCallbackFail(paramString1, null, "download url error.").toString();
        }
      }
      else if ("operateDownloadTask".equals(paramString1))
      {
        localObject6 = localThrowable3.optString("downloadTaskId");
        if ((!"abort".equals(localThrowable3.optString("operationType"))) || (!this.downloadMap.containsKey(localObject6))) {
          continue;
        }
        MiniappDownloadUtil.getInstance().abort((String)this.downloadMap.get(localObject6));
        localObject3 = new JSONObject();
      }
      label1495:
      label1652:
      label1662:
      try
      {
        ((JSONObject)localObject3).put("downloadTaskId", localObject6);
        localObject3 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject3).toString();
        return localObject3;
      }
      catch (Throwable localThrowable8) {}
      if ("createUploadTask".equals(paramString1))
      {
        localObject6 = ((JSONObject)localObject3).optString("url");
        bool = ((JSONObject)localObject3).optBoolean("__skipDomainCheck__", false);
        String str3 = ((JSONObject)localObject3).optString("filePath");
        localObject7 = ((JSONObject)localObject3).optString("name");
        str2 = MiniAppFileManager.getInstance().getAbsolutePath(str3);
        localObject9 = new File(str2);
        if (TextUtils.isEmpty((CharSequence)localObject6))
        {
          QLog.w("[mini] FileJsPlugin", 1, "upload url is empty.");
          return ApiUtil.wrapCallbackFail(paramString1, null, ":upload url is empty : " + (String)localObject6).toString();
        }
        if (!this.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool, (String)localObject6, 3))
        {
          QLog.w("[mini] FileJsPlugin", 1, "check upload DomainValid fail, callbackFail, event:" + paramString1 + ", callbackId:" + paramInt + ", url:" + (String)localObject6);
          return ApiUtil.wrapCallbackFail(paramString1, null, ajjy.a(2131638734)).toString();
        }
        if (TextUtils.isEmpty(str2))
        {
          QLog.w("[mini] FileJsPlugin", 1, "upload file error. " + str2);
          return ApiUtil.wrapCallbackFail(paramString1, null, ":file doesn't exist").toString();
        }
        if (TextUtils.isEmpty((CharSequence)localObject7))
        {
          QLog.w("[mini] FileJsPlugin", 1, "upload file name error. " + (String)localObject7);
          return ApiUtil.wrapCallbackFail(paramString1, null, ":file name is error").toString();
        }
        localObject10 = ((JSONObject)localObject3).optJSONObject("header");
        JSONObject localJSONObject2 = ((JSONObject)localObject3).optJSONObject("formData");
        if (TextUtils.isEmpty(str3)) {}
        for (localObject3 = "";; localObject3 = str3.replace(MiniAppGlobal.STR_WXFILE, ""))
        {
          localObject3 = MiniappHttpUtil.httpUpload("POST", (String)localObject6, str2, (JSONObject)localObject10, localJSONObject2, (String)localObject7, (String)localObject3, new FileJsPlugin.5(this, paramInt, paramJsRuntime, l, (WeakReference)localObject8, (File)localObject9));
          this.uploadMap.put(Integer.valueOf(paramInt), localObject3);
          try
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("uploadTaskId", paramInt);
            localObject3 = ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject3).toString();
            return localObject3;
          }
          catch (Throwable localThrowable4)
          {
            localThrowable4.printStackTrace();
            QLog.e("[mini] FileJsPlugin", 1, paramString1 + " return error.", localThrowable4);
          }
        }
      }
      else if ("operateUploadTask".equals(paramString1))
      {
        localObject6 = (JsRuntime)((WeakReference)localObject8).get();
        i = localThrowable4.optInt("uploadTaskId");
        if (("abort".equals(localThrowable4.optString("operationType"))) && (this.uploadMap.containsKey(Integer.valueOf(i)))) {
          ((MiniappHttpUtil.UploadTask)this.uploadMap.get(Integer.valueOf(i))).abort();
        }
      }
      else
      {
        if (("saveFile".equals(paramString1)) || ("saveFileSync".equals(paramString1))) {
          return execFileTask(paramString1, new FileJsPlugin.6(this, localThrowable4.optString("tempFilePath"), paramJsRuntime, paramString1, paramInt, localThrowable4.optString("filePath"), l));
        }
        if (("mkdir".equals(paramString1)) || ("mkdirSync".equals(paramString1))) {
          return execFileTask(paramString1, new FileJsPlugin.7(this, localThrowable4.optString("dirPath"), localThrowable4, paramJsRuntime, paramString1, paramInt));
        }
        Object localObject4;
        if ("getFileInfo".equals(paramString1))
        {
          localObject6 = localThrowable4.optString("filePath");
          String str1 = localThrowable4.optString("digestAlgorithm", "md5");
          localObject8 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject6);
          if (("md5".equals(str1)) || ("sha1".equals(str1)))
          {
            i = 1;
            if ((!TextUtils.isEmpty((CharSequence)localObject8)) && (i != 0))
            {
              localObject6 = new File((String)localObject8);
              localObject7 = new JSONObject();
            }
          }
          else
          {
            for (;;)
            {
              try
              {
                if (!"sha1".equals(str1)) {
                  break label1652;
                }
                str1 = mpr.a((String)localObject8);
                if (str1 == null) {
                  break label1662;
                }
                str1 = str1.toLowerCase();
                ((JSONObject)localObject7).put("digest", str1);
                ((JSONObject)localObject7).put("size", ((File)localObject6).length());
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject7, paramInt);
              }
              catch (Throwable localThrowable5)
              {
                QLog.e("[mini] FileJsPlugin", 1, "getFileInfo exception:" + localThrowable5.getMessage());
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
              }
              break;
              i = 0;
              break label1495;
              localObject4 = MD5Coding.encodeFile2HexStr((String)localObject8);
              continue;
              localObject4 = null;
            }
          }
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "invalid data", paramInt);
        }
        else
        {
          if (!"getSavedFileInfo".equals(paramString1)) {
            break;
          }
          localObject4 = ((JSONObject)localObject4).optString("filePath");
          localObject6 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject4);
          if (!TextUtils.isEmpty((CharSequence)localObject6))
          {
            localObject6 = new File((String)localObject6);
            if (((File)localObject6).exists())
            {
              localObject4 = new JSONObject();
              try
              {
                ((JSONObject)localObject4).put("size", ((File)localObject6).length());
                ((JSONObject)localObject4).put("createTime", ((File)localObject6).lastModified() / 1000L);
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject4, paramInt);
              }
              catch (Throwable localThrowable6)
              {
                localThrowable6.printStackTrace();
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
              }
            }
            else
            {
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "no such file" + localThrowable6, paramInt);
            }
          }
          else
          {
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "no such file" + localThrowable6, paramInt);
          }
        }
      }
    }
    if ("getSavedFileList".equals(paramString1)) {
      localObject6 = MiniAppFileManager.getInstance().getSaveFileList();
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        if (localObject6 != null)
        {
          int j = localObject6.length;
          i = 0;
          if (i < j)
          {
            localObject7 = localObject6[i];
            if ((localObject7 == null) || (!((File)localObject7).exists()) || (!((File)localObject7).isFile())) {
              break label2980;
            }
            localObject8 = new JSONObject();
            ((JSONObject)localObject8).put("filePath", MiniAppFileManager.getInstance().getWxFilePath(((File)localObject7).getAbsolutePath()));
            ((JSONObject)localObject8).put("size", ((File)localObject7).length());
            ((JSONObject)localObject8).put("createTime", ((File)localObject7).lastModified() / 1000L);
            localJSONArray.put(localObject8);
            break label2980;
          }
        }
        localObject6 = new JSONObject();
        ((JSONObject)localObject6).put("fileList", localJSONArray);
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject6, paramInt);
      }
      catch (Throwable localThrowable7)
      {
        localThrowable7.printStackTrace();
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
      }
      break;
      Object localObject5;
      if ("removeSavedFile".equals(paramString1))
      {
        localObject6 = localThrowable7.optString("filePath");
        if ((TextUtils.isEmpty((CharSequence)localObject6)) || (localThrowable7.isNull("filePath"))) {
          return handleCallbackFail(paramJsRuntime, paramString1, null, "fail parameter error: parameter.dirPath should be String instead of Null;", paramInt);
        }
        if (MiniAppFileManager.getInstance().getWxFileType((String)localObject6) == 1)
        {
          localObject5 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject6);
          if (bace.a((String)localObject5))
          {
            bace.a((String)localObject5, false);
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
        AppBrandTask.runTaskOnUiThread(new FileJsPlugin.8(this, ((JSONObject)localObject5).optString("filePath"), paramJsRuntime, paramString1, paramInt));
        break;
      }
      if (("writeFile".equals(paramString1)) || ("writeFileSync".equals(paramString1)))
      {
        localObject6 = ((JSONObject)localObject5).optString("filePath");
        if (((JSONObject)localObject5).isNull("data"))
        {
          paramString2 = null;
          localObject7 = ((JSONObject)localObject5).optString("encoding", "utf8");
          localObject5 = NativeBuffer.unpackNativeBuffer((JSONObject)localObject5, "data", this.mTTEngine.getNativeBufferPool());
          if (localObject5 == null) {
            break label2391;
          }
        }
        label2391:
        for (localObject5 = ((NativeBuffer)localObject5).buf;; localObject5 = null)
        {
          return execFileTask(paramString1, new FileJsPlugin.9(this, paramString2, (byte[])localObject5, paramJsRuntime, paramString1, paramInt, (String)localObject7, (String)localObject6, l));
          paramString2 = ((JSONObject)localObject5).optString("data");
          break;
        }
      }
      if (("readFile".equals(paramString1)) || ("readFileSync".equals(paramString1)))
      {
        localObject6 = ((JSONObject)localObject5).optString("filePath");
        localObject5 = ((JSONObject)localObject5).optString("encoding", "__internal__array_buffer");
        paramString2 = (String)localObject5;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          paramString2 = "__internal__array_buffer";
        }
        return execFileTask(paramString1, new FileJsPlugin.10(this, (String)localObject6, paramJsRuntime, paramString1, paramInt, paramString2, l));
      }
      if (("access".equals(paramString1)) || ("accessSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.11(this, ((JSONObject)localObject5).optString("path"), l, paramJsRuntime, paramString1, paramInt));
      }
      if (("unlink".equals(paramString1)) || ("unlinkSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.12(this, ((JSONObject)localObject5).optString("filePath"), paramJsRuntime, paramString1, paramInt));
      }
      if (("readdir".equals(paramString1)) || ("readdirSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.13(this, ((JSONObject)localObject5).optString("dirPath"), (JSONObject)localObject5, paramJsRuntime, paramString1, paramInt));
      }
      if (("fs_copyFile".equals(paramString1)) || ("fs_copyFileSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.14(this, ((JSONObject)localObject5).optString("srcPath"), paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject5).optString("destPath"), l));
      }
      if (("fs_appendFile".equals(paramString1)) || ("fs_appendFileSync".equals(paramString1)))
      {
        localObject6 = ((JSONObject)localObject5).optString("filePath");
        localObject7 = ((JSONObject)localObject5).optString("data");
        localObject8 = ((JSONObject)localObject5).optString("encoding", "utf8");
        paramString2 = NativeBuffer.unpackNativeBuffer((JSONObject)localObject5, "data", this.mTTEngine.getNativeBufferPool());
        if (paramString2 != null) {}
        for (paramString2 = paramString2.buf;; paramString2 = null) {
          return execFileTask(paramString1, new FileJsPlugin.15(this, (String)localObject8, paramJsRuntime, paramString1, paramInt, (String)localObject6, (String)localObject7, paramString2));
        }
      }
      if ("unzip".equals(paramString1)) {
        return execFileTask(paramString1, new FileJsPlugin.16(this, ((JSONObject)localObject5).optString("zipFilePath"), paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject5).optString("targetPath"), l));
      }
      if (("rmdir".equals(paramString1)) || ("rmdirSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.17(this, ((JSONObject)localObject5).optString("dirPath"), (JSONObject)localObject5, paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject5).optBoolean("recursive")));
      }
      if (("fs_rename".equals(paramString1)) || ("fs_renameSync".equals(paramString1))) {
        return execFileTask(paramString1, new FileJsPlugin.18(this, ((JSONObject)localObject5).optString("oldPath"), paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject5).optString("newPath")));
      }
      if ((!"stat".equals(paramString1)) && (!"statSync".equals(paramString1))) {
        break;
      }
      return execFileTask(paramString1, new FileJsPlugin.19(this, ((JSONObject)localObject5).optString("path"), paramJsRuntime, paramString1, paramInt, ((JSONObject)localObject5).optBoolean("recursive")));
      break;
      label2980:
      i += 1;
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin
 * JD-Core Version:    0.7.0.1
 */