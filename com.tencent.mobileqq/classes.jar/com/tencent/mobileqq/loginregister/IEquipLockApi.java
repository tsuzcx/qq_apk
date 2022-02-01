package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.image.ApngDrawable;
import mqq.app.AppRuntime;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;

public abstract interface IEquipLockApi
{
  public abstract int a(String paramString);
  
  public abstract int a(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract int a(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver);
  
  public abstract int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte);
  
  public abstract int a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver);
  
  public abstract void a(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void a(Activity paramActivity, AppRuntime paramAppRuntime, int paramInt);
  
  public abstract void a(Activity paramActivity, AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt);
  
  public abstract void a(String paramString, ApngDrawable paramApngDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.IEquipLockApi
 * JD-Core Version:    0.7.0.1
 */