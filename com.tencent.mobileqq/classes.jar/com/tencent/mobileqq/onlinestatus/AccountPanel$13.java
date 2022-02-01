package com.tencent.mobileqq.onlinestatus;

import com.tencent.qphone.base.util.QLog;

class AccountPanel$13
  extends OnBatteryChangeObserver
{
  AccountPanel$13(AccountPanel paramAccountPanel) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onBatteryChanged updateOnlineStatusItem");
    }
    AccountPanel.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.13
 * JD-Core Version:    0.7.0.1
 */