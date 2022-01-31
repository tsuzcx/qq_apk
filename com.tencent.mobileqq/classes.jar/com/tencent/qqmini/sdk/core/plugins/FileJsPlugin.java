package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import android.util.Base64;
import bdcy;
import bdeu;
import bdew;
import bdfz;
import bdgg;
import bdgi;
import bdgo;
import bdgr;
import bdhe;
import bdnw;
import bdnx;
import bdyo;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.UploaderProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
  public int curPreloadTaskId;
  private ConcurrentHashMap<String, String> downloadMap = new ConcurrentHashMap();
  private AtomicInteger downloadTaskId = new AtomicInteger(0);
  private ConcurrentHashMap<Integer, String> uploadMap = new ConcurrentHashMap();
  
  private void checkUsrFileSize(String paramString, int paramInt)
  {
    paramString = this.mMiniAppInfo;
    if (paramString != null) {}
    for (long l = paramString.usrFileSizeLimit; !bdeu.a().a(2, paramInt, this.mIsMiniGame, l); l = 0L) {
      throw new IOException("the maximum size of the file storage is exceeded");
    }
  }
  
  private String execFileTask(String paramString, FileJsPlugin.FileTask paramFileTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramFileTask.run();
    }
    bdew.a(new FileJsPlugin.19(this, paramFileTask), 16, null, true);
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
  
  private String handleCallbackFail(bdfz parambdfz, JSONObject paramJSONObject, String paramString)
  {
    if (!parambdfz.jdField_a_of_type_JavaLangString.endsWith("Sync"))
    {
      parambdfz.a(paramJSONObject, paramString);
      return "";
    }
    return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, paramJSONObject, paramString).toString();
  }
  
  private String handleCallbackOK(bdfz parambdfz, JSONObject paramJSONObject)
  {
    if (!parambdfz.jdField_a_of_type_JavaLangString.endsWith("Sync"))
    {
      parambdfz.a(paramJSONObject);
      return "";
    }
    return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, paramJSONObject).toString();
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
      bdnw.d("FileJsPlugin", "isEncodingSupport exception,e:" + paramString.getMessage(), paramString);
    }
    return false;
  }
  
  private Object readFile(String paramString1, String paramString2)
  {
    paramString2 = bdgo.a(new File(paramString2));
    if (paramString2 == null) {
      return null;
    }
    if ("base64".equals(paramString1)) {
      return Base64.encodeToString(paramString2, 2);
    }
    if ("binary".equals(paramString1)) {
      return bdhe.a(paramString2);
    }
    if ("hex".equals(paramString1)) {
      return bdhe.a(new String(paramString2));
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
      bdnw.d("FileJsPlugin", "read file err", paramString1);
    }
    return null;
  }
  
  private boolean writeUsrFile(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      checkUsrFileSize(paramString3, paramArrayOfByte.length);
      return bdgo.a(paramString3, paramArrayOfByte, paramBoolean);
    }
    if ("base64".equals(paramString2)) {
      paramArrayOfByte = Base64.decode(paramString1, 2);
    }
    while ((paramString2.equals("binary")) || (paramString2.equals("hex")) || (paramString2.equals("base64")))
    {
      checkUsrFileSize(paramString3, paramArrayOfByte.length);
      return bdgo.a(paramString3, paramArrayOfByte, paramBoolean);
      if ("hex".equals(paramString2)) {
        paramArrayOfByte = bdhe.a(paramString1);
      } else {
        paramArrayOfByte = paramString1.getBytes();
      }
    }
    paramArrayOfByte = Charset.forName(paramString2).encode(new String(paramArrayOfByte, Charset.forName("utf8")));
    paramString1 = paramArrayOfByte.array();
    checkUsrFileSize(paramString3, paramArrayOfByte.limit());
    return bdgo.a(paramString3, paramString1, paramBoolean, paramArrayOfByte.limit());
  }
  
  public String access(bdfz parambdfz)
  {
    long l = System.currentTimeMillis();
    return execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.5(this, parambdfz, l));
  }
  
  public String appendFile(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str1 = ((JSONObject)localObject).optString("filePath");
      String str2 = ((JSONObject)localObject).optString("data");
      String str3 = ((JSONObject)localObject).optString("encoding", "utf8");
      localObject = bdgr.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null) {}
      for (localObject = ((bdgr)localObject).a;; localObject = null)
      {
        parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.6(this, str3, parambdfz, str1, (byte[])localObject, str2));
        return parambdfz;
      }
      return "{}";
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
  }
  
  public String copyFile(bdfz parambdfz)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("srcPath");
      localObject = ((JSONObject)localObject).optString("destPath");
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.8(this, str, parambdfz, (String)localObject, l));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "";
  }
  
  public String createDownloadTask(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str2 = String.valueOf(this.downloadTaskId.getAndIncrement());
      String str3 = localJSONObject.optString("url");
      boolean bool = localJSONObject.optBoolean("__skipDomainCheck__", false);
      Object localObject2 = localJSONObject.optJSONObject("header");
      String str1 = bdeu.a().c(localJSONObject.optString("filePath"));
      if (TextUtils.isEmpty(str3))
      {
        bdnw.d("FileJsPlugin", "download url is null");
        return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "download url is null.").toString();
      }
      if (!bdyo.a(this.mMiniAppInfo, bool, str3, 2))
      {
        bdnw.d("FileJsPlugin", "download url Domain not configured." + str3);
        return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "Domain not configured.").toString();
      }
      if ((!TextUtils.isEmpty(str3)) && (bdyo.a(this.mMiniAppInfo, bool, str3, 2)))
      {
        Object localObject1;
        if (TextUtils.isEmpty(str1)) {
          localObject1 = bdeu.a().g(str3);
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            str3 = getDownloadUrl(str3);
            this.downloadMap.put(str2, str3);
            long l = System.currentTimeMillis();
            localObject2 = bdhe.a((JSONObject)localObject2);
            ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str3, (Map)localObject2, (String)localObject1, 60, new FileJsPlugin.2(this, str2, parambdfz, l, str3, (String)localObject1, localJSONObject, str1));
          }
          for (;;)
          {
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("downloadTaskId", str2);
              localObject1 = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, (JSONObject)localObject1).toString();
              return localObject1;
            }
            catch (Throwable localThrowable)
            {
              bdnw.d("FileJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " return error.", localThrowable);
              continue;
            }
            localObject1 = str1;
            break;
            bdnw.a("FileJsPlugin", "download failed, savepath is null.");
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("downloadTaskId", str2);
            ((JSONObject)localObject1).put("state", "fail");
            ((JSONObject)localObject1).put("errMsg", "Download Failed, savepath is null");
            parambdfz.jdField_a_of_type_Bdcy.a("onDownloadTaskStateChange", ((JSONObject)localObject1).toString(), 0);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            bdnw.d("FileJsPlugin", "download failed." + localException);
          }
        }
      }
      bdnw.c("FileJsPlugin", "check download DomainValid fail, callbackFail, event:" + parambdfz.jdField_a_of_type_JavaLangString + ", callbackId:" + parambdfz.jdField_b_of_type_Int + ", url:" + str3);
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
      return "";
    }
    parambdfz = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "download url error.").toString();
    return parambdfz;
  }
  
  public String createFileSystemInstance(bdfz parambdfz)
  {
    return "{}";
  }
  
  public String createLoadSubPackageTask(bdfz parambdfz)
  {
    try
    {
      String str = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString).optString("moduleName");
      int i = this.curPreloadTaskId + 1;
      this.curPreloadTaskId = i;
      JSONObject localJSONObject = new JSONObject();
      bdnx.a().a(this.mApkgInfo, this.mMiniAppInfo, str, new FileJsPlugin.4(this, i, str, parambdfz));
      localJSONObject.put("loadTaskId", i);
      parambdfz = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, localJSONObject).toString();
      return parambdfz;
    }
    catch (Throwable parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "";
  }
  
  public String createUploadTask(bdfz parambdfz)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject3 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str1 = ((JSONObject)localObject3).optString("url");
      boolean bool = ((JSONObject)localObject3).optBoolean("__skipDomainCheck__", false);
      Object localObject1 = ((JSONObject)localObject3).optString("filePath");
      String str2 = ((JSONObject)localObject3).optString("name");
      String str3 = bdeu.a().a((String)localObject1);
      File localFile = new File(str3);
      if (TextUtils.isEmpty(str1))
      {
        bdnw.c("FileJsPlugin", "upload url is empty.");
        return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, ":upload url is empty : " + str1).toString();
      }
      if (bdyo.a(this.mMiniAppInfo, bool, str1, 3))
      {
        bdnw.c("FileJsPlugin", "check upload DomainValid fail, callbackFail, event:" + parambdfz.jdField_a_of_type_JavaLangString + ", callbackId:" + parambdfz.jdField_b_of_type_Int + ", url:" + str1);
        return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "url not in domain list, 请求域名不合法").toString();
      }
      if (TextUtils.isEmpty(str3))
      {
        bdnw.c("FileJsPlugin", "upload file error. " + str3);
        return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, ":file doesn't exist").toString();
      }
      if (TextUtils.isEmpty(str2))
      {
        bdnw.c("FileJsPlugin", "upload file name error. " + str2);
        return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, ":file name is error").toString();
      }
      int i = parambdfz.jdField_b_of_type_Int;
      Object localObject2 = ((JSONObject)localObject3).optJSONObject("header");
      localObject3 = ((JSONObject)localObject3).optJSONObject("formData");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject1 = "";; localObject1 = ((String)localObject1).replace("wxfile://", ""))
      {
        localObject2 = bdhe.a((JSONObject)localObject2);
        localObject3 = bdhe.a((JSONObject)localObject3);
        ((UploaderProxy)ProxyManager.get(UploaderProxy.class)).upload(str1, (Map)localObject2, str3, str2, (String)localObject1, (Map)localObject3, 60, new FileJsPlugin.3(this, i, parambdfz, l, localFile));
        this.uploadMap.put(Integer.valueOf(i), str1);
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("uploadTaskId", i);
          localObject1 = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, (JSONObject)localObject1).toString();
          return localObject1;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          bdnw.d("FileJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " return error.", localThrowable);
        }
      }
    }
    catch (JSONException parambdfz)
    {
      for (;;)
      {
        parambdfz.printStackTrace();
      }
    }
    return "";
  }
  
  /* Error */
  public void getFileInfo(bdfz parambdfz)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 243	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: getfield 376	bdfz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokespecial 377	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: ldc_w 379
    //   19: invokevirtual 382	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 5
    //   24: aload_3
    //   25: ldc_w 617
    //   28: ldc_w 619
    //   31: invokevirtual 389	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_3
    //   35: invokestatic 143	bdeu:a	()Lbdeu;
    //   38: aload 5
    //   40: invokevirtual 575	bdeu:a	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 7
    //   45: ldc_w 619
    //   48: aload_3
    //   49: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifne +167 -> 219
    //   55: ldc_w 621
    //   58: aload_3
    //   59: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +162 -> 224
    //   65: goto +154 -> 219
    //   68: aload 7
    //   70: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   73: ifne +136 -> 209
    //   76: iload_2
    //   77: ifeq +132 -> 209
    //   80: new 275	java/io/File
    //   83: dup
    //   84: aload 7
    //   86: invokespecial 276	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 5
    //   91: new 243	org/json/JSONObject
    //   94: dup
    //   95: invokespecial 494	org/json/JSONObject:<init>	()V
    //   98: astore 6
    //   100: ldc_w 621
    //   103: aload_3
    //   104: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +52 -> 159
    //   110: aload 7
    //   112: invokestatic 624	bdha:a	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: ifnull +9 -> 126
    //   120: aload_3
    //   121: invokevirtual 627	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   124: astore 4
    //   126: aload 6
    //   128: ldc_w 629
    //   131: aload 4
    //   133: invokevirtual 498	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload 6
    //   139: ldc_w 631
    //   142: aload 5
    //   144: invokevirtual 633	java/io/File:length	()J
    //   147: invokevirtual 636	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_1
    //   152: aload 6
    //   154: invokevirtual 247	bdfz:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   157: pop
    //   158: return
    //   159: aload 7
    //   161: invokestatic 639	bdyv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore_3
    //   165: goto -49 -> 116
    //   168: astore_3
    //   169: ldc 56
    //   171: new 217	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 641
    //   181: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_3
    //   185: invokevirtual 267	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 453	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_1
    //   198: invokevirtual 643	bdfz:b	()Ljava/lang/String;
    //   201: pop
    //   202: return
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 409	org/json/JSONException:printStackTrace	()V
    //   208: return
    //   209: aload_1
    //   210: aconst_null
    //   211: ldc_w 645
    //   214: invokevirtual 236	bdfz:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   217: pop
    //   218: return
    //   219: iconst_1
    //   220: istore_2
    //   221: goto -153 -> 68
    //   224: iconst_0
    //   225: istore_2
    //   226: goto -158 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	FileJsPlugin
    //   0	229	1	parambdfz	bdfz
    //   76	150	2	i	int
    //   14	151	3	localObject1	Object
    //   168	17	3	localThrowable	Throwable
    //   1	131	4	str1	String
    //   22	121	5	localObject2	Object
    //   98	55	6	localJSONObject	JSONObject
    //   43	117	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   100	116	168	java/lang/Throwable
    //   120	126	168	java/lang/Throwable
    //   126	158	168	java/lang/Throwable
    //   159	165	168	java/lang/Throwable
    //   3	65	203	org/json/JSONException
    //   68	76	203	org/json/JSONException
    //   80	100	203	org/json/JSONException
    //   100	116	203	org/json/JSONException
    //   120	126	203	org/json/JSONException
    //   126	158	203	org/json/JSONException
    //   159	165	203	org/json/JSONException
    //   169	202	203	org/json/JSONException
    //   209	218	203	org/json/JSONException
  }
  
  public String getSavedFileInfo(bdfz parambdfz)
  {
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString).optString("filePath");
        localObject2 = bdeu.a().a((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists()) {
          continue;
        }
        localObject1 = new JSONObject();
      }
      catch (JSONException parambdfz)
      {
        Object localObject1;
        Object localObject2;
        parambdfz.printStackTrace();
        continue;
        parambdfz.a(null, "no such file" + localThrowable);
        continue;
        parambdfz.a(null, "no such file" + localThrowable);
        continue;
      }
      try
      {
        ((JSONObject)localObject1).put("size", ((File)localObject2).length());
        ((JSONObject)localObject1).put("createTime", ((File)localObject2).lastModified() / 1000L);
        parambdfz.a((JSONObject)localObject1);
        return "";
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        parambdfz.b();
      }
    }
  }
  
  public String getSavedFileList(bdfz parambdfz)
  {
    Object localObject1 = bdeu.a().a();
    try
    {
      localJSONArray = new JSONArray();
      if (localObject1 == null) {
        break label132;
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
        label132:
        localThrowable.printStackTrace();
        parambdfz.b();
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
        localJSONObject.put("filePath", bdeu.a().e(localObject2.getAbsolutePath()));
        localJSONObject.put("size", localObject2.length());
        localJSONObject.put("createTime", localObject2.lastModified() / 1000L);
        localJSONArray.put(localJSONObject);
      }
    }
    else
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("fileList", localJSONArray);
      parambdfz.a((JSONObject)localObject1);
      return "";
    }
  }
  
  public String mkdir(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("dirPath");
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.9(this, str, localJSONObject, parambdfz));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "{}";
  }
  
  public String openDocument(bdfz parambdfz)
  {
    try
    {
      new JSONObject(parambdfz.jdField_b_of_type_JavaLangString).optString("filePath");
      bdgi.a(new FileJsPlugin.18(this));
      return "";
    }
    catch (JSONException parambdfz)
    {
      for (;;)
      {
        parambdfz.printStackTrace();
      }
    }
  }
  
  public String operateDownloadTask(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("downloadTaskId");
      if (("abort".equals(localJSONObject.optString("operationType"))) && (this.downloadMap.containsKey(str)))
      {
        ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).abort((String)this.downloadMap.get(str));
        localJSONObject = new JSONObject();
      }
      return "";
    }
    catch (JSONException parambdfz)
    {
      try
      {
        localJSONObject.put("downloadTaskId", str);
        parambdfz = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, localJSONObject).toString();
        return parambdfz;
      }
      catch (Throwable parambdfz)
      {
        break label106;
      }
      parambdfz = parambdfz;
      parambdfz.printStackTrace();
    }
  }
  
  public String operateUploadTask(bdfz parambdfz)
  {
    try
    {
      parambdfz = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      int i = parambdfz.optInt("uploadTaskId");
      if (("abort".equals(parambdfz.optString("operationType"))) && (this.uploadMap.containsKey(Integer.valueOf(i)))) {
        ((UploaderProxy)ProxyManager.get(UploaderProxy.class)).abort((String)this.uploadMap.get(Integer.valueOf(i)));
      }
      return "";
    }
    catch (JSONException parambdfz)
    {
      for (;;)
      {
        parambdfz.printStackTrace();
      }
    }
  }
  
  public String readFile(bdfz parambdfz)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str2 = ((JSONObject)localObject).optString("filePath");
      String str1 = ((JSONObject)localObject).optString("encoding", "__internal__array_buffer");
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "__internal__array_buffer";
      }
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.10(this, str2, parambdfz, (String)localObject, l));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "{}";
  }
  
  public String readdir(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("dirPath");
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.11(this, str, localJSONObject, parambdfz));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "";
  }
  
  public String removeSavedFile(bdfz parambdfz)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
        String str = ((JSONObject)localObject).optString("filePath");
        if ((TextUtils.isEmpty(str)) || (((JSONObject)localObject).isNull("filePath"))) {
          return handleCallbackFail(parambdfz, null, "fail parameter error: parameter.dirPath should be String instead of Null;");
        }
        if (bdeu.a().a(str) != 1) {
          continue;
        }
        localObject = bdeu.a().a(str);
        if (!bdgo.b((String)localObject)) {
          continue;
        }
        bdgo.a((String)localObject, false);
        parambdfz.a();
      }
      catch (JSONException parambdfz)
      {
        parambdfz.printStackTrace();
        continue;
        parambdfz.a(null, "not a store filePath");
        continue;
      }
      return "";
      parambdfz.a(null, "not a store filePath");
    }
  }
  
  public String rename(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("oldPath");
      localObject = ((JSONObject)localObject).optString("newPath");
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.12(this, str, parambdfz, (String)localObject));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "";
  }
  
  public String rmdir(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("dirPath");
      boolean bool = localJSONObject.optBoolean("recursive");
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.13(this, str, localJSONObject, parambdfz, bool));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "";
  }
  
  public String saveFile(bdfz parambdfz)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("tempFilePath");
      localObject = ((JSONObject)localObject).optString("filePath");
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.7(this, str, parambdfz, (String)localObject, l));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "";
  }
  
  public String stat(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("path");
      boolean bool = localJSONObject.optBoolean("recursive");
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.14(this, str, parambdfz, bool));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "{}";
  }
  
  public String unlink(bdfz parambdfz)
  {
    try
    {
      String str = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString).optString("filePath");
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.15(this, str, parambdfz));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "";
  }
  
  public String unzip(bdfz parambdfz)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("zipFilePath");
      localObject = ((JSONObject)localObject).optString("targetPath");
      parambdfz = execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.16(this, str, parambdfz, (String)localObject, l));
      return parambdfz;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
    return "";
  }
  
  public String writeFile(bdfz parambdfz)
  {
    byte[] arrayOfByte = null;
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      String str2 = ((JSONObject)localObject).optString("filePath");
      if (((JSONObject)localObject).isNull("data")) {}
      for (String str1 = null;; str1 = ((JSONObject)localObject).optString("data"))
      {
        String str3 = ((JSONObject)localObject).optString("encoding", "utf8");
        localObject = bdgr.a(this.mMiniAppContext, (JSONObject)localObject, "data");
        if (localObject != null) {
          arrayOfByte = ((bdgr)localObject).a;
        }
        return execFileTask(parambdfz.jdField_a_of_type_JavaLangString, new FileJsPlugin.17(this, str1, arrayOfByte, parambdfz, str3, str2, l));
      }
      return "";
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin
 * JD-Core Version:    0.7.0.1
 */