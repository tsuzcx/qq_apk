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
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterWithNickAndPwd", 2, "onGetQuickRegisterAccount code = " + paramInt + ";uin = " + paramString1 + ";phoneNum=" + paramString2 + ";mIsfromLH=" + this.a.d);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    if (!paramBoolean) {
      try
      {
        paramString1 = new String(paramArrayOfByte, "utf-8");
        paramString2 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131716956);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramString2, 1);
        return;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          paramString1 = null;
        }
      }
    }
    if (paramInt == 0)
    {
      RegisterWithNickAndPwd.a(this.a, paramString1);
      RegisterWithNickAndPwd.b(this.a, paramString2);
      if ((TextUtils.isEmpty(RegisterWithNickAndPwd.a(this.a))) || (TextUtils.isEmpty(RegisterWithNickAndPwd.b(this.a))))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716956, 1);
        return;
      }
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
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716956, 1);
  }
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "RegisterByNicknameAndPwdActivity onRegisterCommitPassResp ");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte2 = new String(paramArrayOfByte2, "utf-8");
        if (TextUtils.isEmpty(paramArrayOfByte2))
        {
          paramArrayOfByte2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131716956);
          AppRuntime localAppRuntime = this.a.jdField_a_of_type_MqqAppAppRuntime;
          if (paramBoolean)
          {
            localObject1 = Integer.toString(paramInt);
            if (paramArrayOfByte2 != null) {
              continue;
            }
            localObject2 = "";
            ReportController.a(localAppRuntime, "new_reg", "setting_page_yes", "result", "", 1, "", (String)localObject1, "", (String)localObject2, "", "", "", "", "");
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
            if (paramBoolean) {
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte2, 1);
          }
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte2)
      {
        paramArrayOfByte2.printStackTrace();
        paramArrayOfByte2 = null;
        continue;
        Object localObject1 = "-1001";
        continue;
        Object localObject2 = paramArrayOfByte2;
        continue;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("RegisterByNicknameAndPwdActivity onRegisterCommitPassResp code = ").append(paramInt).append(";uin = ").append(paramString).append(";contactsig = ");
          if (paramArrayOfByte1 == null)
          {
            paramBoolean = true;
            QLog.d("RegisterWithNickAndPwd", 2, paramBoolean);
          }
        }
        else
        {
          if (paramInt != 0) {
            continue;
          }
          RegisterWithNickAndPwd.a(this.a, paramString);
          RegisterWithNickAndPwd.a(this.a, paramArrayOfByte1);
          RegisterWithNickAndPwd.b(this.a, paramArrayOfByte3);
          if (!TextUtils.isEmpty(RegisterWithNickAndPwd.a(this.a))) {
            continue;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte2, 1);
          return;
        }
        paramBoolean = false;
        continue;
        if ((RegisterWithNickAndPwd.a(this.a) == null) || (RegisterWithNickAndPwd.a(this.a).length == 0))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte2, 1);
          return;
        }
        RegisterManager.a().b();
        this.a.e();
        if ("CN".equals(RegisterOverseaHelper.a().a())) {
          break;
        }
        ReportController.a(null, "dc00898", "", "", "0X800B8DD", "0X800B8DD", 0, 0, "", "", RegisterOverseaHelper.a().a(), "");
        return;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte2, 1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterWithNickAndPwd.1
 * JD-Core Version:    0.7.0.1
 */