package com.tencent.mobileqq.mini.launch;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$7
  implements Runnable
{
  AppBrandLaunchManager$7(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    QLog.e("miniapp-process_AppBrandLaunchManager", 1, "启动失败, scene未知" + this.val$appConfig.toString());
    QQToast.a(AppBrandLaunchManager.access$000(this.this$0), HardCodeUtil.a(2131700679), 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.7
 * JD-Core Version:    0.7.0.1
 */