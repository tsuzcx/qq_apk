package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;

class AccountPanel$1
  implements Runnable
{
  AccountPanel$1(AccountPanel paramAccountPanel) {}
  
  public void run()
  {
    if ((AccountPanel.a(this.this$0) != null) && (AccountPanel.a(this.this$0) != null))
    {
      AccountPanel.a(this.this$0, true);
      AccountPanel.b(this.this$0, false);
      AccountPanel.a(this.this$0, AccountPanel.a(this.this$0));
      AccountPanel.a(this.this$0).startAllSubMessageAccountMsg(false);
      SubAccountControll.a(AccountPanel.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.1
 * JD-Core Version:    0.7.0.1
 */