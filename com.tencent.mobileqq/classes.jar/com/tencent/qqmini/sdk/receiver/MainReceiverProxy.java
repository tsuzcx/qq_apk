package com.tencent.qqmini.sdk.receiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

@MiniKeep
public class MainReceiverProxy
  implements IReceiverProxy
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Object localObject;
    if ("mini_preload_app".equals(str))
    {
      QMLog.i("minisdk-start", "预加载小程序");
      localObject = paramIntent.getExtras();
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = new Bundle();
      }
      paramContext.putString("mini_key_preload_type", "preload_app");
      AppRuntimeLoaderManager.g().preloadRuntime(paramContext);
      paramContext = new Bundle();
      paramContext.putString("mini_key_preload_type", "preload_app");
      AppLoaderFactory.g().getAppBrandProxy().onAppStart(null, paramContext);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).preConnectDownloadHost();
    }
    if ("mini_prelaunch_app".equals(str))
    {
      paramIntent = paramIntent.getExtras();
      paramContext = paramIntent;
      if (paramIntent == null) {
        paramContext = new Bundle();
      }
      paramIntent = (MiniAppInfo)paramContext.getParcelable("mini_appinfo");
      if (paramIntent == null) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("预加载小程序 miniAppInfo:");
      ((StringBuilder)localObject).append(paramIntent);
      QMLog.i("minisdk-start", ((StringBuilder)localObject).toString());
      paramContext.putString("mini_key_preload_type", "preload_app");
      AppRuntimeLoaderManager.g().preLaunchRuntimeLoader(paramIntent, new MainReceiverProxy.1(this, paramIntent), paramContext);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).preConnectDownloadHost();
      return;
    }
    if ("mini_preload_game".equals(str))
    {
      QMLog.i("minisdk-start", "预加载小游戏");
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 605, "1");
      if ((GameWnsUtils.gameEnable()) && (GameWnsUtils.enablePreloadGameBaseLib()))
      {
        paramIntent = paramIntent.getExtras();
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = new Bundle();
        }
        paramContext.putString("mini_key_preload_type", "preload_game");
        AppRuntimeLoaderManager.g().preloadRuntime(paramContext);
        paramContext = new Bundle();
        paramContext.putString("mini_key_preload_type", "preload_game");
        AppLoaderFactory.g().getAppBrandProxy().onAppStart(null, paramContext);
      }
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).preConnectDownloadHost();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.receiver.MainReceiverProxy
 * JD-Core Version:    0.7.0.1
 */