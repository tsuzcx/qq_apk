package com.tencent.qqperf.tools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.perf.report.FeatureFlag;
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
        long l1;
        long l2;
        if ((this.a == 0) || (this.a == 1) || (this.a == 3000) || (this.a == 10))
        {
          if (!PerformanceReportUtils.a) {
            break label708;
          }
          i = 0;
          localHashMap.put("actloginTypt", String.valueOf(i));
          localHashMap.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().c()));
          if ((!PerformanceReportUtils.a) && (this.a != 10)) {
            localHashMap.put("aio_preloaded", String.valueOf(PerformanceReportUtils.b));
          }
          if ((MobileQQ.sMobileQQ.waitAppRuntime(null) != null) && (MobileQQ.sProcessId == 1))
          {
            localHashMap.put("param_is_logining", String.valueOf(((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isLogining()));
            localHashMap.put("param_syncing_msg", String.valueOf(((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isSyncingMsg()));
          }
          localHashMap.put("param_cpu_core_num", String.valueOf(ProcessStats.b()));
          localHashMap.put("param_ram", String.valueOf(DeviceInfoUtil.a()));
          localHashMap.put("suspend_thread_switch", String.valueOf(SuspendThreadManager.a));
          if (DeviceOptSwitch.p)
          {
            l1 = System.currentTimeMillis();
            l2 = DeviceOptSwitch.q;
            String str3 = "-1";
            if (l2 == -1L) {
              str1 = "-1";
            } else {
              str1 = String.valueOf(l1 - DeviceOptSwitch.q);
            }
            if (DeviceOptSwitch.m == 0L) {
              break label713;
            }
            localObject1 = String.valueOf(l1 - DeviceOptSwitch.m);
            if (DeviceOptSwitch.l == 0L) {
              break label720;
            }
            localObject2 = String.valueOf(l1 - DeviceOptSwitch.l);
            if (DeviceOptSwitch.o == 0L) {
              break label727;
            }
            str2 = String.valueOf(l1 - DeviceOptSwitch.o);
            if (DeviceOptSwitch.n != 0L) {
              str3 = String.valueOf(l1 - DeviceOptSwitch.n);
            }
            localHashMap.put("perfConfigReportValue", String.valueOf(DeviceOptSwitch.k));
            localHashMap.put("automatorFinishtime", str1);
            localHashMap.put("qZoneInterval", localObject1);
            localHashMap.put("miniInterval", localObject2);
            localHashMap.put("troopListInterval", str2);
            localHashMap.put("preDownloadInterval", str3);
          }
        }
        if (this.a != 10) {
          PerformanceReportUtils.a = true;
        }
        String str1 = PerformanceReportUtils.a(this.a);
        localObject1 = PerformanceReportUtils.a();
        if ((str1 != null) && (this.b > 0L))
        {
          l1 = ((SharedPreferences)localObject1).getLong(str1, 0L);
          l2 = PerformanceReportUtils.b();
          boolean bool = QLog.isDevelopLevel();
          if (bool)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reportUISwitch report_time ：");
            ((StringBuilder)localObject2).append(l2);
            ((StringBuilder)localObject2).append(",lastRp");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append(",aioBusiness=");
            ((StringBuilder)localObject2).append(String.valueOf(BusinessRecoderForPerf.a()));
            QLog.d("PerformanceReportUtils", 4, ((StringBuilder)localObject2).toString());
          }
          if ((l1 == 0L) || (SystemClock.uptimeMillis() < l1) || (SystemClock.uptimeMillis() - l1 >= l2))
          {
            if (QLog.isDevelopLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("reportUISwitch timeConsumed ：");
              ((StringBuilder)localObject2).append(this.b);
              ((StringBuilder)localObject2).append(",aioBusiness=");
              ((StringBuilder)localObject2).append(String.valueOf(BusinessRecoderForPerf.a()));
              QLog.d("PerformanceReportUtils", 4, ((StringBuilder)localObject2).toString());
            }
            localHashMap.put("aioBusiness", String.valueOf(BusinessRecoderForPerf.a()));
            FeatureFlag.a(localHashMap);
            StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(this.c, str1, true, this.b, 0L, localHashMap, PerformanceReportUtils.c());
            ((SharedPreferences)localObject1).edit().putLong(str1, SystemClock.uptimeMillis()).commit();
          }
        }
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      label708:
      int i = 1;
      continue;
      label713:
      Object localObject1 = "-1";
      continue;
      label720:
      Object localObject2 = "-1";
      continue;
      label727:
      String str2 = "-1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.tools.PerformanceReportUtils.1
 * JD-Core Version:    0.7.0.1
 */