package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;

class WebviewContainer$6
  implements Runnable
{
  WebviewContainer$6(WebviewContainer paramWebviewContainer) {}
  
  public void run()
  {
    AbsAppBrandPage localAbsAppBrandPage = this.this$0.appBrandRuntime.pageContainer.getCurrentPage();
    if (localAbsAppBrandPage.hasToastView()) {
      localAbsAppBrandPage.hideToastView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer.6
 * JD-Core Version:    0.7.0.1
 */