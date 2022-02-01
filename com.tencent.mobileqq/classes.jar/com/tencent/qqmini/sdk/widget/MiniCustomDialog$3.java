package com.tencent.qqmini.sdk.widget;

import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniCustomDialog$3
  implements CompoundButton.OnCheckedChangeListener
{
  MiniCustomDialog$3(MiniCustomDialog paramMiniCustomDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DialogInterface.OnClickListener localOnClickListener;
    MiniCustomDialog localMiniCustomDialog;
    if (this.val$pl != null)
    {
      localOnClickListener = this.val$pl;
      localMiniCustomDialog = this.this$0;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localOnClickListener.onClick(localMiniCustomDialog, i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniCustomDialog.3
 * JD-Core Version:    0.7.0.1
 */