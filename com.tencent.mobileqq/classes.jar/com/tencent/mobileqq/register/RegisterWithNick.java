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
  protected static final String a;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new RegisterWithNick.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private String b = null;
  private String c = "";
  private String d = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = RegisterWithNick.class.getSimpleName();
  }
  
  public RegisterWithNick(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    if (this.c == null) {
      this.c = "";
    }
  }
  
  public void a() {}
  
  public void a(Intent paramIntent)
  {
    this.c = paramIntent.getStringExtra("key_register_smscode");
    if (this.c == null) {
      this.c = "";
    }
    this.d = paramIntent.getStringExtra("key_register_from_fail_pay_lh");
    a(paramIntent.getStringExtra("key_register_nick"));
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, String.format(Locale.getDefault(), "doAction nick: %s, unBindUin: %s, smsCode: %s", new Object[] { paramString, this.d, this.c }));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.createWaitingDialog(2131716905);
      if (PhoneNumLoginImpl.a().a(this.jdField_a_of_type_MqqAppAppRuntime, this.c.getBytes(), paramString.getBytes(), this.d, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716956, 1);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterWithNick
 * JD-Core Version:    0.7.0.1
 */