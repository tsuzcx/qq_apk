package com.tencent.qqmini.sdk.core.widget;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AppCloseDialog$1
  implements View.OnClickListener
{
  AppCloseDialog$1(AppCloseDialog paramAppCloseDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.val$pl;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.this$0, 0);
    }
    try
    {
      if (this.this$0.isShowing()) {
        this.this$0.dismiss();
      }
      label40:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label40;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.AppCloseDialog.1
 * JD-Core Version:    0.7.0.1
 */