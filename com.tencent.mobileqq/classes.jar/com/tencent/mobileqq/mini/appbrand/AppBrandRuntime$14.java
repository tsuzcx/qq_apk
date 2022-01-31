package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;

class AppBrandRuntime$14
  implements Runnable
{
  AppBrandRuntime$14(AppBrandRuntime paramAppBrandRuntime, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    this.this$0.reload(this.val$url, true);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.this$0.serviceRuntime, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.14
 * JD-Core Version:    0.7.0.1
 */