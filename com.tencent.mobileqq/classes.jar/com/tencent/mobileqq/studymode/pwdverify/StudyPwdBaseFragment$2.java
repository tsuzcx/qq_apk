package com.tencent.mobileqq.studymode.pwdverify;

import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.mobileqq.widget.container.AdaptiveKeyboardLayout;

class StudyPwdBaseFragment$2
  implements Runnable
{
  StudyPwdBaseFragment$2(StudyPwdBaseFragment paramStudyPwdBaseFragment) {}
  
  public void run()
  {
    if (this.this$0.isResumed())
    {
      StudyPwdBaseFragment.b(this.this$0).setKeyboardLayoutEnable(true);
      StudyPwdBaseFragment.d(this.this$0).a(StudyPwdBaseFragment.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */