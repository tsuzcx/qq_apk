package com.tencent.mobileqq.flashshow.part;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter;

class FSLayerBasePart$2
  extends ViewPager2.OnPageChangeCallback
{
  FSLayerBasePart$2(FSLayerBasePart paramFSLayerBasePart) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    super.onPageScrollStateChanged(paramInt);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    this.a.b.a(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSLayerBasePart.2
 * JD-Core Version:    0.7.0.1
 */