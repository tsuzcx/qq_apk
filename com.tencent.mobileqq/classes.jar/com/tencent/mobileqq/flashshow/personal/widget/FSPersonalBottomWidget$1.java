package com.tencent.mobileqq.flashshow.personal.widget;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

class FSPersonalBottomWidget$1
  extends ViewPager2.OnPageChangeCallback
{
  FSPersonalBottomWidget$1(FSPersonalBottomWidget paramFSPersonalBottomWidget) {}
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    FSPersonalBottomWidget localFSPersonalBottomWidget = this.a;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    FSPersonalBottomWidget.a(localFSPersonalBottomWidget, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSPersonalBottomWidget.1
 * JD-Core Version:    0.7.0.1
 */