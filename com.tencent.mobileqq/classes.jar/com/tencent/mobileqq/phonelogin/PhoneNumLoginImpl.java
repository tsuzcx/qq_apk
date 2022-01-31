package com.tencent.mobileqq.phonelogin;

import agox;
import agoy;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class PhoneNumLoginImpl
{
  private static PhoneNumLoginImpl jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean;
  
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
  
  public int a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return -1;
    }
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.VerifySMSVerifyLoginCode(paramString1, paramString2, paramString3, paramWtloginObserver);
  }
  
  public int a(AppInterface paramAppInterface, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.RefreshSMSVerifyLoginCode(paramString1, paramString2, paramWtloginObserver);
  }
  
  public int a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WtloginObserver paramWtloginObserver)
  {
    if (paramQQAppInterface == null) {
      return -1;
    }
    paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    if (paramQQAppInterface == null) {
      return -1;
    }
    return paramQQAppInterface.RegGetSMSVerifyLoginAccount(paramArrayOfByte1, paramArrayOfByte2, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString1))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.CheckSMSVerifyLoginAccount(paramString1, paramString2, AppSetting.a, paramWtloginObserver);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    Object localObject;
    long l;
    do
    {
      do
      {
        return;
        localObject = paramQQAppInterface.getApplication();
      } while (localObject == null);
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      l = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramQQAppInterface, Long.valueOf(l));
      localObject = ((MobileQQ)localObject).getSharedPreferences("pwd_sharedpref", 0);
    } while (localObject == null);
    paramQQAppInterface = "pwd_ts_key" + paramQQAppInterface;
    ((SharedPreferences)localObject).edit().putLong(paramQQAppInterface, l).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.setHasPwd(paramString, paramBoolean);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i = 1;
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    } while (paramQQAppInterface == null);
    if (paramBoolean) {}
    for (;;)
    {
      paramQQAppInterface.setRegDevLockFlag(i);
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
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    if (localMobileQQ == null) {
      return false;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (a(paramQQAppInterface, str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sp", 2, "getHasPwd return true uin=" + str);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("sp", 2, "getHasPwd return false uin=" + str);
    }
    Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    if (localLong != null)
    {
      paramQQAppInterface = localLong;
      if (localLong.longValue() != 0L) {}
    }
    else
    {
      paramQQAppInterface = localMobileQQ.getSharedPreferences("pwd_sharedpref", 0);
      if (paramQQAppInterface == null) {
        return false;
      }
      paramQQAppInterface = Long.valueOf(paramQQAppInterface.getLong("pwd_ts_key" + str, 0L));
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramQQAppInterface);
    }
    return System.currentTimeMillis() - paramQQAppInterface.longValue() > 86400000L;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (a(paramQQAppInterface, str)) {
      return true;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    localQQCustomDialog.setTitle(2131434340);
    localQQCustomDialog.setMessage(2131434341);
    paramQQAppInterface = new agox(this, str, paramActivity, paramQQAppInterface);
    paramActivity = new agoy(this);
    localQQCustomDialog.setPositiveButton(2131434342, paramQQAppInterface);
    localQQCustomDialog.setNegativeButton(2131433029, paramActivity);
    localQQCustomDialog.show();
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1;
    if (paramQQAppInterface == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
      if (paramQQAppInterface == null) {
        return true;
      }
      bool2 = paramQQAppInterface.getHasPwd(paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("sp", 2, "getHasPwd return uin=" + paramString + " ret = " + bool2);
    return bool2;
  }
  
  public int b(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString3))) {
      return -1;
    }
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.GetSubaccountStViaSMSVerifyLogin(paramString1, paramString2, paramString3, AppSetting.a, paramWtloginObserver);
  }
  
  public int b(AppInterface paramAppInterface, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.GetStViaSMSVerifyLogin(paramString1, paramString2, AppSetting.a, paramWtloginObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl
 * JD-Core Version:    0.7.0.1
 */