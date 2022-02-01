package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public class MiniGamePublicAccountViewPagerIndicator
  extends LinearLayout
  implements ViewPager.OnPageChangeListener
{
  private MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig mConfig;
  public ViewPager mViewPager;
  public MiniGamePublicAccountViewPagerIndicator.OnPageSelectedListener onPageSelectedListener;
  
  public MiniGamePublicAccountViewPagerIndicator(Context paramContext)
  {
    super(paramContext);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public MiniGamePublicAccountViewPagerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public ViewPager getViewPager()
  {
    return this.mViewPager;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    MiniGamePublicAccountViewPagerIndicator.IndicatorView localIndicatorView = (MiniGamePublicAccountViewPagerIndicator.IndicatorView)getChildAt(paramInt1);
    if (localIndicatorView != null) {
      localIndicatorView.update(paramFloat);
    }
    if (paramInt1 < getChildCount() - 1) {
      ((MiniGamePublicAccountViewPagerIndicator.IndicatorView)getChildAt(paramInt1 + 1)).update(1.0F - paramFloat);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.mViewPager;
    if (localObject == null) {
      return;
    }
    if (((ViewPager)localObject).getAdapter() == null) {
      return;
    }
    if (super.getChildCount() <= paramInt) {
      return;
    }
    int i = 0;
    while (i < super.getChildCount())
    {
      localObject = (MiniGamePublicAccountViewPagerIndicator.IndicatorView)super.getChildAt(i);
      if (localObject != null)
      {
        boolean bool;
        if (i == paramInt) {
          bool = true;
        } else {
          bool = false;
        }
        ((MiniGamePublicAccountViewPagerIndicator.IndicatorView)localObject).setSelected(bool);
      }
      i += 1;
    }
    localObject = this.onPageSelectedListener;
    if (localObject != null) {
      ((MiniGamePublicAccountViewPagerIndicator.OnPageSelectedListener)localObject).onPageSelected(paramInt);
    }
  }
  
  public void refreshIndicator()
  {
    Object localObject = this.mViewPager;
    if (localObject == null) {
      return;
    }
    localObject = ((ViewPager)localObject).getAdapter();
    if (localObject == null) {
      return;
    }
    int k = ((PagerAdapter)localObject).getCount();
    if (k <= 1)
    {
      super.setVisibility(4);
      return;
    }
    super.setVisibility(0);
    super.removeAllViews();
    int j = this.mViewPager.getCurrentItem();
    int i = j;
    if (j >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = 0;
    while (i < k)
    {
      super.addView(new MiniGamePublicAccountViewPagerIndicator.IndicatorView(getContext(), this.mConfig));
      i += 1;
    }
    i = 0;
    while (i < super.getChildCount())
    {
      localObject = (MiniGamePublicAccountViewPagerIndicator.IndicatorView)super.getChildAt(i);
      if (localObject != null)
      {
        boolean bool;
        if (i == j) {
          bool = true;
        } else {
          bool = false;
        }
        ((MiniGamePublicAccountViewPagerIndicator.IndicatorView)localObject).setSelected(bool);
      }
      i += 1;
    }
  }
  
  public void setIndicatorViewConfig(MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig paramIndicatorViewConfig)
  {
    this.mConfig = paramIndicatorViewConfig;
  }
  
  public void setOnPageSelectedListener(MiniGamePublicAccountViewPagerIndicator.OnPageSelectedListener paramOnPageSelectedListener)
  {
    this.onPageSelectedListener = paramOnPageSelectedListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
    paramViewPager = this.mViewPager;
    if (paramViewPager != null) {
      paramViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountViewPagerIndicator
 * JD-Core Version:    0.7.0.1
 */