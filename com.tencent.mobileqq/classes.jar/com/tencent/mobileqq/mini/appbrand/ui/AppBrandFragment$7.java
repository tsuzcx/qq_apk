package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

class AppBrandFragment$7
  implements Runnable
{
  AppBrandFragment$7(AppBrandFragment paramAppBrandFragment, Activity paramActivity) {}
  
  public void run()
  {
    if ((this.this$0.miniConfig == null) || (this.this$0.miniConfig.config == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("AppBrandFragment", 2, "syncForceGroundAndRefreshBadge--miniConfig error");
      }
    }
    Bundle localBundle;
    do
    {
      return;
      localBundle = new Bundle();
      localBundle.putString("miniAppID", this.this$0.miniConfig.config.appId);
      localBundle.putString("param_proc_name", BaseApplicationImpl.getApplication().getQQProcessName());
      localBundle.putString("param_proc_modulename", "mini_app_client_module");
    } while ((this.val$activity == null) || (!(this.val$activity instanceof AppBrandUI)));
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandFragment", 2, "onStart--onProcessForeGround");
    }
    ((AppBrandUI)this.val$activity).onProcessForeGround(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandFragment", 2, "onResume--onRefreshMiniBadge");
    }
    ((AppBrandUI)this.val$activity).onRefreshMiniBadge(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment.7
 * JD-Core Version:    0.7.0.1
 */