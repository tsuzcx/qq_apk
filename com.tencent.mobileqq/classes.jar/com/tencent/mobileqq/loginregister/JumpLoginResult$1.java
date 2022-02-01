package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class JumpLoginResult$1
  implements Runnable
{
  JumpLoginResult$1(JumpLoginResult paramJumpLoginResult, String paramString, Activity paramActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpLoginResult", 2, "-->login success(finish after ls), go to AgentActivity, account:" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.JumpLoginResult.1
 * JD-Core Version:    0.7.0.1
 */