package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SecurePhoneBannerManager$1
  implements View.OnClickListener
{
  SecurePhoneBannerManager$1(SecurePhoneBannerManager paramSecurePhoneBannerManager, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    Dialog localDialog = SecurePhoneBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    localDialog.show();
    SecurePhoneBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, this.jdField_a_of_type_AndroidContentContext, localDialog);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C4", "0X800B0C4", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C5", "0X800B0C5", 0, 0, "", "", "", "");
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 24, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SecurePhoneBannerManager.1
 * JD-Core Version:    0.7.0.1
 */