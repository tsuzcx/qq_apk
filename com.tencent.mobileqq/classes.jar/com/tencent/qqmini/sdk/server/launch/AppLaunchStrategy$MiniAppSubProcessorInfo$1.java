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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recycle process=");
    localStringBuilder.append(this.this$1.processName);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.this$1.allMiniAppInfo);
    QMLog.i("minisdk-start_LaunchManagerService", localStringBuilder.toString());
    AppLaunchStrategy.access$000(this.this$1.this$0, this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy.MiniAppSubProcessorInfo.1
 * JD-Core Version:    0.7.0.1
 */