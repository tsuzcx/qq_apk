package com.tencent.mobileqq.onlinestatus;

import ayzg;
import bdxj;
import com.tencent.mobileqq.app.QQAppInterface;

public class AccountPanel$3
  implements Runnable
{
  public AccountPanel$3(ayzg paramayzg) {}
  
  public void run()
  {
    if ((ayzg.a(this.this$0) != null) && (ayzg.a(this.this$0) != null))
    {
      ayzg.a(this.this$0, true);
      ayzg.b(this.this$0, false);
      ayzg.a(this.this$0, ayzg.a(this.this$0));
      ayzg.a(this.this$0).startAllSubMessageAccountMsg(false);
      bdxj.a(ayzg.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.3
 * JD-Core Version:    0.7.0.1
 */