package com.tencent.mtt.hippy.views.viewpager;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.supportui.views.viewpager.ViewPager.LayoutParams;
import com.tencent.mtt.supportui.views.viewpager.ViewPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class HippyViewPagerAdapter
  extends ViewPagerAdapter
{
  private static final String TAG = "HippyViewPagerAdapter";
  private int mChildSize = 0;
  private HippyInstanceContext mEngineContext;
  private int mInitPageIndex = 0;
  protected HippyViewPager mViewPager;
  protected List<View> mViews = new ArrayList();
  
  public HippyViewPagerAdapter(HippyInstanceContext paramHippyInstanceContext, HippyViewPager paramHippyViewPager)
  {
    this.mEngineContext = paramHippyInstanceContext;
    this.mViewPager = paramHippyViewPager;
  }
  
  protected void addView(HippyViewPagerItem paramHippyViewPagerItem, int paramInt)
  {
    if ((paramHippyViewPagerItem != null) && (paramInt >= 0))
    {
      if (paramInt >= this.mViews.size()) {
        this.mViews.add(paramHippyViewPagerItem);
      }
    }
    else {
      return;
    }
    this.mViews.add(paramInt, paramHippyViewPagerItem);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof View))
    {
      paramObject = (View)paramObject;
      if (paramObject != null)
      {
        paramObject.layout(0, 0, 0, 0);
        paramViewGroup.removeView(paramObject);
      }
    }
  }
  
  public int getCount()
  {
    return this.mChildSize;
  }
  
  public int getInitialItemIndex()
  {
    return this.mInitPageIndex;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if ((this.mViews == null) || (this.mViews.isEmpty())) {}
    int i;
    do
    {
      return -2;
      i = this.mViews.indexOf(paramObject);
    } while (i < 0);
    return i;
  }
  
  protected int getItemViewSize()
  {
    if (this.mViews == null) {
      return 0;
    }
    return this.mViews.size();
  }
  
  protected View getViewAt(int paramInt)
  {
    if ((this.mViews == null) || (paramInt < 0) || (paramInt >= this.mViews.size())) {
      return null;
    }
    return (View)this.mViews.get(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.mViews != null) && (paramInt < this.mViews.size())) {}
    for (View localView = (View)this.mViews.get(paramInt);; localView = null)
    {
      if ((localView != null) && (localView.getParent() == null))
      {
        paramViewGroup.addView(localView, new ViewPager.LayoutParams());
        this.mViewPager.triggerRequestLayout();
        return localView;
      }
      return null;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  protected void removeView(View paramView)
  {
    int j = this.mViews.size();
    int i = 0;
    if (i < j) {
      if (getViewAt(i) != paramView) {}
    }
    for (;;)
    {
      if (i >= 0) {
        this.mViews.remove(i);
      }
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  protected void removeViewAtIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mViews.size())) {
      this.mViews.remove(paramInt);
    }
  }
  
  public void setChildSize(int paramInt)
  {
    this.mChildSize = paramInt;
  }
  
  public void setInitPageIndex(int paramInt)
  {
    this.mInitPageIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.HippyViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */