package com.tencent.mobileqq.hiboom;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class HiBoomTextView$1
  extends GestureDetector.SimpleOnGestureListener
{
  HiBoomTextView$1(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.h != null)
    {
      this.a.h.a(this.a);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    Object localObject = HiBoomFont.a().a(this.a.a, this.a.b, this.a.c);
    if (this.a.b())
    {
      ((HiBoomFontDrawer)localObject).a(true);
      this.a.invalidate();
      return true;
    }
    if (HiBoomTextView.a(this.a))
    {
      this.a.c();
    }
    else if (((HiBoomFontDrawer)localObject).b == 3)
    {
      this.a.a(true);
    }
    else if (((HiBoomFontDrawer)localObject).b == 4)
    {
      localObject = this.a;
      ((HiBoomTextView)localObject).e = true;
      ((HiBoomTextView)localObject).invalidate();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.1
 * JD-Core Version:    0.7.0.1
 */