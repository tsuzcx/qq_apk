package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.mobileqq.bridge.ReportControllerServiceHolder;
import com.tencent.mobileqq.bridge.report.service.IReportService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class ReportReceiver$ReportRunner
  implements Runnable
{
  private Intent a;
  
  public ReportReceiver$ReportRunner(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  private void a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime != null)
    {
      if (!"com.tencent.mobileqq".equals(MobileQQ.sMobileQQ.getQQProcessName())) {
        return;
      }
      int i = this.a.getIntExtra("is_runtime", -1);
      Object localObject = this.a.getStringExtra("reporting_tag");
      if (a(i, (String)localObject))
      {
        String str = this.a.getStringExtra("reporting_detail");
        int j = this.a.getIntExtra("reporting_count", 1);
        if (i == 0)
        {
          ReportController.b(localAppRuntime, (String)localObject, str, j);
          return;
        }
        if (i == 1) {
          ReportController.a(localAppRuntime, (String)localObject, str, j);
        }
      }
      else
      {
        localObject = ReportControllerServiceHolder.a();
        if (localObject != null) {
          ((IReportService)localObject).a(this.a, localAppRuntime);
        }
      }
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (paramInt == 1001) {
      return false;
    }
    if ("dc02528".equals(paramString)) {
      return false;
    }
    if ("dc02181".equals(paramString)) {
      return false;
    }
    return !"dc_qqgame".equals(paramString);
  }
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ReportReceiver", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportReceiver.ReportRunner
 * JD-Core Version:    0.7.0.1
 */