package com.tencent.qqmini.sdk.server.launch;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppLaunchStrategy$MiniAppSubProcessorInfo$1
  implements Runnable
{
  AppLaunchStrategy$MiniAppSubProcessorInfo$1(AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo) {}
  
  public void run()
  {
    if (this.this$1.isForeground) {
      return;
    }
    QMLog.i("minisdk-start_LaunchManagerService", "recycle process=" + this.this$1.processName + " " + this.this$1.allMiniAppInfo);
    AppLaunchStrategy.access$000(this.this$1.this$0, this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy.MiniAppSubProcessorInfo.1
 * JD-Core Version:    0.7.0.1
 */