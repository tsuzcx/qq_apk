package com.tencent.mobileqq.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class PagingScrollView$YScrollDetector
  extends GestureDetector.SimpleOnGestureListener
{
  protected PagingScrollView$YScrollDetector(PagingScrollView paramPagingScrollView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PagingScrollView.a(this.a))
    {
      PagingScrollView.a(this.a, false);
      paramFloat1 = Math.abs(paramFloat1);
      paramFloat2 = Math.abs(paramFloat2);
      if (paramFloat2 > paramFloat1)
      {
        if (paramFloat1 >= 0.01F) {
          break label62;
        }
        PagingScrollView.a(this.a, true);
      }
    }
    for (;;)
    {
      return PagingScrollView.a(this.a);
      label62:
      if (paramFloat2 / paramFloat1 > 1.73205F) {
        PagingScrollView.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PagingScrollView.YScrollDetector
 * JD-Core Version:    0.7.0.1
 */