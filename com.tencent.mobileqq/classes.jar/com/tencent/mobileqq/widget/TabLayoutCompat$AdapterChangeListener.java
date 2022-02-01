package com.tencent.mobileqq.widget;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

class TabLayoutCompat$AdapterChangeListener
  implements ViewPagerCompat.OnAdapterChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  TabLayoutCompat$AdapterChangeListener(TabLayoutCompat paramTabLayoutCompat) {}
  
  public void a(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.a == paramViewPager) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.a(paramPagerAdapter2, this.jdField_a_of_type_Boolean);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.AdapterChangeListener
 * JD-Core Version:    0.7.0.1
 */