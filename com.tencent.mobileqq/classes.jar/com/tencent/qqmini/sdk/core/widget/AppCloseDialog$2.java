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
    if (this.val$nl != null) {
      this.val$nl.onClick(this.this$0, 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      try
      {
        if (this.this$0.isShowing()) {
          this.this$0.dismiss();
        }
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.AppCloseDialog.2
 * JD-Core Version:    0.7.0.1
 */