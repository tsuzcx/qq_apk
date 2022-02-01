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
  private Intent jdField_a_of_type_AndroidContentIntent;
  public AutoLoginHelper a;
  public String a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new RegisterWithNickAndPwd.1(this);
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private String c;
  public boolean c;
  private String d;
  public boolean d;
  private String e;
  public boolean e;
  private String f = null;
  
  public RegisterWithNickAndPwd(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_from_quick_register", false);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_from_send_sms", false);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getStringExtra("key_register_smscode");
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_is_lh", false);
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "autoLogin, forceLogin=" + paramBoolean);
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity == null) || (paramIntent == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterWithNickAndPwd", 2, "autoLogin, data is null");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper.d();
        this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper = new AutoLoginHelper(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper.e();
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterByNicknameAndPwdActivity));
    ((RegisterByNicknameAndPwdActivity)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity).changeViewToLogin();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper.d();
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper = null;
    }
  }
  
  public void a(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("key_register_nick");
    String str2 = paramIntent.getStringExtra("key_register_password");
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_register_smscode");
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("key_register_autologin", false);
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    this.f = paramIntent.getStringExtra("key_register_fail_paid_lh");
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("key_register_phonenum_bindnewqq", true);
    a(str1, str2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RegisterWithNickAndPwd", 4, String.format(Locale.getDefault(), "doAction smsCode: %s, unBindLH:%s, nick: %s, pas: %s, isLH:%b, autoLogin: %b, isPhoneNumBindNewQQ:%b", new Object[] { this.jdField_a_of_type_JavaLangString, this.f, paramString1, MD5.a(paramString2), Boolean.valueOf(this.jdField_d_of_type_Boolean), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_e_of_type_Boolean) }));
    }
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
    AccountManager localAccountManager = (AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0);
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        localAccountManager.getQuickRegisterAccount(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, AppSetting.a(), "8.5.5", this.jdField_a_of_type_MqqObserverAccountObserver);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.createWaitingDialog(2131716905);
        return;
        PhoneNumLoginImpl.a().a(this.jdField_a_of_type_MqqAppAppRuntime, true);
        RegisterManager.a().a(this.jdField_a_of_type_MqqAppAppRuntime, paramString2, paramString1, this.jdField_a_of_type_JavaLangString, this.f, this.jdField_e_of_type_Boolean, null, this.jdField_a_of_type_MqqObserverAccountObserver);
      }
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
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_e_of_type_Boolean = paramBoolean2;
    a(paramString1, paramString2);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper.f();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper.g();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoLoginHelper.c();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "go2next, onRegisterCommitPassResp, mAutoLogin = " + this.jdField_c_of_type_Boolean + ", mIsfromLH=" + this.jdField_d_of_type_Boolean);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterQQNumberActivity.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
    localIntent.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode);
    localIntent.putExtra("key", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
    localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_register_sign", this.jdField_a_of_type_ArrayOfByte);
    localIntent.putExtra("key_register_password", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("resp_register_supersig", this.jdField_b_of_type_ArrayOfByte);
    localIntent.putExtra("key_register_unbind", true);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered);
    localIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd);
    localIntent.putExtra("key_register_from_send_sms", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_register_chose_bind_phone", false);
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      a(localIntent, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "reAutoLogin");
    }
    a(this.jdField_a_of_type_AndroidContentIntent, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterWithNickAndPwd
 * JD-Core Version:    0.7.0.1
 */