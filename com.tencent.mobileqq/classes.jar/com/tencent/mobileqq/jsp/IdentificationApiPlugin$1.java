package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.identification.FaceContext;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.statistics.ReportController;

class IdentificationApiPlugin$1
  extends LoginVerifyObserver
{
  IdentificationApiPlugin$1(IdentificationApiPlugin paramIdentificationApiPlugin, FaceContext paramFaceContext) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    ReportController.a(null, "dc00898", "", "", "0X800B0EB", "0X800B0EB", 0, 0, "", "", "", "");
    IdentificationApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin, this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    IdentificationApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin, this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */