package com.tencent.mobileqq.register;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterManager
{
  private static volatile RegisterManager jdField_a_of_type_ComTencentMobileqqRegisterRegisterManager;
  private int jdField_a_of_type_Int;
  private QueryAccount.RegisterFaceResult jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount$RegisterFaceResult;
  
  private RegisterManager()
  {
    a();
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount$RegisterFaceResult != null)
    {
      QLog.d("RegisterManager", 1, "onSendRegisterBySetPass: sendRegisterBySetPass has face result.");
      localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      paramBundle = (HashMap)localBundle.getParcelable("mapSt");
      if (paramBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount$RegisterFaceResult.a());
      } else {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount$RegisterFaceResult.a();
      }
      localBundle.putSerializable("mapSt", paramBundle);
    }
    return localBundle;
  }
  
  public static RegisterManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRegisterRegisterManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqRegisterRegisterManager == null) {
          jdField_a_of_type_ComTencentMobileqqRegisterRegisterManager = new RegisterManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqRegisterRegisterManager;
  }
  
  public QueryAccount.RegisterFaceResult a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount$RegisterFaceResult;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount$RegisterFaceResult = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1) {
      a();
    }
  }
  
  public void a(QueryAccount.RegisterFaceResult paramRegisterFaceResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount$RegisterFaceResult = paramRegisterFaceResult;
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, Bundle paramBundle, AccountObserver paramAccountObserver)
  {
    QLog.d("RegisterManager", 1, "sendRegisterBySetPass");
    ((AccountManager)paramAppRuntime.getManager(0)).sendRegisterBySetPass(paramString1, paramString2, paramString3, paramString4, paramBoolean, "8.7.0", a(paramBundle), paramAccountObserver);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount$RegisterFaceResult = null;
    this.jdField_a_of_type_Int = 7;
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, Bundle paramBundle, AccountObserver paramAccountObserver)
  {
    QLog.d("RegisterManager", 1, "sendRegisterBySetPassWithLH");
    ((AccountManager)paramAppRuntime.getManager(0)).sendRegisterBySetPassWithLH(paramString1, paramString2, paramString3, paramString4, paramBoolean, "8.7.0", a(paramBundle), paramAccountObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterManager
 * JD-Core Version:    0.7.0.1
 */