package com.tencent.mobileqq.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class SlideDetectListView$1
  extends GestureDetector.SimpleOnGestureListener
{
  SlideDetectListView$1(SlideDetectListView paramSlideDetectListView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.a.j) {
      return false;
    }
    if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F) && ((this.a.f == 0) || (this.a.k)) && (!this.a.b) && (Math.abs(paramFloat1) > this.a.i))
    {
      paramMotionEvent1 = this.a;
      paramMotionEvent1.e = paramMotionEvent1.a(paramMotionEvent1.a);
      paramMotionEvent1 = this.a;
      paramMotionEvent1.d = paramMotionEvent1.b(paramMotionEvent1.e);
      if (this.a.d != null)
      {
        paramMotionEvent1 = this.a;
        paramMotionEvent1.b = true;
        paramMotionEvent1.setPressed(false);
        this.a.d.setPressed(false);
        if (SlideDetectListView.a(this.a) != null)
        {
          int i = this.a.e;
          int j = this.a.getHeaderViewsCount();
          paramMotionEvent1 = SlideDetectListView.a(this.a);
          paramMotionEvent2 = this.a;
          paramMotionEvent1.a(paramMotionEvent2, paramMotionEvent2.d, i - j);
        }
        this.a.a = 0;
        return true;
      }
      this.a.c = true;
      return true;
    }
    if (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F) {
      this.a.c = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDetectListView.1
 * JD-Core Version:    0.7.0.1
 */