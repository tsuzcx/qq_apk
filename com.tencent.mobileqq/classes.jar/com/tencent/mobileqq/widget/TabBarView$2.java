package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TabBarView$2
  implements View.OnClickListener
{
  TabBarView$2(TabBarView paramTabBarView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a >= 500L)
    {
      TabBarView localTabBarView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
      localTabBarView.a = l;
      localTabBarView.setSelectedTab(this.jdField_a_of_type_Int, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView.2
 * JD-Core Version:    0.7.0.1
 */