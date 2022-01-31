package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class VideoPlugin$3
  implements Runnable
{
  VideoPlugin$3(VideoPlugin paramVideoPlugin, int paramInt1, JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString, int paramInt2) {}
  
  public void run()
  {
    VideoPlugin.access$100(this.this$0, this.val$videoPlayerId, this.val$jsonObject);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.VideoPlugin.3
 * JD-Core Version:    0.7.0.1
 */