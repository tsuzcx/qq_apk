package com.tencent.qqmini.sdk.server;

import android.util.LruCache;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class LaunchManagerService$7
  implements Runnable
{
  LaunchManagerService$7(LaunchManagerService paramLaunchManagerService, String paramString1, String paramString2) {}
  
  public void run()
  {
    LaunchManagerService.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (LaunchManagerService.MiniAppSubProcessorInfo)LaunchManagerService.access$000(this.this$0).get(this.val$processName);
    if (localMiniAppSubProcessorInfo != null)
    {
      QMLog.i("minisdk-start_LaunchManagerService", "set preload BaseLibVersion:" + this.val$baseLibVersion + " to " + localMiniAppSubProcessorInfo);
      localMiniAppSubProcessorInfo.preloadGameBaseLibVersion = this.val$baseLibVersion;
      LaunchManagerService.access$000(this.this$0).put(this.val$processName, localMiniAppSubProcessorInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.7
 * JD-Core Version:    0.7.0.1
 */