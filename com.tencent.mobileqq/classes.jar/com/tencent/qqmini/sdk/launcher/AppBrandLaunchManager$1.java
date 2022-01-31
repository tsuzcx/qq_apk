package com.tencent.qqmini.sdk.launcher;

import bdld;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;

class AppBrandLaunchManager$1
  implements Runnable
{
  AppBrandLaunchManager$1(AppBrandLaunchManager paramAppBrandLaunchManager, bdld parambdld) {}
  
  public void run()
  {
    AppBrandLaunchManager localAppBrandLaunchManager;
    if ((this.a != null) && (this.a.a != null))
    {
      localAppBrandLaunchManager = this.this$0;
      if (this.a.a.isEngineTypeMiniGame()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.1
 * JD-Core Version:    0.7.0.1
 */