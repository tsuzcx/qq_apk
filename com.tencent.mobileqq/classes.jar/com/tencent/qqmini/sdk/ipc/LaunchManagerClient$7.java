package com.tencent.qqmini.sdk.ipc;

import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class LaunchManagerClient$7
  implements Runnable
{
  LaunchManagerClient$7(LaunchManagerClient paramLaunchManagerClient) {}
  
  public void run()
  {
    try
    {
      LaunchManagerClient.access$200(this.this$0).stopAllMiniApp();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.LaunchManagerClient.7
 * JD-Core Version:    0.7.0.1
 */