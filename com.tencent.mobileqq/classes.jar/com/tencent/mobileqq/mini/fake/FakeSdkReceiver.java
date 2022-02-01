package com.tencent.mobileqq.mini.fake;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import common.config.service.QzoneConfig;

public class FakeSdkReceiver
  implements IFakeReceiver
{
  public static final String ACTION_KILL = "mini_process_kill";
  public static final String LOG_TAG = "AppBrandReceiver";
  private static int killOtherGamesOnStartFlag = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillOtherGamesOnStart", 0);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandTaskPreloadReceiver onReceive action: ");
    localStringBuilder.append((String)localObject);
    QLog.i("minisdk-start", 1, localStringBuilder.toString());
    try
    {
      MiniSDK.init(paramContext.getApplicationContext());
      ThreadManager.executeOnSubThread(new FakeSdkReceiver.1(this));
      localObject = AppLoaderFactory.g().getMiniAppEnv().getReceiverProxy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.fake.FakeSdkReceiver
 * JD-Core Version:    0.7.0.1
 */