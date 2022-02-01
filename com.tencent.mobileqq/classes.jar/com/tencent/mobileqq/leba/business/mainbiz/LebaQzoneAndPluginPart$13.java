package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.statistics.ReportTask;

class LebaQzoneAndPluginPart$13
  implements Runnable
{
  LebaQzoneAndPluginPart$13(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, INearbyCardManager paramINearbyCardManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyINearbyCardManager.b();
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("exp").a(new String[] { "", String.valueOf(i), "", "" }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.13
 * JD-Core Version:    0.7.0.1
 */