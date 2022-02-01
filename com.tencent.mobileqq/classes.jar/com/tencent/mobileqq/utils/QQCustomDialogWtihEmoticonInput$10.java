package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihEmoticonInput$10
  implements View.OnClickListener
{
  QQCustomDialogWtihEmoticonInput$10(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.b.hideSoftInputFromWindow();
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(this.b, 0);
      if (this.b.w)
      {
        if (this.b.m) {
          this.b.u.removeView(this.b.r.getView());
        } else {
          this.b.u.removeView(this.b.q);
        }
        this.b.w = false;
      }
    }
    try
    {
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
      label118:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label118;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.10
 * JD-Core Version:    0.7.0.1
 */