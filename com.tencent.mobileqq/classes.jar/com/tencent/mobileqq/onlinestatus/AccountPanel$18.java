package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

class AccountPanel$18
  extends OnlineStatusPermissionObserver
{
  AccountPanel$18(AccountPanel paramAccountPanel) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if ((!AccountPanel.a(this.a)) || (paramBundle == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, new Object[] { "receiveModOnlineStatusPermission: no needShowOnlineStatusToast needShowOnlineStatusToast=", Boolean.valueOf(AccountPanel.a(this.a)) });
      }
    }
    boolean bool;
    do
    {
      return;
      bool = paramBundle.getBoolean("param_need_switch_online_status", false);
      if ((!paramBoolean) || (paramBundle == null)) {
        break;
      }
      i = paramBundle.getInt("StatusId", 0);
      AccountPanel.a(this.a, AppRuntime.Status.online, i, false);
    } while (bool);
    QQToast.a(AccountPanel.a(this.a).getApp(), 2, 2131691412, 1).a();
    this.a.c();
    return;
    if (bool) {}
    for (int i = 2131698430;; i = 2131691413)
    {
      QQToast.a(AccountPanel.a(this.a), 1, i, 1).a();
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.18
 * JD-Core Version:    0.7.0.1
 */