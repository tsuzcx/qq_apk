package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class NavigationPlugin$2
  implements Runnable
{
  NavigationPlugin$2(NavigationPlugin paramNavigationPlugin, NavigationBar paramNavigationBar, String paramString, JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    this.val$navigationBar.setTitleText(this.val$title);
    NavigationPlugin.access$000(this.this$0, this.val$webview, this.val$tmpJson, this.val$callbackId, "setNavigationBarTitle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NavigationPlugin.2
 * JD-Core Version:    0.7.0.1
 */