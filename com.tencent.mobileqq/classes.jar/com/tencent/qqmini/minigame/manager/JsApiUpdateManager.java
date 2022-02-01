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
  private static MiniAppInfo newerMiniAppInfo;
  private static MiniAppInfo olderMiniAppInfo;
  
  public static void checkForUpdate(MiniAppInfo paramMiniAppInfo, MiniAppFileManager paramMiniAppFileManager, JsApiUpdateManager.IUpdateListener paramIUpdateListener)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      olderMiniAppInfo = paramMiniAppInfo;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpdate() called with: oldMiniAppConfig = [");
      localStringBuilder.append(paramMiniAppInfo);
      localStringBuilder.append("], callback = [");
      localStringBuilder.append(paramIUpdateListener);
      localStringBuilder.append("]");
      QMLog.d("JsApiUpdateManager", localStringBuilder.toString());
      if (paramMiniAppInfo.verType != 3)
      {
        QMLog.w("JsApiUpdateManager", "checkForUpdate skip check for not online version");
        handleUpdateCheckResult(paramIUpdateListener, false);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramMiniAppInfo.appId, "", "", new JsApiUpdateManager.1(paramMiniAppInfo, paramIUpdateListener, paramMiniAppFileManager));
      return;
    }
    paramMiniAppFileManager = new StringBuilder();
    paramMiniAppFileManager.append("checkUpdate() called with: oldMiniAppConfig = [");
    paramMiniAppFileManager.append(paramMiniAppInfo);
    paramMiniAppFileManager.append("], callback = [");
    paramMiniAppFileManager.append(paramIUpdateListener);
    paramMiniAppFileManager.append("]");
    QMLog.e("JsApiUpdateManager", paramMiniAppFileManager.toString());
  }
  
  public static void handleUpdateApp()
  {
    QMLog.d("JsApiUpdateManager", "handleUpdateApp() called");
    Object localObject = olderMiniAppInfo;
    if ((localObject != null) && (newerMiniAppInfo != null) && (((MiniAppInfo)localObject).launchParam != null) && (newerMiniAppInfo.launchParam != null))
    {
      newerMiniAppInfo.launchParam.forceReload = 3;
      newerMiniAppInfo.launchParam.scene = olderMiniAppInfo.launchParam.scene;
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("key_app_info", newerMiniAppInfo);
      AppBrandCmdProxy.g().sendCmd("cmd_update_app_for_mini_game", (Bundle)localObject, null);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleUpdateApp olderMiniAppInfo = ");
    ((StringBuilder)localObject).append(olderMiniAppInfo);
    ((StringBuilder)localObject).append(" newerMiniAppInfo = ");
    ((StringBuilder)localObject).append(newerMiniAppInfo);
    QMLog.e("JsApiUpdateManager", ((StringBuilder)localObject).toString());
  }
  
  public static void handleUpdateCheckResult(JsApiUpdateManager.IUpdateListener paramIUpdateListener, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleUpdateCheckResult hasUpdate:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", callback:");
    localStringBuilder.append(paramIUpdateListener);
    QMLog.d("JsApiUpdateManager", localStringBuilder.toString());
    if (paramIUpdateListener != null) {
      paramIUpdateListener.onCheckResult(paramBoolean);
    }
  }
  
  private static void handleUpdateDownload(MiniAppFileManager paramMiniAppFileManager, MiniAppInfo paramMiniAppInfo, JsApiUpdateManager.IUpdateListener paramIUpdateListener)
  {
    if (paramMiniAppInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleUpdateDownload() called with: callback = [");
      localStringBuilder.append(paramIUpdateListener);
      localStringBuilder.append("], miniAppConfig = [");
      localStringBuilder.append(paramMiniAppInfo);
      localStringBuilder.append("]");
      QMLog.d("JsApiUpdateManager", localStringBuilder.toString());
      GpkgManager.getGpkgInfoByConfig(paramMiniAppInfo, new JsApiUpdateManager.2(paramMiniAppFileManager, paramIUpdateListener));
    }
  }
  
  private static void handleUpdateDownloadResult(JsApiUpdateManager.IUpdateListener paramIUpdateListener, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleUpdateDownloadResult success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", callback:");
    localStringBuilder.append(paramIUpdateListener);
    QMLog.d("JsApiUpdateManager", localStringBuilder.toString());
    if (paramIUpdateListener != null) {
      paramIUpdateListener.onDownloadResult(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.JsApiUpdateManager
 * JD-Core Version:    0.7.0.1
 */