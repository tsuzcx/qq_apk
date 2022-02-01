package com.tencent.mobileqq.loginwelcome;

import awdj;
import com.tencent.mobileqq.activity.Conversation;

public class LoginwelcomeHelper$2
  implements Runnable
{
  public LoginwelcomeHelper$2(awdj paramawdj) {}
  
  public void run()
  {
    if (this.this$0.a.a != null)
    {
      LoginWelcomeManager localLoginWelcomeManager = LoginWelcomeManager.a(this.this$0.a.a);
      localLoginWelcomeManager.e();
      if (localLoginWelcomeManager.b) {
        localLoginWelcomeManager.h();
      }
      if (localLoginWelcomeManager.c) {
        localLoginWelcomeManager.i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.2
 * JD-Core Version:    0.7.0.1
 */