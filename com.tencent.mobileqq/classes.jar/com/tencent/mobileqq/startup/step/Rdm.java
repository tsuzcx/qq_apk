package com.tencent.mobileqq.startup.step;

import ahrk;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.statistics.MTAReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneCrashHandler;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Rdm
  extends Step
{
  private static AtomicInteger a = new AtomicInteger(0);
  
  private void a(String paramString1, String paramString2)
  {
    if (BaseApplicationImpl.sProcessId == 4) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    MTAReportController localMTAReportController = MTAReportController.a(BaseApplicationImpl.sApplication);
    localMTAReportController.a(false);
    localMTAReportController.initMtaConfig("10000665", "AGU36HSC29K4");
    if (!paramString1.endsWith(":openSdk")) {
      localMTAReportController.a(paramString2);
    }
    QLog.d("AutoMonitor", 1, "MTA, cost=" + (SystemClock.uptimeMillis() - l) + " results: true");
  }
  
  protected boolean a()
  {
    String str = BaseApplicationImpl.processName;
    QLog.d("RdmInit", 1, "doStep process=" + str + ", sRdmState=" + a.get());
    if ((a.compareAndSet(0, 1)) && (BaseApplicationImpl.sProcessId != 4)) {}
    for (;;)
    {
      try
      {
        localObject1 = BaseApplicationImpl.sApplication.getAllAccounts();
        if (localObject1 != null)
        {
          localObject1 = (SimpleAccount)((List)localObject1).get(0);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((SimpleAccount)localObject1).getUin();
        }
      }
      catch (Exception localException2)
      {
        Object localObject3;
        Object localObject1 = "10000";
        continue;
        localObject1 = "10000";
        continue;
      }
      try
      {
        if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 7))
        {
          Thread.setDefaultUncaughtExceptionHandler(new ReportLog());
          StatisticCollector.a(BaseApplicationImpl.sApplication).c((String)localObject1);
          Object localObject2 = localObject1;
          if (!str.endsWith(":openSdk"))
          {
            StatisticCollector.a(BaseApplicationImpl.sApplication).a((String)localObject1);
            localObject2 = localObject1;
          }
          localObject1 = new ahrk(this, str);
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            continue;
          }
          ThreadManager.post((Runnable)localObject1, 5, null, true);
          a(str, localObject2);
          return true;
          localObject1 = null;
          continue;
        }
        if (BaseApplicationImpl.sProcessId != 2) {
          continue;
        }
        Thread.setDefaultUncaughtExceptionHandler(new QZoneCrashHandler());
        continue;
        localException1.printStackTrace();
      }
      catch (Exception localException1) {}
      localObject3 = localObject1;
      continue;
      ((Runnable)localObject1).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Rdm
 * JD-Core Version:    0.7.0.1
 */