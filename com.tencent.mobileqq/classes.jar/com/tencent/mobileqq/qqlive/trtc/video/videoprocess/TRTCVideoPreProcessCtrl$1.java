package com.tencent.mobileqq.qqlive.trtc.video.videoprocess;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.qqlive.filter.QQLiveAEFilterProcess;

class TRTCVideoPreProcessCtrl$1
  implements SensorEventListener
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (TRTCVideoPreProcessCtrl.a(this.a) != null) {
      TRTCVideoPreProcessCtrl.a(this.a).a(paramSensorEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.videoprocess.TRTCVideoPreProcessCtrl.1
 * JD-Core Version:    0.7.0.1
 */