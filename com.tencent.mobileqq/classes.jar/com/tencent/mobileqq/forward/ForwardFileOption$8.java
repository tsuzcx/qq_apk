package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardFileOption$8
  implements View.OnClickListener
{
  ForwardFileOption$8(ForwardFileOption paramForwardFileOption) {}
  
  public void onClick(View paramView)
  {
    this.a.G();
    ForwardFileOption.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.8
 * JD-Core Version:    0.7.0.1
 */