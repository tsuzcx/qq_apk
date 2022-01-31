package com.tencent.mobileqq.richmedia.capture.gesture;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

public class CameraViewPagerGesture
  implements GLGestureListener
{
  protected ViewPager a;
  
  public CameraViewPagerGesture(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
  }
  
  public int a()
  {
    return 1002;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean) && (this.a != null) && (this.a.isShown())) {}
    try
    {
      this.a.onTouchEvent(paramMotionEvent);
      if ((i != 2) || (!paramBoolean) || (this.a == null) || (!this.a.isShown())) {}
    }
    catch (Exception localException)
    {
      try
      {
        if (GLGestureProxy.a().a(paramMotionEvent))
        {
          paramMotionEvent = GLGestureProxy.a().a(paramMotionEvent);
          this.a.onTouchEvent(paramMotionEvent);
          paramMotionEvent.recycle();
        }
        return false;
        localException = localException;
        localException.printStackTrace();
      }
      catch (Exception paramMotionEvent)
      {
        for (;;)
        {
          paramMotionEvent.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraViewPagerGesture
 * JD-Core Version:    0.7.0.1
 */