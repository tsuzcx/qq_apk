package com.tencent.widget;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public abstract class OneViewPagerAdapter
  extends PagerAdapter
  implements ViewPager.OnPageChangeListener
{
  private int mPageScrollState = 0;
  ViewPager mViewPager;
  SparseArray<View> mViews = new SparseArray();
  
  public OneViewPagerAdapter(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    this.mViews.remove(paramInt);
  }
  
  public abstract View getView(int paramInt);
  
  public abstract void initView(Object paramObject, int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = getView(paramInt);
    Object localObject = localView;
    if (localView == null) {
      localObject = new FrameLayout(paramViewGroup.getContext());
    }
    if (((ViewPager)paramViewGroup).getCurrentItem() == paramInt) {
      initView(localObject, paramInt);
    }
    paramViewGroup.addView((View)localObject);
    this.mViews.put(paramInt, localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void loadView(int paramInt)
  {
    if (paramInt >= getCount()) {
      return;
    }
    View localView = (View)this.mViews.get(paramInt);
    if (localView != null) {
      initView(localView, paramInt);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.mPageScrollState = paramInt;
    if (this.mPageScrollState == 0)
    {
      int i = this.mViewPager.getCurrentItem();
      paramInt = 0;
      while (paramInt < this.mViews.size())
      {
        int j = this.mViews.keyAt(paramInt);
        if (j != i)
        {
          View localView = (View)this.mViews.valueAt(paramInt);
          if (localView != null) {
            unInitView(localView, j);
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.mPageScrollState == 1)
    {
      if (paramInt1 < this.mViewPager.getCurrentItem())
      {
        loadView(paramInt1);
        return;
      }
      if (paramInt1 == this.mViewPager.getCurrentItem()) {
        loadView(paramInt1 + 1);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    loadView(paramInt);
    int i = 0;
    while (i < this.mViews.size())
    {
      int j = this.mViews.keyAt(i);
      if (j != paramInt)
      {
        View localView = (View)this.mViews.valueAt(i);
        if (localView != null) {
          unInitView(localView, j);
        }
      }
      i += 1;
    }
  }
  
  public abstract void unInitView(Object paramObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.OneViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */