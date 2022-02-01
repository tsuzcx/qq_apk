package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.music.OnlineMusicStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

class AccountPanel$16$1
  implements Runnable
{
  AccountPanel$16$1(AccountPanel.16 param16, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = OnLineStatusHelper.a().a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a));
      if ((AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a) != 1000L) || (l != 1000L)) {
        break label241;
      }
    }
    label241:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a)))
      {
        String str = OnLineStatusHelper.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a).getResources().getString(2131698443, new Object[] { str });
        QQToast.a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a);
      OnlineMusicStatusManager.a().a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a), l);
      if (!AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a, l)) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a.c();
      }
      AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a, l);
      return;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a.c();
      QQToast.a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$16.a), 1, 2131698430, 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.16.1
 * JD-Core Version:    0.7.0.1
 */