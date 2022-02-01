package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoReplyEditActivity$6
  implements View.OnClickListener
{
  AutoReplyEditActivity$6(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    if (AutoReplyEditActivity.g(this.a)) {
      AutoReplyEditActivity.a(this.a, false);
    } else if (AutoReplyEditActivity.h(this.a)) {
      AutoReplyEditActivity.b(this.a, false);
    } else {
      AutoReplyEditActivity.a(this.a, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.6
 * JD-Core Version:    0.7.0.1
 */