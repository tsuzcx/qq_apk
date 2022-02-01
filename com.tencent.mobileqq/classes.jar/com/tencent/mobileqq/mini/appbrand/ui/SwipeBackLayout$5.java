package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import apoh;
import com.tencent.mobileqq.utils.QQCustomDialog;

class SwipeBackLayout$5
  implements DialogInterface.OnClickListener
{
  SwipeBackLayout$5(SwipeBackLayout paramSwipeBackLayout, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (SwipeBackLayout.access$1900(this.this$0).isShowing()) {
      SwipeBackLayout.access$1900(this.this$0).dismiss();
    }
    apoh.a(this.val$activity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.SwipeBackLayout.5
 * JD-Core Version:    0.7.0.1
 */