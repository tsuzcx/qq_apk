package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class LbsPackHorizontalListView
  extends HorizontalListView
{
  public LbsPackHorizontalListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LbsPackHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
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
    bool1 = bool2;
    if (getChildAt(0) != null)
    {
      int i = this.mNextX;
      if (this.mNextX == 0) {
        return false;
      }
      int j = getChildAt(1).getMeasuredWidth();
      int k = i % j;
      double d1 = k;
      double d2 = j;
      Double.isNaN(d2);
      if (d1 <= d2 * 0.5D) {
        i -= k;
      } else {
        i = i - k + j;
      }
      OverScroller localOverScroller = this.mScroller;
      j = this.mNextX;
      bool1 = bool2;
      if (localOverScroller.springBack(getScrollX() + j, 0, i, i, 0, 0, 1000))
      {
        invalidate();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int getScrollOffset()
  {
    return this.mNextX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.LbsPackHorizontalListView
 * JD-Core Version:    0.7.0.1
 */