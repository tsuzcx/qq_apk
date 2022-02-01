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
    if (SendBottomBar.e(this.a).isChecked())
    {
      SendBottomBar.f(this.a).c();
      SendBottomBar.e(this.a).setText(HardCodeUtil.a(2131896068));
    }
    else
    {
      SendBottomBar.f(this.a).d();
      SendBottomBar.e(this.a).setText(HardCodeUtil.a(2131896117));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.2
 * JD-Core Version:    0.7.0.1
 */