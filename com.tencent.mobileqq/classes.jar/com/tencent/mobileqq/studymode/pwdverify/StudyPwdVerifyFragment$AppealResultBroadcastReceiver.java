package com.tencent.mobileqq.studymode.pwdverify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class StudyPwdVerifyFragment$AppealResultBroadcastReceiver
  extends BroadcastReceiver
{
  private StudyPwdVerifyFragment$AppealResultBroadcastReceiver(StudyPwdVerifyFragment paramStudyPwdVerifyFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int i = paramIntent.getIntExtra("jumpType", 0);
    if (i == 1)
    {
      this.a.a(false);
      return;
    }
    if (i == 2) {
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdVerifyFragment.AppealResultBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */