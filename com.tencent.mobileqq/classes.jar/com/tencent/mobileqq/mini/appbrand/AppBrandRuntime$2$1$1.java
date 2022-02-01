package com.tencent.mobileqq.mini.appbrand;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;

class AppBrandRuntime$2$1$1
  implements Runnable
{
  AppBrandRuntime$2$1$1(AppBrandRuntime.2.1 param1) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_name", BaseApplicationImpl.getApplication().getQQProcessName());
    localBundle.putString("param_proc_modulename", "mini_app_client_module");
    localBundle.putBoolean("param_proc_first_start", true);
    if ((this.this$2.this$1.this$0.activity != null) && ((this.this$2.this$1.this$0.activity instanceof AppBrandUI))) {
      ((AppBrandUI)this.this$2.this$1.this$0.activity).onProcessForeGround(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.2.1.1
 * JD-Core Version:    0.7.0.1
 */