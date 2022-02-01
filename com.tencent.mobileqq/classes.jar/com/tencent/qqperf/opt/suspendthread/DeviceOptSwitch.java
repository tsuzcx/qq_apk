package com.tencent.qqperf.opt.suspendthread;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;

public class DeviceOptSwitch
{
  public static Set<Integer> a = new HashSet();
  public static boolean b = false;
  public static boolean c = false;
  public static boolean d = false;
  public static boolean e = false;
  public static boolean f = false;
  public static boolean g = false;
  public static boolean h = false;
  public static boolean i = true;
  public static boolean j = false;
  public static int k = 0;
  public static long l = 0L;
  public static long m = 0L;
  public static long n = 0L;
  public static long o = 0L;
  public static boolean p = false;
  public static long q = -1L;
  public static boolean r = false;
  public static Set<Integer> s = new HashSet();
  
  public static SharedPreferences a()
  {
    return MobileQQ.getContext().getSharedPreferences("perf_config", 4);
  }
  
  public static void b()
  {
    if ((!j) && (MobileQQ.sProcessId == 1)) {}
    for (;;)
    {
      try
      {
        localObject1 = a();
        bool = DeviceInfoUtils.isLowPerfDevice();
        g = ((SharedPreferences)localObject1).getBoolean("enable_thread_suspend", false);
        h = ((SharedPreferences)localObject1).getBoolean("fake_enable_thread_suspend", false);
        i = ((SharedPreferences)localObject1).getBoolean("suspendWhiteListOnly", true);
        SuspendThreadManager.a().b();
        if (!bool) {
          return;
        }
        if (bool) {
          p = true;
        }
        d = ((SharedPreferences)localObject1).getBoolean("disablepreloadproc_new", false);
        c = ((SharedPreferences)localObject1).getBoolean("disablegettrooplist_new", false);
        b = ((SharedPreferences)localObject1).getBoolean("disablepredownload_new", false);
        e = ((SharedPreferences)localObject1).getBoolean("enableautoperf_new", false);
        if ((d) || (c) || (b)) {
          break label563;
        }
        if (!e) {
          break label558;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        boolean bool;
        String str1;
        Object localObject2;
        int i2;
        String str2;
        QLog.e("Perf", 1, "enablePerfConfig has Exception:", localThrowable);
      }
      if ((i1 != 0) && (bool))
      {
        str1 = ((SharedPreferences)localObject1).getString("extralsteps_new", "");
        bool = str1.isEmpty();
        if (!bool)
        {
          localObject2 = str1.split("\\|");
          if (localObject2.length > 0)
          {
            i2 = localObject2.length;
            i1 = 0;
            if (i1 < i2)
            {
              str2 = localObject2[i1];
              s.add(Integer.valueOf(Integer.parseInt(str2)));
              i1 += 1;
              continue;
            }
          }
        }
        a.clear();
        localObject1 = ((SharedPreferences)localObject1).getString("predownloadwhitelist_new", "");
        if (!((String)localObject1).isEmpty())
        {
          localObject2 = ((String)localObject1).split("\\|");
          if (localObject2.length > 0)
          {
            i2 = localObject2.length;
            i1 = 0;
            if (i1 < i2)
            {
              str2 = localObject2[i1];
              a.add(Integer.valueOf(Integer.parseInt(str2)));
              i1 += 1;
              continue;
            }
          }
        }
        k = 0;
        if (d) {
          k |= 0x1;
        }
        if (c) {
          k |= 0x2;
        }
        if (b) {
          k |= 0x4;
        }
        if (e) {
          k |= 0x8;
        }
        j = true;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sDisablePreloadProcess:");
        ((StringBuilder)localObject2).append(d);
        ((StringBuilder)localObject2).append(",sDisableGetTroopList:");
        ((StringBuilder)localObject2).append(c);
        ((StringBuilder)localObject2).append(",sDisablePreDownload:");
        ((StringBuilder)localObject2).append(b);
        ((StringBuilder)localObject2).append(",sEnableAutoMatorPerf:");
        ((StringBuilder)localObject2).append(e);
        ((StringBuilder)localObject2).append(",sEnableCpuTimePrint:");
        ((StringBuilder)localObject2).append(f);
        ((StringBuilder)localObject2).append(",extra_imp_steps:");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(",sPerfConfigReportValue:");
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append(",predownload_white_list:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("Perf", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      return;
      label558:
      int i1 = 0;
      continue;
      label563:
      i1 = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch
 * JD-Core Version:    0.7.0.1
 */