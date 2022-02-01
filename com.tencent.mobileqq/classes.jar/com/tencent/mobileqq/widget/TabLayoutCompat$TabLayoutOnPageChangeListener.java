package com.tencent.mobileqq.widget;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;

public class TabLayoutCompat$TabLayoutOnPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private int jdField_a_of_type_Int;
  private final WeakReference<TabLayoutCompat> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  public TabLayoutCompat$TabLayoutOnPageChangeListener(TabLayoutCompat paramTabLayoutCompat)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTabLayoutCompat);
  }
  
  void a()
  {
    this.b = 0;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    TabLayoutCompat localTabLayoutCompat = (TabLayoutCompat)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localTabLayoutCompat != null)
    {
      paramInt2 = this.b;
      boolean bool2 = false;
      boolean bool1;
      if ((paramInt2 == 2) && (this.jdField_a_of_type_Int != 1)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if ((this.b != 2) || (this.jdField_a_of_type_Int != 0)) {
        bool2 = true;
      }
      localTabLayoutCompat.a(paramInt1, paramFloat, bool1, bool2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    TabLayoutCompat localTabLayoutCompat = (TabLayoutCompat)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localTabLayoutCompat != null) && (localTabLayoutCompat.b() != paramInt) && (paramInt < localTabLayoutCompat.a()))
    {
      int i = this.b;
      boolean bool;
      if ((i != 0) && ((i != 2) || (this.jdField_a_of_type_Int != 0))) {
        bool = false;
      } else {
        bool = true;
      }
      TabLayoutCompat.Tab localTab1 = TabLayoutCompat.a(localTabLayoutCompat);
      localTabLayoutCompat.b(localTabLayoutCompat.a(paramInt), bool);
      TabLayoutCompat.Tab localTab2 = localTabLayoutCompat.a(paramInt);
      if ((TabLayoutCompat.a(localTabLayoutCompat) != null) && (localTab2 != null)) {
        TabLayoutCompat.a(localTabLayoutCompat).a(localTab2, localTab1, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.TabLayoutOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */