package com.tencent.mobileqq.onlinestatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AccountPanel$8
  implements DialogInterface.OnClickListener
{
  AccountPanel$8(AccountPanel paramAccountPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed -> LoginActivity");
    }
    ReportController.a(null, "dc00898", "", "", "0X800B430", "0X800B430", 0, 0, "", "", "", "");
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("uin", AccountPanel.a(this.a));
    paramDialogInterface.putExtra("befault_uin", AccountPanel.a(this.a).getCurrentAccountUin());
    RouteUtils.a(AccountPanel.a(this.a), paramDialogInterface, "/base/login");
    AccountPanel.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.8
 * JD-Core Version:    0.7.0.1
 */