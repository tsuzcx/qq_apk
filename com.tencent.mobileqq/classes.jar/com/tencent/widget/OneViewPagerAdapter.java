package com.tencent.widget;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class OneViewPagerAdapter
  extends PagerAdapter
  implements ViewPager.OnPageChangeListener
{
  private int jdField_a_of_type_Int = 0;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  SparseArray<View> b = new SparseArray();
  
  public OneViewPagerAdapter(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public abstract View a(int paramInt);
  
  public abstract void a(Object paramObject, int paramInt);
  
  public abstract void b(Object paramObject, int paramInt);
  
  public void c(int paramInt)
  {
    if (paramInt >= getCount()) {}
    View localView;
    do
    {
      return;
      localView = (View)this.b.get(paramInt);
    } while (localView == null);
    a(localView, paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    this.b.remove(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      localObject = new FrameLayout(paramViewGroup.getContext());
    }
    for (;;)
    {
      if (((ViewPager)paramViewGroup).getCurrentItem() == paramInt) {
        a(localObject, paramInt);
      }
      paramViewGroup.addView((View)localObject);
      this.b.put(paramInt, localObject);
      return localObject;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0)
    {
      int i = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
      paramInt = 0;
      while (paramInt < this.b.size())
      {
        int j = this.b.keyAt(paramInt);
        if (j != i)
        {
          View localView = (View)this.b.valueAt(paramInt);
          if (localView != null) {
            b(localView, j);
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (paramInt1 >= this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem()) {
        break label25;
      }
      c(paramInt1);
    }
    label25:
    while (paramInt1 != this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem()) {
      return;
    }
    c(paramInt1 + 1);
  }
  
  public void onPageSelected(int paramInt)
  {
    c(paramInt);
    int i = 0;
    while (i < this.b.size())
    {
      int j = this.b.keyAt(i);
      if (j != paramInt)
      {
        View localView = (View)this.b.valueAt(i);
        if (localView != null) {
          b(localView, j);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.OneViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */