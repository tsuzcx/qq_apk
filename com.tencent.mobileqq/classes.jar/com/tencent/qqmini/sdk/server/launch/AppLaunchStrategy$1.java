package com.tencent.qqmini.sdk.server.launch;

import android.text.TextUtils;
import java.util.List;

class AppLaunchStrategy$1
  implements Runnable
{
  AppLaunchStrategy$1(AppLaunchStrategy paramAppLaunchStrategy, AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo) {}
  
  public void run()
  {
    AppLaunchStrategy localAppLaunchStrategy;
    if ((this.val$preloadProcess != null) && (!this.val$preloadProcess.allMiniAppInfo.isEmpty()))
    {
      localAppLaunchStrategy = this.this$0;
      if (TextUtils.equals(this.val$preloadProcess.preloadType, "preload_game")) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      localAppLaunchStrategy.preloadExtraMiniApp(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy.1
 * JD-Core Version:    0.7.0.1
 */