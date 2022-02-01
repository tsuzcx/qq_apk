package com.tencent.qqmini.proxyimpl;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.ext.GameProxy;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

@JsPlugin
public class NavigationJsPlugin
  extends BaseJsPlugin
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);
  private WnsConfigProxy jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWnsConfigProxy = (WnsConfigProxy)AppLoaderFactory.g().getProxyManager().get(WnsConfigProxy.class);
  
  private void a(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new NavigationJsPlugin.4(this, paramMiniAppInfo), 32, null, true);
  }
  
  private void a(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.miniAppId = paramMiniAppInfo.appId;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString1;
    localLaunchParam.privateExtraData = paramString2;
    localLaunchParam.fromBackToMiniApp = 1;
    localLaunchParam.fromMiniAppId = this.mApkgInfo.appId;
    paramMiniAppInfo = new MiniAppConfig(paramMiniAppInfo);
    paramMiniAppInfo.launchParam = localLaunchParam;
    MiniAppController.startApp(this.mMiniAppContext.getAttachedActivity(), paramMiniAppInfo, new NavigationJsPlugin.6(this, new Handler(Looper.getMainLooper()), paramMiniAppLaunchListener));
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.privateExtraData = paramString3;
    localLaunchParam.fromMiniAppId = this.mApkgInfo.appId;
    paramString2 = this.mMiniAppContext.getAttachedActivity();
    MiniAppController.navigateBackMiniApp(paramString2, paramString1, localLaunchParam, new NavigationJsPlugin.5(this, paramString2));
    return true;
  }
  
  @JsEvent({"exitMiniProgram"})
  public void exitMiniProgram(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NavigationJsPlugin.1(this, this.mMiniAppContext.getAttachedActivity()));
    paramRequestEvent.ok();
  }
  
  @JsEvent({"navigateBackMiniProgram"})
  public void navigateBackMiniProgram(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = jdField_a_of_type_Int;
      String str;
      Object localObject2;
      if (i == 0)
      {
        str = ((JSONObject)localObject1).optString("extraData");
        localObject1 = ((JSONObject)localObject1).optString("privateExtraData");
        localObject2 = this.mMiniAppInfo.launchParam.fromMiniAppId;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (a((String)localObject2, str, (String)localObject1)))
        {
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail();
        return;
      }
      if (jdField_a_of_type_Int == 1)
      {
        str = ((JSONObject)localObject1).optString("extraData");
        localObject1 = ((JSONObject)localObject1).optString("privateExtraData");
        localObject2 = MiniSdkLauncher.convert(this.mMiniAppInfo.launchParam.fromMiniAppInfo);
        if (localObject2 != null)
        {
          a((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2, str, (String)localObject1, new NavigationJsPlugin.2(this, paramRequestEvent));
          return;
        }
      }
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("NavigationJsPlugin", 1, "navigateBackMiniProgram error, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"navigateToMiniProgram"})
  public void navigateToMiniProgram(RequestEvent paramRequestEvent)
  {
    Object localObject1;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("NavigationJsPlugin", 1, localThrowable.getMessage(), localThrowable);
      localObject1 = null;
    }
    String str2;
    Object localObject5;
    com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo1;
    EntryModel localEntryModel;
    String str1;
    if (localObject1 != null)
    {
      str2 = ((JSONObject)localObject1).optString("reportData");
      localObject5 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.createMiniAppInfo((JSONObject)localObject1);
      localMiniAppInfo1 = this.mMiniAppContext.getMiniAppInfo();
      localEntryModel = localMiniAppInfo1.launchParam.entryModel;
      str1 = "";
      if ((localObject5 == null) || (!localMiniAppInfo1.appMode.useAppInfoWhenNavigate)) {}
    }
    for (;;)
    {
      try
      {
        localObject4 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWnsConfigProxy.getConfig("qqminiapp", "miniappsearchappid");
        Object localObject2 = localObject4;
        if (StringUtil.a((String)localObject4)) {
          localObject2 = "1109875297";
        }
        if ((this.mMiniAppContext.getMiniAppInfo() != null) && (((String)localObject2).equals(this.mMiniAppContext.getMiniAppInfo().appId)))
        {
          i = 2077;
        }
        else
        {
          if (!localMiniAppInfo1.isAppStoreMiniApp()) {
            break label726;
          }
          i = 2001;
        }
        localObject2 = ((JSONObject)localObject1).optJSONObject("extraData");
        if (localObject2 == null) {
          break label733;
        }
        localObject2 = ((JSONObject)localObject2).toString();
        localObject4 = ((JSONObject)localObject1).optJSONObject("privateExtraData");
        if (localObject4 == null) {
          break label741;
        }
        localObject4 = ((JSONObject)localObject4).toString();
        localObject6 = new com.tencent.mobileqq.mini.sdk.LaunchParam();
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject6).scene = i;
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject6).fromMiniAppId = localMiniAppInfo1.launchParam.miniAppId;
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject6).navigateExtData = ((String)localObject2);
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject6).privateExtraData = ((String)localObject4);
        if (localEntryModel != null) {
          ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject6).entryModel = MiniSdkUtil.a(localEntryModel);
        }
        localObject2 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.createMiniAppInfo((JSONObject)localObject1);
        MiniAppController.launchMiniAppByAppInfo(this.mMiniAppContext.getAttachedActivity(), (com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2, (com.tencent.mobileqq.mini.sdk.LaunchParam)localObject6);
        paramRequestEvent.ok();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("navigateToMiniProgram, open miniApp from appInfo, appInfo: ");
        ((StringBuilder)localObject4).append(((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject5).toString());
        QLog.d("NavigationJsPlugin", 1, ((StringBuilder)localObject4).toString());
        if (((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject5).verType == 3) {
          a((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2);
        }
        return;
      }
      catch (Exception localException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("navigateToMiniProgram, ");
        ((StringBuilder)localObject4).append(Log.getStackTraceString(localException));
        QLog.e("NavigationJsPlugin", 1, ((StringBuilder)localObject4).toString());
      }
      int i = ((JSONObject)localObject1).optInt("openType");
      Object localObject6 = ((JSONObject)localObject1).optString("appId");
      if (i == 0)
      {
        String str3 = ((JSONObject)localObject1).optString("path");
        localObject4 = ((JSONObject)localObject1).optString("envVersion");
        localObject3 = ((JSONObject)localObject1).optJSONObject("extraData");
        if (localObject3 != null) {
          localObject3 = ((JSONObject)localObject3).toString();
        } else {
          localObject3 = "";
        }
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo2 = this.mMiniAppInfo;
        localObject5 = "release";
        if ((localMiniAppInfo2 != null) && ("release".equals(this.mMiniAppInfo.getVerTypeStr()))) {
          localObject4 = localObject5;
        }
        localObject5 = new com.tencent.mobileqq.mini.sdk.LaunchParam();
        if (localMiniAppInfo1.isAppStoreMiniApp()) {
          i = 2001;
        } else {
          i = 1037;
        }
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).scene = i;
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).entryPath = str3;
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).navigateExtData = ((String)localObject3);
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).fromMiniAppId = localMiniAppInfo1.launchParam.miniAppId;
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).entryModel = MiniSdkUtil.a(localEntryModel);
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).envVersion = ((String)localObject4);
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).reportData = str2;
        localObject3 = ((JSONObject)localObject1).optJSONObject("privateExtraData");
        localObject1 = str1;
        if (localObject3 != null) {
          localObject1 = ((JSONObject)localObject3).toString();
        }
        ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).privateExtraData = ((String)localObject1);
        if ((!localMiniAppInfo1.isSpecialMiniApp()) && (jdField_a_of_type_Int == 1))
        {
          ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).fromEnvVersion = localMiniAppInfo1.getVerTypeStr();
          ((com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5).fromMiniAppInfo = MiniSdkLauncher.convert(localMiniAppInfo1);
        }
        MiniAppController.startAppByAppid(this.mMiniAppContext.getAttachedActivity(), (String)localObject6, str3, (String)localObject4, (com.tencent.mobileqq.mini.sdk.LaunchParam)localObject5, new NavigationJsPlugin.3(this, paramRequestEvent));
        paramRequestEvent.ok();
        return;
      }
      if (i == 1)
      {
        if (GameProxy.startGameByMiniApp(this.mMiniAppContext.getAttachedActivity(), (String)localObject6, (JSONObject)localObject1))
        {
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail();
      }
      return;
      label726:
      i = 1037;
      continue;
      label733:
      Object localObject3 = "";
      continue;
      label741:
      Object localObject4 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */