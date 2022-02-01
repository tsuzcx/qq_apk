package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardReplyMsgOption$1
  implements View.OnClickListener
{
  ForwardReplyMsgOption$1(ForwardReplyMsgOption paramForwardReplyMsgOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.hideSoftInputFromWindow();
      ForwardReplyMsgOption.a(this.a, ForwardReplyMsgOption.a(this.a).uniseq);
      this.a.F();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardReplyMsgOption.1
 * JD-Core Version:    0.7.0.1
 */