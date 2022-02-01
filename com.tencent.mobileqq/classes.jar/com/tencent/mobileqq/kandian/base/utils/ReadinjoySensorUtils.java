package com.tencent.mobileqq.kandian.base.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoySensorUtils
  implements SensorEventListener
{
  private static volatile ReadinjoySensorUtils jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadinjoySensorUtils;
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
  
  public static ReadinjoySensorUtils a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadinjoySensorUtils == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadinjoySensorUtils == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadinjoySensorUtils = new ReadinjoySensorUtils();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadinjoySensorUtils;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localObject == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
      this.jdField_a_of_type_AndroidHardwareSensor = ((SensorManager)localObject).getDefaultSensor(4);
    }
    if (this.jdField_b_of_type_AndroidHardwareSensor == null) {
      this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 3);
      this.c = this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_b_of_type_AndroidHardwareSensor, 3);
      this.jdField_a_of_type_Boolean = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("register,gyroscopeEnable=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(" ,accelerometerEnable");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("ReadinjoySensorUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public double[] a()
  {
    return this.jdField_b_of_type_ArrayOfDouble;
  }
  
  public void b()
  {
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localSensorManager != null) {
      localSensorManager.unregisterListener(this);
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
    int i = paramSensorEvent.sensor.getType();
    if (i != 1)
    {
      if (i != 4) {
        return;
      }
      if (this.jdField_b_of_type_Float != 0.0F)
      {
        float f7 = (float)paramSensorEvent.timestamp;
        float f8 = this.jdField_b_of_type_Float;
        float f6 = paramSensorEvent.values[0];
        float f5 = paramSensorEvent.values[1];
        float f4 = paramSensorEvent.values[2];
        double d1 = Math.sqrt(f6 * f6 + f5 * f5 + f4 * f4);
        float f3 = f6;
        float f2 = f5;
        float f1 = f4;
        if (d1 > 9.999999717180685E-010D)
        {
          d2 = f6;
          Double.isNaN(d2);
          f3 = (float)(d2 / d1);
          d2 = f5;
          Double.isNaN(d2);
          f2 = (float)(d2 / d1);
          d2 = f4;
          Double.isNaN(d2);
          f1 = (float)(d2 / d1);
        }
        double d2 = (f7 - f8) * 1.0E-009F;
        Double.isNaN(d2);
        d2 = d1 * d2 / 2.0D;
        d1 = Math.sin(d2);
        d2 = Math.cos(d2);
        localObject = this.jdField_b_of_type_ArrayOfDouble;
        double d3 = f3;
        Double.isNaN(d3);
        localObject[0] = (d3 * d1);
        d3 = f2;
        Double.isNaN(d3);
        localObject[1] = (d3 * d1);
        d3 = f1;
        Double.isNaN(d3);
        localObject[2] = (d1 * d3);
        localObject[3] = d2;
      }
      this.jdField_b_of_type_Float = ((float)paramSensorEvent.timestamp);
      return;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfFloat;
    localObject[0] = (localObject[0] * 0.8F + paramSensorEvent.values[0] * 0.2F);
    localObject = this.jdField_a_of_type_ArrayOfFloat;
    localObject[1] = (localObject[1] * 0.8F + paramSensorEvent.values[1] * 0.2F);
    localObject = this.jdField_a_of_type_ArrayOfFloat;
    localObject[2] = (localObject[2] * 0.8F + paramSensorEvent.values[2] * 0.2F);
    this.jdField_a_of_type_ArrayOfDouble[0] = (paramSensorEvent.values[0] - this.jdField_a_of_type_ArrayOfFloat[0]);
    this.jdField_a_of_type_ArrayOfDouble[1] = (paramSensorEvent.values[1] - this.jdField_a_of_type_ArrayOfFloat[1]);
    this.jdField_a_of_type_ArrayOfDouble[2] = (paramSensorEvent.values[2] - this.jdField_a_of_type_ArrayOfFloat[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ReadinjoySensorUtils
 * JD-Core Version:    0.7.0.1
 */