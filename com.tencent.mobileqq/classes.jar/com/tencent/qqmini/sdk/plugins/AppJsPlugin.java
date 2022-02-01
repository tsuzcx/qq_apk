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
      else
      {
        localObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject).toString());
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppJsPlugin", "cancelDownloadAppTask Throwable:", localThrowable);
      localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
    }
    return "";
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
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppJsPlugin", "installApp", localThrowable);
      JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
    }
    return "";
  }
  
  @JsEvent({"isMicroAppInstalled"})
  public void isMicroAppInstalled(RequestEvent paramRequestEvent)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getNativeAppInfoForJump(this.mMiniAppContext.getMiniAppInfo().appId, "", "", 100, new AppJsPlugin.5(this, paramRequestEvent));
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    paramIMiniAppContext = this.mThirdAppProxy;
    if (paramIMiniAppContext != null) {
      paramIMiniAppContext.init();
    }
  }
  
  public void onDestroy()
  {
    ThirdAppProxy localThirdAppProxy = this.mThirdAppProxy;
    if (localThirdAppProxy != null) {
      localThirdAppProxy.unInit();
    }
    super.onDestroy();
  }
  
  @JsEvent({"queryAppInfo"})
  public String queryAppInfo(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramRequestEvent.jsonParams).optString("packagename");
        PackageManager localPackageManager = this.mMiniAppContext.getContext().getPackageManager();
        Object localObject2 = localPackageManager.getInstalledPackages(0).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label253;
        }
        Object localObject1 = (PackageInfo)((Iterator)localObject2).next();
        if ((((PackageInfo)localObject1).packageName == null) || (!((PackageInfo)localObject1).packageName.equals(str))) {
          continue;
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
        else
        {
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "not such package");
          paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("AppJsPlugin", "queryAppInfo throwable:", localThrowable);
        localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
      }
      return "";
      label253:
      JSONObject localJSONObject = null;
    }
  }
  
  @JsEvent({"queryDownloadAppTask"})
  public String queryDownloadAppTask(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("appid");
      this.mThirdAppProxy.queryDownloadTask(str, new AppJsPlugin.3(this, paramRequestEvent));
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppJsPlugin", "queryDownloadAppTask Throwable:", localThrowable);
      JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
    }
    return "";
  }
  
  @JsEvent({"startApp"})
  public String startApp(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        String str1 = ((JSONObject)localObject1).optString("packagename");
        String str2 = ((JSONObject)localObject1).optString("path");
        PackageManager localPackageManager = this.mMiniAppContext.getContext().getPackageManager();
        Object localObject2 = localPackageManager.getInstalledPackages(0).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (PackageInfo)((Iterator)localObject2).next();
          if ((((PackageInfo)localObject1).packageName == null) || (!((PackageInfo)localObject1).packageName.equals(str1))) {
            continue;
          }
          if (localObject1 != null)
          {
            localObject2 = new JSONObject();
            boolean bool = TextUtils.isEmpty(str2);
            if (!bool)
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_miniapp");
              ((Intent)localObject1).setFlags(268435456);
              ((Intent)localObject1).setComponent(new ComponentName(str1, str2));
              if (((Intent)localObject1).resolveActivityInfo(localPackageManager, 65536) != null)
              {
                this.mMiniAppContext.getAttachedActivity().startActivity((Intent)localObject1);
              }
              else
              {
                QMLog.e("AppJsPlugin", "找不到指定的 Activity");
                localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "can not find activity.");
                paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
                return "";
              }
            }
            else
            {
              localObject1 = localPackageManager.getLaunchIntentForPackage(((PackageInfo)localObject1).packageName);
              ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_miniapp");
              this.mMiniAppContext.getAttachedActivity().startActivity((Intent)localObject1);
            }
            localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject2);
            paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
            return "";
          }
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
          paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
          return "";
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("AppJsPlugin", "startApp throwable:", localThrowable);
        localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
        return "";
      }
      JSONObject localJSONObject = null;
    }
  }
  
  @JsEvent({"startDownloadAppTask"})
  public String startDownloadAppTask(RequestEvent paramRequestEvent)
  {
    Object localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localObject != null) && (((ChannelProxy)localObject).isGooglePlayVersion()))
    {
      int i = 0;
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_download_switch", 0) == 1) {
        i = 1;
      }
      if (i == 0)
      {
        AppBrandTask.runTaskOnUiThread(new AppJsPlugin.1(this));
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("retCode", -123);
          ((JSONObject)localObject).put("errMsg", "googlePlay download no supported!");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        localObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject).toString());
        return "";
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
      if (!TextUtils.isEmpty(str2))
      {
        this.mThirdAppProxy.queryApkDownloadInfo(str2, new AppJsPlugin.2(this, paramRequestEvent, str2, bool, str1, str3, str4));
        return "";
      }
      localObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject).toString());
      return "";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppJsPlugin", "startDownloadAppTask throwable:", localThrowable);
      JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppJsPlugin
 * JD-Core Version:    0.7.0.1
 */