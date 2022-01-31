package com.tencent.mobileqq.mini.launch;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class AppBrandLaunchManager$2
  implements Runnable
{
  AppBrandLaunchManager$2(AppBrandLaunchManager paramAppBrandLaunchManager, AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo) {}
  
  public void run()
  {
    AppBrandLaunchManager localAppBrandLaunchManager;
    if ((this.val$preloadProcess != null) && (this.val$preloadProcess.appConfig != null))
    {
      localAppBrandLaunchManager = this.this$0;
      if (this.val$preloadProcess.appConfig.isEngineTypeMiniGame()) {
        break label43;
      }
    }
    label43:
    for (boolean bool = true;; bool = false)
    {
      localAppBrandLaunchManager.preloadExtraMiniApp(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.2
 * JD-Core Version:    0.7.0.1
 */