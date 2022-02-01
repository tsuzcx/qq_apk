package com.tencent.mobileqq.now.widget;

import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;

class SimpleCircleIndicator$1
  extends DataSetObserver
{
  SimpleCircleIndicator$1(SimpleCircleIndicator paramSimpleCircleIndicator, ViewPager paramViewPager) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator.setCurrentItem(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.SimpleCircleIndicator.1
 * JD-Core Version:    0.7.0.1
 */