package com.tencent.mobileqq.statistics.provider.report;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.soso.LbsInfoReportManager;
import com.tencent.mobileqq.bridge.report.service.IReportService;
import com.tencent.mobileqq.search.report.ReportModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.statistics.CaptureReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.content.ReadInJoyDataProviderObserver;
import mqq.app.AppRuntime;

class ReportServiceProvider$1
  implements IReportService
{
  ReportServiceProvider$1(ReportServiceProvider paramReportServiceProvider) {}
  
  public AppRuntime a(AppRuntime paramAppRuntime)
  {
    Object localObject = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      localObject = paramAppRuntime;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localObject = paramAppRuntime;
        if ((localAppRuntime instanceof QQAppInterface)) {
          localObject = localAppRuntime;
        }
      }
    }
    return localObject;
  }
  
  public void a(Intent paramIntent, AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {}
    for (;;)
    {
      return;
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      int i;
      try
      {
        i = paramIntent.getIntExtra("is_runtime", -1);
        if (i == 1001)
        {
          ((LbsInfoReportManager)paramAppRuntime.getManager(QQManagerFactory.LBS_REPORT_MANAGER)).a(paramIntent);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.d("ReportServiceImpl", 1, paramIntent, new Object[0]);
        return;
      }
      String str1 = paramIntent.getStringExtra("reporting_tag");
      String str2 = paramIntent.getStringExtra("reporting_detail");
      try
      {
        if ("dc02528".equals(str1))
        {
          if (i == 1) {
            UniteSearchReportController.a(str1, paramAppRuntime, (ReportModel)paramIntent.getSerializableExtra("reporting_detail"));
          }
        }
        else if ("dc02181".equals(str1))
        {
          if (i == 0)
          {
            CaptureReportController.b(str1, paramAppRuntime, str2);
            return;
          }
          if (i == 1)
          {
            CaptureReportController.a(str1, paramAppRuntime, str2);
            return;
          }
        }
      }
      catch (OutOfMemoryError paramIntent) {}
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!"CliOper".equals(paramString1)) {
      ReadInJoyDataProviderObserver.a().a(paramString2, paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.report.ReportServiceProvider.1
 * JD-Core Version:    0.7.0.1
 */