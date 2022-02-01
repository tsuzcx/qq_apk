package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CMShowKitFileManager
  extends BaseJsPlugin
{
  private static Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener;
  private static String jdField_a_of_type_JavaLangString;
  private static ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private static Timer jdField_a_of_type_JavaUtilTimer;
  private static JSONArray jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
  private static final String b;
  private static final String c;
  private static final String d;
  private static String e = "download url is empty";
  private static String f = "cache exists";
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/mini_cmshow/");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("/dress/");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("/face/");
    d = localStringBuilder.toString();
  }
  
  private static String a(String paramString1, IMiniAppContext paramIMiniAppContext, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wxfile://tmp_cmshowCache/");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("/");
    paramString2 = ((StringBuilder)localObject).toString();
    paramIMiniAppContext = ((MiniAppFileManager)paramIMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByWxFilePath(paramString2);
    localObject = new File(paramIMiniAppContext);
    if (((File)localObject).exists()) {
      FileUtils.delete(paramIMiniAppContext, true);
    }
    ((File)localObject).mkdirs();
    if (!new File(paramString1).exists())
    {
      QLog.e("CMShowKitFileManager", 1, "cache file not exist, copy to game file error.");
      return null;
    }
    FileUtils.copyDocumentItemsToAnotherDocument(paramString1, paramIMiniAppContext);
    return paramString2.replace("wxfile://tmp_", "qqfile://tmp_");
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      localObject = MD5Utils.toMD5(paramString1);
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkDownloadData e");
      ((StringBuilder)localObject).append(localException);
      QLog.e("CMShowKitFileManager", 1, ((StringBuilder)localObject).toString());
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    File localFile;
    if (paramString2 == "faceData") {
      localFile = new File(d);
    } else {
      localFile = new File(c);
    }
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".zip");
    Object localObject = new File(localStringBuilder.toString());
    if (((File)localObject).exists()) {
      return f;
    }
    ((File)localObject).getParentFile().mkdirs();
    paramString1 = new DownloadTask(paramString1, (File)localObject);
    paramString1.p = true;
    paramString1.n = true;
    paramString1.b = 2;
    paramString1.q = true;
    paramString1.r = true;
    if (DownloaderFactory.a(paramString1, null) == 0)
    {
      if (!((File)localObject).exists())
      {
        QLog.e("CMShowKitFileManager", 1, "CMShow kit zipFile download error, zipFile not exist.");
        return null;
      }
      try
      {
        paramString1 = new StringBuilder();
        paramString1.append(localFile.getAbsolutePath());
        paramString1.append(File.separator);
        paramString1.append(paramString2);
        paramString1.append(File.separator);
        paramString1 = paramString1.toString();
        paramString2 = new File(paramString1);
        if (paramString2.exists()) {
          FileUtils.deleteDirectory(paramString1);
        }
        paramString2.mkdirs();
        ZipUtils.unZipFile((File)localObject, paramString1);
        return paramString1;
      }
      catch (OutOfMemoryError paramString1)
      {
        ((File)localObject).delete();
        paramString2 = new StringBuilder();
        paramString2.append("checkDownloadData unZipFile file error resType->");
        paramString2.append(paramString1.getMessage());
        QLog.e("CMShowKitFileManager", 1, paramString2.toString());
        return null;
      }
      catch (Exception paramString1)
      {
        ((File)localObject).delete();
        paramString2 = new StringBuilder();
        paramString2.append("checkDownloadData unZipFile file error  error->");
        paramString2.append(paramString1.getMessage());
        QLog.e("CMShowKitFileManager", 1, paramString2.toString());
        return null;
      }
    }
    QLog.e("CMShowKitFileManager", 1, "downloadTask.FAIL");
    return null;
  }
  
  private static String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("CMShowKitFileManager", 1, "resultData is null");
      return "";
    }
    paramJSONObject = paramJSONObject.optString("extend_data");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      QLog.e("TAG", 1, "resultData.extend_data is empty!");
      return "";
    }
    return paramJSONObject.split(",")[3].split("\"")[3];
  }
  
  private static Map<String, String> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject("avatar3D").getJSONArray("dress_infos");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
        Object localObject;
        try
        {
          String str = String.valueOf(localJSONObject.optLong("dress_id"));
        }
        catch (Exception localException)
        {
          QLog.e("CMShowKitFileManager", 1, "dress_id cast to string error", localException);
          localObject = null;
        }
        localHashMap.put(localJSONObject.optString("dress_url"), localObject);
        i += 1;
      }
      paramJSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject("avatar3D").remove("dress_infos");
      return localHashMap;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  private static void a(long paramLong)
  {
    try
    {
      b();
      jdField_a_of_type_JavaUtilTimer = new Timer();
      jdField_a_of_type_JavaUtilTimer.schedule(new CMShowKitFileManager.1(), paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void a(String paramString, IMiniAppContext paramIMiniAppContext, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("CMShowKitFileManager", 1, e);
      c();
      return;
    }
    String str = a(paramString, "faceData");
    paramString = str;
    if (str.equals(f))
    {
      QLog.i("CMShowKitFileManager", 1, "read dressId faceData res from cache");
      paramString = new StringBuilder();
      paramString.append(d);
      paramString.append("/faceData/");
      File localFile = new File(paramString.toString());
      paramString = str;
      if (localFile.exists()) {
        paramString = localFile.getAbsolutePath();
      }
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("CMShowKitFileManager", 1, "download to cache fail.");
      c();
      return;
    }
    jdField_a_of_type_JavaLangString = a(paramString, paramIMiniAppContext, "faceData");
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      QLog.e("CMShowKitFileManager", 1, "copy error.");
      c();
      return;
    }
    try
    {
      paramJSONObject.put("local_face_data", jdField_a_of_type_JavaLangString);
      QLog.i("CMShowKitFileManager", 1, "gameFaceData ready.");
      return;
    }
    catch (JSONException paramString)
    {
      label174:
      break label174;
    }
    c();
  }
  
  private static void a(Map<String, String> paramMap, IMiniAppContext paramIMiniAppContext, JSONObject paramJSONObject)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("CMShowKitFileManager", 1, e);
        c();
        return;
      }
      String str2 = (String)paramMap.get(localObject);
      String str1 = a((String)localObject, str2);
      localObject = str1;
      if (str1.equals(f))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("read dressId ");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(" res from cache");
        QLog.i("CMShowKitFileManager", 1, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(c);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append("/");
        File localFile = new File(((StringBuilder)localObject).toString());
        localObject = str1;
        if (localFile.exists()) {
          localObject = localFile.getAbsolutePath();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("CMShowKitFileManager", 1, "download to cache fail.");
        c();
        return;
      }
      localObject = a((String)localObject, paramIMiniAppContext, str2);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("CMShowKitFileManager", 1, "copy to game file error.");
        c();
        return;
      }
      if (!a(jdField_a_of_type_OrgJsonJSONArray, (String)localObject)) {}
      try
      {
        jdField_a_of_type_OrgJsonJSONArray.put(localObject);
        paramJSONObject.put("local_dress_res", jdField_a_of_type_OrgJsonJSONArray);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dressRes id : ");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(" ready");
        QLog.i("CMShowKitFileManager", 1, ((StringBuilder)localObject).toString());
      }
      catch (JSONException paramMap)
      {
        label317:
        break label317;
      }
      c();
      return;
      if ((jdField_a_of_type_OrgJsonJSONArray.length() == paramMap.keySet().size()) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)))
      {
        jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadSucceed(null, null);
        b();
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, IMiniAppContext paramIMiniAppContext, Downloader.DownloadListener paramDownloadListener)
  {
    a(5000L);
    jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = paramDownloadListener;
    jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
    d();
    paramDownloadListener = a(paramJSONObject);
    Map localMap = a(paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject("avatar3D");
      paramJSONObject.put("local_face_data", null);
      paramJSONObject.put("local_dress_res", null);
      if ((!TextUtils.isEmpty(paramDownloadListener)) && (localMap != null) && (localMap.size() != 0))
      {
        a(paramDownloadListener, paramIMiniAppContext, paramJSONObject);
        a(localMap, paramIMiniAppContext, paramJSONObject);
        return;
      }
      QLog.e("CMShowKitFileManager", 1, e);
      c();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("CMShowKitFileManager", 1, paramJSONObject, new Object[0]);
      c();
    }
  }
  
  private static boolean a(JSONArray paramJSONArray, String paramString)
  {
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() == 0) {
        return false;
      }
      int i = 0;
      while (i < paramJSONArray.length())
      {
        if (paramString.equals(paramJSONArray.optString(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static void b()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilTimer != null)
      {
        jdField_a_of_type_JavaUtilTimer.cancel();
        jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void c()
  {
    QLog.i("CMShowKitFileManager", 1, "callBackError.");
    jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadFailed(null, null);
    b();
  }
  
  private static void d()
  {
    File localFile = new File(b);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowKitFileManager
 * JD-Core Version:    0.7.0.1
 */