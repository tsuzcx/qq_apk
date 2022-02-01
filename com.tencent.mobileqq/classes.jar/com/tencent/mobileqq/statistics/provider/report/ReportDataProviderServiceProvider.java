package com.tencent.mobileqq.statistics.provider.report;

import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.statistics.ReportController;

public class ReportDataProviderServiceProvider
  implements Provider<IReportDataProviderService>
{
  private IReportDataProviderService jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIReportDataProviderService;
  private ReportController jdField_a_of_type_ComTencentMobileqqStatisticsReportController;
  
  private IReportDataProviderService b()
  {
    return new ReportDataProviderServiceProvider.1(this);
  }
  
  public IReportDataProviderService a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIReportDataProviderService == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIReportDataProviderService == null) {
          this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIReportDataProviderService = b();
        }
      }
      finally {}
    }
    return this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIReportDataProviderService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.report.ReportDataProviderServiceProvider
 * JD-Core Version:    0.7.0.1
 */