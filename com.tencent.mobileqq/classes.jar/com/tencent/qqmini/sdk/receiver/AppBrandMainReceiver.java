package com.tencent.qqmini.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;

public class AppBrandMainReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandTaskPreloadReceiver onReceive action: ");
    localStringBuilder.append((String)localObject);
    QMLog.i("minisdk-start", localStringBuilder.toString());
    MiniSDK.init(paramContext.getApplicationContext());
    AppLoaderFactory.g().getMiniAppEnv().setupWithIntent(paramIntent);
    localObject = AppLoaderFactory.g().getMiniAppEnv().getReceiverProxy();
    if (localObject != null) {
      ((IReceiverProxy)localObject).onReceive(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver
 * JD-Core Version:    0.7.0.1
 */