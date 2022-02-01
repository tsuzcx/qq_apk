package com.tencent.mobileqq.studymode.pwdverify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StudyPwdSetConfirmFragment$1
  implements View.OnClickListener
{
  StudyPwdSetConfirmFragment$1(StudyPwdSetConfirmFragment paramStudyPwdSetConfirmFragment) {}
  
  public void onClick(View paramView)
  {
    StudyPwdSetConfirmFragment.a(this.a);
    ReportController.b(StudyPwdSetConfirmFragment.b(this.a), "dc00898", "", "", "0X800BD42", "0X800BD42", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetConfirmFragment.1
 * JD-Core Version:    0.7.0.1
 */