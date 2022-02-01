package com.tencent.qqmini.sdk.server.launch;

import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;

class AppLaunchStrategy$2
  implements Runnable
{
  AppLaunchStrategy$2(AppLaunchStrategy paramAppLaunchStrategy, MiniAppBaseInfo paramMiniAppBaseInfo) {}
  
  public void run()
  {
    AppLaunchStrategy localAppLaunchStrategy = this.this$0;
    if (!this.val$currAppConfig.isEngineTypeMiniGame()) {}
    for (boolean bool = true;; bool = false)
    {
      localAppLaunchStrategy.preloadExtraMiniApp(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy.2
 * JD-Core Version:    0.7.0.1
 */