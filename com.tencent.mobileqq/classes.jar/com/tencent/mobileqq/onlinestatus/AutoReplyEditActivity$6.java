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
    if (AutoReplyEditActivity.c(this.a)) {
      AutoReplyEditActivity.a(this.a, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AutoReplyEditActivity.d(this.a)) {
        AutoReplyEditActivity.b(this.a, false);
      } else {
        AutoReplyEditActivity.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.6
 * JD-Core Version:    0.7.0.1
 */