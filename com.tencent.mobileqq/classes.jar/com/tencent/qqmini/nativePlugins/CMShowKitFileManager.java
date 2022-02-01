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
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
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
  private static JSONArray a = new JSONArray();
  private static ArrayList<String> b = new ArrayList();
  private static String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static String g = "download url is empty";
  private static String h = "cache exists";
  private static Timer i;
  private static Downloader.DownloadListener j;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/mini_cmshow/");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append("/dress/");
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append("/face/");
    f = localStringBuilder.toString();
  }
  
  private static String a(String paramString1, IMiniAppContext paramIMiniAppContext, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wxfile://tmp_cmshowCache/");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("/");
    paramString2 = ((StringBuilder)localObject).toString();
    paramIMiniAppContext = ((IMiniAppFileManager)paramIMiniAppContext.getManager(IMiniAppFileManager.class)).getTmpPathByWxFilePath(paramString2);
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
      localFile = new File(f);
    } else {
      localFile = new File(e);
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
      return h;
    }
    ((File)localObject).getParentFile().mkdirs();
    paramString1 = new DownloadTask(paramString1, (File)localObject);
    paramString1.N = true;
    paramString1.J = true;
    paramString1.e = 2;
    paramString1.P = true;
    paramString1.Q = true;
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
  
  private static Map<String, String> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject("avatar3D").getJSONArray("dress_infos");
      int k = 0;
      while (k < localJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)localJSONArray.get(k);
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
        k += 1;
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
      i = new Timer();
      i.schedule(new CMShowKitFileManager.1(), paramLong);
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
      QLog.e("CMShowKitFileManager", 1, g);
      c();
      return;
    }
    String str = a(paramString, "faceData");
    paramString = str;
    if (str.equals(h))
    {
      QLog.i("CMShowKitFileManager", 1, "read dressId faceData res from cache");
      paramString = new StringBuilder();
      paramString.append(f);
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
    c = a(paramString, paramIMiniAppContext, "faceData");
    if (TextUtils.isEmpty(c))
    {
      QLog.e("CMShowKitFileManager", 1, "copy error.");
      c();
      return;
    }
    try
    {
      paramJSONObject.put("local_face_data", c);
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
        QLog.e("CMShowKitFileManager", 1, g);
        c();
        return;
      }
      String str2 = (String)paramMap.get(localObject);
      String str1 = a((String)localObject, str2);
      localObject = str1;
      if (str1.equals(h))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("read dressId ");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(" res from cache");
        QLog.i("CMShowKitFileManager", 1, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(e);
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
      if (!a(a, (String)localObject)) {}
      try
      {
        a.put(localObject);
        paramJSONObject.put("local_dress_res", a);
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
      if ((a.length() == paramMap.keySet().size()) && (!TextUtils.isEmpty(c)))
      {
        j.onDownloadSucceed(null, null);
        b();
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, IMiniAppContext paramIMiniAppContext, Downloader.DownloadListener paramDownloadListener)
  {
    a(5000L);
    j = paramDownloadListener;
    a = new JSONArray();
    d();
    paramDownloadListener = b(paramJSONObject);
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
      QLog.e("CMShowKitFileManager", 1, g);
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
      int k = 0;
      while (k < paramJSONArray.length())
      {
        if (paramString.equals(paramJSONArray.optString(k))) {
          return true;
        }
        k += 1;
      }
    }
    return false;
  }
  
  private static String b(JSONObject paramJSONObject)
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
  
  private static void b()
  {
    try
    {
      if (i != null)
      {
        i.cancel();
        i = null;
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
    j.onDownloadFailed(null, null);
    b();
  }
  
  private static void d()
  {
    File localFile = new File(d);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowKitFileManager
 * JD-Core Version:    0.7.0.1
 */