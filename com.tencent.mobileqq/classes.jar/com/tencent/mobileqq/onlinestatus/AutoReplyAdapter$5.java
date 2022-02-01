package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoReplyAdapter$5
  implements View.OnClickListener
{
  AutoReplyAdapter$5(AutoReplyAdapter paramAutoReplyAdapter, AutoReplyText paramAutoReplyText, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (AutoReplyAdapter.c(this.c) != null) {
      AutoReplyAdapter.c(this.c).b(this.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyAdapter.5
 * JD-Core Version:    0.7.0.1
 */