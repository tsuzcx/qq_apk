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
  public static ArrayList<Class<? extends IEquipLockApi>> a;
  private IEquipLockApi a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(EquipLockImpl.class);
  }
  
  public EquipLockProxy()
  {
    QLog.d("EquipLockProxy", 1, new Object[] { "sLockVasClazzList size : ", Integer.valueOf(jdField_a_of_type_JavaUtilArrayList.size()) });
    Class localClass = (Class)jdField_a_of_type_JavaUtilArrayList.get(0);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi = ((IEquipLockApi)localClass.newInstance());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("EquipLockProxy", 1, "IEquipLockApi newInstance", localException);
    }
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramString);
  }
  
  public int a(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramAppRuntime, paramContext, paramString, paramBoolean);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramAppRuntime, paramString, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramAppRuntime, paramVerifyDevLockObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramAppRuntime, paramVerifyDevLockObserver, paramArrayOfByte);
  }
  
  public int a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramAppRuntime, paramArrayOfByte, paramVerifyDevLockObserver);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramActivity, paramAppRuntime, paramInt);
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramActivity, paramAppRuntime, paramInt1, paramInt2, paramString);
  }
  
  public void a(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramContext, paramString, paramLong, paramIntent, paramBoolean, paramInt);
  }
  
  public void a(String paramString, ApngDrawable paramApngDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIEquipLockApi.a(paramString, paramApngDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.EquipLockProxy
 * JD-Core Version:    0.7.0.1
 */