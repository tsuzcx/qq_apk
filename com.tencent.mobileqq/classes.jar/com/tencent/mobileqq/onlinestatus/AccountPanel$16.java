package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

class AccountPanel$16
  extends AccountObserver
{
  AccountPanel$16(AccountPanel paramAccountPanel) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if ((paramBoolean1) && (AccountPanel.a(this.a) != null)) {
      AccountPanel.a(this.a).a(paramStatus);
    }
    if (!paramBoolean2) {
      return;
    }
    ThreadManager.getUIHandler().post(new AccountPanel.16.1(this, paramBoolean1, paramStatus));
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!AccountPanel.a(this.a, paramLong)) {
      this.a.c();
    }
    AccountPanel.a(this.a, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.16
 * JD-Core Version:    0.7.0.1
 */