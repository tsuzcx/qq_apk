package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;

public class EquipLockImpl
  implements IEquipLockApi
{
  public int a(String paramString)
  {
    return EquipmentLockImpl.a().a(paramString);
  }
  
  public int a(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramContext, paramString, paramBoolean);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("EquipLockImpl", 1, "checkDevLockStatus");
      return -1;
    }
    return EquipmentLockImpl.a().a((AppInterface)paramAppRuntime, paramString, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramVerifyDevLockObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramVerifyDevLockObserver, paramArrayOfByte);
  }
  
  public int a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramArrayOfByte, paramVerifyDevLockObserver);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    EquipLockWebEntrance.a(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, int paramInt)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("EquipLockImpl", 1, "enter, app not appinterface");
      return;
    }
    EquipLockWebEntrance.a(paramActivity, (AppInterface)paramAppRuntime, paramInt);
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("EquipLockImpl", 1, "enterForResult, app not appinterface");
      return;
    }
    EquipLockWebEntrance.a(paramActivity, (AppInterface)paramAppRuntime, paramInt1, paramInt2, paramString);
  }
  
  public void a(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    VasWebviewUtil.openQQBrowserActivity(paramContext, paramString, paramLong, paramIntent, paramBoolean, paramInt);
  }
  
  public void a(String paramString, ApngDrawable paramApngDrawable)
  {
    VasFaceManager.a(paramString, paramApngDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.EquipLockImpl
 * JD-Core Version:    0.7.0.1
 */