package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.sensor.ApolloGyroSensorEventListener;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;

public class SensorUtil
{
  private static int jdField_a_of_type_Int;
  private static ApolloGyroSensorEventListener jdField_a_of_type_ComTencentMobileqqApolloGameProcessSensorApolloGyroSensorEventListener;
  
  public static void a()
  {
    ApolloGyroSensorEventListener localApolloGyroSensorEventListener = jdField_a_of_type_ComTencentMobileqqApolloGameProcessSensorApolloGyroSensorEventListener;
    if (localApolloGyroSensorEventListener != null) {
      localApolloGyroSensorEventListener.b();
    }
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Int == 0) {
      return;
    }
    Object localObject = CmGameUtil.a(paramInt);
    if (localObject == null) {
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject == null) {
      return;
    }
    localObject = (Vibrator)((Activity)localObject).getSystemService("vibrator");
    if (localObject == null)
    {
      QLog.e("[cmshow]SensorUtil", 1, "Vibrator service is null");
      return;
    }
    if (!((Vibrator)localObject).hasVibrator())
    {
      QLog.e("[cmshow]SensorUtil", 1, "Vibrator is not support");
      return;
    }
    ((Vibrator)localObject).cancel();
    jdField_a_of_type_Int = 0;
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqApolloGameProcessSensorApolloGyroSensorEventListener;
    if (localObject == null)
    {
      localObject = CmGameUtil.a(paramInt1);
      if (localObject == null)
      {
        ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 3, "cs.xy_device_gyro_sensor_start.local", "{}");
        return;
      }
      localObject = ((CmGameLauncher)localObject).a();
      if (localObject == null)
      {
        ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 3, "cs.xy_device_gyro_sensor_start.local", "{}");
        return;
      }
      localObject = ((Activity)localObject).getBaseContext();
      if (localObject == null)
      {
        ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 3, "cs.xy_device_gyro_sensor_start.local", "{}");
        QLog.e("[cmshow]SensorUtil", 1, "context is null");
        return;
      }
      jdField_a_of_type_ComTencentMobileqqApolloGameProcessSensorApolloGyroSensorEventListener = new ApolloGyroSensorEventListener((Context)localObject, paramLong, paramInt2);
    }
    else
    {
      ((ApolloGyroSensorEventListener)localObject).a(paramLong);
    }
    jdField_a_of_type_ComTencentMobileqqApolloGameProcessSensorApolloGyroSensorEventListener.a();
  }
  
  public static void a(int paramInt1, long paramLong, long[] paramArrayOfLong, int paramInt2)
  {
    Object localObject = CmGameUtil.a(paramInt1);
    if (localObject == null) {
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject == null)
    {
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 1, "cs.xy_device_vibrate.local", "{}");
      return;
    }
    localObject = (Vibrator)((Activity)localObject).getSystemService("vibrator");
    if (localObject == null)
    {
      QLog.e("[cmshow]SensorUtil", 1, "Vibrator service is null");
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 2, "cs.xy_device_vibrate.local", "{}");
      return;
    }
    if (!((Vibrator)localObject).hasVibrator())
    {
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 3, "cs.xy_device_vibrate.local", "{}");
      QLog.e("[cmshow]SensorUtil", 1, "Vibrator is not support");
      return;
    }
    if (paramArrayOfLong.length > 1)
    {
      jdField_a_of_type_Int = 1;
      ((Vibrator)localObject).vibrate(paramArrayOfLong, paramInt2);
    }
    else if (paramArrayOfLong.length == 1)
    {
      jdField_a_of_type_Int = 1;
      ((Vibrator)localObject).vibrate(paramArrayOfLong[0]);
    }
    else
    {
      QLog.e("[cmshow]SensorUtil", 1, "Vibrator effect error!");
    }
    ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 0, "cs.xy_device_vibrate.local", "{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SensorUtil
 * JD-Core Version:    0.7.0.1
 */