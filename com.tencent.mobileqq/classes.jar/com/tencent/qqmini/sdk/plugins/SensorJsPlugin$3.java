package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$3
  implements Runnable
{
  SensorJsPlugin$3(SensorJsPlugin paramSensorJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      SensorJsPlugin.access$000(this.this$0);
      JSONObject localJSONObject1 = new JSONObject(this.val$req.jsonParams);
      if (localJSONObject1.optBoolean("enable"))
      {
        int i = this.this$0.getInterval(localJSONObject1);
        if (this.this$0.startGyroscope(this.val$req.jsService, i))
        {
          this.val$req.ok();
          return;
        }
        this.val$req.fail();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    this.this$0.stopGyroscope();
    this.val$req.ok();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("errMsg", this.val$req.event + ":cancel");
    this.val$req.evaluateCallbackJs(localJSONObject2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */