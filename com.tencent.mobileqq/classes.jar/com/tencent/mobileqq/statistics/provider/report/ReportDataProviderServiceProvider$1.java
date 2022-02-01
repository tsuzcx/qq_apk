package com.tencent.mobileqq.statistics.provider.report;

import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJNewReportChannelConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.data.RIJNewReporter;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.mobileqq.login.LoginConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportController.BusinessDataReporter;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;

class ReportDataProviderServiceProvider$1
  implements IReportDataProviderService
{
  ReportDataProviderServiceProvider$1(ReportDataProviderServiceProvider paramReportDataProviderServiceProvider) {}
  
  public ReportController.BusinessDataReporter a()
  {
    return new RIJNewReporter();
  }
  
  public ReportController a(AppRuntime paramAppRuntime)
  {
    if (ReportDataProviderServiceProvider.a(this.a) == null) {}
    try
    {
      if (ReportDataProviderServiceProvider.a(this.a) == null) {
        ReportDataProviderServiceProvider.a(this.a, ReportControllerImpl.a(paramAppRuntime));
      }
      return ReportDataProviderServiceProvider.a(this.a);
    }
    finally {}
  }
  
  public String a(AppRuntime paramAppRuntime, ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppRuntime).getServerConfigValue(paramConfigType, paramString);
    }
    return null;
  }
  
  public List<String> a()
  {
    return NotificationActivity.REPORT_TVALUE_NOTIFICATION_LOGIN_TVALUES;
  }
  
  public boolean a(String paramString)
  {
    if ("dc01160".equals(paramString)) {
      return RIJNewReportChannelConfigHandler.a();
    }
    return false;
  }
  
  public List<String> b()
  {
    return LoginConstants.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.report.ReportDataProviderServiceProvider.1
 * JD-Core Version:    0.7.0.1
 */