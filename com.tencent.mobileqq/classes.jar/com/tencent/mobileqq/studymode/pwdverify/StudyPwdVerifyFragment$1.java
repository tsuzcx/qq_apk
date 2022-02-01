package com.tencent.mobileqq.studymode.pwdverify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StudyPwdVerifyFragment$1
  implements View.OnClickListener
{
  StudyPwdVerifyFragment$1(StudyPwdVerifyFragment paramStudyPwdVerifyFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.l();
    this.a.o();
    ReportController.b(StudyPwdVerifyFragment.a(this.a), "dc00898", "", "", "0X800BD46", "0X800BD46", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdVerifyFragment.1
 * JD-Core Version:    0.7.0.1
 */