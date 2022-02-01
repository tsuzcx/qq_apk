package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;

class AppBrandUI$2
  implements Runnable
{
  AppBrandUI$2(AppBrandUI paramAppBrandUI) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_name", BaseApplicationImpl.getApplication().getQQProcessName());
    localBundle.putString("param_proc_modulename", "mini_sdk_client_module");
    localBundle.putBoolean("param_proc_first_start", true);
    this.this$0.onProcessForeGround(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI.2
 * JD-Core Version:    0.7.0.1
 */