package com.tencent.mobileqq.loginwelcome;

import android.os.Bundle;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.qphone.base.util.QLog;

class LoginWelcomeManager$3
  extends PublicAccountObserver
{
  LoginWelcomeManager$3(LoginWelcomeManager paramLoginWelcomeManager, Bundle paramBundle) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("result", i);
      this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString);
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.3
 * JD-Core Version:    0.7.0.1
 */