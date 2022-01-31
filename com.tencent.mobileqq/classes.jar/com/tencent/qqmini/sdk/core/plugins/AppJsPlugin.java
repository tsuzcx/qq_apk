package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import begy;
import begz;
import beka;
import bekg;
import besl;
import com.tencent.qqmini.sdk.core.proxy.ThirdAppProxy;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AppJsPlugin
  extends BaseJsPlugin
{
  private static final String CHANNEL = "10036618";
  private static final String EVENT_DOWNLOAD_APP = "startDownloadAppTask";
  private static final String EVENT_DOWNLOAD_APP_CANCEL = "cancelDownloadAppTask";
  private static final String EVENT_INSTALL_APP = "installApp";
  private static final String EVENT_QUERY_APP_INFO = "queryAppInfo";
  private static final String EVENT_QUERY_DOWNLOAD_INFO = "queryDownloadAppTask";
  private static final String EVENT_START_APP = "startApp";
  private static final String TAG = "AppJsPlugin";
  private static final String VIA = "SmallGame";
  private ThirdAppProxy mThirdAppProxy;
  
  public String cancelDownloadAppTask(beka parambeka)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = new JSONObject(parambeka.jdField_b_of_type_JavaLangString).optString("appid");
      localJSONObject.put("appid", localObject);
      if (this.mThirdAppProxy.stopDownloadTask((String)localObject))
      {
        localObject = bekg.a(parambeka.jdField_a_of_type_JavaLangString, localJSONObject);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, ((JSONObject)localObject).toString());
      }
      for (;;)
      {
        return "";
        localObject = bekg.b(parambeka.jdField_a_of_type_JavaLangString, localJSONObject);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, ((JSONObject)localObject).toString());
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        besl.d("AppJsPlugin", "cancelDownloadAppTask Throwable:", localThrowable);
        localJSONObject = bekg.b(parambeka.jdField_a_of_type_JavaLangString, localJSONObject);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, localJSONObject.toString());
      }
    }
  }
  
  public String installApp(beka parambeka)
  {
    return "";
  }
  
  public void onCreate(begz parambegz)
  {
    super.onCreate(parambegz);
    if (this.mThirdAppProxy != null) {
      this.mThirdAppProxy.init();
    }
  }
  
  public void onDestroy()
  {
    if (this.mThirdAppProxy != null) {
      this.mThirdAppProxy.unInit();
    }
    super.onDestroy();
  }
  
  public String queryAppInfo(beka parambeka)
  {
    try
    {
      str = new JSONObject(parambeka.jdField_b_of_type_JavaLangString).optString("packagename");
      localPackageManager = this.mMiniAppContext.a().getPackageManager();
      localObject2 = localPackageManager.getInstalledPackages(0).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (PackageInfo)((Iterator)localObject2).next();
      } while ((((PackageInfo)localObject1).packageName == null) || (!((PackageInfo)localObject1).packageName.equals(str)));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str;
        PackageManager localPackageManager;
        Object localObject2;
        Object localObject1;
        besl.d("AppJsPlugin", "queryAppInfo throwable:", localThrowable);
        JSONObject localJSONObject = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, localJSONObject.toString());
        continue;
        localJSONObject = null;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("packagename", str);
      ((JSONObject)localObject2).put("appName", ((PackageInfo)localObject1).applicationInfo.loadLabel(localPackageManager).toString());
      ((JSONObject)localObject2).put("versionCode", ((PackageInfo)localObject1).versionCode);
      ((JSONObject)localObject2).put("versionName", ((PackageInfo)localObject1).versionName);
      localObject1 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, (JSONObject)localObject2);
      parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, ((JSONObject)localObject1).toString());
    }
    for (;;)
    {
      return "";
      localObject1 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "not such package");
      parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, ((JSONObject)localObject1).toString());
    }
  }
  
  public String queryDownloadAppTask(beka parambeka)
  {
    try
    {
      String str = new JSONObject(parambeka.jdField_b_of_type_JavaLangString).optString("appid");
      this.mThirdAppProxy.queryDownloadTask(str, new AppJsPlugin.2(this, parambeka));
      return "";
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        besl.d("AppJsPlugin", "queryDownloadAppTask Throwable:", localThrowable);
        JSONObject localJSONObject = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, localJSONObject.toString());
      }
    }
  }
  
  public String startApp(beka parambeka)
  {
    try
    {
      localObject1 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      str1 = ((JSONObject)localObject1).optString("packagename");
      str2 = ((JSONObject)localObject1).optString("path");
      localPackageManager = this.mMiniAppContext.a().getPackageManager();
      localObject2 = localPackageManager.getInstalledPackages(0).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (PackageInfo)((Iterator)localObject2).next();
      } while ((((PackageInfo)localObject1).packageName == null) || (!((PackageInfo)localObject1).packageName.equals(str1)));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        String str1;
        String str2;
        PackageManager localPackageManager;
        Object localObject2;
        besl.d("AppJsPlugin", "startApp throwable:", localThrowable);
        JSONObject localJSONObject = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, localJSONObject.toString());
        continue;
        localJSONObject = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, localJSONObject.toString());
        continue;
        localJSONObject = null;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new JSONObject();
      if (!TextUtils.isEmpty(str2))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_miniapp");
        ((Intent)localObject1).setFlags(268435456);
        ((Intent)localObject1).setComponent(new ComponentName(str1, str2));
        if (((Intent)localObject1).resolveActivityInfo(localPackageManager, 65536) != null) {
          this.mMiniAppContext.a().startActivity((Intent)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, (JSONObject)localObject2);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, ((JSONObject)localObject1).toString());
        return "";
        besl.d("AppJsPlugin", "找不到指定的 Activity");
        localObject1 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "can not find activity.");
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, ((JSONObject)localObject1).toString());
        return "";
        localObject1 = localPackageManager.getLaunchIntentForPackage(((PackageInfo)localObject1).packageName);
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_miniapp");
        this.mMiniAppContext.a().startActivity((Intent)localObject1);
      }
    }
  }
  
  public String startDownloadAppTask(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      String str1 = localJSONObject1.optString("packagename");
      String str2 = localJSONObject1.optString("appid");
      String str3 = localJSONObject1.optString("version");
      String str4 = localJSONObject1.optString("md5");
      boolean bool = localJSONObject1.optBoolean("autoInstall");
      if (!TextUtils.isEmpty(str2)) {
        this.mThirdAppProxy.queryApkDownloadInfo(str2, new AppJsPlugin.1(this, parambeka, str2, bool, str1, str3, str4));
      }
      for (;;)
      {
        return "";
        localJSONObject1 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, localJSONObject1.toString());
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        besl.d("AppJsPlugin", "startDownloadAppTask throwable:", localThrowable);
        JSONObject localJSONObject2 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, localJSONObject2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppJsPlugin
 * JD-Core Version:    0.7.0.1
 */