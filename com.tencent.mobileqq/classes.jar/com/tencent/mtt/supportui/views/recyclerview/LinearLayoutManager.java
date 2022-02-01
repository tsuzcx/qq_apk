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
      int j = getItemCount();
      int i = 0;
      if (i < j)
      {
        paramSparseIntArray.append(i, paramInt);
        if (this.mRecyclerView.mLayout.canScrollHorizontally()) {}
        for (paramInt = ((RecyclerAdapter)this.mRecyclerView.getAdapter()).getItemWidth(i) + paramInt + this.mRecyclerView.getAdapter().getItemMaigin(0, i) + this.mRecyclerView.getAdapter().getItemMaigin(2, i);; paramInt = ((RecyclerAdapter)this.mRecyclerView.getAdapter()).getItemHeight(i) + paramInt + this.mRecyclerView.getAdapter().getItemMaigin(1, i) + this.mRecyclerView.getAdapter().getItemMaigin(3, i))
        {
          i += 1;
          break;
        }
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
    int j = paramRenderState.mAvailable + paramRenderState.mExtra;
    if (j > 0)
    {
      if (paramRenderState.hasMore(paramState) != 1) {
        break label151;
      }
      j = i1 - paramRenderState.mAvailable + j;
      if (paramRenderState.overscroll) {
        break label97;
      }
    }
    label85:
    label97:
    View localView;
    label151:
    do
    {
      i = i1 - paramRenderState.mAvailable;
      do
      {
        do
        {
          do
          {
            return i;
            i = j;
          } while (paramRenderState.mItemDirection <= 0);
          i = j;
        } while (this.mEndReached);
        this.mEndReached = true;
        i = j;
      } while (this.mRecyclerView.getAdapter() == null);
      this.mRecyclerView.getAdapter().notifyEndReached();
      return j;
      this.mEndReached = false;
      i = paramRenderState.mCurrentPosition;
      localView = getNextView(paramRecycler, paramRenderState, paramState);
    } while (localView == null);
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)localView.getLayoutParams();
    boolean bool1;
    label221:
    label234:
    int i2;
    int k;
    label393:
    int m;
    int n;
    if ((!localLayoutParams.isItemRemoved()) && (this.mRenderState.mScrapList == null))
    {
      boolean bool2 = this.mShouldReverseLayout;
      if (paramRenderState.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label585;
        }
        addView(localView);
      }
    }
    else
    {
      measureChildWithMargins(localView, 0, 0);
      if (((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter)) && (((RecyclerAdapter)this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight()))
      {
        if (((localView instanceof RecyclerViewItem)) && (((RecyclerViewItem)localView).getChildCount() > 0))
        {
          recordItemSize(i, ((RecyclerViewItem)localView).getChildAt(0));
          ((RecyclerAdapter)this.mRecyclerView.getAdapter()).forceUpdateOffsetMap();
        }
        if (paramRenderState.hasMore(paramState) == 1) {
          this.mRecyclerView.getAdapter().getTotalHeight();
        }
      }
      i2 = this.mOrientationHelper.getDecoratedMeasurement(localView);
      if (getOrientation() != 1) {
        break label642;
      }
      if (!isLayoutRTL()) {
        break label595;
      }
      i = getWidth() - getPaddingRight();
      k = i - this.mOrientationHelper.getDecoratedMeasurementInOther(localView);
      if (paramRenderState.mLayoutDirection != -1) {
        break label620;
      }
      m = paramRenderState.mOffset;
      n = paramRenderState.mOffset - i2;
      label416:
      layoutDecorated(localView, k + localLayoutParams.leftMargin, n + localLayoutParams.topMargin, i - localLayoutParams.rightMargin, m - localLayoutParams.bottomMargin);
      paramRenderState.mOffset += paramRenderState.mLayoutDirection * i2;
      if (localLayoutParams.isItemRemoved()) {
        break label712;
      }
      paramRenderState.mAvailable -= i2;
    }
    label642:
    label712:
    for (int i = j - i2;; i = j)
    {
      if (paramRenderState.mScrollingOffset != -2147483648)
      {
        paramRenderState.mScrollingOffset += i2;
        if (paramRenderState.mAvailable < 0) {
          paramRenderState.mScrollingOffset += paramRenderState.mAvailable;
        }
        recycleByRenderState(paramRecycler, paramRenderState);
      }
      if (((paramBoolean) && (localView.isFocusable())) || ((paramState != null) && (paramState.getTargetScrollPosition() == getPosition(localView)))) {
        break label85;
      }
      j = i;
      break;
      bool1 = false;
      break label221;
      label585:
      addView(localView, 0);
      break label234;
      label595:
      k = getPaddingLeft();
      i = this.mOrientationHelper.getDecoratedMeasurementInOther(localView) + k;
      break label393;
      label620:
      n = paramRenderState.mOffset;
      m = paramRenderState.mOffset;
      m += i2;
      break label416;
      n = getPaddingTop();
      m = this.mOrientationHelper.getDecoratedMeasurementInOther(localView) + n;
      if (paramRenderState.mLayoutDirection == -1)
      {
        i = paramRenderState.mOffset;
        k = paramRenderState.mOffset - i2;
        break label416;
      }
      k = paramRenderState.mOffset;
      i = paramRenderState.mOffset;
      i += i2;
      break label416;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */