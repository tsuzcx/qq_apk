package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$2
  implements Runnable
{
  SensorJsPlugin$2(SensorJsPlugin paramSensorJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        SensorJsPlugin.access$300(this.this$0);
        JSONObject localJSONObject1 = new JSONObject(this.val$jsonParams);
        if (localJSONObject1.optBoolean("enable"))
        {
          j = localJSONObject1.optInt("interval");
          i = 3;
          if (j != 20) {
            break label195;
          }
          i = 1;
          if (this.this$0.startAccelerometer(i))
          {
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
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("errMsg", this.val$eventName + ":cancel");
      this.val$webview.evaluateCallbackJs(this.val$callbackId, localJSONObject2.toString());
      return;
      label195:
      if (j == 60) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SensorJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */