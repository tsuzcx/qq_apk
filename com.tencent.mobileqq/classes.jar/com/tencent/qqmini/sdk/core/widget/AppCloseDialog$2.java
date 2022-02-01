package com.tencent.qqmini.sdk.core.widget;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AppCloseDialog$2
  implements View.OnClickListener
{
  AppCloseDialog$2(AppCloseDialog paramAppCloseDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.val$nl;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.this$0, 1);
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
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.AppCloseDialog.2
 * JD-Core Version:    0.7.0.1
 */