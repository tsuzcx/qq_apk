package com.tencent.mobileqq.mini.mainpage;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;

class AddPhoneNumberFragment$2$1$1
  implements Runnable
{
  AddPhoneNumberFragment$2$1$1(AddPhoneNumberFragment.2.1 param1, String paramString) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = this.this$2.this$1.this$0.getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      QQToast.a(localFragmentActivity, this.val$message, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.2.1.1
 * JD-Core Version:    0.7.0.1
 */