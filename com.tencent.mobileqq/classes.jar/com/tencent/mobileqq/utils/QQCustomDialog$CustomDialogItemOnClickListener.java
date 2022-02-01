package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialog$CustomDialogItemOnClickListener
  implements View.OnClickListener
{
  int i;
  
  public QQCustomDialog$CustomDialogItemOnClickListener(QQCustomDialog paramQQCustomDialog, int paramInt)
  {
    this.i = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.this$0.onArrayItemClick != null) {
      this.this$0.onArrayItemClick.onClick(this.this$0, this.this$0.customWhichToCallBack(this.i));
    }
    try
    {
      if (this.this$0.isShowing()) {
        this.this$0.dismiss();
      }
      label54:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.CustomDialogItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */