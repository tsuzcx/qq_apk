package com.tencent.mobileqq.mini.mainpage;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;

class AddPhoneNumberFragment$8
  implements View.OnClickListener
{
  AddPhoneNumberFragment$8(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(AddPhoneNumberFragment.access$1000(this.this$0))) {
      MiniAppSendSmsCodeServlet.sendVerifySmsCodeRequest(AddPhoneNumberFragment.access$1000(this.this$0), AddPhoneNumberFragment.access$000(this.this$0), "+86", new AddPhoneNumberFragment.8.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8
 * JD-Core Version:    0.7.0.1
 */