package com.tencent.mobileqq.onlinestatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime.Status;

class AccountPanel$3
  implements DialogInterface.OnClickListener
{
  AccountPanel$3(AccountPanel paramAccountPanel, AppRuntime.Status paramStatus, long paramLong, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel)))
    {
      AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel).i().setValue(Boolean.valueOf(true));
      QQToast.a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel), 1, 2131719223, 1).a();
      return;
    }
    AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel).a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, true);
    if (AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel) != null) {
      AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel).a(this.jdField_a_of_type_JavaLangString);
    }
    ReportController.b(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel), "dc00898", "", "", "0X8009DE1", "0X8009DE1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.3
 * JD-Core Version:    0.7.0.1
 */