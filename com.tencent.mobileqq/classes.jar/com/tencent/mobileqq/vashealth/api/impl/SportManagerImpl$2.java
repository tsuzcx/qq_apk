package com.tencent.mobileqq.vashealth.api.impl;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.qphone.base.util.QLog;

class SportManagerImpl$2
  implements SensorEventListener
{
  SportManagerImpl$2(SportManagerImpl paramSportManagerImpl, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.values[0] <= 1.0E+008F) && (NetConnInfoCenter.getServerTimeMillis() <= this.jdField_a_of_type_Long))
    {
      if ((SSOHttpUtils.jdField_a_of_type_Long != 0L) && (SSOHttpUtils.jdField_a_of_type_Int != 0))
      {
        long l = NetConnInfoCenter.getServerTimeMillis() - SSOHttpUtils.jdField_a_of_type_Long;
        int i = (int)(paramSensorEvent.values[0] - SSOHttpUtils.jdField_a_of_type_Int);
        if ((l > this.jdField_a_of_type_Int) && (i > this.b))
        {
          this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplSportManagerImpl.refreshCurrentStep("timer1 report");
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sensor event step:");
        localStringBuilder.append(paramSensorEvent.values[0]);
        localStringBuilder.append(",cur_total:");
        localStringBuilder.append(SSOHttpUtils.jdField_a_of_type_Int);
        localStringBuilder.append(",interval time:");
        localStringBuilder.append(l);
        QLog.e("SportManager", 1, localStringBuilder.toString());
        return;
      }
      paramSensorEvent = new StringBuilder();
      paramSensorEvent.append("lastReportStepTime:");
      paramSensorEvent.append(SSOHttpUtils.jdField_a_of_type_Long);
      paramSensorEvent.append(",cur_total:");
      paramSensorEvent.append(SSOHttpUtils.jdField_a_of_type_Int);
      QLog.e("SportManager", 1, paramSensorEvent.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unregister listener:");
    localStringBuilder.append(paramSensorEvent.values[0]);
    QLog.e("SportManager", 1, localStringBuilder.toString());
    if (SportManagerImpl.sSensorManager != null) {
      SportManagerImpl.sSensorManager.unregisterListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.SportManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */