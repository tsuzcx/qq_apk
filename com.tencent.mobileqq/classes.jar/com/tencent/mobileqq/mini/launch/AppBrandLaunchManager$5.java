package com.tencent.mobileqq.mini.launch;

import ajjy;
import android.app.Activity;
import bbmy;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$5
  implements Runnable
{
  AppBrandLaunchManager$5(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppConfig paramMiniAppConfig, Activity paramActivity) {}
  
  public void run()
  {
    if (this.val$appConfig.config == null) {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "启动失败, Appid 为空 appConfig.config==null Activity=" + this.val$activity);
    }
    for (;;)
    {
      bbmy.a(AppBrandLaunchManager.access$100(this.this$0), ajjy.a(2131634808), 2000).a();
      return;
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "启动失败, Appid 为空" + this.val$appConfig.config.toString() + " Activity=" + this.val$activity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.5
 * JD-Core Version:    0.7.0.1
 */