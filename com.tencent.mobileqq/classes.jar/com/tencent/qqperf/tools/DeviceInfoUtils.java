package com.tencent.qqperf.tools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import com.tencent.qqperf.opt.suspendthread.LowEndPerfBean;
import com.tencent.qqperf.opt.suspendthread.LowEndPerfProcessor;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeviceInfoUtils
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = 0L;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static int b = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static int a()
  {
    int i = c();
    if (i != 0) {
      return i;
    }
    if (b == 0) {
      b = b();
    }
    return b;
  }
  
  public static boolean a()
  {
    return a() == 1;
  }
  
  private static int b()
  {
    int j = DeviceOptSwitch.a().getInt("localLevel", 0);
    int i = j;
    long l2;
    if (j == 0)
    {
      i = DeviceInfoUtil.b();
      long l1 = DeviceInfoUtil.c();
      l2 = DeviceInfoUtil.a();
      if ((i < 8) || (l1 < 2000000L) || (l2 < 5368709120L)) {
        break label79;
      }
      i = 1;
    }
    for (;;)
    {
      DeviceOptSwitch.a().edit().putInt("localLevel", i).apply();
      return i;
      label79:
      if ((i <= 6) || (l2 <= 3221225472L)) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  public static boolean b()
  {
    return a() == 3;
  }
  
  private static int c()
  {
    int i = 0;
    if (jdField_a_of_type_Int != 0) {
      i = jdField_a_of_type_Int;
    }
    do
    {
      return i;
      if (!LowEndPerfProcessor.a().a()) {
        break;
      }
    } while (jdField_a_of_type_Int == 0);
    jdField_a_of_type_Int = 0;
    DeviceOptSwitch.a().edit().putInt("device_perf_level", 0).apply();
    return 0;
    SharedPreferences localSharedPreferences = DeviceOptSwitch.a();
    jdField_a_of_type_Int = localSharedPreferences.getInt("device_perf_level", 0);
    if (jdField_a_of_type_Int != 0) {
      return jdField_a_of_type_Int;
    }
    if (jdField_a_of_type_Long == 0L) {
      jdField_a_of_type_Long = localSharedPreferences.getLong("device_perf_level_timestamps", 0L);
    }
    if (Math.abs(jdField_a_of_type_Long - System.currentTimeMillis()) < -1702967296L) {
      return jdField_a_of_type_Int;
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      return jdField_a_of_type_Int;
    }
    ThreadManagerV2.excute(new DeviceInfoUtils.1(localSharedPreferences), 128, null, true);
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.tools.DeviceInfoUtils
 * JD-Core Version:    0.7.0.1
 */