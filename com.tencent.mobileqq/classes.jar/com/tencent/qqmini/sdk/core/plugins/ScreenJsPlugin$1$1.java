package com.tencent.qqmini.sdk.core.plugins;

import org.json.JSONObject;

class ScreenJsPlugin$1$1
  implements ScreenJsPlugin.ScreenShotListenManager.OnScreenShotListener
{
  ScreenJsPlugin$1$1(ScreenJsPlugin.1 param1) {}
  
  public void onShot(String paramString)
  {
    paramString = new JSONObject();
    this.this$1.this$0.sendSubscribeEvent("onUserCaptureScreen", paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */