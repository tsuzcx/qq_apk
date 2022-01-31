package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StartupTracker
{
  public static long a;
  private static ConcurrentHashMap a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
  }
  
  public static void a(String paramString, long paramLong) {}
  
  public static void a(String paramString1, String paramString2) {}
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("AIO_Start_cost");
  }
  
  public static final void b(String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    if (paramString1 != null)
    {
      paramString2 = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      if (paramString2 != null)
      {
        jdField_a_of_type_Long = l - paramString2.longValue();
        paramString1 = paramString1 + ", cost=" + jdField_a_of_type_Long + "|" + QQAppInterface.b + "|" + AIOPreLoadEngine.a;
        if (!QLog.isColorLevel()) {
          break label90;
        }
        QLog.i("AutoMonitor", 2, paramString1);
      }
    }
    label90:
    while (paramString2 == null)
    {
      return;
      Log.i("AutoMonitor", paramString1);
      return;
    }
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, Long.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StartupTracker
 * JD-Core Version:    0.7.0.1
 */