package com.tencent.qqmini.sdk.plugins;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$AccelerometerSensorJsPlugin
  implements SensorEventListener
{
  private static final float COEFFICIENT = 10.0F;
  private IJsService mJsService;
  
  SensorJsPlugin$AccelerometerSensorJsPlugin(SensorJsPlugin paramSensorJsPlugin, @NonNull IJsService paramIJsService)
  {
    this.mJsService = paramIJsService;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (SensorJsPlugin.access$200(this.this$0)) {
      return;
    }
    if (paramSensorEvent.sensor.getType() == 1)
    {
      paramSensorEvent = paramSensorEvent.values;
      float f1 = -paramSensorEvent[0] / 10.0F;
      float f2 = -paramSensorEvent[1] / 10.0F;
      float f3 = -paramSensorEvent[2] / 10.0F;
      try
      {
        paramSensorEvent = new JSONObject();
        paramSensorEvent.put("x", f1);
        paramSensorEvent.put("y", f2);
        paramSensorEvent.put("z", f3);
        SensorJsPlugin.access$300(this.this$0, "onAccelerometerChange", paramSensorEvent.toString(), 0, this.mJsService);
        return;
      }
      catch (JSONException paramSensorEvent)
      {
        paramSensorEvent.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin.AccelerometerSensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */