package com.tencent.mobileqq.onlinestatus;

import axsv;
import bcqk;
import com.tencent.mobileqq.app.QQAppInterface;

public class AccountPanel$3
  implements Runnable
{
  public AccountPanel$3(axsv paramaxsv) {}
  
  public void run()
  {
    if ((axsv.a(this.this$0) != null) && (axsv.a(this.this$0) != null))
    {
      axsv.a(this.this$0, true);
      axsv.b(this.this$0, false);
      axsv.a(this.this$0, axsv.a(this.this$0));
      axsv.a(this.this$0).startAllSubMessageAccountMsg(false);
      bcqk.a(axsv.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.3
 * JD-Core Version:    0.7.0.1
 */