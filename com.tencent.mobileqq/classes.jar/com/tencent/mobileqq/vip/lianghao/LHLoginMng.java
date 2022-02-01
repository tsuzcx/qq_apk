package com.tencent.mobileqq.vip.lianghao;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.register.RegisterManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;

public class LHLoginMng
{
  private AppRuntime a;
  
  public LHLoginMng(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public void a(Intent paramIntent, String paramString, LHLoginMng.OnLockLHUinResult paramOnLockLHUinResult)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isDevelopLevel()) {
        RegisterLHAssistant.a("LHLoginMng -- lockLH", paramIntent);
      }
      String str1 = paramIntent.getStringExtra("key_register_smscode");
      if (str1 == null) {
        str1 = "";
      }
      String str2 = paramIntent.getStringExtra("key_register_nick");
      if (str2 == null) {
        str2 = "";
      }
      String str4 = paramIntent.getStringExtra("key_register_password");
      String str3 = str4;
      if (str4 == null) {
        str3 = "";
      }
      boolean bool = paramIntent.getBooleanExtra("key_register_chose_bind_phone", false);
      if (bool)
      {
        paramIntent = new LHLoginMng.LHLoginCallbackForW(paramIntent, paramString, paramOnLockLHUinResult);
        ((WtloginManager)this.a.getManager(1)).regGetSMSVerifyLoginAccountWithLH(str1.getBytes(), str2.getBytes(), paramString, "8.8.17", paramIntent);
      }
      else
      {
        paramIntent = new LHLoginMng.LHLoginCallbackForA(paramIntent, paramString, paramOnLockLHUinResult);
        PhoneNumLoginImpl.a().a(this.a, false);
        RegisterManager.b().b(this.a, str3, str2, str1, paramString, false, null, paramIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "lockLH, lhUin: %s, isBindPhoneNum: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
      }
      return;
    }
    if (paramOnLockLHUinResult != null) {
      paramOnLockLHUinResult.a(paramIntent, false, paramString, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.LHLoginMng
 * JD-Core Version:    0.7.0.1
 */