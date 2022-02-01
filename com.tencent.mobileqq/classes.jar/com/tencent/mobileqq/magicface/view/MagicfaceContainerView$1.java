package com.tencent.mobileqq.magicface.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MagicfaceContainerView$1
  extends GestureDetector.SimpleOnGestureListener
{
  MagicfaceContainerView$1(MagicfaceContainerView paramMagicfaceContainerView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.a(5);
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 150.0F)
    {
      if (this.a.a != null)
      {
        this.a.a.a(0);
        return false;
      }
    }
    else if (paramMotionEvent1.getX() - paramMotionEvent2.getX() < -150.0F)
    {
      if (this.a.a != null)
      {
        this.a.a.a(1);
        return false;
      }
    }
    else if (paramMotionEvent1.getY() - paramMotionEvent2.getY() > 150.0F)
    {
      if (this.a.a != null)
      {
        this.a.a.a(2);
        return false;
      }
    }
    else if ((paramMotionEvent1.getY() - paramMotionEvent2.getY() < -150.0F) && (this.a.a != null)) {
      this.a.a.a(3);
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.a(4);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceContainerView.1
 * JD-Core Version:    0.7.0.1
 */