package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomedTabWidget$1
  implements View.OnClickListener
{
  CustomedTabWidget$1(CustomedTabWidget paramCustomedTabWidget) {}
  
  public void onClick(View paramView)
  {
    CustomedTabWidget localCustomedTabWidget = this.a;
    localCustomedTabWidget.setCurrentTab(localCustomedTabWidget.indexOfChild(paramView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomedTabWidget.1
 * JD-Core Version:    0.7.0.1
 */