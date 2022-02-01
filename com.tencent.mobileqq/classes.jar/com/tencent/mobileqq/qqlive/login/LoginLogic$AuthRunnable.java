package com.tencent.mobileqq.qqlive.login;

import com.tencent.mobileqq.qqlive.utils.ThreadCenter;

class LoginLogic$AuthRunnable
  implements Runnable
{
  LoginLogic$AuthRunnable(LoginLogic paramLoginLogic) {}
  
  public void run()
  {
    this.this$0.reLogin();
    ThreadCenter.a(this.this$0, this, 6000000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.login.LoginLogic.AuthRunnable
 * JD-Core Version:    0.7.0.1
 */