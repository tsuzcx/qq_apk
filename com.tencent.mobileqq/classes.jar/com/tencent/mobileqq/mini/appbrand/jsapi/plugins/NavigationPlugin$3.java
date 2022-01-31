package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class NavigationPlugin$3
  implements Runnable
{
  NavigationPlugin$3(NavigationPlugin paramNavigationPlugin, NavigationBar paramNavigationBar, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.val$navigationBar != null)
    {
      this.val$navigationBar.showLoading();
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NavigationPlugin.3
 * JD-Core Version:    0.7.0.1
 */