package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SecurePhoneBannerManager$6
  implements View.OnClickListener
{
  SecurePhoneBannerManager$6(SecurePhoneBannerManager paramSecurePhoneBannerManager, Context paramContext, Dialog paramDialog, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    SecurePhoneBannerManager.b(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppDialog);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C8", "0X800B0C8", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SecurePhoneBannerManager.6
 * JD-Core Version:    0.7.0.1
 */