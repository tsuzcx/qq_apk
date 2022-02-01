package com.tencent.mobileqq.utils;

import android.util.Log;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class StartupTrackerForAio
{
  public static final void a(String paramString1, String paramString2)
  {
    long l = StartupTracker.a(paramString1, paramString2);
    if (l != -1L)
    {
      paramString1 = paramString1 + ", cost=" + l + "|" + ChatFragment.a + "|" + AIOPreLoadEngine.a;
      if (QLog.isColorLevel()) {
        QLog.i("AutoMonitor", 2, paramString1);
      }
    }
    else
    {
      return;
    }
    Log.i("AutoMonitor", paramString1);
  }
  
  public static boolean a()
  {
    return StartupTracker.a.containsKey("AIO_Start_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StartupTrackerForAio
 * JD-Core Version:    0.7.0.1
 */