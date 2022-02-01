package com.tencent.mobileqq.statistics.provider.report;

import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.statistics.ReportController;

public class ReportDataProviderServiceProvider
  implements Provider<IReportDataProviderService>
{
  private IReportDataProviderService a;
  private ReportController b;
  
  private IReportDataProviderService b()
  {
    return new ReportDataProviderServiceProvider.1(this);
  }
  
  public IReportDataProviderService a()
  {
    if (this.a == null) {
      try
      {
        if (this.a == null) {
          this.a = b();
        }
      }
      finally {}
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.report.ReportDataProviderServiceProvider
 * JD-Core Version:    0.7.0.1
 */