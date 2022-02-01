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
    }
    while (paramLinearLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToCenter(paramLinearLayoutManager, paramView, getOrientationHelper(paramLinearLayoutManager));
      return arrayOfInt;
      arrayOfInt[0] = 0;
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
    if ((paramRecyclerView == null) || (paramRecyclerView.getAdapter() == null) || (paramRecyclerView.getLayoutManager() == null)) {
      throw new IllegalStateException("PagerSnapHelper can't attach to the RecyclerView before setup Adapter or LayoutManager");
    }
    if (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
      throw new IllegalStateException("PagerSnapHelper can only attach to the RecyclerView with LinearLayoutManager");
    }
  }
  
  private void destroyCallbacks()
  {
    this.recyclerView.removeOnScrollListener(this.touchEventProcessor);
    this.recyclerView.setOnFlingListener(null);
  }
  
  private void dispatchPagerChanged(View paramView, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder;
    int i;
    if ((paramView != null) && (this.recyclerView != null) && (this.layoutManager != null))
    {
      localViewHolder = this.recyclerView.getChildViewHolder(paramView);
      i = this.layoutManager.getPosition(paramView);
      if ((localViewHolder != null) && (i != -1) && ((i != this.centerPosition) || (paramBoolean)) && (!checkIsPositionOutOfBound(i, this.layoutManager))) {
        break label72;
      }
    }
    label72:
    do
    {
      return;
      this.centerPosition = i;
    } while (this.eventListener == null);
    this.eventListener.onPagerChanged(localViewHolder);
  }
  
  private int distanceToCenter(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    int j = paramOrientationHelper.getDecoratedStart(paramView);
    int k = paramOrientationHelper.getDecoratedMeasurement(paramView) / 2;
    if (paramLinearLayoutManager.getClipToPadding()) {}
    for (int i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;; i = paramOrientationHelper.getEnd() / 2) {
      return k + j - i;
    }
  }
  
  @Nullable
  private View findFirstVisibleView(LinearLayoutManager paramLinearLayoutManager)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int m = paramLinearLayoutManager.getChildCount();
    if (m == 0) {}
    OrientationHelper localOrientationHelper;
    int i;
    int j;
    do
    {
      return localObject2;
      localOrientationHelper = getOrientationHelper(paramLinearLayoutManager);
      i = 2147483647;
      j = 0;
      localObject2 = localObject1;
    } while (j >= m);
    localObject2 = paramLinearLayoutManager.getChildAt(j);
    int k = localOrientationHelper.getDecoratedStart((View)localObject2);
    if (k < i)
    {
      localObject1 = localObject2;
      i = k;
    }
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  private View findLastVisibleView(LinearLayoutManager paramLinearLayoutManager)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int m = paramLinearLayoutManager.getChildCount();
    if (m == 0) {}
    OrientationHelper localOrientationHelper;
    int i;
    int j;
    do
    {
      return localObject2;
      localOrientationHelper = getOrientationHelper(paramLinearLayoutManager);
      i = -2147483648;
      j = 0;
      localObject2 = localObject1;
    } while (j >= m);
    localObject2 = paramLinearLayoutManager.getChildAt(j);
    int k = localOrientationHelper.getDecoratedStart((View)localObject2);
    if (k > i)
    {
      localObject1 = localObject2;
      i = k;
    }
    for (;;)
    {
      j += 1;
      break;
    }
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
    if (this.recyclerView.getOnFlingListenerCompat() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.touchEventProcessor = new PagerSnapHelper.TouchEventProcessor(this, null);
    this.onLayoutChangedListener = new PagerSnapHelper.OnLayoutChangedListenerImpl(this, null);
    this.recyclerView.addOnScrollListener(this.touchEventProcessor);
    this.recyclerView.setOnFlingListenerCompat(this.touchEventProcessor);
    this.recyclerView.addOnLayoutChangeListener(this.onLayoutChangedListener);
    this.recyclerView.getAdapter().registerAdapterDataObserver(new PagerSnapHelper.1(this));
  }
  
  private boolean snapFromFling(@NonNull LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2, int paramInt)
  {
    int i = 1;
    if (paramLinearLayoutManager.getItemCount() == 0) {}
    int m;
    do
    {
      View localView;
      do
      {
        return false;
        localView = findCenterView(paramLinearLayoutManager);
      } while (localView == null);
      m = paramLinearLayoutManager.getPosition(localView);
    } while (m == -1);
    label51:
    int j;
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      if (paramFloat1 > 0.0F)
      {
        int k = getStartPosition();
        j = getEndPosition(paramLinearLayoutManager);
        if ((paramInt == -1) || (m == paramInt)) {
          break label123;
        }
        paramInt = m;
        label81:
        if (paramInt == -1) {
          break label144;
        }
        if (paramInt >= k) {
          break label146;
        }
        i = k;
      }
    }
    for (;;)
    {
      return snapToTargetPosition(i);
      i = 0;
      break label51;
      if (paramFloat2 > 0.0F) {
        break label51;
      }
      i = 0;
      break label51;
      label123:
      if (i != 0)
      {
        paramInt = m + 1;
        break label81;
      }
      paramInt = m - 1;
      break label81;
      label144:
      break;
      label146:
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
  }
  
  public void attachToRecyclerView(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
  {
    if (this.recyclerView == paramRecyclerViewCompat) {}
    do
    {
      return;
      if (this.recyclerView != null) {
        destroyCallbacks();
      }
      this.recyclerView = paramRecyclerViewCompat;
    } while (this.recyclerView == null);
    checkRecyclerViewState(this.recyclerView);
    this.layoutManager = ((LinearLayoutManager)this.recyclerView.getLayoutManager());
    setupCallbacks();
    snapToCenterPosition();
  }
  
  protected LinearSmoothScroller createSnapScroller(LinearLayoutManager paramLinearLayoutManager)
  {
    return new PagerSnapHelper.2(this, this.recyclerView.getContext(), paramLinearLayoutManager);
  }
  
  @Nullable
  public View findCenterView(LinearLayoutManager paramLinearLayoutManager)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int n = paramLinearLayoutManager.getChildCount();
    if (n == 0) {}
    OrientationHelper localOrientationHelper;
    int j;
    int i;
    int k;
    label54:
    do
    {
      return localObject2;
      localOrientationHelper = getOrientationHelper(paramLinearLayoutManager);
      if (!paramLinearLayoutManager.getClipToPadding()) {
        break;
      }
      j = localOrientationHelper.getStartAfterPadding() + localOrientationHelper.getTotalSpace() / 2;
      i = 2147483647;
      k = 0;
      localObject2 = localObject1;
    } while (k >= n);
    localObject2 = paramLinearLayoutManager.getChildAt(k);
    int m = Math.abs(localOrientationHelper.getDecoratedStart((View)localObject2) + localOrientationHelper.getDecoratedMeasurement((View)localObject2) / 2 - j);
    if (m < i)
    {
      localObject1 = localObject2;
      i = m;
    }
    for (;;)
    {
      k += 1;
      break label54;
      j = localOrientationHelper.getEnd() / 2;
      break;
    }
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
    if ((this.recyclerView == null) || (this.layoutManager == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramView == null) || (checkIsPositionOutOfBound(this.layoutManager.getPosition(paramView), this.layoutManager)) || (paramView == null));
      paramView = calculateDistanceToFinalSnap(this.layoutManager, paramView);
    } while ((paramView[0] == 0) && (paramView[1] == 0));
    this.recyclerView.scrollBy(paramView[0], paramView[1]);
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
    if ((this.recyclerView == null) || (this.layoutManager == null)) {}
    View localView;
    do
    {
      return false;
      localView = findCenterView(this.layoutManager);
    } while (localView == null);
    return snapToTargetView(localView);
  }
  
  public boolean snapToNextPosition()
  {
    if ((this.recyclerView == null) || (this.layoutManager == null)) {}
    int i;
    do
    {
      return false;
      i = this.centerPosition + 1;
    } while (checkIsPositionOutOfBound(i, this.layoutManager));
    snapToTargetPosition(i);
    return true;
  }
  
  public boolean snapToPreviousPosition()
  {
    if ((this.recyclerView == null) || (this.layoutManager == null)) {}
    int i;
    do
    {
      return false;
      i = this.centerPosition - 1;
    } while (checkIsPositionOutOfBound(i, this.layoutManager));
    snapToTargetPosition(i);
    return true;
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
    if (paramView == null) {}
    int i;
    do
    {
      return false;
      i = this.layoutManager.getPosition(paramView);
    } while (i == -1);
    int j = getStartPosition();
    int k = getEndPosition(this.layoutManager);
    if (i < j) {
      i = j;
    }
    for (;;)
    {
      return snapToTargetPosition(i);
      if (i > k) {
        i = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.support.PagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */