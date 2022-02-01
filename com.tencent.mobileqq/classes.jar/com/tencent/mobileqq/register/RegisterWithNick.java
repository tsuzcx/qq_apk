package com.tencent.mobileqq.register;

import android.content.Intent;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.WtloginObserver;

public class RegisterWithNick
  extends RegisterStepBase
{
  protected static final String a = "RegisterWithNick";
  protected WtloginObserver b = new RegisterWithNick.1(this);
  private String c = null;
  private byte[] d = null;
  private String e = "";
  private String f = null;
  private boolean i = false;
  
  public RegisterWithNick(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    if (this.e == null) {
      this.e = "";
    }
  }
  
  public void a() {}
  
  public void a(Intent paramIntent)
  {
    this.e = paramIntent.getStringExtra("key_register_smscode");
    if (this.e == null) {
      this.e = "";
    }
    this.f = paramIntent.getStringExtra("key_register_from_fail_pay_lh");
    a(paramIntent.getStringExtra("key_register_nick"));
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(a, 4, String.format(Locale.getDefault(), "doAction nick: %s, unBindUin: %s, smsCode: %s", new Object[] { paramString, this.f, this.e }));
      }
      this.h.createWaitingDialog(2131914021);
      if (PhoneNumLoginImpl.a().a(this.g, this.e.getBytes(), paramString.getBytes(), this.f, this.b) != 0)
      {
        this.h.closeDialog();
        this.h.notifyToast(2131914072, 1);
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterWithNick
 * JD-Core Version:    0.7.0.1
 */