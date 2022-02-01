package com.tencent.ttpic.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.tencent.aekit.api.standard.AEModule;

public class SensorUtil2
  implements SensorEventListener
{
  private float[] mRotationMatrix = new float[16];
  private Sensor mRotationSensor;
  private SensorManager mSensorManager;
  
  public SensorUtil2()
  {
    Matrix.setIdentityM(this.mRotationMatrix, 0);
    if (AEModule.getContext() == null) {
      return;
    }
    this.mSensorManager = ((SensorManager)AEModule.getContext().getSystemService("sensor"));
    this.mRotationSensor = this.mSensorManager.getDefaultSensor(11);
  }
  
  public void getRotation(float[] paramArrayOfFloat)
  {
    try
    {
      System.arraycopy(this.mRotationMatrix, 0, paramArrayOfFloat, 0, 16);
      return;
    }
    finally {}
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    try
    {
      SensorManager.getRotationMatrixFromVector(this.mRotationMatrix, paramSensorEvent.values);
      return;
    }
    finally {}
  }
  
  public void start()
  {
    SensorManager localSensorManager = this.mSensorManager;
    if (localSensorManager != null) {
      localSensorManager.registerListener(this, this.mRotationSensor, 1);
    }
  }
  
  public void stop()
  {
    SensorManager localSensorManager = this.mSensorManager;
    if (localSensorManager != null) {
      localSensorManager.unregisterListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.SensorUtil2
 * JD-Core Version:    0.7.0.1
 */