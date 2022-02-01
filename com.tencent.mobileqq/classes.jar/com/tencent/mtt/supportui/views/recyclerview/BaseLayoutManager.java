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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 17)
        {
          if (paramInt != 33)
          {
            if (paramInt != 66)
            {
              if (paramInt != 130) {
                return -2147483648;
              }
              if (this.mOrientation == 1) {
                return 1;
              }
              return -2147483648;
            }
            if (this.mOrientation == 0) {
              return 1;
            }
            return -2147483648;
          }
          if (this.mOrientation == 1) {
            return -1;
          }
          return -2147483648;
        }
        if (this.mOrientation == 0) {
          return -1;
        }
        return -2147483648;
      }
      return 1;
    }
    return -1;
  }
  
  private void ensureSuspentionState()
  {
    if (!this.mRecyclerView.hasSuspentedItem()) {
      return;
    }
    if (getChildCount() == 0) {
      return;
    }
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
    localView = this.mCurrentSuspentionView;
    if ((localView != null) && (localView.getParent() == this.mRecyclerView))
    {
      j = this.mCurrentSuspentionView.getMeasuredHeight();
      i = this.mRecyclerView.findNextSuspentedPos(i);
      localView = null;
      if (i != -1) {
        localView = findViewByPosition(i);
      }
      if (localView == null) {
        i = 2147483647;
      } else {
        i = localView.getTop();
      }
      if (i < j) {
        this.mCurrentSuspentionView.offsetTopAndBottom(i - j);
      }
    }
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState, boolean paramBoolean)
  {
    if (!this.mRecyclerView.isRefreshing())
    {
      if (this.mRecyclerView.mState.mCustomHeaderHeight > 0) {
        return 0;
      }
      int i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
      if (i > 0)
      {
        paramState.overscroll = false;
        i = -scrollBy(-i, paramRecycler, paramState);
        if (paramBoolean)
        {
          paramInt = this.mOrientationHelper.getEndAfterPadding() - (paramInt + i);
          if (paramInt > 0)
          {
            this.mOrientationHelper.offsetChildren(paramInt);
            return paramInt + i;
          }
        }
        return i;
      }
    }
    return 0;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState, boolean paramBoolean)
  {
    if (this.mRecyclerView.isRefreshing()) {
      return 0;
    }
    int i = paramInt - this.mOrientationHelper.getStartAfterPadding();
    if (i > 0)
    {
      paramState.overscroll = false;
      int j = -scrollBy(i, paramRecycler, paramState);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.mOrientationHelper.getStartAfterPadding();
        i = j;
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private void logChildren()
  {
    Log.d("LinearLayoutManager", "internal representation of views on the screen");
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("item ");
      localStringBuilder.append(getPosition(localView));
      localStringBuilder.append(", coord:");
      localStringBuilder.append(this.mOrientationHelper.getDecoratedStart(localView));
      Log.d("LinearLayoutManager", localStringBuilder.toString());
      i += 1;
    }
    Log.d("LinearLayoutManager", "==============");
  }
  
  private void recycleChildren(RecyclerViewBase.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
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
    while (i > paramInt2)
    {
      removeAndRecycleViewAt(i, paramRecycler);
      i -= 1;
    }
  }
  
  private void recycleViewsFromEnd(RecyclerViewBase.Recycler paramRecycler, int paramInt)
  {
    int k = getChildCount();
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    int j = this.mOrientationHelper.getEndAfterPadding() - i;
    View localView;
    if (this.mShouldReverseLayout)
    {
      paramInt = 0;
      while (paramInt < k)
      {
        localView = getChildAt(paramInt);
        if (this.mOrientationHelper.getDecoratedStart(localView) < j)
        {
          recycleChildren(paramRecycler, 0, paramInt);
          return;
        }
        paramInt += 1;
      }
    }
    i = k - 1;
    paramInt = i;
    while (paramInt >= 0)
    {
      localView = getChildAt(paramInt);
      if (this.mOrientationHelper.getDecoratedStart(localView) < j)
      {
        recycleChildren(paramRecycler, i, paramInt);
        return;
      }
      paramInt -= 1;
    }
  }
  
  private void recycleViewsFromStart(RecyclerViewBase.Recycler paramRecycler, int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    int j = this.mOrientationHelper.getStartAfterPadding() + i;
    i = getChildCount();
    View localView;
    if (this.mShouldReverseLayout)
    {
      i -= 1;
      paramInt = i;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        if (this.mOrientationHelper.getDecoratedEnd(localView) > j)
        {
          recycleChildren(paramRecycler, i, paramInt);
          return;
        }
        paramInt -= 1;
      }
    }
    paramInt = 0;
    while (paramInt < i)
    {
      localView = getChildAt(paramInt);
      if (this.mOrientationHelper.getDecoratedEnd(localView) > j)
      {
        recycleChildren(paramRecycler, 0, paramInt);
        return;
      }
      paramInt += 1;
    }
  }
  
  private void resolveShouldLayoutReverse()
  {
    boolean bool;
    if ((this.mOrientation != 1) && (isLayoutRTL())) {
      bool = this.mReverseLayout ^ true;
    } else {
      bool = this.mReverseLayout;
    }
    this.mShouldReverseLayout = bool;
  }
  
  private int scrollBy(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    this.time = System.currentTimeMillis();
    if (getChildCount() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      ensureRenderState();
      if (paramInt > 0) {
        i = 1;
      } else {
        i = -1;
      }
      int j = Math.abs(paramInt);
      updateRenderState(i, j, true, paramState);
      int k = this.mRenderState.mScrollingOffset + fill(paramRecycler, this.mRenderState, paramState, false);
      if (k < 0) {
        return 0;
      }
      if (j > k) {
        paramInt = i * k;
      }
      this.mOrientationHelper.offsetChildren(-paramInt);
      ensureSuspentionState();
      j = this.mRecyclerView.mAdapter.getPreloadThresholdInPixels();
      int i = this.mRecyclerView.mAdapter.getPreloadThresholdInItemNumber();
      if ((j > 0) && (this.mRecyclerView.getHeight() < paramState.mTotalHeight))
      {
        if ((this.mRecyclerView.mOffsetY + j + this.mRecyclerView.getHeight() >= paramState.mTotalHeight) || (this.mRecyclerView.mOffsetY + j + paramInt + this.mRecyclerView.getHeight() < paramState.mTotalHeight)) {}
      }
      else {
        do
        {
          this.mRecyclerView.mAdapter.onPreload();
          break;
          if ((i <= 0) || (this.mRecyclerView.getHeight() >= paramState.mTotalHeight)) {
            break;
          }
          j = this.mRecyclerView.mAdapter.getHeightBefore(this.mRenderState.mCurrentPosition - this.mRenderState.mItemDirection);
        } while ((this.mRenderState.mCurrentPosition == getItemCount() - i) && (this.mRecyclerView.mOffsetY + this.mRecyclerView.getHeight() < j) && (this.mRecyclerView.mOffsetY + paramInt + this.mRecyclerView.getHeight() >= j));
      }
      if (this.mOrientation == 0)
      {
        paramRecycler = this.mRecyclerView;
        paramRecycler.mOffsetX += paramInt;
      }
      else
      {
        paramRecycler = this.mRecyclerView;
        paramRecycler.mOffsetY += paramInt;
      }
      this.mPreventFixGap = this.mRecyclerView.isInOverScrollArea();
      return paramInt;
    }
    return 0;
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
    if (getChildCount() == 0) {
      return 0;
    }
    int j = getPosition(getChildClosestToStartByOrder());
    int i = j;
    if (this.mShouldReverseLayout) {
      i = paramState.getItemCount() - 1 - j;
    }
    return i;
  }
  
  public int computeHorizontalScrollRange(RecyclerViewBase.State paramState)
  {
    return paramState.getItemCount();
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    int k = 0;
    int j = getPosition(getChildAt(0));
    int i = 1;
    if (paramInt < j) {
      k = 1;
    }
    paramInt = i;
    if (k != this.mShouldReverseLayout) {
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
    if (getChildCount() == 0) {
      return 0;
    }
    int j = getPosition(getChildClosestToStartByOrder());
    int i = j;
    if (this.mShouldReverseLayout) {
      i = paramState.getItemCount() - 1 - j;
    }
    return i;
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
    if (this.mOrientationHelper == null)
    {
      BaseLayoutManager.OrientationHelper localOrientationHelper;
      if (this.mOrientation == 0) {
        localOrientationHelper = createHorizontalOrientationHelper();
      } else {
        localOrientationHelper = createVerticalOrientationHelper();
      }
      this.mOrientationHelper = localOrientationHelper;
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
    Object localObject = this.mOrientationHelper;
    int i = -1;
    if (localObject == null) {
      return -1;
    }
    int k = ((BaseLayoutManager.OrientationHelper)localObject).getStartAfterPadding();
    int m = this.mOrientationHelper.getEndAfterPadding();
    int j = paramInt1;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      j = paramInt1;
    }
    while (j != paramInt2)
    {
      localObject = getChildAt(j);
      paramInt1 = this.mOrientationHelper.getDecoratedStart((View)localObject);
      int n = this.mOrientationHelper.getDecoratedEnd((View)localObject);
      if ((paramInt1 < m) && (n > k)) {
        if (paramBoolean)
        {
          if ((paramInt1 >= k) && (n <= m)) {
            return getPosition((View)localObject);
          }
        }
        else {
          return getPosition((View)localObject);
        }
      }
      j += i;
    }
    return -2147483648;
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    if (i == 0) {
      return null;
    }
    paramInt -= getPosition(getChildAt(0));
    if ((paramInt >= 0) && (paramInt < i)) {
      return getChildAt(paramInt);
    }
    return null;
  }
  
  public RecyclerViewBase.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerViewBase.LayoutParams(-2, -2);
  }
  
  public View getChildClosestToEndByOrder()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = 0;
    } else {
      i = getChildCount() - 1;
    }
    return getChildAt(i);
  }
  
  public View getChildClosestToEndInScreen()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = 0;
    } else {
      i = getChildCount() - 1;
    }
    return getChildAt(i);
  }
  
  public View getChildClosestToStartByOrder()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = getChildCount() - 1;
    } else {
      i = 0;
    }
    return getChildAt(i);
  }
  
  public View getChildClosestToStartInScreen()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = getChildCount() - 1;
    } else {
      i = 0;
    }
    return getChildAt(i);
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
    if ((!this.mRecyclerView.shouldPrebindItem()) && (!paramState.hasTargetScrollPosition())) {
      return 0;
    }
    return this.mOrientationHelper.getTotalSpace();
  }
  
  public View getFirstItemAfterOffset(int paramInt)
  {
    return super.getFirstItemAfterOffset(paramInt + this.mOrientationHelper.getStartAfterPadding());
  }
  
  public View getFirstItemBeforeOffset(int paramInt)
  {
    return super.getFirstItemBeforeOffset(paramInt + this.mOrientationHelper.getStartAfterPadding());
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
      paramRecycler = localView;
      if (localView != null)
      {
        paramRecycler = localView.getLayoutParams();
        if ((paramRecycler instanceof ViewGroup.MarginLayoutParams)) {
          paramRecycler = new RecyclerViewBase.LayoutParams((ViewGroup.MarginLayoutParams)paramRecycler);
        } else {
          paramRecycler = new RecyclerViewBase.LayoutParams(paramRecycler);
        }
        paramRecycler.mViewHolder = this.mRecyclerView.createViewHolder(localView, this.mRecyclerView);
        paramRecycler.mViewHolder.mViewType = 1;
        paramRecycler.mViewHolder.mPosition = (paramRenderState.mCurrentPosition - paramRenderState.mItemDirection);
        localView.setLayoutParams(paramRecycler);
        paramState.mHeaderCountInScreen += 1;
        return localView;
      }
    }
    else if (paramRenderState.hasMore(paramState) == 4)
    {
      localView = paramRenderState.nextFooter(paramRecycler, paramState);
      paramRecycler = localView;
      if (localView != null)
      {
        RecyclerViewBase.LayoutParams localLayoutParams = new RecyclerViewBase.LayoutParams(localView.getLayoutParams());
        localLayoutParams.mViewHolder = this.mRecyclerView.createViewHolder(localView, this.mRecyclerView);
        localLayoutParams.mViewHolder.mViewType = 2;
        localLayoutParams.mViewHolder.mPosition = (paramRenderState.mCurrentPosition - paramRenderState.mItemDirection);
        if (this.mRecyclerView.getAdapter().getFooterViewInBottomMode())
        {
          int i = this.mRecyclerView.getHeight() - this.mRecyclerView.getAdapter().getListTotalHeight();
          int j = this.mRecyclerView.getAdapter().getFooterViewHeight(this.mRecyclerView.getAdapter().getFooterViewCount());
          if (i > 0)
          {
            localLayoutParams.height = (j + i);
            localView.setPadding(localView.getPaddingLeft(), i, localView.getPaddingRight(), localView.getPaddingBottom());
          }
          else
          {
            localLayoutParams.height = j;
            localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
          }
        }
        localView.setLayoutParams(localLayoutParams);
        paramState.mFooterCountInScreen += 1;
        paramRecycler = localView;
        if (localLayoutParams.mViewHolder.mPosition - paramState.getItemCount() + 1 == paramState.mFooterCount) {
          if (this.mRenderState.mScrollingOffset == -2147483648)
          {
            paramRecycler = localView;
            if (!this.mRecyclerView.filterCheckNotifyFooterAppeared) {}
          }
          else
          {
            if (this.mRecyclerView.filterCheckNotifyFooterAppeared) {
              this.mRecyclerView.filterCheckNotifyFooterAppeared = false;
            }
            this.mRecyclerView.needNotifyFooter = true;
            return localView;
          }
        }
      }
    }
    else
    {
      paramRecycler = paramRenderState.next(paramRecycler);
    }
    return paramRecycler;
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
    } else {
      localView = getChildClosestToEndInScreen();
    }
    ensureRenderState();
    updateRenderState(i, (int)((this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getStartAfterPadding()) * 0.33F), false, paramState);
    this.mRenderState.mScrollingOffset = -2147483648;
    this.mRecyclerView.filterCheckNotifyFooterAppeared = true;
    fill(paramRecycler, this.mRenderState, paramState, true);
    paramRecycler = FocusFinder.getInstance();
    try
    {
      paramView = paramRecycler.findNextFocus(this.mRecyclerView, paramView, paramInt);
    }
    catch (Exception paramView)
    {
      label135:
      break label135;
    }
    paramView = null;
    if ((paramView != null) && (paramView != localView))
    {
      if (!paramView.isFocusable()) {
        return null;
      }
      return paramView;
    }
    return null;
  }
  
  public void onLayoutChildren(RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    Object localObject = this.mPendingSavedState;
    if (localObject != null)
    {
      setOrientation(((BaseLayoutManager.SavedState)localObject).mOrientation);
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
    boolean bool1 = this.mShouldReverseLayout;
    boolean bool2 = this.mStackFromEnd;
    bool1 ^= bool2;
    if (this.mLastStackFromEnd != bool2) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.mPendingScrollPosition != -2147483648)
    {
      k = this.mPendingScrollPosition;
      i = this.mPendingGravity;
      if (i != 0)
      {
        i &= 0x70;
        if (i != 16)
        {
          if (i != 48)
          {
            if (i != 80) {
              break label265;
            }
            i = this.mRecyclerView.getMeasuredHeight();
            j = this.mPendingScrollPositionItemHeight;
          }
          else
          {
            i = this.mOrientationHelper.getStartAfterPadding();
            break label260;
          }
        }
        else
        {
          i = this.mRecyclerView.getMeasuredHeight();
          j = this.mPendingScrollPositionItemHeight;
          i = (i - j) / 2;
        }
        i -= j;
        label260:
        this.mPendingScrollPositionOffset = i;
      }
      label265:
      localObject = this.mPendingSavedState;
      if (localObject != null)
      {
        bool1 = ((BaseLayoutManager.SavedState)localObject).mAnchorLayoutFromEnd;
        if (bool1)
        {
          i = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
          j = k;
        }
        else
        {
          i = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
          j = k;
        }
      }
      else
      {
        if (this.mPendingScrollPositionOffset == -2147483648)
        {
          localObject = findViewByPosition(this.mPendingScrollPosition);
          if (localObject != null)
          {
            i = this.mOrientationHelper.getDecoratedStart((View)localObject);
            j = this.mOrientationHelper.getStartAfterPadding();
            m = this.mOrientationHelper.getEndAfterPadding();
            n = this.mOrientationHelper.getDecoratedEnd((View)localObject);
            if (this.mOrientationHelper.getDecoratedMeasurement((View)localObject) > this.mOrientationHelper.getTotalSpace()) {
              if (!bool1) {}
            }
          }
          for (;;)
          {
            i = this.mOrientationHelper.getEndAfterPadding();
            j = k;
            break label829;
            do
            {
              i = this.mOrientationHelper.getStartAfterPadding();
              j = k;
              break label829;
              if (i - j < 0)
              {
                i = this.mOrientationHelper.getStartAfterPadding();
                break label681;
              }
              if (m - n < 0)
              {
                i = this.mOrientationHelper.getEndAfterPadding();
                break;
              }
              if (bool1)
              {
                i = this.mOrientationHelper.getDecoratedEnd((View)localObject);
                j = k;
                break label829;
              }
              i = this.mOrientationHelper.getDecoratedStart((View)localObject);
              j = k;
              break label829;
              if (getChildCount() > 0)
              {
                i = getPosition(getChildAt(0));
                if (this.mPendingScrollPosition < i) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                if (bool1 == this.mShouldReverseLayout)
                {
                  i = this.mOrientationHelper.getEndAfterPadding();
                  break;
                }
                i = this.mOrientationHelper.getStartAfterPadding();
                break label681;
              }
            } while (!bool1);
          }
        }
        if (this.mShouldReverseLayout)
        {
          i = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
          bool1 = true;
          j = k;
        }
        else
        {
          i = this.mOrientationHelper.getStartAfterPadding();
          i = this.mPendingScrollPositionOffset + i;
          label681:
          bool1 = false;
          j = k;
        }
      }
    }
    else if ((getChildCount() > 0) && (i == 0))
    {
      if (bool1)
      {
        i = this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen());
        localObject = getChildClosestToEndByOrder();
      }
      else
      {
        localObject = getChildClosestToStartByOrder();
        i = this.mOrientationHelper.getDecoratedStart((View)localObject);
      }
      j = getPosition((View)localObject);
    }
    else
    {
      if (bool1) {
        i = this.mOrientationHelper.getEndAfterPadding();
      } else {
        i = this.mOrientationHelper.getStartAfterPadding();
      }
      if (this.mStackFromEnd) {
        j = paramState.getItemCount() - 1 + this.mRecyclerView.mAdapter.getFooterViewCount();
      } else {
        j = -this.mRecyclerView.mAdapter.getHeaderViewCount();
      }
    }
    label829:
    int j = this.mRecyclerView.validateAnchorItemPosition(j);
    int m = validateAnchorPosition(this.mRenderState.mItemDirection, j, paramState.getItemCount());
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
    int k = getExtraLayoutSpace(paramState);
    if (paramState.getTargetScrollPosition() < m) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (bool2 == this.mShouldReverseLayout)
    {
      j = k;
      k = 0;
    }
    else
    {
      j = 0;
    }
    updateRenderStateToFillStart(m, i);
    localObject = this.mRenderState;
    ((BaseLayoutManager.RenderState)localObject).mExtra = k;
    if (!bool1) {
      ((BaseLayoutManager.RenderState)localObject).mCurrentPosition += this.mRenderState.mItemDirection;
    }
    fill(paramRecycler, this.mRenderState, paramState, false);
    int n = this.mRenderState.mCurrentPosition - this.mRenderState.mItemDirection;
    k = this.mRenderState.mOffset;
    int i1 = this.mOrientation;
    if (i1 == 1) {
      this.mRecyclerView.mOffsetY = (getHeightBefore(n) - k);
    } else if (i1 == 0) {
      this.mRecyclerView.mOffsetX = (getHeightBefore(n) - k);
    }
    updateRenderStateToFillEnd(m, i);
    localObject = this.mRenderState;
    ((BaseLayoutManager.RenderState)localObject).mExtra = j;
    if (bool1) {
      ((BaseLayoutManager.RenderState)localObject).mCurrentPosition += this.mRenderState.mItemDirection;
    }
    fill(paramRecycler, this.mRenderState, paramState, false);
    m = this.mRenderState.mOffset;
    this.mRecyclerView.onItemsFill(m);
    this.mRecyclerView.checkNotifyFooterAppearWithFewChild(m);
    int i = m;
    j = k;
    if (getChildCount() > 0)
    {
      i = m;
      j = k;
      if (!this.mPreventFixGap)
      {
        i = m;
        j = k;
        if (this.mRecyclerView.mState.mCustomHeaderHeight == 0) {
          if (getHeight() <= this.mRecyclerView.mAdapter.getListTotalHeight())
          {
            i = fixLayoutStartGap(k, paramRecycler, paramState, true);
            m += i;
            n = fixLayoutEndGap(m, paramRecycler, paramState, false);
            j = k + i + n;
            i = m + n;
          }
          else
          {
            if (this.mRecyclerView.mOffsetY - this.mOrientationHelper.getStartAfterPadding() != 0)
            {
              if (!this.doNotCheckAgain)
              {
                this.doNotCheckAgain = true;
                scrollToPositionWidthOffsetInLayout(-this.mRecyclerView.mAdapter.getHeaderViewCount(), this.mOrientationHelper.getStartAfterPadding());
                i = m;
                j = k;
                break label1388;
              }
            }
            else
            {
              i = m;
              j = k;
              if (!this.doNotCheckAgain) {
                break label1388;
              }
            }
            this.doNotCheckAgain = false;
            j = k;
            i = m;
          }
        }
      }
    }
    label1388:
    if ((getChildCount() > 0) && (!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
    {
      localObject = paramRecycler.getScrapList();
      int i2 = ((List)localObject).size();
      int i3 = getPosition(getChildAt(0));
      m = 0;
      n = 0;
      k = 0;
      for (;;)
      {
        i1 = -1;
        if (m >= i2) {
          break;
        }
        RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)((List)localObject).get(m);
        if (localViewHolder.getPosition() < i3) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool1 != this.mShouldReverseLayout) {
          i1 = -1;
        } else {
          i1 = 1;
        }
        if (i1 == -1) {
          n += this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
        } else {
          k += this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
        }
        m += 1;
      }
      this.mRenderState.mScrapList = ((List)localObject);
      if (n > 0)
      {
        updateRenderStateToFillStart(getPosition(getChildClosestToStartByOrder()), j);
        localObject = this.mRenderState;
        ((BaseLayoutManager.RenderState)localObject).mExtra = n;
        ((BaseLayoutManager.RenderState)localObject).mAvailable = 0;
        m = ((BaseLayoutManager.RenderState)localObject).mCurrentPosition;
        if (this.mShouldReverseLayout) {
          j = 1;
        } else {
          j = -1;
        }
        ((BaseLayoutManager.RenderState)localObject).mCurrentPosition = (m + j);
        fill(paramRecycler, this.mRenderState, paramState, false);
      }
      if (k > 0)
      {
        updateRenderStateToFillEnd(getPosition(getChildClosestToEndByOrder()), i);
        localObject = this.mRenderState;
        ((BaseLayoutManager.RenderState)localObject).mExtra = k;
        ((BaseLayoutManager.RenderState)localObject).mAvailable = 0;
        j = ((BaseLayoutManager.RenderState)localObject).mCurrentPosition;
        if (this.mShouldReverseLayout) {
          i = i1;
        } else {
          i = 1;
        }
        ((BaseLayoutManager.RenderState)localObject).mCurrentPosition = (j + i);
        fill(paramRecycler, this.mRenderState, paramState, false);
      }
      this.mRenderState.mScrapList = null;
    }
    removeSuspentions();
    ensureSuspentionState();
    this.mPendingScrollPosition = -2147483648;
    this.mPendingScrollPositionOffset = -2147483648;
    this.mLastStackFromEnd = this.mStackFromEnd;
    this.mPendingGravity = 0;
    this.mPendingSavedState = null;
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
    BaseLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      return new BaseLayoutManager.SavedState(localSavedState);
    }
    localSavedState = new BaseLayoutManager.SavedState();
    int i;
    if (getChildCount() > 0)
    {
      boolean bool = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
      localSavedState.mAnchorLayoutFromEnd = bool;
      if (bool)
      {
        localSavedState.mAnchorOffset = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen()));
        localSavedState.mAnchorPosition = getPosition(getChildClosestToEndByOrder());
        break label145;
      }
      localSavedState.mAnchorPosition = getPosition(getChildClosestToStartByOrder());
      i = this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen()) - this.mOrientationHelper.getStartAfterPadding();
    }
    else
    {
      i = 0;
      localSavedState.mAnchorPosition = 0;
    }
    localSavedState.mAnchorOffset = i;
    label145:
    localSavedState.mStackFromEnd = this.mStackFromEnd;
    localSavedState.mReverseLayout = this.mReverseLayout;
    localSavedState.mOrientation = this.mOrientation;
    return localSavedState;
  }
  
  protected void recordItemSize(int paramInt, View paramView)
  {
    if ((this.mRecyclerView != null) && (this.mRecyclerView.getAdapter() != null) && ((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter)))
    {
      RecyclerAdapter localRecyclerAdapter = (RecyclerAdapter)this.mRecyclerView.getAdapter();
      if (localRecyclerAdapter.isAutoCalculateItemHeight())
      {
        int i = paramView.getMeasuredWidth();
        if (localRecyclerAdapter.mItemWidthList == null) {
          localRecyclerAdapter.mItemWidthList = new ArrayList(localRecyclerAdapter.getItemCount());
        }
        if (localRecyclerAdapter.mItemWidthList.size() > paramInt)
        {
          localRecyclerAdapter.mItemWidthList.set(paramInt, Integer.valueOf(i));
          return;
        }
        if (localRecyclerAdapter.mItemWidthList.size() == paramInt)
        {
          localRecyclerAdapter.mItemWidthList.add(Integer.valueOf(i));
          return;
        }
        paramView = new StringBuilder();
        paramView.append("recordItemSize with wrong index ");
        paramView.append(paramInt);
        paramView.append(", itemWidth ");
        paramView.append(i);
        paramView.append(", listSize ");
        paramView.append(localRecyclerAdapter.mItemWidthList.size());
        Log.e("LinearLayoutManager", paramView.toString());
      }
    }
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
    View localView = this.mCurrentSuspentionView;
    if ((localView != null) && (localView.getParent() == this.mRecyclerView))
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
      if (this.mRecyclerView.mOffsetY + paramInt < -this.mRecyclerView.getSpringBackMaxDistance()) {}
      int i;
      for (paramInt = -this.mRecyclerView.getSpringBackMaxDistance();; paramInt = this.mRecyclerView.mAdapter.getListTotalHeight() + this.mRecyclerView.getSpringBackMaxDistance())
      {
        i = paramInt - this.mRecyclerView.mOffsetY;
        break;
        i = paramInt;
        if (this.mRecyclerView.mOffsetY + paramInt <= this.mRecyclerView.mAdapter.getListTotalHeight() + this.mRecyclerView.getSpringBackMaxDistance()) {
          break;
        }
      }
      paramInt = this.mRecyclerView.mOffsetY;
      paramRecycler = this.mRecyclerView.mAdapter.getBeginPositionWithOffset(paramInt + i);
      this.mRecyclerView.mLayout.mPendingScrollPosition = paramRecycler[0];
      this.mRecyclerView.mLayout.mPendingScrollPositionOffset = paramRecycler[1];
      this.mRecyclerView.dispatchLayout();
      return Math.abs(i);
    }
    paramState.overscroll = true;
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    BaseLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if ((localSavedState != null) && (localSavedState.mOrientation != paramInt)) {
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
    BaseLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if ((localSavedState != null) && (localSavedState.mReverseLayout != paramBoolean)) {
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
    BaseLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if ((localSavedState != null) && (localSavedState.mStackFromEnd != paramBoolean)) {
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
    if ((paramInt != -2147483648) && (this.mRecyclerView.mRecycler != null))
    {
      if (this.mRecyclerView.isRepeatableSuspensionMode()) {
        localObject = this.mRecyclerView.mRecycler.getViewForPosition(paramInt);
      } else {
        localObject = this.mRecyclerView.mRecycler.getSuspendViewForPosition(paramInt);
      }
      if (localObject == null) {
        return;
      }
      measureChildWithMargins((View)localObject, 0, 0);
      layoutDecorated((View)localObject, 0, 0, ((View)localObject).getMeasuredWidth(), ((View)localObject).getMeasuredHeight());
      this.mRecyclerView.addAnimatingView((View)localObject, true);
      this.mCurrentSuspentionView = ((View)localObject);
      Object localObject = this.mRecyclerView.getChildViewHolder((View)localObject);
      if (((RecyclerViewBase.ViewHolder)localObject).isRecyclable()) {
        ((RecyclerViewBase.ViewHolder)localObject).setIsRecyclable(false);
      }
      return;
    }
    this.mCurrentSuspentionView = null;
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
    this.mRenderState.mExtra = getExtraLayoutSpace(paramState);
    BaseLayoutManager.RenderState localRenderState = this.mRenderState;
    localRenderState.mLayoutDirection = paramInt1;
    int i = -1;
    if (paramInt1 == 1)
    {
      if (!this.mShouldReverseLayout) {
        i = 1;
      }
      localRenderState.mItemDirection = i;
      this.mRenderState.mCurrentPosition = (getPosition(getChildClosestToEndByOrder()) + this.mRenderState.mItemDirection);
      this.mRenderState.mOffset = this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen());
      paramInt1 = this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen()) - this.mOrientationHelper.getEndAfterPadding();
    }
    else
    {
      if (this.mShouldReverseLayout) {
        i = 1;
      }
      localRenderState.mItemDirection = i;
      this.mRenderState.mCurrentPosition = (getPosition(getChildClosestToStartByOrder()) + this.mRenderState.mItemDirection);
      this.mRenderState.mOffset = this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen());
      paramInt1 = -this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen()) + this.mOrientationHelper.getStartAfterPadding();
    }
    localRenderState = this.mRenderState;
    localRenderState.mAvailable = paramInt2;
    if (paramBoolean) {
      localRenderState.mAvailable -= paramInt1;
    }
    this.mRenderState.overscroll = paramState.overscroll;
    this.mRenderState.mScrollingOffset = paramInt1;
  }
  
  protected void updateRenderStateToFillEnd(int paramInt1, int paramInt2)
  {
    this.mRenderState.mAvailable = (this.mOrientationHelper.getEndAfterPadding() - paramInt2);
    BaseLayoutManager.RenderState localRenderState = this.mRenderState;
    int i;
    if (this.mShouldReverseLayout) {
      i = -1;
    } else {
      i = 1;
    }
    localRenderState.mItemDirection = i;
    localRenderState = this.mRenderState;
    localRenderState.mCurrentPosition = paramInt1;
    localRenderState.mLayoutDirection = 1;
    localRenderState.mOffset = paramInt2;
    localRenderState.mScrollingOffset = -2147483648;
  }
  
  protected void updateRenderStateToFillStart(int paramInt1, int paramInt2)
  {
    this.mRenderState.mAvailable = (paramInt2 - this.mOrientationHelper.getStartAfterPadding());
    BaseLayoutManager.RenderState localRenderState = this.mRenderState;
    localRenderState.mCurrentPosition = paramInt1;
    if (this.mShouldReverseLayout) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    }
    localRenderState.mItemDirection = paramInt1;
    localRenderState = this.mRenderState;
    localRenderState.mLayoutDirection = -1;
    localRenderState.mOffset = paramInt2;
    localRenderState.mScrollingOffset = -2147483648;
  }
  
  public int validateAnchorPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt2;
  }
  
  protected void validateChildOrder()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("validating child count ");
    ((StringBuilder)localObject).append(getChildCount());
    Log.d("LinearLayoutManager", ((StringBuilder)localObject).toString());
    if (getChildCount() < 1) {
      return;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    int j = getPosition(getChildAt(0));
    int k = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
    int m;
    int n;
    if (this.mShouldReverseLayout)
    {
      i = 1;
      for (;;)
      {
        if (i >= getChildCount()) {
          return;
        }
        localObject = getChildAt(i);
        m = getPosition((View)localObject);
        n = this.mOrientationHelper.getDecoratedStart((View)localObject);
        if (m < j)
        {
          logChildren();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("detected invalid position. loc invalid? ");
          if (n < k) {
            bool1 = true;
          }
          ((StringBuilder)localObject).append(bool1);
          throw new RuntimeException(((StringBuilder)localObject).toString());
        }
        if (n > k) {
          break;
        }
        i += 1;
      }
      logChildren();
      throw new RuntimeException("detected invalid location");
    }
    int i = 1;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      m = getPosition((View)localObject);
      n = this.mOrientationHelper.getDecoratedStart((View)localObject);
      if (m < j)
      {
        logChildren();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("detected invalid position. loc invalid? ");
        bool1 = bool2;
        if (n < k) {
          bool1 = true;
        }
        ((StringBuilder)localObject).append(bool1);
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      if (n >= k)
      {
        i += 1;
      }
      else
      {
        logChildren();
        throw new RuntimeException("detected invalid location");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
 * JD-Core Version:    0.7.0.1
 */