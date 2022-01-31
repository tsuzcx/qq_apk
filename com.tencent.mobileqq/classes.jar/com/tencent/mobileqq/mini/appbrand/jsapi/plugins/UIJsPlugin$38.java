package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class UIJsPlugin$38
  implements Runnable
{
  UIJsPlugin$38(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    PageWebview localPageWebview = this.this$0.jsPluginEngine.appBrandRuntime.getPageWebView();
    if (localPageWebview != null)
    {
      localPageWebview.setEnableShowBackHome(false);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.38
 * JD-Core Version:    0.7.0.1
 */