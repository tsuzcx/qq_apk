package com.tencent.mobileqq.widget;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;

public class TabLayoutCompat$TabLayoutOnPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private final WeakReference<TabLayoutCompat> a;
  private int b;
  private int c;
  
  public TabLayoutCompat$TabLayoutOnPageChangeListener(TabLayoutCompat paramTabLayoutCompat)
  {
    this.a = new WeakReference(paramTabLayoutCompat);
  }
  
  void a()
  {
    this.c = 0;
    this.b = 0;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.b = this.c;
    this.c = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    TabLayoutCompat localTabLayoutCompat = (TabLayoutCompat)this.a.get();
    if (localTabLayoutCompat != null)
    {
      paramInt2 = this.c;
      boolean bool2 = false;
      boolean bool1;
      if ((paramInt2 == 2) && (this.b != 1)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if ((this.c != 2) || (this.b != 0)) {
        bool2 = true;
      }
      localTabLayoutCompat.a(paramInt1, paramFloat, bool1, bool2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    TabLayoutCompat localTabLayoutCompat = (TabLayoutCompat)this.a.get();
    if ((localTabLayoutCompat != null) && (localTabLayoutCompat.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayoutCompat.getTabCount()))
    {
      int i = this.c;
      boolean bool;
      if ((i != 0) && ((i != 2) || (this.b != 0))) {
        bool = false;
      } else {
        bool = true;
      }
      TabLayoutCompat.Tab localTab1 = TabLayoutCompat.a(localTabLayoutCompat);
      localTabLayoutCompat.b(localTabLayoutCompat.b(paramInt), bool);
      TabLayoutCompat.Tab localTab2 = localTabLayoutCompat.b(paramInt);
      if ((TabLayoutCompat.b(localTabLayoutCompat) != null) && (localTab2 != null)) {
        TabLayoutCompat.b(localTabLayoutCompat).a(localTab2, localTab1, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.TabLayoutOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */