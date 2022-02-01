package com.tencent.qqmini.sdk.server;

import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;

class LaunchManagerService$5
  implements Runnable
{
  LaunchManagerService$5(LaunchManagerService paramLaunchManagerService, MiniAppBaseInfo paramMiniAppBaseInfo) {}
  
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
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.5
 * JD-Core Version:    0.7.0.1
 */