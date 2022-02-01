package com.tencent.mobileqq.utils;

import aewu;
import amxv;
import anbx;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import bcad;
import bfwz;
import bfyg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.ServerConfigManager.ConfigType;

public final class PerformanceReportUtils$1
  implements Runnable
{
  public PerformanceReportUtils$1(int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject1 = bfyg.a(ServerConfigManager.ConfigType.common, bfwz.b());
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportUISwitch openStr ：" + (String)localObject1);
    }
    if ((localObject1 == null) || (!"1".equals(localObject1))) {
      return;
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        Object localObject2;
        String str1;
        long l1;
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_Int == 10))
        {
          if (!QQAppInterface.AIO_HAD_OPEN) {
            break label995;
          }
          i = 0;
          localHashMap.put("actloginTypt", String.valueOf(i));
          localHashMap.put("param_threadOpId", String.valueOf(anbx.a().a()));
          if ((!QQAppInterface.AIO_HAD_OPEN) && (this.jdField_a_of_type_Int != 10))
          {
            QQAppInterface.AIO_HAD_OPEN = true;
            localHashMap.put("aio_preloaded", String.valueOf(aewu.jdField_a_of_type_Int));
          }
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
          {
            if (((QQAppInterface)localObject1).mAutomator.jdField_a_of_type_Long == 0L) {
              break label1000;
            }
            bool = true;
            localHashMap.put("param_is_logining", String.valueOf(bool));
            if (((QQAppInterface)localObject1).mAutomator.c()) {
              break label1005;
            }
            bool = true;
            localHashMap.put("param_syncing_msg", String.valueOf(bool));
            localHashMap.put("inActionLoginB", String.valueOf(((QQAppInterface)localObject1).mAutomator.a()));
          }
          localHashMap.put("param_cpu_core_num", String.valueOf(amxv.a()));
          localHashMap.put("param_ram", String.valueOf(DeviceInfoUtil.getSystemTotalMemory()));
          localHashMap.put("suspend_thread_switch", String.valueOf(SuspendThreadManager.jdField_a_of_type_Int));
          if (bcad.l)
          {
            localObject2 = "-1";
            str1 = "-1";
            String str2 = "-1";
            String str3 = "-1";
            l1 = System.currentTimeMillis();
            if (AutomatorFinish.jdField_a_of_type_Long != -1L) {
              continue;
            }
            localObject1 = "-1";
            if (bcad.e != 0L) {
              localObject2 = String.valueOf(l1 - bcad.e);
            }
            if (bcad.d != 0L) {
              str1 = String.valueOf(l1 - bcad.d);
            }
            if (bcad.g != 0L) {
              str2 = String.valueOf(l1 - bcad.g);
            }
            if (bcad.f != 0L) {
              str3 = String.valueOf(l1 - bcad.f);
            }
            localHashMap.put("perfConfigReportValue", String.valueOf(bcad.c));
            localHashMap.put("automatorFinishtime", localObject1);
            localHashMap.put("qZoneInterval", localObject2);
            localHashMap.put("miniInterval", str1);
            localHashMap.put("troopListInterval", str2);
            localHashMap.put("preDownloadInterval", str3);
          }
        }
        localObject1 = null;
        long l2;
        switch (this.jdField_a_of_type_Int)
        {
        case 0: 
          localObject2 = bfwz.a();
          if ((localObject1 == null) || (this.jdField_a_of_type_Long <= 0L)) {
            break;
          }
          l2 = ((SharedPreferences)localObject2).getLong((String)localObject1, 0L);
          l1 = bfwz.a();
          str1 = bfyg.a(ServerConfigManager.ConfigType.common, bfwz.n());
          if (str1 != null) {
            if (QLog.isDevelopLevel()) {
              QLog.d("PerformanceReportUtils", 4, "reportUISwitch  server time：" + str1);
            }
          }
        case 1: 
        case 3000: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
          try
          {
            l1 = Long.valueOf(str1).longValue();
            l1 *= 1000L;
          }
          catch (Exception localException2)
          {
            l1 = bfwz.a();
            continue;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("PerformanceReportUtils", 4, "reportUISwitch report_time ：" + l1 + ",lastRp" + l2 + ",aioBusiness=" + bfwz.a());
          }
          if ((l2 != 0L) && (SystemClock.uptimeMillis() >= l2) && (SystemClock.uptimeMillis() - l2 < l1)) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("PerformanceReportUtils", 4, "reportUISwitch timeConsumed ：" + this.jdField_a_of_type_Long + ",aioBusiness=" + bfwz.a());
          }
          localHashMap.put("aioBusiness", bfwz.a());
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_JavaLangString, (String)localObject1, true, this.jdField_a_of_type_Long, 0L, localHashMap, bfwz.o());
          ((SharedPreferences)localObject2).edit().putLong((String)localObject1, SystemClock.uptimeMillis()).commit();
          return;
          localObject1 = String.valueOf(l1 - AutomatorFinish.jdField_a_of_type_Long);
          continue;
          localObject1 = bfwz.c();
          continue;
          localObject1 = bfwz.d();
          continue;
          localObject1 = bfwz.e();
          continue;
          localObject1 = bfwz.f();
          continue;
          localObject1 = bfwz.g();
          continue;
          localObject1 = bfwz.h();
          continue;
          localObject1 = bfwz.i();
          continue;
          localObject1 = bfwz.j();
          continue;
          localObject1 = bfwz.k();
          continue;
          localObject1 = bfwz.l();
          continue;
          localObject1 = bfwz.m();
          break;
        }
        int i = 1;
      }
      catch (Exception localException1)
      {
        return;
      }
      label995:
      continue;
      label1000:
      boolean bool = false;
      continue;
      label1005:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PerformanceReportUtils.1
 * JD-Core Version:    0.7.0.1
 */