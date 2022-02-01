package com.tencent.qqmini.sdk.widget;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniCustomDialog$CustomDialogItemOnClickListener
  implements View.OnClickListener
{
  int i;
  
  public MiniCustomDialog$CustomDialogItemOnClickListener(MiniCustomDialog paramMiniCustomDialog, int paramInt)
  {
    this.i = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.this$0.onArrayItemClick != null)
    {
      DialogInterface.OnClickListener localOnClickListener = this.this$0.onArrayItemClick;
      MiniCustomDialog localMiniCustomDialog = this.this$0;
      localOnClickListener.onClick(localMiniCustomDialog, localMiniCustomDialog.customWhichToCallBack(this.i));
    }
    try
    {
      if (this.this$0.isShowing()) {
        this.this$0.dismiss();
      }
      label55:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniCustomDialog.CustomDialogItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */