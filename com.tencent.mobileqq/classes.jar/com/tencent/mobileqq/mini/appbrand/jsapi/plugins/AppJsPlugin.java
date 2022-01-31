package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.MD5;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
  public static final String FOLDER = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/app_download/";
  private static final Set<String> S_EVENT_MAP = new AppJsPlugin.1();
  private static final String TAG = "AppJsPlugin";
  private static final String VIA = "SmallGame";
  private AppJsPlugin.AppDownloadManager mAppDownloadManager;
  
  private File getAkgCacheFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new File(FOLDER + File.separator + MD5.toMD5(paramString) + ".apk");
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if ("startDownloadAppTask".equals(paramString1)) {}
    Object localObject4;
    Object localObject5;
    Object localObject6;
    for (;;)
    {
      String str1;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        str1 = localJSONObject.optString("packagename");
        localObject4 = localJSONObject.optString("appid");
        localObject5 = localJSONObject.optString("version");
        localObject6 = localJSONObject.optString("md5");
        boolean bool = localJSONObject.optBoolean("autoInstall");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          this.mAppDownloadManager.queryApkDownloadInfo((String)localObject4, new AppJsPlugin.2(this, paramString1, paramJsRuntime, paramInt, (String)localObject4, bool, str1, (String)localObject5, (String)localObject6));
          return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
        }
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        continue;
      }
      catch (Throwable localThrowable1)
      {
        QZLog.e("AppJsPlugin", 1, localThrowable1, new Object[0]);
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        continue;
      }
      Object localObject1;
      if ("cancelDownloadAppTask".equals(paramString1))
      {
        localObject1 = new JSONObject();
        try
        {
          str1 = new JSONObject(paramString2).optString("appid");
          ((JSONObject)localObject1).put("appid", str1);
          if (!this.mAppDownloadManager.stopDownloadTask(str1)) {
            break label274;
          }
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject1).toString());
        }
        catch (Throwable localThrowable6)
        {
          QZLog.e("AppJsPlugin", 1, localThrowable6, new Object[0]);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, (JSONObject)localObject1).toString());
        }
        continue;
        label274:
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, (JSONObject)localObject1).toString());
      }
      else
      {
        if (!"queryDownloadAppTask".equals(paramString1)) {
          break;
        }
        try
        {
          localObject1 = new JSONObject(paramString2).optString("appid");
          AppJsPlugin.AppDownloadManager.access$100(this.mAppDownloadManager, (String)localObject1, new AppJsPlugin.3(this, (String)localObject1, paramString1, paramJsRuntime, paramInt));
        }
        catch (Throwable localThrowable2)
        {
          QZLog.e("AppJsPlugin", 1, localThrowable2, new Object[0]);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        }
      }
    }
    if ("queryAppInfo".equals(paramString1)) {}
    for (;;)
    {
      String str2;
      for (;;)
      {
        try
        {
          str2 = new JSONObject(paramString2).optString("packagename");
          localObject4 = this.jsPluginEngine.activityContext.getPackageManager();
          localObject5 = ((PackageManager)localObject4).getInstalledPackages(0).iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break label1067;
          }
          PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject5).next();
          if ((localPackageInfo.packageName == null) || (!localPackageInfo.packageName.equals(str2))) {
            continue;
          }
          if (localPackageInfo == null) {
            break label595;
          }
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("packagename", str2);
          ((JSONObject)localObject5).put("appName", localPackageInfo.applicationInfo.loadLabel((PackageManager)localObject4).toString());
          ((JSONObject)localObject5).put("versionCode", localPackageInfo.versionCode);
          ((JSONObject)localObject5).put("versionName", localPackageInfo.versionName);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject5).toString());
        }
        catch (Throwable localThrowable3)
        {
          QZLog.e("AppJsPlugin", 1, localThrowable3, new Object[0]);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        }
        break;
        label595:
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null, "not such package").toString());
        break;
        if (!"installApp".equals(paramString1)) {
          break label711;
        }
        try
        {
          Object localObject2 = new JSONObject(paramString2);
          ((JSONObject)localObject2).optString("packagename");
          localObject2 = ((JSONObject)localObject2).optString("appid");
          this.mAppDownloadManager.installApp((String)localObject2, new AppJsPlugin.4(this, paramString1, paramJsRuntime, paramInt));
        }
        catch (Throwable localThrowable4)
        {
          QZLog.e("AppJsPlugin", 1, localThrowable4, new Object[0]);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        }
      }
      break;
      label711:
      if (!"startApp".equals(paramString1)) {
        break;
      }
      for (;;)
      {
        try
        {
          Object localObject3 = new JSONObject(paramString2);
          str2 = ((JSONObject)localObject3).optString("packagename");
          localObject4 = ((JSONObject)localObject3).optString("path");
          localObject5 = this.jsPluginEngine.activityContext.getPackageManager();
          localObject6 = ((PackageManager)localObject5).getInstalledPackages(0).iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break label1061;
          }
          localObject3 = (PackageInfo)((Iterator)localObject6).next();
          if ((((PackageInfo)localObject3).packageName == null) || (!((PackageInfo)localObject3).packageName.equals(str2))) {
            continue;
          }
          if (localObject3 == null) {
            break label1042;
          }
          localObject6 = new JSONObject();
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label1003;
          }
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_miniapp");
          ((Intent)localObject3).setFlags(268435456);
          ((Intent)localObject3).setComponent(new ComponentName(str2, (String)localObject4));
          if (((Intent)localObject3).resolveActivityInfo((PackageManager)localObject5, 65536) == null) {
            break label964;
          }
          this.jsPluginEngine.activityContext.startActivity((Intent)localObject3);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject6).toString());
        }
        catch (Throwable localThrowable5)
        {
          QZLog.e("AppJsPlugin", 1, localThrowable5, new Object[0]);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        }
        break;
        label964:
        QZLog.e("AppJsPlugin", 1, new Object[] { "找不到指定的 Activity" });
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null, "can not find activity.").toString());
        return "";
        label1003:
        localIntent = ((PackageManager)localObject5).getLaunchIntentForPackage(localThrowable5.packageName);
        localIntent.putExtra("big_brother_source_key", "biz_src_miniapp");
        this.jsPluginEngine.activityContext.startActivity(localIntent);
        continue;
        label1042:
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        break;
        label1061:
        localIntent = null;
      }
      label1067:
      Intent localIntent = null;
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mAppDownloadManager = new AppJsPlugin.AppDownloadManager(this, paramBaseJsPluginEngine.activityContext);
  }
  
  public void onDestroy()
  {
    if (this.mAppDownloadManager != null) {
      this.mAppDownloadManager.unInit();
    }
    super.onDestroy();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin
 * JD-Core Version:    0.7.0.1
 */