package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$6
  implements Runnable
{
  AppBrandLaunchManager$6(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppConfig paramMiniAppConfig, Activity paramActivity) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (this.val$appConfig.config == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("启动失败, Appid 为空 appConfig.config==null Activity=");
      localStringBuilder.append(this.val$activity);
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("启动失败, Appid 为空");
      localStringBuilder.append(this.val$appConfig.config.toString());
      localStringBuilder.append(" Activity=");
      localStringBuilder.append(this.val$activity);
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, localStringBuilder.toString());
    }
    QQToast.makeText(AppBrandLaunchManager.access$000(this.this$0), HardCodeUtil.a(2131898846), 2000).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.6
 * JD-Core Version:    0.7.0.1
 */