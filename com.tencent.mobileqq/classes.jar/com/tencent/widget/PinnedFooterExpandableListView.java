package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;

public class PinnedFooterExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  private static final String TAG = "PinnedFooterExpandableListView";
  private boolean mActionDownHappened;
  PinnedHeaderExpandableListView.ExpandableListAdapter mAdapter = null;
  Context mContext = null;
  int mFloatingGroupPos = -1;
  boolean mFooterEnable;
  int mHeaderHeight;
  View mHeaderView = null;
  int mHeaderWidth;
  private boolean mIsHeaderGroupClickable;
  private PinnedFooterExpandableListView.FooterExpandListViewListener mListener;
  PinnedFooterExpandableListView.OnLayoutListener mOnLayoutListener = null;
  AbsListView.OnScrollListener mOnScrollListener = null;
  private View mTouchTarget;
  
  public PinnedFooterExpandableListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PinnedFooterExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PinnedFooterExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private View getTouchTarget(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (!(paramView instanceof ViewGroup)) {
      localObject = paramView;
    }
    label58:
    label89:
    label101:
    for (;;)
    {
      return localObject;
      localObject = (ViewGroup)paramView;
      int k = ((ViewGroup)localObject).getChildCount();
      boolean bool = isChildrenDrawingOrderEnabled();
      int i = k - 1;
      int j;
      if (i >= 0) {
        if (bool)
        {
          j = getChildDrawingOrder(k, i);
          paramView = ((ViewGroup)localObject).getChildAt(j);
          if (!isTouchPointInView(paramView, paramInt1, paramInt2)) {
            break label89;
          }
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label101;
        }
        return paramView;
        j = i;
        break label58;
        i -= 1;
        break;
        paramView = null;
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  private boolean isTouchPointInView(View paramView, int paramInt1, int paramInt2)
  {
    return (paramView.isClickable()) && (paramInt2 >= paramView.getTop()) && (paramInt2 <= paramView.getBottom()) && (paramInt1 >= paramView.getLeft()) && (paramInt1 <= paramView.getRight());
  }
  
  private void refreshHeader()
  {
    Object localObject = getExpandableListAdapter();
    if (!(localObject instanceof PinnedHeaderExpandableListView.ExpandableListAdapter)) {
      return;
    }
    localObject = (PinnedHeaderExpandableListView.ExpandableListAdapter)localObject;
    int i2 = getFirstVisiblePosition();
    int k = getLastVisiblePosition();
    int i3 = getPackedPositionGroup(getExpandableListPosition(k));
    int n = this.mHeaderView.getMeasuredHeight();
    int i1 = getHeight();
    int i4 = i1 - n;
    int j = k - 2;
    int m = k - 1;
    int i5 = getPackedPositionGroup(getExpandableListPosition(j));
    int i;
    if (i3 == ((PinnedHeaderExpandableListView.ExpandableListAdapter)localObject).getGroupCount() - 1)
    {
      i = 1;
      label98:
      if ((j < 0) || (i5 == i3)) {
        break label425;
      }
      if (getPackedPositionGroup(getExpandableListPosition(m)) != i3) {
        break label521;
      }
    }
    label521:
    for (j = m;; j = k)
    {
      localObject = getChildAt(j - i2);
      if ((localObject != null) && (i1 - ((View)localObject).getTop() >= n))
      {
        j = i3 + 1;
        if ((this.mAdapter != null) && (j < this.mAdapter.getGroupCount()))
        {
          this.mFloatingGroupPos = j;
          this.mAdapter.configHeaderView(this.mHeaderView, j);
        }
        k = ((View)localObject).getTop() + n;
        j = k;
        if (k < i1 - n) {
          j = i1 - n;
        }
        if (i != 0)
        {
          this.mFloatingGroupPos = -1;
          this.mHeaderView.layout(0, -n, this.mHeaderWidth, -n);
          return;
          i = 0;
          break label98;
        }
        this.mHeaderView.layout(0, j, this.mHeaderWidth, j + n);
        return;
      }
      if ((this.mAdapter != null) && (i3 < this.mAdapter.getGroupCount()))
      {
        this.mFloatingGroupPos = i3;
        this.mAdapter.configHeaderView(this.mHeaderView, i3);
      }
      if ((i != 0) && (j != k))
      {
        this.mFloatingGroupPos = -1;
        this.mHeaderView.layout(0, -n, this.mHeaderWidth, -this.mHeaderHeight);
        return;
      }
      if (getPackedPositionType(getExpandableListPosition(m)) == 0)
      {
        setFooterEnable(false);
        if (this.mListener != null) {
          this.mListener.onHeaderDisable();
        }
        this.mFloatingGroupPos = -1;
        this.mHeaderView.layout(0, -n, this.mHeaderWidth, -this.mHeaderHeight);
        return;
      }
      this.mHeaderView.layout(0, i4, this.mHeaderWidth, this.mHeaderHeight + i4);
      return;
      label425:
      if (i != 0)
      {
        this.mFloatingGroupPos = -1;
        this.mHeaderView.layout(0, -this.mHeaderHeight, this.mHeaderWidth, -this.mHeaderHeight);
      }
      for (;;)
      {
        i = i3 + 1;
        if ((this.mAdapter == null) || (i >= this.mAdapter.getGroupCount())) {
          break;
        }
        this.mFloatingGroupPos = i;
        this.mAdapter.configHeaderView(this.mHeaderView, i);
        return;
        this.mHeaderView.layout(0, i4, this.mHeaderWidth, this.mHeaderHeight + i4);
      }
    }
  }
  
  public void createHeaderView()
  {
    if (this.mHeaderView != null) {}
    int i;
    do
    {
      ExpandableListAdapter localExpandableListAdapter;
      do
      {
        do
        {
          return;
        } while (!this.mFooterEnable);
        localExpandableListAdapter = getExpandableListAdapter();
      } while (!(localExpandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter));
      this.mAdapter = ((PinnedHeaderExpandableListView.ExpandableListAdapter)localExpandableListAdapter);
      i = this.mAdapter.getHeaderViewLayoutResourceId();
    } while (i == 0);
    this.mHeaderView = LayoutInflater.from(this.mContext).inflate(i, this, false);
    if (this.mHeaderView != null) {
      this.mHeaderView.setOnClickListener(new PinnedFooterExpandableListView.1(this, this));
    }
    requestLayout();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.mHeaderView != null) && (this.mHeaderView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.mHeaderView, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = pointToPosition(i, j);
    if ((this.mHeaderView != null) && (this.mHeaderView.getVisibility() == 0) && (j >= this.mHeaderView.getTop()) && (j <= this.mHeaderView.getBottom()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.mTouchTarget = getTouchTarget(this.mHeaderView, i, j);
        this.mActionDownHappened = true;
      }
      while (paramMotionEvent.getAction() != 1) {
        return true;
      }
      if ((getTouchTarget(this.mHeaderView, i, j) == this.mTouchTarget) && (this.mTouchTarget.isClickable()))
      {
        this.mTouchTarget.performClick();
        invalidate(new Rect(0, 0, this.mHeaderWidth, this.mHeaderHeight));
      }
      for (;;)
      {
        this.mActionDownHappened = false;
        return true;
        if (this.mIsHeaderGroupClickable)
        {
          i = getPackedPositionGroup(getExpandableListPosition(k));
          if ((i != -1) && (this.mActionDownHappened)) {
            if (isGroupExpanded(i)) {
              collapseGroup(i);
            } else {
              expandGroup(i);
            }
          }
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mHeaderView != null) {
      this.mHeaderView.refreshDrawableState();
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mOnLayoutListener != null) {
      this.mOnLayoutListener.onLayout(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mHeaderView != null)
    {
      measureChild(this.mHeaderView, paramInt1, paramInt2);
      this.mHeaderWidth = this.mHeaderView.getMeasuredWidth();
      this.mHeaderHeight = this.mHeaderView.getMeasuredHeight();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mHeaderView != null) {
      refreshHeader();
    }
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    createHeaderView();
  }
  
  public void setFooterEnable(boolean paramBoolean)
  {
    this.mFooterEnable = paramBoolean;
    if (this.mHeaderView != null)
    {
      if (this.mFooterEnable) {
        this.mHeaderView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mHeaderView.setVisibility(8);
  }
  
  public void setListener(PinnedFooterExpandableListView.FooterExpandListViewListener paramFooterExpandListViewListener)
  {
    this.mListener = paramFooterExpandListViewListener;
  }
  
  public void setOnLayoutListener(PinnedFooterExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.mOnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.PinnedFooterExpandableListView
 * JD-Core Version:    0.7.0.1
 */