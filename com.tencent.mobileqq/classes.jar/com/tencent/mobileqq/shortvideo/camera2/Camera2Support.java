package com.tencent.mobileqq.shortvideo.camera2;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class Camera2Support
{
  public static void a()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 23) {
        return;
      }
      try
      {
        i = Camera2Control.c();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Camera2Support", 1, "reportCamera2DeviceSupport exception, ", localThrowable);
        i = -4;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("camera2SupportLevel", String.valueOf(i));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append("");
      localHashMap.put("osVersion", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("_");
      localStringBuilder.append(Build.MODEL);
      localHashMap.put("deviceName", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "Camera2Support", true, 0L, 0L, localHashMap, "");
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong)
  {
    String str;
    if (paramInt1 == 2) {
      str = "actCapturePhotoCamera2";
    } else {
      str = "actCapturePhotoCamera";
    }
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    localHashMap.put("param_type", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localHashMap.put("param_cost", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    localHashMap.put("param_size", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append("");
    localHashMap.put("param_version", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.MODEL);
    localHashMap.put("param_deviceName", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", str, true, paramLong, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Support
 * JD-Core Version:    0.7.0.1
 */