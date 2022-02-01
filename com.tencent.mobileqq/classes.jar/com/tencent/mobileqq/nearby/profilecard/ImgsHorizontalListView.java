package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;

public class ImgsHorizontalListView
  extends HorizontalListView
{
  public View a;
  
  public ImgsHorizontalListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImgsHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean checkScrollToChild()
  {
    boolean bool1 = this.mStayDisplayOffsetZero;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int i;
    if (!this.isFromRightToLeft ? Math.abs(this.mCurrentX - this.mMaxX) < this.mTouchSlop : Math.abs(this.mCurrentX - this.mMinX) < this.mTouchSlop) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.a.setVisibility(8);
      i = this.mMaxX;
      this.mCurrentX = i;
      this.mNextX = i;
      invalidate();
      return false;
    }
    this.a.setVisibility(0);
    if (this.mTouchSlop + this.mDisplayOffset >= 0)
    {
      this.mNextX += this.mDisplayOffset;
      invalidate();
      return false;
    }
    View localView = getChildAt(0);
    bool1 = bool2;
    if (localView != null)
    {
      int j = this.mNextX + this.mDisplayOffset;
      int k = localView.getMeasuredWidth();
      double d1 = this.mDisplayOffset;
      double d2 = k / 2;
      Double.isNaN(d2);
      i = j;
      if (d1 <= -(d2 + 0.5D)) {
        i = j + k;
      }
      bool1 = bool2;
      if (this.mScroller.springBack(this.mNextX + getScrollX(), 0, i, i, 0, 0))
      {
        invalidate();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setArrow(View paramView)
  {
    this.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.ImgsHorizontalListView
 * JD-Core Version:    0.7.0.1
 */