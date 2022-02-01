package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ClickableToastView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (ClickableToastView.a(this.a).d != null)
    {
      this.a.a();
      ClickableToastView.a(this.a).d.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClickableToastView.2
 * JD-Core Version:    0.7.0.1
 */