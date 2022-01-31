package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class ScreenJsPlugin$2
  implements ScreenJsPlugin.ScreenShotListenManager.OnScreenShotListener
{
  ScreenJsPlugin$2(ScreenJsPlugin paramScreenJsPlugin) {}
  
  public void onShot(String paramString)
  {
    paramString = new JSONObject();
    this.this$0.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onUserCaptureScreen", paramString.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ScreenJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */