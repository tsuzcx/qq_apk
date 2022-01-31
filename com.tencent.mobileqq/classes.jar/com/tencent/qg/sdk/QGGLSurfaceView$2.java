package com.tencent.qg.sdk;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class QGGLSurfaceView$2
  implements SensorEventListener
{
  private long timestamp;
  
  QGGLSurfaceView$2(QGGLSurfaceView paramQGGLSurfaceView) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor == null) {}
    do
    {
      return;
      if (paramSensorEvent.sensor.getType() == 3)
      {
        f1 = paramSensorEvent.values[0];
        f2 = -paramSensorEvent.values[1];
        f3 = -paramSensorEvent.values[2];
        this.this$0.mRenderer.nativeOnSensorChanged(3, 360.0F - f1, f2, f3);
        return;
      }
    } while (paramSensorEvent.sensor.getType() != 1);
    QGGLSurfaceView.access$000(this.this$0)[0] = (QGGLSurfaceView.access$000(this.this$0)[0] * 0.8F + paramSensorEvent.values[0] * 0.2F);
    QGGLSurfaceView.access$000(this.this$0)[1] = (QGGLSurfaceView.access$000(this.this$0)[1] * 0.8F + paramSensorEvent.values[1] * 0.2F);
    QGGLSurfaceView.access$000(this.this$0)[2] = (QGGLSurfaceView.access$000(this.this$0)[2] * 0.8F + paramSensorEvent.values[2] * 0.2F);
    float f1 = paramSensorEvent.values[0];
    float f2 = QGGLSurfaceView.access$000(this.this$0)[0];
    float f3 = paramSensorEvent.values[1];
    float f4 = QGGLSurfaceView.access$000(this.this$0)[1];
    float f5 = paramSensorEvent.values[2];
    float f6 = QGGLSurfaceView.access$000(this.this$0)[2];
    this.this$0.mRenderer.nativeOnSensorChanged(1, f1 - f2, f3 - f4, f5 - f6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.QGGLSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */