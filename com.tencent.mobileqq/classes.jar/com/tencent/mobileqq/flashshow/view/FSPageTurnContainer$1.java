package com.tencent.mobileqq.flashshow.view;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.tencent.qphone.base.util.QLog;

class FSPageTurnContainer$1
  extends ViewPager2.OnPageChangeCallback
{
  FSPageTurnContainer$1(FSPageTurnContainer paramFSPageTurnContainer) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    super.onPageScrollStateChanged(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("  onPageScrollStateChanged  state = ");
    localStringBuilder.append(paramInt);
    QLog.d("FSPageTurnContainer", 1, localStringBuilder.toString());
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected  position = ");
    localStringBuilder.append(paramInt);
    QLog.d("FSPageTurnContainer", 1, localStringBuilder.toString());
    FSPageTurnContainer.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.FSPageTurnContainer.1
 * JD-Core Version:    0.7.0.1
 */