package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class SendBottomBar$5
  implements View.OnClickListener
{
  SendBottomBar$5(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b.isShowing()) {
      this.a.b.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.5
 * JD-Core Version:    0.7.0.1
 */