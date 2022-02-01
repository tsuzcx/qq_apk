package com.tencent.viola.ui.view.list;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.viola.utils.ViolaLogUtils;

@SuppressLint({"ClickableViewAccessibility"})
public class PagerSnapHelper
{
  public static final int GRAVITY_CENTER = 0;
  public static final int GRAVITY_TOP = 1;
  private static final String TAG = "PagerSnapHelper";
  private int centerPosition;
  private PagerSnapHelper.PagerEventListener eventListener;
  private boolean footerReboundEnable = false;
  private int gravity;
  private OrientationHelper horizontalHelper;
  private boolean isHorizontalReverseLayout;
  private boolean isQuickPageChanged;
  private boolean isSnapping;
  private LinearLayoutManager layoutManager;
  private PagerSnapHelper.OnLayoutChangedListenerImpl onLayoutChangedListener;
  private PagerSnapHelper.OnLayoutSizeChangedListener onLayoutSizeChangedListener;
  private int placeHeaderCount;
  private int reboundFooterCount;
  private RecyclerViewCompat recyclerView;
  private int snapOffset;
  private boolean snapOnFling;
  private boolean snapOnIdle;
  private float snapSpeedFactor;
  private PagerSnapHelper.TouchEventProcessor touchEventProcessor;
  private OrientationHelper verticalHelper;
  
  public PagerSnapHelper(int paramInt)
  {
    this(paramInt, 45.0F);
  }
  
  public PagerSnapHelper(int paramInt, float paramFloat)
  {
    init();
    this.gravity = paramInt;
    this.snapSpeedFactor = paramFloat;
  }
  
  private int adjustPosition(int paramInt)
  {
    int i = getStartPosition();
    int j = getEndPosition(this.layoutManager);
    if (paramInt < i) {}
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= j);
    return j;
  }
  
  @NonNull
  private int[] calculateDistanceToFinalSnap(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = distanceToBaseLine(paramLinearLayoutManager, paramView, getOrientationHelper(paramLinearLayoutManager));
    }
    while (paramLinearLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToBaseLine(paramLinearLayoutManager, paramView, getOrientationHelper(paramLinearLayoutManager));
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
  
  private int computeMinScollDistance()
  {
    return ViewConfiguration.get(this.recyclerView.getContext()).getScaledTouchSlop();
  }
  
  private void destroyCallbacks()
  {
    this.recyclerView.removeOnScrollListener(this.touchEventProcessor);
    this.recyclerView.setOnFlingListener(null);
  }
  
  private void dispatchFooterRebound()
  {
    if (this.eventListener != null)
    {
      this.eventListener.onFooterRebound();
      ViolaLogUtils.d("PagerSnapHelper", "onScrollStateChanged: onFooterRebound");
    }
  }
  
  private void dispatchPagerChanged(View paramView, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder;
    int i;
    if ((paramView != null) && (this.recyclerView != null) && (this.layoutManager != null))
    {
      localViewHolder = this.recyclerView.getChildViewHolder(paramView);
      i = this.layoutManager.getPosition(paramView);
      ViolaLogUtils.d("PagerSnapHelper", "dispatchPagerChanged: position=" + i + ", centerPosition=" + this.centerPosition + ", reset=" + paramBoolean);
      if ((localViewHolder != null) && (i != -1) && ((i != this.centerPosition) || (paramBoolean)))
      {
        if (!checkIsPositionOutOfBound(i, this.layoutManager)) {
          break label126;
        }
        ViolaLogUtils.e("PagerSnapHelper", "dispatchPagerChanged , position out of bound");
      }
    }
    label126:
    do
    {
      return;
      this.centerPosition = i;
    } while (this.eventListener == null);
    TraceCompat.beginSection("onPagerChanged");
    this.eventListener.onPagerChanged(localViewHolder);
    TraceCompat.endSection();
  }
  
  private void dispatchRebound(int paramInt1, int paramInt2)
  {
    if (this.eventListener != null) {
      this.eventListener.onPagerRebound(paramInt1, paramInt2);
    }
  }
  
  private int distanceToBaseLine(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    switch (this.gravity)
    {
    default: 
      return distanceToCenter(paramLinearLayoutManager, paramView, paramOrientationHelper);
    }
    return distanceToTop(paramLinearLayoutManager, paramView, paramOrientationHelper);
  }
  
  private int distanceToCenter(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - getCenterLine(paramLinearLayoutManager, paramOrientationHelper);
  }
  
  private int distanceToTop(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    int j = paramOrientationHelper.getDecoratedStart(paramView);
    int i = getTopLine(paramOrientationHelper);
    if (paramLinearLayoutManager.getPosition(paramView) == 0) {
      i = 0;
    }
    return getFinalTopDistance(j, i, paramView);
  }
  
  private View findStartView(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int m = paramLayoutManager.getChildCount();
    if (m == 0) {}
    int j;
    int i;
    do
    {
      return localObject2;
      j = 0;
      i = 0;
      localObject2 = localObject1;
    } while (j >= m);
    localObject2 = paramLayoutManager.getChildAt(j);
    int k = paramOrientationHelper.getDecoratedStart((View)localObject2);
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
  
  private int getCenterLine(LinearLayoutManager paramLinearLayoutManager, OrientationHelper paramOrientationHelper)
  {
    if (paramLinearLayoutManager.getClipToPadding()) {}
    for (int i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;; i = paramOrientationHelper.getEnd() / 2) {
      return i + this.snapOffset;
    }
  }
  
  private int getEndPosition(RecyclerView.LayoutManager paramLayoutManager)
  {
    return paramLayoutManager.getItemCount() - this.reboundFooterCount - 1;
  }
  
  private int getFinalTopDistance(int paramInt1, int paramInt2, View paramView)
  {
    if (!this.isHorizontalReverseLayout) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 - (this.layoutManager.getWidth() - paramView.getWidth()) + paramInt2;
  }
  
  private int getStartPosition()
  {
    return this.placeHeaderCount;
  }
  
  private int getTopLine(OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getStartAfterPadding() + this.snapOffset;
  }
  
  private void init()
  {
    this.reboundFooterCount = 0;
    this.placeHeaderCount = 0;
    this.centerPosition = -1;
    this.isSnapping = false;
    this.isQuickPageChanged = false;
    this.snapOnIdle = true;
    this.snapOnFling = true;
  }
  
  private boolean needDispatchFooterRebound(int paramInt1, LinearLayoutManager paramLinearLayoutManager, int paramInt2, int paramInt3)
  {
    if (paramInt1 == getEndPosition(paramLinearLayoutManager))
    {
      paramInt1 = 1;
      if (this.isHorizontalReverseLayout) {
        break label40;
      }
      if ((paramInt1 == 0) || ((paramInt2 >= 0) && (paramInt3 >= 0))) {
        break label38;
      }
    }
    label38:
    label40:
    while ((paramInt1 != 0) && ((paramInt2 > 0) || (paramInt3 > 0)))
    {
      return true;
      paramInt1 = 0;
      break;
      return false;
    }
    return false;
  }
  
  private boolean needSnapWhenHorizontalReverse(View paramView)
  {
    if (!this.isHorizontalReverseLayout) {}
    int i;
    do
    {
      return true;
      i = this.layoutManager.getPosition(paramView);
    } while ((getOrientationHelper(this.layoutManager).getDecoratedEnd(paramView) != this.layoutManager.getWidth()) || (i != 0));
    return false;
  }
  
  private void setupCallbacks()
  {
    if (this.recyclerView.getOnCompatFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.touchEventProcessor = new PagerSnapHelper.TouchEventProcessor(this, null);
    this.onLayoutChangedListener = new PagerSnapHelper.OnLayoutChangedListenerImpl(this, null);
    this.onLayoutSizeChangedListener = new PagerSnapHelper.OnLayoutSizeChangedListener(this, null);
    this.recyclerView.setOnTouchListener(this.touchEventProcessor);
    this.recyclerView.addOnScrollListener(this.touchEventProcessor);
    this.recyclerView.setOnCompatFlingListener(this.touchEventProcessor);
    this.recyclerView.addOnLayoutChangeListener(this.onLayoutChangedListener);
    this.recyclerView.addOnLayoutChangeListener(this.onLayoutSizeChangedListener);
    this.recyclerView.getAdapter().registerAdapterDataObserver(new PagerSnapHelper.1(this));
  }
  
  private boolean snapFromFling(@NonNull LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (!this.isHorizontalReverseLayout) {
      return snapFromNormal(paramLinearLayoutManager, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt);
    }
    return snapFromFlingWhenHorizontalReverse(paramLinearLayoutManager, paramFloat3, paramFloat4);
  }
  
  private boolean snapFromFlingWhenHorizontalReverse(LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2)
  {
    int m = 1;
    int j = paramLinearLayoutManager.getItemCount();
    if (j == 0) {}
    View localView;
    label38:
    int i;
    do
    {
      return false;
      localView = null;
      if (!paramLinearLayoutManager.canScrollVertically()) {
        break;
      }
      localView = findStartView(paramLinearLayoutManager, getOrientationHelper(paramLinearLayoutManager));
      if (localView == null) {
        break label167;
      }
      i = paramLinearLayoutManager.getPosition(localView);
    } while (i == -1);
    int k = adjustPosition(i);
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      if (paramFloat1 > 0.0F)
      {
        i = 1;
        label81:
        paramLinearLayoutManager = paramLinearLayoutManager.computeScrollVectorForPosition(j - 1);
        if (paramLinearLayoutManager == null) {
          break label229;
        }
        j = m;
        if (paramLinearLayoutManager.x >= 0.0F)
        {
          if (paramLinearLayoutManager.y >= 0.0F) {
            break label193;
          }
          j = m;
        }
      }
    }
    for (;;)
    {
      label120:
      if (j != 0) {
        if (i != 0) {
          i = k;
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label227;
        }
        return snapToTargetPosition(i);
        if (!paramLinearLayoutManager.canScrollHorizontally()) {
          break label38;
        }
        localView = findStartView(paramLinearLayoutManager, getOrientationHelper(paramLinearLayoutManager));
        break label38;
        label167:
        break;
        i = 0;
        break label81;
        if (paramFloat2 > 0.0F)
        {
          i = 1;
          break label81;
        }
        i = 0;
        break label81;
        label193:
        j = 0;
        break label120;
        i = k + 1;
        continue;
        if (i != 0) {
          i = k + 1;
        } else {
          i = k;
        }
      }
      label227:
      break;
      label229:
      j = 0;
    }
  }
  
  private boolean snapFromNormal(@NonNull LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    int i = 1;
    if (paramLinearLayoutManager.getItemCount() == 0) {}
    label165:
    label186:
    for (;;)
    {
      return false;
      View localView = findCenterView(paramLinearLayoutManager);
      if (localView != null)
      {
        int j = paramLinearLayoutManager.getPosition(localView);
        if (j != -1)
        {
          j = adjustPosition(j);
          int k = computeMinScollDistance();
          if (paramLinearLayoutManager.canScrollHorizontally()) {
            if (Math.abs(paramFloat1) > k) {
              if (paramFloat1 > 0.0F)
              {
                if ((paramInt == -1) || (j == paramInt)) {
                  break label165;
                }
                paramInt = j;
              }
            }
          }
          for (;;)
          {
            if (paramInt == -1) {
              break label186;
            }
            return snapToTargetPosition(adjustPosition(paramInt));
            i = 0;
            break;
            if (paramFloat3 > 0.0F) {
              break;
            }
            i = 0;
            break;
            if (Math.abs(paramFloat2) > k)
            {
              if (paramFloat2 > 0.0F) {
                break;
              }
              i = 0;
              break;
            }
            if (paramFloat4 > 0.0F) {
              break;
            }
            i = 0;
            break;
            if (i != 0) {
              paramInt = j + 1;
            } else {
              paramInt = j - 1;
            }
          }
        }
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
    int k = Math.abs(distanceToBaseLine(paramLinearLayoutManager, (View)localObject2, localOrientationHelper));
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
  
  public int getSnapOffset()
  {
    return this.snapOffset;
  }
  
  public boolean isSnapping()
  {
    return this.isSnapping;
  }
  
  public void offsetToTargetPosition(int paramInt)
  {
    if ((this.recyclerView == null) || (this.layoutManager == null)) {
      return;
    }
    offsetToTargetPosition(this.layoutManager.findViewByPosition(paramInt));
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
  
  public void setEventListener(PagerSnapHelper.PagerEventListener paramPagerEventListener)
  {
    this.eventListener = paramPagerEventListener;
  }
  
  public void setHorizontalReverseLayout(boolean paramBoolean)
  {
    this.isHorizontalReverseLayout = paramBoolean;
  }
  
  public void setQuickPageChanged(boolean paramBoolean)
  {
    this.isQuickPageChanged = paramBoolean;
  }
  
  public void setReboundFooterCount(int paramInt)
  {
    this.reboundFooterCount = paramInt;
  }
  
  public void setSnapOffset(int paramInt)
  {
    this.snapOffset = paramInt;
  }
  
  public void setSnapOnFling(boolean paramBoolean)
  {
    this.snapOnFling = paramBoolean;
  }
  
  public void setSnapOnIdle(boolean paramBoolean)
  {
    this.snapOnIdle = paramBoolean;
  }
  
  public void setSnapSpeedFactor(int paramInt)
  {
    this.snapSpeedFactor = paramInt;
  }
  
  public void setStickLastPosition(boolean paramBoolean)
  {
    this.footerReboundEnable = paramBoolean;
  }
  
  public boolean snapToCenterPosition()
  {
    if ((this.recyclerView == null) || (this.layoutManager == null)) {}
    View localView;
    do
    {
      do
      {
        return false;
        localView = findCenterView(this.layoutManager);
      } while (localView == null);
      ViolaLogUtils.d("PagerSnapHelper", "snapToCenterPosition: findCenterView=" + this.layoutManager.getPosition(localView));
    } while (!needSnapWhenHorizontalReverse(localView));
    return snapToTargetView(localView);
  }
  
  public boolean snapToTargetPosition(int paramInt)
  {
    if (checkIsPositionOutOfBound(paramInt, this.layoutManager)) {}
    View localView;
    Object localObject;
    int j;
    int k;
    do
    {
      return false;
      localView = this.layoutManager.findViewByPosition(paramInt);
      ViolaLogUtils.d("PagerSnapHelper", "snapToTargetPosition: position=" + paramInt + ", view=" + localView);
      if (localView == null)
      {
        this.recyclerView.smoothScrollToPosition(paramInt);
        this.isSnapping = true;
        return true;
      }
      localObject = calculateDistanceToFinalSnap(this.layoutManager, localView);
      j = localObject[0];
      k = localObject[1];
    } while (((j > 0) && (!this.recyclerView.canScrollHorizontally(1))) || ((j < 0) && (!this.recyclerView.canScrollHorizontally(-1))) || ((j == 0) && (k == 0)));
    int i;
    if ((paramInt == getEndPosition(this.layoutManager)) && ((j < 0) || (k < 0)))
    {
      i = 1;
      label165:
      if ((i != 0) && (!this.footerReboundEnable)) {
        break label254;
      }
      localObject = createSnapScroller(this.layoutManager);
      ((RecyclerView.SmoothScroller)localObject).setTargetPosition(paramInt);
      this.layoutManager.startSmoothScroll((RecyclerView.SmoothScroller)localObject);
      this.isSnapping = true;
      if (this.centerPosition == paramInt) {
        break label256;
      }
      i = 1;
      label216:
      if (this.isQuickPageChanged) {
        dispatchPagerChanged(localView, false);
      }
      if (!needDispatchFooterRebound(paramInt, this.layoutManager, j, k)) {
        break label261;
      }
      dispatchFooterRebound();
    }
    for (;;)
    {
      return true;
      i = 0;
      break label165;
      label254:
      break;
      label256:
      i = 0;
      break label216;
      label261:
      if (i == 0) {
        dispatchRebound(j, k);
      }
    }
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
    return snapToTargetPosition(adjustPosition(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */