package com.tencent.mobileqq.startup.step;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ProcessInfoUtil
{
  public static int a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if (paramString.compareTo(localRunningAppProcessInfo.processName) == 0) {
              return localRunningAppProcessInfo.pid;
            }
          }
        }
      }
    }
    return -1;
  }
  
  public static int a(String paramString)
  {
    SharedPreferences localSharedPreferences = b();
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pid");
      localStringBuilder.append(paramString);
      return localSharedPreferences.getInt(localStringBuilder.toString(), -1);
    }
    return -1;
  }
  
  public static long a(String paramString)
  {
    int i = a(BaseApplicationImpl.getContext(), paramString);
    if (i == -1) {
      return 0L;
    }
    int j = a(paramString);
    if ((j != -1) && (i == j))
    {
      long l = b(paramString);
      if (l != -1L)
      {
        l = System.currentTimeMillis() - l;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getProcessRunningTime - ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(":");
          localStringBuilder.append(l);
          QLog.d("ProcessUtils", 2, localStringBuilder.toString());
        }
        return l;
      }
    }
    return 0L;
  }
  
  public static void a(String paramString)
  {
    ThreadManager.post(new ProcessInfoUtil.1(paramString), 5, null, true);
  }
  
  public static long b(String paramString)
  {
    SharedPreferences localSharedPreferences = b();
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start_time");
      localStringBuilder.append(paramString);
      return localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
    }
    return -1L;
  }
  
  private static SharedPreferences b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getSharedPreferences("process_info_pref", 4);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.ProcessInfoUtil
 * JD-Core Version:    0.7.0.1
 */