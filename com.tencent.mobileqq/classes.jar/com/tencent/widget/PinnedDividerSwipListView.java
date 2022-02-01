package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import java.util.LinkedList;

public class PinnedDividerSwipListView
  extends SwipListView
  implements AbsListView.OnScrollListener
{
  private static final int PINNED_DIVDER_STATE_PINNED = 0;
  private static final int PINNED_DIVDER_STATE_PUSHING_UP = 1;
  private static final int PINNED_DIVIDER_STATE_INVISIBLE = -1;
  private PinnedDividerSwipListView.DividerAdapter mAdapter = null;
  private Context mContext = null;
  private int mCurDividerViewPushUpDistance = 0;
  private int mCurDividerViewState = 0;
  private View mFloatingView = null;
  private LinkedList<View> mHeaderViews = new LinkedList();
  private PinnedDividerListView.OnLayoutListener mOnLayoutListener = null;
  private AbsListView.OnScrollListener mOnScrollListener = null;
  private PinnedDividerSwipListView.OnScrollListenerAdapter mOnScrollListenerAdapter = null;
  
  public PinnedDividerSwipListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PinnedDividerSwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PinnedDividerSwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  public void addHeaderView(View paramView)
  {
    addHeaderView(paramView, null, false);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addHeaderView(paramView, paramObject, paramBoolean);
    this.mHeaderViews.add(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView = this.mFloatingView;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.mFloatingView, getDrawingTime());
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mFloatingView != null)
    {
      i = getFirstVisiblePosition() - this.mHeaderViews.size();
      if (i >= 0)
      {
        this.mFloatingView.setVisibility(0);
        localObject = this.mFloatingView;
        ((View)localObject).layout(0, -this.mCurDividerViewPushUpDistance, ((View)localObject).getMeasuredWidth(), this.mFloatingView.getMeasuredHeight() - this.mCurDividerViewPushUpDistance);
        this.mAdapter.configDividerView(this.mFloatingView, i);
      }
      else
      {
        this.mFloatingView.setVisibility(4);
      }
    }
    int k = getChildCount();
    int i = this.mHeaderViews.size();
    for (;;)
    {
      int j = i + 1;
      if (j >= k) {
        break;
      }
      localObject = getChildAt(j);
      i = j;
      if (((View)localObject).getVisibility() != 0)
      {
        ((View)localObject).setVisibility(0);
        i = j;
      }
    }
    Object localObject = this.mOnLayoutListener;
    if (localObject != null) {
      ((PinnedDividerListView.OnLayoutListener)localObject).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.mFloatingView;
    if (localView != null) {
      measureChild(localView, paramInt1, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (this.mFloatingView != null)
    {
      int j;
      if (paramInt1 >= this.mHeaderViews.size())
      {
        j = paramInt1 - this.mHeaderViews.size();
        this.mAdapter.configDividerView(this.mFloatingView, j);
        if (this.mAdapter.isDividerView(j))
        {
          this.mCurDividerViewState = 0;
          paramInt1 = 1;
        }
        else
        {
          localObject = getChildAt(0);
          if ((localObject != null) && (((View)localObject).getBottom() > this.mFloatingView.getMeasuredHeight())) {
            this.mCurDividerViewState = 0;
          } else if (this.mAdapter.isDividerView(j + 1)) {
            this.mCurDividerViewState = 1;
          } else {
            this.mCurDividerViewState = 0;
          }
          paramInt1 = 0;
        }
        int k = getChildCount();
        i = paramInt1;
        if (paramInt1 != 0)
        {
          localObject = getChildAt(0);
          i = paramInt1;
          if (((View)localObject).getVisibility() != 4)
          {
            ((View)localObject).setVisibility(4);
            i = paramInt1;
          }
        }
        while (i < k)
        {
          localObject = getChildAt(i);
          if (((View)localObject).getVisibility() != 0) {
            ((View)localObject).setVisibility(0);
          }
          i += 1;
        }
        if (this.mCurDividerViewState == 1)
        {
          localObject = getChildAt(1);
          i = this.mFloatingView.getMeasuredHeight();
          if (localObject != null) {
            paramInt1 = ((View)localObject).getTop();
          } else {
            paramInt1 = 0;
          }
          this.mCurDividerViewPushUpDistance = (i - paramInt1);
        }
        else
        {
          this.mCurDividerViewPushUpDistance = 0;
        }
        this.mFloatingView.setVisibility(0);
        localObject = this.mFloatingView;
        ((View)localObject).layout(0, -this.mCurDividerViewPushUpDistance, ((View)localObject).getMeasuredWidth(), this.mFloatingView.getMeasuredHeight() - this.mCurDividerViewPushUpDistance);
        i = j;
      }
      else
      {
        this.mCurDividerViewState = -1;
        this.mFloatingView.setVisibility(4);
        j = this.mHeaderViews.size();
        i = paramInt1;
        if (this.mAdapter.getCount() > 0)
        {
          i = paramInt1;
          if (this.mAdapter.isDividerView(0))
          {
            i = paramInt1;
            if (j >= paramInt1)
            {
              i = paramInt1;
              if (j < paramInt1 + paramInt2)
              {
                getChildAt(j - paramInt1).setVisibility(0);
                i = paramInt1;
              }
            }
          }
        }
      }
    }
    Object localObject = this.mOnScrollListener;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScroll(paramAbsListView, i, paramInt2, paramInt3);
    }
    localObject = this.mOnScrollListenerAdapter;
    if (localObject != null) {
      ((PinnedDividerSwipListView.OnScrollListenerAdapter)localObject).onScroll(paramAbsListView, i, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject = this.mOnScrollListener;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
    localObject = this.mOnScrollListenerAdapter;
    if (localObject != null) {
      ((PinnedDividerSwipListView.OnScrollListenerAdapter)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean removeHeaderView(View paramView)
  {
    boolean bool = super.removeHeaderView(paramView);
    if (bool) {
      this.mHeaderViews.remove(paramView);
    }
    return bool;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof PinnedDividerSwipListView.DividerAdapter))
    {
      this.mAdapter = ((PinnedDividerSwipListView.DividerAdapter)paramListAdapter);
      int i = this.mAdapter.getDividerLayout();
      if (i != 0)
      {
        this.mFloatingView = LayoutInflater.from(this.mContext).inflate(i, this, false);
        requestLayout();
      }
      super.setAdapter(this.mAdapter);
      return;
    }
    this.mAdapter = null;
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnLayoutListener(PinnedDividerListView.OnLayoutListener paramOnLayoutListener)
  {
    this.mOnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
  
  public void setOnScrollListenerAdapter(PinnedDividerSwipListView.OnScrollListenerAdapter paramOnScrollListenerAdapter)
  {
    this.mOnScrollListenerAdapter = paramOnScrollListenerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.PinnedDividerSwipListView
 * JD-Core Version:    0.7.0.1
 */