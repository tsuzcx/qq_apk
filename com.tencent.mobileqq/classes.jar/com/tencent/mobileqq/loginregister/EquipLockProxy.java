package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;

public class EquipLockProxy
  implements IEquipLockApi
{
  @ConfigInject(configPath="Business/qqlogin-api/src/main/resources/Inject_login_register_config.yml", version=1)
  public static ArrayList<Class<? extends IEquipLockApi>> a = new ArrayList();
  private IEquipLockApi b;
  
  static
  {
    a.add(EquipLockImpl.class);
  }
  
  public EquipLockProxy()
  {
    QLog.d("EquipLockProxy", 1, new Object[] { "sLockVasClazzList size : ", Integer.valueOf(a.size()) });
    Class localClass = (Class)a.get(0);
    try
    {
      this.b = ((IEquipLockApi)localClass.newInstance());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("EquipLockProxy", 1, "IEquipLockApi newInstance", localException);
    }
  }
  
  public int a(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public int a(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean)
  {
    return this.b.a(paramAppRuntime, paramContext, paramString, paramBoolean);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    return this.b.a(paramAppRuntime, paramString, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte)
  {
    return this.b.a(paramAppRuntime, paramVerifyDevLockObserver, paramArrayOfByte);
  }
  
  public int a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    return this.b.a(paramAppRuntime, paramArrayOfByte, paramVerifyDevLockObserver);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    this.b.a(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, int paramInt)
  {
    this.b.a(paramActivity, paramAppRuntime, paramInt);
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString)
  {
    this.b.a(paramActivity, paramAppRuntime, paramInt1, paramInt2, paramString);
  }
  
  public void a(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    this.b.a(paramContext, paramString, paramLong, paramIntent, paramBoolean, paramInt);
  }
  
  public void a(String paramString, ApngDrawable paramApngDrawable)
  {
    this.b.a(paramString, paramApngDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.EquipLockProxy
 * JD-Core Version:    0.7.0.1
 */