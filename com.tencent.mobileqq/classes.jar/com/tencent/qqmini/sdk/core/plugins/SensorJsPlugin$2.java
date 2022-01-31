package com.tencent.qqmini.sdk.core.plugins;

import bgkd;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$2
  implements Runnable
{
  SensorJsPlugin$2(SensorJsPlugin paramSensorJsPlugin, bgkd parambgkd) {}
  
  public void run()
  {
    try
    {
      SensorJsPlugin.access$000(this.this$0);
      if (new JSONObject(this.val$req.b).optBoolean("enable"))
      {
        if (this.this$0.startAccelerometer(this.val$req.jdField_a_of_type_Bghn, 3))
        {
          SensorJsPlugin.access$102(this.this$0, true);
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
    if (!SensorJsPlugin.access$100(this.this$0)) {
      this.val$req.a(":fail to disable, not enable?");
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errMsg", this.val$req.jdField_a_of_type_JavaLangString + ":cancel");
      this.val$req.a(localJSONObject.toString());
      return;
      SensorJsPlugin.access$102(this.this$0, false);
      this.val$req.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SensorJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */