package com.tencent.qqmini.sdk.core.plugins;

import bgkd;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$1
  implements Runnable
{
  SensorJsPlugin$1(SensorJsPlugin paramSensorJsPlugin, bgkd parambgkd) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        SensorJsPlugin.access$000(this.this$0);
        JSONObject localJSONObject1 = new JSONObject(this.val$req.b);
        if (localJSONObject1.optBoolean("enable"))
        {
          j = localJSONObject1.optInt("interval");
          i = 3;
          if (j != 20) {
            break label157;
          }
          i = 1;
          if (this.this$0.startAccelerometer(this.val$req.jdField_a_of_type_Bghn, i))
          {
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
      this.this$0.stopAccelerometer();
      this.val$req.a();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("errMsg", this.val$req.jdField_a_of_type_JavaLangString + ":cancel");
      this.val$req.a(localJSONObject2.toString());
      return;
      label157:
      if (j == 60) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SensorJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */