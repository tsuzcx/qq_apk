package com.tencent.mobileqq.mini.mainpage;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class AddPhoneNumberFragment$1
  implements View.OnClickListener
{
  AddPhoneNumberFragment$1(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131438510)
    {
      paramView = this.this$0.getBaseActivity();
      if ((paramView != null) && (!paramView.isFinishing()))
      {
        paramView.setResult(0);
        paramView.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.1
 * JD-Core Version:    0.7.0.1
 */