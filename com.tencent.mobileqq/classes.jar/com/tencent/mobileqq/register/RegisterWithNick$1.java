package com.tencent.mobileqq.register;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;

class RegisterWithNick$1
  extends WtloginObserver
{
  RegisterWithNick$1(RegisterWithNick paramRegisterWithNick) {}
  
  public void onRegGetSMSVerifyLoginAccount(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte1 = RegisterWithNick.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnRegGetSMSVerifyLoginAccount ret=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uin=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d(paramArrayOfByte1, 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    Object localObject = null;
    paramArrayOfByte1 = (byte[])localObject;
    if (paramArrayOfByte3 != null) {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte3, "utf-8");
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
        paramArrayOfByte1 = (byte[])localObject;
      }
    }
    localObject = this.a.jdField_a_of_type_MqqAppAppRuntime;
    String str = Integer.toString(paramInt);
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte3 = "";
    } else {
      paramArrayOfByte3 = paramArrayOfByte1;
    }
    ReportController.a((AppRuntime)localObject, "new_reg", "setting_page_no", "result", "", 1, "", str, "", paramArrayOfByte3, "", "", "", "", "");
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    if (paramInt == 0)
    {
      RegisterWithNick.a(this.a, Long.valueOf(paramLong).toString());
      RegisterWithNick.a(this.a, paramArrayOfByte2);
      if (TextUtils.isEmpty(RegisterWithNick.a(this.a)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716609, 1);
        return;
      }
      if ((RegisterWithNick.a(this.a) != null) && (RegisterWithNick.a(this.a).length != 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(RegisterWithNick.jdField_a_of_type_JavaLangString, 4, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccount ret: %s, uin: %s, sign: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), MD5.toMD5(RegisterWithNick.a(this.a)) }));
        }
        paramArrayOfByte1 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterQQNumberActivity.class);
        paramArrayOfByte1.putExtra("phonenum", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
        paramArrayOfByte1.putExtra("invite_code", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode);
        paramArrayOfByte1.putExtra("key", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
        paramArrayOfByte1.putExtra("key_register_is_phone_num_registered", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered);
        paramArrayOfByte1.putExtra("uin", RegisterWithNick.a(this.a));
        paramArrayOfByte1.putExtra("key_register_sign", RegisterWithNick.a(this.a));
        paramArrayOfByte1.putExtra("key_register_from_send_sms", RegisterWithNick.a(this.a));
        paramArrayOfByte1.putExtra("key_register_chose_bind_phone", true);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(paramArrayOfByte1);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716609, 1);
      return;
    }
    if (TextUtils.isEmpty(paramArrayOfByte1))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716609, 1);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterWithNick.1
 * JD-Core Version:    0.7.0.1
 */