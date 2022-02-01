package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public abstract interface IContactInterface
{
  public abstract BusinessObserver a(IRegisterView paramIRegisterView);
  
  public abstract void a(QBaseActivity paramQBaseActivity, Intent paramIntent);
  
  public abstract void a(AppRuntime paramAppRuntime);
  
  public abstract void a(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.IContactInterface
 * JD-Core Version:    0.7.0.1
 */