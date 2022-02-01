package com.tencent.mobileqq.mini.mainpage;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class AddPhoneNumberFragment$8$1$1$1
  implements Runnable
{
  AddPhoneNumberFragment$8$1$1$1(AddPhoneNumberFragment.8.1.1 param1, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = this.this$3.this$2.this$1.this$0.getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      QQToast.makeText(localBaseActivity, this.val$errMsg, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8.1.1.1
 * JD-Core Version:    0.7.0.1
 */