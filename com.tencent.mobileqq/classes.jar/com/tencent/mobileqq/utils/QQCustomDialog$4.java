package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialog$4
  implements CompoundButton.OnCheckedChangeListener
{
  QQCustomDialog$4(QQCustomDialog paramQQCustomDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DialogInterface.OnClickListener localOnClickListener = this.val$pl;
    QQCustomDialog localQQCustomDialog = this.this$0;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localOnClickListener.onClick(localQQCustomDialog, i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.4
 * JD-Core Version:    0.7.0.1
 */