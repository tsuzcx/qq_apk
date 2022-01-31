package com.tencent.mobileqq.mini.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3.QQBaselibLoader;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver;
import common.config.service.QzoneConfig;

public class AppBrandTaskPreloadReceiver7
  extends AppBrandMainReceiver
{
  public static final String ACTION_KILL = "mini_process_kill";
  public static final String LOG_TAG = "AppBrandReceiver";
  private static int killOtherGamesOnStartFlag = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillOtherGamesOnStart", 0);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    QMLog.i("minisdk-start", "AppBrandTaskPreloadReceiver onReceive action: " + (String)localObject);
    if (AppBrandUI3.mHasOnCreate) {
      QMLog.i("minisdk-start", "AppBrandUI3 has OnCreate，return。");
    }
    for (;;)
    {
      return;
      try
      {
        MiniSDK.init(paramContext.getApplicationContext());
        AppLoaderFactory.g().setBaselibLoader(AppBrandUI3.QQBaselibLoader.g());
        AppBrandUI3.initOKHttpClient();
        ThreadManager.executeOnSubThread(new AppBrandTaskPreloadReceiver7.1(this));
        paramIntent.putExtra("isFlutterRuntimeProcess", true);
        localObject = AppLoaderFactory.g().getReceiverProxy();
        if (localObject != null)
        {
          ((IReceiverProxy)localObject).onReceive(paramContext, paramIntent);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver7
 * JD-Core Version:    0.7.0.1
 */