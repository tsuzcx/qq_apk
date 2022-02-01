package com.tencent.mobileqq.mini.launch;

import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class AppBrandMainService$AppBrandMainServiceBinder$1
  implements Runnable
{
  AppBrandMainService$AppBrandMainServiceBinder$1(AppBrandMainService.AppBrandMainServiceBinder paramAppBrandMainServiceBinder, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver) {}
  
  public void run()
  {
    AppBrandLaunchManager.g().startMiniApp(null, this.val$appConfig, this.val$resultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandMainService.AppBrandMainServiceBinder.1
 * JD-Core Version:    0.7.0.1
 */