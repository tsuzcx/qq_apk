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
    if (l - this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a < 500L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a = l;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_a_of_type_Int, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView.2
 * JD-Core Version:    0.7.0.1
 */