package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class JumpLoginResult$1
  implements Runnable
{
  JumpLoginResult$1(JumpLoginResult paramJumpLoginResult, String paramString, Activity paramActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->login success(finish after ls), go to AgentActivity, account:");
      localStringBuilder.append(this.a);
      QLog.d("JumpLoginResult", 2, localStringBuilder.toString());
    }
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.JumpLoginResult.1
 * JD-Core Version:    0.7.0.1
 */