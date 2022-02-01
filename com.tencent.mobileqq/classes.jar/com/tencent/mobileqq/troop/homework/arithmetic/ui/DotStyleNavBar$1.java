package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;

class DotStyleNavBar$1
  implements ViewPager.OnPageChangeListener
{
  DotStyleNavBar$1(DotStyleNavBar paramDotStyleNavBar) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (DotStyleNavBar.a(this.a) != null) {
      DotStyleNavBar.a(this.a).onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (DotStyleNavBar.a(this.a) != null) {
      DotStyleNavBar.a(this.a).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.a.setCurrent(paramInt);
    if (DotStyleNavBar.a(this.a) != null) {
      DotStyleNavBar.a(this.a).onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.DotStyleNavBar.1
 * JD-Core Version:    0.7.0.1
 */