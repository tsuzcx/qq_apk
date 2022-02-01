package com.tencent.mobileqq.statistics.provider.report;

import com.tencent.mobileqq.bridge.report.service.IReportService;
import com.tencent.mobileqq.data.entitymanager.Provider;

public class ReportServiceProvider
  implements Provider<IReportService>
{
  private IReportService a;
  
  private IReportService b()
  {
    return new ReportServiceProvider.1(this);
  }
  
  public IReportService a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.report.ReportServiceProvider
 * JD-Core Version:    0.7.0.1
 */