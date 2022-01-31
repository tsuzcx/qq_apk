package com.tencent.mobileqq.mini.launch;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class AppBrandLaunchManager$10
  implements Runnable
{
  AppBrandLaunchManager$10(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    AppBrandLaunchManager localAppBrandLaunchManager = this.this$0;
    if (!this.val$appConfig.isEngineTypeMiniGame()) {}
    for (boolean bool = true;; bool = false)
    {
      localAppBrandLaunchManager.preloadExtraMiniApp(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.10
 * JD-Core Version:    0.7.0.1
 */