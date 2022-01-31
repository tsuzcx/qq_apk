package com.tencent.qqmini.sdk.core.plugins;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import bdcy;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$RotationSensorJsPlugin
  implements SensorEventListener
{
  private bdcy jsService;
  
  private SensorJsPlugin$RotationSensorJsPlugin(SensorJsPlugin paramSensorJsPlugin) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 3) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("alpha", paramSensorEvent.values[0]);
      localJSONObject.put("beta", paramSensorEvent.values[1]);
      localJSONObject.put("gamma", paramSensorEvent.values[2]);
      if (this.jsService != null) {
        this.jsService.a("onDeviceMotionChange", localJSONObject.toString(), 0);
      }
      return;
    }
    catch (JSONException paramSensorEvent)
    {
      paramSensorEvent.printStackTrace();
    }
  }
  
  public void setJsService(bdcy parambdcy)
  {
    this.jsService = parambdcy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SensorJsPlugin.RotationSensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */