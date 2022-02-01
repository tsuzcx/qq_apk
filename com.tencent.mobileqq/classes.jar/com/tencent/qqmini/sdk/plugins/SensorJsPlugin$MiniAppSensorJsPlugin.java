package com.tencent.qqmini.sdk.plugins;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$MiniAppSensorJsPlugin
  implements SensorEventListener
{
  final float COEFFICENT = 10.0F;
  int accuracy = -1;
  private float[] mAccelerometerValues = new float[3];
  private IJsService mJsService;
  private float[] mMagneticFieldValues = new float[3];
  private float[] mMatrix = new float[9];
  private float[] mValues = new float[3];
  
  SensorJsPlugin$MiniAppSensorJsPlugin(SensorJsPlugin paramSensorJsPlugin, @NonNull IJsService paramIJsService)
  {
    this.mJsService = paramIJsService;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    this.accuracy = paramInt;
  }
  
  public void onCompass(SensorEvent paramSensorEvent)
  {
    if (!SensorJsPlugin.access$100(this.this$0)) {
      return;
    }
    if (paramSensorEvent.sensor.getType() == 1) {
      this.mAccelerometerValues = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.mMagneticFieldValues = paramSensorEvent.values;
    }
    SensorManager.getRotationMatrix(this.mMatrix, null, this.mAccelerometerValues, this.mMagneticFieldValues);
    SensorManager.getOrientation(this.mMatrix, this.mValues);
    float f = (float)Math.toDegrees(this.mValues[0]);
    paramSensorEvent = "unknow ${" + this.accuracy + "}";
    switch (this.accuracy)
    {
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("direction", f);
        localJSONObject.put("accuracy", paramSensorEvent);
        SensorJsPlugin.access$700(this.this$0, "onCompassChange", localJSONObject.toString(), 0, this.mJsService);
        return;
      }
      catch (JSONException paramSensorEvent)
      {
        paramSensorEvent.printStackTrace();
        return;
      }
      paramSensorEvent = "high";
      continue;
      paramSensorEvent = "low";
      continue;
      paramSensorEvent = "medium";
      continue;
      paramSensorEvent = "no-contact";
      continue;
      paramSensorEvent = "unreliable";
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    onCompass(paramSensorEvent);
    float[] arrayOfFloat = paramSensorEvent.values;
    switch (paramSensorEvent.sensor.getType())
    {
    case 9: 
    default: 
      return;
    }
    float f1 = -arrayOfFloat[0] / 10.0F;
    float f2 = -arrayOfFloat[1] / 10.0F;
    float f3 = -arrayOfFloat[2] / 10.0F;
    try
    {
      paramSensorEvent = new JSONObject();
      paramSensorEvent.put("x", f1);
      paramSensorEvent.put("y", f2);
      paramSensorEvent.put("z", f3);
      SensorJsPlugin.access$600(this.this$0, "onAccelerometerChange", paramSensorEvent.toString(), 0, this.mJsService);
      return;
    }
    catch (JSONException paramSensorEvent)
    {
      paramSensorEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin.MiniAppSensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */