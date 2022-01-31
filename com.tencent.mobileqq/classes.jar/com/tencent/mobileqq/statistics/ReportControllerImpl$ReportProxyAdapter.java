package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;

public class ReportControllerImpl$ReportProxyAdapter
  extends BaseProxy
{
  public ReportControllerImpl$ReportProxyAdapter(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  protected void a()
  {
    ReportController localReportController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localReportController != null) && ((localReportController instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localReportController).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
  
  protected void b()
  {
    ReportController localReportController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localReportController != null) && ((localReportController instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localReportController).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportControllerImpl.ReportProxyAdapter
 * JD-Core Version:    0.7.0.1
 */