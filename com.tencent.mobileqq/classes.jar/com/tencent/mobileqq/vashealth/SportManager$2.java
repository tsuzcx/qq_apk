package com.tencent.mobileqq.vashealth;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class SportManager$2
  implements SensorEventListener
{
  SportManager$2(SportManager paramSportManager, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.values[0] > 1.0E+008F) || (NetConnInfoCenter.getServerTimeMillis() > this.jdField_a_of_type_Long))
    {
      QLog.e("SportManager", 1, "unregister listener:" + paramSensorEvent.values[0]);
      if (SportManager.a != null) {
        SportManager.a.unregisterListener(this);
      }
      return;
    }
    if ((SSOHttpUtils.jdField_a_of_type_Long == 0L) || (SSOHttpUtils.jdField_a_of_type_Int == 0))
    {
      QLog.e("SportManager", 1, "lastReportStepTime:" + SSOHttpUtils.jdField_a_of_type_Long + ",cur_total:" + SSOHttpUtils.jdField_a_of_type_Int);
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis() - SSOHttpUtils.jdField_a_of_type_Long;
    int i = (int)(paramSensorEvent.values[0] - SSOHttpUtils.jdField_a_of_type_Int);
    if ((l > this.jdField_a_of_type_Int) && (i > this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqVashealthSportManager.a("timer1 report");
      return;
    }
    QLog.e("SportManager", 1, "sensor event step:" + paramSensorEvent.values[0] + ",cur_total:" + SSOHttpUtils.jdField_a_of_type_Int + ",interval time:" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SportManager.2
 * JD-Core Version:    0.7.0.1
 */