package com.tencent.mobileqq.conditionsearch.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimeSelectView$3
  implements View.OnClickListener
{
  TimeSelectView$3(TimeSelectView paramTimeSelectView) {}
  
  public void onClick(View paramView)
  {
    if (TimeSelectView.a(this.a) != null) {
      TimeSelectView.a(this.a).a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.3
 * JD-Core Version:    0.7.0.1
 */