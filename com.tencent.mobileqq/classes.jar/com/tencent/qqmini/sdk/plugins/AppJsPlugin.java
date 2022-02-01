package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class AppJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_DOWNLOAD_APP = "startDownloadAppTask";
  private static final String EVENT_DOWNLOAD_APP_CANCEL = "cancelDownloadAppTask";
  private static final String EVENT_INSTALL_APP = "installApp";
  private static final String EVENT_IS_MICROAPP_INSTALLED = "isMicroAppInstalled";
  private static final String EVENT_QUERY_APP_INFO = "queryAppInfo";
  private static final String EVENT_QUERY_DOWNLOAD_INFO = "queryDownloadAppTask";
  private static final String EVENT_START_APP = "startApp";
  private static final String TAG = "AppJsPlugin";
  private ThirdAppProxy mThirdAppProxy = (ThirdAppProxy)ProxyManager.get(ThirdAppProxy.class);
  
  @JsEvent({"cancelDownloadAppTask"})
  public String cancelDownloadAppTask(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams).optString("appid");
      localJSONObject.put("appid", localObject);
      if (this.mThirdAppProxy.stopDownloadTask((String)localObject))
      {
        localObject = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject).toString());
      }
      for (;;)
      {
        return "";
        localObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject).toString());
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("AppJsPlugin", "cancelDownloadAppTask Throwable:", localThrowable);
        localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
      }
    }
  }
  
  @JsEvent({"installApp"})
  public String installApp(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      ((JSONObject)localObject).optString("packagename");
      localObject = ((JSONObject)localObject).optString("appid");
      this.mThirdAppProxy.installApp((String)localObject, new AppJsPlugin.4(this, paramRequestEvent));
      return "";
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("AppJsPlugin", "installApp", localThrowable);
        JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
      }
    }
  }
  
  @JsEvent({"isMicroAppInstalled"})
  public void isMicroAppInstalled(RequestEvent paramRequestEvent)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getNativeAppInfoForJump(this.mMiniAppContext.getMiniAppInfo().appId, "", "", 100, new AppJsPlugin.5(this, paramRequestEvent));
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
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
  
  @JsEvent({"queryAppInfo"})
  public String queryAppInfo(RequestEvent paramRequestEvent)
  {
    try
    {
      str = new JSONObject(paramRequestEvent.jsonParams).optString("packagename");
      localPackageManager = this.mMiniAppContext.getContext().getPackageManager();
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
        QMLog.e("AppJsPlugin", "queryAppInfo throwable:", localThrowable);
        JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
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
      localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject2);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
    }
    for (;;)
    {
      return "";
      localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "not such package");
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
    }
  }
  
  @JsEvent({"queryDownloadAppTask"})
  public String queryDownloadAppTask(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("appid");
      this.mThirdAppProxy.queryDownloadTask(str, new AppJsPlugin.3(this, paramRequestEvent));
      return "";
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("AppJsPlugin", "queryDownloadAppTask Throwable:", localThrowable);
        JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
      }
    }
  }
  
  @JsEvent({"startApp"})
  public String startApp(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      str1 = ((JSONObject)localObject1).optString("packagename");
      str2 = ((JSONObject)localObject1).optString("path");
      localPackageManager = this.mMiniAppContext.getContext().getPackageManager();
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
        QMLog.e("AppJsPlugin", "startApp throwable:", localThrowable);
        JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
        continue;
        localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
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
          this.mMiniAppContext.getAttachedActivity().startActivity((Intent)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject2);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
        return "";
        QMLog.e("AppJsPlugin", "找不到指定的 Activity");
        localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "can not find activity.");
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
        return "";
        localObject1 = localPackageManager.getLaunchIntentForPackage(((PackageInfo)localObject1).packageName);
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_miniapp");
        this.mMiniAppContext.getAttachedActivity().startActivity((Intent)localObject1);
      }
    }
  }
  
  @JsEvent({"startDownloadAppTask"})
  public String startDownloadAppTask(RequestEvent paramRequestEvent)
  {
    Object localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localObject != null) && (((ChannelProxy)localObject).isGooglePlayVersion()))
    {
      int i;
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_download_switch", 0) == 1) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          AppBrandTask.runTaskOnUiThread(new AppJsPlugin.1(this));
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("retCode", -123);
            ((JSONObject)localObject).put("errMsg", "googlePlay download no supported!");
            localObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject);
            paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject).toString());
            return "";
            i = 0;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = ((JSONObject)localObject).optString("packagename");
      String str2 = ((JSONObject)localObject).optString("appid");
      String str3 = ((JSONObject)localObject).optString("version");
      String str4 = ((JSONObject)localObject).optString("md5");
      boolean bool = ((JSONObject)localObject).optBoolean("autoInstall");
      if (!TextUtils.isEmpty(str2)) {
        this.mThirdAppProxy.queryApkDownloadInfo(str2, new AppJsPlugin.2(this, paramRequestEvent, str2, bool, str1, str3, str4));
      }
      for (;;)
      {
        return "";
        localObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject).toString());
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("AppJsPlugin", "startDownloadAppTask throwable:", localThrowable);
        JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppJsPlugin
 * JD-Core Version:    0.7.0.1
 */