package com.tencent.qqmini.sdk.ipc;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class LaunchManagerClient$8
  implements Runnable
{
  LaunchManagerClient$8(LaunchManagerClient paramLaunchManagerClient, String paramString, MiniCmdCallback paramMiniCmdCallback, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.getService() == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendCmd IAppBrandService Connection is Null 1. cmd=");
      ((StringBuilder)localObject).append(this.val$cmd);
      QMLog.e("minisdk-start_AppBrandProxy", ((StringBuilder)localObject).toString());
      localObject = this.val$callback;
      if (localObject == null) {
        return;
      }
      try
      {
        ((MiniCmdCallback)localObject).onCmdResult(false, new Bundle());
        return;
      }
      catch (Throwable localThrowable1)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable1);
        return;
      }
    }
    try
    {
      LaunchManagerClient.access$200(this.this$0).sendCmd(this.val$cmd, AppLoaderFactory.g().getCurrentProcessName(), this.val$bundle, this.val$callback);
      return;
    }
    catch (Throwable localThrowable2)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.LaunchManagerClient.8
 * JD-Core Version:    0.7.0.1
 */