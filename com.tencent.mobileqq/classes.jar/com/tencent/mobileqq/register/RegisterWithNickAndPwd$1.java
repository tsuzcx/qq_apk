package com.tencent.mobileqq.register;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.security.RegisterOverseaHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;

class RegisterWithNickAndPwd$1
  extends AccountObserver
{
  RegisterWithNickAndPwd$1(RegisterWithNickAndPwd paramRegisterWithNickAndPwd) {}
  
  public void onGetQuickRegisterAccount(boolean paramBoolean, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetQuickRegisterAccount code = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(";uin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(";phoneNum=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(";mIsfromLH=");
      localStringBuilder.append(this.a.d);
      QLog.d("Login_Optimize_RegisterWithNickAndPwd", 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    if (!paramBoolean)
    {
      paramString1 = null;
      try
      {
        paramString2 = new String(paramArrayOfByte, "utf-8");
        paramString1 = paramString2;
      }
      catch (UnsupportedEncodingException paramString2)
      {
        paramString2.printStackTrace();
      }
      paramString2 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131716609);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramString2, 1);
      return;
    }
    if (paramInt == 0)
    {
      RegisterWithNickAndPwd.a(this.a, paramString1);
      RegisterWithNickAndPwd.b(this.a, paramString2);
      if ((!TextUtils.isEmpty(RegisterWithNickAndPwd.a(this.a))) && (!TextUtils.isEmpty(RegisterWithNickAndPwd.b(this.a))))
      {
        paramString1 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterQQNumberActivity.class);
        paramString1.putExtra("key_register_secret_phone", paramString2);
        paramString1.putExtra("uin", RegisterWithNickAndPwd.a(this.a));
        paramString1.putExtra("key_register_password", RegisterWithNickAndPwd.c(this.a));
        paramString1.putExtra("key_register_unbind", true);
        paramString1.putExtra("key_register_from_quick_register", this.a.jdField_a_of_type_Boolean);
        paramString1.putExtra("key_register_is_phone_num_registered", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered);
        paramString1.putExtra("key_register_has_pwd", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd);
        paramString1.putExtra("key_register_from_send_sms", this.a.b);
        paramString1.putExtra("key_register_chose_bind_phone", false);
        if ((this.a.c) && (!this.a.d))
        {
          RegisterWithNickAndPwd.a(this.a, paramString1, false);
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(paramString1);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716609, 1);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716609, 1);
  }
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "RegisterByNicknameAndPwdActivity onRegisterCommitPassResp ");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    Object localObject1;
    try
    {
      localObject1 = new String(paramArrayOfByte2, "utf-8");
    }
    catch (UnsupportedEncodingException paramArrayOfByte2)
    {
      paramArrayOfByte2.printStackTrace();
      localObject1 = null;
    }
    paramArrayOfByte2 = (byte[])localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramArrayOfByte2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131716609);
    }
    AppRuntime localAppRuntime = this.a.jdField_a_of_type_MqqAppAppRuntime;
    if (paramBoolean) {
      localObject1 = Integer.toString(paramInt);
    } else {
      localObject1 = "-1001";
    }
    Object localObject2;
    if (paramArrayOfByte2 == null) {
      localObject2 = "";
    } else {
      localObject2 = paramArrayOfByte2;
    }
    ReportController.a(localAppRuntime, "new_reg", "setting_page_yes", "result", "", 1, "", (String)localObject1, "", (String)localObject2, "", "", "", "", "");
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    if (!paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte2, 1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("RegisterByNicknameAndPwdActivity onRegisterCommitPassResp code = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(";uin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(";contactsig = ");
      if (paramArrayOfByte1 == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("RegisterWithNickAndPwd", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt == 0)
    {
      RegisterWithNickAndPwd.a(this.a, paramString);
      RegisterWithNickAndPwd.a(this.a, paramArrayOfByte1);
      RegisterWithNickAndPwd.b(this.a, paramArrayOfByte3);
      if (TextUtils.isEmpty(RegisterWithNickAndPwd.a(this.a)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte2, 1);
        return;
      }
      if ((RegisterWithNickAndPwd.a(this.a) != null) && (RegisterWithNickAndPwd.a(this.a).length != 0))
      {
        RegisterManager.a().b();
        this.a.e();
        if (!"CN".equals(RegisterOverseaHelper.a().a())) {
          ReportController.a(null, "dc00898", "", "", "0X800B8DD", "0X800B8DD", 0, 0, "", "", RegisterOverseaHelper.a().a(), "");
        }
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte2, 1);
      }
    }
    else
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte2, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterWithNickAndPwd.1
 * JD-Core Version:    0.7.0.1
 */