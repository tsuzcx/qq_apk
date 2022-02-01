package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogThreeBtns$CustomDialogItemOnClickListener
  implements View.OnClickListener
{
  int a;
  
  public QQCustomDialogThreeBtns$CustomDialogItemOnClickListener(QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.b.k != null)
    {
      DialogInterface.OnClickListener localOnClickListener = this.b.k;
      QQCustomDialogThreeBtns localQQCustomDialogThreeBtns = this.b;
      localOnClickListener.onClick(localQQCustomDialogThreeBtns, localQQCustomDialogThreeBtns.a(this.a));
      this.b.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogThreeBtns.CustomDialogItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */