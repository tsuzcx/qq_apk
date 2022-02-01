package com.tencent.mobileqq.resourcesgrab;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class ResourceGrabView$1
  implements View.OnTouchListener
{
  float a = 0.0F;
  float b = 0.0F;
  int c = 0;
  
  ResourceGrabView$1(ResourceGrabView paramResourceGrabView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        float f = paramMotionEvent.getY();
        paramView = ResourceGrabView.a(this.d);
        paramView.y = ((int)(paramView.y + (f - this.b) / 3.0F));
        paramView = ResourceGrabView.b(this.d);
        paramMotionEvent = this.d;
        paramView.updateViewLayout(paramMotionEvent, ResourceGrabView.a(paramMotionEvent));
        return true;
      }
      i = ResourceGrabView.a(this.d).y;
      int j = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      if ((Math.abs(i - this.c) <= j) && (System.currentTimeMillis() - ResourceGrabView.c(this.d) >= 500L))
      {
        this.d.a();
        return true;
      }
    }
    else
    {
      ResourceGrabView.a(this.d, System.currentTimeMillis());
      this.a = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      this.c = ResourceGrabView.a(this.d).y;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabView.1
 * JD-Core Version:    0.7.0.1
 */