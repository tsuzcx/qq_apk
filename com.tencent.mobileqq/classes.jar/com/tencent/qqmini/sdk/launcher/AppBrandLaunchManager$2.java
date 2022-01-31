package com.tencent.qqmini.sdk.launcher;

import bgpw;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;

class AppBrandLaunchManager$2
  implements Runnable
{
  AppBrandLaunchManager$2(AppBrandLaunchManager paramAppBrandLaunchManager, bgpw parambgpw) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.2
 * JD-Core Version:    0.7.0.1
 */