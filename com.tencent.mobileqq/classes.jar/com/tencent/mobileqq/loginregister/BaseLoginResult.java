package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import mqq.app.AppRuntime;

public abstract class BaseLoginResult
  implements ILoginResult
{
  public void a(Activity paramActivity, String paramString) {}
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime) {}
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString) {}
  
  public boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.BaseLoginResult
 * JD-Core Version:    0.7.0.1
 */