package com.tencent.mobileqq.widget;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

class TabLayoutCompat$AdapterChangeListener
  implements ViewPagerCompat.OnAdapterChangeListener
{
  private boolean b;
  
  TabLayoutCompat$AdapterChangeListener(TabLayoutCompat paramTabLayoutCompat) {}
  
  public void a(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    if (this.a.m == paramViewPager) {
      this.a.a(paramPagerAdapter2, this.b);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.AdapterChangeListener
 * JD-Core Version:    0.7.0.1
 */