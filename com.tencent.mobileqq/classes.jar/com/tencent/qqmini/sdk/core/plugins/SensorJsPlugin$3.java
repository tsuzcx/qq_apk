package com.tencent.qqmini.sdk.core.plugins;

import bdfz;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$3
  implements Runnable
{
  SensorJsPlugin$3(SensorJsPlugin paramSensorJsPlugin, bdfz parambdfz) {}
  
  public void run()
  {
    int i = 1;
    for (;;)
    {
      int j;
      try
      {
        SensorJsPlugin.access$000(this.this$0);
        JSONObject localJSONObject1 = new JSONObject(this.val$req.b);
        if (localJSONObject1.optBoolean("enable"))
        {
          j = localJSONObject1.optInt("interval");
          if (j != 20) {
            break label201;
          }
          if (this.this$0.startGyroscope(this.val$req.jdField_a_of_type_Bdcy, i))
          {
            SensorJsPlugin.access$202(this.this$0, true);
            this.val$req.a();
            return;
          }
          this.val$req.b();
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      this.this$0.stopGyroscope();
      if (!SensorJsPlugin.access$200(this.this$0)) {
        this.val$req.a(":fail to disable, not enable?");
      }
      for (;;)
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("errMsg", this.val$req.jdField_a_of_type_JavaLangString + ":cancel");
        this.val$req.a(localJSONObject2.toString());
        return;
        SensorJsPlugin.access$202(this.this$0, false);
        this.val$req.a();
      }
      label201:
      while (j != 60)
      {
        JSONObject localJSONObject2;
        i = 3;
        break;
      }
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SensorJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */