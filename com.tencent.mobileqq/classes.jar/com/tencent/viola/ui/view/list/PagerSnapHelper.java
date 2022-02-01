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
  private int minFlingVelocity = -1;
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
    if (paramInt < i) {
      return i;
    }
    i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    return i;
  }
  
  @NonNull
  private int[] calculateDistanceToFinalSnap(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = distanceToBaseLine(paramLinearLayoutManager, paramView, getOrientationHelper(paramLinearLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramLinearLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToBaseLine(paramLinearLayoutManager, paramView, getOrientationHelper(paramLinearLayoutManager));
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
    PagerSnapHelper.PagerEventListener localPagerEventListener = this.eventListener;
    if (localPagerEventListener != null)
    {
      localPagerEventListener.onFooterRebound();
      ViolaLogUtils.d("PagerSnapHelper", "onScrollStateChanged: onFooterRebound");
    }
  }
  
  private void dispatchHeaderRebound()
  {
    ViolaLogUtils.d("PagerSnapHelper", "onScrollStateChanged: onHeaderRebound");
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
        paramView = new StringBuilder();
        paramView.append("dispatchPagerChanged: position=");
        paramView.append(i);
        paramView.append(", centerPosition=");
        paramView.append(this.centerPosition);
        paramView.append(", reset=");
        paramView.append(paramBoolean);
        ViolaLogUtils.d("PagerSnapHelper", paramView.toString());
        if ((localObject != null) && (i != -1) && ((i != this.centerPosition) || (paramBoolean)))
        {
          if (checkIsPositionOutOfBound(i, this.layoutManager))
          {
            ViolaLogUtils.e("PagerSnapHelper", "dispatchPagerChanged , position out of bound");
            return;
          }
          this.centerPosition = i;
          if (this.eventListener != null)
          {
            TraceCompat.beginSection("onPagerChanged");
            this.eventListener.onPagerChanged((RecyclerView.ViewHolder)localObject);
            TraceCompat.endSection();
          }
        }
      }
    }
  }
  
  private void dispatchRebound(int paramInt1, int paramInt2)
  {
    PagerSnapHelper.PagerEventListener localPagerEventListener = this.eventListener;
    if (localPagerEventListener != null) {
      localPagerEventListener.onPagerRebound(paramInt1, paramInt2);
    }
  }
  
  private int distanceToBaseLine(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    if (this.gravity != 1) {
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
    int n = paramLayoutManager.getChildCount();
    Object localObject = null;
    if (n == 0) {
      return null;
    }
    int i = 0;
    int k;
    for (int j = 0; i < n; j = k)
    {
      View localView = paramLayoutManager.getChildAt(i);
      int m = paramOrientationHelper.getDecoratedStart(localView);
      k = j;
      if (m > j)
      {
        localObject = localView;
        k = m;
      }
      i += 1;
    }
    return localObject;
  }
  
  private int getCenterLine(LinearLayoutManager paramLinearLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i;
    if (paramLinearLayoutManager.getClipToPadding()) {
      i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
    } else {
      i = paramOrientationHelper.getEnd() / 2;
    }
    return i + this.snapOffset;
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
    int i = getEndPosition(paramLinearLayoutManager);
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt1 == i) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (!this.isHorizontalReverseLayout)
    {
      if (paramInt1 != 0)
      {
        if (paramInt2 < 0) {
          break label51;
        }
        if (paramInt3 < 0) {
          return true;
        }
      }
      bool1 = false;
      label51:
      return bool1;
    }
    if (paramInt1 != 0)
    {
      bool1 = bool2;
      if (paramInt2 > 0) {
        break label76;
      }
      if (paramInt3 > 0) {
        return true;
      }
    }
    bool1 = false;
    label76:
    return bool1;
  }
  
  private boolean needDispatchHeaderRebound(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getStartPosition();
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt1 == i) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (!this.isHorizontalReverseLayout)
    {
      if (paramInt1 != 0)
      {
        if (paramInt2 > 0) {
          break label49;
        }
        if (paramInt3 > 0) {
          return true;
        }
      }
      bool1 = false;
      label49:
      return bool1;
    }
    if (paramInt1 != 0)
    {
      bool1 = bool2;
      if (paramInt2 < 0) {
        break label73;
      }
      if (paramInt3 < 0) {
        return true;
      }
    }
    bool1 = false;
    label73:
    return bool1;
  }
  
  private boolean needSnapWhenHorizontalReverse(View paramView)
  {
    if (!this.isHorizontalReverseLayout) {
      return true;
    }
    int i = this.layoutManager.getPosition(paramView);
    return (getOrientationHelper(this.layoutManager).getDecoratedEnd(paramView) != this.layoutManager.getWidth()) || (i != 0);
  }
  
  private void setupCallbacks()
  {
    if (this.recyclerView.getOnCompatFlingListener() == null)
    {
      this.touchEventProcessor = new PagerSnapHelper.TouchEventProcessor(this, null);
      this.onLayoutChangedListener = new PagerSnapHelper.OnLayoutChangedListenerImpl(this, null);
      this.onLayoutSizeChangedListener = new PagerSnapHelper.OnLayoutSizeChangedListener(this, null);
      this.recyclerView.setOnTouchListener(this.touchEventProcessor);
      this.recyclerView.addOnScrollListener(this.touchEventProcessor);
      this.recyclerView.setOnCompatFlingListener(this.touchEventProcessor);
      this.recyclerView.addOnLayoutChangeListener(this.onLayoutChangedListener);
      this.recyclerView.addOnLayoutChangeListener(this.onLayoutSizeChangedListener);
      this.recyclerView.getAdapter().registerAdapterDataObserver(new PagerSnapHelper.1(this));
      return;
    }
    throw new IllegalStateException("An instance of OnFlingListener already set.");
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
    int j = paramLinearLayoutManager.getItemCount();
    if (j == 0) {
      return false;
    }
    View localView = null;
    if (paramLinearLayoutManager.canScrollVertically()) {
      localView = findStartView(paramLinearLayoutManager, getOrientationHelper(paramLinearLayoutManager));
    } else if (paramLinearLayoutManager.canScrollHorizontally()) {
      localView = findStartView(paramLinearLayoutManager, getOrientationHelper(paramLinearLayoutManager));
    }
    if (localView == null) {
      return false;
    }
    int i = paramLinearLayoutManager.getPosition(localView);
    if (i == -1) {
      return false;
    }
    int k = adjustPosition(i);
    boolean bool = paramLinearLayoutManager.canScrollHorizontally();
    int m = 1;
    if (bool) {
      if (paramFloat1 <= 0.0F) {}
    }
    for (;;)
    {
      i = 1;
      break;
      do
      {
        i = 0;
        break;
      } while (paramFloat2 <= 0.0F);
    }
    paramLinearLayoutManager = paramLinearLayoutManager.computeScrollVectorForPosition(j - 1);
    if (paramLinearLayoutManager != null)
    {
      j = m;
      if (paramLinearLayoutManager.x < 0.0F) {
        break label174;
      }
      if (paramLinearLayoutManager.y < 0.0F)
      {
        j = m;
        break label174;
      }
    }
    j = 0;
    label174:
    if (j != 0)
    {
      if (i != 0)
      {
        j = k;
        break label206;
      }
    }
    else
    {
      j = k;
      if (i == 0) {
        break label206;
      }
    }
    j = k + 1;
    label206:
    if (j == -1) {
      return false;
    }
    return snapToTargetPosition(j);
  }
  
  private boolean snapFromNormal(@NonNull LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (paramLinearLayoutManager.getItemCount() == 0) {
      return false;
    }
    View localView = findCenterView(paramLinearLayoutManager);
    if (localView == null) {
      return false;
    }
    int i = paramLinearLayoutManager.getPosition(localView);
    if (i == -1) {
      return false;
    }
    int j = adjustPosition(i);
    int k = computeMinScollDistance();
    boolean bool = paramLinearLayoutManager.canScrollHorizontally();
    i = 1;
    if (bool)
    {
      if (Math.abs(paramFloat1) > k ? paramFloat1 > 0.0F : paramFloat3 > 0.0F) {}
    }
    else {
      while (Math.abs(paramFloat2) > k ? paramFloat2 <= 0.0F : paramFloat4 <= 0.0F)
      {
        i = 0;
        break;
      }
    }
    if ((paramInt != -1) && (j != paramInt)) {
      paramInt = j;
    } else if (i != 0) {
      paramInt = j + 1;
    } else {
      paramInt = j - 1;
    }
    if (paramInt == -1) {
      return false;
    }
    return snapToTargetPosition(adjustPosition(paramInt));
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
      int m = Math.abs(distanceToBaseLine(paramLinearLayoutManager, localView, localOrientationHelper));
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
    if (this.recyclerView != null)
    {
      LinearLayoutManager localLinearLayoutManager = this.layoutManager;
      if (localLinearLayoutManager == null) {
        return;
      }
      offsetToTargetPosition(localLinearLayoutManager.findViewByPosition(paramInt));
    }
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
    RecyclerViewCompat localRecyclerViewCompat = this.recyclerView;
    if (localRecyclerViewCompat != null)
    {
      localRecyclerViewCompat.addOnLayoutChangeListener(this.onLayoutChangedListener);
      this.recyclerView.requestLayout();
    }
  }
  
  public void setEventListener(PagerSnapHelper.PagerEventListener paramPagerEventListener)
  {
    this.eventListener = paramPagerEventListener;
  }
  
  public void setHorizontalReverseLayout(boolean paramBoolean)
  {
    this.isHorizontalReverseLayout = paramBoolean;
  }
  
  public void setMinFlingVelocity(int paramInt)
  {
    this.minFlingVelocity = paramInt;
  }
  
  public void setPlaceHeaderCount(int paramInt)
  {
    int i = this.placeHeaderCount;
    this.placeHeaderCount = paramInt;
    if (i != paramInt) {
      requestLayoutChanged();
    }
  }
  
  public void setQuickPageChanged(boolean paramBoolean)
  {
    this.isQuickPageChanged = paramBoolean;
  }
  
  public void setReboundFooterCount(int paramInt)
  {
    int i = this.reboundFooterCount;
    this.reboundFooterCount = paramInt;
    if (i != paramInt) {
      requestLayoutChanged();
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("snapToCenterPosition: findCenterView=");
      localStringBuilder.append(this.layoutManager.getPosition((View)localObject));
      ViolaLogUtils.d("PagerSnapHelper", localStringBuilder.toString());
      if (!needSnapWhenHorizontalReverse((View)localObject)) {
        return false;
      }
      return snapToTargetView((View)localObject);
    }
    return false;
  }
  
  public boolean snapToTargetPosition(int paramInt)
  {
    if (checkIsPositionOutOfBound(paramInt, this.layoutManager)) {
      return false;
    }
    View localView = this.layoutManager.findViewByPosition(paramInt);
    this.isSnapping = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("snapToTargetPosition: position=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", view=");
    ((StringBuilder)localObject).append(localView);
    ViolaLogUtils.d("PagerSnapHelper", ((StringBuilder)localObject).toString());
    if (localView == null)
    {
      this.recyclerView.smoothScrollToPosition(paramInt);
      this.isSnapping = true;
      return true;
    }
    localObject = calculateDistanceToFinalSnap(this.layoutManager, localView);
    int j = localObject[0];
    int k = localObject[1];
    if (((j > 0) && (!this.recyclerView.canScrollHorizontally(1))) || ((j < 0) && (!this.recyclerView.canScrollHorizontally(-1)))) {
      return false;
    }
    if ((j == 0) && (k == 0)) {
      return false;
    }
    int i;
    if ((paramInt == getEndPosition(this.layoutManager)) && ((j < 0) || (k < 0))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!this.footerReboundEnable)) {
      return false;
    }
    localObject = createSnapScroller(this.layoutManager);
    ((RecyclerView.SmoothScroller)localObject).setTargetPosition(paramInt);
    this.layoutManager.startSmoothScroll((RecyclerView.SmoothScroller)localObject);
    this.isSnapping = true;
    if (this.centerPosition != paramInt) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.isQuickPageChanged) {
      dispatchPagerChanged(localView, false);
    }
    if (needDispatchFooterRebound(paramInt, this.layoutManager, j, k))
    {
      dispatchFooterRebound();
      return true;
    }
    if (needDispatchHeaderRebound(paramInt, j, k)) {
      dispatchHeaderRebound();
    }
    if (i == 0) {
      dispatchRebound(j, k);
    }
    return true;
  }
  
  public boolean snapToTargetView(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    int i = this.layoutManager.getPosition(paramView);
    if (i == -1) {
      return false;
    }
    return snapToTargetPosition(adjustPosition(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */