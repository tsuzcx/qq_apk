package com.tencent.mobileqq.register;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterManager
{
  private static volatile RegisterManager a;
  private int b;
  private QueryAccount.RegisterFaceResult c;
  
  private RegisterManager()
  {
    a();
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (this.c != null)
    {
      QLog.d("RegisterManager", 1, "onSendRegisterBySetPass: sendRegisterBySetPass has face result.");
      localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      paramBundle = (HashMap)localBundle.getParcelable("mapSt");
      if (paramBundle != null) {
        paramBundle.putAll(this.c.a());
      } else {
        paramBundle = this.c.a();
      }
      localBundle.putSerializable("mapSt", paramBundle);
    }
    return localBundle;
  }
  
  public static RegisterManager b()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new RegisterManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a()
  {
    this.b = 1;
    this.c = null;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    if (this.b == 1) {
      a();
    }
  }
  
  public void a(QueryAccount.RegisterFaceResult paramRegisterFaceResult)
  {
    this.c = paramRegisterFaceResult;
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, Bundle paramBundle, AccountObserver paramAccountObserver)
  {
    QLog.d("RegisterManager", 1, "sendRegisterBySetPass");
    ((AccountManager)paramAppRuntime.getManager(0)).sendRegisterBySetPass(paramString1, paramString2, paramString3, paramString4, paramBoolean, "8.8.17", a(paramBundle), paramAccountObserver);
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, Bundle paramBundle, AccountObserver paramAccountObserver)
  {
    QLog.d("RegisterManager", 1, "sendRegisterBySetPassWithLH");
    ((AccountManager)paramAppRuntime.getManager(0)).sendRegisterBySetPassWithLH(paramString1, paramString2, paramString3, paramString4, paramBoolean, "8.8.17", a(paramBundle), paramAccountObserver);
  }
  
  public QueryAccount.RegisterFaceResult c()
  {
    return this.c;
  }
  
  public void d()
  {
    this.c = null;
    this.b = 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterManager
 * JD-Core Version:    0.7.0.1
 */