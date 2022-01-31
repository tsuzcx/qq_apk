package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;

class AppBrandRuntime$2$1
  implements Runnable
{
  AppBrandRuntime$2$1(AppBrandRuntime.2 param2) {}
  
  public void run()
  {
    this.this$1.this$0.pageContainer.launch(this.this$1.val$url, "appLaunch");
    ThreadManagerV2.excute(new AppBrandRuntime.2.1.1(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.2.1
 * JD-Core Version:    0.7.0.1
 */