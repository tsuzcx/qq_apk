package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendBottomBar$1
  implements View.OnClickListener
{
  SendBottomBar$1(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a) != null) {
      SendBottomBar.a(this.a).a();
    }
    if (SendBottomBar.a(this.a)) {
      FileManagerUtil.b(SendBottomBar.a(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FileManagerUtil.a(SendBottomBar.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.1
 * JD-Core Version:    0.7.0.1
 */