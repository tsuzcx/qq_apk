package com.tencent.qqmini.sdk.server.launch;

import android.text.TextUtils;
import java.util.List;

class AppLaunchStrategy$1
  implements Runnable
{
  AppLaunchStrategy$1(AppLaunchStrategy paramAppLaunchStrategy, AppLaunchStrategy.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo) {}
  
  public void run()
  {
    AppLaunchStrategy.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = this.val$preloadProcess;
    if ((localMiniAppSubProcessorInfo != null) && (!localMiniAppSubProcessorInfo.allMiniAppInfo.isEmpty())) {
      this.this$0.preloadExtraMiniApp(TextUtils.equals(this.val$preloadProcess.preloadType, "preload_game") ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy.1
 * JD-Core Version:    0.7.0.1
 */