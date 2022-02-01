package com.tencent.mobileqq.winkpublish.widget;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishCustomDialog$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.c, 1);
    }
    try
    {
      if ((this.c.isShowing()) && (this.b)) {
        this.c.dismiss();
      }
      label44:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.PublishCustomDialog.3
 * JD-Core Version:    0.7.0.1
 */