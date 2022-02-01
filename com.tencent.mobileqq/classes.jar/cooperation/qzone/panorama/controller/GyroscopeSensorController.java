package cooperation.qzone.panorama.controller;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class GyroscopeSensorController
  implements SensorEventListener
{
  private static final float NS2S = 1.0E-009F;
  private static final float SENSOR_SENSITIVITY = 1.0F;
  private float[] angle = new float[3];
  private Sensor mGyroscope;
  private SensorManager mSensorManager;
  private float[] preAngle = new float[3];
  private GyroscopeSensorController.SensorChangeListener sensorChangeListener;
  private long timestamp;
  
  public GyroscopeSensorController(Context paramContext, GyroscopeSensorController.SensorChangeListener paramSensorChangeListener)
  {
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.mGyroscope = this.mSensorManager.getDefaultSensor(4);
    this.sensorChangeListener = paramSensorChangeListener;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 4)
    {
      if (this.timestamp != 0L)
      {
        float f1 = (float)(paramSensorEvent.timestamp - this.timestamp) * 1.0E-009F;
        float[] arrayOfFloat = this.angle;
        arrayOfFloat[0] += paramSensorEvent.values[0] * f1;
        arrayOfFloat = this.angle;
        arrayOfFloat[1] += paramSensorEvent.values[1] * f1;
        arrayOfFloat = this.angle;
        float f2 = arrayOfFloat[2];
        arrayOfFloat[2] = (f1 * paramSensorEvent.values[2] + f2);
        f1 = (float)Math.toDegrees(this.angle[0] - this.preAngle[0]);
        f2 = (float)Math.toDegrees(this.angle[1] - this.preAngle[1]);
        float f3 = (float)Math.toDegrees(this.angle[2] - this.preAngle[2]);
        if (this.sensorChangeListener != null) {
          this.sensorChangeListener.onSensorChange(f1 * 1.0F, f2 * 1.0F, f3 * 1.0F);
        }
        this.preAngle[0] = this.angle[0];
        this.preAngle[1] = this.angle[1];
        this.preAngle[2] = this.angle[2];
      }
      this.timestamp = paramSensorEvent.timestamp;
    }
  }
  
  public void registerGyroscopeListener()
  {
    this.mSensorManager.registerListener(this, this.mGyroscope, 1);
  }
  
  public void unregisterGyroscopeListener()
  {
    this.mSensorManager.unregisterListener(this, this.mGyroscope);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.controller.GyroscopeSensorController
 * JD-Core Version:    0.7.0.1
 */