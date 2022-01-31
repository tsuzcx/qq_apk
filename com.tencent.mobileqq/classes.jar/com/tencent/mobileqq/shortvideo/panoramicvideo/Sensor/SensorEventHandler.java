package com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Utils.SensorUtil;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;
import com.tencent.sveffects.SdkContext;

public class SensorEventHandler
  implements SensorEventListener
{
  public static String TAG = "SensorEventHandler";
  private Context mContext;
  private int mDeviceRotation;
  private float[] rotationMatrix = new float[16];
  private SensorEventHandler.SensorHandlerCallback sensorHandlerCallback;
  private SensorManager sensorManager;
  private boolean sensorRegistered;
  
  public SensorEventHandler(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void init()
  {
    this.sensorRegistered = false;
    if (!SdkContext.getInstance().getResources().getSensorResource().checkSensorEnable()) {
      return;
    }
    SdkContext.getInstance().getResources().getSensorResource().registerListener(this);
    this.sensorRegistered = true;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.accuracy != 0) {}
    switch (paramSensorEvent.sensor.getType())
    {
    default: 
      return;
    }
    this.mDeviceRotation = SdkContext.getInstance().getResources().getSensorResource().getRotation();
    SensorUtil.sensorRotationVectorToMatrix(paramSensorEvent, this.mDeviceRotation, this.rotationMatrix);
    this.sensorHandlerCallback.updateSensorMatrix(this.rotationMatrix);
  }
  
  public void releaseResources()
  {
    if (!this.sensorRegistered) {
      return;
    }
    SdkContext.getInstance().getResources().getSensorResource().unregisterListener(this);
    this.sensorRegistered = false;
  }
  
  public void setSensorHandlerCallback(SensorEventHandler.SensorHandlerCallback paramSensorHandlerCallback)
  {
    this.sensorHandlerCallback = paramSensorHandlerCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler
 * JD-Core Version:    0.7.0.1
 */