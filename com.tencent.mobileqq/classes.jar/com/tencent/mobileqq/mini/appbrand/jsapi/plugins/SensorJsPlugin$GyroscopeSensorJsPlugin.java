package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$GyroscopeSensorJsPlugin
  implements SensorEventListener
{
  private final float NS2S = 1.0E-009F;
  private float[] angle = new float[3];
  private float timestamp;
  
  private SensorJsPlugin$GyroscopeSensorJsPlugin(SensorJsPlugin paramSensorJsPlugin) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1;
    Object localObject;
    float f2;
    float f3;
    if (paramSensorEvent.sensor.getType() == 4) {
      if (this.timestamp != 0.0F)
      {
        f1 = ((float)paramSensorEvent.timestamp - this.timestamp) * 1.0E-009F;
        localObject = this.angle;
        localObject[0] += paramSensorEvent.values[0] * f1;
        localObject = this.angle;
        localObject[1] += paramSensorEvent.values[1] * f1;
        localObject = this.angle;
        f2 = localObject[2];
        localObject[2] = (f1 * paramSensorEvent.values[2] + f2);
        f1 = (float)Math.toDegrees(this.angle[0]);
        f2 = (float)Math.toDegrees(this.angle[1]);
        f3 = (float)Math.toDegrees(this.angle[2]);
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("x", f1);
      ((JSONObject)localObject).put("y", f2);
      ((JSONObject)localObject).put("z", f3);
      this.this$0.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onGyroscopeChange", ((JSONObject)localObject).toString(), 0);
      this.timestamp = ((float)paramSensorEvent.timestamp);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SensorJsPlugin.GyroscopeSensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */