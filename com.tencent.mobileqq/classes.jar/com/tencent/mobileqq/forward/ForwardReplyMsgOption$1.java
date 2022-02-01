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
    if (this.a.a != null)
    {
      this.a.a.hideSoftInputFromWindow();
      ForwardReplyMsgOption localForwardReplyMsgOption = this.a;
      ForwardReplyMsgOption.a(localForwardReplyMsgOption, ForwardReplyMsgOption.a(localForwardReplyMsgOption).uniseq);
      this.a.G();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardReplyMsgOption.1
 * JD-Core Version:    0.7.0.1
 */