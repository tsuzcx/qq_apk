package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mtt.supportui.utils.ViewCompatTool;
import java.util.ArrayList;

public abstract class RecyclerViewBase$LayoutManager
{
  public static final int INVALID_OFFSET = -2147483648;
  public int mPendingScrollPosition = -2147483648;
  protected int mPendingScrollPositionOffset = -2147483648;
  public boolean mPreventFixGap = false;
  public RecyclerViewBase mRecyclerView;
  public RecyclerViewBase.SmoothScroller mSmoothScroller;
  
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = 0;
    paramInt1 = Math.max(0, paramInt1 - paramInt2);
    if (paramBoolean) {
      if (paramInt3 >= 0) {
        break label34;
      }
    }
    label34:
    do
    {
      paramInt1 = 0;
      paramInt2 = i;
      break;
      if (paramInt3 >= 0) {
        paramInt1 = paramInt3;
      }
      while (paramInt3 == -1)
      {
        paramInt2 = 1073741824;
        break;
      }
    } while (paramInt3 != -2);
    paramInt2 = -2147483648;
    return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
  }
  
  public void addView(View paramView)
  {
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    int i;
    if (this.mRecyclerView.mAnimatingViewIndex >= 0) {
      i = this.mRecyclerView.mAnimatingViewIndex;
    } else {
      i = -1;
    }
    addView(paramView, i);
  }
  
  public void addView(View paramView, int paramInt)
  {
    Object localObject = this.mRecyclerView;
    if (localObject == null) {
      return;
    }
    if (((RecyclerViewBase)localObject).mAnimatingViewIndex >= 0) {
      if (paramInt <= this.mRecyclerView.mAnimatingViewIndex)
      {
        localObject = this.mRecyclerView;
        ((RecyclerViewBase)localObject).mAnimatingViewIndex += 1;
      }
      else
      {
        paramView = new StringBuilder();
        paramView.append("index=");
        paramView.append(paramInt);
        paramView.append(" count=");
        paramView.append(this.mRecyclerView.mAnimatingViewIndex);
        throw new IndexOutOfBoundsException(paramView.toString());
      }
    }
    localObject = RecyclerViewBase.getChildViewHolderInt(paramView);
    if (((RecyclerViewBase.ViewHolder)localObject).isScrap())
    {
      ((RecyclerViewBase.ViewHolder)localObject).unScrap();
      RecyclerViewBase.access$300(this.mRecyclerView, paramView, paramInt, paramView.getLayoutParams());
      return;
    }
    this.mRecyclerView.addView(paramView, paramInt);
    ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mInsetsDirty = true;
    localObject = this.mRecyclerView.getAdapter();
    if (localObject != null) {
      ((RecyclerViewBase.Adapter)localObject).onViewAttachedToWindow(RecyclerViewBase.getChildViewHolderInt(paramView));
    }
    this.mRecyclerView.onChildAttachedToWindow(paramView);
    localObject = this.mSmoothScroller;
    if ((localObject != null) && (((RecyclerViewBase.SmoothScroller)localObject).isRunning())) {
      this.mSmoothScroller.onChildAttachedToWindow(paramView);
    }
  }
  
  public void attachView(View paramView)
  {
    attachView(paramView, -1);
  }
  
  public void attachView(View paramView, int paramInt)
  {
    attachView(paramView, paramInt, (RecyclerViewBase.LayoutParams)paramView.getLayoutParams());
  }
  
  public void attachView(View paramView, int paramInt, RecyclerViewBase.LayoutParams paramLayoutParams)
  {
    RecyclerViewBase.access$600(this.mRecyclerView, paramView, paramInt, paramLayoutParams);
    if (this.mRecyclerView.mAnimatingViewIndex >= 0)
    {
      paramView = this.mRecyclerView;
      paramView.mAnimatingViewIndex += 1;
    }
  }
  
  public void calculateOffsetMap(SparseIntArray paramSparseIntArray, int paramInt) {}
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
  
  public boolean canScrollVertically()
  {
    return false;
  }
  
  public boolean checkLayoutParams(RecyclerViewBase.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams != null;
  }
  
  public void clear() {}
  
  public int computeHorizontalScrollExtent(RecyclerViewBase.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollOffset(RecyclerViewBase.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollRange(RecyclerViewBase.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollExtent(RecyclerViewBase.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollOffset(RecyclerViewBase.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollRange(RecyclerViewBase.State paramState)
  {
    return 0;
  }
  
  public void detachAndScrapAttachedViews(RecyclerViewBase.Recycler paramRecycler)
  {
    Object localObject = this.mRecyclerView;
    if ((localObject != null) && (((RecyclerViewBase)localObject).needAdvancedStopDetachChildView())) {
      return;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject = getChildAt(i);
      detachViewAt(i);
      if ((localObject instanceof RecyclerViewItem)) {
        paramRecycler.scrapView((View)localObject);
      }
      i -= 1;
    }
  }
  
  public void detachAndScrapView(View paramView, RecyclerViewBase.Recycler paramRecycler)
  {
    detachView(paramView);
    paramRecycler.scrapView(paramView);
  }
  
  public void detachAndScrapViewAt(int paramInt, RecyclerViewBase.Recycler paramRecycler)
  {
    View localView = getChildAt(paramInt);
    detachViewAt(paramInt);
    paramRecycler.scrapView(localView);
  }
  
  public void detachView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (paramView == this.mRecyclerView.findFocus()) {
      this.mRecyclerView.clearChildFocus(paramView);
    }
    if (paramView.hasFocus()) {
      paramView.clearFocus();
    }
    RecyclerViewBase.access$400(this.mRecyclerView, paramView);
  }
  
  public void detachViewAt(int paramInt)
  {
    Object localObject = this.mRecyclerView.getChildAt(paramInt);
    if (localObject == null) {
      return;
    }
    if (localObject == this.mRecyclerView.findFocus()) {
      this.mRecyclerView.clearChildFocus((View)localObject);
    }
    if ((localObject instanceof IRecyclerViewFooter)) {
      this.mRecyclerView.removeView((View)localObject);
    } else {
      RecyclerViewBase.access$500(this.mRecyclerView, paramInt);
    }
    if (this.mRecyclerView.mAnimatingViewIndex >= 0)
    {
      localObject = this.mRecyclerView;
      ((RecyclerViewBase)localObject).mAnimatingViewIndex -= 1;
    }
  }
  
  public View findViewByPosition(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (getPosition(localView) == paramInt) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public abstract RecyclerViewBase.LayoutParams generateDefaultLayoutParams();
  
  public RecyclerViewBase.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerViewBase.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerViewBase.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof RecyclerViewBase.LayoutParams)) {
      return new RecyclerViewBase.LayoutParams((RecyclerViewBase.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new RecyclerViewBase.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new RecyclerViewBase.LayoutParams(paramLayoutParams);
  }
  
  public View getChildAt(int paramInt)
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      return localRecyclerViewBase.getChildAt(paramInt);
    }
    return null;
  }
  
  public View getChildClosestToEndByOrder()
  {
    return null;
  }
  
  public View getChildClosestToEndInScreen()
  {
    return null;
  }
  
  public View getChildClosestToStartByOrder()
  {
    return null;
  }
  
  public View getChildClosestToStartInScreen()
  {
    return null;
  }
  
  public int getChildCount()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      return localRecyclerViewBase.getChildCount() - this.mRecyclerView.mNumAnimatingViews;
    }
    return 0;
  }
  
  public int getDecoratedBottom(View paramView)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getBottom() + localRect.bottom;
  }
  
  public int getDecoratedEnd(View paramView)
  {
    return 0;
  }
  
  public int getDecoratedLeft(View paramView)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getLeft() - localRect.left;
  }
  
  public int getDecoratedMeasuredHeight(View paramView)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getMeasuredHeight() + localRect.top + localRect.bottom;
  }
  
  public int getDecoratedMeasuredWidth(View paramView)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getMeasuredWidth() + localRect.left + localRect.right;
  }
  
  public int getDecoratedRight(View paramView)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getRight() + localRect.right;
  }
  
  public int getDecoratedStart(View paramView)
  {
    return 0;
  }
  
  public int getDecoratedTop(View paramView)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getTop() - localRect.top;
  }
  
  public View getFirstItemAfterOffset(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (getDecoratedStart(localView) > paramInt) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public View getFirstItemBeforeOffset(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (getDecoratedStart(localView) < paramInt) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public int getHeight()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      return localRecyclerViewBase.getHeight();
    }
    return 0;
  }
  
  public int getItemCount()
  {
    Object localObject = this.mRecyclerView;
    if (localObject != null) {
      localObject = ((RecyclerViewBase)localObject).getAdapter();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return ((RecyclerViewBase.Adapter)localObject).getItemCount();
    }
    return 0;
  }
  
  public int getLayoutType()
  {
    return 1;
  }
  
  public int getMinimumHeight()
  {
    return ViewCompatTool.getMinimumHeight(this.mRecyclerView);
  }
  
  public int getMinimumWidth()
  {
    return ViewCompatTool.getMinimumWidth(this.mRecyclerView);
  }
  
  public int getPaddingBottom()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      return localRecyclerViewBase.getPaddingBottom();
    }
    return 0;
  }
  
  public int getPaddingLeft()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      return localRecyclerViewBase.getPaddingLeft();
    }
    return 0;
  }
  
  public int getPaddingRight()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      return localRecyclerViewBase.getPaddingRight();
    }
    return 0;
  }
  
  public int getPaddingTop()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      return localRecyclerViewBase.getPaddingTop();
    }
    return 0;
  }
  
  public int getPendingOffset()
  {
    return 0;
  }
  
  public int getPendingPosition()
  {
    return 0;
  }
  
  public int getPosition(View paramView)
  {
    if ((paramView != null) && (paramView.getLayoutParams() != null)) {
      return ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).getViewPosition();
    }
    return -2147483648;
  }
  
  public int getTotalHeight()
  {
    return -2147483648;
  }
  
  public int getWidth()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      return localRecyclerViewBase.getWidth();
    }
    return 0;
  }
  
  public boolean hasFocus()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    return (localRecyclerViewBase != null) && (localRecyclerViewBase.hasFocus());
  }
  
  public boolean isFocused()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    return (localRecyclerViewBase != null) && (localRecyclerViewBase.isFocused());
  }
  
  public boolean isSmoothScrolling()
  {
    RecyclerViewBase.SmoothScroller localSmoothScroller = this.mSmoothScroller;
    return (localSmoothScroller != null) && (localSmoothScroller.isRunning());
  }
  
  public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    paramView.layout(paramInt1 + localRect.left, paramInt2 + localRect.top, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }
  
  public void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    int i = localRect.left;
    int j = localRect.right;
    int k = localRect.top;
    int m = localRect.bottom;
    paramView.measure(getChildMeasureSpec(getWidth(), getPaddingLeft() + getPaddingRight() + (paramInt1 + (i + j)), localLayoutParams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + (paramInt2 + (k + m)), localLayoutParams.height, canScrollVertically()));
  }
  
  public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    RecyclerViewBase.LayoutParams localLayoutParams;
    if (paramView.getLayoutParams() != null) {
      localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    } else {
      localLayoutParams = generateDefaultLayoutParams();
    }
    Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    int i = localRect.left;
    int j = localRect.right;
    int k = localRect.top;
    int m = localRect.bottom;
    int n = localLayoutParams.width;
    int i1 = localLayoutParams.height;
    paramView.measure(getChildMeasureSpec(getWidth(), getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + (paramInt1 + (i + j)), n, canScrollHorizontally()), getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + (paramInt2 + (k + m)), i1, canScrollVertically()));
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      localRecyclerViewBase.offsetChildrenHorizontal(paramInt);
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      localRecyclerViewBase.offsetChildrenVertical(paramInt);
    }
  }
  
  public void onAdapterChanged(RecyclerViewBase.Adapter paramAdapter1, RecyclerViewBase.Adapter paramAdapter2) {}
  
  public boolean onAddFocusables(RecyclerViewBase paramRecyclerViewBase, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onAttachedToWindow(RecyclerViewBase paramRecyclerViewBase) {}
  
  public RecyclerViewBase.LayoutParams onCreateItemLayoutParams(RecyclerView.ViewHolderWrapper paramViewHolderWrapper, int paramInt1, int paramInt2, int paramInt3)
  {
    return new RecyclerViewBase.LayoutParams(-2, -2);
  }
  
  public void onDetachedFromWindow(RecyclerViewBase paramRecyclerViewBase) {}
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    return null;
  }
  
  public View onInterceptFocusSearch(View paramView, int paramInt)
  {
    return null;
  }
  
  public void onItemsAdded(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2) {}
  
  public void onItemsRemoved(RecyclerViewBase paramRecyclerViewBase, int paramInt1, int paramInt2) {}
  
  public void onLayoutChildren(RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState) {}
  
  public void onMeasure(RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState, int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = j;
    if (m != -2147483648)
    {
      paramInt1 = j;
      if (m != 1073741824) {
        paramInt1 = getMinimumWidth();
      }
    }
    paramInt2 = i;
    if (k != -2147483648)
    {
      paramInt2 = i;
      if (k != 1073741824) {
        paramInt2 = getMinimumHeight();
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onRequestChildFocus(RecyclerViewBase paramRecyclerViewBase, View paramView1, View paramView2)
  {
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  void onSmoothScrollerStopped(RecyclerViewBase.SmoothScroller paramSmoothScroller)
  {
    if (this.mSmoothScroller == paramSmoothScroller) {
      this.mSmoothScroller = null;
    }
  }
  
  public void removeAllViews()
  {
    Object localObject = this.mRecyclerView.getAdapter();
    int j = this.mRecyclerView.getChildCount() - this.mRecyclerView.mNumAnimatingViews;
    int i = 0;
    while (i < j)
    {
      View localView = this.mRecyclerView.getChildAt(i);
      if (localObject != null) {
        ((RecyclerViewBase.Adapter)localObject).onViewDetachedFromWindow(RecyclerViewBase.getChildViewHolderInt(localView));
      }
      this.mRecyclerView.onChildDetachedFromWindow(localView);
      i += 1;
    }
    i = j - 1;
    while (i >= 0)
    {
      this.mRecyclerView.removeViewAt(i);
      if (this.mRecyclerView.mAnimatingViewIndex >= 0)
      {
        localObject = this.mRecyclerView;
        ((RecyclerViewBase)localObject).mAnimatingViewIndex -= 1;
      }
      i -= 1;
    }
  }
  
  void removeAndRecycleAllViews(RecyclerViewBase.Recycler paramRecycler)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      removeAndRecycleViewAt(i, paramRecycler);
      i -= 1;
    }
  }
  
  protected void removeAndRecycleScrapInt(RecyclerViewBase.Recycler paramRecycler, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = paramRecycler.getScrapCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramRecycler.getScrapViewAt(i);
      if ((localView instanceof RecyclerViewItem))
      {
        if (paramBoolean1) {
          RecyclerViewBase.access$800(this.mRecyclerView, localView, false);
        }
        if (paramBoolean2) {
          paramRecycler.quickRecycleScrapView(localView);
        }
      }
      i += 1;
    }
    paramRecycler.clearScrap();
    if ((paramBoolean1) && (j > 0)) {
      this.mRecyclerView.invalidate();
    }
  }
  
  public void removeAndRecycleView(View paramView, RecyclerViewBase.Recycler paramRecycler)
  {
    removeView(paramView);
    paramRecycler.recycleView(paramView);
  }
  
  public void removeAndRecycleViewAt(int paramInt, RecyclerViewBase.Recycler paramRecycler)
  {
    View localView = getChildAt(paramInt);
    removeViewAt(paramInt);
    paramRecycler.recycleView(localView);
  }
  
  public void removeDetachedView(View paramView)
  {
    RecyclerViewBase.access$700(this.mRecyclerView, paramView, false);
  }
  
  public void removeView(View paramView)
  {
    RecyclerViewBase.Adapter localAdapter = this.mRecyclerView.getAdapter();
    if (localAdapter != null) {
      localAdapter.onViewDetachedFromWindow(RecyclerViewBase.getChildViewHolderInt(paramView));
    }
    this.mRecyclerView.onChildDetachedFromWindow(paramView);
    this.mRecyclerView.removeView(paramView);
    if (this.mRecyclerView.mAnimatingViewIndex >= 0)
    {
      paramView = this.mRecyclerView;
      paramView.mAnimatingViewIndex -= 1;
    }
  }
  
  public void removeViewAt(int paramInt)
  {
    Object localObject1 = this.mRecyclerView.getChildAt(paramInt);
    if (localObject1 != null)
    {
      Object localObject2 = ((View)localObject1).getLayoutParams();
      if ((localObject2 != null) && ((localObject2 instanceof RecyclerViewBase.LayoutParams)))
      {
        localObject2 = (RecyclerViewBase.LayoutParams)localObject2;
        if (((RecyclerViewBase.LayoutParams)localObject2).mViewHolder != null)
        {
          localObject2 = ((RecyclerViewBase.LayoutParams)localObject2).mViewHolder;
          if (((RecyclerViewBase.ViewHolder)localObject2).mViewType == 2)
          {
            RecyclerViewBase.State localState = this.mRecyclerView.mState;
            localState.mFooterCountInScreen -= 1;
          }
          if (((RecyclerViewBase.ViewHolder)localObject2).mViewType == 1)
          {
            localObject2 = this.mRecyclerView.mState;
            ((RecyclerViewBase.State)localObject2).mHeaderCountInScreen -= 1;
          }
        }
      }
      localObject2 = this.mRecyclerView.getAdapter();
      if (localObject2 != null) {
        ((RecyclerViewBase.Adapter)localObject2).onViewDetachedFromWindow(RecyclerViewBase.getChildViewHolderInt((View)localObject1));
      }
      this.mRecyclerView.onChildDetachedFromWindow((View)localObject1);
      this.mRecyclerView.removeViewAt(paramInt);
      if (this.mRecyclerView.mAnimatingViewIndex >= 0)
      {
        localObject1 = this.mRecyclerView;
        ((RecyclerViewBase)localObject1).mAnimatingViewIndex -= 1;
      }
    }
  }
  
  public boolean requestChildRectangleOnScreen(RecyclerViewBase paramRecyclerViewBase, View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i;
    int j;
    label190:
    do
    {
      int k;
      int m;
      try
      {
        i = getPaddingLeft();
        j = getPaddingTop();
        k = getWidth();
        int i3 = getPaddingRight();
        m = getHeight();
        int n = getPaddingBottom();
        int i4 = paramView.getLeft() + paramRect.left;
        int i1 = paramView.getTop() + paramRect.top;
        int i5 = paramRect.right;
        int i2 = paramRect.bottom;
        i = Math.min(0, i4 - i);
        j = Math.min(0, i1 - j);
        k = Math.max(0, i5 + i4 - (k - i3));
        m = Math.max(0, i2 + i1 - (m - n));
        if (i == 0) {
          break label190;
        }
      }
      catch (StackOverflowError paramRecyclerViewBase)
      {
        return false;
      }
      if (paramBoolean) {
        paramRecyclerViewBase.scrollBy(i, j);
      } else {
        paramRecyclerViewBase.smoothScrollBy(i, j, false);
      }
      if ((paramRecyclerViewBase.needNotifyFooter) && (!paramRecyclerViewBase.checkNotifyFooterOnRelease))
      {
        paramRecyclerViewBase.needNotifyFooter = false;
        paramRecyclerViewBase.mRecycler.notifyLastFooterAppeared();
      }
      return true;
      i = k;
      if (j == 0) {
        j = m;
      }
    } while ((i != 0) || (j != 0));
    return false;
  }
  
  public void requestLayout()
  {
    RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
    if (localRecyclerViewBase != null) {
      localRecyclerViewBase.requestLayout();
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    return 0;
  }
  
  public void scrollToPosition(int paramInt) {}
  
  public void scrollToPositionWidthGravity(int paramInt1, int paramInt2, int paramInt3) {}
  
  public abstract void scrollToPositionWithOffset(int paramInt1, int paramInt2);
  
  public int scrollVerticallyBy(int paramInt, RecyclerViewBase.Recycler paramRecycler, RecyclerViewBase.State paramState)
  {
    return 0;
  }
  
  public void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    RecyclerViewBase.access$900(this.mRecyclerView, paramInt1, paramInt2);
  }
  
  public void smoothScrollToPosition(RecyclerViewBase paramRecyclerViewBase, RecyclerViewBase.State paramState, int paramInt) {}
  
  public void startSmoothScroll(RecyclerViewBase.SmoothScroller paramSmoothScroller)
  {
    RecyclerViewBase.SmoothScroller localSmoothScroller = this.mSmoothScroller;
    if ((localSmoothScroller != null) && (paramSmoothScroller != localSmoothScroller) && (localSmoothScroller.isRunning())) {
      this.mSmoothScroller.stop();
    }
    this.mSmoothScroller = paramSmoothScroller;
    this.mSmoothScroller.start(this.mRecyclerView, this);
  }
  
  void stopSmoothScroller()
  {
    RecyclerViewBase.SmoothScroller localSmoothScroller = this.mSmoothScroller;
    if (localSmoothScroller != null) {
      localSmoothScroller.stop();
    }
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
 * JD-Core Version:    0.7.0.1
 */