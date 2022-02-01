package com.tencent.mobileqq.minigame.jsapi.manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.MiniAppSubProcessorInfo;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.qphone.base.util.QLog;

public class JsApiUpdateManager
{
  private static final String KEY_APP_INFO = "key_app_info";
  private static final String TAG = "JsApiUpdateManager";
  private static MiniAppConfig newerMiniAppConfig;
  private static MiniAppConfig olderMiniAppConfig;
  
  public static void checkForUpdate(MiniAppConfig paramMiniAppConfig, MiniAppFileManager paramMiniAppFileManager, JsApiUpdateManager.IUpdateListener paramIUpdateListener)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      olderMiniAppConfig = paramMiniAppConfig;
      QLog.d("JsApiUpdateManager", 1, "checkUpdate() called with: olderMiniAppInfo = [" + paramMiniAppConfig + "], callback = [" + paramIUpdateListener + "]");
      if (paramMiniAppConfig.config.verType != 3)
      {
        QLog.w("JsApiUpdateManager", 2, "checkForUpdate skip check for not online version");
        handleUpdateCheckResult(paramIUpdateListener, false);
        return;
      }
      MiniAppCmdUtil.getInstance().getAppInfoById(null, paramMiniAppConfig.config.appId, null, null, new JsApiUpdateManager.1(paramMiniAppConfig, paramIUpdateListener, paramMiniAppFileManager));
      return;
    }
    QLog.e("JsApiUpdateManager", 1, "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppConfig + "], callback = [" + paramIUpdateListener + "]");
  }
  
  public static void handleUpdateApp()
  {
    QLog.d("JsApiUpdateManager", 1, "handleUpdateApp() called");
    if ((olderMiniAppConfig != null) && (newerMiniAppConfig != null) && (olderMiniAppConfig.launchParam != null) && (newerMiniAppConfig.launchParam != null))
    {
      newerMiniAppConfig.forceReroad = 3;
      newerMiniAppConfig.launchParam.scene = olderMiniAppConfig.launchParam.scene;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("key_app_info", newerMiniAppConfig);
      AppBrandProxy.g().sendCmd("cmd_update_app_for_mini_game", localBundle, null);
      return;
    }
    QLog.e("JsApiUpdateManager", 1, "handleUpdateApp olderMiniAppConfig = " + olderMiniAppConfig + " newerMiniAppConfig = " + newerMiniAppConfig);
  }
  
  public static void handleUpdateAppForMiniGame(@Nullable Bundle paramBundle)
  {
    QLog.d("JsApiUpdateManager", 1, "handleUpdateAppForMiniGame() called with: bundle = [" + paramBundle + "]");
    if (paramBundle == null) {}
    do
    {
      return;
      paramBundle = (MiniAppConfig)paramBundle.getParcelable("key_app_info");
    } while (paramBundle == null);
    AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = AppBrandLaunchManager.g().getCacheApp(paramBundle.config);
    if ((localMiniAppSubProcessorInfo != null) && (BaseActivity.sTopActivity != null))
    {
      AppBrandLaunchManager.g().forceKillProcess(localMiniAppSubProcessorInfo);
      AppBrandLaunchManager.g().startMiniApp(BaseActivity.sTopActivity, paramBundle, null);
      return;
    }
    QLog.e("JsApiUpdateManager", 1, "handleUpdateAppForMiniGame subProcessInfo = " + localMiniAppSubProcessorInfo + " sTopActivity = " + BaseActivity.sTopActivity);
  }
  
  public static void handleUpdateCheckResult(JsApiUpdateManager.IUpdateListener paramIUpdateListener, boolean paramBoolean)
  {
    QLog.d("JsApiUpdateManager", 1, "handleUpdateCheckResult hasUpdate:" + paramBoolean + ", callback:" + paramIUpdateListener);
    if (paramIUpdateListener != null) {
      paramIUpdateListener.onCheckResult(paramBoolean);
    }
  }
  
  private static void handleUpdateDownload(MiniAppFileManager paramMiniAppFileManager, MiniAppConfig paramMiniAppConfig, JsApiUpdateManager.IUpdateListener paramIUpdateListener)
  {
    if (paramMiniAppConfig != null)
    {
      QLog.d("JsApiUpdateManager", 1, "handleUpdateDownload() called with: callback = [" + paramIUpdateListener + "], miniAppConfig = [" + paramMiniAppConfig + "]");
      GpkgManager.getGpkgInfoByConfig(paramMiniAppConfig, new JsApiUpdateManager.2(paramMiniAppFileManager, paramIUpdateListener));
    }
  }
  
  private static void handleUpdateDownloadResult(JsApiUpdateManager.IUpdateListener paramIUpdateListener, boolean paramBoolean)
  {
    QLog.d("JsApiUpdateManager", 1, "handleUpdateDownloadResult success:" + paramBoolean + ", callback:" + paramIUpdateListener);
    if (paramIUpdateListener != null) {
      paramIUpdateListener.onDownloadResult(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager
 * JD-Core Version:    0.7.0.1
 */