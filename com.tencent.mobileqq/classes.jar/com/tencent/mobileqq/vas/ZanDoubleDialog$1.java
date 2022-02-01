package com.tencent.mobileqq.vas;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ZanDoubleDialog$1
  implements View.OnClickListener
{
  ZanDoubleDialog$1(ZanDoubleDialog paramZanDoubleDialog) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.dismiss();
      continue;
      if (this.a.a != null) {
        this.a.a.onLeftClick();
      }
      this.a.dismiss();
      continue;
      if (this.a.a != null) {
        this.a.a.onRightClick();
      }
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanDoubleDialog.1
 * JD-Core Version:    0.7.0.1
 */