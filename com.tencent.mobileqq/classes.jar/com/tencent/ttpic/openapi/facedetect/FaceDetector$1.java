package com.tencent.ttpic.openapi.facedetect;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class FaceDetector$1
  implements SensorEventListener
{
  FaceDetector$1(FaceDetector paramFaceDetector) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor != FaceDetector.access$000(this.this$0)) {
      return;
    }
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    FaceDetector.access$102(this.this$0, Math.atan2(f1, f2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.facedetect.FaceDetector.1
 * JD-Core Version:    0.7.0.1
 */