package com.tencent.mobileqq.now.widget;

import android.database.DataSetObserver;
import androidx.viewpager.widget.ViewPager;

class SimpleCircleIndicator$1
  extends DataSetObserver
{
  SimpleCircleIndicator$1(SimpleCircleIndicator paramSimpleCircleIndicator, ViewPager paramViewPager) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator.setCurrentItem(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.SimpleCircleIndicator.1
 * JD-Core Version:    0.7.0.1
 */