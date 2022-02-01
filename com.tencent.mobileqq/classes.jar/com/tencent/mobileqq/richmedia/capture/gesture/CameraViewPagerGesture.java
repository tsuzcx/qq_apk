package com.tencent.mobileqq.richmedia.capture.gesture;

import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

public class CameraViewPagerGesture
  implements GLGestureListener
{
  private ViewPager a;
  
  public CameraViewPagerGesture(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
  }
  
  public int onGetPriority()
  {
    return 1012;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean))
    {
      ViewPager localViewPager1 = this.a;
      if ((localViewPager1 != null) && (localViewPager1.isShown())) {
        try
        {
          this.a.onTouchEvent(paramMotionEvent);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    if ((i == 2) && (paramBoolean))
    {
      ViewPager localViewPager2 = this.a;
      if ((localViewPager2 != null) && (localViewPager2.isShown())) {
        try
        {
          if (GLGestureProxy.getInstance().checkSecendFinger(paramMotionEvent))
          {
            paramMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(paramMotionEvent);
            this.a.onTouchEvent(paramMotionEvent);
            paramMotionEvent.recycle();
          }
        }
        catch (Exception paramMotionEvent)
        {
          paramMotionEvent.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraViewPagerGesture
 * JD-Core Version:    0.7.0.1
 */