package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;

class AppBrandLaunchManager$4
  implements Runnable
{
  AppBrandLaunchManager$4(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppBaseInfo paramMiniAppBaseInfo) {}
  
  public void run()
  {
    AppBrandLaunchManager localAppBrandLaunchManager = this.this$0;
    if (!this.a.isEngineTypeMiniGame()) {}
    for (boolean bool = true;; bool = false)
    {
      localAppBrandLaunchManager.preloadExtraMiniApp(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.4
 * JD-Core Version:    0.7.0.1
 */