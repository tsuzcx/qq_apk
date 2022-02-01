package com.tencent.mobileqq.studymode.pwdverify;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StudyPwdBaseFragment$1
  implements View.OnClickListener
{
  StudyPwdBaseFragment$1(StudyPwdBaseFragment paramStudyPwdBaseFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getActivity() != null)
    {
      StudyPwdBaseFragment.a(this.a);
      this.a.getActivity().setResult(0);
      this.a.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */