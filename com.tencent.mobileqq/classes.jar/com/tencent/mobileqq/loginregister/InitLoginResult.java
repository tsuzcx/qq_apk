package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class InitLoginResult
  extends BaseLoginResult
{
  public boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime; paramAppRuntime == null; paramAppRuntime = null)
    {
      QLog.e("InitLoginResult", 1, "onLoginSuccess error, appInterface is null");
      return false;
    }
    ThreadManager.postImmediately(new InitLoginResult.1(this, paramAppRuntime, paramString), null, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.InitLoginResult
 * JD-Core Version:    0.7.0.1
 */