package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import mqq.app.AppRuntime;

public abstract interface ILoginAction
{
  public abstract void a();
  
  public abstract void a(Activity paramActivity, Bundle paramBundle);
  
  public abstract void a(Context paramContext);
  
  public abstract void a(QBaseActivity paramQBaseActivity, int paramInt);
  
  public abstract void a(QBaseActivity paramQBaseActivity, Bundle paramBundle);
  
  public abstract void a(QBaseActivity paramQBaseActivity, String paramString, boolean paramBoolean);
  
  public abstract void a(QBaseActivity paramQBaseActivity, AppRuntime paramAppRuntime, LoginErrorInfo paramLoginErrorInfo);
  
  public abstract void a(String paramString);
  
  public abstract boolean a(AppRuntime paramAppRuntime, Class<?> paramClass, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ILoginAction
 * JD-Core Version:    0.7.0.1
 */