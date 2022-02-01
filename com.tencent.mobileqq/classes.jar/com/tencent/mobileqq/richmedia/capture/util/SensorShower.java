package com.tencent.mobileqq.richmedia.capture.util;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.QLog;

public class SensorShower
{
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private SensorShower.LightSensorListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSensorShower$LightSensorListener;
  private SensorShower.OnGetValue jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSensorShower$OnGetValue;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static SensorShower a()
  {
    return SensorShower.Singleton.a();
  }
  
  public int a(Context paramContext, SensorShower.OnGetValue paramOnGetValue)
  {
    QLog.d("MicroMsg.LightSensor", 1, "SensorShower start");
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("MicroMsg.LightSensor", 1, "[SensorShower.start] light sensor has started");
      return 2;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getApplicationContext().getSystemService("sensor"));
    paramContext = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(5);
    if (paramContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSensorShower$LightSensorListener = new SensorShower.LightSensorListener(this, null);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSensorShower$LightSensorListener, paramContext, 3);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSensorShower$OnGetValue = paramOnGetValue;
      return 0;
    }
    QLog.e("MicroMsg.LightSensor", 1, "[SensorShower.start] System do not have lightSensor");
    return 1;
  }
  
  public void a()
  {
    QLog.d("MicroMsg.LightSensor", 1, "sensorshower stop");
    if (this.jdField_a_of_type_Boolean)
    {
      SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
      if (localSensorManager != null)
      {
        this.jdField_a_of_type_Boolean = false;
        localSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSensorShower$LightSensorListener);
        return;
      }
    }
    QLog.d("MicroMsg.LightSensor", 1, "sensorshower stop mHasStarted is false or mSensorShower is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.SensorShower
 * JD-Core Version:    0.7.0.1
 */