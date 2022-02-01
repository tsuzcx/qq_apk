package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SecurePhoneBannerManager$3
  implements View.OnClickListener
{
  SecurePhoneBannerManager$3(SecurePhoneBannerManager paramSecurePhoneBannerManager, QQAppInterface paramQQAppInterface, Context paramContext, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    SecurePhoneBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1);
    SecurePhoneBannerManager.b(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppDialog);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C7", "0X800B0C7", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SecurePhoneBannerManager.3
 * JD-Core Version:    0.7.0.1
 */