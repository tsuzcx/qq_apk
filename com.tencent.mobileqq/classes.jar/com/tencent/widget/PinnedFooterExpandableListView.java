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
    if (!(paramView instanceof ViewGroup)) {
      return paramView;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView;
    int k = localViewGroup.getChildCount();
    boolean bool = isChildrenDrawingOrderEnabled();
    Object localObject = null;
    int i = k - 1;
    for (;;)
    {
      paramView = localObject;
      if (i < 0) {
        break;
      }
      int j;
      if (bool) {
        j = getChildDrawingOrder(k, i);
      } else {
        j = i;
      }
      paramView = localViewGroup.getChildAt(j);
      if (isTouchPointInView(paramView, paramInt1, paramInt2)) {
        break;
      }
      i -= 1;
    }
    if (paramView == null) {
      return localViewGroup;
    }
    return paramView;
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
    int i3 = getFirstVisiblePosition();
    int m = getLastVisiblePosition();
    int i2 = getPackedPositionGroup(getExpandableListPosition(m));
    int i1 = this.mHeaderView.getMeasuredHeight();
    int i4 = getHeight();
    int k = i4 - i1;
    int j = m - 2;
    int n = m - 1;
    int i5 = getPackedPositionGroup(getExpandableListPosition(j));
    if (i2 == ((PinnedHeaderExpandableListView.ExpandableListAdapter)localObject).getGroupCount() - 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j >= 0) && (i5 != i2))
    {
      if (getPackedPositionGroup(getExpandableListPosition(n)) == i2) {
        j = n;
      } else {
        j = m;
      }
      localObject = getChildAt(j - i3);
      if ((localObject != null) && (i4 - ((View)localObject).getTop() >= i1))
      {
        j = i2 + 1;
        PinnedHeaderExpandableListView.ExpandableListAdapter localExpandableListAdapter = this.mAdapter;
        if ((localExpandableListAdapter != null) && (j < localExpandableListAdapter.getGroupCount()))
        {
          this.mFloatingGroupPos = j;
          this.mAdapter.configHeaderView(this.mHeaderView, j);
        }
        m = ((View)localObject).getTop() + i1;
        j = m;
        if (m < k) {
          j = k;
        }
        if (i != 0)
        {
          this.mFloatingGroupPos = -1;
          localObject = this.mHeaderView;
          i = -i1;
          ((View)localObject).layout(0, i, this.mHeaderWidth, i);
          return;
        }
        this.mHeaderView.layout(0, j, this.mHeaderWidth, i1 + j);
        return;
      }
      localObject = this.mAdapter;
      if ((localObject != null) && (i2 < ((PinnedHeaderExpandableListView.ExpandableListAdapter)localObject).getGroupCount()))
      {
        this.mFloatingGroupPos = i2;
        this.mAdapter.configHeaderView(this.mHeaderView, i2);
      }
      if ((i != 0) && (j != m))
      {
        this.mFloatingGroupPos = -1;
        this.mHeaderView.layout(0, -i1, this.mHeaderWidth, -this.mHeaderHeight);
        return;
      }
      if (getPackedPositionType(getExpandableListPosition(n)) == 0)
      {
        setFooterEnable(false);
        localObject = this.mListener;
        if (localObject != null) {
          ((PinnedFooterExpandableListView.FooterExpandListViewListener)localObject).onHeaderDisable();
        }
        this.mFloatingGroupPos = -1;
        this.mHeaderView.layout(0, -i1, this.mHeaderWidth, -this.mHeaderHeight);
        return;
      }
      this.mHeaderView.layout(0, k, this.mHeaderWidth, this.mHeaderHeight + k);
      return;
    }
    if (i != 0)
    {
      this.mFloatingGroupPos = -1;
      localObject = this.mHeaderView;
      i = this.mHeaderHeight;
      ((View)localObject).layout(0, -i, this.mHeaderWidth, -i);
    }
    else
    {
      this.mHeaderView.layout(0, k, this.mHeaderWidth, this.mHeaderHeight + k);
    }
    int i = i2 + 1;
    localObject = this.mAdapter;
    if ((localObject != null) && (i < ((PinnedHeaderExpandableListView.ExpandableListAdapter)localObject).getGroupCount()))
    {
      this.mFloatingGroupPos = i;
      this.mAdapter.configHeaderView(this.mHeaderView, i);
    }
  }
  
  public void createHeaderView()
  {
    if (this.mHeaderView != null) {
      return;
    }
    if (!this.mFooterEnable) {
      return;
    }
    Object localObject = getExpandableListAdapter();
    if ((localObject instanceof PinnedHeaderExpandableListView.ExpandableListAdapter))
    {
      this.mAdapter = ((PinnedHeaderExpandableListView.ExpandableListAdapter)localObject);
      int i = this.mAdapter.getHeaderViewLayoutResourceId();
      if (i != 0)
      {
        this.mHeaderView = LayoutInflater.from(this.mContext).inflate(i, this, false);
        localObject = this.mHeaderView;
        if (localObject != null) {
          ((View)localObject).setOnClickListener(new PinnedFooterExpandableListView.1(this, this));
        }
        requestLayout();
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView = this.mHeaderView;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.mHeaderView, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = pointToPosition(i, j);
    View localView = this.mHeaderView;
    if ((localView != null) && (localView.getVisibility() == 0) && (j >= this.mHeaderView.getTop()) && (j <= this.mHeaderView.getBottom()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.mTouchTarget = getTouchTarget(this.mHeaderView, i, j);
        this.mActionDownHappened = true;
        return true;
      }
      if (paramMotionEvent.getAction() == 1)
      {
        paramMotionEvent = getTouchTarget(this.mHeaderView, i, j);
        localView = this.mTouchTarget;
        if ((paramMotionEvent == localView) && (localView.isClickable()))
        {
          this.mTouchTarget.performClick();
          invalidate(new Rect(0, 0, this.mHeaderWidth, this.mHeaderHeight));
        }
        else if (this.mIsHeaderGroupClickable)
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
        this.mActionDownHappened = false;
      }
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    View localView = this.mHeaderView;
    if (localView != null) {
      localView.refreshDrawableState();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    PinnedFooterExpandableListView.OnLayoutListener localOnLayoutListener = this.mOnLayoutListener;
    if (localOnLayoutListener != null) {
      localOnLayoutListener.onLayout(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.mHeaderView;
    if (localView != null)
    {
      measureChild(localView, paramInt1, paramInt2);
      this.mHeaderWidth = this.mHeaderView.getMeasuredWidth();
      this.mHeaderHeight = this.mHeaderView.getMeasuredHeight();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mHeaderView != null) {
      refreshHeader();
    }
    AbsListView.OnScrollListener localOnScrollListener = this.mOnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.mOnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
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
    View localView = this.mHeaderView;
    if (localView != null)
    {
      if (this.mFooterEnable)
      {
        localView.setVisibility(0);
        return;
      }
      localView.setVisibility(8);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.PinnedFooterExpandableListView
 * JD-Core Version:    0.7.0.1
 */