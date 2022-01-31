package com.tencent.mobileqq.mini.launch;

import ajjy;
import bbmy;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$6
  implements Runnable
{
  AppBrandLaunchManager$6(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    QLog.e("miniapp-process_AppBrandLaunchManager", 1, "启动失败, scene未知" + this.val$appConfig.toString());
    bbmy.a(AppBrandLaunchManager.access$100(this.this$0), ajjy.a(2131634807), 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.6
 * JD-Core Version:    0.7.0.1
 */