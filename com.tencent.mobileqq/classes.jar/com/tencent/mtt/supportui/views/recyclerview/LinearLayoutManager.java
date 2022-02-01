package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;

public class LinearLayoutManager
  extends BaseLayoutManager
{
  private static final String TAG = "LinearLayoutManager";
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, false);
  }
  
  public void calculateOffsetMap(SparseIntArray paramSparseIntArray, int paramInt)
  {
    if (this.mRecyclerView.mLayoutType == 1)
    {
      int k = getItemCount();
      int i = paramInt;
      paramInt = 0;
      while (paramInt < k)
      {
        paramSparseIntArray.append(paramInt, i);
        RecyclerViewBase.Adapter localAdapter;
        int j;
        if (this.mRecyclerView.mLayout.canScrollHorizontally())
        {
          i = i + ((RecyclerAdapter)this.mRecyclerView.getAdapter()).getItemWidth(paramInt) + this.mRecyclerView.getAdapter().getItemMaigin(0, paramInt);
          localAdapter = this.mRecyclerView.getAdapter();
          j = 2;
        }
        else
        {
          i = i + ((RecyclerAdapter)this.mRecyclerView.getAdapter()).getItemHeight(paramInt) + this.mRecyclerView.getAdapter().getItemMaigin(1, paramInt);
          localAdapter = this.mRecyclerView.getAdapter();
          j = 3;
        }
        i += localAdapter.getItemMaigin(j, paramInt);
        paramInt += 1;
      }
    }
  }
  
  protected int fill(RecyclerViewBase.Recycler paramRecycler, BaseLayoutManager.RenderState paramRenderState, RecyclerViewBase.State paramState, boolean paramBoolean)
  {
    int i1 = paramRenderState.mAvailable;
    if (paramRenderState.mScrollingOffset != -2147483648)
    {
      if (paramRenderState.mAvailable < 0) {
        paramRenderState.mScrollingOffset += paramRenderState.mAvailable;
      }
      recycleByRenderState(paramRecycler, paramRenderState);
    }
    int n = paramRenderState.mAvailable + paramRenderState.mExtra;
    View localView;
    do
    {
      int i;
      do
      {
        if (n <= 0) {
          break;
        }
        if (paramRenderState.hasMore(paramState) == 1)
        {
          i = paramRenderState.mAvailable;
          if (!paramRenderState.overscroll) {
            break;
          }
          if ((paramRenderState.mItemDirection > 0) && (!this.mEndReached))
          {
            this.mEndReached = true;
            if (this.mRecyclerView.getAdapter() != null) {
              this.mRecyclerView.getAdapter().notifyEndReached();
            }
          }
          return i1 - i + n;
        }
        this.mEndReached = false;
        i = paramRenderState.mCurrentPosition;
        localView = getNextView(paramRecycler, paramRenderState, paramState);
        if (localView == null) {
          break;
        }
        RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.isItemRemoved()) && (this.mRenderState.mScrapList == null))
        {
          boolean bool2 = this.mShouldReverseLayout;
          boolean bool1;
          if (paramRenderState.mLayoutDirection == -1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (bool2 == bool1) {
            addView(localView);
          } else {
            addView(localView, 0);
          }
        }
        measureChildWithMargins(localView, 0, 0);
        if (((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter)) && (((RecyclerAdapter)this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight()))
        {
          if ((localView instanceof RecyclerViewItem))
          {
            RecyclerViewItem localRecyclerViewItem = (RecyclerViewItem)localView;
            if (localRecyclerViewItem.getChildCount() > 0)
            {
              recordItemSize(i, localRecyclerViewItem.getChildAt(0));
              ((RecyclerAdapter)this.mRecyclerView.getAdapter()).forceUpdateOffsetMap();
            }
          }
          if (paramRenderState.hasMore(paramState) == 1) {
            this.mRecyclerView.getAdapter().getTotalHeight();
          }
        }
        int i2 = this.mOrientationHelper.getDecoratedMeasurement(localView);
        int j;
        int k;
        int m;
        if (getOrientation() == 1)
        {
          if (isLayoutRTL())
          {
            i = getWidth() - getPaddingRight();
            j = i - this.mOrientationHelper.getDecoratedMeasurementInOther(localView);
          }
          else
          {
            j = getPaddingLeft();
            i = this.mOrientationHelper.getDecoratedMeasurementInOther(localView) + j;
          }
          if (paramRenderState.mLayoutDirection == -1)
          {
            k = paramRenderState.mOffset;
            m = paramRenderState.mOffset - i2;
          }
          else
          {
            m = paramRenderState.mOffset;
            k = paramRenderState.mOffset + i2;
          }
        }
        else
        {
          m = getPaddingTop();
          k = m + this.mOrientationHelper.getDecoratedMeasurementInOther(localView);
          if (paramRenderState.mLayoutDirection == -1)
          {
            i = paramRenderState.mOffset;
            j = paramRenderState.mOffset - i2;
          }
          else
          {
            j = paramRenderState.mOffset;
            i = paramRenderState.mOffset + i2;
          }
        }
        layoutDecorated(localView, localLayoutParams.leftMargin + j, m + localLayoutParams.topMargin, i - localLayoutParams.rightMargin, k - localLayoutParams.bottomMargin);
        paramRenderState.mOffset += paramRenderState.mLayoutDirection * i2;
        i = n;
        if (!localLayoutParams.isItemRemoved())
        {
          paramRenderState.mAvailable -= i2;
          i = n - i2;
        }
        if (paramRenderState.mScrollingOffset != -2147483648)
        {
          paramRenderState.mScrollingOffset += i2;
          if (paramRenderState.mAvailable < 0) {
            paramRenderState.mScrollingOffset += paramRenderState.mAvailable;
          }
          recycleByRenderState(paramRecycler, paramRenderState);
        }
        if ((paramBoolean) && (localView.isFocusable())) {
          break;
        }
        n = i;
      } while (paramState == null);
      n = i;
    } while (paramState.getTargetScrollPosition() != getPosition(localView));
    return i1 - paramRenderState.mAvailable;
  }
  
  public int getLayoutType()
  {
    return 1;
  }
  
  protected void handleRecordItemHeightChange(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mRecyclerView != null) && (this.mRecyclerView.getFirstVisibleItemPos() >= paramInt1) && (this.mRecyclerView.mOffsetY > 0))
    {
      RecyclerViewBase localRecyclerViewBase = this.mRecyclerView;
      localRecyclerViewBase.mOffsetY -= paramInt2;
      localRecyclerViewBase = this.mRecyclerView;
      localRecyclerViewBase.mOffsetY += paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */