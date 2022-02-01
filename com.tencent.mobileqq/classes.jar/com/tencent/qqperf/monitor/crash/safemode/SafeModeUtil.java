package com.tencent.qqperf.monitor.crash.safemode;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigJourney;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class SafeModeUtil
{
  public static long a;
  public static long b = -1L;
  private static final int c;
  private static final AtomicBoolean d;
  private static final CountDownLatch e;
  private static boolean f = false;
  
  static
  {
    int i;
    if ((System.currentTimeMillis() & 1L) == 0L) {
      i = 30;
    } else {
      i = 15;
    }
    c = i;
    d = new AtomicBoolean(false);
    e = new CountDownLatch(2);
  }
  
  public static void a()
  {
    QConfigJourney.a().d();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((QQCrashReportManager.i) && (paramContext.getSharedPreferences("pref_safemode_not_exit", 4).getBoolean("key_not_exit_enable", false))) {
      return;
    }
    Object localObject = paramContext.getSharedPreferences("sp_safe_mode", 0);
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      paramInt = ((SharedPreferences)localObject).getInt("key_count_start_fail", 0);
      if (paramInt > 0)
      {
        ((SharedPreferences)localObject).edit().putInt("key_count_start_fail", 0).commit();
        if ((f()) && (paramInt > 3))
        {
          paramContext = StatisticCollector.getInstance(paramContext);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("exitSafeModeStart_");
          ((StringBuilder)localObject).append(c);
          paramContext.collectPerformance("", ((StringBuilder)localObject).toString(), true, 0L, 0L, null, null);
        }
      }
      QConfigJourney.a().c();
      return;
    }
    paramInt = ((SharedPreferences)localObject).getInt("key_count_crash", 0);
    if (paramInt > 0)
    {
      ((SharedPreferences)localObject).edit().putInt("key_count_crash", 0).commit();
      if ((f()) && (paramInt > 3)) {
        StatisticCollector.getInstance(paramContext).collectPerformance("", "exitSafeModeCrash", true, 0L, 0L, null, null);
      }
    }
  }
  
  public static void a(Context paramContext, Object paramObject)
  {
    if ((paramObject != null) && (paramObject.toString().contains("Activity")) && (d.compareAndSet(false, true)))
    {
      paramObject = paramContext.getSharedPreferences("sp_safe_mode", 0);
      int i = paramObject.getInt("key_count_start_fail", 0);
      if ((i > 3) && (f()))
      {
        StatisticCollector localStatisticCollector = StatisticCollector.getInstance(paramContext);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterSafeModeStart_");
        localStringBuilder.append(c);
        localStatisticCollector.collectPerformance("", localStringBuilder.toString(), true, 0L, 0L, null, null);
      }
      QConfigJourney.a().a = true;
      QConfigJourney.a().b = true;
      paramObject.edit().putInt("key_count_start_fail", i + 1).commit();
      ThreadManager.getSubThreadHandler().postDelayed(new SafeModeUtil.1(paramContext), c * 1000L);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getSharedPreferences("sp_safe_mode", 0);
    int i = ((SharedPreferences)localObject).getInt("key_count_crash", 0);
    String str = ((SharedPreferences)localObject).getString("key_crash_info", "");
    long l = ((SharedPreferences)localObject).getLong("key_crash_time", 0L);
    localObject = ((SharedPreferences)localObject).edit();
    if (str.equals(paramString))
    {
      if (Math.abs(System.currentTimeMillis() - l) > 21600000L)
      {
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash", 1);
        ((SharedPreferences.Editor)localObject).putLong("key_crash_time", System.currentTimeMillis());
      }
      else if (i <= 3)
      {
        if ((i == 3) && (f())) {
          StatisticCollector.getInstance(paramContext).collectPerformance("", "enterSafeModeCrash", true, 0L, 0L, null, null);
        }
        QConfigJourney.a().a(false);
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash", i + 1);
      }
    }
    else
    {
      QConfigJourney.a().a(false);
      ((SharedPreferences.Editor)localObject).putInt("key_count_crash", 1);
      ((SharedPreferences.Editor)localObject).putString("key_crash_info", paramString);
      ((SharedPreferences.Editor)localObject).putLong("key_crash_time", System.currentTimeMillis());
    }
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(String paramString) {}
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences("sp_safe_mode", 0);
    int i = paramContext.getInt("key_count_start_fail", 0);
    int j = paramContext.getInt("key_count_crash", 0);
    if ((i > 3) || (j > 3)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((1 != MobileQQ.sProcessId) && (7 != MobileQQ.sProcessId)) {
      return false;
    }
    Object localObject1 = MobileQQ.getContext().getSharedPreferences("pref_safemode_not_exit", 4);
    if (!((SharedPreferences)localObject1).getBoolean("key_not_exit_enable", false)) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
    }
    for (;;)
    {
      int k;
      try
      {
        Object localObject2 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_type", null);
        localObject1 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_stack", null);
        if ((localObject2 == null) || (TextUtils.isEmpty(paramString1))) {
          break label306;
        }
        localObject2 = ((String)localObject2).split("\\|");
        int m = localObject2.length;
        k = 0;
        int i = 0;
        j = i;
        if (k < m)
        {
          Object localObject3 = localObject2[k];
          if (!paramString1.equals(localObject3)) {
            break label297;
          }
          QLog.e("SafeModeUtil", 1, new Object[] { "crashType = ", paramString1, ",crash = ", localObject3 });
          i = 1;
          break label297;
        }
        if ((localObject1 != null) && (!TextUtils.isEmpty(paramString2)))
        {
          paramString1 = ((String)localObject1).split("\\|");
          int n = paramString1.length;
          k = 0;
          i = 0;
          m = i;
          if (k < n)
          {
            localObject1 = paramString1[k];
            if (paramString2.contains((CharSequence)localObject1))
            {
              QLog.e("SafeModeUtil", 1, new Object[] { "crashStack = ", paramString2, ",crash = ", localObject1 });
              i = 1;
            }
            k += 1;
            continue;
          }
        }
        else
        {
          m = 0;
        }
        return (m != 0) && (j != 0);
      }
      catch (Throwable paramString1)
      {
        QLog.e("SafeModeUtil", 1, "isNotExitSafeMode has some error", paramString1);
      }
      return false;
      label297:
      k += 1;
      continue;
      label306:
      int j = 0;
    }
  }
  
  public static void b()
  {
    try
    {
      e.await(10000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public static void c()
  {
    e.countDown();
  }
  
  public static void d() {}
  
  public static void e() {}
  
  private static boolean f()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil
 * JD-Core Version:    0.7.0.1
 */