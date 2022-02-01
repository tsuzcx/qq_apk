package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class AppBrandMainService$AppBrandMainServiceBinder$5
  implements Runnable
{
  AppBrandMainService$AppBrandMainServiceBinder$5(AppBrandMainService.AppBrandMainServiceBinder paramAppBrandMainServiceBinder, String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle) {}
  
  public void run()
  {
    AppBrandLaunchManager.g().onAppStop(this.val$processName, this.val$appConfig, this.val$bundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandMainService.AppBrandMainServiceBinder.5
 * JD-Core Version:    0.7.0.1
 */