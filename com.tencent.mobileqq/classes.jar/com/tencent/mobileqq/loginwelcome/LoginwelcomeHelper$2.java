package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.activity.home.Conversation;

class LoginwelcomeHelper$2
  implements Runnable
{
  LoginwelcomeHelper$2(LoginwelcomeHelper paramLoginwelcomeHelper) {}
  
  public void run()
  {
    if (this.this$0.a.aF != null)
    {
      LoginWelcomeManager localLoginWelcomeManager = LoginWelcomeManager.a(this.this$0.a.s());
      localLoginWelcomeManager.h();
      if (localLoginWelcomeManager.i) {
        localLoginWelcomeManager.l();
      }
      if (localLoginWelcomeManager.k) {
        localLoginWelcomeManager.n();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.2
 * JD-Core Version:    0.7.0.1
 */