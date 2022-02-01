package com.tencent.mobileqq.multiaio.widget;

import android.view.View;

class MultiAIOBaseViewPager$MultiAIOViewPositionComparator
  extends MultiAIOBaseViewPager.ViewPositionComparator
{
  private final MultiAIOBaseViewPager a;
  
  public MultiAIOBaseViewPager$MultiAIOViewPositionComparator(MultiAIOBaseViewPager paramMultiAIOBaseViewPager)
  {
    this.a = paramMultiAIOBaseViewPager;
  }
  
  public int a(View paramView1, View paramView2)
  {
    paramView1 = (MultiAIOBaseViewPager.LayoutParams)paramView1.getLayoutParams();
    paramView2 = (MultiAIOBaseViewPager.LayoutParams)paramView2.getLayoutParams();
    boolean bool1 = paramView1.a;
    boolean bool2 = paramView2.a;
    int i = -1;
    if (bool1 != bool2)
    {
      if (paramView1.a) {
        i = 1;
      }
      return i;
    }
    i = this.a.getCurrentItem();
    if (i == paramView1.e) {
      return 1;
    }
    if (i == paramView2.e) {
      return -1;
    }
    return paramView1.e - paramView2.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.MultiAIOViewPositionComparator
 * JD-Core Version:    0.7.0.1
 */