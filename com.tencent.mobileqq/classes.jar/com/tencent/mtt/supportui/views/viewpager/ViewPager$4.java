package com.tencent.mtt.supportui.views.viewpager;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ViewPager$4
  implements ViewTreeObserver.OnPreDrawListener
{
  ViewPager$4(ViewPager paramViewPager) {}
  
  public boolean onPreDraw()
  {
    this.this$0.post(new ViewPager.4.1(this));
    this.this$0.getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.viewpager.ViewPager.4
 * JD-Core Version:    0.7.0.1
 */