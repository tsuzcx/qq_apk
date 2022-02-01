package com.tencent.mobileqq.onlinestatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime.Status;

class AccountPanel$4
  implements DialogInterface.OnClickListener
{
  AccountPanel$4(AccountPanel paramAccountPanel, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel)))
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.c();
      QQToast.a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel), 1, 2131719505, 1).a();
      return;
    }
    AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, true);
    ReportController.b(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel), "dc00898", "", "", "0X8009DE1", "0X8009DE1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.4
 * JD-Core Version:    0.7.0.1
 */