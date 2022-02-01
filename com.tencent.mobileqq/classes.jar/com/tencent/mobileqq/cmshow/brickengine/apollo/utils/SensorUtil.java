package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.app.Activity;
import android.os.Vibrator;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;

public class SensorUtil
{
  private static int a;
  
  public static void a(int paramInt)
  {
    if (a == 0) {
      return;
    }
    Object localObject = CmGameUtil.a(paramInt);
    if (localObject == null) {
      return;
    }
    localObject = ((CmGameLauncher)localObject).f();
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
    a = 0;
  }
  
  public static void a(int paramInt1, long paramLong, long[] paramArrayOfLong, int paramInt2)
  {
    Object localObject = CmGameUtil.a(paramInt1);
    if (localObject == null) {
      return;
    }
    localObject = ((CmGameLauncher)localObject).f();
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
      a = 1;
      ((Vibrator)localObject).vibrate(paramArrayOfLong, paramInt2);
    }
    else if (paramArrayOfLong.length == 1)
    {
      a = 1;
      ((Vibrator)localObject).vibrate(paramArrayOfLong[0]);
    }
    else
    {
      QLog.e("[cmshow]SensorUtil", 1, "Vibrator effect error!");
    }
    ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 0, "cs.xy_device_vibrate.local", "{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SensorUtil
 * JD-Core Version:    0.7.0.1
 */