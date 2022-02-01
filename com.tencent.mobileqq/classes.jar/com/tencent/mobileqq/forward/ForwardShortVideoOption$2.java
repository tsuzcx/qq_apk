package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardShortVideoOption$2
  implements View.OnClickListener
{
  ForwardShortVideoOption$2(ForwardShortVideoOption paramForwardShortVideoOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      ForwardShortVideoOption.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption.2
 * JD-Core Version:    0.7.0.1
 */