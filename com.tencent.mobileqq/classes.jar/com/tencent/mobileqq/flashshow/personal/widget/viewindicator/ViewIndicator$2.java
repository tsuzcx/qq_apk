package com.tencent.mobileqq.flashshow.personal.widget.viewindicator;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

class ViewIndicator$2
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      ViewIndicator.a(this.a, true);
      return;
    }
    if (paramInt == 0) {
      ViewIndicator.a(this.a, false);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewIndicator.a(this.a, paramInt1, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    ViewIndicator.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.viewindicator.ViewIndicator.2
 * JD-Core Version:    0.7.0.1
 */