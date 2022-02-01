package com.tencent.mobileqq.startup.step;

import android.os.Looper;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bridge.ReportControllerServiceHolder;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.provider.report.ReportDataProviderServiceProvider;
import com.tencent.mobileqq.statistics.provider.report.ReportServiceProvider;
import com.tencent.mobileqq.statistics.provider.report.TouchEventServiceProvider;
import com.tencent.mobileqq.statistics.provider.statistic.LocalMultiProcConfigServiceProvider;
import com.tencent.mobileqq.statistics.provider.statistic.StaticsCollectorServiceProvider;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashHandleListener;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import com.tencent.qqperf.monitor.crash.ReportLog;
import com.tencent.qqperf.monitor.logcathook.LogcatHook;
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
    ReportControllerServiceHolder.d(new LocalMultiProcConfigServiceProvider());
  }
  
  private boolean a()
  {
    if (b())
    {
      QLog.d("RdmInit", 1, "is studyroom biz, need ignore do step.");
      return true;
    }
    return false;
  }
  
  private boolean b()
  {
    return (BaseApplicationImpl.sProcessId == -1) && (BaseApplicationImpl.processName != null) && (BaseApplicationImpl.processName.endsWith(":live"));
  }
  
  protected boolean doStep()
  {
    if (a()) {
      return true;
    }
    String str = BaseApplicationImpl.processName;
    a();
    Object localObject1 = new StringBuilder("doStep process=");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(", sRdmState=");
    ((StringBuilder)localObject1).append(a.get());
    QLog.d("RdmInit", 1, ((StringBuilder)localObject1).toString());
    if ((a.compareAndSet(0, 1)) && (BaseApplicationImpl.sProcessId != 4)) {}
    for (;;)
    {
      try
      {
        localObject1 = BaseApplicationImpl.sApplication.getAllAccounts();
        if (localObject1 == null) {
          break label281;
        }
        localObject1 = (SimpleAccount)((List)localObject1).get(0);
        if (localObject1 != null) {
          localObject1 = ((SimpleAccount)localObject1).getUin();
        } else {
          localObject1 = "10000";
        }
        if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 7))
        {
          if (BaseApplicationImpl.sProcessId == 2) {
            Thread.setDefaultUncaughtExceptionHandler(new QZoneCrashHandler());
          }
        }
        else {
          Thread.setDefaultUncaughtExceptionHandler(new ReportLog());
        }
        QQCrashReportManager.a().a((String)localObject1, new QQCrashHandleListener());
        if (!str.endsWith(":openSdk"))
        {
          StatisticCollector.getInstance(BaseApplicationImpl.sApplication).setContact((String)localObject1);
          QQCrashReportManager.a((String)localObject1);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Rdm.1 local1 = new Rdm.1(this, str);
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        ThreadManager.post(local1, 5, null, true);
      } else {
        local1.run();
      }
      try
      {
        if ((!LogcatHook.sLogcatHooked.get()) && (LogcatHook.ENABEL_SYSLOG_IN_RDM))
        {
          LogcatHook.startHookLogcat();
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("LogcatHook", "LogcatHook start failed !!", localThrowable);
      }
      return true;
      label281:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Rdm
 * JD-Core Version:    0.7.0.1
 */