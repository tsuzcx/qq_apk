package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardPluginShareStructMsgOption$3
  implements View.OnClickListener
{
  ForwardPluginShareStructMsgOption$3(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption) {}
  
  public void onClick(View paramView)
  {
    ForwardPluginShareStructMsgOption.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.3
 * JD-Core Version:    0.7.0.1
 */