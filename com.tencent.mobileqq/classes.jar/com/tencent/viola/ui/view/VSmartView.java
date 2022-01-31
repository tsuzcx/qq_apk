package com.tencent.viola.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.ArrayList;
import java.util.List;

public class VSmartView
  extends VFrameLayout
  implements View.OnTouchListener
{
  private float offset = 0.0F;
  private List<VSmartView.RecyclerViewWrapper> recyclerViews = new ArrayList();
  private VSmartView.RvScrollListener scrollListener = new VSmartView.RvScrollListener(this, null);
  private VSmartHeaderView smartHeaderView;
  private VPageSliderView.VPagerSliderScrollListener vPagerSliderScrollListener = new VSmartView.1(this);
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
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void addRecyclerView(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    if (paramRecyclerView == null) {
      return;
    }
    VSmartView.RecyclerViewWrapper localRecyclerViewWrapper = new VSmartView.RecyclerViewWrapper(this, null);
    localRecyclerViewWrapper.recyclerView = paramRecyclerView;
    localRecyclerViewWrapper.ignoreScrollEvent = paramBoolean;
    paramRecyclerView.setOnTouchListener(this);
    paramRecyclerView.setOnScrollListener(this.scrollListener);
    paramRecyclerView.setTag(localRecyclerViewWrapper);
    this.recyclerViews.add(localRecyclerViewWrapper);
  }
  
  public void destroy()
  {
    if (this.viewPager != null) {
      this.viewPager.removeScrollListener(this.vPagerSliderScrollListener);
    }
    this.recyclerViews.clear();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof VSmartView.RecyclerViewWrapper)) {
      ((VSmartView.RecyclerViewWrapper)paramView).ignoreScrollEvent = false;
    }
    return super.onTouchEvent(paramMotionEvent);
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
    if (paramVPageSliderView == null) {
      return;
    }
    this.viewPager = paramVPageSliderView;
    paramVPageSliderView.setOverScrollMode(2);
    paramVPageSliderView.addScrollListener(this.vPagerSliderScrollListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSmartView
 * JD-Core Version:    0.7.0.1
 */