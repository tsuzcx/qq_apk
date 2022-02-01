package com.tencent.qqmini.sdk.server;

import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;

class LaunchManagerService$6
  implements Runnable
{
  LaunchManagerService$6(LaunchManagerService paramLaunchManagerService, MiniAppBaseInfo paramMiniAppBaseInfo) {}
  
  public void run()
  {
    LaunchManagerService localLaunchManagerService = this.this$0;
    if (!this.val$currAppConfig.isEngineTypeMiniGame()) {}
    for (boolean bool = true;; bool = false)
    {
      localLaunchManagerService.preloadExtraMiniApp(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.6
 * JD-Core Version:    0.7.0.1
 */