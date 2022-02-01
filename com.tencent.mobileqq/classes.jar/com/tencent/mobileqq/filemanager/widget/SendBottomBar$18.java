package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendBottomBar$18
  implements View.OnClickListener
{
  SendBottomBar$18(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.e(this.a).isChecked())
    {
      SendBottomBar.c(this.a, true);
      FileManagerReporter.a("0X800942B");
    }
    else
    {
      SendBottomBar.d(this.a, false);
      SendBottomBar.c(this.a, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.18
 * JD-Core Version:    0.7.0.1
 */