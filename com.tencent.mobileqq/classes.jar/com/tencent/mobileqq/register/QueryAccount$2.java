package com.tencent.mobileqq.register;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.security.RegisterOverseaHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;

class QueryAccount$2
  extends AccountObserver
{
  QueryAccount$2(QueryAccount paramQueryAccount) {}
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onRegQueryAccountResp isSuccess=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" code=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("queryMobile", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    } else {
      paramArrayOfByte = null;
    }
    AppRuntime localAppRuntime = this.a.jdField_a_of_type_MqqAppAppRuntime;
    if (paramBoolean) {
      localObject1 = Integer.toString(paramInt);
    } else {
      localObject1 = "-1001";
    }
    Object localObject2;
    if (paramArrayOfByte == null) {
      localObject2 = "";
    } else {
      localObject2 = paramArrayOfByte;
    }
    ReportController.a(localAppRuntime, "new_reg", "reg_page", "next_clk", "", 1, "", (String)localObject1, "", (String)localObject2, "", "", "", "", "");
    if (!paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
      localObject1 = paramArrayOfByte;
      if (TextUtils.isEmpty(paramArrayOfByte)) {
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131716609);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast((String)localObject1, 0);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfByte))
    {
      int j = paramArrayOfByte.indexOf("(");
      int i = paramArrayOfByte.indexOf(")");
      if ((j > 0) && (i > 0))
      {
        j += 1;
        if (j < i) {
          QueryAccount.a(this.a, paramArrayOfByte.substring(j, i));
        }
      }
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 5)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
              localObject1 = paramArrayOfByte;
              if (TextUtils.isEmpty(paramArrayOfByte)) {
                localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getResources().getString(2131716609);
              }
              this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast((String)localObject1, 0);
              return;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered = true;
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd = false;
            this.a.a(null);
            return;
          }
          QueryAccount.a(this.a);
          return;
        }
        QueryAccount.a(this.a);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered = true;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd = true;
      this.a.a(null);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered = false;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd = true;
    this.a.a(null);
  }
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueryAccount", 2, "onRegisterCommitMobileResp");
    }
    Object localObject3 = null;
    String str = null;
    if (paramArrayOfByte1 != null) {}
    Object localObject1;
    try
    {
      str = new String(paramArrayOfByte1, "utf-8");
      localObject3 = str;
      localObject1 = str;
      if (QLog.isColorLevel())
      {
        localObject3 = str;
        localObject1 = new StringBuilder();
        localObject3 = str;
        ((StringBuilder)localObject1).append("onRegisterCommitMobileResp code = ");
        localObject3 = str;
        ((StringBuilder)localObject1).append(paramInt);
        localObject3 = str;
        ((StringBuilder)localObject1).append(";strMsg = ");
        localObject3 = str;
        ((StringBuilder)localObject1).append(str);
        localObject3 = str;
        QLog.d("QueryAccount", 2, ((StringBuilder)localObject1).toString());
        localObject1 = str;
      }
    }
    catch (Exception localException)
    {
      localObject1 = localObject3;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onRegisterCommitMobileResp strPromptInfo exception = ");
        ((StringBuilder)localObject1).append(localException);
        QLog.d("QueryAccount", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject3;
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    if ((paramInt != 3) && (paramInt != 59)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    }
    if (paramArrayOfByte2 != null) {
      try
      {
        new String(paramArrayOfByte2, "UTF-8");
      }
      catch (Exception paramArrayOfByte2)
      {
        paramArrayOfByte2.printStackTrace();
      }
      catch (UnsupportedEncodingException paramArrayOfByte2)
      {
        paramArrayOfByte2.printStackTrace();
      }
    }
    paramArrayOfByte2 = this.a.jdField_a_of_type_MqqAppAppRuntime;
    int i;
    if (TextUtils.isEmpty(paramString)) {
      i = 2;
    } else {
      i = 1;
    }
    int j;
    if (paramBoolean) {
      j = 0;
    } else {
      j = paramInt;
    }
    ReportController.a(paramArrayOfByte2, "dc00898", "", "", "0X8009844", "0X8009844", i, j, "", "", "", "");
    localObject3 = this.a.jdField_a_of_type_MqqAppAppRuntime;
    if (paramBoolean) {
      paramArrayOfByte2 = Integer.toString(paramInt);
    } else {
      paramArrayOfByte2 = "-1001";
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = "2";
    } else {
      paramString = "1";
    }
    Object localObject2;
    if (localObject1 == null) {
      localObject2 = "";
    } else {
      localObject2 = localObject1;
    }
    ReportController.a((AppRuntime)localObject3, "new_reg", "reg_page", "next_msg", "", 1, "", paramArrayOfByte2, paramString, (String)localObject2, "", "", "", "", "");
    if (!paramBoolean)
    {
      paramArrayOfByte1 = (byte[])localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramArrayOfByte1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131716609);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte1, 0);
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 7)
              {
                if (paramInt != 8)
                {
                  if (paramInt != 9)
                  {
                    if (paramInt != 59)
                    {
                      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716609, 0);
                      return;
                    }
                    QueryAccount.c(this.a, (String)localObject1);
                    return;
                  }
                  RegisterOverseaHelper.a().a(this.a.jdField_a_of_type_MqqAppAppRuntime, this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, paramArrayOfByte1);
                  return;
                }
                this.a.b((String)localObject1);
                return;
              }
              paramArrayOfByte1 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterQQNumberActivity.class);
              paramArrayOfByte1.putExtra("phonenum", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
              paramArrayOfByte1.putExtra("invite_code", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode);
              paramArrayOfByte1.putExtra("key", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
              paramArrayOfByte1.putExtra("key_register_is_phone_num_registered", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered);
              paramArrayOfByte1.putExtra("key_register_has_pwd", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd);
              paramArrayOfByte1.putExtra("key_register_result", false);
              this.a.b(paramArrayOfByte1);
              this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(paramArrayOfByte1);
              return;
            }
            if (paramArrayOfByte1 != null) {
              try
              {
                paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
                if (!TextUtils.isEmpty(paramArrayOfByte1))
                {
                  this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.handler.post(new QueryAccount.2.1(this, paramArrayOfByte1));
                  return;
                }
                if (!QLog.isColorLevel()) {
                  return;
                }
                QLog.d("QueryAccount", 2, "captcha url is empty");
                return;
              }
              catch (Throwable paramArrayOfByte1)
              {
                paramArrayOfByte1.printStackTrace();
                return;
              }
            }
          }
          else
          {
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716609, 0);
              return;
            }
            QueryAccount.b(this.a, (String)localObject1);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
          }
        }
        else
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            QueryAccount.a(this.a, (String)localObject1);
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716609, 0);
        }
      }
      else {
        QueryAccount.a(this.a, 0, 0L);
      }
    }
    else {
      QueryAccount.a(this.a, 0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.2
 * JD-Core Version:    0.7.0.1
 */