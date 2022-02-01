package com.tencent.mobileqq.mini.mainpage;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class AddPhoneNumberFragment$2$1$1
  implements Runnable
{
  AddPhoneNumberFragment$2$1$1(AddPhoneNumberFragment.2.1 param1, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = this.this$2.this$1.this$0.getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      QQToast.a(localBaseActivity, this.val$message, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.2.1.1
 * JD-Core Version:    0.7.0.1
 */