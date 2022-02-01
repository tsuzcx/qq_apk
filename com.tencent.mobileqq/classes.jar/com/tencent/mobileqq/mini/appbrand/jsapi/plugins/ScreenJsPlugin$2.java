package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;

class ScreenJsPlugin$2
  implements ScreenJsPlugin.ScreenShotListenManager.OnScreenShotListener
{
  ScreenJsPlugin$2(ScreenJsPlugin paramScreenJsPlugin, BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onShot(String paramString)
  {
    paramString = this.val$jsPluginEngine.getServiceRuntime();
    if (this.this$0.isGameRuntime) {
      paramString = ScreenJsPlugin.access$000(this.this$0);
    }
    if (paramString != null) {
      paramString.evaluateSubcribeJS("onUserCaptureScreen", "{}", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ScreenJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */