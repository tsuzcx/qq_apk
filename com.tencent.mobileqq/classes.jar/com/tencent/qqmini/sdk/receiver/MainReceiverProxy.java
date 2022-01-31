package com.tencent.qqmini.sdk.receiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bguq;
import bhcg;
import bhck;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

public class MainReceiverProxy
  implements IReceiverProxy
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("mini_preload_app".equals(paramContext)) {
      if (bguq.shouldIgnorePreload()) {
        QMLog.w("minisdk-start", "Already started, ignore broadcast: " + paramContext);
      }
    }
    do
    {
      do
      {
        return;
        QMLog.i("minisdk-start", "预加载小程序");
        paramIntent = paramIntent.getExtras();
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = new Bundle();
        }
        paramContext.putString("mini_key_preload_type", "preload_app");
        AppRuntimeLoaderManager.g().preloadRuntime(paramContext);
        paramContext = new Bundle();
        paramContext.putString("mini_key_preload_type", "preload_app");
        AppLoaderFactory.g().getAppBrandProxy().onAppStart(null, paramContext);
        return;
      } while (!"mini_preload_game".equals(paramContext));
      if (bguq.shouldIgnorePreload())
      {
        QMLog.w("minisdk-start", "Already started, ignore broadcast: " + paramContext);
        return;
      }
      QMLog.i("minisdk-start", "预加载小游戏");
      bhck.a(bhcg.a(), 605, "1");
    } while ((!GameWnsUtils.gameEnable()) || (!GameWnsUtils.enablePreloadGameBaseLib()));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.receiver.MainReceiverProxy
 * JD-Core Version:    0.7.0.1
 */