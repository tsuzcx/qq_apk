package com.tencent.mobileqq.msf.service;

import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class k
{
  private static final String A = "sp_boot_time";
  private static final String B = "sp_last_su_time";
  private static final String C = "sp_day_id";
  private static final String D = "sp_s_times";
  private static final int E = 0;
  private static final int F = 1;
  private static final int G = 2;
  private static final int H = 3;
  private static final int I = 4;
  private static int J = 0;
  private static int K = 0;
  private static String L;
  private static long M = 0L;
  private static boolean N = false;
  private static long O = 0L;
  private static int P = -1;
  private static boolean Q = false;
  private static boolean R = false;
  public static int a = 8;
  public static int b = 22;
  public static String c = "MSFAliveManager";
  public static boolean d = false;
  public static final int e = 1;
  public static boolean f = false;
  public static int g = 0;
  public static int h = 0;
  public static int i = 1;
  public static int j = 2;
  public static int k = 0;
  public static int l = 1;
  public static int m = 2;
  public static int n = 3;
  public static int o = 4;
  public static int p = 5;
  public static final String q = "sp_boot_msf";
  public static final int r = 1;
  public static final int s = 2;
  public static boolean t = false;
  public static final String u = "key_action_name";
  public static final String v = "key_from_job";
  private static final long w = 900000L;
  private static boolean x = false;
  private static final String y = "sp_job_ab";
  private static final String z = "sp_key_job_ab_enable";
  
  public static long a(long paramLong)
  {
    return TimeUnit.MILLISECONDS.toDays(paramLong + TimeZone.getDefault().getRawOffset());
  }
  
  public static void a()
  {
    if (R) {
      return;
    }
    for (;;)
    {
      try
      {
        if (Math.random() < 0.009999999776482582D)
        {
          i1 = 1;
          if ((i1 != 0) && (t) && (MsfCore.sCore != null) && (MsfService.core.sender.b.l().c()))
          {
            long l1 = BaseApplication.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).lastUpdateTime;
            l1 = System.currentTimeMillis() - l1;
            String str = c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("intervalTime = ");
            localStringBuilder.append(l1);
            localStringBuilder.append(",model = ");
            localStringBuilder.append(Build.MODEL);
            localStringBuilder.append(",manufacture = ");
            localStringBuilder.append(Build.MANUFACTURER);
            localStringBuilder.append(",startupType = ");
            localStringBuilder.append(String.valueOf(K));
            localStringBuilder.append(",os = ");
            localStringBuilder.append(Build.VERSION.SDK_INT);
            localStringBuilder.append(",sStartupBroadcast = ");
            localStringBuilder.append(L);
            QLog.i(str, 1, localStringBuilder.toString());
            com.tencent.mobileqq.msf.core.c.a.a(MsfCore.sCore, "update_start_rate", "", "", "", 1, "", String.valueOf(K), L, String.valueOf(l1), "", "", "", "");
          }
          R = true;
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(c, 2, "checkReportUpdateBoot", localException);
        }
        return;
      }
      int i1 = 0;
    }
  }
  
  public static void a(Intent paramIntent, int paramInt)
  {
    if (M == 0L)
    {
      J = paramInt;
      M = System.currentTimeMillis();
      if (paramIntent == null)
      {
        K = 1;
      }
      else if (paramIntent.getStringExtra("key_action_name") != null)
      {
        K = 4;
        L = paramIntent.getStringExtra("key_action_name");
      }
      else if (paramIntent.getBooleanExtra("key_from_job", false))
      {
        K = 3;
      }
      else
      {
        K = 2;
      }
      long l2 = System.currentTimeMillis();
      O = l2 - SystemClock.elapsedRealtime();
      paramIntent = BaseApplication.getContext().getSharedPreferences("sp_boot_msf", 0);
      long l3 = paramIntent.getLong("sp_boot_time", 0L);
      long l1 = paramIntent.getLong("sp_last_su_time", 0L);
      if ((l3 != 0L) && (Math.abs(l3 - O) > 120000L) && (O > l1) && (l1 > 0L)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      N = bool1;
      Object localObject = paramIntent.edit();
      ((SharedPreferences.Editor)localObject).putLong("sp_boot_time", O).putLong("sp_last_su_time", l2);
      l2 = paramIntent.getLong("sp_day_id", 0L);
      l3 = (System.currentTimeMillis() + 28800000L) / 86400000L;
      if ((l2 != 0L) && (l2 <= l3))
      {
        if (l2 < l3)
        {
          P = paramIntent.getInt("sp_s_times", 0);
          ((SharedPreferences.Editor)localObject).putLong("sp_day_id", l3).putInt("sp_s_times", 1);
        }
        else
        {
          ((SharedPreferences.Editor)localObject).putInt("sp_s_times", paramIntent.getInt("sp_s_times", 0) + 1);
        }
      }
      else {
        ((SharedPreferences.Editor)localObject).putLong("sp_day_id", 1L + l3).putInt("sp_s_times", 0);
      }
      ((SharedPreferences.Editor)localObject).apply();
      paramIntent = c;
      paramInt = K;
      boolean bool1 = N;
      long l4 = O;
      boolean bool2 = MsfCore.sCore.isOffline();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(P);
      ((StringBuilder)localObject).append(", sFromType = ");
      ((StringBuilder)localObject).append(J);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sStartupBroadcast = ");
      localStringBuilder.append(L);
      QLog.d(paramIntent, 1, new Object[] { "startupType = ", Integer.valueOf(paramInt), ", firstStartup = ", Boolean.valueOf(bool1), ", bootTime = ", Long.valueOf(l4), ", lastStartupTime = ", Long.valueOf(l1), ", isOffline = ", Boolean.valueOf(bool2), ", recordDay = ", Long.valueOf(l2), ", currentDay = ", Long.valueOf(l3), ", times=", localObject, localStringBuilder.toString() });
    }
  }
  
  public static void a(j paramj, boolean paramBoolean)
  {
    d = paramBoolean;
    long l3 = System.currentTimeMillis();
    long l4 = SystemClock.elapsedRealtime();
    long l1 = System.currentTimeMillis();
    long l2 = b(l1);
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSFAliveRecorder onMSFServiceBeginAsync ");
      localStringBuilder.append(l1);
      QLog.d(str, 1, localStringBuilder.toString());
    }
    a.a();
    if ((a.d > 0L) && (Math.abs(a.d - (l3 - l4)) <= 10000L))
    {
      l3 = a(a.c);
      l4 = a(l1);
      if (l3 != l4)
      {
        if (QLog.isColorLevel())
        {
          str = c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("not same day report ");
          localStringBuilder.append(l3);
          localStringBuilder.append(" ");
          localStringBuilder.append(l4);
          QLog.d(str, 1, localStringBuilder.toString());
        }
        a.b(paramj);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          str = c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("fix data ");
          localStringBuilder.append(a.p);
          localStringBuilder.append(" ");
          localStringBuilder.append(a.c);
          QLog.d(str, 1, localStringBuilder.toString());
        }
        if ((l1 > a.c) && (l1 - a.c <= 39600000L))
        {
          if (!a.p) {
            a.o += l1 - a.c;
          }
          a.c = l1;
        }
        else
        {
          a.b();
        }
      }
      if (l2 > b) {
        a.b(paramj);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        str = c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("reboot or bad data ");
        localStringBuilder.append(a.d);
        QLog.d(str, 1, localStringBuilder.toString());
      }
      a.b();
    }
    if (l2 < a) {
      a.b();
    }
    if (l2 <= b) {
      a.a(paramj);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    
    if (!g())
    {
      QLog.d(c, 1, "MSF_Alive_Log reportJobAliveMsf not enable");
      return;
    }
    if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null))
    {
      HashMap localHashMap = new HashMap(8);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject).append("");
      localHashMap.put("osVersion", ((StringBuilder)localObject).toString());
      localHashMap.put("model", Build.MODEL);
      localHashMap.put("manufacture", Build.MANUFACTURER);
      if (paramBoolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("rdminit", localObject);
      MsfCore.sCore.statReporter.a("EvtJobPullMsfAlive", true, 0L, 0L, localHashMap, false, false);
      f = false;
      return;
    }
    f = true;
  }
  
  public static long b(long paramLong)
  {
    return TimeUnit.MILLISECONDS.toHours(paramLong + TimeZone.getDefault().getRawOffset()) % 24L;
  }
  
  public static void b()
  {
    if (Q) {
      return;
    }
    if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null) && (!MsfCore.sCore.isOffline()) && (K != 0))
    {
      boolean bool1;
      if (N ? Math.random() < 0.009999999776482582D : Math.random() < 0.001000000047497451D) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      long l1 = (M - O) / 1000L;
      int i1 = MsfSdkUtils.getAutoStartMode(BaseApplication.getContext());
      Object localObject1;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = c;
        boolean bool2 = N;
        int i2 = K;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(", bootDuration  = ");
        ((StringBuilder)localObject2).append(l1);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("bdAction = ");
        ((StringBuilder)localObject3).append(L);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(", autoMode = ");
        localStringBuilder.append(i1);
        QLog.d((String)localObject1, 2, new Object[] { "report service boot, isFirst = ", Boolean.valueOf(bool2), ", type = ", Integer.valueOf(i2), localObject2, localObject3, ", report = ", Boolean.valueOf(bool1), localStringBuilder.toString() });
      }
      if (bool1)
      {
        localObject1 = new HashMap(8);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
        ((StringBuilder)localObject2).append("");
        ((HashMap)localObject1).put("osVersion", ((StringBuilder)localObject2).toString());
        ((HashMap)localObject1).put("model", Build.MODEL);
        ((HashMap)localObject1).put("manufacture", Build.MANUFACTURER);
        ((HashMap)localObject1).put("startupType", String.valueOf(K));
        ((HashMap)localObject1).put("startupAction", L);
        ((HashMap)localObject1).put("bootDuration", String.valueOf(l1));
        ((HashMap)localObject1).put("autoMode", String.valueOf(i1));
        MsfCore.sCore.statReporter.a("EvtMSFServiceBoot", N, l1, 0L, (Map)localObject1, false, false);
        if ((MsfCore.sCore != null) && (N) && (MsfService.core.sender.b.l().c())) {
          com.tencent.mobileqq.msf.core.c.a.a(MsfCore.sCore, "self_start_rate", "", "", "", 1, "", String.valueOf(K), L, String.valueOf(l1), String.valueOf(i1), "", "", "");
        }
      }
      if (Math.random() < 0.003000000026077032D) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i1 != 0) && (P != -1))
      {
        localObject1 = new HashMap(8);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
        ((StringBuilder)localObject2).append("");
        ((HashMap)localObject1).put("osVersion", ((StringBuilder)localObject2).toString());
        ((HashMap)localObject1).put("model", Build.MODEL);
        ((HashMap)localObject1).put("manufacture", Build.MANUFACTURER);
        ((HashMap)localObject1).put("startTimes", String.valueOf(P));
        MsfCore.sCore.statReporter.a("EvtMSFStartTimes", true, 0L, 0L, (Map)localObject1, false, false);
      }
      Q = true;
      return;
    }
    QLog.e(c, 1, "boot type uninit");
  }
  
  public static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 1, "onMSFServiceDestroy");
    }
    a.c();
  }
  
  public static void d()
  {
    d = false;
  }
  
  public static void e()
  {
    if (!g())
    {
      QLog.d(c, 1, "MSF_Alive_Log add JobScheduler not enable");
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      QLog.d(c, 1, "MSF_Alive_Log add JobScheduler begin");
      if (!x)
      {
        JobScheduler localJobScheduler = (JobScheduler)BaseApplication.getContext().getSystemService("jobscheduler");
        JobInfo.Builder localBuilder = new JobInfo.Builder(1, new ComponentName(BaseApplication.getContext(), MSFAliveJobService.class));
        localBuilder.setPeriodic(900000L);
        localBuilder.setPersisted(true);
        int i1 = 0;
        try
        {
          int i2 = localJobScheduler.schedule(localBuilder.build());
          i1 = i2;
        }
        catch (Throwable localThrowable)
        {
          QLog.d(c, 1, "MSF_Alive_Log add JobScheduler Throwable:", localThrowable);
        }
        if (i1 == 1)
        {
          QLog.d(c, 1, "MSF_Alive_Log add JobScheduler success!");
          x = true;
          return;
        }
        if (i1 == 0) {
          QLog.d(c, 1, "MSF_Alive_Log add JobScheduler fail!");
        }
      }
    }
  }
  
  public static void f()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      ((JobScheduler)BaseApplication.getContext().getSystemService("jobscheduler")).cancel(1);
      QLog.d(c, 1, "MSF_Alive_Log cancel JobScheduler!");
    }
  }
  
  public static boolean g()
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i1 < 21)
    {
      g = p;
    }
    else
    {
      i1 = com.tencent.mobileqq.msf.core.a.a.bw();
      if (i1 == j)
      {
        g = m;
      }
      else if (i1 == h)
      {
        g = l;
      }
      else if (i1 == i)
      {
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_job_ab", 0);
        g = localSharedPreferences.getInt("sp_key_job_ab_enable", k);
        if (g == k)
        {
          if (Math.random() <= 0.5D) {
            i1 = n;
          } else {
            i1 = o;
          }
          g = i1;
          localSharedPreferences.edit().putInt("sp_key_job_ab_enable", g).commit();
          QLog.d(c, 1, new Object[] { "MSF_Alive_Log sample job AB Test: ", Integer.valueOf(g) });
        }
      }
    }
    QLog.d(c, 1, new Object[] { "MSF_Alive_Log get job state = ", Integer.valueOf(g) });
    i1 = g;
    if ((i1 == m) || (i1 == n)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.k
 * JD-Core Version:    0.7.0.1
 */