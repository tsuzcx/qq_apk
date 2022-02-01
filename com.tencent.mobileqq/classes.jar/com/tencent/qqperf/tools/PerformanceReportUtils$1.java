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
        HashMap localHashMap = new HashMap();
        Object localObject;
        long l1;
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_Int == 10))
        {
          if (!PerformanceReportUtils.jdField_a_of_type_Boolean) {
            break label831;
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
            localObject = "-1";
            String str2 = "-1";
            String str3 = "-1";
            String str4 = "-1";
            l1 = System.currentTimeMillis();
            if (DeviceOptSwitch.e != -1L) {
              continue;
            }
            str1 = "-1";
            if (DeviceOptSwitch.b != 0L) {
              localObject = String.valueOf(l1 - DeviceOptSwitch.b);
            }
            if (DeviceOptSwitch.jdField_a_of_type_Long != 0L) {
              str2 = String.valueOf(l1 - DeviceOptSwitch.jdField_a_of_type_Long);
            }
            if (DeviceOptSwitch.d != 0L) {
              str3 = String.valueOf(l1 - DeviceOptSwitch.d);
            }
            if (DeviceOptSwitch.c != 0L) {
              str4 = String.valueOf(l1 - DeviceOptSwitch.c);
            }
            localHashMap.put("perfConfigReportValue", String.valueOf(DeviceOptSwitch.jdField_a_of_type_Int));
            localHashMap.put("automatorFinishtime", str1);
            localHashMap.put("qZoneInterval", localObject);
            localHashMap.put("miniInterval", str2);
            localHashMap.put("troopListInterval", str3);
            localHashMap.put("preDownloadInterval", str4);
          }
        }
        String str1 = null;
        switch (this.jdField_a_of_type_Int)
        {
        case 0: 
          localObject = PerformanceReportUtils.a();
          if ((str1 != null) && (this.jdField_a_of_type_Long > 0L))
          {
            l1 = ((SharedPreferences)localObject).getLong(str1, 0L);
            long l2 = PerformanceReportUtils.a();
            if (QLog.isDevelopLevel()) {
              QLog.d("PerformanceReportUtils", 4, "reportUISwitch report_time ：" + l2 + ",lastRp" + l1 + ",aioBusiness=" + String.valueOf(BusinessRecoderForPerf.a()));
            }
            if ((l1 == 0L) || (SystemClock.uptimeMillis() < l1) || (SystemClock.uptimeMillis() - l1 >= l2))
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("PerformanceReportUtils", 4, "reportUISwitch timeConsumed ：" + this.jdField_a_of_type_Long + ",aioBusiness=" + String.valueOf(BusinessRecoderForPerf.a()));
              }
              localHashMap.put("aioBusiness", String.valueOf(BusinessRecoderForPerf.a()));
              StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(this.jdField_a_of_type_JavaLangString, str1, true, this.jdField_a_of_type_Long, 0L, localHashMap, PerformanceReportUtils.l());
              ((SharedPreferences)localObject).edit().putLong(str1, SystemClock.uptimeMillis()).commit();
              return;
              str1 = String.valueOf(l1 - DeviceOptSwitch.e);
              continue;
              str1 = PerformanceReportUtils.a();
            }
          }
          break;
        case 1: 
          str1 = PerformanceReportUtils.b();
          break;
        case 3000: 
          str1 = PerformanceReportUtils.c();
          break;
        case 3: 
          str1 = PerformanceReportUtils.d();
          break;
        case 4: 
          str1 = PerformanceReportUtils.e();
          break;
        case 5: 
          str1 = PerformanceReportUtils.f();
          break;
        case 6: 
          str1 = PerformanceReportUtils.g();
          break;
        case 7: 
          str1 = PerformanceReportUtils.h();
          break;
        case 8: 
          str1 = PerformanceReportUtils.i();
          break;
        case 9: 
          str1 = PerformanceReportUtils.j();
          break;
        case 10: 
          str1 = PerformanceReportUtils.k();
          break;
        default: 
          continue;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      return;
      label831:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.tools.PerformanceReportUtils.1
 * JD-Core Version:    0.7.0.1
 */