package com.tencent.mobileqq.onlinestatus;

import amov;
import com.tencent.mobileqq.app.QQAppInterface;

class AccountOnlineStateActivity$3
  implements Runnable
{
  AccountOnlineStateActivity$3(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void run()
  {
    amov localamov = (amov)AccountOnlineStateActivity.a(this.this$0).getBusinessHandler(2);
    if (localamov != null) {
      localamov.B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.3
 * JD-Core Version:    0.7.0.1
 */