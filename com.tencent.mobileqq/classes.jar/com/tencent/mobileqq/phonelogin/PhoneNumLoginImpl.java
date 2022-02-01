package com.tencent.mobileqq.phonelogin;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class PhoneNumLoginImpl
{
  private static PhoneNumLoginImpl jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl = null;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private boolean jdField_a_of_type_Boolean = false;
  
  public static PhoneNumLoginImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl == null) {
        jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl = new PhoneNumLoginImpl();
      }
      return jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl;
    }
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.verifySMSVerifyLoginCode(paramString1, paramString2, paramString3, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.refreshSMSVerifyLoginCode(paramString1, paramString2, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString1))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.checkSMSVerifyLoginAccount(paramString1, paramString2, AppSetting.a(), paramArrayOfByte, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, WtloginObserver paramWtloginObserver)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.regGetSMSVerifyLoginAccount(paramArrayOfByte1, paramArrayOfByte2, paramString, "8.5.5", paramWtloginObserver);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    } while (paramAppRuntime == null);
    paramAppRuntime.setHasPwd(paramString, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    int i = 1;
    if (paramAppRuntime == null) {}
    do
    {
      return;
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    } while (paramAppRuntime == null);
    if (paramBoolean) {}
    for (;;)
    {
      paramAppRuntime.setRegDevLockFlag(i);
      return;
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    boolean bool1;
    if (paramAppRuntime == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return true;
      }
      bool2 = paramAppRuntime.getHasPwd(paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("sp", 2, "getHasPwd return uin=" + paramString + " ret = " + bool2);
    return bool2;
  }
  
  public int b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString3))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.getSubAccountStViaSMSVerifyLogin(paramString1, paramString2, paramString3, AppSetting.a(), paramWtloginObserver);
  }
  
  public int b(AppRuntime paramAppRuntime, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.getStViaSMSVerifyLogin(paramString1, paramString2, AppSetting.a(), paramWtloginObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl
 * JD-Core Version:    0.7.0.1
 */