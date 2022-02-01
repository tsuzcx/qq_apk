package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoReplyAdapter$3
  implements View.OnClickListener
{
  AutoReplyAdapter$3(AutoReplyAdapter paramAutoReplyAdapter, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    this.b.a(this.a.getTextId());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyAdapter.3
 * JD-Core Version:    0.7.0.1
 */