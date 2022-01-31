package com.tencent.mobileqq.msf.sdk.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class a
{
  public static long a()
  {
    Object localObject = BaseApplication.getContext();
    if (localObject != null)
    {
      localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
      return localMemoryInfo.availMem;
    }
    return -1L;
  }
  
  public static void b()
  {
    Object localObject1 = BaseApplication.getContext();
    if (localObject1 != null)
    {
      Object localObject2 = (ActivityManager)((Context)localObject1).getSystemService("activity");
      localObject1 = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject2).getMemoryInfo((ActivityManager.MemoryInfo)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sysTotalMem:").append(((ActivityManager.MemoryInfo)localObject1).totalMem / 1024L / 1024L).append("M");
      ((StringBuilder)localObject2).append("|sysAvailMem:").append(((ActivityManager.MemoryInfo)localObject1).availMem / 1024L / 1024L).append("M");
      ((StringBuilder)localObject2).append("|sysThreshold:").append(((ActivityManager.MemoryInfo)localObject1).threshold / 1014L / 1014L).append("M");
      ((StringBuilder)localObject2).append("|isLowMem:").append(((ActivityManager.MemoryInfo)localObject1).lowMemory);
      QLog.d("SysMemoryInfo", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void c()
  {
    Runtime localRuntime = Runtime.getRuntime();
    if (localRuntime != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("appMaxMem:").append(localRuntime.maxMemory() / 1024L / 1024L).append("M");
      localStringBuilder.append("|appTotalMem:").append(localRuntime.totalMemory() / 1024L / 1024L).append("M");
      localStringBuilder.append("|appFreeMem:").append(localRuntime.freeMemory() / 1014L / 1014L).append("M");
      QLog.d("AppMemoryInfo", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.a
 * JD-Core Version:    0.7.0.1
 */