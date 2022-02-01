package com.tencent.mobileqq.flashshow.widgets.common;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSCustomDialog$4
  implements View.OnClickListener
{
  FSCustomDialog$4(FSCustomDialog paramFSCustomDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.b, 0);
    }
    try
    {
      if (this.b.isShowing()) {
        this.b.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSCustomDialog.4
 * JD-Core Version:    0.7.0.1
 */