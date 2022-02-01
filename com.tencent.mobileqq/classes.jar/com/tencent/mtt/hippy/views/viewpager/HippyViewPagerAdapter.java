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
  private int mInitPageIndex = 0;
  protected final HippyViewPager mViewPager;
  protected final List<View> mViews = new ArrayList();
  
  public HippyViewPagerAdapter(HippyInstanceContext paramHippyInstanceContext, HippyViewPager paramHippyViewPager)
  {
    this.mViewPager = paramHippyViewPager;
  }
  
  protected void addView(HippyViewPagerItem paramHippyViewPagerItem, int paramInt)
  {
    if ((paramHippyViewPagerItem != null) && (paramInt >= 0))
    {
      if (paramInt >= this.mViews.size())
      {
        this.mViews.add(paramHippyViewPagerItem);
        return;
      }
      this.mViews.add(paramInt, paramHippyViewPagerItem);
    }
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
    List localList = this.mViews;
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return -2;
      }
      int i = this.mViews.indexOf(paramObject);
      if (i < 0) {
        return -2;
      }
      return i;
    }
    return -2;
  }
  
  protected int getItemViewSize()
  {
    List localList = this.mViews;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  protected View getViewAt(int paramInt)
  {
    List localList = this.mViews;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (View)this.mViews.get(paramInt);
    }
    return null;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.mViews;
    if ((localObject != null) && (paramInt < ((List)localObject).size())) {
      localObject = (View)this.mViews.get(paramInt);
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((View)localObject).getParent() == null))
    {
      paramViewGroup.addView((View)localObject, new ViewPager.LayoutParams());
      this.mViewPager.triggerRequestLayout();
      return localObject;
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  protected void removeView(View paramView)
  {
    int j = this.mViews.size();
    int i = 0;
    while (i < j)
    {
      if (getViewAt(i) == paramView) {
        break label38;
      }
      i += 1;
    }
    i = -1;
    label38:
    if (i >= 0) {
      this.mViews.remove(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.HippyViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */