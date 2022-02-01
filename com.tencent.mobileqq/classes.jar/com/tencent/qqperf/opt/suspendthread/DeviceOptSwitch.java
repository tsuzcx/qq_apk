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
  public static int a;
  public static long a;
  public static Set<Integer> a;
  public static boolean a;
  public static long b;
  public static Set<Integer> b;
  public static boolean b;
  public static long c;
  public static boolean c;
  public static long d;
  public static boolean d;
  public static long e;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public static boolean i;
  public static boolean j;
  public static boolean k;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    f = false;
    g = false;
    h = true;
    i = false;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
    jdField_d_of_type_Long = 0L;
    j = false;
    jdField_e_of_type_Long = -1L;
    k = false;
    jdField_b_of_type_JavaUtilSet = new HashSet();
  }
  
  public static SharedPreferences a()
  {
    return MobileQQ.getContext().getSharedPreferences("perf_config", 4);
  }
  
  public static void a()
  {
    if ((!i) && (MobileQQ.sProcessId == 1)) {}
    for (;;)
    {
      try
      {
        localObject1 = a();
        bool = DeviceInfoUtils.b();
        f = ((SharedPreferences)localObject1).getBoolean("enable_thread_suspend", false);
        g = ((SharedPreferences)localObject1).getBoolean("fake_enable_thread_suspend", false);
        h = ((SharedPreferences)localObject1).getBoolean("suspendWhiteListOnly", true);
        SuspendThreadManager.a().a();
        if (!bool) {
          return;
        }
        if (bool) {
          j = true;
        }
        jdField_c_of_type_Boolean = ((SharedPreferences)localObject1).getBoolean("disablepreloadproc_new", false);
        jdField_b_of_type_Boolean = ((SharedPreferences)localObject1).getBoolean("disablegettrooplist_new", false);
        jdField_a_of_type_Boolean = ((SharedPreferences)localObject1).getBoolean("disablepredownload_new", false);
        jdField_d_of_type_Boolean = ((SharedPreferences)localObject1).getBoolean("enableautoperf_new", false);
        if ((jdField_c_of_type_Boolean) || (jdField_b_of_type_Boolean) || (jdField_a_of_type_Boolean)) {
          break label563;
        }
        if (!jdField_d_of_type_Boolean) {
          break label558;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        boolean bool;
        String str1;
        Object localObject2;
        int n;
        String str2;
        QLog.e("Perf", 1, "enablePerfConfig has Exception:", localThrowable);
      }
      if ((m != 0) && (bool))
      {
        str1 = ((SharedPreferences)localObject1).getString("extralsteps_new", "");
        bool = str1.isEmpty();
        if (!bool)
        {
          localObject2 = str1.split("\\|");
          if (localObject2.length > 0)
          {
            n = localObject2.length;
            m = 0;
            if (m < n)
            {
              str2 = localObject2[m];
              jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(Integer.parseInt(str2)));
              m += 1;
              continue;
            }
          }
        }
        jdField_a_of_type_JavaUtilSet.clear();
        localObject1 = ((SharedPreferences)localObject1).getString("predownloadwhitelist_new", "");
        if (!((String)localObject1).isEmpty())
        {
          localObject2 = ((String)localObject1).split("\\|");
          if (localObject2.length > 0)
          {
            n = localObject2.length;
            m = 0;
            if (m < n)
            {
              str2 = localObject2[m];
              jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(Integer.parseInt(str2)));
              m += 1;
              continue;
            }
          }
        }
        jdField_a_of_type_Int = 0;
        if (jdField_c_of_type_Boolean) {
          jdField_a_of_type_Int |= 0x1;
        }
        if (jdField_b_of_type_Boolean) {
          jdField_a_of_type_Int |= 0x2;
        }
        if (jdField_a_of_type_Boolean) {
          jdField_a_of_type_Int |= 0x4;
        }
        if (jdField_d_of_type_Boolean) {
          jdField_a_of_type_Int |= 0x8;
        }
        i = true;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sDisablePreloadProcess:");
        ((StringBuilder)localObject2).append(jdField_c_of_type_Boolean);
        ((StringBuilder)localObject2).append(",sDisableGetTroopList:");
        ((StringBuilder)localObject2).append(jdField_b_of_type_Boolean);
        ((StringBuilder)localObject2).append(",sDisablePreDownload:");
        ((StringBuilder)localObject2).append(jdField_a_of_type_Boolean);
        ((StringBuilder)localObject2).append(",sEnableAutoMatorPerf:");
        ((StringBuilder)localObject2).append(jdField_d_of_type_Boolean);
        ((StringBuilder)localObject2).append(",sEnableCpuTimePrint:");
        ((StringBuilder)localObject2).append(jdField_e_of_type_Boolean);
        ((StringBuilder)localObject2).append(",extra_imp_steps:");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(",sPerfConfigReportValue:");
        ((StringBuilder)localObject2).append(jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append(",predownload_white_list:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("Perf", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      return;
      label558:
      int m = 0;
      continue;
      label563:
      m = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch
 * JD-Core Version:    0.7.0.1
 */