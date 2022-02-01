package com.tencent.xweb.extension.video;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.xweb.WebView;

class e$14
  implements View.OnTouchListener
{
  e$14(e parame) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!e.c(this.a)) {
      return false;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 1)
    {
      if (i != 5)
      {
        if (i == 6) {
          e.a(this.a, 0);
        }
      }
      else if (paramMotionEvent.getPointerCount() == 2) {
        e.a(this.a, 1);
      }
    }
    else {
      e.a(this.a, 0);
    }
    if ((paramMotionEvent.getAction() == 1) && (e.d(this.a) == 3))
    {
      double d1 = e.a(this.a);
      double d2 = e.e(this.a);
      Double.isNaN(d2);
      d1 = d1 * d2 / 100.0D;
      this.a.a(d1, true);
      e.b(this.a).evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[] { Double.valueOf(d1) }), new e.14.1(this));
      e.b(this.a, 0);
    }
    if (e.f(this.a) == 1) {
      return e.g(this.a).onTouchEvent(paramMotionEvent);
    }
    return e.h(this.a).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e.14
 * JD-Core Version:    0.7.0.1
 */