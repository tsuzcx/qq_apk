package com.tencent.mobileqq.shortvideo.hwcodec;

import android.os.Build.VERSION;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class HwEnvData
{
  public static int a = 1500;
  public static boolean a = false;
  public static boolean b = false;
  
  public static boolean a()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] supportHardWareCodec:SDK_INT=");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append("dpcSupportHwCodec=");
      localStringBuilder.append(a);
      QLog.d("HwEnvData", 2, localStringBuilder.toString());
    }
    boolean bool = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeature(CameraCompatibleConstants.r);
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] supportHardWareCodec:black=");
        localStringBuilder.append(bool);
        QLog.d("HwEnvData", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (Build.VERSION.SDK_INT < 18) {
      return false;
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData
 * JD-Core Version:    0.7.0.1
 */