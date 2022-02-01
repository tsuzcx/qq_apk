package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.leba.controller.LebaController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class Leba$4$1
  implements Runnable
{
  Leba$4$1(Leba.4 param4, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaLeba$4.this$0.m();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLeba$4.this$0.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLeba$4.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqLebaLeba$4.this$0.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshLebaConfig. lebaData size=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqLebaLeba$4.this$0.jdField_a_of_type_JavaUtilList.size());
      QLog.i("LebaFrame", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLeba$4.this$0.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLeba$4.this$0.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.a(true);
      this.jdField_a_of_type_ComTencentMobileqqLebaLeba$4.this$0.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.b();
      if (QLog.isColorLevel()) {
        QLog.i("LebaFrame", 2, "refreshLebaConfig. notifyData.");
      }
      Leba.a(this.jdField_a_of_type_ComTencentMobileqqLebaLeba$4.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.4.1
 * JD-Core Version:    0.7.0.1
 */