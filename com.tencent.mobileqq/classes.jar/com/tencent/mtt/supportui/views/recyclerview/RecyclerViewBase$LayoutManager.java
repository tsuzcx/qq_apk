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
    int j = 1073741824;
    int i = Math.max(0, paramInt1 - paramInt2);
    if (paramBoolean) {
      if (paramInt3 >= 0)
      {
        paramInt1 = paramInt3;
        paramInt2 = j;
      }
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
      paramInt2 = 0;
      paramInt1 = 0;
      continue;
      paramInt2 = j;
      paramInt1 = paramInt3;
      if (paramInt3 < 0) {
        if (paramInt3 == -1)
        {
          paramInt1 = i;
          paramInt2 = j;
        }
        else if (paramInt3 == -2)
        {
          paramInt2 = -2147483648;
          paramInt1 = i;
        }
        else
        {
          paramInt2 = 0;
          paramInt1 = 0;
        }
      }
    }
  }
  
  public void addView(View paramView)
  {
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    if (this.mRecyclerView.mAnimatingViewIndex >= 0)
    {
      addView(paramView, this.mRecyclerView.mAnimatingViewIndex);
      return;
    }
    addView(paramView, -1);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (this.mRecyclerView == null) {}
    do
    {
      return;
      if (this.mRecyclerView.mAnimatingViewIndex >= 0)
      {
        if (paramInt > this.mRecyclerView.mAnimatingViewIndex) {
          throw new IndexOutOfBoundsException("index=" + paramInt + " count=" + this.mRecyclerView.mAnimatingViewIndex);
        }
        localObject = this.mRecyclerView;
        ((RecyclerViewBase)localObject).mAnimatingViewIndex += 1;
      }
      Object localObject = RecyclerViewBase.getChildViewHolderInt(paramView);
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
    } while ((this.mSmoothScroller == null) || (!this.mSmoothScroller.isRunning()));
    this.mSmoothScroller.onChildAttachedToWindow(paramView);
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
    if ((this.mRecyclerView != null) && (this.mRecyclerView.needAdvancedStopDetachChildView())) {}
    for (;;)
    {
      return;
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        View localView = getChildAt(i);
        detachViewAt(i);
        if ((localView instanceof RecyclerViewItem)) {
          paramRecycler.scrapView(localView);
        }
        i -= 1;
      }
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
    if (localObject == null) {}
    for (;;)
    {
      return;
      if (localObject == this.mRecyclerView.findFocus()) {
        this.mRecyclerView.clearChildFocus((View)localObject);
      }
      if ((localObject instanceof IRecyclerViewFooter)) {
        this.mRecyclerView.removeView((View)localObject);
      }
      while (this.mRecyclerView.mAnimatingViewIndex >= 0)
      {
        localObject = this.mRecyclerView;
        ((RecyclerViewBase)localObject).mAnimatingViewIndex -= 1;
        return;
        RecyclerViewBase.access$500(this.mRecyclerView, paramInt);
      }
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
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getChildAt(paramInt);
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
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getChildCount() - this.mRecyclerView.mNumAnimatingViews;
    }
    return 0;
  }
  
  public int getDecoratedBottom(View paramView)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    int i = paramView.getBottom();
    return localRect.bottom + i;
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
    int i = paramView.getMeasuredHeight();
    int j = localRect.top;
    return localRect.bottom + (i + j);
  }
  
  public int getDecoratedMeasuredWidth(View paramView)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    int i = paramView.getMeasuredWidth();
    int j = localRect.left;
    return localRect.right + (i + j);
  }
  
  public int getDecoratedRight(View paramView)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    int i = paramView.getRight();
    return localRect.right + i;
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
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getHeight();
    }
    return 0;
  }
  
  public int getItemCount()
  {
    if (this.mRecyclerView != null) {}
    for (RecyclerViewBase.Adapter localAdapter = this.mRecyclerView.getAdapter(); localAdapter != null; localAdapter = null) {
      return localAdapter.getItemCount();
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
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getPaddingBottom();
    }
    return 0;
  }
  
  public int getPaddingLeft()
  {
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getPaddingLeft();
    }
    return 0;
  }
  
  public int getPaddingRight()
  {
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getPaddingRight();
    }
    return 0;
  }
  
  public int getPaddingTop()
  {
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getPaddingTop();
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
    if ((paramView == null) || (paramView.getLayoutParams() == null)) {
      return -2147483648;
    }
    return ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).getViewPosition();
  }
  
  public int getWidth()
  {
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getWidth();
    }
    return 0;
  }
  
  public boolean hasFocus()
  {
    return (this.mRecyclerView != null) && (this.mRecyclerView.hasFocus());
  }
  
  public boolean isFocused()
  {
    return (this.mRecyclerView != null) && (this.mRecyclerView.isFocused());
  }
  
  public boolean isSmoothScrolling()
  {
    return (this.mSmoothScroller != null) && (this.mSmoothScroller.isRunning());
  }
  
  public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((RecyclerViewBase.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }
  
  public void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    int i = localRect.left;
    int j = localRect.right;
    int k = localRect.top;
    int m = localRect.bottom;
    paramView.measure(getChildMeasureSpec(getWidth(), i + j + paramInt1 + (getPaddingLeft() + getPaddingRight()), localLayoutParams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), m + k + paramInt2 + (getPaddingTop() + getPaddingBottom()), localLayoutParams.height, canScrollVertically()));
  }
  
  public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getLayoutParams() != null) {}
    for (RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();; localLayoutParams = generateDefaultLayoutParams())
    {
      Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
      int m = localRect.left;
      int n = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      int i1 = localLayoutParams.width;
      int k = localLayoutParams.height;
      paramInt1 = getChildMeasureSpec(getWidth(), m + n + paramInt1 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), i1, canScrollHorizontally());
      m = getHeight();
      n = getPaddingTop();
      i1 = getPaddingBottom();
      int i2 = localLayoutParams.topMargin;
      paramView.measure(paramInt1, getChildMeasureSpec(m, localLayoutParams.bottomMargin + (n + i1 + i2) + (j + i + paramInt2), k, canScrollVertically()));
      return;
    }
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.offsetChildrenHorizontal(paramInt);
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.offsetChildrenVertical(paramInt);
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
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (j)
    {
    default: 
      paramInt1 = getMinimumWidth();
    }
    switch (i)
    {
    default: 
      paramInt2 = getMinimumHeight();
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
    boolean bool = false;
    label194:
    label218:
    label225:
    label230:
    for (;;)
    {
      int i;
      int j;
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
          break label218;
        }
      }
      catch (StackOverflowError paramRecyclerViewBase)
      {
        return false;
      }
      if (paramBoolean)
      {
        paramRecyclerViewBase.scrollBy(i, j);
        if ((paramRecyclerViewBase.needNotifyFooter) && (!paramRecyclerViewBase.checkNotifyFooterOnRelease))
        {
          paramRecyclerViewBase.needNotifyFooter = false;
          paramRecyclerViewBase.mRecycler.notifyLastFooterAppeared();
        }
      }
      else
      {
        paramRecyclerViewBase.smoothScrollBy(i, j, false);
        continue;
        if (j == 0) {
          break label225;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label230;
        }
        if (j != 0)
        {
          break;
          bool = true;
        }
        return bool;
        i = k;
        break label194;
        j = m;
      }
    }
  }
  
  public void requestLayout()
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.requestLayout();
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
    if ((this.mSmoothScroller != null) && (paramSmoothScroller != this.mSmoothScroller) && (this.mSmoothScroller.isRunning())) {
      this.mSmoothScroller.stop();
    }
    this.mSmoothScroller = paramSmoothScroller;
    this.mSmoothScroller.start(this.mRecyclerView, this);
  }
  
  void stopSmoothScroller()
  {
    if (this.mSmoothScroller != null) {
      this.mSmoothScroller.stop();
    }
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
 * JD-Core Version:    0.7.0.1
 */