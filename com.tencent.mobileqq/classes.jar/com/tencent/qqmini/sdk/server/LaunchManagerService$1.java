package com.tencent.qqmini.sdk.server;

import android.text.TextUtils;
import java.util.List;

class LaunchManagerService$1
  implements Runnable
{
  LaunchManagerService$1(LaunchManagerService paramLaunchManagerService, LaunchManagerService.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo) {}
  
  public void run()
  {
    LaunchManagerService localLaunchManagerService;
    if ((this.val$preloadProcess != null) && (!this.val$preloadProcess.allMiniAppInfo.isEmpty()))
    {
      localLaunchManagerService = this.this$0;
      if (TextUtils.equals(this.val$preloadProcess.preloadType, "preload_game")) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      localLaunchManagerService.preloadExtraMiniApp(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.1
 * JD-Core Version:    0.7.0.1
 */