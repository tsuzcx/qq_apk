package com.tencent.qqperf.tools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import com.tencent.qqperf.opt.suspendthread.SuspendThreadManager;
import com.tencent.qqperf.opt.threadpriority.ThreadOptimizer;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class PerformanceReportUtils$1
  implements Runnable
{
  PerformanceReportUtils$1(int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localHashMap = new HashMap();
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_Int == 10))
        {
          if (!PerformanceReportUtils.jdField_a_of_type_Boolean) {
            break label836;
          }
          i = 0;
          localHashMap.put("actloginTypt", String.valueOf(i));
          localHashMap.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
          if ((!PerformanceReportUtils.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != 10)) {
            localHashMap.put("aio_preloaded", String.valueOf(PerformanceReportUtils.jdField_a_of_type_Int));
          }
          if ((MobileQQ.sMobileQQ.waitAppRuntime(null) != null) && (MobileQQ.sProcessId == 1))
          {
            localHashMap.put("param_is_logining", String.valueOf(((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isLogining()));
            localHashMap.put("param_syncing_msg", String.valueOf(((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isSyncingMsg()));
          }
          localHashMap.put("param_cpu_core_num", String.valueOf(ProcessStats.a()));
          localHashMap.put("param_ram", String.valueOf(DeviceInfoUtil.a()));
          localHashMap.put("suspend_thread_switch", String.valueOf(SuspendThreadManager.jdField_a_of_type_Int));
          if (DeviceOptSwitch.j)
          {
            l1 = System.currentTimeMillis();
            l2 = DeviceOptSwitch.e;
            String str3 = "-1";
            if (l2 == -1L) {
              str1 = "-1";
            } else {
              str1 = String.valueOf(l1 - DeviceOptSwitch.e);
            }
            if (DeviceOptSwitch.b == 0L) {
              break label841;
            }
            localObject2 = String.valueOf(l1 - DeviceOptSwitch.b);
            if (DeviceOptSwitch.jdField_a_of_type_Long == 0L) {
              break label848;
            }
            localObject3 = String.valueOf(l1 - DeviceOptSwitch.jdField_a_of_type_Long);
            if (DeviceOptSwitch.d == 0L) {
              break label855;
            }
            str2 = String.valueOf(l1 - DeviceOptSwitch.d);
            if (DeviceOptSwitch.c != 0L) {
              str3 = String.valueOf(l1 - DeviceOptSwitch.c);
            }
            localHashMap.put("perfConfigReportValue", String.valueOf(DeviceOptSwitch.jdField_a_of_type_Int));
            localHashMap.put("automatorFinishtime", str1);
            localHashMap.put("qZoneInterval", localObject2);
            localHashMap.put("miniInterval", localObject3);
            localHashMap.put("troopListInterval", str2);
            localHashMap.put("preDownloadInterval", str3);
          }
        }
        i = this.jdField_a_of_type_Int;
        if (i != 0) {
          if (i != 1) {
            if (i == 3000) {}
          }
        }
        switch (i)
        {
        case 10: 
          str1 = PerformanceReportUtils.k();
          break;
        case 9: 
          str1 = PerformanceReportUtils.j();
          break;
        case 8: 
          str1 = PerformanceReportUtils.i();
          break;
        case 7: 
          str1 = PerformanceReportUtils.h();
          break;
        case 6: 
          str1 = PerformanceReportUtils.g();
          break;
        case 5: 
          str1 = PerformanceReportUtils.f();
          break;
        case 4: 
          str1 = PerformanceReportUtils.e();
          break;
        case 3: 
          str1 = PerformanceReportUtils.d();
          break;
          str1 = PerformanceReportUtils.c();
          break;
          str1 = PerformanceReportUtils.b();
          break;
          str1 = PerformanceReportUtils.a();
        }
      }
      catch (Exception localException)
      {
        HashMap localHashMap;
        long l1;
        long l2;
        String str1;
        boolean bool;
        return;
      }
      Object localObject2 = PerformanceReportUtils.a();
      if ((str1 != null) && (this.jdField_a_of_type_Long > 0L))
      {
        l1 = ((SharedPreferences)localObject2).getLong(str1, 0L);
        l2 = PerformanceReportUtils.a();
        bool = QLog.isDevelopLevel();
        if (bool)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("reportUISwitch report_time ：");
          ((StringBuilder)localObject3).append(l2);
          ((StringBuilder)localObject3).append(",lastRp");
          ((StringBuilder)localObject3).append(l1);
          ((StringBuilder)localObject3).append(",aioBusiness=");
          ((StringBuilder)localObject3).append(String.valueOf(BusinessRecoderForPerf.a()));
          QLog.d("PerformanceReportUtils", 4, ((StringBuilder)localObject3).toString());
        }
        if ((l1 == 0L) || (SystemClock.uptimeMillis() < l1) || (SystemClock.uptimeMillis() - l1 >= l2))
        {
          if (QLog.isDevelopLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("reportUISwitch timeConsumed ：");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
            ((StringBuilder)localObject3).append(",aioBusiness=");
            ((StringBuilder)localObject3).append(String.valueOf(BusinessRecoderForPerf.a()));
            QLog.d("PerformanceReportUtils", 4, ((StringBuilder)localObject3).toString());
          }
          localHashMap.put("aioBusiness", String.valueOf(BusinessRecoderForPerf.a()));
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(this.jdField_a_of_type_JavaLangString, str1, true, this.jdField_a_of_type_Long, 0L, localHashMap, PerformanceReportUtils.l());
          ((SharedPreferences)localObject2).edit().putLong(str1, SystemClock.uptimeMillis()).commit();
        }
      }
      return;
      label836:
      int i = 1;
      continue;
      label841:
      localObject2 = "-1";
      continue;
      label848:
      Object localObject3 = "-1";
      continue;
      label855:
      String str2 = "-1";
      continue;
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.tools.PerformanceReportUtils.1
 * JD-Core Version:    0.7.0.1
 */