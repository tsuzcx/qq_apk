package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.Log;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLayoutManager
  extends RecyclerViewBase.LayoutManager
{
  protected static final boolean DEBUG = false;
  public static final int HORIZONTAL = 0;
  private static final float MAX_SCROLL_FACTOR = 0.33F;
  private static final float SUSPEND_ITEM_ALPHA = 0.8F;
  private static final String TAG = "LinearLayoutManager";
  public static final int VERTICAL = 1;
  private boolean doNotCheckAgain = false;
  private int mCurrentSuspentionPos = -2147483648;
  private View mCurrentSuspentionView = null;
  protected boolean mEndReached = false;
  private boolean mLastStackFromEnd;
  private int mOrientation;
  public BaseLayoutManager.OrientationHelper mOrientationHelper;
  private int mPendingGravity = 0;
  private BaseLayoutManager.SavedState mPendingSavedState = null;
  private int mPendingScrollPositionItemHeight;
  public BaseLayoutManager.RenderState mRenderState;
  private boolean mReverseLayout = false;
  protected boolean mShouldReverseLayout = false;
  private boolean mStackFromEnd = false;
  protected int mSuspentedAreaSize = 0;
  long time = 0L;
  
  public BaseLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public BaseLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
  }
  
  private int convertFocusDirectionToLayoutDirection(int paramInt)
  {
    int j = -1;
    int k = 1;
    int m = -2147483648;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = -2147483648;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      do
      {
        do
        {
          return i;
          return 1;
          i = j;
        } while (this.mOrientation == 1);
        return -2147483648;
        paramInt = m;
        if (this.mOrientation == 1) {
          paramInt = 1;
        }
        return paramInt;
        i = j;
      } while (this.mOrientation == 0);
      return -2147483648;
    }
    if (this.mOrientation == 0) {}
    for (paramInt = k;; paramInt = -2147483648) {
      return paramInt;
    }
  }
  
  private void ensureSuspentionState()
  {
    if (!this.mRecyclerView.hasSuspentedItem()) {
      break label10;
    }
    for (;;)
    {
      label10:
      return;
      if (getChildCount() != 0)
      {
        View localView = getChildClosestToStartByOrder();
        int i = getPosition(localView);
        if (localView.getTop() > 0)
        {
          showCurrentSuspention(-2147483648);
          return;
        }
        int j = this.mRecyclerView.findPrevSuspentedPos(i);
        if (j != -1) {
          showCurrentSuspention(j);
        }
        if ((this.mCurrentSuspentionView == null) || (this.mCurrentSuspentionView.getParent() != this.mRecyclerView)) {
          break;
        }
        j = this.mCurrentSuspentionView.getMeasuredHeight();
        i = this.mRecyclerView.findNextSuspentedPos(i);
        localView = null;
        if (i != -1) {
          localView = findViewByPosition(i);
        }
        if (localView == null) {}
        for (i = 2147483647; i < j; i = localView.getTop())
        {
          this.mCurrentSuspentionView.offsetTopAndBottom(i - j);
          return;
        }
      }
    }
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState, boolean paramBoolean)
  {
    int j = 0;
    int i = j;
    if (!this.mRecyclerView.isRefreshing())
    {
      if (this.mRecyclerView.mState.mCustomHeaderHeight <= 0) {
        break label37;
      }
      i = j;
    }
    label37:
    do
    {
      do
      {
        int k;
        do
        {
          return i;
          k = this.mOrientationHelper.getEndAfterPadding() - paramInt;
          i = j;
        } while (k <= 0);
        paramState.overscroll = false;
        j = -scrollBy(-k, paramRecycler, paramState);
        i = j;
      } while (!paramBoolean);
      paramInt = this.mOrientationHelper.getEndAfterPadding() - (paramInt + j);
      i = j;
    } while (paramInt <= 0);
    this.mOrientationHelper.offsetChildren(paramInt);
    return j + paramInt;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState, boolean paramBoolean)
  {
    int i = 0;
    if (this.mRecyclerView.isRefreshing()) {}
    int j;
    do
    {
      do
      {
        do
        {
          return i;
          j = paramInt - this.mOrientationHelper.getStartAfterPadding();
        } while (j <= 0);
        paramState.overscroll = false;
        j = -scrollBy(j, paramRecycler, paramState);
        i = j;
      } while (!paramBoolean);
      paramInt = paramInt + j - this.mOrientationHelper.getStartAfterPadding();
      i = j;
    } while (paramInt <= 0);
    this.mOrientationHelper.offsetChildren(-paramInt);
    return j - paramInt;
  }
  
  private void logChildren()
  {
    Log.d("LinearLayoutManager", "internal representation of views on the screen");
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      Log.d("LinearLayoutManager", "item " + getPosition(localView) + ", coord:" + this.mOrientationHelper.getDecoratedStart(localView));
      i += 1;
    }
    Log.d("LinearLayoutManager", "==============");
  }
  
  private void recycleChildren(RecyclerViewBase.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          removeAndRecycleViewAt(paramInt2, paramRecycler);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i > paramInt2)
        {
          removeAndRecycleViewAt(i, paramRecycler);
          i -= 1;
        }
      }
    }
  }
  
  private void recycleViewsFromEnd(RecyclerViewBase.Recycler paramRecycler, int paramInt)
  {
    int j = getChildCount();
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    i = this.mOrientationHelper.getEndAfterPadding() - i;
    View localView;
    if (this.mShouldReverseLayout)
    {
      paramInt = 0;
      if (paramInt < j)
      {
        localView = getChildAt(paramInt);
        if (this.mOrientationHelper.getDecoratedStart(localView) >= i) {
          break label71;
        }
        recycleChildren(paramRecycler, 0, paramInt);
      }
    }
    for (;;)
    {
      return;
      label71:
      paramInt += 1;
      break;
      paramInt = j - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        if (this.mOrientationHelper.getDecoratedStart(localView) < i)
        {
          recycleChildren(paramRecycler, j - 1, paramInt);
          return;
        }
        paramInt -= 1;
      }
    }
  }
  
  private void recycleViewsFromStart(RecyclerViewBase.Recycler paramRecycler, int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    i = this.mOrientationHelper.getStartAfterPadding() + i;
    int j = getChildCount();
    View localView;
    if (this.mShouldReverseLayout)
    {
      paramInt = j - 1;
      if (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        if (this.mOrientationHelper.getDecoratedEnd(localView) <= i) {
          break label75;
        }
        recycleChildren(paramRecycler, j - 1, paramInt);
      }
    }
    for (;;)
    {
      return;
      label75:
      paramInt -= 1;
      break;
      paramInt = 0;
      while (paramInt < j)
      {
        localView = getChildAt(paramInt);
        if (this.mOrientationHelper.getDecoratedEnd(localView) > i)
        {
          recycleChildren(paramRecycler, 0, paramInt);
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  private void resolveShouldLayoutReverse()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!isLayoutRTL()))
    {
      this.mShouldReverseLayout = this.mReverseLayout;
      return;
    }
    if (!this.mReverseLayout) {}
    for (;;)
    {
      this.mShouldReverseLayout = bool;
      return;
      bool = false;
    }
  }
  
  private int scrollBy(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    this.time = System.currentTimeMillis();
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    ensureRenderState();
    if (paramInt > 0) {}
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      updateRenderState(i, j, true, paramState);
      k = this.mRenderState.mScrollingOffset + fill(paramRecycler, this.mRenderState, paramState, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.mOrientationHelper.offsetChildren(-paramInt);
    ensureSuspentionState();
    int j = this.mRecyclerView.mAdapter.getPreloadThresholdInPixels();
    i = this.mRecyclerView.mAdapter.getPreloadThresholdInItemNumber();
    if ((j > 0) && (this.mRecyclerView.getHeight() < paramState.mTotalHeight))
    {
      if ((this.mRecyclerView.mOffsetY + j + this.mRecyclerView.getHeight() < paramState.mTotalHeight) && (j + this.mRecyclerView.mOffsetY + paramInt + this.mRecyclerView.getHeight() >= paramState.mTotalHeight)) {
        this.mRecyclerView.mAdapter.onPreload();
      }
      if (this.mOrientation != 0) {
        break label367;
      }
      paramRecycler = this.mRecyclerView;
      paramRecycler.mOffsetX += paramInt;
    }
    for (;;)
    {
      this.mPreventFixGap = this.mRecyclerView.isInOverScrollArea();
      return paramInt;
      if ((i <= 0) || (this.mRecyclerView.getHeight() >= paramState.mTotalHeight)) {
        break;
      }
      j = this.mRecyclerView.mAdapter.getHeightBefore(this.mRenderState.mCurrentPosition - this.mRenderState.mItemDirection);
      if ((this.mRenderState.mCurrentPosition != getItemCount() - i) || (this.mRecyclerView.mOffsetY + this.mRecyclerView.getHeight() >= j) || (this.mRecyclerView.mOffsetY + paramInt + this.mRecyclerView.getHeight() < j)) {
        break;
      }
      this.mRecyclerView.mAdapter.onPreload();
      break;
      label367:
      paramRecycler = this.mRecyclerView;
      paramRecycler.mOffsetY += paramInt;
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return this.mOrientation == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.mOrientation == 1;
  }
  
  public int computeHorizontalScrollExtent(RecyclerViewBase.State paramState)
  {
    return getChildCount();
  }
  
  public int computeHorizontalScrollOffset(RecyclerViewBase.State paramState)
  {
    int i;
    if (getChildCount() == 0) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = getPosition(getChildClosestToStartByOrder());
      i = j;
    } while (!this.mShouldReverseLayout);
    return paramState.getItemCount() - 1 - j;
  }
  
  public int computeHorizontalScrollRange(RecyclerViewBase.State paramState)
  {
    return paramState.getItemCount();
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    int i = 1;
    int j = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.mShouldReverseLayout) {
      paramInt = -1;
    }
    if (this.mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public int computeVerticalScrollExtent(RecyclerViewBase.State paramState)
  {
    return getChildCount();
  }
  
  public int computeVerticalScrollOffset(RecyclerViewBase.State paramState)
  {
    int i;
    if (getChildCount() == 0) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = getPosition(getChildClosestToStartByOrder());
      i = j;
    } while (!this.mShouldReverseLayout);
    return paramState.getItemCount() - 1 - j;
  }
  
  public int computeVerticalScrollRange(RecyclerViewBase.State paramState)
  {
    return paramState.getItemCount();
  }
  
  BaseLayoutManager.OrientationHelper createHorizontalOrientationHelper()
  {
    return new BaseLayoutManager.3(this);
  }
  
  BaseLayoutManager.OrientationHelper createVerticalOrientationHelper()
  {
    return new BaseLayoutManager.2(this);
  }
  
  protected void ensureRenderState()
  {
    if (this.mRenderState == null) {
      this.mRenderState = new BaseLayoutManager.RenderState();
    }
    if (this.mOrientationHelper == null) {
      if (this.mOrientation != 0) {
        break label43;
      }
    }
    label43:
    for (BaseLayoutManager.OrientationHelper localOrientationHelper = createHorizontalOrientationHelper();; localOrientationHelper = createVerticalOrientationHelper())
    {
      this.mOrientationHelper = localOrientationHelper;
      return;
    }
  }
  
  protected abstract int fill(RecyclerViewBase.Recycler paramRecycler, BaseLayoutManager.RenderState paramRenderState, RecyclerViewBase.State paramState, boolean paramBoolean);
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    return findOneVisibleChild(0, getChildCount(), true);
  }
  
  public int findFirstVisibleItemPosition()
  {
    return findOneVisibleChild(0, getChildCount(), false);
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    return findOneVisibleChild(getChildCount() - 1, -1, true);
  }
  
  public int findLastVisibleItemPosition()
  {
    return findOneVisibleChild(getChildCount() - 1, -1, false);
  }
  
  int findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = -1;
    if (this.mOrientationHelper == null) {
      return -1;
    }
    int k = this.mOrientationHelper.getStartAfterPadding();
    int m = this.mOrientationHelper.getEndAfterPadding();
    int j = paramInt1;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      j = paramInt1;
    }
    while (j != paramInt2)
    {
      View localView = getChildAt(j);
      paramInt1 = this.mOrientationHelper.getDecoratedStart(localView);
      int n = this.mOrientationHelper.getDecoratedEnd(localView);
      if ((paramInt1 < m) && (n > k)) {
        if (paramBoolean)
        {
          if ((paramInt1 >= k) && (n <= m)) {
            return getPosition(localView);
          }
        }
        else {
          return getPosition(localView);
        }
      }
      j += i;
    }
    return -2147483648;
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    if (i == 0) {}
    do
    {
      return null;
      paramInt -= getPosition(getChildAt(0));
    } while ((paramInt < 0) || (paramInt >= i));
    return getChildAt(paramInt);
  }
  
  public RecyclerViewBase.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerViewBase.LayoutParams(-2, -2);
  }
  
  public View getChildClosestToEndByOrder()
  {
    if (this.mShouldReverseLayout) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  public View getChildClosestToEndInScreen()
  {
    if (this.mShouldReverseLayout) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  public View getChildClosestToStartByOrder()
  {
    if (this.mShouldReverseLayout) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  public View getChildClosestToStartInScreen()
  {
    if (this.mShouldReverseLayout) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  public int getCurrentSuspentionPosition()
  {
    return this.mCurrentSuspentionPos;
  }
  
  public View getCurrentSuspentionView()
  {
    return this.mCurrentSuspentionView;
  }
  
  public int getDecoratedEnd(View paramView)
  {
    return this.mOrientationHelper.getDecoratedEnd(paramView);
  }
  
  public int getDecoratedStart(View paramView)
  {
    return this.mOrientationHelper.getDecoratedStart(paramView);
  }
  
  protected int getExtraLayoutSpace(RecyclerViewBase.State paramState)
  {
    if ((this.mRecyclerView.shouldPrebindItem()) || (paramState.hasTargetScrollPosition())) {
      return this.mOrientationHelper.getTotalSpace();
    }
    return 0;
  }
  
  public View getFirstItemAfterOffset(int paramInt)
  {
    return super.getFirstItemAfterOffset(this.mOrientationHelper.getStartAfterPadding() + paramInt);
  }
  
  public View getFirstItemBeforeOffset(int paramInt)
  {
    return super.getFirstItemBeforeOffset(this.mOrientationHelper.getStartAfterPadding() + paramInt);
  }
  
  protected int getHeightBefore(int paramInt)
  {
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getHeightBefore(paramInt);
    }
    return 0;
  }
  
  protected View getNextView(RecyclerViewBase.Recycler paramRecycler, BaseLayoutManager.RenderState paramRenderState, RecyclerViewBase.State paramState)
  {
    View localView;
    if (paramRenderState.hasMore(paramState) == 2)
    {
      localView = paramRenderState.nextHeader(paramRecycler);
      if (localView == null) {
        break label428;
      }
      paramRecycler = localView.getLayoutParams();
      if ((paramRecycler instanceof ViewGroup.MarginLayoutParams))
      {
        paramRecycler = new RecyclerViewBase.LayoutParams((ViewGroup.MarginLayoutParams)paramRecycler);
        paramRecycler.mViewHolder = this.mRecyclerView.createViewHolder(localView, this.mRecyclerView);
        paramRecycler.mViewHolder.mViewType = 1;
        paramRecycler.mViewHolder.mPosition = (paramRenderState.mCurrentPosition - paramRenderState.mItemDirection);
        localView.setLayoutParams(paramRecycler);
        paramState.mHeaderCountInScreen += 1;
        paramRecycler = localView;
      }
    }
    do
    {
      return paramRecycler;
      paramRecycler = new RecyclerViewBase.LayoutParams(paramRecycler);
      break;
      if (paramRenderState.hasMore(paramState) != 4) {
        break label422;
      }
      localView = paramRenderState.nextFooter(paramRecycler, paramState);
      paramRecycler = localView;
    } while (localView == null);
    RecyclerViewBase.LayoutParams localLayoutParams = new RecyclerViewBase.LayoutParams(localView.getLayoutParams());
    localLayoutParams.mViewHolder = this.mRecyclerView.createViewHolder(localView, this.mRecyclerView);
    localLayoutParams.mViewHolder.mViewType = 2;
    localLayoutParams.mViewHolder.mPosition = (paramRenderState.mCurrentPosition - paramRenderState.mItemDirection);
    int j;
    if (this.mRecyclerView.getAdapter().getFooterViewInBottomMode())
    {
      int i = this.mRecyclerView.getHeight() - this.mRecyclerView.getAdapter().getListTotalHeight();
      j = this.mRecyclerView.getAdapter().getFooterViewHeight(this.mRecyclerView.getAdapter().getFooterViewCount());
      if (i <= 0) {
        break label391;
      }
      localLayoutParams.height = (j + i);
      localView.setPadding(localView.getPaddingLeft(), i, localView.getPaddingRight(), localView.getPaddingBottom());
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      paramState.mFooterCountInScreen += 1;
      paramRecycler = localView;
      if (localLayoutParams.mViewHolder.mPosition - paramState.getItemCount() + 1 != paramState.mFooterCount) {
        break;
      }
      if (this.mRenderState.mScrollingOffset == -2147483648)
      {
        paramRecycler = localView;
        if (!this.mRecyclerView.filterCheckNotifyFooterAppeared) {
          break;
        }
      }
      if (this.mRecyclerView.filterCheckNotifyFooterAppeared) {
        this.mRecyclerView.filterCheckNotifyFooterAppeared = false;
      }
      this.mRecyclerView.needNotifyFooter = true;
      return localView;
      label391:
      localLayoutParams.height = j;
      localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
    }
    label422:
    return paramRenderState.next(paramRecycler);
    label428:
    return localView;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getPendingOffset()
  {
    return this.mPendingScrollPositionOffset;
  }
  
  public int getPendingPosition()
  {
    return this.mPendingScrollPosition;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public boolean getStackFromEnd()
  {
    return this.mStackFromEnd;
  }
  
  protected void handleRecordItemHeightChange(int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean isLayoutRTL()
  {
    return false;
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    resolveShouldLayoutReverse();
    if (getChildCount() == 0) {
      return null;
    }
    int i = convertFocusDirectionToLayoutDirection(paramInt);
    if (i == -2147483648) {
      return null;
    }
    View localView;
    if (i == -1) {
      localView = getChildClosestToStartInScreen();
    }
    for (;;)
    {
      ensureRenderState();
      updateRenderState(i, (int)(0.33F * (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getStartAfterPadding())), false, paramState);
      this.mRenderState.mScrollingOffset = -2147483648;
      this.mRecyclerView.filterCheckNotifyFooterAppeared = true;
      fill(paramRecycler, this.mRenderState, paramState, true);
      paramRecycler = FocusFinder.getInstance();
      try
      {
        paramView = paramRecycler.findNextFocus(this.mRecyclerView, paramView, paramInt);
        if ((paramView == null) || (paramView == localView) || (!paramView.isFocusable()))
        {
          return null;
          localView = getChildClosestToEndInScreen();
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView = null;
        }
      }
    }
    return paramView;
  }
  
  public void onLayoutChildren(RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    if (this.mPendingSavedState != null)
    {
      setOrientation(this.mPendingSavedState.mOrientation);
      setReverseLayout(this.mPendingSavedState.mReverseLayout);
      setStackFromEnd(this.mPendingSavedState.mStackFromEnd);
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    ensureRenderState();
    resolveShouldLayoutReverse();
    if ((this.mPendingScrollPosition != -2147483648) && ((this.mPendingScrollPosition < -paramState.mHeaderCount) || (this.mPendingScrollPosition >= paramState.getItemCount())) && ((this.mPendingScrollPosition != 0) || (paramState.getItemCount() != 0)))
    {
      this.mPendingScrollPosition = -2147483648;
      this.mPendingScrollPositionOffset = -2147483648;
    }
    boolean bool = this.mShouldReverseLayout;
    bool = this.mStackFromEnd ^ bool;
    int j;
    label208:
    label247:
    int n;
    Object localObject;
    int i4;
    label342:
    int m;
    int k;
    label358:
    label631:
    RecyclerViewBase.ViewHolder localViewHolder;
    label465:
    int i1;
    if (this.mLastStackFromEnd != this.mStackFromEnd)
    {
      i = 1;
      if (this.mPendingScrollPosition == -2147483648) {
        break label1216;
      }
      j = this.mPendingScrollPosition;
      if (this.mPendingGravity != 0) {}
      switch (this.mPendingGravity & 0x70)
      {
      default: 
        if (this.mPendingSavedState != null)
        {
          bool = this.mPendingSavedState.mAnchorLayoutFromEnd;
          if (bool)
          {
            i = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
            n = this.mRecyclerView.validateAnchorItemPosition(j);
            detachAndScrapAttachedViews(paramRecycler);
            if (paramState.mDataChanged)
            {
              paramState.mDataChanged = false;
              if ((this.mCurrentSuspentionView != null) && (!this.mRecyclerView.isRepeatableSuspensionMode()))
              {
                localObject = this.mRecyclerView.getChildViewHolder(this.mCurrentSuspentionView);
                if (localObject != null) {
                  ((RecyclerViewBase.ViewHolder)localObject).setIsRecyclable(true);
                }
              }
              removeAndRecycleScrapInt(paramRecycler, true, true);
            }
            j = getExtraLayoutSpace(paramState);
            if (paramState.getTargetScrollPosition() >= n) {
              break label1361;
            }
            i4 = 1;
            if (i4 != this.mShouldReverseLayout) {
              break label1367;
            }
            m = 0;
            k = j;
            updateRenderStateToFillStart(n, i);
            this.mRenderState.mExtra = m;
            if (!bool)
            {
              localObject = this.mRenderState;
              ((BaseLayoutManager.RenderState)localObject).mCurrentPosition += this.mRenderState.mItemDirection;
            }
            fill(paramRecycler, this.mRenderState, paramState, false);
            m = this.mRenderState.mCurrentPosition - this.mRenderState.mItemDirection;
            j = this.mRenderState.mOffset;
            if (this.mOrientation != 1) {
              break label1377;
            }
            this.mRecyclerView.mOffsetY = (getHeightBefore(m) - j);
            updateRenderStateToFillEnd(n, i);
            this.mRenderState.mExtra = k;
            if (bool)
            {
              localObject = this.mRenderState;
              ((BaseLayoutManager.RenderState)localObject).mCurrentPosition += this.mRenderState.mItemDirection;
            }
            fill(paramRecycler, this.mRenderState, paramState, false);
            i = this.mRenderState.mOffset;
            this.mRecyclerView.onItemsFill(i);
            this.mRecyclerView.checkNotifyFooterAppearWithFewChild(i);
            if ((getChildCount() <= 0) || (this.mPreventFixGap) || (this.mRecyclerView.mState.mCustomHeaderHeight != 0)) {
              break label1482;
            }
            if (getHeight() > this.mRecyclerView.mAdapter.getListTotalHeight()) {
              break label1403;
            }
            k = fixLayoutStartGap(j, paramRecycler, paramState, true);
            i += k;
            m = fixLayoutEndGap(i, paramRecycler, paramState, false);
            j = j + k + m;
            i += m;
            if ((getChildCount() <= 0) || (paramState.isPreLayout()) || (!supportsPredictiveItemAnimations())) {
              break label1695;
            }
            m = 0;
            k = 0;
            localObject = paramRecycler.getScrapList();
            int i2 = ((List)localObject).size();
            int i3 = getPosition(getChildAt(0));
            n = 0;
            label687:
            if (n >= i2) {
              break label1519;
            }
            localViewHolder = (RecyclerViewBase.ViewHolder)((List)localObject).get(n);
            if (localViewHolder.getPosition() >= i3) {
              break label1485;
            }
            bool = true;
            label721:
            if (bool == this.mShouldReverseLayout) {
              break label1491;
            }
            i1 = -1;
            label733:
            if (i1 != -1) {
              break label1497;
            }
            m = this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView) + m;
          }
        }
        break;
      }
    }
    for (;;)
    {
      n += 1;
      break label687;
      i = 0;
      break;
      this.mPendingScrollPositionOffset = this.mOrientationHelper.getStartAfterPadding();
      break label208;
      this.mPendingScrollPositionOffset = ((this.mRecyclerView.getMeasuredHeight() - this.mPendingScrollPositionItemHeight) / 2 - this.mPendingScrollPositionItemHeight);
      break label208;
      this.mPendingScrollPositionOffset = (this.mRecyclerView.getMeasuredHeight() - this.mPendingScrollPositionItemHeight);
      break label208;
      i = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
      break label247;
      if (this.mPendingScrollPositionOffset == -2147483648)
      {
        localObject = findViewByPosition(this.mPendingScrollPosition);
        if (localObject != null)
        {
          i = this.mOrientationHelper.getDecoratedStart((View)localObject);
          k = this.mOrientationHelper.getStartAfterPadding();
          m = this.mOrientationHelper.getEndAfterPadding();
          n = this.mOrientationHelper.getDecoratedEnd((View)localObject);
          if (this.mOrientationHelper.getDecoratedMeasurement((View)localObject) > this.mOrientationHelper.getTotalSpace())
          {
            if (bool)
            {
              i = this.mOrientationHelper.getEndAfterPadding();
              break label247;
            }
            i = this.mOrientationHelper.getStartAfterPadding();
            break label247;
          }
          if (i - k < 0)
          {
            i = this.mOrientationHelper.getStartAfterPadding();
            bool = false;
            break label247;
          }
          if (m - n < 0)
          {
            i = this.mOrientationHelper.getEndAfterPadding();
            bool = true;
            break label247;
          }
          if (bool)
          {
            i = this.mOrientationHelper.getDecoratedEnd((View)localObject);
            break label247;
          }
          i = this.mOrientationHelper.getDecoratedStart((View)localObject);
          break label247;
        }
        if (getChildCount() > 0)
        {
          i = getPosition(getChildAt(0));
          if (this.mPendingScrollPosition < i) {}
          for (bool = true;; bool = false)
          {
            if (bool != this.mShouldReverseLayout) {
              break label1120;
            }
            i = this.mOrientationHelper.getEndAfterPadding();
            bool = true;
            break;
          }
          label1120:
          i = this.mOrientationHelper.getStartAfterPadding();
          bool = false;
          break label247;
        }
        if (bool)
        {
          i = this.mOrientationHelper.getEndAfterPadding();
          break label247;
        }
        i = this.mOrientationHelper.getStartAfterPadding();
        break label247;
      }
      if (this.mShouldReverseLayout)
      {
        i = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
        bool = true;
        break label247;
      }
      i = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
      bool = false;
      break label247;
      label1216:
      if ((getChildCount() > 0) && (i == 0))
      {
        if (bool)
        {
          i = this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen());
          j = getPosition(getChildClosestToEndByOrder());
          break label247;
        }
        localObject = getChildClosestToStartByOrder();
        i = this.mOrientationHelper.getDecoratedStart((View)localObject);
        j = getPosition((View)localObject);
        break label247;
      }
      if (bool) {}
      for (i = this.mOrientationHelper.getEndAfterPadding();; i = this.mOrientationHelper.getStartAfterPadding())
      {
        if (!this.mStackFromEnd) {
          break label1345;
        }
        j = paramState.getItemCount() - 1 + this.mRecyclerView.mAdapter.getFooterViewCount();
        break;
      }
      label1345:
      j = -this.mRecyclerView.mAdapter.getHeaderViewCount();
      break label247;
      label1361:
      i4 = 0;
      break label342;
      label1367:
      k = 0;
      m = j;
      break label358;
      label1377:
      if (this.mOrientation != 0) {
        break label465;
      }
      this.mRecyclerView.mOffsetX = (getHeightBefore(m) - j);
      break label465;
      label1403:
      if (this.mRecyclerView.mOffsetY - this.mOrientationHelper.getStartAfterPadding() != 0)
      {
        if (!this.doNotCheckAgain)
        {
          this.doNotCheckAgain = true;
          scrollToPositionWidthOffsetInLayout(-this.mRecyclerView.mAdapter.getHeaderViewCount(), this.mOrientationHelper.getStartAfterPadding());
          break label631;
        }
        this.doNotCheckAgain = false;
        break label631;
      }
      if (this.doNotCheckAgain) {
        this.doNotCheckAgain = false;
      }
      label1482:
      break label631;
      label1485:
      bool = false;
      break label721;
      label1491:
      i1 = 1;
      break label733;
      label1497:
      k = this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView) + k;
    }
    label1519:
    this.mRenderState.mScrapList = ((List)localObject);
    if (m > 0)
    {
      updateRenderStateToFillStart(getPosition(getChildClosestToStartByOrder()), j);
      this.mRenderState.mExtra = m;
      this.mRenderState.mAvailable = 0;
      localObject = this.mRenderState;
      m = ((BaseLayoutManager.RenderState)localObject).mCurrentPosition;
      if (this.mShouldReverseLayout)
      {
        j = 1;
        ((BaseLayoutManager.RenderState)localObject).mCurrentPosition = (j + m);
        fill(paramRecycler, this.mRenderState, paramState, false);
      }
    }
    else if (k > 0)
    {
      updateRenderStateToFillEnd(getPosition(getChildClosestToEndByOrder()), i);
      this.mRenderState.mExtra = k;
      this.mRenderState.mAvailable = 0;
      localObject = this.mRenderState;
      j = ((BaseLayoutManager.RenderState)localObject).mCurrentPosition;
      if (!this.mShouldReverseLayout) {
        break label1740;
      }
    }
    label1695:
    label1740:
    for (int i = -1;; i = 1)
    {
      ((BaseLayoutManager.RenderState)localObject).mCurrentPosition = (i + j);
      fill(paramRecycler, this.mRenderState, paramState, false);
      this.mRenderState.mScrapList = null;
      removeSuspentions();
      ensureSuspentionState();
      this.mPendingScrollPosition = -2147483648;
      this.mPendingScrollPositionOffset = -2147483648;
      this.mLastStackFromEnd = this.mStackFromEnd;
      this.mPendingGravity = 0;
      this.mPendingSavedState = null;
      return;
      j = -1;
      break;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof BaseLayoutManager.SavedState))
    {
      this.mPendingSavedState = ((BaseLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.mPendingSavedState != null) {
      return new BaseLayoutManager.SavedState(this.mPendingSavedState);
    }
    BaseLayoutManager.SavedState localSavedState = new BaseLayoutManager.SavedState();
    if (getChildCount() > 0)
    {
      boolean bool = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
      localSavedState.mAnchorLayoutFromEnd = bool;
      if (bool)
      {
        localSavedState.mAnchorOffset = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen()));
        localSavedState.mAnchorPosition = getPosition(getChildClosestToEndByOrder());
      }
    }
    for (;;)
    {
      localSavedState.mStackFromEnd = this.mStackFromEnd;
      localSavedState.mReverseLayout = this.mReverseLayout;
      localSavedState.mOrientation = this.mOrientation;
      return localSavedState;
      localSavedState.mAnchorPosition = getPosition(getChildClosestToStartByOrder());
      localSavedState.mAnchorOffset = (this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen()) - this.mOrientationHelper.getStartAfterPadding());
      continue;
      localSavedState.mAnchorPosition = 0;
      localSavedState.mAnchorOffset = 0;
    }
  }
  
  protected void recordItemSize(int paramInt, View paramView)
  {
    RecyclerAdapter localRecyclerAdapter;
    int i;
    if ((this.mRecyclerView != null) && (this.mRecyclerView.getAdapter() != null) && ((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter)))
    {
      localRecyclerAdapter = (RecyclerAdapter)this.mRecyclerView.getAdapter();
      if (localRecyclerAdapter.isAutoCalculateItemHeight())
      {
        i = paramView.getMeasuredWidth();
        if (localRecyclerAdapter.mItemWidthList == null) {
          localRecyclerAdapter.mItemWidthList = new ArrayList(localRecyclerAdapter.getItemCount());
        }
        if (localRecyclerAdapter.mItemWidthList.size() <= paramInt) {
          break label107;
        }
        localRecyclerAdapter.mItemWidthList.set(paramInt, Integer.valueOf(i));
      }
    }
    return;
    label107:
    if (localRecyclerAdapter.mItemWidthList.size() == paramInt)
    {
      localRecyclerAdapter.mItemWidthList.add(Integer.valueOf(i));
      return;
    }
    Log.e("LinearLayoutManager", "recordItemSize with wrong index " + paramInt + ", itemWidth " + i + ", listSize " + localRecyclerAdapter.mItemWidthList.size());
  }
  
  protected void recycleByRenderState(RecyclerViewBase.Recycler paramRecycler, BaseLayoutManager.RenderState paramRenderState)
  {
    if (paramRenderState.mLayoutDirection == -1)
    {
      recycleViewsFromEnd(paramRecycler, paramRenderState.mScrollingOffset);
      return;
    }
    recycleViewsFromStart(paramRecycler, paramRenderState.mScrollingOffset);
  }
  
  public void removeSuspentions()
  {
    if ((this.mCurrentSuspentionView != null) && (this.mCurrentSuspentionView.getParent() == this.mRecyclerView))
    {
      this.mCurrentSuspentionView.clearAnimation();
      this.mRecyclerView.removeAnimatingView(this.mCurrentSuspentionView, true);
      this.mCurrentSuspentionView = null;
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    paramState.overscroll = true;
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = -2147483648;
    requestLayout();
  }
  
  public void scrollToPositionWidthGravity(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingGravity = paramInt2;
    this.mPendingScrollPositionOffset = -2147483648;
    this.mPendingScrollPositionItemHeight = paramInt3;
    requestLayout();
  }
  
  public void scrollToPositionWidthOffsetInLayout(int paramInt1, int paramInt2)
  {
    this.mPendingGravity = 0;
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    this.mRecyclerView.dispatchLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    if (Math.abs(paramInt) > getHeight() * 1.5F)
    {
      int i;
      if (this.mRecyclerView.mOffsetY + paramInt < -this.mRecyclerView.getSpringBackMaxDistance()) {
        i = -this.mRecyclerView.getSpringBackMaxDistance() - this.mRecyclerView.mOffsetY;
      }
      for (;;)
      {
        paramInt = this.mRecyclerView.mOffsetY;
        paramRecycler = this.mRecyclerView.mAdapter.getBeginPositionWithOffset(paramInt + i);
        this.mRecyclerView.mLayout.mPendingScrollPosition = paramRecycler[0];
        this.mRecyclerView.mLayout.mPendingScrollPositionOffset = paramRecycler[1];
        this.mRecyclerView.dispatchLayout();
        return Math.abs(i);
        i = paramInt;
        if (this.mRecyclerView.mOffsetY + paramInt > this.mRecyclerView.mAdapter.getListTotalHeight() + this.mRecyclerView.getSpringBackMaxDistance()) {
          i = this.mRecyclerView.mAdapter.getListTotalHeight() + this.mRecyclerView.getSpringBackMaxDistance() - this.mRecyclerView.mOffsetY;
        }
      }
    }
    paramState.overscroll = true;
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.mOrientation != paramInt)) {
      this.mPendingSavedState.mOrientation = paramInt;
    }
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    this.mOrientationHelper = null;
    requestLayout();
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.mReverseLayout != paramBoolean)) {
      this.mPendingSavedState.mReverseLayout = paramBoolean;
    }
    if (paramBoolean == this.mReverseLayout) {
      return;
    }
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.mStackFromEnd != paramBoolean)) {
      this.mPendingSavedState.mStackFromEnd = paramBoolean;
    }
    if (this.mStackFromEnd == paramBoolean) {
      return;
    }
    this.mStackFromEnd = paramBoolean;
    requestLayout();
  }
  
  public void showCurrentSuspention(int paramInt)
  {
    Log.d("TMYHIS", "showCurrentSuspention=");
    this.mRecyclerView.mAnimatingViewPrevPos = this.mRecyclerView.mAnimatingViewPos;
    this.mRecyclerView.mAnimatingViewPos = paramInt;
    this.mCurrentSuspentionPos = paramInt;
    removeSuspentions();
    if ((paramInt == -2147483648) || (this.mRecyclerView.mRecycler == null)) {
      this.mCurrentSuspentionView = null;
    }
    label160:
    for (;;)
    {
      return;
      if (this.mRecyclerView.isRepeatableSuspensionMode()) {}
      for (Object localObject = this.mRecyclerView.mRecycler.getViewForPosition(paramInt);; localObject = this.mRecyclerView.mRecycler.getSuspendViewForPosition(paramInt))
      {
        if (localObject == null) {
          break label160;
        }
        measureChildWithMargins((View)localObject, 0, 0);
        layoutDecorated((View)localObject, 0, 0, ((View)localObject).getMeasuredWidth(), ((View)localObject).getMeasuredHeight());
        this.mRecyclerView.addAnimatingView((View)localObject, true);
        this.mCurrentSuspentionView = ((View)localObject);
        localObject = this.mRecyclerView.getChildViewHolder((View)localObject);
        if (!((RecyclerViewBase.ViewHolder)localObject).isRecyclable()) {
          break;
        }
        ((RecyclerViewBase.ViewHolder)localObject).setIsRecyclable(false);
        return;
      }
    }
  }
  
  public void smoothScrollToPosition(RecyclerViewBase paramRecyclerViewBase, RecyclerViewBase.State paramState, int paramInt)
  {
    paramRecyclerViewBase = new BaseLayoutManager.1(this, paramRecyclerViewBase.getContext());
    paramRecyclerViewBase.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerViewBase);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return false;
  }
  
  protected void updateRenderState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerViewBase.State paramState)
  {
    int i = -1;
    int j = 1;
    this.mRenderState.mExtra = getExtraLayoutSpace(paramState);
    this.mRenderState.mLayoutDirection = paramInt1;
    if (paramInt1 == 1)
    {
      localRenderState = this.mRenderState;
      if (this.mShouldReverseLayout) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localRenderState.mItemDirection = paramInt1;
        this.mRenderState.mCurrentPosition = (getPosition(getChildClosestToEndByOrder()) + this.mRenderState.mItemDirection);
        this.mRenderState.mOffset = this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen());
        paramInt1 = this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen()) - this.mOrientationHelper.getEndAfterPadding();
        this.mRenderState.mAvailable = paramInt2;
        if (paramBoolean)
        {
          localRenderState = this.mRenderState;
          localRenderState.mAvailable -= paramInt1;
        }
        this.mRenderState.overscroll = paramState.overscroll;
        this.mRenderState.mScrollingOffset = paramInt1;
        return;
      }
    }
    BaseLayoutManager.RenderState localRenderState = this.mRenderState;
    if (this.mShouldReverseLayout) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localRenderState.mItemDirection = paramInt1;
      this.mRenderState.mCurrentPosition = (getPosition(getChildClosestToStartByOrder()) + this.mRenderState.mItemDirection);
      this.mRenderState.mOffset = this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen());
      paramInt1 = -this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen()) + this.mOrientationHelper.getStartAfterPadding();
      break;
    }
  }
  
  protected void updateRenderStateToFillEnd(int paramInt1, int paramInt2)
  {
    this.mRenderState.mAvailable = (this.mOrientationHelper.getEndAfterPadding() - paramInt2);
    BaseLayoutManager.RenderState localRenderState = this.mRenderState;
    if (this.mShouldReverseLayout) {}
    for (int i = -1;; i = 1)
    {
      localRenderState.mItemDirection = i;
      this.mRenderState.mCurrentPosition = paramInt1;
      this.mRenderState.mLayoutDirection = 1;
      this.mRenderState.mOffset = paramInt2;
      this.mRenderState.mScrollingOffset = -2147483648;
      return;
    }
  }
  
  protected void updateRenderStateToFillStart(int paramInt1, int paramInt2)
  {
    this.mRenderState.mAvailable = (paramInt2 - this.mOrientationHelper.getStartAfterPadding());
    this.mRenderState.mCurrentPosition = paramInt1;
    BaseLayoutManager.RenderState localRenderState = this.mRenderState;
    if (this.mShouldReverseLayout) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localRenderState.mItemDirection = paramInt1;
      this.mRenderState.mLayoutDirection = -1;
      this.mRenderState.mOffset = paramInt2;
      this.mRenderState.mScrollingOffset = -2147483648;
      return;
    }
  }
  
  protected void validateChildOrder()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Log.d("LinearLayoutManager", "validating child count " + getChildCount());
    if (getChildCount() < 1) {}
    for (;;)
    {
      return;
      int j = getPosition(getChildAt(0));
      int k = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
      int i;
      Object localObject;
      int m;
      int n;
      if (this.mShouldReverseLayout)
      {
        i = 1;
        while (i < getChildCount())
        {
          localObject = getChildAt(i);
          m = getPosition((View)localObject);
          n = this.mOrientationHelper.getDecoratedStart((View)localObject);
          if (m < j)
          {
            logChildren();
            localObject = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (n < k) {}
            for (;;)
            {
              throw new RuntimeException(bool1);
              bool1 = false;
            }
          }
          if (n > k)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
          i += 1;
        }
      }
      else
      {
        i = 1;
        while (i < getChildCount())
        {
          localObject = getChildAt(i);
          m = getPosition((View)localObject);
          n = this.mOrientationHelper.getDecoratedStart((View)localObject);
          if (m < j)
          {
            logChildren();
            localObject = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (n < k) {}
            for (bool1 = bool2;; bool1 = false) {
              throw new RuntimeException(bool1);
            }
          }
          if (n < k)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
 * JD-Core Version:    0.7.0.1
 */