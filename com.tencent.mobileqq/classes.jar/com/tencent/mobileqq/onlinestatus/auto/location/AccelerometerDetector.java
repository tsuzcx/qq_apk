package com.tencent.mobileqq.onlinestatus.auto.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class AccelerometerDetector
  extends StepMovementDetector
{
  private float jdField_a_of_type_Float = 0.0F;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  private float jdField_b_of_type_Float = 0.0F;
  private boolean jdField_b_of_type_Boolean = false;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[4];
  private float jdField_c_of_type_Float = 0.0F;
  private long jdField_c_of_type_Long = 0L;
  private float jdField_d_of_type_Float = 0.0F;
  private final int jdField_d_of_type_Int = 4;
  private long jdField_d_of_type_Long = 0L;
  private final float jdField_e_of_type_Float = 1.3F;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private float jdField_f_of_type_Float = 2.0F;
  private int jdField_f_of_type_Int = 0;
  private int g = 0;
  private int h = 250;
  
  AccelerometerDetector()
  {
    super(1);
    this.jdField_a_of_type_JavaLangString = "AccelerometerDetector";
  }
  
  private float a(float paramFloat)
  {
    float f1 = this.jdField_f_of_type_Float;
    int i = this.jdField_e_of_type_Int;
    if (i < 4)
    {
      this.jdField_b_of_type_ArrayOfFloat[i] = paramFloat;
      this.jdField_e_of_type_Int = (i + 1);
      return f1;
    }
    f1 = a(this.jdField_b_of_type_ArrayOfFloat, 4);
    float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    System.arraycopy(arrayOfFloat, 1, arrayOfFloat, 0, 3);
    this.jdField_b_of_type_ArrayOfFloat[3] = paramFloat;
    return f1;
  }
  
  private float a(float[] paramArrayOfFloat, int paramInt)
  {
    float f1 = 0.0F;
    int i = 0;
    while (i < paramInt)
    {
      f1 += paramArrayOfFloat[i];
      i += 1;
    }
    f1 /= 4.0F;
    if (f1 >= 8.0F) {
      return 4.3F;
    }
    if ((f1 >= 7.0F) && (f1 < 8.0F)) {
      return 3.3F;
    }
    if ((f1 >= 4.0F) && (f1 < 7.0F)) {
      return 2.3F;
    }
    if ((f1 >= 3.0F) && (f1 < 4.0F)) {
      return 2.0F;
    }
    return 1.3F;
  }
  
  private void a(float paramFloat)
  {
    float f1 = this.jdField_d_of_type_Float;
    if (f1 == 0.0F)
    {
      this.jdField_d_of_type_Float = paramFloat;
    }
    else if (a(paramFloat, f1))
    {
      this.jdField_d_of_type_Long = this.jdField_c_of_type_Long;
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      long l = this.jdField_e_of_type_Long;
      if ((l - this.jdField_d_of_type_Long >= this.h) && (this.jdField_a_of_type_Float - this.jdField_b_of_type_Float >= this.jdField_f_of_type_Float))
      {
        this.jdField_c_of_type_Long = l;
        a();
      }
      l = this.jdField_e_of_type_Long;
      if (l - this.jdField_d_of_type_Long >= this.h)
      {
        f1 = this.jdField_a_of_type_Float;
        float f2 = this.jdField_b_of_type_Float;
        if (f1 - f2 >= 1.3F)
        {
          this.jdField_c_of_type_Long = l;
          this.jdField_f_of_type_Float = a(f1 - f2);
        }
      }
    }
    this.jdField_d_of_type_Float = paramFloat;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (paramFloat1 >= paramFloat2)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_f_of_type_Int += 1;
    }
    else
    {
      this.g = this.jdField_f_of_type_Int;
      this.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && ((this.g >= 2) || (paramFloat2 >= 20.0F)))
    {
      this.jdField_a_of_type_Float = paramFloat2;
      return true;
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_b_of_type_Float = paramFloat2;
    }
    return false;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    System.arraycopy(paramSensorEvent.values, 0, this.jdField_a_of_type_ArrayOfFloat, 0, 3);
    paramSensorEvent = this.jdField_a_of_type_ArrayOfFloat;
    this.jdField_c_of_type_Float = ((float)Math.sqrt(paramSensorEvent[0] * paramSensorEvent[0] + paramSensorEvent[1] * paramSensorEvent[1] + paramSensorEvent[2] * paramSensorEvent[2]));
    a(this.jdField_c_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.AccelerometerDetector
 * JD-Core Version:    0.7.0.1
 */