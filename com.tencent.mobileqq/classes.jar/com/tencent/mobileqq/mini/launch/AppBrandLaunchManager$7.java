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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("启动失败, scene未知");
    localStringBuilder.append(this.val$appConfig.toString());
    QLog.e("miniapp-process_AppBrandLaunchManager", 1, localStringBuilder.toString());
    QQToast.makeText(AppBrandLaunchManager.access$000(this.this$0), HardCodeUtil.a(2131898845), 2000).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.7
 * JD-Core Version:    0.7.0.1
 */