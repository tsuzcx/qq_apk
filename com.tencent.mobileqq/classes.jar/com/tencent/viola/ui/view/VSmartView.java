package com.tencent.viola.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.viola.ui.component.VPageSlider;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.ui.view.list.VRecyclerView.VerticalOverScrollEventListener;
import java.util.ArrayList;
import java.util.List;

public class VSmartView
  extends VFrameLayout
  implements View.OnTouchListener, VRecyclerView.VerticalOverScrollEventListener
{
  private int currentItemIndex;
  private int lastOverDistanceY;
  private float offset = 0.0F;
  private List<VSmartView.RecyclerViewWrapper> recyclerViews = new ArrayList();
  private VSmartView.RvScrollListener scrollListener = new VSmartView.RvScrollListener(this, null);
  private VSmartHeaderView smartHeaderView;
  private VPageSliderView.VPagerSliderScrollListener vPagerSliderScrollListener = new VSmartView.2(this);
  private VPageSliderView viewPager;
  
  public VSmartView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private float getTranslationYLimit()
  {
    if (this.smartHeaderView == null) {
      return 0.0F;
    }
    return this.smartHeaderView.getHeight() - this.offset;
  }
  
  private void resetOtherList()
  {
    if ((this.currentItemIndex < 0) || (this.currentItemIndex >= this.recyclerViews.size())) {}
    while (Math.abs(this.smartHeaderView.getTranslationY()) >= getTranslationYLimit()) {
      return;
    }
    VSmartView.RecyclerViewWrapper localRecyclerViewWrapper1 = (VSmartView.RecyclerViewWrapper)this.recyclerViews.get(this.currentItemIndex);
    int i = 0;
    label61:
    VSmartView.RecyclerViewWrapper localRecyclerViewWrapper2;
    if (i < this.recyclerViews.size())
    {
      localRecyclerViewWrapper2 = (VSmartView.RecyclerViewWrapper)this.recyclerViews.get(i);
      if (localRecyclerViewWrapper2.recyclerView != localRecyclerViewWrapper1.recyclerView) {
        break label108;
      }
    }
    for (;;)
    {
      i += 1;
      break label61;
      break;
      label108:
      VRecyclerList localVRecyclerList = localRecyclerViewWrapper2.recyclerView.getComponent();
      if (localVRecyclerList != null)
      {
        int j = localRecyclerViewWrapper1.recyclerView.getContentOffsetY();
        if (j != localRecyclerViewWrapper2.lastContentOffset)
        {
          localRecyclerViewWrapper2.lastContentOffset = j;
          localVRecyclerList.scrollByDistance(j);
        }
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void addRecyclerView(VRecyclerView paramVRecyclerView, boolean paramBoolean)
  {
    addRecyclerView(paramVRecyclerView, paramBoolean, -1);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void addRecyclerView(VRecyclerView paramVRecyclerView, boolean paramBoolean, int paramInt)
  {
    if (paramVRecyclerView == null) {
      return;
    }
    VSmartView.RecyclerViewWrapper localRecyclerViewWrapper = new VSmartView.RecyclerViewWrapper(null);
    localRecyclerViewWrapper.recyclerView = paramVRecyclerView;
    localRecyclerViewWrapper.ignoreScrollEvent = paramBoolean;
    paramVRecyclerView.setVerticalOverScrollEventListener(this);
    paramVRecyclerView.setOnTouchListener(this);
    paramVRecyclerView.setOnScrollListener(this.scrollListener);
    paramVRecyclerView.setTag(localRecyclerViewWrapper);
    if ((paramInt < 0) || (paramInt > this.recyclerViews.size()))
    {
      this.recyclerViews.add(localRecyclerViewWrapper);
      return;
    }
    this.recyclerViews.add(paramInt, localRecyclerViewWrapper);
  }
  
  public void destroy()
  {
    if (this.viewPager != null) {
      this.viewPager.removeScrollListener(this.vPagerSliderScrollListener);
    }
    this.recyclerViews.clear();
  }
  
  public ViewPager getViewPager()
  {
    return this.viewPager;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof VSmartView.RecyclerViewWrapper)) {
      ((VSmartView.RecyclerViewWrapper)paramView).ignoreScrollEvent = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onVerticalScroll(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = this.lastOverDistanceY;
    float f1 = this.smartHeaderView.getTranslationY();
    float f2 = paramInt - i;
    this.smartHeaderView.setTranslationY(f2 * 1.0F + f1);
    this.lastOverDistanceY = paramInt;
  }
  
  public void setOffset(float paramFloat)
  {
    this.offset = paramFloat;
  }
  
  public void setSmartHeaderView(VSmartHeaderView paramVSmartHeaderView)
  {
    this.smartHeaderView = paramVSmartHeaderView;
  }
  
  public void setViewPager(VPageSliderView paramVPageSliderView)
  {
    if (paramVPageSliderView == null) {}
    do
    {
      return;
      this.viewPager = paramVPageSliderView;
      paramVPageSliderView.setOverScrollMode(2);
      paramVPageSliderView.addScrollListener(this.vPagerSliderScrollListener);
    } while (paramVPageSliderView.getComponent() == null);
    paramVPageSliderView.getComponent().setOnJSSetIndexListener(new VSmartView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSmartView
 * JD-Core Version:    0.7.0.1
 */