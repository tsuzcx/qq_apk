package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher.FragmentType;
import org.json.JSONObject;

public class NavigationJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NavigationJsPlugin";
  private static final int navigateBackByAPPInfo = WnsConfig.getConfig("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);
  private NavigationProxy navigationProxy = (NavigationProxy)ProxyManager.get(NavigationProxy.class);
  
  private static void navigateBackMiniApp(Activity paramActivity, String paramString, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_appid", paramString);
    if (paramLaunchParam != null)
    {
      paramLaunchParam.fromBackToMiniApp = 1;
      localIntent.putExtra("mini_launch_param", paramLaunchParam);
    }
    localIntent.putExtra("mini_receiver", paramResultReceiver);
    localIntent.putExtra("public_fragment_window_feature", 1);
    MiniFragmentLauncher.startTranslucent(paramActivity, localIntent, MiniFragmentLauncher.FragmentType.FRAGMENT_APPINFO_LOADING);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void navigateBackMiniApp(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, ResultReceiver paramResultReceiver)
  {
    MiniAppInfo localMiniAppInfo = MiniAppInfo.copy(paramMiniAppInfo);
    localMiniAppInfo.launchParam.miniAppId = paramMiniAppInfo.appId;
    localMiniAppInfo.launchParam.scene = 1038;
    localMiniAppInfo.launchParam.navigateExtData = paramString1;
    localMiniAppInfo.launchParam.privateExtraData = paramString2;
    localMiniAppInfo.launchParam.fromBackToMiniApp = 1;
    localMiniAppInfo.launchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
    MiniSDK.startMiniApp(this.mMiniAppContext.getAttachedActivity(), localMiniAppInfo, new Bundle(), paramResultReceiver);
  }
  
  private boolean navigateBackMiniApp(String paramString1, String paramString2, String paramString3)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.privateExtraData = paramString3;
    localLaunchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
    navigateBackMiniApp(this.mMiniAppContext.getAttachedActivity(), paramString1, localLaunchParam, new NavigationJsPlugin.4(this, new Handler(Looper.getMainLooper())));
    return true;
  }
  
  private void navigateToMiniProgramByAppid(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    int j = paramJSONObject.optInt("openType");
    String str1 = paramJSONObject.optString("appId");
    int i = 2001;
    if (j == 0)
    {
      String str2 = paramJSONObject.optString("path");
      Object localObject = paramJSONObject.optJSONObject("extraData");
      LaunchParam localLaunchParam = new LaunchParam();
      if (!this.mMiniAppInfo.isAppStoreMiniApp()) {
        i = 1037;
      }
      localLaunchParam.scene = i;
      localLaunchParam.entryPath = str2;
      if (localObject != null) {
        localObject = ((JSONObject)localObject).toString();
      } else {
        localObject = "";
      }
      localLaunchParam.navigateExtData = ((String)localObject);
      localLaunchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
      localLaunchParam.entryModel = this.mMiniAppInfo.launchParam.entryModel;
      paramJSONObject = paramJSONObject.optString("envVersion");
      localLaunchParam.envVersion = paramJSONObject;
      if ((!this.mMiniAppInfo.isSpecialMiniApp()) && (navigateBackByAPPInfo == 1))
      {
        localLaunchParam.fromEnvVersion = this.mMiniAppInfo.getVerTypeStr();
        localLaunchParam.fromMiniAppInfo = MiniAppInfo.copy(this.mMiniAppInfo);
      }
      localLaunchParam.reportData = paramString;
      MiniSDK.startMiniApp(this.mMiniAppContext.getAttachedActivity(), str1, localLaunchParam.scene, str2, paramJSONObject, localLaunchParam, new NavigationJsPlugin.1(this, new Handler(Looper.getMainLooper()), paramRequestEvent));
      paramRequestEvent.ok();
      return;
    }
    paramString = new LaunchParam();
    if (!this.mMiniAppInfo.isAppStoreMiniApp()) {
      i = 1037;
    }
    paramString.scene = i;
    if (this.navigationProxy.launchByAppType(j, this.mMiniAppContext.getAttachedActivity(), str1, paramString.scene, paramJSONObject, new NavigationJsPlugin.2(this, new Handler(Looper.getMainLooper()), paramRequestEvent)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"exitMiniProgram"})
  public void exitMiniProgram(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NavigationJsPlugin.5(this, this.mMiniAppContext.getAttachedActivity()));
    paramRequestEvent.ok();
  }
  
  @JsEvent({"navigateBackMiniProgram"})
  public void navigateBackMiniProgram(RequestEvent paramRequestEvent)
  {
    new JSONObject();
    String str1;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("NavigationJsPlugin", localThrowable.getMessage(), localThrowable);
      str1 = null;
    }
    int i = navigateBackByAPPInfo;
    String str2;
    Object localObject;
    if (i == 0)
    {
      if (str1 != null)
      {
        str2 = str1.optString("extraData");
        str1 = str1.optString("privateExtraData");
        localObject = this.mMiniAppInfo.launchParam.fromMiniAppId;
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (navigateBackMiniApp((String)localObject, str2, str1)))
        {
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail();
      }
    }
    else if ((i == 1) && (str1 != null))
    {
      str2 = str1.optString("extraData");
      str1 = str1.optString("privateExtraData");
      localObject = this.mMiniAppInfo.launchParam.fromMiniAppInfo;
      if (localObject != null) {
        navigateBackMiniApp((MiniAppInfo)localObject, str2, str1, new NavigationJsPlugin.3(this, new Handler(Looper.getMainLooper()), paramRequestEvent));
      }
    }
  }
  
  @JsEvent({"navigateToMiniProgram"})
  public void navigateToMiniProgram(RequestEvent paramRequestEvent)
  {
    Object localObject1 = "";
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("NavigationJsPlugin", "", localThrowable);
      localJSONObject2 = null;
    }
    this.navigationProxy.onBeforeNavigateToMiniProgram();
    String str;
    Object localObject2;
    EntryModel localEntryModel;
    if (localJSONObject2 != null)
    {
      str = localJSONObject2.optString("reportData");
      localObject2 = MiniAppInfo.createMiniAppInfo(localJSONObject2.optJSONObject("appInfo"));
      localEntryModel = this.mMiniAppInfo.launchParam.entryModel;
      if ((localObject2 == null) || (!this.mMiniAppInfo.appMode.useAppInfoWhenNavigate)) {}
    }
    for (;;)
    {
      try
      {
        if (WnsConfig.getConfig("qqminiapp", "miniappsearchappid", "1109875297").equals(this.mMiniAppInfo.appId))
        {
          i = 2077;
        }
        else
        {
          if (!this.mMiniAppInfo.isAppStoreMiniApp()) {
            break label348;
          }
          i = 2001;
        }
        JSONObject localJSONObject3 = localJSONObject2.optJSONObject("extraData");
        if (localJSONObject3 != null) {
          localObject1 = localJSONObject3.toString();
        }
        LaunchParam localLaunchParam = new LaunchParam();
        localLaunchParam.scene = i;
        localLaunchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
        localLaunchParam.navigateExtData = ((String)localObject1);
        if (localEntryModel != null) {
          localLaunchParam.entryModel = localEntryModel;
        }
        ((MiniAppInfo)localObject2).launchParam.clone(localLaunchParam);
        MiniSDK.startMiniApp(this.mMiniAppContext.getAttachedActivity(), (MiniAppInfo)localObject2);
        paramRequestEvent.ok();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("navigateToMiniProgram, open miniApp from appInfo, appInfo: ");
        ((StringBuilder)localObject1).append(((MiniAppInfo)localObject2).toString());
        QMLog.d("NavigationJsPlugin", ((StringBuilder)localObject1).toString());
        if (((MiniAppInfo)localObject2).verType == 3) {
          this.navigationProxy.onAfterLaunchByAppInfo(localJSONObject3);
        }
        return;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("navigateToMiniProgram, ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QMLog.e("NavigationJsPlugin", ((StringBuilder)localObject2).toString(), localException);
      }
      navigateToMiniProgramByAppid(paramRequestEvent, localJSONObject2, str);
      return;
      label348:
      int i = 1037;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */