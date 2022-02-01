package com.tencent.qqmini.sdk.plugins;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$RotationSensorJsPlugin
  implements SensorEventListener
{
  private IJsService mJsService;
  
  SensorJsPlugin$RotationSensorJsPlugin(SensorJsPlugin paramSensorJsPlugin, @NonNull IJsService paramIJsService)
  {
    this.mJsService = paramIJsService;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (SensorJsPlugin.access$200(this.this$0)) {
      return;
    }
    if (paramSensorEvent.sensor.getType() == 3) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("alpha", paramSensorEvent.values[0]);
        localJSONObject.put("beta", paramSensorEvent.values[1]);
        localJSONObject.put("gamma", paramSensorEvent.values[2]);
        if (this.mJsService != null)
        {
          this.mJsService.evaluateSubscribeJS("onDeviceMotionChange", localJSONObject.toString(), 0);
          return;
        }
      }
      catch (JSONException paramSensorEvent)
      {
        paramSensorEvent.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin.RotationSensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */