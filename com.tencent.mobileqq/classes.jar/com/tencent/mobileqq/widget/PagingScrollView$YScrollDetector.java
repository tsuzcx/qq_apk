package com.tencent.mobileqq.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class PagingScrollView$YScrollDetector
  extends GestureDetector.SimpleOnGestureListener
{
  protected PagingScrollView$YScrollDetector(PagingScrollView paramPagingScrollView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PagingScrollView.access$000(this.a))
    {
      PagingScrollView.access$002(this.a, false);
      paramFloat1 = Math.abs(paramFloat1);
      paramFloat2 = Math.abs(paramFloat2);
      if (paramFloat2 > paramFloat1) {
        if (paramFloat1 < 0.01F) {
          PagingScrollView.access$002(this.a, true);
        } else if (paramFloat2 / paramFloat1 > 1.73205F) {
          PagingScrollView.access$002(this.a, true);
        }
      }
    }
    return PagingScrollView.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PagingScrollView.YScrollDetector
 * JD-Core Version:    0.7.0.1
 */