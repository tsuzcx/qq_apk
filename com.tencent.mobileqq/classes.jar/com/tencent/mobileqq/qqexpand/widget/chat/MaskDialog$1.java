package com.tencent.mobileqq.qqexpand.widget.chat;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MaskDialog$1
  implements View.OnClickListener
{
  MaskDialog$1(MaskDialog paramMaskDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.a.onClick(this.b, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.chat.MaskDialog.1
 * JD-Core Version:    0.7.0.1
 */