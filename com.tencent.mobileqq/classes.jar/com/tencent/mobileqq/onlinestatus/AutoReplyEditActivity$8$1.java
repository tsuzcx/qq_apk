package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoReplyEditActivity$8$1
  implements View.OnClickListener
{
  AutoReplyEditActivity$8$1(AutoReplyEditActivity.8 param8) {}
  
  public void onClick(View paramView)
  {
    AutoReplyEditActivity.a(this.a.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.8.1
 * JD-Core Version:    0.7.0.1
 */