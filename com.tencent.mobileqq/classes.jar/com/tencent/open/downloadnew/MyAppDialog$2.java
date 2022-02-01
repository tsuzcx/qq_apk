package com.tencent.open.downloadnew;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MyAppDialog$2
  implements View.OnClickListener
{
  MyAppDialog$2(MyAppDialog paramMyAppDialog, DialogInterface.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.d, this.b);
    }
    if (this.c) {
      this.d.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog.2
 * JD-Core Version:    0.7.0.1
 */