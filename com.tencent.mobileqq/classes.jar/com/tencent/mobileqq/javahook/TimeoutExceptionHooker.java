package com.tencent.mobileqq.javahook;

import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class TimeoutExceptionHooker
{
  private static int jdField_a_of_type_Int = 0;
  private static TimeoutExceptionHooker.MyReplaceMethodCallback jdField_a_of_type_ComTencentMobileqqJavahookTimeoutExceptionHooker$MyReplaceMethodCallback = new TimeoutExceptionHooker.MyReplaceMethodCallback(null);
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return;
    }
    try
    {
      JavaHookBridge.findAndReplaceMethod(Class.forName("java.lang.Daemons$FinalizerWatchdogDaemon"), "finalizerTimedOut", new Object[] { Object.class, jdField_a_of_type_ComTencentMobileqqJavahookTimeoutExceptionHooker$MyReplaceMethodCallback });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
  }
  
  private static void b(boolean paramBoolean)
  {
    String str = null;
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {
        str = ((AppRuntime)localObject).getAccount();
      }
      long l1 = Runtime.getRuntime().totalMemory();
      long l2 = Runtime.getRuntime().freeMemory();
      long l3 = Runtime.getRuntime().maxMemory();
      localObject = new HashMap();
      ((HashMap)localObject).put("heapSize", String.valueOf(l1 - l2));
      ((HashMap)localObject).put("maxMemory", String.valueOf(l3));
      int i = jdField_a_of_type_Int + 1;
      jdField_a_of_type_Int = i;
      ((HashMap)localObject).put("count", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, "TimeoutExceptionHooker", paramBoolean, 0L, 0L, (HashMap)localObject, "", true);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.TimeoutExceptionHooker
 * JD-Core Version:    0.7.0.1
 */