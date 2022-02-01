package com.tencent.mobileqq.wink.pick.circle.part;

import android.view.View;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

class WinkCirclePhotoListPart$2
  implements ViewPager.OnPageChangeListener
{
  WinkCirclePhotoListPart$2(WinkCirclePhotoListPart paramWinkCirclePhotoListPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((WinkCirclePhotoListPart.e(this.a) != null) && (WinkCirclePhotoListPart.e(this.a).getChildCount() > paramInt)) {
      WinkCirclePhotoListPart.e(this.a).getChildAt(paramInt).performClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePhotoListPart.2
 * JD-Core Version:    0.7.0.1
 */