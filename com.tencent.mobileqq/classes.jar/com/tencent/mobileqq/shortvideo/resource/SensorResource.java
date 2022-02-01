package com.tencent.mobileqq.shortvideo.resource;

import android.hardware.SensorEventListener;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;

public abstract interface SensorResource
{
  public abstract boolean checkSensorEnable();
  
  public abstract boolean getCameraIsFront();
  
  public abstract int getRotation();
  
  public abstract void registerListener(SensorEventListener paramSensorEventListener);
  
  public abstract void setCameraChangedListener(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack);
  
  public abstract void unregisterListener(SensorEventListener paramSensorEventListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.resource.SensorResource
 * JD-Core Version:    0.7.0.1
 */