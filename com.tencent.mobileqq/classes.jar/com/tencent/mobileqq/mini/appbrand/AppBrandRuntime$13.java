package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;

class AppBrandRuntime$13
  implements Runnable
{
  AppBrandRuntime$13(AppBrandRuntime paramAppBrandRuntime, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    this.this$0.pageContainer.swichTab(this.val$url);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.this$0.serviceRuntime, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.13
 * JD-Core Version:    0.7.0.1
 */