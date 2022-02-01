package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class DialogUtil$5
  implements View.OnClickListener
{
  DialogUtil$5(DialogInterface.OnClickListener paramOnClickListener1, Dialog paramDialog, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131431900) {}
    try
    {
      if (this.a != null) {
        this.a.onClick(this.b, 0);
      }
      if (!this.b.isShowing()) {
        break label96;
      }
      this.b.dismiss();
    }
    catch (Exception localException)
    {
      DialogInterface.OnClickListener localOnClickListener;
      break label96;
    }
    if (paramView.getId() == 2131431907)
    {
      localOnClickListener = this.c;
      if (localOnClickListener != null) {
        localOnClickListener.onClick(this.b, 1);
      }
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
    }
    label96:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil.5
 * JD-Core Version:    0.7.0.1
 */