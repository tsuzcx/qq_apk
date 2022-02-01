package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class c$1
  implements View.OnTouchListener
{
  c$1(c paramc) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      c.a(this.a, false);
      c.a(this.a, paramMotionEvent.getX());
      if (c.a(this.a) != null)
      {
        c.a(this.a).a();
        return true;
      }
    }
    else
    {
      if (paramMotionEvent.getAction() == 2)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = (int)(c.b(this.a).getWidth() + (f1 - c.c(this.a)));
        if (f2 < 0.0F)
        {
          f1 = 0.0F;
        }
        else
        {
          f1 = f2;
          if (f2 > c.d(this.a).getWidth()) {
            f1 = c.d(this.a).getWidth();
          }
        }
        paramView = this.a;
        c.b(paramView, f1 * 100.0F / c.d(paramView).getWidth());
        paramView = this.a;
        paramView.a(c.e(paramView), true);
        if (c.a(this.a) != null) {
          c.a(this.a).a();
        }
        c.a(this.a, true);
        return true;
      }
      if ((c.f(this.a)) && (c.a(this.a) != null))
      {
        paramView = c.a(this.a);
        paramMotionEvent = this.a;
        paramView.a(paramMotionEvent, c.e(paramMotionEvent), true);
      }
      c.a(this.a, false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c.1
 * JD-Core Version:    0.7.0.1
 */