package dov.com.qq.im.capture.part;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.capture.view.PressScaleAnimDelegate;

class RecyclerViewItemTouchListener$1
  implements GestureDetector.OnGestureListener
{
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = RecyclerViewItemTouchListener.a(this.a).findChildViewUnder(paramMotionEvent.getX(), paramMotionEvent.getY());
    if ((paramMotionEvent != null) && (RecyclerViewItemTouchListener.a(this.a) != null))
    {
      PressScaleAnimDelegate.a(paramMotionEvent, 300L, new RecyclerViewItemTouchListener.1.1(this, paramMotionEvent), new float[] { 1.0F, 0.95F, 1.0F });
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.part.RecyclerViewItemTouchListener.1
 * JD-Core Version:    0.7.0.1
 */