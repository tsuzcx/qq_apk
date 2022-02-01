package com.tencent.mobileqq.onlinestatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.utils.UiRouteUtils;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AccountPanel$5
  implements DialogInterface.OnClickListener
{
  AccountPanel$5(AccountPanel paramAccountPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed -> LoginActivity");
    }
    ReportController.a(null, "dc00898", "", "", "0X800B430", "0X800B430", 0, 0, "", "", "", "");
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("uin", AccountPanel.d(this.a).m());
    paramDialogInterface.putExtra("befault_uin", AccountPanel.c(this.a).getCurrentAccountUin());
    UiRouteUtils.a(AccountPanel.a(this.a), paramDialogInterface, "/base/login");
    AccountPanel.d(this.a).a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.5
 * JD-Core Version:    0.7.0.1
 */