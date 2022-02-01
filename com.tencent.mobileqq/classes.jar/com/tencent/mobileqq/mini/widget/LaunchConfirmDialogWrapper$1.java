package com.tencent.mobileqq.mini.widget;

import android.view.View;
import android.view.View.OnClickListener;

class LaunchConfirmDialogWrapper$1
  implements View.OnClickListener
{
  LaunchConfirmDialogWrapper$1(LaunchConfirmDialogWrapper paramLaunchConfirmDialogWrapper, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.val$listener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    this.this$0.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.LaunchConfirmDialogWrapper.1
 * JD-Core Version:    0.7.0.1
 */