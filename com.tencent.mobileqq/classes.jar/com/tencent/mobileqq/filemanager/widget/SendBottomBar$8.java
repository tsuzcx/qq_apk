package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendBottomBar$8
  implements View.OnClickListener
{
  SendBottomBar$8(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    SendBottomBar.a(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.8
 * JD-Core Version:    0.7.0.1
 */