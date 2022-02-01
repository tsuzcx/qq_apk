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
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "onRegQueryAccountResp isSuccess=" + paramBoolean + " code=" + paramInt);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        AppRuntime localAppRuntime = this.a.jdField_a_of_type_MqqAppAppRuntime;
        if (paramBoolean)
        {
          localObject1 = Integer.toString(paramInt);
          if (paramArrayOfByte != null) {
            continue;
          }
          localObject2 = "";
          ReportController.a(localAppRuntime, "new_reg", "reg_page", "next_clk", "", 1, "", (String)localObject1, "", (String)localObject2, "", "", "", "", "");
          if (paramBoolean) {
            continue;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
          localObject1 = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131716956);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast((String)localObject1, 0);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
        continue;
        Object localObject1 = "-1001";
        continue;
        Object localObject2 = paramArrayOfByte;
        continue;
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          int i = paramArrayOfByte.indexOf("(");
          int j = paramArrayOfByte.indexOf(")");
          if ((i > 0) && (j > 0) && (i + 1 < j)) {
            QueryAccount.a(this.a, paramArrayOfByte.substring(i + 1, j));
          }
        }
        switch (paramInt)
        {
        case 4: 
        default: 
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
          localObject1 = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getResources().getString(2131716956);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast((String)localObject1, 0);
          return;
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered = false;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd = true;
      this.a.a(null);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered = true;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd = true;
      this.a.a(null);
      return;
      QueryAccount.a(this.a);
      return;
      QueryAccount.a(this.a);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered = true;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd = false;
      this.a.a(null);
      return;
      paramArrayOfByte = null;
    }
  }
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueryAccount", 2, "onRegisterCommitMobileResp");
    }
    if (paramArrayOfByte1 != null) {}
    for (;;)
    {
      String str1;
      try
      {
        str1 = new String(paramArrayOfByte1, "utf-8");
        if (!QLog.isColorLevel()) {
          break label122;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("QueryAccount", 2, "onRegisterCommitMobileResp code = " + paramInt + ";strMsg = " + str1);
          }
          if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
            break label125;
          }
          return;
        }
        catch (Exception localException2)
        {
          break label90;
        }
        localException1 = localException1;
        str1 = null;
      }
      label90:
      QLog.d("QueryAccount", 2, "onRegisterCommitMobileResp strPromptInfo exception = " + localException1);
      label122:
      continue;
      label125:
      if ((paramInt != 3) && (paramInt != 59)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
      }
      if (paramArrayOfByte2 != null) {}
      try
      {
        new String(paramArrayOfByte2, "UTF-8");
        paramArrayOfByte2 = this.a.jdField_a_of_type_MqqAppAppRuntime;
        if (TextUtils.isEmpty(paramString))
        {
          i = 2;
          if (!paramBoolean) {
            break label356;
          }
          j = 0;
          ReportController.a(paramArrayOfByte2, "dc00898", "", "", "0X8009844", "0X8009844", i, j, "", "", "", "");
          AppRuntime localAppRuntime = this.a.jdField_a_of_type_MqqAppAppRuntime;
          if (!paramBoolean) {
            break label362;
          }
          paramArrayOfByte2 = Integer.toString(paramInt);
          if (!TextUtils.isEmpty(paramString)) {
            break label369;
          }
          paramString = "2";
          if (str1 != null) {
            break label376;
          }
          str2 = "";
          ReportController.a(localAppRuntime, "new_reg", "reg_page", "next_msg", "", 1, "", paramArrayOfByte2, paramString, str2, "", "", "", "", "");
          if (paramBoolean) {
            break label383;
          }
          paramArrayOfByte1 = str1;
          if (TextUtils.isEmpty(str1)) {
            paramArrayOfByte1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131716956);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(paramArrayOfByte1, 0);
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte2)
      {
        for (;;)
        {
          paramArrayOfByte2.printStackTrace();
        }
      }
      catch (Exception paramArrayOfByte2)
      {
        for (;;)
        {
          paramArrayOfByte2.printStackTrace();
          continue;
          int i = 1;
          continue;
          label356:
          int j = paramInt;
          continue;
          label362:
          paramArrayOfByte2 = "-1001";
          continue;
          label369:
          paramString = "1";
          continue;
          label376:
          String str2 = str1;
        }
        switch (paramInt)
        {
        default: 
          label383:
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716956, 0);
          return;
        }
      }
      QueryAccount.a(this.a, 0, 0L);
      return;
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str1)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716956, 0);
        return;
      }
      QueryAccount.a(this.a, str1);
      return;
      QueryAccount.a(this.a, 0, 0L);
      return;
      if (TextUtils.isEmpty(str1))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716956, 0);
        return;
      }
      QueryAccount.b(this.a, str1);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
      return;
      if (paramArrayOfByte1 != null)
      {
        try
        {
          paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
          if (!TextUtils.isEmpty(paramArrayOfByte1))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.handler.post(new QueryAccount.2.1(this, paramArrayOfByte1));
            return;
          }
        }
        catch (Throwable paramArrayOfByte1)
        {
          paramArrayOfByte1.printStackTrace();
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("QueryAccount", 2, "captcha url is empty");
          return;
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
          this.a.b(str1);
          return;
          RegisterOverseaHelper.a().a(this.a.jdField_a_of_type_MqqAppAppRuntime, this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, paramArrayOfByte1);
          return;
          QueryAccount.c(this.a, str1);
          return;
          str1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.2
 * JD-Core Version:    0.7.0.1
 */