package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.identification.FaceAreaManager;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.statistics.ReportController;

class IdentificationApiPlugin$1
  extends LoginVerifyObserver
{
  IdentificationApiPlugin$1(IdentificationApiPlugin paramIdentificationApiPlugin, FaceAreaManager paramFaceAreaManager) {}
  
  public void ipJudgeSuccess(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceAreaManager);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    ReportController.a(null, "dc00898", "", "", "0X800B0EB", "0X800B0EB", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqJspIdentificationApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceAreaManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */