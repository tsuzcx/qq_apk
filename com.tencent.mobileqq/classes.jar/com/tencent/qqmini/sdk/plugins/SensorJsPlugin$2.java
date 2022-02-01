package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$2
  implements Runnable
{
  SensorJsPlugin$2(SensorJsPlugin paramSensorJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      SensorJsPlugin.access$000(this.this$0);
      if (new JSONObject(this.val$req.jsonParams).optBoolean("enable"))
      {
        if (this.this$0.startCompass(this.val$req.jsService, 3))
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
    this.this$0.stopCompass();
    this.val$req.ok();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errMsg", this.val$req.event + ":cancel");
    this.val$req.evaluateCallbackJs(localJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */