package com.tencent.mobileqq.richmedia.capture.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQSlidingTabView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.b.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView.1
 * JD-Core Version:    0.7.0.1
 */