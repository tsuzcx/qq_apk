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
  
  public int a()
  {
    return this.h;
  }
  
  protected boolean a()
  {
    if (!this.c) {}
    for (;;)
    {
      return false;
      if (getChildAt(0) != null)
      {
        int i = this.h;
        if (this.h != 0)
        {
          int j = getChildAt(1).getMeasuredWidth();
          int k = i % j;
          if (k <= j * 0.5D) {
            i -= k;
          }
          while (this.a.a(this.h + getScrollX(), 0, i, i, 0, 0, 1000))
          {
            invalidate();
            return true;
            i = i - k + j;
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    if (!this.d) {
      if (Math.abs(this.g - this.i) >= this.o) {}
    }
    while (Math.abs(this.g - this.j) < this.o)
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.LbsPackHorizontalListView
 * JD-Core Version:    0.7.0.1
 */