package com.tencent.mobileqq.shortvideo.panoramicvideo;

import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.SensorHandlerCallback;

class SphereTo2DRenderObj$1
  implements SensorEventHandler.SensorHandlerCallback
{
  SphereTo2DRenderObj$1(SphereTo2DRenderObj paramSphereTo2DRenderObj) {}
  
  public void updateSensorMatrix(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, SphereTo2DRenderObj.access$000(this.this$0), 0, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.SphereTo2DRenderObj.1
 * JD-Core Version:    0.7.0.1
 */