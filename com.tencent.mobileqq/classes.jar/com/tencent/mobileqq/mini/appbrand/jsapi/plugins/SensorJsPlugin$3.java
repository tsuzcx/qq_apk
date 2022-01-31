package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$3
  implements Runnable
{
  SensorJsPlugin$3(SensorJsPlugin paramSensorJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    try
    {
      SensorJsPlugin.access$300(this.this$0);
      if (new JSONObject(this.val$jsonParams).optBoolean("enable"))
      {
        if (this.this$0.startAccelerometer(3))
        {
          SensorJsPlugin.access$402(this.this$0, true);
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
          return;
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    this.this$0.stopAccelerometer();
    if (!SensorJsPlugin.access$400(this.this$0)) {
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, ":fail to disable, not enable?", this.val$callbackId);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errMsg", this.val$eventName + ":cancel");
      this.val$webview.evaluateCallbackJs(this.val$callbackId, localJSONObject.toString());
      return;
      SensorJsPlugin.access$402(this.this$0, false);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SensorJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */