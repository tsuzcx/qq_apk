package com.tencent.mobileqq.register;

import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AutoLoginHelper;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterWithNickAndPwd
  extends RegisterStepBase
{
  public boolean a = false;
  public String b = "";
  public boolean c;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public AutoLoginHelper i;
  protected AccountObserver j = new RegisterWithNickAndPwd.1(this);
  private String k = null;
  private String l = null;
  private byte[] m = null;
  private String n = null;
  private String o = null;
  private String p = null;
  private byte[] q;
  private Intent r;
  
  public RegisterWithNickAndPwd(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    paramRegisterNewBaseActivity = this.h.getIntent();
    this.a = paramRegisterNewBaseActivity.getBooleanExtra("key_register_from_quick_register", false);
    this.c = paramRegisterNewBaseActivity.getBooleanExtra("key_register_from_send_sms", false);
    this.b = paramRegisterNewBaseActivity.getStringExtra("key_register_smscode");
    this.p = paramRegisterNewBaseActivity.getStringExtra("key_register_fail_paid_lh");
    this.e = paramRegisterNewBaseActivity.getBooleanExtra("key_register_is_lh", false);
    if (this.b == null) {
      this.b = "";
    }
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("autoLogin, forceLogin=");
      localStringBuilder.append(paramBoolean);
      QLog.d("RegisterWithNickAndPwd", 2, localStringBuilder.toString());
    }
    if ((this.g != null) && (this.h != null) && (paramIntent != null))
    {
      if (this.r == null) {
        this.r = paramIntent;
      }
      paramIntent = this.i;
      if (paramIntent != null)
      {
        paramIntent.f();
        this.i = null;
      }
      this.i = new AutoLoginHelper(this.g, this.h, this.r);
      this.i.b();
      this.i.g();
      if ((this.h instanceof RegisterByNicknameAndPwdActivity)) {
        ((RegisterByNicknameAndPwdActivity)this.h).changeViewToLogin();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "autoLogin, data is null");
    }
  }
  
  public void a()
  {
    AutoLoginHelper localAutoLoginHelper = this.i;
    if (localAutoLoginHelper != null)
    {
      localAutoLoginHelper.f();
      this.i = null;
    }
  }
  
  public void a(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("key_register_nick");
    String str2 = paramIntent.getStringExtra("key_register_password");
    this.b = paramIntent.getStringExtra("key_register_smscode");
    this.d = paramIntent.getBooleanExtra("key_register_autologin", false);
    if (this.b == null) {
      this.b = "";
    }
    this.p = paramIntent.getStringExtra("key_register_fail_paid_lh");
    this.f = paramIntent.getBooleanExtra("key_register_phonenum_bindnewqq", true);
    a(str1, str2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RegisterWithNickAndPwd", 4, String.format(Locale.getDefault(), "doAction smsCode: %s, unBindLH:%s, nick: %s, pas: %s, isLH:%b, autoLogin: %b, isPhoneNumBindNewQQ:%b", new Object[] { this.b, this.p, paramString1, MD5.b(paramString2), Boolean.valueOf(this.e), Boolean.valueOf(this.d), Boolean.valueOf(this.f) }));
    }
    this.n = paramString1;
    this.o = paramString2;
    AccountManager localAccountManager = (AccountManager)this.g.getManager(0);
    try
    {
      if (this.a)
      {
        localAccountManager.getQuickRegisterAccount(this.g.getCurrentAccountUin(), this.n, this.o, AppSetting.d(), "8.8.17", this.j);
      }
      else
      {
        PhoneNumLoginImpl.a().a(this.g, true);
        RegisterManager.b().a(this.g, paramString2, paramString1, this.b, this.p, this.f, null, this.j);
      }
      this.h.createWaitingDialog(2131914021);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RegisterWithNickAndPwd", 4, String.format(Locale.getDefault(), "doAction autoLogin: %b, isPhoneNumBindNewQQ:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    this.d = paramBoolean1;
    this.f = paramBoolean2;
    a(paramString1, paramString2);
  }
  
  public void b()
  {
    AutoLoginHelper localAutoLoginHelper = this.i;
    if (localAutoLoginHelper != null) {
      localAutoLoginHelper.k();
    }
  }
  
  public void c()
  {
    AutoLoginHelper localAutoLoginHelper = this.i;
    if (localAutoLoginHelper != null) {
      localAutoLoginHelper.l();
    }
  }
  
  public void d()
  {
    AutoLoginHelper localAutoLoginHelper = this.i;
    if (localAutoLoginHelper != null) {
      localAutoLoginHelper.e();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("go2next, onRegisterCommitPassResp, mAutoLogin = ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", mIsfromLH=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("RegisterWithNickAndPwd", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(this.h, RegisterQQNumberActivity.class);
    ((Intent)localObject).putExtra("phonenum", this.h.phoneNum);
    ((Intent)localObject).putExtra("from_type", this.h.mFrom);
    ((Intent)localObject).putExtra("invite_code", this.h.inviteCode);
    ((Intent)localObject).putExtra("key", this.h.countryCode);
    ((Intent)localObject).putExtra("uin", this.k);
    ((Intent)localObject).putExtra("key_register_sign", this.m);
    ((Intent)localObject).putExtra("key_register_password", this.o);
    ((Intent)localObject).putExtra("resp_register_supersig", this.q);
    ((Intent)localObject).putExtra("key_register_unbind", true);
    ((Intent)localObject).putExtra("key_register_is_phone_num_registered", this.h.mIsPhoneNumRegistered);
    ((Intent)localObject).putExtra("key_register_has_pwd", this.h.mHasPwd);
    ((Intent)localObject).putExtra("key_register_from_send_sms", this.c);
    ((Intent)localObject).putExtra("key_register_chose_bind_phone", false);
    if ((this.d) && (!this.e))
    {
      a((Intent)localObject, false);
      return;
    }
    this.h.startActivity((Intent)localObject);
    this.h.finish();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "reAutoLogin");
    }
    a(this.r, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterWithNickAndPwd
 * JD-Core Version:    0.7.0.1
 */