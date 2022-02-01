package com.tencent.sveffects;

import android.hardware.SensorEventListener;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;
import lhw;

public class SvEffectSdkInitor$QQSenorResource
  implements SensorResource
{
  public boolean checkSensorEnable()
  {
    return lhw.a().a();
  }
  
  public boolean getCameraIsFront()
  {
    return lhw.a().b();
  }
  
  public int getRotation()
  {
    return 0;
  }
  
  public void registerListener(SensorEventListener paramSensorEventListener)
  {
    lhw.a().a(paramSensorEventListener);
  }
  
  public void setCameraChangedListener(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
  {
    lhw.a().a(paramCameraChangedCallBack);
  }
  
  public void unregisterListener(SensorEventListener paramSensorEventListener)
  {
    lhw.a().b(paramSensorEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQSenorResource
 * JD-Core Version:    0.7.0.1
 */