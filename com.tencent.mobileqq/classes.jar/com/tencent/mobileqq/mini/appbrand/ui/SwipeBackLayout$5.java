package com.tencent.mobileqq.mini.appbrand.ui;

import aluq;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bafb;

class SwipeBackLayout$5
  implements DialogInterface.OnClickListener
{
  SwipeBackLayout$5(SwipeBackLayout paramSwipeBackLayout, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (SwipeBackLayout.access$1900(this.this$0).isShowing()) {
      SwipeBackLayout.access$1900(this.this$0).dismiss();
    }
    aluq.a(this.val$activity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.SwipeBackLayout.5
 * JD-Core Version:    0.7.0.1
 */