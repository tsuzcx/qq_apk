package com.tencent.mobileqq.conditionsearch.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimeSelectView$4
  implements View.OnClickListener
{
  TimeSelectView$4(TimeSelectView paramTimeSelectView) {}
  
  public void onClick(View paramView)
  {
    if (TimeSelectView.a(this.a) != null) {
      TimeSelectView.a(this.a).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.4
 * JD-Core Version:    0.7.0.1
 */