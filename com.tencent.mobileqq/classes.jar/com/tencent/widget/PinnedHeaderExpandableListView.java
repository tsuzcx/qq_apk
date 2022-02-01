package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;

public class PinnedHeaderExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  private static final int PINNED_HEADER_STATE_INVISIBLE = -1;
  private static final int PINNED_HEADER_STATE_PINNED = 0;
  private static final int PINNED_HEADER_STATE_PUSHING_UP = 1;
  private PinnedHeaderExpandableListView.ExpandableListAdapter mAdapter = null;
  private Context mContext = null;
  private int mCurHeaderGroupPos = -1;
  private int mCurHeaderViewPushUpDistance = 0;
  private int mCurHeaderViewState = 0;
  private boolean mDispatchTouchEventToHeaderView = false;
  private View mHeaderView = null;
  private ExpandableListView.OnGroupClickListener mOnGroupClickedListener = null;
  private PinnedHeaderExpandableListView.OnLayoutListener mOnLayoutListener = null;
  private AbsListView.OnScrollListener mOnScrollListener = null;
  protected boolean mShouldHeaderShow = true;
  private boolean oweOneForceLayout = false;
  
  public PinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void configHeaderView(int paramInt, boolean paramBoolean)
  {
    int j = 1;
    int k = getPackedPositionType(getExpandableListPosition(paramInt));
    View localView;
    if (k != 2) {
      if (k == 0) {
        if ((getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 0) || (getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 2))
        {
          this.mCurHeaderViewState = -1;
          if (this.mCurHeaderViewState == -1) {
            break label425;
          }
          if (this.mCurHeaderViewState != 1) {
            break label303;
          }
          localView = getChildAt(1);
          int m = this.mHeaderView.getMeasuredHeight();
          if (localView == null) {
            break label298;
          }
          i = localView.getTop();
          label99:
          this.mCurHeaderViewPushUpDistance = (m - i);
          label107:
          if (!this.mShouldHeaderShow) {
            break label316;
          }
          this.mHeaderView.setVisibility(0);
          if (!this.mAdapter.needHideBackgroundGroup()) {
            break label316;
          }
          if (k != 0) {
            break label506;
          }
          localView = getChildAt(0);
          if ((localView == null) || (isDirectChildHeaderOrFooter(localView))) {
            break label506;
          }
          localView.setVisibility(4);
        }
      }
    }
    label298:
    label303:
    label316:
    label506:
    for (int i = 1;; i = 0)
    {
      k = getChildCount();
      if (i != 0) {
        i = j;
      }
      for (;;)
      {
        if (i >= k) {
          break label316;
        }
        localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() != 0) && (!isDirectChildHeaderOrFooter(localView))) {
          localView.setVisibility(0);
        }
        i += 1;
        continue;
        this.mCurHeaderViewState = 0;
        break;
        if (getChildAt(0).getBottom() > this.mHeaderView.getMeasuredHeight())
        {
          this.mCurHeaderViewState = 0;
          break;
        }
        if (getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 0)
        {
          this.mCurHeaderViewState = 1;
          break;
        }
        this.mCurHeaderViewState = 0;
        break;
        this.mCurHeaderViewState = -1;
        break;
        i = 0;
        break label99;
        this.mCurHeaderViewPushUpDistance = 0;
        break label107;
        i = 0;
      }
      paramInt = getPackedPositionGroup(getExpandableListPosition(paramInt));
      if ((paramInt != this.mCurHeaderGroupPos) || (paramBoolean) || (this.oweOneForceLayout))
      {
        this.oweOneForceLayout = false;
        this.mCurHeaderGroupPos = paramInt;
        this.mAdapter.configHeaderView(this.mHeaderView, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.mHeaderView.getMeasuredWidth(), 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(this.mHeaderView.getMeasuredHeight(), 1073741824);
        this.mHeaderView.measure(paramInt, i);
        this.mHeaderView.layout(0, 0, this.mHeaderView.getMeasuredWidth(), this.mHeaderView.getMeasuredHeight());
      }
      for (;;)
      {
        return;
        if (paramBoolean) {
          this.oweOneForceLayout = true;
        }
        this.mHeaderView.setVisibility(4);
        if (this.mAdapter.needHideBackgroundGroup())
        {
          i = getChildCount();
          paramInt = 0;
          while (paramInt < i)
          {
            localView = getChildAt(paramInt);
            if ((localView != null) && (localView.getVisibility() != 0) && (!isDirectChildHeaderOrFooter(localView))) {
              localView.setVisibility(0);
            }
            paramInt += 1;
          }
        }
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  private void refreshAllChild(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        refreshAllChild(localViewGroup.getChildAt(i));
        i += 1;
      }
    }
    paramView.refreshDrawableState();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.mHeaderView != null) && (this.mHeaderView.getVisibility() == 0))
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.mCurHeaderViewPushUpDistance);
      drawChild(paramCanvas, this.mHeaderView, getDrawingTime());
      paramCanvas.restore();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.mDispatchTouchEventToHeaderView)
    {
      if ((this.mHeaderView != null) && (this.mHeaderView.dispatchTouchEvent(paramMotionEvent))) {}
      for (boolean bool = true;; bool = false)
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          this.mDispatchTouchEventToHeaderView = false;
        }
        return bool;
      }
    }
    if ((this.mHeaderView != null) && (f1 >= 0.0F) && (f1 <= this.mHeaderView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.mHeaderView.getMeasuredHeight() - this.mCurHeaderViewPushUpDistance) && (paramMotionEvent.getAction() == 0) && (this.mHeaderView.getVisibility() == 0) && (this.mHeaderView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.mDispatchTouchEventToHeaderView = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mHeaderView != null) {
      refreshAllChild(this.mHeaderView);
    }
  }
  
  public View getHeaderView()
  {
    return this.mHeaderView;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mHeaderView != null) {
      configHeaderView(getFirstVisiblePosition(), true);
    }
    if (this.mOnLayoutListener != null) {
      this.mOnLayoutListener.onLayout(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mHeaderView != null) {
      measureChild(this.mHeaderView, paramInt1, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mHeaderView != null) {
      configHeaderView(paramInt1, false);
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
    if ((paramExpandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter))
    {
      this.mAdapter = ((PinnedHeaderExpandableListView.ExpandableListAdapter)paramExpandableListAdapter);
      int i = this.mAdapter.getHeaderViewLayoutResourceId();
      if (i != 0)
      {
        this.mHeaderView = LayoutInflater.from(this.mContext).inflate(i, this, false);
        if (this.mHeaderView != null) {
          this.mHeaderView.setOnTouchListener(new PinnedHeaderExpandableListView.1(this));
        }
        requestLayout();
      }
    }
  }
  
  public void setHeaderViewShouldShow(boolean paramBoolean)
  {
    this.mShouldHeaderShow = paramBoolean;
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.mOnGroupClickedListener = paramOnGroupClickListener;
    super.setOnGroupClickListener(paramOnGroupClickListener);
  }
  
  public void setOnLayoutListener(PinnedHeaderExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.mOnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.PinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */