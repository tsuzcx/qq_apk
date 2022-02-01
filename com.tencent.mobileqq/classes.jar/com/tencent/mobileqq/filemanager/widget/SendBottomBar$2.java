package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendBottomBar$2
  implements View.OnClickListener
{
  SendBottomBar$2(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.a(this.a).d();
      SendBottomBar.a(this.a).setText(HardCodeUtil.a(2131713753));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SendBottomBar.a(this.a).e();
      SendBottomBar.a(this.a).setText(HardCodeUtil.a(2131713765));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.2
 * JD-Core Version:    0.7.0.1
 */