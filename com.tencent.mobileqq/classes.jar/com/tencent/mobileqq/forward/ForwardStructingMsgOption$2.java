package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardStructingMsgOption$2
  implements View.OnClickListener
{
  ForwardStructingMsgOption$2(ForwardStructingMsgOption paramForwardStructingMsgOption) {}
  
  public void onClick(View paramView)
  {
    ForwardStructingMsgOption.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardStructingMsgOption.2
 * JD-Core Version:    0.7.0.1
 */