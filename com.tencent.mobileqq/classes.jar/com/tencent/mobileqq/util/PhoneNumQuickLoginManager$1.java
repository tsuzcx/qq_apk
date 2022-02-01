package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.mobileqq.app.identity.LocalPhoneModule.PhoneNumCallback;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;
import tencent.im.login.GetLocalPhone.EncryptPhoneData;

final class PhoneNumQuickLoginManager$1
  implements LocalPhoneModule.PhoneNumCallback
{
  PhoneNumQuickLoginManager$1(Context paramContext, AppRuntime paramAppRuntime, Map paramMap, WtloginObserver paramWtloginObserver) {}
  
  public void a(int paramInt, Exception paramException)
  {
    this.d.onException(paramException.getMessage(), paramInt);
  }
  
  public void a(GetLocalPhone.EncryptPhoneData paramEncryptPhoneData)
  {
    if (paramEncryptPhoneData == null)
    {
      QLog.e("PhoneNumQuickLoginManager", 1, "getPhoneNumSuccess, phoneData is null");
      a(-2001, new Exception("phoneData is null"));
      return;
    }
    PhoneNumQuickLoginManager.a(this.a, this.b, paramEncryptPhoneData.str_encypt_phone.get(), this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.1
 * JD-Core Version:    0.7.0.1
 */