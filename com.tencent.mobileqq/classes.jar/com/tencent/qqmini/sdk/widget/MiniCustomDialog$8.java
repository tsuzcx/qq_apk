package com.tencent.qqmini.sdk.widget;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniCustomDialog$8
  implements View.OnClickListener
{
  MiniCustomDialog$8(MiniCustomDialog paramMiniCustomDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
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
      label37:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniCustomDialog.8
 * JD-Core Version:    0.7.0.1
 */