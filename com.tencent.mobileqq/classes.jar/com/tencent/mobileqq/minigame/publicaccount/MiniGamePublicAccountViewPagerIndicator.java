package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MiniGamePublicAccountViewPagerIndicator
  extends LinearLayout
  implements ViewPager.OnPageChangeListener
{
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
    if (this.mViewPager == null) {}
    label71:
    do
    {
      do
      {
        return;
      } while ((this.mViewPager.getAdapter() == null) || (super.getChildCount() <= paramInt));
      int i = 0;
      if (i < super.getChildCount())
      {
        MiniGamePublicAccountViewPagerIndicator.IndicatorView localIndicatorView = (MiniGamePublicAccountViewPagerIndicator.IndicatorView)super.getChildAt(i);
        if (localIndicatorView != null) {
          if (i != paramInt) {
            break label71;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localIndicatorView.setSelected(bool);
          i += 1;
          break;
        }
      }
    } while (this.onPageSelectedListener == null);
    this.onPageSelectedListener.onPageSelected(paramInt);
  }
  
  public void refreshIndicator()
  {
    if (this.mViewPager == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.mViewPager.getAdapter();
    } while (localObject == null);
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
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      j = 0;
      while (j < k)
      {
        super.addView(new MiniGamePublicAccountViewPagerIndicator.IndicatorView(getContext()));
        j += 1;
      }
      j = 0;
      label110:
      if (j < super.getChildCount())
      {
        localObject = (MiniGamePublicAccountViewPagerIndicator.IndicatorView)super.getChildAt(j);
        if (localObject != null) {
          if (j != i) {
            break label155;
          }
        }
      }
      label155:
      for (boolean bool = true;; bool = false)
      {
        ((MiniGamePublicAccountViewPagerIndicator.IndicatorView)localObject).setSelected(bool);
        j += 1;
        break label110;
        break;
      }
    }
  }
  
  public void setOnPageSelectedListener(MiniGamePublicAccountViewPagerIndicator.OnPageSelectedListener paramOnPageSelectedListener)
  {
    this.onPageSelectedListener = paramOnPageSelectedListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
    if (this.mViewPager != null) {
      this.mViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountViewPagerIndicator
 * JD-Core Version:    0.7.0.1
 */