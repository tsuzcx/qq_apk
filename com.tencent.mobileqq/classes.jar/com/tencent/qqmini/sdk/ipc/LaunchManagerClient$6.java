package com.tencent.qqmini.sdk.ipc;

import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class LaunchManagerClient$6
  implements Runnable
{
  LaunchManagerClient$6(LaunchManagerClient paramLaunchManagerClient, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    try
    {
      LaunchManagerClient.access$200(this.this$0).stopMiniApp(this.val$miniAppInfo);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.LaunchManagerClient.6
 * JD-Core Version:    0.7.0.1
 */