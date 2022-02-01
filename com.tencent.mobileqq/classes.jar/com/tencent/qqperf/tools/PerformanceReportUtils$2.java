package com.tencent.qqperf.tools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.UnifiedMonitor;
import com.tencent.qqperf.opt.threadpriority.ThreadOptimizer;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class PerformanceReportUtils$2
  extends AsyncTask<Void, Void, Void>
{
  PerformanceReportUtils$2(String paramString1, int paramInt, String paramString2) {}
  
  protected Void a(Void... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        localSharedPreferences = PerformanceReportUtils.a();
        if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_Int <= 0)) {
          break label445;
        }
        if ((this.jdField_a_of_type_Int >= 60) && (QLog.isDevelopLevel())) {
          QLog.e("PerformanceReportUtils", 4, "reportFPS  fps error fpsvalue :" + this.jdField_a_of_type_Int);
        }
        long l1 = localSharedPreferences.getLong(this.jdField_a_of_type_JavaLangString, 0L);
        long l2 = PerformanceReportUtils.a();
        if (QLog.isDevelopLevel()) {
          QLog.d("PerformanceReportUtils", 4, "reportFPS report_time ：" + l2 + ",lastRp" + l1 + ",reportFPS fpsvalue：" + this.jdField_a_of_type_Int);
        }
        if ((l1 == 0L) || (SystemClock.uptimeMillis() < l1)) {
          continue;
        }
        if (SystemClock.uptimeMillis() - l1 < l2) {
          break label447;
        }
      }
      catch (Exception paramVarArgs)
      {
        SharedPreferences localSharedPreferences;
        boolean bool;
        HashMap localHashMap;
        break label445;
        i = 1;
        continue;
      }
      bool = UnifiedMonitor.a().whetherReportThisTime(12, false);
      if ((i != 0) || (bool))
      {
        localHashMap = new HashMap();
        localHashMap.put("param_FPS", String.valueOf(this.jdField_a_of_type_Int));
        localHashMap.put("aioBusiness", this.b);
        localHashMap.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
        if (QLog.isDevelopLevel()) {
          QLog.d("PerformanceReportUtils", 4, "reportFPS real report  fpsvalue：" + this.jdField_a_of_type_Int);
        }
        MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (MobileQQ.sProcessId == 1)
        {
          localHashMap.put("param_is_logining", String.valueOf(((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isLogining()));
          localHashMap.put("param_syncing_msg", String.valueOf(((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isSyncingMsg()));
        }
        if (i != 0)
        {
          paramVarArgs = this.jdField_a_of_type_JavaLangString;
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), paramVarArgs, PerformanceReportUtils.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int, 0L, localHashMap, PerformanceReportUtils.l());
          if (i != 0) {
            localSharedPreferences.edit().putLong(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis()).commit();
          }
        }
        else
        {
          paramVarArgs = this.jdField_a_of_type_JavaLangString + "_new";
          continue;
        }
      }
      label445:
      return null;
      label447:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.tools.PerformanceReportUtils.2
 * JD-Core Version:    0.7.0.1
 */