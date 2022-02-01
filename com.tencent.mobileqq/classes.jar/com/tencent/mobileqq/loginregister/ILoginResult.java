package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import mqq.app.AppRuntime;

public abstract interface ILoginResult
{
  public abstract void a(Activity paramActivity, String paramString);
  
  public abstract void a(Activity paramActivity, AppRuntime paramAppRuntime);
  
  public abstract void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ILoginResult
 * JD-Core Version:    0.7.0.1
 */