package com.tencent.mobileqq.widget.bounce;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.util.Iterator;
import java.util.List;

class BounceViewPager$MyOnPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private BounceViewPager$MyOnPageChangeListener(BounceViewPager paramBounceViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      BounceViewPager.a(this.a, 0.0F);
    }
    Iterator localIterator = BounceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((BounceViewPager.PageChangedObserver)localIterator.next()).b(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = this.a;
    ((BounceViewPager)localObject).a = paramInt1;
    BounceViewPager.a((BounceViewPager)localObject, paramFloat);
    this.a.a();
    localObject = BounceViewPager.a(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BounceViewPager.PageChangedObserver)((Iterator)localObject).next()).a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = BounceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((BounceViewPager.PageChangedObserver)localIterator.next()).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.bounce.BounceViewPager.MyOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */