package com.tencent.mobileqq.statistics.provider.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.report.api.IRIJNewReport;
import com.tencent.mobileqq.login.LoginConstants;
import com.tencent.mobileqq.qqsec.api.FrozenConstants;
import com.tencent.mobileqq.qroute.QRoute;
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
  
  public String a(AppRuntime paramAppRuntime, ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppRuntime).getServerConfigValue(paramConfigType, paramString);
    }
    return null;
  }
  
  public List<String> a()
  {
    return FrozenConstants.a;
  }
  
  public boolean a(String paramString)
  {
    if ("dc01160".equals(paramString)) {
      return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isEnableUseNewReportChannel();
    }
    return false;
  }
  
  public ReportController b(AppRuntime paramAppRuntime)
  {
    if (ReportDataProviderServiceProvider.a(this.a) == null) {
      try
      {
        if (ReportDataProviderServiceProvider.a(this.a) == null) {
          ReportDataProviderServiceProvider.a(this.a, ReportControllerImpl.b(paramAppRuntime));
        }
      }
      finally {}
    }
    return ReportDataProviderServiceProvider.a(this.a);
  }
  
  public List<String> b()
  {
    return LoginConstants.a;
  }
  
  public ReportController.BusinessDataReporter d()
  {
    return ((IRIJNewReport)QRoute.api(IRIJNewReport.class)).createNewReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.report.ReportDataProviderServiceProvider.1
 * JD-Core Version:    0.7.0.1
 */