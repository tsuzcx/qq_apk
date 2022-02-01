package com.tencent.mobileqq.mini.mainpage;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddPhoneNumberFragment$2
  implements View.OnClickListener
{
  AddPhoneNumberFragment$2(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(AddPhoneNumberFragment.access$000(this.this$0))) {
      MiniAppSendSmsCodeServlet.sendSmsCodeRequest(AddPhoneNumberFragment.access$000(this.this$0), "+86", new AddPhoneNumberFragment.2.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.2
 * JD-Core Version:    0.7.0.1
 */