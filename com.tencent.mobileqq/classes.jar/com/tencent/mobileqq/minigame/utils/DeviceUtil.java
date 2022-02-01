package com.tencent.mobileqq.minigame.utils;

import android.os.Build.VERSION;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class DeviceUtil
{
  public static int getDeviceBenchmarkLevel()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        return 0;
      }
      int k = DeviceInfoUtil.getCpuNumber();
      if (k <= 0) {
        return -1;
      }
      int m = (int)(DeviceInfoUtil.getCpuMaxFreq() / 100000L);
      if (m <= 0) {
        return -1;
      }
      int n = (int)(DeviceInfoUtil.getSystemTotalMemory() / 1048576L);
      if (n <= 0) {
        return -1;
      }
      int j = (k * 200 + m * m * 10 + n / 1024 * (n / 1024) * 100) / 400;
      int i = j;
      if (j > 50) {
        i = 50;
      }
      QLog.d("getDeviceBenchmarkLevel", 1, "getDeviceBenchmarkLevel coreNum:" + k + " cpuFreq:" + m + " ramSize:" + n + " score:" + i);
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("getDeviceBenchmarkLevel", 1, "getDeviceBenchmarkLevel error", localThrowable);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */