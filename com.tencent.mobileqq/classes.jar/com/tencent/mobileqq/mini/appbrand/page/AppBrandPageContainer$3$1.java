package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.qphone.base.util.QLog;

class AppBrandPageContainer$3$1
  implements Runnable
{
  AppBrandPageContainer$3$1(AppBrandPageContainer.3 param3) {}
  
  public void run()
  {
    try
    {
      this.this$1.this$0.appBrandRuntime.webviewPool.recyclePageWebview(this.this$1.val$page.getCurrentPageWebview(), BaseApplicationImpl.sApplication);
      if (this.this$1.val$page.getCurrentPageWebview() != null) {
        this.this$1.val$page.getCurrentPageWebview().resetTitle();
      }
      this.this$1.val$page.cleanup();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AppBrandPageContainer", 1, "navigateBack exception!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer.3.1
 * JD-Core Version:    0.7.0.1
 */