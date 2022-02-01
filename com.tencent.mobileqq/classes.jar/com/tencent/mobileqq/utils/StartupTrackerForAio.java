package com.tencent.mobileqq.utils;

import android.util.Log;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class StartupTrackerForAio
{
  public static final void a(String paramString1, String paramString2)
  {
    long l = StartupTracker.a(paramString1, paramString2);
    if (l != -1L)
    {
      paramString2 = AIOUtils.a();
      paramString2.append(paramString1);
      paramString2.append(", cost=");
      paramString2.append(l);
      paramString2.append("|");
      paramString2.append(ChatFragment.a);
      paramString2.append("|");
      paramString2.append(AIOPreLoadEngine.a);
      paramString1 = paramString2.toString();
      if (QLog.isColorLevel())
      {
        QLog.i("AutoMonitor", 2, paramString1);
        return;
      }
      Log.i("AutoMonitor", paramString1);
    }
  }
  
  public static boolean a()
  {
    return StartupTracker.a.containsKey("AIO_Start_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StartupTrackerForAio
 * JD-Core Version:    0.7.0.1
 */