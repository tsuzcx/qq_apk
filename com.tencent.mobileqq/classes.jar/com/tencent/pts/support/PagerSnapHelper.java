package com.tencent.pts.support;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class PagerSnapHelper
{
  private static final int MAX_SCROLL_ON_FLING_DURATION = 300;
  private static final String TAG = "PagerSnapHelper";
  private int centerPosition = -1;
  private PagerSnapHelper.PagerEventListener eventListener;
  private OrientationHelper horizontalHelper;
  private boolean isQuickPageChanged = false;
  private boolean isSnapping = false;
  private View lastCenterView = null;
  private LinearLayoutManager layoutManager;
  private PagerSnapHelper.OnLayoutChangedListenerImpl onLayoutChangedListener;
  private int placeHeaderCount = 0;
  private int reboundFooterCount = 0;
  private RecyclerViewCompat recyclerView;
  private PagerSnapHelper.TouchEventProcessor touchEventProcessor;
  private OrientationHelper verticalHelper;
  
  @NonNull
  private int[] calculateDistanceToFinalSnap(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = distanceToCenter(paramLinearLayoutManager, paramView, getOrientationHelper(paramLinearLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramLinearLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToCenter(paramLinearLayoutManager, paramView, getOrientationHelper(paramLinearLayoutManager));
      return arrayOfInt;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  private boolean checkIsPositionOutOfBound(int paramInt, RecyclerView.LayoutManager paramLayoutManager)
  {
    int i = getEndPosition(paramLayoutManager);
    return (paramInt < getStartPosition()) || (paramInt > i);
  }
  
  private void checkRecyclerViewState(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView != null) && (paramRecyclerView.getAdapter() != null) && (paramRecyclerView.getLayoutManager() != null))
    {
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        return;
      }
      throw new IllegalStateException("PagerSnapHelper can only attach to the RecyclerView with LinearLayoutManager");
    }
    throw new IllegalStateException("PagerSnapHelper can't attach to the RecyclerView before setup Adapter or LayoutManager");
  }
  
  private void destroyCallbacks()
  {
    this.recyclerView.removeOnScrollListener(this.touchEventProcessor);
    this.recyclerView.setOnFlingListener(null);
  }
  
  private void dispatchPagerChanged(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      Object localObject = this.recyclerView;
      if ((localObject != null) && (this.layoutManager != null))
      {
        localObject = ((RecyclerViewCompat)localObject).getChildViewHolder(paramView);
        int i = this.layoutManager.getPosition(paramView);
        if ((localObject != null) && (i != -1) && ((i != this.centerPosition) || (paramBoolean)))
        {
          if (checkIsPositionOutOfBound(i, this.layoutManager)) {
            return;
          }
          this.centerPosition = i;
          paramView = this.eventListener;
          if (paramView != null) {
            paramView.onPagerChanged((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
  }
  
  private int distanceToCenter(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    int j = paramOrientationHelper.getDecoratedStart(paramView);
    int k = paramOrientationHelper.getDecoratedMeasurement(paramView) / 2;
    int i;
    if (paramLinearLayoutManager.getClipToPadding()) {
      i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
    } else {
      i = paramOrientationHelper.getEnd() / 2;
    }
    return j + k - i;
  }
  
  @Nullable
  private View findFirstVisibleView(LinearLayoutManager paramLinearLayoutManager)
  {
    int n = paramLinearLayoutManager.getChildCount();
    Object localObject = null;
    if (n == 0) {
      return null;
    }
    OrientationHelper localOrientationHelper = getOrientationHelper(paramLinearLayoutManager);
    int j = 2147483647;
    int i = 0;
    while (i < n)
    {
      View localView = paramLinearLayoutManager.getChildAt(i);
      int m = localOrientationHelper.getDecoratedStart(localView);
      int k = j;
      if (m < j)
      {
        localObject = localView;
        k = m;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  private View findLastVisibleView(LinearLayoutManager paramLinearLayoutManager)
  {
    int n = paramLinearLayoutManager.getChildCount();
    Object localObject = null;
    if (n == 0) {
      return null;
    }
    OrientationHelper localOrientationHelper = getOrientationHelper(paramLinearLayoutManager);
    int j = -2147483648;
    int i = 0;
    while (i < n)
    {
      View localView = paramLinearLayoutManager.getChildAt(i);
      int m = localOrientationHelper.getDecoratedStart(localView);
      int k = j;
      if (m > j)
      {
        localObject = localView;
        k = m;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  private int getEndPosition(RecyclerView.LayoutManager paramLayoutManager)
  {
    return paramLayoutManager.getItemCount() - this.reboundFooterCount - 1;
  }
  
  private int getStartPosition()
  {
    return this.placeHeaderCount;
  }
  
  private void setupCallbacks()
  {
    if (this.recyclerView.getOnFlingListenerCompat() == null)
    {
      this.touchEventProcessor = new PagerSnapHelper.TouchEventProcessor(this, null);
      this.onLayoutChangedListener = new PagerSnapHelper.OnLayoutChangedListenerImpl(this, null);
      this.recyclerView.addOnScrollListener(this.touchEventProcessor);
      this.recyclerView.setOnFlingListenerCompat(this.touchEventProcessor);
      this.recyclerView.addOnLayoutChangeListener(this.onLayoutChangedListener);
      this.recyclerView.getAdapter().registerAdapterDataObserver(new PagerSnapHelper.1(this));
      return;
    }
    throw new IllegalStateException("An instance of OnFlingListener already set.");
  }
  
  private boolean snapFromFling(@NonNull LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramLinearLayoutManager.getItemCount() == 0) {
      return false;
    }
    View localView = findCenterView(paramLinearLayoutManager);
    if (localView == null) {
      return false;
    }
    int m = paramLinearLayoutManager.getPosition(localView);
    if (m == -1) {
      return false;
    }
    boolean bool = paramLinearLayoutManager.canScrollHorizontally();
    int i = 1;
    if (bool)
    {
      if (paramFloat1 > 0.0F) {}
    }
    else {
      while (paramFloat2 <= 0.0F)
      {
        i = 0;
        break;
      }
    }
    int j = getStartPosition();
    int k = getEndPosition(paramLinearLayoutManager);
    if ((paramInt != -1) && (m != paramInt)) {
      paramInt = m;
    } else if (i != 0) {
      paramInt = m + 1;
    } else {
      paramInt = m - 1;
    }
    if (paramInt == -1) {
      return false;
    }
    if (paramInt < j) {
      paramInt = j;
    } else if (paramInt > k) {
      paramInt = k;
    }
    return snapToTargetPosition(paramInt);
  }
  
  public void attachToRecyclerView(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
  {
    RecyclerViewCompat localRecyclerViewCompat = this.recyclerView;
    if (localRecyclerViewCompat == paramRecyclerViewCompat) {
      return;
    }
    if (localRecyclerViewCompat != null) {
      destroyCallbacks();
    }
    this.recyclerView = paramRecyclerViewCompat;
    paramRecyclerViewCompat = this.recyclerView;
    if (paramRecyclerViewCompat != null)
    {
      checkRecyclerViewState(paramRecyclerViewCompat);
      this.layoutManager = ((LinearLayoutManager)this.recyclerView.getLayoutManager());
      setupCallbacks();
      snapToCenterPosition();
    }
  }
  
  protected LinearSmoothScroller createSnapScroller(LinearLayoutManager paramLinearLayoutManager)
  {
    return new PagerSnapHelper.2(this, this.recyclerView.getContext(), paramLinearLayoutManager);
  }
  
  @Nullable
  public View findCenterView(LinearLayoutManager paramLinearLayoutManager)
  {
    int i1 = paramLinearLayoutManager.getChildCount();
    Object localObject = null;
    if (i1 == 0) {
      return null;
    }
    OrientationHelper localOrientationHelper = getOrientationHelper(paramLinearLayoutManager);
    int i;
    if (paramLinearLayoutManager.getClipToPadding()) {
      i = localOrientationHelper.getStartAfterPadding() + localOrientationHelper.getTotalSpace() / 2;
    } else {
      i = localOrientationHelper.getEnd() / 2;
    }
    int k = 2147483647;
    int j = 0;
    while (j < i1)
    {
      View localView = paramLinearLayoutManager.getChildAt(j);
      int n = Math.abs(localOrientationHelper.getDecoratedStart(localView) + localOrientationHelper.getDecoratedMeasurement(localView) / 2 - i);
      int m = k;
      if (n < k)
      {
        localObject = localView;
        m = n;
      }
      j += 1;
      k = m;
    }
    return localObject;
  }
  
  public int getCurrentPosition()
  {
    return this.centerPosition;
  }
  
  @NonNull
  protected OrientationHelper getOrientationHelper(LinearLayoutManager paramLinearLayoutManager)
  {
    if (paramLinearLayoutManager.canScrollVertically())
    {
      if (this.verticalHelper == null) {
        this.verticalHelper = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 1);
      }
      return this.verticalHelper;
    }
    if (this.horizontalHelper == null) {
      this.horizontalHelper = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 0);
    }
    return this.horizontalHelper;
  }
  
  public boolean isSnapping()
  {
    return this.isSnapping;
  }
  
  public void offsetToTargetPosition(View paramView)
  {
    if (this.recyclerView != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.layoutManager;
      if (localLinearLayoutManager == null) {
        return;
      }
      if (paramView == null) {
        return;
      }
      if (checkIsPositionOutOfBound(localLinearLayoutManager.getPosition(paramView), this.layoutManager)) {
        return;
      }
      if (paramView != null)
      {
        paramView = calculateDistanceToFinalSnap(this.layoutManager, paramView);
        if ((paramView[0] != 0) || (paramView[1] != 0)) {
          this.recyclerView.scrollBy(paramView[0], paramView[1]);
        }
      }
    }
  }
  
  public void requestLayoutChanged()
  {
    this.recyclerView.addOnLayoutChangeListener(this.onLayoutChangedListener);
  }
  
  public void setEventListener(PagerSnapHelper.PagerEventListener paramPagerEventListener)
  {
    this.eventListener = paramPagerEventListener;
  }
  
  public void setPlaceHeaderCount(int paramInt)
  {
    this.placeHeaderCount = paramInt;
  }
  
  public void setQuickPageChanged(boolean paramBoolean)
  {
    this.isQuickPageChanged = paramBoolean;
  }
  
  public void setReboundFooterCount(int paramInt)
  {
    this.reboundFooterCount = paramInt;
  }
  
  public boolean snapToCenterPosition()
  {
    if (this.recyclerView != null)
    {
      Object localObject = this.layoutManager;
      if (localObject == null) {
        return false;
      }
      localObject = findCenterView((LinearLayoutManager)localObject);
      if (localObject == null) {
        return false;
      }
      return snapToTargetView((View)localObject);
    }
    return false;
  }
  
  public boolean snapToNextPosition()
  {
    if (this.recyclerView != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.layoutManager;
      if (localLinearLayoutManager == null) {
        return false;
      }
      int i = this.centerPosition + 1;
      if (checkIsPositionOutOfBound(i, localLinearLayoutManager)) {
        return false;
      }
      snapToTargetPosition(i);
      return true;
    }
    return false;
  }
  
  public boolean snapToPreviousPosition()
  {
    if (this.recyclerView != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.layoutManager;
      if (localLinearLayoutManager == null) {
        return false;
      }
      int i = this.centerPosition - 1;
      if (checkIsPositionOutOfBound(i, localLinearLayoutManager)) {
        return false;
      }
      snapToTargetPosition(i);
      return true;
    }
    return false;
  }
  
  public boolean snapToTargetPosition(int paramInt)
  {
    if (checkIsPositionOutOfBound(paramInt, this.layoutManager)) {
      return false;
    }
    View localView = this.layoutManager.findViewByPosition(paramInt);
    if (localView == null)
    {
      this.recyclerView.smoothScrollToPosition(paramInt);
      this.isSnapping = true;
      return true;
    }
    LinearSmoothScroller localLinearSmoothScroller = createSnapScroller(this.layoutManager);
    localLinearSmoothScroller.setTargetPosition(paramInt);
    this.layoutManager.startSmoothScroll(localLinearSmoothScroller);
    this.isSnapping = true;
    if (this.isQuickPageChanged) {
      dispatchPagerChanged(localView, false);
    }
    return true;
  }
  
  public boolean snapToTargetView(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    int j = this.layoutManager.getPosition(paramView);
    if (j == -1) {
      return false;
    }
    int i = getStartPosition();
    int k = getEndPosition(this.layoutManager);
    if (j >= i)
    {
      i = j;
      if (j > k) {
        i = k;
      }
    }
    return snapToTargetPosition(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.support.PagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */