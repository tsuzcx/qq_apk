package com.tencent.mobileqq.qqexpand.fragment;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

class ExpandEditFragment$1
  implements GestureDetector.OnGestureListener
{
  ExpandEditFragment$1(ExpandEditFragment paramExpandEditFragment) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      int i;
      if (paramMotionEvent1.getY() - paramMotionEvent2.getY() > 50.0F) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramMotionEvent2.getY() - paramMotionEvent1.getY() > 50.0F) {
        i = 1;
      }
      if ((i != 0) && (this.a.f != null))
      {
        this.a.f.a();
        ExpandEditFragment.a(this.a).setVisibility(8);
        this.a.e.setVisibility(8);
      }
    }
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandEditFragment.1
 * JD-Core Version:    0.7.0.1
 */