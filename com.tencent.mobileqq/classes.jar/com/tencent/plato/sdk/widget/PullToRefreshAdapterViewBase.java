package com.tencent.plato.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView>
  extends PullToRefreshBase<T>
  implements AbsListView.OnScrollListener
{
  private boolean mLastItemVisible;
  private PullToRefreshBase.OnLastItemVisibleListener mOnLastItemVisibleListener;
  private AbsListView.OnScrollListener mOnScrollListener;
  
  public PullToRefreshAdapterViewBase(Context paramContext)
  {
    super(paramContext);
    ((AbsListView)this.mRefreshableView).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((AbsListView)this.mRefreshableView).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
    ((AbsListView)this.mRefreshableView).setOnScrollListener(this);
  }
  
  private boolean isFirstItemVisible()
  {
    Object localObject = ((AbsListView)this.mRefreshableView).getAdapter();
    if ((localObject == null) || (((Adapter)localObject).isEmpty())) {
      return true;
    }
    if (((AbsListView)this.mRefreshableView).getFirstVisiblePosition() <= 1)
    {
      localObject = ((AbsListView)this.mRefreshableView).getChildAt(0);
      if (localObject != null) {
        return ((View)localObject).getTop() >= ((AbsListView)this.mRefreshableView).getTop();
      }
    }
    return false;
  }
  
  private boolean isLastItemVisible()
  {
    Object localObject = ((AbsListView)this.mRefreshableView).getAdapter();
    if ((localObject == null) || (((Adapter)localObject).isEmpty())) {
      return true;
    }
    int j = ((AbsListView)this.mRefreshableView).getCount();
    int i = ((AbsListView)this.mRefreshableView).getLastVisiblePosition();
    if (i >= j - 1 - 1)
    {
      j = ((AbsListView)this.mRefreshableView).getFirstVisiblePosition();
      localObject = ((AbsListView)this.mRefreshableView).getChildAt(i - j);
      if (localObject != null) {
        return ((View)localObject).getBottom() <= ((AbsListView)this.mRefreshableView).getBottom();
      }
    }
    return false;
  }
  
  protected boolean isReadyForPullEnd()
  {
    return isLastItemVisible();
  }
  
  protected boolean isReadyForPullStart()
  {
    return isFirstItemVisible();
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mOnLastItemVisibleListener != null) {
      if ((paramInt3 <= 0) || (paramInt1 + paramInt2 < paramInt3 - 1)) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      this.mLastItemVisible = bool;
      if (this.mOnScrollListener != null) {
        this.mOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.mOnLastItemVisibleListener != null) && (this.mLastItemVisible)) {
      this.mOnLastItemVisibleListener.onLastItemVisible();
    }
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ((AdapterView)this.mRefreshableView).setAdapter(paramListAdapter);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ((AbsListView)this.mRefreshableView).setOnItemClickListener(paramOnItemClickListener);
  }
  
  public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener paramOnLastItemVisibleListener)
  {
    this.mOnLastItemVisibleListener = paramOnLastItemVisibleListener;
  }
  
  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.widget.PullToRefreshAdapterViewBase
 * JD-Core Version:    0.7.0.1
 */