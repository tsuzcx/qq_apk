package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import android.util.Base64;
import bglu;
import bglv;
import bgnt;
import bgok;
import bgop;
import bgpc;
import bgpf;
import bgpi;
import bgpv;
import bgxm;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.UploaderProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DomainUtil;
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
    for (long l = paramString.usrFileSizeLimit; !bgnt.a().a(2, paramInt, this.mIsMiniGame, l, this.mMiniAppInfo, this.mMiniAppContext.a()); l = 0L) {
      throw new IOException("the maximum size of the file storage is exceeded");
    }
  }
  
  private String execFileTask(String paramString, FileJsPlugin.FileTask paramFileTask)
  {
    if (paramString.endsWith("Sync")) {
      return paramFileTask.run();
    }
    ThreadManager.a(new FileJsPlugin.17(this, paramFileTask), 16, null, true);
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
  
  private String handleCallbackFail(bgok parambgok, JSONObject paramJSONObject, String paramString)
  {
    if (!parambgok.jdField_a_of_type_JavaLangString.endsWith("Sync"))
    {
      parambgok.a(paramJSONObject, paramString);
      return "";
    }
    return bgop.a(parambgok.jdField_a_of_type_JavaLangString, paramJSONObject, paramString).toString();
  }
  
  private String handleCallbackOK(bgok parambgok, JSONObject paramJSONObject)
  {
    if (!parambgok.jdField_a_of_type_JavaLangString.endsWith("Sync"))
    {
      parambgok.a(paramJSONObject);
      return "";
    }
    return bgop.a(parambgok.jdField_a_of_type_JavaLangString, paramJSONObject).toString();
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
  
  private Object readFile(String paramString1, String paramString2)
  {
    paramString2 = bgpc.a(new File(paramString2));
    if (paramString2 == null) {
      return null;
    }
    if ("base64".equals(paramString1)) {
      return Base64.encodeToString(paramString2, 2);
    }
    if ("binary".equals(paramString1)) {
      return bgpv.a(paramString2);
    }
    if ("hex".equals(paramString1)) {
      return bgpv.a(new String(paramString2));
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
    if (paramArrayOfByte != null)
    {
      checkUsrFileSize(paramString3, paramArrayOfByte.length);
      return bgpc.a(paramString3, paramArrayOfByte, paramBoolean);
    }
    if ("base64".equals(paramString2)) {
      paramArrayOfByte = Base64.decode(paramString1, 2);
    }
    while ((paramString2.equals("binary")) || (paramString2.equals("hex")) || (paramString2.equals("base64")))
    {
      checkUsrFileSize(paramString3, paramArrayOfByte.length);
      return bgpc.a(paramString3, paramArrayOfByte, paramBoolean);
      if ("hex".equals(paramString2)) {
        paramArrayOfByte = bgpv.a(paramString1);
      } else {
        paramArrayOfByte = paramString1.getBytes();
      }
    }
    paramArrayOfByte = Charset.forName(paramString2).encode(new String(paramArrayOfByte, Charset.forName("utf8")));
    paramString1 = paramArrayOfByte.array();
    checkUsrFileSize(paramString3, paramArrayOfByte.limit());
    return bgpc.a(paramString3, paramString1, paramBoolean, paramArrayOfByte.limit());
  }
  
  public String access(bgok parambgok)
  {
    long l = System.currentTimeMillis();
    return execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.4(this, parambgok, l));
  }
  
  public String appendFile(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str1 = ((JSONObject)localObject).optString("filePath");
      String str2 = ((JSONObject)localObject).optString("data");
      String str3 = ((JSONObject)localObject).optString("encoding", "utf8");
      localObject = bgpi.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null) {}
      for (localObject = ((bgpi)localObject).a;; localObject = null)
      {
        parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.5(this, str3, parambgok, str1, str2, (byte[])localObject));
        return parambgok;
      }
      return "{}";
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
  
  public String copyFile(bgok parambgok)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("srcPath");
      localObject = ((JSONObject)localObject).optString("destPath");
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.7(this, str, parambgok, (String)localObject, l));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "";
  }
  
  public String createDownloadTask(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str2 = String.valueOf(this.downloadTaskId.getAndIncrement());
      String str3 = localJSONObject.optString("url");
      boolean bool = localJSONObject.optBoolean("__skipDomainCheck__", false);
      Object localObject2 = localJSONObject.optJSONObject("header");
      String str1 = bgnt.a().c(localJSONObject.optString("filePath"));
      if (TextUtils.isEmpty(str3))
      {
        QMLog.e("FileJsPlugin", "download url is null");
        return bgop.a(parambgok.jdField_a_of_type_JavaLangString, null, "download url is null.").toString();
      }
      if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, str3, 2))
      {
        QMLog.e("FileJsPlugin", "download url Domain not configured." + str3);
        return bgop.a(parambgok.jdField_a_of_type_JavaLangString, null, "Domain not configured.").toString();
      }
      if ((!TextUtils.isEmpty(str3)) && (DomainUtil.isDomainValid(this.mMiniAppInfo, bool, str3, 2)))
      {
        Object localObject1;
        if (TextUtils.isEmpty(str1)) {
          localObject1 = bgnt.a().g(str3);
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            str3 = getDownloadUrl(str3);
            this.downloadMap.put(str2, str3);
            long l = System.currentTimeMillis();
            localObject2 = bgpv.a((JSONObject)localObject2);
            ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str3, (Map)localObject2, (String)localObject1, 60, new FileJsPlugin.2(this, str2, parambgok, l, str3, (String)localObject1, localJSONObject, str1));
          }
          for (;;)
          {
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("downloadTaskId", str2);
              localObject1 = bgop.a(parambgok.jdField_a_of_type_JavaLangString, (JSONObject)localObject1).toString();
              return localObject1;
            }
            catch (Throwable localThrowable)
            {
              QMLog.e("FileJsPlugin", parambgok.jdField_a_of_type_JavaLangString + " return error.", localThrowable);
              continue;
            }
            localObject1 = str1;
            break;
            QMLog.d("FileJsPlugin", "download failed, savepath is null.");
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("downloadTaskId", str2);
            ((JSONObject)localObject1).put("state", "fail");
            ((JSONObject)localObject1).put("errMsg", "Download Failed, savepath is null");
            parambgok.jdField_a_of_type_Bglu.a("onDownloadTaskStateChange", ((JSONObject)localObject1).toString(), 0);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QMLog.e("FileJsPlugin", "download failed." + localException);
          }
        }
      }
      QMLog.w("FileJsPlugin", "check download DomainValid fail, callbackFail, event:" + parambgok.jdField_a_of_type_JavaLangString + ", callbackId:" + parambgok.jdField_b_of_type_Int + ", url:" + str3);
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
      return "";
    }
    parambgok = bgop.a(parambgok.jdField_a_of_type_JavaLangString, null, "download url error.").toString();
    return parambgok;
  }
  
  public String createFileSystemInstance(bgok parambgok)
  {
    return "{}";
  }
  
  public String createUploadTask(bgok parambgok)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject3 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str1 = ((JSONObject)localObject3).optString("url");
      boolean bool = ((JSONObject)localObject3).optBoolean("__skipDomainCheck__", false);
      Object localObject1 = ((JSONObject)localObject3).optString("filePath");
      String str2 = ((JSONObject)localObject3).optString("name");
      String str3 = bgnt.a().a((String)localObject1);
      File localFile = new File(str3);
      if (TextUtils.isEmpty(str1))
      {
        QMLog.w("FileJsPlugin", "upload url is empty.");
        return bgop.a(parambgok.jdField_a_of_type_JavaLangString, null, ":upload url is empty : " + str1).toString();
      }
      if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, str1, 3))
      {
        QMLog.w("FileJsPlugin", "check upload DomainValid fail, callbackFail, event:" + parambgok.jdField_a_of_type_JavaLangString + ", callbackId:" + parambgok.jdField_b_of_type_Int + ", url:" + str1);
        return bgop.a(parambgok.jdField_a_of_type_JavaLangString, null, "url not in domain list, 请求域名不合法").toString();
      }
      if (TextUtils.isEmpty(str3))
      {
        QMLog.w("FileJsPlugin", "upload file error. " + str3);
        return bgop.a(parambgok.jdField_a_of_type_JavaLangString, null, ":file doesn't exist").toString();
      }
      if (TextUtils.isEmpty(str2))
      {
        QMLog.w("FileJsPlugin", "upload file name error. " + str2);
        return bgop.a(parambgok.jdField_a_of_type_JavaLangString, null, ":file name is error").toString();
      }
      int i = parambgok.jdField_b_of_type_Int;
      Object localObject2 = ((JSONObject)localObject3).optJSONObject("header");
      localObject3 = ((JSONObject)localObject3).optJSONObject("formData");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject1 = "";; localObject1 = ((String)localObject1).replace("wxfile://", ""))
      {
        localObject2 = bgpv.a((JSONObject)localObject2);
        localObject3 = bgpv.a((JSONObject)localObject3);
        ((UploaderProxy)ProxyManager.get(UploaderProxy.class)).upload(str1, (Map)localObject2, str3, str2, (String)localObject1, (Map)localObject3, 60, new FileJsPlugin.3(this, i, parambgok, l, localFile));
        this.uploadMap.put(Integer.valueOf(i), str1);
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("uploadTaskId", i);
          localObject1 = bgop.a(parambgok.jdField_a_of_type_JavaLangString, (JSONObject)localObject1).toString();
          return localObject1;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          QMLog.e("FileJsPlugin", parambgok.jdField_a_of_type_JavaLangString + " return error.", localThrowable);
        }
      }
    }
    catch (JSONException parambgok)
    {
      for (;;)
      {
        parambgok.printStackTrace();
      }
    }
    return "";
  }
  
  /* Error */
  public void getFileInfo(bgok parambgok)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 252	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: getfield 385	bgok:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokespecial 386	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: ldc_w 388
    //   19: invokevirtual 391	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 5
    //   24: aload_3
    //   25: ldc_w 601
    //   28: ldc_w 603
    //   31: invokevirtual 398	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_3
    //   35: invokestatic 143	bgnt:a	()Lbgnt;
    //   38: aload 5
    //   40: invokevirtual 555	bgnt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 7
    //   45: ldc_w 603
    //   48: aload_3
    //   49: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifne +167 -> 219
    //   55: ldc_w 605
    //   58: aload_3
    //   59: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +162 -> 224
    //   65: goto +154 -> 219
    //   68: aload 7
    //   70: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   73: ifne +136 -> 209
    //   76: iload_2
    //   77: ifeq +132 -> 209
    //   80: new 284	java/io/File
    //   83: dup
    //   84: aload 7
    //   86: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 5
    //   91: new 252	org/json/JSONObject
    //   94: dup
    //   95: invokespecial 500	org/json/JSONObject:<init>	()V
    //   98: astore 6
    //   100: ldc_w 605
    //   103: aload_3
    //   104: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +52 -> 159
    //   110: aload 7
    //   112: invokestatic 608	bgpr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: ifnull +9 -> 126
    //   120: aload_3
    //   121: invokevirtual 611	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   124: astore 4
    //   126: aload 6
    //   128: ldc_w 613
    //   131: aload 4
    //   133: invokevirtual 504	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload 6
    //   139: ldc_w 615
    //   142: aload 5
    //   144: invokevirtual 617	java/io/File:length	()J
    //   147: invokevirtual 620	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_1
    //   152: aload 6
    //   154: invokevirtual 256	bgok:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   157: pop
    //   158: return
    //   159: aload 7
    //   161: invokestatic 625	com/tencent/qqmini/sdk/utils/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore_3
    //   165: goto -49 -> 116
    //   168: astore_3
    //   169: ldc 56
    //   171: new 226	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 627
    //   181: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_3
    //   185: invokevirtual 276	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 458	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_1
    //   198: invokevirtual 629	bgok:b	()Ljava/lang/String;
    //   201: pop
    //   202: return
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 414	org/json/JSONException:printStackTrace	()V
    //   208: return
    //   209: aload_1
    //   210: aconst_null
    //   211: ldc_w 631
    //   214: invokevirtual 245	bgok:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
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
    //   0	229	1	parambgok	bgok
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
  
  public String getSavedFileInfo(bgok parambgok)
  {
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optString("filePath");
        localObject2 = bgnt.a().a((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists()) {
          continue;
        }
        localObject1 = new JSONObject();
      }
      catch (JSONException parambgok)
      {
        Object localObject1;
        Object localObject2;
        parambgok.printStackTrace();
        continue;
        parambgok.a(null, "no such file" + localThrowable);
        continue;
        parambgok.a(null, "no such file" + localThrowable);
        continue;
      }
      try
      {
        ((JSONObject)localObject1).put("size", ((File)localObject2).length());
        ((JSONObject)localObject1).put("createTime", ((File)localObject2).lastModified() / 1000L);
        parambgok.a((JSONObject)localObject1);
        return "";
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        parambgok.b();
      }
    }
  }
  
  public String getSavedFileList(bgok parambgok)
  {
    Object localObject1 = bgnt.a().a();
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
        parambgok.b();
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
        localJSONObject.put("filePath", bgnt.a().e(localObject2.getAbsolutePath()));
        localJSONObject.put("size", localObject2.length());
        localJSONObject.put("createTime", localObject2.lastModified() / 1000L);
        localJSONArray.put(localJSONObject);
      }
    }
    else
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("fileList", localJSONArray);
      parambgok.a((JSONObject)localObject1);
      return "";
    }
  }
  
  public String mkdir(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("dirPath");
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.8(this, str, localJSONObject, parambgok));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "{}";
  }
  
  public void onDestroy()
  {
    bgxm.a();
    super.onDestroy();
  }
  
  public String operateDownloadTask(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("downloadTaskId");
      if (("abort".equals(localJSONObject.optString("operationType"))) && (this.downloadMap.containsKey(str)))
      {
        ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).abort((String)this.downloadMap.get(str));
        localJSONObject = new JSONObject();
      }
      return "";
    }
    catch (JSONException parambgok)
    {
      try
      {
        localJSONObject.put("downloadTaskId", str);
        parambgok = bgop.a(parambgok.jdField_a_of_type_JavaLangString, localJSONObject).toString();
        return parambgok;
      }
      catch (Throwable parambgok)
      {
        break label106;
      }
      parambgok = parambgok;
      parambgok.printStackTrace();
    }
  }
  
  public String operateUploadTask(bgok parambgok)
  {
    try
    {
      parambgok = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      int i = parambgok.optInt("uploadTaskId");
      if (("abort".equals(parambgok.optString("operationType"))) && (this.uploadMap.containsKey(Integer.valueOf(i)))) {
        ((UploaderProxy)ProxyManager.get(UploaderProxy.class)).abort((String)this.uploadMap.get(Integer.valueOf(i)));
      }
      return "";
    }
    catch (JSONException parambgok)
    {
      for (;;)
      {
        parambgok.printStackTrace();
      }
    }
  }
  
  public String readFile(bgok parambgok)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new bgpf(parambgok.jdField_b_of_type_JavaLangString);
      String str2 = ((bgpf)localObject).optString("filePath");
      String str1 = ((bgpf)localObject).optString("encoding", "__internal__array_buffer");
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "__internal__array_buffer";
      }
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.9(this, str2, parambgok, (String)localObject, l));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "{}";
  }
  
  public String readdir(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("dirPath");
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.10(this, str, localJSONObject, parambgok));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "";
  }
  
  public String removeSavedFile(bgok parambgok)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
        String str = ((JSONObject)localObject).optString("filePath");
        if ((TextUtils.isEmpty(str)) || (((JSONObject)localObject).isNull("filePath"))) {
          return handleCallbackFail(parambgok, null, "fail parameter error: parameter.dirPath should be String instead of Null;");
        }
        if (bgnt.a().a(str) != 1) {
          continue;
        }
        localObject = bgnt.a().a(str);
        if (!bgpc.b((String)localObject)) {
          continue;
        }
        bgpc.a((String)localObject, false);
        parambgok.a();
      }
      catch (JSONException parambgok)
      {
        parambgok.printStackTrace();
        continue;
        parambgok.a(null, "not a store filePath");
        continue;
      }
      return "";
      parambgok.a(null, "not a store filePath");
    }
  }
  
  public String rename(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("oldPath");
      localObject = ((JSONObject)localObject).optString("newPath");
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.11(this, str, parambgok, (String)localObject));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "";
  }
  
  public String rmdir(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("dirPath");
      boolean bool = localJSONObject.optBoolean("recursive");
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.12(this, str, localJSONObject, parambgok, bool));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "";
  }
  
  public String saveFile(bgok parambgok)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("tempFilePath");
      localObject = ((JSONObject)localObject).optString("filePath");
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.6(this, str, parambgok, (String)localObject, l));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "";
  }
  
  public String stat(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = localJSONObject.optString("path");
      boolean bool = localJSONObject.optBoolean("recursive");
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.13(this, str, parambgok, bool));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "{}";
  }
  
  public String unlink(bgok parambgok)
  {
    try
    {
      String str = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optString("filePath");
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.14(this, str, parambgok));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "";
  }
  
  public String unzip(bgok parambgok)
  {
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject).optString("zipFilePath");
      localObject = ((JSONObject)localObject).optString("targetPath");
      parambgok = execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.15(this, str, parambgok, (String)localObject, l));
      return parambgok;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "";
  }
  
  public String writeFile(bgok parambgok)
  {
    byte[] arrayOfByte = null;
    long l = System.currentTimeMillis();
    try
    {
      Object localObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str2 = ((JSONObject)localObject).optString("filePath");
      if (((JSONObject)localObject).isNull("data")) {}
      for (String str1 = null;; str1 = ((JSONObject)localObject).optString("data"))
      {
        String str3 = ((JSONObject)localObject).optString("encoding", "utf8");
        localObject = bgpi.a(this.mMiniAppContext, (JSONObject)localObject, "data");
        if (localObject != null) {
          arrayOfByte = ((bgpi)localObject).a;
        }
        return execFileTask(parambgok.jdField_a_of_type_JavaLangString, new FileJsPlugin.16(this, str1, arrayOfByte, parambgok, str3, str2, l));
      }
      return "";
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin
 * JD-Core Version:    0.7.0.1
 */