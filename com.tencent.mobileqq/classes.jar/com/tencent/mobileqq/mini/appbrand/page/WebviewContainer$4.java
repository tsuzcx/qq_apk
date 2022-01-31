package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;

class WebviewContainer$4
  implements Runnable
{
  WebviewContainer$4(WebviewContainer paramWebviewContainer, String paramString) {}
  
  public void run()
  {
    this.this$0.appBrandRuntime.pageContainer.getCurrentPage().showToastView(1, "loading", null, this.val$title, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer.4
 * JD-Core Version:    0.7.0.1
 */