package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.troop.widget.BaseUsingTimeReport;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;

public class NearbyUsingTimeReport
  extends BaseUsingTimeReport
{
  private NearbyAppInterface a;
  
  public NearbyUsingTimeReport(NearbyAppInterface paramNearbyAppInterface, String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public UsingTimeReportManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return null;
    }
    return (UsingTimeReportManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(220);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.reportClickEvent("dc00899", this.jdField_a_of_type_JavaLangString, "", this.b, this.c, 0, 0, String.valueOf(paramLong), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUsingTimeReport
 * JD-Core Version:    0.7.0.1
 */