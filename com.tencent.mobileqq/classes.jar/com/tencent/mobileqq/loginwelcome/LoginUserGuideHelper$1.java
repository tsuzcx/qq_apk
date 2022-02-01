package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

final class LoginUserGuideHelper$1
  implements Runnable
{
  LoginUserGuideHelper$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ThreadManager.excute(new LoginUserGuideHelper.1.1(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.1
 * JD-Core Version:    0.7.0.1
 */