package com.tencent.mobileqq.jumpcontroller;

import android.content.Intent;
import android.os.Message;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.haoliyou.JumpForwardSecurityCheck;
import mqq.os.MqqHandler;

class JumpControllerInject$1
  implements Runnable
{
  JumpControllerInject$1(JumpControllerInject paramJumpControllerInject, JumpForwardSecurityCheck paramJumpForwardSecurityCheck, Intent paramIntent, int paramInt, JumpActivity paramJumpActivity) {}
  
  public void run()
  {
    Object localObject = this.a;
    Intent localIntent = this.b;
    if (!((JumpForwardSecurityCheck)localObject).a(localIntent, localIntent.getAction()))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = this.c;
      ((Message)localObject).obj = this.b;
      this.d.uiHandler.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jumpcontroller.JumpControllerInject.1
 * JD-Core Version:    0.7.0.1
 */