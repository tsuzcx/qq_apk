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
    int n = 0;
    if ((!i) && (MobileQQ.sProcessId == 1)) {}
    for (;;)
    {
      try
      {
        localObject = a();
        bool = DeviceInfoUtils.b();
        f = ((SharedPreferences)localObject).getBoolean("enable_thread_suspend", false);
        g = ((SharedPreferences)localObject).getBoolean("fake_enable_thread_suspend", false);
        h = ((SharedPreferences)localObject).getBoolean("suspendWhiteListOnly", true);
        SuspendThreadManager.a().a();
        if (!bool) {
          return;
        }
        if (bool) {
          j = true;
        }
        jdField_c_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("disablepreloadproc_new", false);
        jdField_b_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("disablegettrooplist_new", false);
        jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("disablepredownload_new", false);
        jdField_d_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("enableautoperf_new", false);
        if ((jdField_c_of_type_Boolean) || (jdField_b_of_type_Boolean) || (jdField_a_of_type_Boolean)) {
          break label512;
        }
        if (!jdField_d_of_type_Boolean) {
          break label517;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        boolean bool;
        String str1;
        String[] arrayOfString;
        int i1;
        String str2;
        QLog.e("Perf", 1, "enablePerfConfig has Exception:", localThrowable);
      }
      if ((m != 0) && (bool))
      {
        str1 = ((SharedPreferences)localObject).getString("extralsteps_new", "");
        if (!str1.isEmpty())
        {
          arrayOfString = str1.split("\\|");
          if (arrayOfString.length > 0)
          {
            i1 = arrayOfString.length;
            m = 0;
            if (m < i1)
            {
              str2 = arrayOfString[m];
              jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(Integer.parseInt(str2)));
              m += 1;
              continue;
            }
          }
        }
        jdField_a_of_type_JavaUtilSet.clear();
        localObject = ((SharedPreferences)localObject).getString("predownloadwhitelist_new", "");
        if (!((String)localObject).isEmpty())
        {
          arrayOfString = ((String)localObject).split("\\|");
          if (arrayOfString.length > 0)
          {
            i1 = arrayOfString.length;
            m = n;
            if (m < i1)
            {
              str2 = arrayOfString[m];
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
        QLog.d("Perf", 1, "sDisablePreloadProcess:" + jdField_c_of_type_Boolean + ",sDisableGetTroopList:" + jdField_b_of_type_Boolean + ",sDisablePreDownload:" + jdField_a_of_type_Boolean + ",sEnableAutoMatorPerf:" + jdField_d_of_type_Boolean + ",sEnableCpuTimePrint:" + jdField_e_of_type_Boolean + ",extra_imp_steps:" + str1 + ",sPerfConfigReportValue:" + jdField_a_of_type_Int + ",predownload_white_list:" + (String)localObject);
        return;
      }
      return;
      label512:
      int m = 1;
      continue;
      label517:
      m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch
 * JD-Core Version:    0.7.0.1
 */