package com.tencent.mobileqq.startup.step;

import android.os.Looper;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bridge.ReportControllerServiceHolder;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.logcathook.LogcatHook;
import com.tencent.mobileqq.statistics.CrashReportServiceImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.provider.report.ReportDataProviderServiceProvider;
import com.tencent.mobileqq.statistics.provider.report.ReportServiceProvider;
import com.tencent.mobileqq.statistics.provider.report.TouchEventServiceProvider;
import com.tencent.mobileqq.statistics.provider.statistic.LocalMultiProcConfigServiceProvider;
import com.tencent.mobileqq.statistics.provider.statistic.StaticsCollectorServiceProvider;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneCrashHandler;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Rdm
  extends Step
{
  private static AtomicInteger a = new AtomicInteger(0);
  
  private static void a()
  {
    ReportControllerServiceHolder.a(new ReportDataProviderServiceProvider());
    ReportControllerServiceHolder.b(new TouchEventServiceProvider());
    ReportControllerServiceHolder.c(new ReportServiceProvider());
    ReportControllerServiceHolder.e(new StaticsCollectorServiceProvider());
    ReportControllerServiceHolder.f(new CrashReportServiceImpl());
    ReportControllerServiceHolder.d(new LocalMultiProcConfigServiceProvider());
  }
  
  protected boolean doStep()
  {
    String str2 = BaseApplicationImpl.processName;
    a();
    QLog.d("RdmInit", 1, "doStep process=" + str2 + ", sRdmState=" + a.get());
    if ((a.compareAndSet(0, 1)) && (BaseApplicationImpl.sProcessId != 4)) {}
    for (;;)
    {
      try
      {
        localObject = BaseApplicationImpl.sApplication.getAllAccounts();
        if (localObject == null) {
          continue;
        }
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (localObject == null) {
          break label249;
        }
        localObject = ((SimpleAccount)localObject).getUin();
        if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 7)) {
          continue;
        }
        Thread.setDefaultUncaughtExceptionHandler(new ReportLog());
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).setEnableCrashRecord((String)localObject);
        if (!str2.endsWith(":openSdk")) {
          StatisticCollector.getInstance(BaseApplicationImpl.sApplication).setContact((String)localObject);
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        localException.printStackTrace();
        continue;
        localException.run();
        continue;
      }
      localObject = new Rdm.1(this, str2);
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        ThreadManager.post((Runnable)localObject, 5, null, true);
      }
      try
      {
        if ((!LogcatHook.sLogcatHooked.get()) && (LogcatHook.ENABEL_SYSLOG_IN_RDM)) {
          LogcatHook.startHookLogcat();
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        Log.e("LogcatHook", "LogcatHook start failed !!", localThrowable);
        return true;
      }
      localObject = null;
      continue;
      if (BaseApplicationImpl.sProcessId == 2)
      {
        Thread.setDefaultUncaughtExceptionHandler(new QZoneCrashHandler());
        continue;
        label249:
        String str1 = "10000";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Rdm
 * JD-Core Version:    0.7.0.1
 */