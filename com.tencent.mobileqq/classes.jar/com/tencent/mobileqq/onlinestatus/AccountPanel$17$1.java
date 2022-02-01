package com.tencent.mobileqq.onlinestatus;

import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.music.OnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusHintFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

class AccountPanel$17$1
  implements Runnable
{
  AccountPanel$17$1(AccountPanel.17 param17, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      l = OnLineStatusHelper.a().a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a));
      if ((AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a) != 1000L) || (l != 1000L)) {
        break label318;
      }
    }
    label318:
    for (int i = 0;; i = 1)
    {
      int j = i;
      if (AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a) == 1040L)
      {
        j = i;
        if (l == 1040L) {
          j = 0;
        }
      }
      if (l == 40001L) {
        j = 0;
      }
      if (!AccountPanel.b(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a))
      {
        AccountPanel.c(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a, true);
        if (l == 40001L) {
          AutoStatusHintFragment.a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a));
        }
      }
      if ((j != 0) && (AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a)))
      {
        String str = OnLineStatusHelper.a().a(l, this.jdField_a_of_type_MqqAppAppRuntime$Status);
        str = AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a).getResources().getString(2131698443, new Object[] { str });
        QQToast.a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a), 2, str, 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel onSetOnlineStatus");
        }
      }
      OnlineMusicStatusManager.a().a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a), l);
      if (!AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a, l)) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a.c();
      }
      AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a, l);
      return;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a.c();
      QQToast.a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$17.a), 1, 2131698430, 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.17.1
 * JD-Core Version:    0.7.0.1
 */