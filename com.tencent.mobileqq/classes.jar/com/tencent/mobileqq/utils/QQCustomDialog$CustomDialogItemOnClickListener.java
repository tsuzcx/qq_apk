package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialog$CustomDialogItemOnClickListener
  implements View.OnClickListener
{
  int a;
  
  public QQCustomDialog$CustomDialogItemOnClickListener(QQCustomDialog paramQQCustomDialog, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.b.onArrayItemClick != null)
    {
      DialogInterface.OnClickListener localOnClickListener = this.b.onArrayItemClick;
      QQCustomDialog localQQCustomDialog = this.b;
      localOnClickListener.onClick(localQQCustomDialog, localQQCustomDialog.customWhichToCallBack(this.a));
    }
    try
    {
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
      label55:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.CustomDialogItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */