package com.tencent.mobileqq.onlinestatus;

import com.tencent.qphone.base.util.QLog;

class AccountOnlineStateActivity$8
  extends OnBatteryChangeObserver
{
  AccountOnlineStateActivity$8(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onBatteryChanged updateOnlineStatusItem");
    }
    AccountOnlineStateActivity.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.8
 * JD-Core Version:    0.7.0.1
 */