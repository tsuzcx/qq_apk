package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;

class AppBrandRuntime$12
  implements Runnable
{
  AppBrandRuntime$12(AppBrandRuntime paramAppBrandRuntime, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    this.this$0.pageContainer.navigateBack(this.val$delta, false);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.this$0.serviceRuntime, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.12
 * JD-Core Version:    0.7.0.1
 */