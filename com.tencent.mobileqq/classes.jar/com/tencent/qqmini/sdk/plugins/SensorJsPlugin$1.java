package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$1
  implements Runnable
{
  SensorJsPlugin$1(SensorJsPlugin paramSensorJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      SensorJsPlugin.access$000(this.this$0);
      JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
      if (localJSONObject.optBoolean("enable"))
      {
        int i = this.this$0.getInterval(localJSONObject);
        if (this.this$0.startAccelerometer(this.val$req.jsService, i))
        {
          this.val$req.ok();
          return;
        }
        this.val$req.fail();
        return;
      }
      this.this$0.stopAccelerometer();
      this.val$req.ok();
      localJSONObject = new JSONObject();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$req.event);
      localStringBuilder.append(":cancel");
      localJSONObject.put("errMsg", localStringBuilder.toString());
      this.val$req.evaluateCallbackJs(localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */