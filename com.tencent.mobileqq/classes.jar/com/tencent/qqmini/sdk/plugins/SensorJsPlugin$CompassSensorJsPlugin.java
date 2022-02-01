package com.tencent.qqmini.sdk.plugins;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$CompassSensorJsPlugin
  implements SensorEventListener
{
  int accuracy = -1;
  private float[] mAccelerometerValues = new float[3];
  private IJsService mJsService;
  private float[] mMagneticFieldValues = new float[3];
  private float[] mMatrix = new float[9];
  private float[] mValues = new float[3];
  
  SensorJsPlugin$CompassSensorJsPlugin(SensorJsPlugin paramSensorJsPlugin, @NonNull IJsService paramIJsService)
  {
    this.mJsService = paramIJsService;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    this.accuracy = paramInt;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (SensorJsPlugin.access$200(this.this$0)) {
      return;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.mMagneticFieldValues = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 1)
    {
      this.mAccelerometerValues = paramSensorEvent.values;
      SensorManager.getRotationMatrix(this.mMatrix, null, this.mAccelerometerValues, this.mMagneticFieldValues);
      SensorManager.getOrientation(this.mMatrix, this.mValues);
      float f = (float)Math.toDegrees(this.mValues[0]);
      paramSensorEvent = new StringBuilder();
      paramSensorEvent.append("unknow ${");
      paramSensorEvent.append(this.accuracy);
      paramSensorEvent.append("}");
      paramSensorEvent = paramSensorEvent.toString();
      int i = this.accuracy;
      if (i != -1)
      {
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i == 3) {
                paramSensorEvent = "high";
              }
            }
            else {
              paramSensorEvent = "medium";
            }
          }
          else {
            paramSensorEvent = "low";
          }
        }
        else {
          paramSensorEvent = "unreliable";
        }
      }
      else {
        paramSensorEvent = "no-contact";
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("direction", f);
        localJSONObject.put("accuracy", paramSensorEvent);
        SensorJsPlugin.access$400(this.this$0, "onCompassChange", localJSONObject.toString(), 0, this.mJsService);
        return;
      }
      catch (JSONException paramSensorEvent)
      {
        paramSensorEvent.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin.CompassSensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */