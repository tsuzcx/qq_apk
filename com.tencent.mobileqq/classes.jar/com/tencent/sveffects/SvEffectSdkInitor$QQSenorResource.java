package com.tencent.sveffects;

import android.hardware.SensorEventListener;
import com.tencent.av.business.manager.panorama.PanoramaSensorManager;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;

public class SvEffectSdkInitor$QQSenorResource
  implements SensorResource
{
  public boolean checkSensorEnable()
  {
    return PanoramaSensorManager.a().a();
  }
  
  public boolean getCameraIsFront()
  {
    return PanoramaSensorManager.a().b();
  }
  
  public int getRotation()
  {
    return 0;
  }
  
  public void registerListener(SensorEventListener paramSensorEventListener)
  {
    PanoramaSensorManager.a().a(paramSensorEventListener);
  }
  
  public void setCameraChangedListener(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
  {
    PanoramaSensorManager.a().a(paramCameraChangedCallBack);
  }
  
  public void unregisterListener(SensorEventListener paramSensorEventListener)
  {
    PanoramaSensorManager.a().b(paramSensorEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQSenorResource
 * JD-Core Version:    0.7.0.1
 */