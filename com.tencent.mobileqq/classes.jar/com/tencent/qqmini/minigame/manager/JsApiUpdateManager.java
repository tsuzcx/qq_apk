package com.tencent.qqmini.minigame.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class JsApiUpdateManager
{
  private static final String KEY_APP_INFO = "key_app_info";
  private static final String TAG = "JsApiUpdateManager";
  private static MiniAppInfo newerMiniAppInfo = null;
  private static MiniAppInfo olderMiniAppInfo = null;
  
  public static void checkForUpdate(MiniAppInfo paramMiniAppInfo, MiniAppFileManager paramMiniAppFileManager, JsApiUpdateManager.IUpdateListener paramIUpdateListener)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      olderMiniAppInfo = paramMiniAppInfo;
      QMLog.d("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], callback = [" + paramIUpdateListener + "]");
      if (paramMiniAppInfo.verType != 3)
      {
        QMLog.w("JsApiUpdateManager", "checkForUpdate skip check for not online version");
        handleUpdateCheckResult(paramIUpdateListener, false);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramMiniAppInfo.appId, "", "", new JsApiUpdateManager.1(paramMiniAppInfo, paramIUpdateListener, paramMiniAppFileManager));
      return;
    }
    QMLog.e("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], callback = [" + paramIUpdateListener + "]");
  }
  
  public static void handleUpdateApp()
  {
    QMLog.d("JsApiUpdateManager", "handleUpdateApp() called");
    if ((olderMiniAppInfo != null) && (newerMiniAppInfo != null) && (olderMiniAppInfo.launchParam != null) && (newerMiniAppInfo.launchParam != null))
    {
      newerMiniAppInfo.forceReroad = 3;
      newerMiniAppInfo.launchParam.scene = olderMiniAppInfo.launchParam.scene;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("key_app_info", newerMiniAppInfo);
      AppBrandCmdProxy.g().sendCmd("cmd_update_app_for_mini_game", localBundle, null);
      return;
    }
    QMLog.e("JsApiUpdateManager", "handleUpdateApp olderMiniAppInfo = " + olderMiniAppInfo + " newerMiniAppInfo = " + newerMiniAppInfo);
  }
  
  public static void handleUpdateCheckResult(JsApiUpdateManager.IUpdateListener paramIUpdateListener, boolean paramBoolean)
  {
    QMLog.d("JsApiUpdateManager", "handleUpdateCheckResult hasUpdate:" + paramBoolean + ", callback:" + paramIUpdateListener);
    if (paramIUpdateListener != null) {
      paramIUpdateListener.onCheckResult(paramBoolean);
    }
  }
  
  private static void handleUpdateDownload(MiniAppFileManager paramMiniAppFileManager, MiniAppInfo paramMiniAppInfo, JsApiUpdateManager.IUpdateListener paramIUpdateListener)
  {
    if (paramMiniAppInfo != null)
    {
      QMLog.d("JsApiUpdateManager", "handleUpdateDownload() called with: callback = [" + paramIUpdateListener + "], miniAppConfig = [" + paramMiniAppInfo + "]");
      GpkgManager.getGpkgInfoByConfig(paramMiniAppInfo, new JsApiUpdateManager.2(paramMiniAppFileManager, paramIUpdateListener));
    }
  }
  
  private static void handleUpdateDownloadResult(JsApiUpdateManager.IUpdateListener paramIUpdateListener, boolean paramBoolean)
  {
    QMLog.d("JsApiUpdateManager", "handleUpdateDownloadResult success:" + paramBoolean + ", callback:" + paramIUpdateListener);
    if (paramIUpdateListener != null) {
      paramIUpdateListener.onDownloadResult(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.JsApiUpdateManager
 * JD-Core Version:    0.7.0.1
 */