package com.tencent.mobileqq.multicard;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener;
import java.lang.ref.WeakReference;

class MultiCardRootLayout$3
  implements FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener
{
  final int a = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(this.g.getContext()));
  int b;
  float c;
  float d;
  float e;
  float f;
  
  MultiCardRootLayout$3(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    MultiCardRootLayout.a(this.g, false);
    int i = paramMotionEvent.getActionMasked();
    float f1;
    Object localObject;
    if (i != 0)
    {
      if ((i != 1) && (i == 2))
      {
        i = this.b;
        if (i != -1)
        {
          i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
          if ((i >= 0) && (i <= paramMotionEvent.getPointerCount() - 1))
          {
            float f2 = MotionEventCompat.getX(paramMotionEvent, i);
            f1 = Math.abs(f2 - this.f);
            float f3 = MotionEventCompat.getY(paramMotionEvent, i) - this.c;
            float f4 = Math.abs(f3);
            if ((f4 > this.a) && (f4 * 0.5F > f1))
            {
              MultiCardRootLayout.a(this.g, false);
              if (f3 > 0.0F) {
                f1 = this.e + this.a;
              } else {
                f1 = this.e - this.a;
              }
              this.c = f1;
              this.d = f2;
            }
            else if (f1 > this.a)
            {
              MultiCardRootLayout.a(this.g, true);
            }
            else if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onInterceptTouchEvent() called with: ev = [");
              ((StringBuilder)localObject).append(paramMotionEvent);
              ((StringBuilder)localObject).append("] do nothing");
              QLog.d("placeholder", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      this.f = f1;
      this.d = f1;
      f1 = paramMotionEvent.getY();
      this.e = f1;
      this.c = f1;
      this.b = MotionEventCompat.getPointerId(paramMotionEvent, 0);
    }
    if (MultiCardRootLayout.b(this.g) != null)
    {
      localObject = (MultiCardRootLayout.MultiCardRootLayoutListener)MultiCardRootLayout.b(this.g).get();
      if (localObject != null) {
        MultiCardRootLayout.a(this.g, ((MultiCardRootLayout.MultiCardRootLayoutListener)localObject).a(paramMotionEvent));
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInterceptTouchEvent() called with: ev = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("], intercept = ");
      ((StringBuilder)localObject).append(MultiCardRootLayout.a(this.g));
      QLog.d("placeholder", 2, ((StringBuilder)localObject).toString());
    }
    return MultiCardRootLayout.a(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRootLayout.3
 * JD-Core Version:    0.7.0.1
 */