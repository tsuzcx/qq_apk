package com.tencent.mobileqq.nearby.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.statistics.ReportTask;

public class NearbyReportRunnable
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NearbyCardManager jdField_a_of_type_ComTencentMobileqqNearbyNearbyCardManager;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public NearbyReportRunnable(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyCardManager.b();
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("exp").a(new String[] { "", String.valueOf(i), "", "" }).a();
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyCardManager.b();
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0)) {
      this.jdField_a_of_type_ArrayOfJavaLangString[1] = String.valueOf(i);
    }
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("clk_red").a(this.jdField_a_of_type_ArrayOfJavaLangString).a();
  }
  
  public void a(NearbyCardManager paramNearbyCardManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyCardManager = paramNearbyCardManager;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.NearbyReportRunnable
 * JD-Core Version:    0.7.0.1
 */