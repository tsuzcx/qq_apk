package com.tencent.mobileqq.mini.launch;

import alpo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$8
  implements Runnable
{
  AppBrandLaunchManager$8(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    QLog.e("miniapp-process_AppBrandLaunchManager", 1, "启动失败, scene未知" + this.val$appConfig.toString());
    QQToast.a(AppBrandLaunchManager.access$100(this.this$0), alpo.a(2131700971), 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.8
 * JD-Core Version:    0.7.0.1
 */