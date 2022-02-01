package com.tencent.qqmini.sdk.plugins;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$GyroscopeSensorJsPlugin
  implements SensorEventListener
{
  private final float NS2S = 1.0E-009F;
  private float[] angle = new float[3];
  private IJsService mJsService;
  private float timestamp;
  
  SensorJsPlugin$GyroscopeSensorJsPlugin(SensorJsPlugin paramSensorJsPlugin, @NonNull IJsService paramIJsService)
  {
    this.mJsService = paramIJsService;
  }
  
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
      SensorJsPlugin.access$800(this.this$0, "onGyroscopeChange", ((JSONObject)localObject).toString(), 0, this.mJsService);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin.GyroscopeSensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */