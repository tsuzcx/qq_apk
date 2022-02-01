import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class phl
  implements SensorEventListener
{
  private static volatile phl jdField_a_of_type_Phl;
  private final float jdField_a_of_type_Float = 0.8F;
  private Context jdField_a_of_type_AndroidContentContext;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private boolean jdField_a_of_type_Boolean = false;
  private double[] jdField_a_of_type_ArrayOfDouble = new double[3];
  private float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  private float jdField_b_of_type_Float;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  private boolean jdField_b_of_type_Boolean;
  private final double[] jdField_b_of_type_ArrayOfDouble = new double[4];
  private boolean c;
  
  public static phl a()
  {
    if (jdField_a_of_type_Phl == null) {}
    try
    {
      if (jdField_a_of_type_Phl == null) {
        jdField_a_of_type_Phl = new phl();
      }
      return jdField_a_of_type_Phl;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor"));
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
        this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(4);
      }
      if (this.jdField_b_of_type_AndroidHardwareSensor == null) {
        this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
      }
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 3);
    this.c = this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_b_of_type_AndroidHardwareSensor, 3);
    this.jdField_a_of_type_Boolean = true;
    QLog.d("ReadinjoySensorUtils", 1, "register,gyroscopeEnable=" + this.jdField_b_of_type_Boolean + " ,accelerometerEnable" + this.c);
  }
  
  public double[] a()
  {
    return this.jdField_b_of_type_ArrayOfDouble;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public double[] b()
  {
    return this.jdField_a_of_type_ArrayOfDouble;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 4: 
      if (this.jdField_b_of_type_Float != 0.0F)
      {
        float f7 = (float)paramSensorEvent.timestamp;
        float f8 = this.jdField_b_of_type_Float;
        float f6 = paramSensorEvent.values[0];
        float f5 = paramSensorEvent.values[1];
        float f4 = paramSensorEvent.values[2];
        double d1 = Math.sqrt(f6 * f6 + f5 * f5 + f4 * f4);
        float f3 = f4;
        float f2 = f5;
        float f1 = f6;
        if (d1 > 9.999999717180685E-010D)
        {
          f1 = (float)(f6 / d1);
          f2 = (float)(f5 / d1);
          f3 = (float)(f4 / d1);
        }
        double d2 = d1 * ((f7 - f8) * 1.0E-009F) / 2.0D;
        d1 = Math.sin(d2);
        d2 = Math.cos(d2);
        this.jdField_b_of_type_ArrayOfDouble[0] = (f1 * d1);
        this.jdField_b_of_type_ArrayOfDouble[1] = (f2 * d1);
        this.jdField_b_of_type_ArrayOfDouble[2] = (f3 * d1);
        this.jdField_b_of_type_ArrayOfDouble[3] = d2;
      }
      this.jdField_b_of_type_Float = ((float)paramSensorEvent.timestamp);
      return;
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = (this.jdField_a_of_type_ArrayOfFloat[0] * 0.8F + paramSensorEvent.values[0] * 0.2F);
    this.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_a_of_type_ArrayOfFloat[1] * 0.8F + paramSensorEvent.values[1] * 0.2F);
    this.jdField_a_of_type_ArrayOfFloat[2] = (this.jdField_a_of_type_ArrayOfFloat[2] * 0.8F + paramSensorEvent.values[2] * 0.2F);
    this.jdField_a_of_type_ArrayOfDouble[0] = (paramSensorEvent.values[0] - this.jdField_a_of_type_ArrayOfFloat[0]);
    this.jdField_a_of_type_ArrayOfDouble[1] = (paramSensorEvent.values[1] - this.jdField_a_of_type_ArrayOfFloat[1]);
    this.jdField_a_of_type_ArrayOfDouble[2] = (paramSensorEvent.values[2] - this.jdField_a_of_type_ArrayOfFloat[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phl
 * JD-Core Version:    0.7.0.1
 */