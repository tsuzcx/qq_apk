package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.util.ApiUtil.OnLocationFinish;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class MapJsPlugin$2
  implements ApiUtil.OnLocationFinish
{
  MapJsPlugin$2(MapJsPlugin paramMapJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onLocationFinishCallback(JSONObject paramJSONObject)
  {
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, paramJSONObject, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */