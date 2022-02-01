package com.tencent.mobileqq.kandian.biz.hippy.tuwen.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.ReflectWrapper;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.list.HippyListView.OnScrollEvent;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollListener;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Recycler;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.State;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger;
import com.tencent.mtt.supportui.views.recyclerview.Scroller;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class NSHippyListView
  extends HippyTKDListView
  implements NestedScrollingChild3
{
  private static final String TAG = "NSHippyListView";
  private NSHippyListView.AdjustHeightObserver adjustHeightObserver;
  private boolean firstAddView = true;
  HippyRootLayout hippyRootLayout;
  private int mMaxFlingVelocity;
  private int mMinFlingVelocity;
  private final int[] mNestedOffsets = new int[2];
  private final int[] mReusableIntPair = new int[2];
  private final int[] mReusableIntPair2 = new int[2];
  private final int[] mScrollOffset = new int[2];
  private NestedScrollingChildHelper mScrollingChildHelper;
  private boolean needAdjustHeight;
  private ReflectWrapper reflectWrapper;
  private final int[] tmpResult = new int[2];
  
  public NSHippyListView(Context paramContext)
  {
    super(paramContext);
    init();
    QLog.d("NSHippyListView", 1, "NSHippyListView new instance");
  }
  
  private int adjustVelocity(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean)
    {
      i = paramInt;
      if (Math.abs(paramInt) >= this.mMinFlingVelocity) {}
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  private int calTouchAxes(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramBoolean) && (Math.abs(paramInt1) > this.mTouchSlop))
    {
      int i = this.mTouchSlop;
      if (paramInt1 < 0) {
        paramInt1 = -1;
      } else {
        paramInt1 = 1;
      }
      return paramInt2 + i * paramInt1;
    }
    return 2147483647;
  }
  
  private boolean callSuperOnTouchEvent(int paramInt)
  {
    return (paramInt != 2) && (paramInt != 1) && (paramInt != 3);
  }
  
  private int computeDistanceWhenSpringBackOnLeftOrTop(int paramInt1, int paramInt2)
  {
    int j = getSpringBackMaxDistance();
    int i = paramInt1;
    if (paramInt2 + paramInt1 <= -j) {
      i = -paramInt2 - j;
    }
    return i;
  }
  
  private int computeDistanceWhenSpringBackOnRightOrBottom(int paramInt1, int paramInt2, Scroller paramScroller, int paramInt3)
  {
    if (this.mState.mTotalHeight <= paramInt3) {
      paramInt3 = 0;
    } else {
      paramInt3 = this.mState.mTotalHeight - paramInt3;
    }
    int j = getSpringBackMaxDistance();
    int i = paramInt1;
    if (paramInt2 + paramInt1 >= paramInt3 + j)
    {
      i = -paramInt2 + paramInt3 + j;
      finishScroller(paramScroller);
    }
    return i;
  }
  
  private int computeDistanceWithoutOverScrollWhenReachRightOrBottom(int paramInt1, int paramInt2, Scroller paramScroller, int paramInt3)
  {
    if (this.mState.mTotalHeight <= paramInt3) {
      paramInt1 = 0;
    } else {
      paramInt1 = this.mState.mTotalHeight - paramInt3 - paramInt2;
    }
    finishScroller(paramScroller);
    return paramInt1;
  }
  
  private int computeDx(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.mOffsetX + paramInt < 0) {
      return computeDxWhenReachLeftEdge(paramInt, paramBoolean1, paramScroller, paramBoolean2, paramBoolean3);
    }
    int i = paramInt;
    if (this.mOffsetX + paramInt > this.mState.mTotalHeight - getWidth()) {
      i = computeDxWhenReachRightEdge(paramInt, paramBoolean1, paramScroller, paramBoolean2);
    }
    return i;
  }
  
  private int[] computeDxDy(int paramInt1, int paramInt2, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2)
  {
    int[] arrayOfInt = this.tmpResult;
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    boolean bool = changeUpOverScrollEnableOnComputeDxDy(paramInt1, paramInt2, paramBoolean1, paramScroller, paramBoolean2, this.mUpOverScrollEnabled);
    int i = paramInt1;
    if (paramInt1 != 0) {
      i = computeDx(paramInt1, paramBoolean1, paramScroller, paramBoolean2, bool);
    }
    paramInt1 = paramInt2;
    if (paramInt2 != 0) {
      paramInt1 = computeDy(paramInt2, paramBoolean1, paramScroller, paramBoolean2, bool);
    }
    arrayOfInt[0] = i;
    arrayOfInt[1] = paramInt1;
    return arrayOfInt;
  }
  
  private int computeDxWhenReachLeftEdge(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3)
    {
      int i = paramInt;
      if (this.mOffsetX < 0) {
        i = computeLeftOrTopWhenOverScroll(paramInt, paramBoolean2);
      }
      paramInt = i;
      if (paramBoolean1) {
        return computeDistanceWhenSpringBackOnLeftOrTop(i, this.mOffsetX);
      }
    }
    else
    {
      paramInt = -this.mOffsetX;
      finishScroller(paramScroller);
    }
    return paramInt;
  }
  
  private int computeDxWhenReachRightEdge(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2)
  {
    if (this.mDownOverScrollEnabled)
    {
      int i = paramInt;
      if (this.mOffsetX > this.mState.mTotalHeight - getWidth()) {
        i = computeRightOrBottomWhenOverScroll(paramInt, paramBoolean2);
      }
      paramInt = i;
      if (paramBoolean1) {
        return computeDistanceWhenSpringBackOnRightOrBottom(i, this.mOffsetX, paramScroller, getWidth());
      }
    }
    else
    {
      paramInt = computeDistanceWithoutOverScrollWhenReachRightOrBottom(paramInt, this.mOffsetX, paramScroller, getWidth());
    }
    return paramInt;
  }
  
  private int computeDy(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.mOffsetY + paramInt <= 0) {
      return computeDyWhenReadTopEdge(paramInt, paramBoolean1, paramScroller, paramBoolean2, paramBoolean3);
    }
    if (this.mOffsetY + paramInt > this.mState.mTotalHeight - getHeight()) {
      return computeDyWhenReachBottomEdge(paramInt, paramBoolean1, paramScroller, paramBoolean2);
    }
    int i = paramInt;
    if (needStopAtTitle()) {
      i = computeDyWhenNeedStopAtTitle(paramInt);
    }
    return i;
  }
  
  private int computeDyWhenNeedStopAtTitle(int paramInt)
  {
    Integer localInteger2 = (Integer)this.reflectWrapper.invokeMethodWithPrimaryType(this, "getStopPosition", new Object[0]);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    int i = paramInt;
    if (this.mOffsetY + paramInt < localInteger1.intValue()) {
      i = localInteger1.intValue() - this.mOffsetY;
    }
    return i;
  }
  
  private int computeDyWhenReachBottomEdge(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2)
  {
    if (this.mDownOverScrollEnabled)
    {
      int i = paramInt;
      if (this.mOffsetY > this.mState.mTotalHeight - getHeight()) {
        i = computeRightOrBottomWhenOverScroll(paramInt, paramBoolean2);
      }
      paramInt = i;
      if (paramBoolean1) {
        return computeDistanceWhenSpringBackOnRightOrBottom(i, this.mOffsetY, paramScroller, getHeight());
      }
    }
    else
    {
      paramInt = computeDistanceWithoutOverScrollWhenReachRightOrBottom(paramInt, this.mOffsetY, paramScroller, getHeight());
    }
    return paramInt;
  }
  
  private int computeDyWhenReadTopEdge(int paramInt, boolean paramBoolean1, Scroller paramScroller, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean3)
    {
      i = paramInt;
      if (this.mOffsetY < 0) {
        i = computeLeftOrTopWhenOverScroll(paramInt, paramBoolean2);
      }
      paramInt = i;
      if (paramBoolean1) {
        return computeDistanceWhenSpringBackOnLeftOrTop(i, this.mOffsetY);
      }
    }
    else
    {
      int j = this.mOffsetY;
      i = -this.mOffsetY;
      notifyReachTopEdgeEvent(paramScroller, paramInt + j);
      paramInt = i;
    }
    return paramInt;
  }
  
  private static int computeLeftOrTopWhenOverScroll(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      i = paramInt;
      if (paramBoolean) {
        i = paramInt / 3;
      }
    }
    return i;
  }
  
  private static int computeRightOrBottomWhenOverScroll(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt > 0)
    {
      i = paramInt;
      if (paramBoolean) {
        i = paramInt / 3;
      }
    }
    return i;
  }
  
  private void doScrollBy(int paramInt1, int paramInt2)
  {
    if (scrollBy(paramInt1, paramInt2, null)) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void finishScroller(Scroller paramScroller)
  {
    if (paramScroller != null) {
      paramScroller.forceFinished(true);
    }
  }
  
  private NestedScrollingChildHelper getScrollingChildHelper()
  {
    if (this.mScrollingChildHelper == null) {
      this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    }
    return this.mScrollingChildHelper;
  }
  
  private void init()
  {
    setOverScrollEnabled(false);
    this.reflectWrapper = new ReflectWrapper();
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mMinFlingVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    setNestedScrollingEnabled(true);
    setFieldValue("mViewFlinger", new NSHippyListView.MyViewFlinger(this));
    setNeedAdjustHeight(true);
  }
  
  private boolean needStopAtTitle()
  {
    return (Boolean.TRUE.equals(getFieldValue("mStopAtTitle"))) && (this.mNeedStopAtTitleIndex != -1);
  }
  
  private void notifyReachTopEdgeEvent(Scroller paramScroller, int paramInt)
  {
    if ((paramScroller != null) && (paramScroller.isFling()))
    {
      onFlingToTopEdge(paramScroller.getCurrVelocity(), paramInt);
      return;
    }
    if (Boolean.TRUE.equals(getFieldValue("mIsTouching"))) {
      onScrollToTopEdge();
    }
  }
  
  private void onTouchMove(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = this.mBlockScroll;
    boolean bool3 = false;
    if ((!bool1) && (this.mLayout.canScrollHorizontally())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (!this.mBlockScroll)
    {
      bool2 = bool3;
      if (this.mLayout.canScrollVertically()) {
        bool2 = true;
      }
    }
    setFieldValue("mTouchEventState", Integer.valueOf(2));
    setFieldValue("mIsTouching", Boolean.valueOf(true));
    int i = (int)(paramMotionEvent.getX(paramInt) + 0.5F);
    paramInt = (int)(paramMotionEvent.getY(paramInt) + 0.5F);
    if (this.mScrollState != 1) {
      processTouchMoveOnNotDragState(i, paramInt, bool1, bool2);
    }
    if (this.mScrollState == 1) {
      processTouchMoveOnDragState(i, paramInt, bool1, bool2);
    }
  }
  
  private void onTouchUpOrCancel(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    this.mVelocityTracker.addMovement(paramMotionEvent2);
    setFieldValue("mTouchEventState", Integer.valueOf(1));
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
    performFling();
    tryNotifyTouchEvent(paramMotionEvent1);
    handleCustomClickEvent(paramMotionEvent1);
    this.mVelocityTracker.clear();
    releaseGlows(true, true);
    stopNestedScroll(0);
  }
  
  private void performFling()
  {
    boolean bool = this.mLayout.canScrollHorizontally();
    float f2 = 0.0F;
    float f1;
    if (bool) {
      f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
    } else {
      f1 = 0.0F;
    }
    if (this.mLayout.canScrollVertically()) {
      f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
    }
    double d1 = f1;
    double d2 = f2;
    int i = 1;
    if ((!(TKDTuWenCommentUtil.isAllZero(new double[] { d1, d2 }) ^ true)) || (!fling((int)f1, (int)f2))) {
      i = 0;
    }
    if (i == 0)
    {
      reflectResetStopAtTitle();
      reflectSetScrollState(0);
      handleOnTouchUpEventWhenStartFling(f1, f2);
    }
  }
  
  private void processTouchMoveOnDragState(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = this.mLastTouchX - paramInt1;
    int k = this.mLastTouchY - paramInt2;
    int[] arrayOfInt1 = this.mReusableIntPair;
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    int n;
    if (paramBoolean1) {
      n = m;
    } else {
      n = 0;
    }
    int i1;
    if (paramBoolean2) {
      i1 = k;
    } else {
      i1 = 0;
    }
    int j = m;
    int i = k;
    if (dispatchNestedPreScroll(n, i1, this.mReusableIntPair, this.mScrollOffset, 0))
    {
      arrayOfInt1 = this.mReusableIntPair;
      j = m - arrayOfInt1[0];
      i = k - arrayOfInt1[1];
      arrayOfInt1 = this.mNestedOffsets;
      k = arrayOfInt1[0];
      int[] arrayOfInt2 = this.mScrollOffset;
      arrayOfInt1[0] = (k + arrayOfInt2[0]);
      arrayOfInt1[1] += arrayOfInt2[1];
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    arrayOfInt1 = this.mScrollOffset;
    this.mLastTouchX = (paramInt1 - arrayOfInt1[0]);
    this.mLastTouchY = (paramInt2 - arrayOfInt1[1]);
    if (!paramBoolean1) {
      j = 0;
    }
    if (!paramBoolean2) {
      i = 0;
    }
    doScrollBy(j, i);
    tryNotifyFooter();
    onTouchMove(paramInt1, paramInt2);
  }
  
  private void processTouchMoveOnNotDragState(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.mInitialTouchX;
    int i = this.mInitialTouchY;
    paramInt1 = calTouchAxes(paramBoolean1, paramInt1 - j, this.mInitialTouchX);
    if (paramInt1 != 2147483647)
    {
      this.mLastTouchX = paramInt1;
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = 0;
    }
    paramInt2 = calTouchAxes(paramBoolean2, paramInt2 - i, this.mInitialTouchY);
    if (paramInt2 != 2147483647)
    {
      this.mLastTouchY = paramInt2;
      paramInt1 = 1;
    }
    if (paramInt1 != 0)
    {
      Object localObject = getFieldValue("mDisallowParentInterceptTouchEventWhenDrag");
      if (Boolean.TRUE.equals(localObject)) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      reflectSetScrollState(1);
    }
  }
  
  private boolean reflectEnableTouchListener()
  {
    Boolean localBoolean = (Boolean)getFieldValue("mEnableRecyclerViewTouchListener");
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  private boolean registerAdjustHeightObserver()
  {
    if (this.adjustHeightObserver != null) {
      return false;
    }
    RecyclerViewBase.Adapter localAdapter = getAdapter();
    if (localAdapter != null)
    {
      this.adjustHeightObserver = new NSHippyListView.AdjustHeightObserver(this, null);
      localAdapter.registerAdapterDataObserver(this.adjustHeightObserver);
      return true;
    }
    return false;
  }
  
  private void resetNestedOffsets(int paramInt)
  {
    if (paramInt == 0)
    {
      int[] arrayOfInt = this.mNestedOffsets;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
    }
  }
  
  private boolean scrollByInternal2(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    stopScroll();
    int[] arrayOfInt1 = this.mReusableIntPair;
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    int[] arrayOfInt2 = this.mReusableIntPair2;
    arrayOfInt2[0] = paramInt1;
    arrayOfInt2[1] = paramInt2;
    scrollStep(paramInt1, paramInt2, false, arrayOfInt1, arrayOfInt2);
    arrayOfInt1 = this.mReusableIntPair;
    int i = arrayOfInt1[0];
    int j = arrayOfInt1[1];
    arrayOfInt1 = this.mReusableIntPair2;
    int k = arrayOfInt1[0];
    int m = arrayOfInt1[1];
    reflectInvalidateDecorations();
    arrayOfInt1 = this.mReusableIntPair;
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    dispatchNestedScroll(i, j, k, m, this.mScrollOffset, 0, arrayOfInt1);
    arrayOfInt1 = this.mReusableIntPair;
    k -= arrayOfInt1[0];
    m -= arrayOfInt1[1];
    boolean bool = TKDTuWenCommentUtil.isAllZero(new double[] { i, j, arrayOfInt1[0], arrayOfInt1[1] });
    this.mLastTouchX -= this.mScrollOffset[0];
    int n = this.mLastTouchY;
    arrayOfInt1 = this.mScrollOffset;
    this.mLastTouchY = (n - arrayOfInt1[1]);
    arrayOfInt2 = this.mNestedOffsets;
    arrayOfInt2[0] += arrayOfInt1[0];
    arrayOfInt2[1] += arrayOfInt1[1];
    invalidateRefreshHeader();
    reflectPullGlows(k, m);
    reflectNotifyScrollListener(paramInt1, paramInt2);
    if (checkShouldInvalidateInScroll()) {
      invalidate();
    }
    reflectPullGlows(k, m);
    awakenScrollBars();
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = j;
    }
    return bool ^ true;
  }
  
  private void scrollStep(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (this.mAdapter == null) {
      return;
    }
    eatRequestLayout();
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      int[] arrayOfInt = computeDxDy(paramInt1, paramInt2, paramBoolean, null, true);
      paramInt1 = arrayOfInt[0];
      paramInt2 = arrayOfInt[1];
      paramArrayOfInt1[0] = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
      paramArrayOfInt1[1] = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
      paramArrayOfInt2[0] -= paramArrayOfInt1[0];
      paramArrayOfInt2[1] -= paramArrayOfInt1[1];
    }
    resumeRequestLayout(false);
  }
  
  private void setupStartNestedScroll(int paramInt)
  {
    int i;
    if (this.mLayout.canScrollHorizontally()) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (this.mLayout.canScrollVertically()) {
      j = i | 0x2;
    }
    startNestedScroll(j, paramInt);
  }
  
  private void tryNotifyFooter()
  {
    if ((this.needNotifyFooter) && (!this.checkNotifyFooterOnRelease) && ((!shouldPrebindItem()) || (this.mOffsetY + getHeight() >= getTotalHeight())))
    {
      this.needNotifyFooter = false;
      if (this.mRecycler != null) {
        this.mRecycler.notifyLastFooterAppeared();
      }
    }
  }
  
  private void tryNotifyTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((reflectEnableTouchListener()) && (Math.abs(paramMotionEvent.getX() - this.mInitialTouchX) < this.mTouchSlop) && (Math.abs(paramMotionEvent.getY() - this.mInitialTouchY) < this.mTouchSlop) && (paramMotionEvent.getActionMasked() == 1)) {
      notifyRecyclerViewTouchEvent(paramMotionEvent);
    }
  }
  
  private void unregisterAdjustHeightObserver()
  {
    if (this.adjustHeightObserver == null) {
      return;
    }
    RecyclerViewBase.Adapter localAdapter = getAdapter();
    if (localAdapter != null) {
      localAdapter.unregisterAdapterDataObserver(this.adjustHeightObserver);
    }
    this.adjustHeightObserver = null;
  }
  
  public void cancelTouch()
  {
    super.cancelTouch();
    stopNestedScroll(0);
  }
  
  protected HippyListAdapter createAdapter(RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    return new NSHippyListView.MyAdapter(this, paramRecyclerView, paramHippyEngineContext);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public final void dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, @NonNull int[] paramArrayOfInt2)
  {
    getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  HippyRootLayout ensureHippyRootLayout()
  {
    if (this.hippyRootLayout == null) {
      for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
        if ((localViewParent instanceof HippyRootLayout))
        {
          this.hippyRootLayout = ((HippyRootLayout)localViewParent);
          break;
        }
      }
    }
    return this.hippyRootLayout;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.mLayout.canScrollHorizontally();
    boolean bool4 = this.mLayout.canScrollVertically();
    int i = adjustVelocity(bool2, paramInt1);
    paramInt1 = adjustVelocity(bool4, paramInt2);
    double d = i;
    boolean bool3 = false;
    if (TKDTuWenCommentUtil.isAllZero(new double[] { d, paramInt1 })) {
      return false;
    }
    float f1 = i;
    float f2 = paramInt1;
    boolean bool1 = bool3;
    if (!dispatchNestedPreFling(f1, f2))
    {
      if ((!bool2) && (!bool4)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      dispatchNestedFling(f1, f2, bool2);
      bool1 = bool3;
      if (bool2)
      {
        setupStartNestedScroll(1);
        paramInt2 = this.mMaxFlingVelocity;
        paramInt2 = Math.max(-paramInt2, Math.min(i, paramInt2));
        i = this.mMaxFlingVelocity;
        paramInt1 = Math.max(-i, Math.min(paramInt1, i));
        this.mViewFlinger.fling(paramInt2, paramInt1);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @Nullable
  <T> T getFieldValue(String paramString)
  {
    return this.reflectWrapper.getFieldValue(this, paramString);
  }
  
  public int getTopInOutterList()
  {
    ensureHippyRootLayout();
    HippyRootLayout localHippyRootLayout = this.hippyRootLayout;
    if (localHippyRootLayout == null) {
      return -1;
    }
    return localHippyRootLayout.getTop();
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  public boolean hasNestedScrollingParent(int paramInt)
  {
    return getScrollingChildHelper().hasNestedScrollingParent(paramInt);
  }
  
  public boolean isFling()
  {
    Scroller localScroller = this.mViewFlinger.getScroller();
    return (localScroller != null) && (localScroller.isFling()) && (!localScroller.isFinished());
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.needAdjustHeight)
    {
      NSHippyListView.AdjustHeightObserver localAdjustHeightObserver = this.adjustHeightObserver;
      if (localAdjustHeightObserver != null) {
        NSHippyListView.AdjustHeightObserver.access$000(localAdjustHeightObserver);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.hippyRootLayout = null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = this.mScrollState;
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (i != 0)
    {
      if (i != 1) {
        return bool;
      }
      stopNestedScroll(0);
      return bool;
    }
    if (j == 2) {
      stopNestedScroll(1);
    }
    paramMotionEvent = this.mNestedOffsets;
    paramMotionEvent[1] = 0;
    paramMotionEvent[0] = 0;
    setupStartNestedScroll(0);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionMasked();
    resetNestedOffsets(j);
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int[] arrayOfInt = this.mNestedOffsets;
    float f = arrayOfInt[0];
    int i = 1;
    localMotionEvent.offsetLocation(f, arrayOfInt[1]);
    boolean bool;
    if (callSuperOnTouchEvent(j)) {
      bool = super.onTouchEvent(paramMotionEvent);
    } else {
      bool = false;
    }
    j = paramMotionEvent.getActionMasked();
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            break label143;
          }
        }
        else
        {
          j = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
          if (j >= 0)
          {
            onTouchMove(paramMotionEvent, j);
            break label143;
          }
          bool = false;
          break label145;
        }
      }
      onTouchUpOrCancel(paramMotionEvent, localMotionEvent);
      break label145;
    }
    else
    {
      setupStartNestedScroll(0);
    }
    label143:
    i = 0;
    label145:
    if (i == 0) {
      this.mVelocityTracker.addMovement(localMotionEvent);
    }
    localMotionEvent.recycle();
    return bool;
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    if (!this.firstAddView) {
      return;
    }
    this.firstAddView = false;
    ThreadManager.getUIHandler().postDelayed(new NSHippyListView.1(this), 100L);
  }
  
  void reflectInvalidateDecorations()
  {
    List localList = (List)getFieldValue("mItemDecorations");
    if ((localList != null) && (!localList.isEmpty())) {
      invalidate();
    }
  }
  
  void reflectNotifyScrollListener(int paramInt1, int paramInt2)
  {
    RecyclerViewBase.OnScrollListener localOnScrollListener = (RecyclerViewBase.OnScrollListener)getFieldValue("mScrollListener");
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrolled(paramInt1, paramInt2);
    }
  }
  
  void reflectPullGlows(int paramInt1, int paramInt2)
  {
    this.reflectWrapper.invokeMethodWithPrimaryType(this, "pullGlows", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  void reflectResetStopAtTitle()
  {
    this.reflectWrapper.invokeMethodWithPrimaryType(this, "resetStopAtTitle", new Object[0]);
  }
  
  void reflectSetScrollState(int paramInt)
  {
    this.reflectWrapper.invokeMethodWithPrimaryType(this, "setScrollState", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.mLayout != null)
    {
      boolean bool1 = this.mLayout.canScrollHorizontally();
      boolean bool2 = this.mLayout.canScrollVertically();
      if ((bool1) || (bool2))
      {
        if (!bool1) {
          paramInt1 = 0;
        }
        if (!bool2) {
          paramInt2 = 0;
        }
        scrollBy(paramInt1, paramInt2, null);
      }
      return;
    }
    throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
  }
  
  public boolean scrollBy(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (checkShouldConsumePendingUpdates()) {
      consumePendingUpdateOperations();
    }
    if (checkShouldStopScroll()) {
      return false;
    }
    return scrollByInternal2(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  protected void sendOnScrollEvent()
  {
    if (this.mScrollEventEnable)
    {
      long l = System.currentTimeMillis();
      if (l - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle) {
        return;
      }
      this.mLastScrollEventTimeStamp = l;
      getOnScrollEvent().send(this, generateScrollEvent());
    }
  }
  
  public void setAdapter(RecyclerViewBase.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
    unregisterAdjustHeightObserver();
    if (this.needAdjustHeight) {
      registerAdjustHeightObserver();
    }
  }
  
  void setFieldValue(String paramString, Object paramObject)
  {
    this.reflectWrapper.setFieldValue(this, paramString, paramObject);
  }
  
  public void setNeedAdjustHeight(boolean paramBoolean)
  {
    this.needAdjustHeight = paramBoolean;
    if (paramBoolean)
    {
      if (registerAdjustHeightObserver()) {
        NSHippyListView.AdjustHeightObserver.access$000(this.adjustHeightObserver);
      }
    }
    else {
      unregisterAdjustHeightObserver();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    smoothScrollBy(paramInt1, paramInt2, paramBoolean1, paramBoolean2, false);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.mLayout.canScrollHorizontally()) {
      paramInt1 = 0;
    }
    if (!this.mLayout.canScrollVertically()) {
      paramInt2 = 0;
    }
    if (TKDTuWenCommentUtil.isAllZero(new double[] { paramInt1, paramInt2 })) {
      return;
    }
    if (paramBoolean3) {
      setupStartNestedScroll(1);
    }
    super.smoothScrollBy(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt1, paramInt2);
  }
  
  public void stopFling()
  {
    this.mViewFlinger.getScroller().abortAnimation();
    stopNestedScroll(1);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public void stopNestedScroll(int paramInt)
  {
    getScrollingChildHelper().stopNestedScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSHippyListView
 * JD-Core Version:    0.7.0.1
 */