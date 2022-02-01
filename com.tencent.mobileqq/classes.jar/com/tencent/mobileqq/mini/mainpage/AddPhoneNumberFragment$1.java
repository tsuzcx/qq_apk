package com.tencent.mobileqq.mini.mainpage;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddPhoneNumberFragment$1
  implements View.OnClickListener
{
  AddPhoneNumberFragment$1(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131371107) && (this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()))
    {
      this.this$0.getActivity().setResult(0);
      this.this$0.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.1
 * JD-Core Version:    0.7.0.1
 */