package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComplexGuidViewPager$1
  implements View.OnClickListener
{
  ComplexGuidViewPager$1(ComplexGuidViewPager paramComplexGuidViewPager) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager.1
 * JD-Core Version:    0.7.0.1
 */