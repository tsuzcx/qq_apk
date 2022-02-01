package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomSingleButtonDialog$CustomDialogItemOnClickListener
  implements View.OnClickListener
{
  int a;
  
  public QQCustomSingleButtonDialog$CustomDialogItemOnClickListener(QQCustomSingleButtonDialog paramQQCustomSingleButtonDialog, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.b.o != null)
    {
      DialogInterface.OnClickListener localOnClickListener = this.b.o;
      QQCustomSingleButtonDialog localQQCustomSingleButtonDialog = this.b;
      localOnClickListener.onClick(localQQCustomSingleButtonDialog, localQQCustomSingleButtonDialog.a(this.a));
      this.b.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomSingleButtonDialog.CustomDialogItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */