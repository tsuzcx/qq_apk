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
    int k = getPackedPositionType(getExpandableListPosition(paramInt));
    int j = 1;
    if (k != 2)
    {
      if (k == 0)
      {
        i = paramInt + 1;
        if ((getPackedPositionType(getExpandableListPosition(i)) != 0) && (getPackedPositionType(getExpandableListPosition(i)) != 2)) {
          this.mCurHeaderViewState = 0;
        } else {
          this.mCurHeaderViewState = -1;
        }
      }
      else if (getChildAt(0).getBottom() > this.mHeaderView.getMeasuredHeight())
      {
        this.mCurHeaderViewState = 0;
      }
      else if (getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 0)
      {
        this.mCurHeaderViewState = 1;
      }
      else
      {
        this.mCurHeaderViewState = 0;
      }
    }
    else {
      this.mCurHeaderViewState = -1;
    }
    int i = this.mCurHeaderViewState;
    View localView;
    if (i != -1)
    {
      if (i == 1)
      {
        localView = getChildAt(1);
        int m = this.mHeaderView.getMeasuredHeight();
        if (localView != null) {
          i = localView.getTop();
        } else {
          i = 0;
        }
        this.mCurHeaderViewPushUpDistance = (m - i);
      }
      else
      {
        this.mCurHeaderViewPushUpDistance = 0;
      }
      if (this.mShouldHeaderShow)
      {
        this.mHeaderView.setVisibility(0);
        if (this.mAdapter.needHideBackgroundGroup())
        {
          if (k == 0)
          {
            localView = getChildAt(0);
            if ((localView != null) && (!isDirectChildHeaderOrFooter(localView)))
            {
              localView.setVisibility(4);
              i = j;
              break label258;
            }
          }
          i = 0;
          label258:
          j = getChildCount();
          while (i < j)
          {
            localView = getChildAt(i);
            if ((localView != null) && (localView.getVisibility() != 0) && (!isDirectChildHeaderOrFooter(localView))) {
              localView.setVisibility(0);
            }
            i += 1;
          }
        }
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
        localView = this.mHeaderView;
        localView.layout(0, 0, localView.getMeasuredWidth(), this.mHeaderView.getMeasuredHeight());
      }
    }
    else
    {
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
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView = this.mHeaderView;
    if ((localView != null) && (localView.getVisibility() == 0))
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
      localView = this.mHeaderView;
      boolean bool;
      if ((localView != null) && (localView.dispatchTouchEvent(paramMotionEvent))) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.mDispatchTouchEventToHeaderView = false;
      }
      return bool;
    }
    View localView = this.mHeaderView;
    if ((localView != null) && (f1 >= 0.0F) && (f1 <= localView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.mHeaderView.getMeasuredHeight() - this.mCurHeaderViewPushUpDistance) && (paramMotionEvent.getAction() == 0) && (this.mHeaderView.getVisibility() == 0) && (this.mHeaderView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.mDispatchTouchEventToHeaderView = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    View localView = this.mHeaderView;
    if (localView != null) {
      refreshAllChild(localView);
    }
  }
  
  public View getHeaderView()
  {
    return this.mHeaderView;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mHeaderView != null) {
      configHeaderView(getFirstVisiblePosition(), true);
    }
    PinnedHeaderExpandableListView.OnLayoutListener localOnLayoutListener = this.mOnLayoutListener;
    if (localOnLayoutListener != null) {
      localOnLayoutListener.onLayout(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.mHeaderView;
    if (localView != null) {
      measureChild(localView, paramInt1, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mHeaderView != null) {
      configHeaderView(paramInt1, false);
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
    if ((paramExpandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter))
    {
      this.mAdapter = ((PinnedHeaderExpandableListView.ExpandableListAdapter)paramExpandableListAdapter);
      int i = this.mAdapter.getHeaderViewLayoutResourceId();
      if (i != 0)
      {
        this.mHeaderView = LayoutInflater.from(this.mContext).inflate(i, this, false);
        paramExpandableListAdapter = this.mHeaderView;
        if (paramExpandableListAdapter != null) {
          paramExpandableListAdapter.setOnTouchListener(new PinnedHeaderExpandableListView.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.PinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */