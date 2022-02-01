package com.tencent.mobileqq.flashshow.personal.widget.viewindicator;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

class ViewIndicator$3
  extends ViewPager2.OnPageChangeCallback
{
  ViewIndicator$3(ViewIndicator paramViewIndicator) {}
  
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
    super.onPageSelected(paramInt);
    ViewIndicator.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.viewindicator.ViewIndicator.3
 * JD-Core Version:    0.7.0.1
 */