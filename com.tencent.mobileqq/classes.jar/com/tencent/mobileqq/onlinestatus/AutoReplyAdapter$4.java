package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoReplyAdapter$4
  implements View.OnClickListener
{
  AutoReplyAdapter$4(AutoReplyAdapter paramAutoReplyAdapter, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    if ((AutoReplyAdapter.c(this.b) != null) && (paramView != null))
    {
      int i = this.a.getTextId();
      AutoReplyAdapter.a(this.b, (View)paramView.getParent(), i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyAdapter.4
 * JD-Core Version:    0.7.0.1
 */