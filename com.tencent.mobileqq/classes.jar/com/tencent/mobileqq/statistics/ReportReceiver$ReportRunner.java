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
    if ((localAppRuntime == null) || (!"com.tencent.mobileqq".equals(MobileQQ.sMobileQQ.getQQProcessName()))) {}
    Object localObject;
    do
    {
      int i;
      String str;
      int j;
      do
      {
        return;
        i = this.a.getIntExtra("is_runtime", -1);
        localObject = this.a.getStringExtra("reporting_tag");
        if (!a(i, (String)localObject)) {
          break;
        }
        str = this.a.getStringExtra("reporting_detail");
        j = this.a.getIntExtra("reporting_count", 1);
        if (i == 0)
        {
          ReportController.b(localAppRuntime, (String)localObject, str, j);
          return;
        }
      } while (i != 1);
      ReportController.a(localAppRuntime, (String)localObject, str, j);
      return;
      localObject = ReportControllerServiceHolder.a();
    } while (localObject == null);
    ((IReportService)localObject).a(this.a, localAppRuntime);
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (paramInt == 1001) {}
    while (("dc02528".equals(paramString)) || ("dc02181".equals(paramString)) || ("dc_qqgame".equals(paramString))) {
      return false;
    }
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportReceiver.ReportRunner
 * JD-Core Version:    0.7.0.1
 */