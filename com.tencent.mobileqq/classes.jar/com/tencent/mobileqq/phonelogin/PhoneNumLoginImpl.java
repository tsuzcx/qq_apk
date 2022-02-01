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
    if (jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl == null) {
          jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl = new PhoneNumLoginImpl();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqPhoneloginPhoneNumLoginImpl;
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return -1;
      }
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return -1;
      }
      return paramAppRuntime.verifySMSVerifyLoginCode(paramString1, paramString2, paramString3, paramWtloginObserver);
    }
    return -1;
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return -1;
      }
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return -1;
      }
      return paramAppRuntime.refreshSMSVerifyLoginCode(paramString1, paramString2, paramWtloginObserver);
    }
    return -1;
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return -1;
      }
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return -1;
      }
      return paramAppRuntime.checkSMSVerifyLoginAccount(paramString1, paramString2, AppSetting.a(), paramArrayOfByte, paramWtloginObserver);
    }
    return -1;
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
    return paramAppRuntime.regGetSMSVerifyLoginAccount(paramArrayOfByte1, paramArrayOfByte2, paramString, "8.7.0", paramWtloginObserver);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime.setHasPwd(paramString, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    if (paramAppRuntime == null) {
      return true;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return true;
    }
    boolean bool = paramAppRuntime.getHasPwd(paramString);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("getHasPwd return uin=");
      paramAppRuntime.append(paramString);
      paramAppRuntime.append(" ret = ");
      paramAppRuntime.append(bool);
      QLog.d("sp", 2, paramAppRuntime.toString());
    }
    return bool;
  }
  
  public int b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString3)) {
        return -1;
      }
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return -1;
      }
      return paramAppRuntime.getSubAccountStViaSMSVerifyLogin(paramString1, paramString2, paramString3, AppSetting.a(), paramWtloginObserver);
    }
    return -1;
  }
  
  public int b(AppRuntime paramAppRuntime, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return -1;
      }
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return -1;
      }
      return paramAppRuntime.getStViaSMSVerifyLogin(paramString1, paramString2, AppSetting.a(), paramWtloginObserver);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl
 * JD-Core Version:    0.7.0.1
 */