package com.tencent.viola.ui.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.viola.ui.adapter.VLoopAbleSliderAdapter;

class VSliderView$1
  implements ViewPager.OnPageChangeListener
{
  VSliderView$1(VSliderView paramVSliderView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    VSliderView localVSliderView = this.this$0;
    localVSliderView.mCurrentItemIndex = paramInt;
    paramInt = VSliderView.access$000(localVSliderView).getRealPosition(paramInt);
    if (VSliderView.access$100(this.this$0) != null) {
      VSliderView.access$100(this.this$0).change(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSliderView.1
 * JD-Core Version:    0.7.0.1
 */