package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class CaptureOperateTouchLayout$IndicatorTouchListener
  implements View.OnTouchListener
{
  private float b = 0.0F;
  private float c = 0.0F;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  private CaptureOperateTouchLayout.IndicatorLongPressCallback i;
  private Runnable j = new CaptureOperateTouchLayout.IndicatorTouchListener.1(this);
  private Runnable k = new CaptureOperateTouchLayout.IndicatorTouchListener.2(this);
  
  public CaptureOperateTouchLayout$IndicatorTouchListener(CaptureOperateTouchLayout paramCaptureOperateTouchLayout, CaptureOperateTouchLayout.IndicatorLongPressCallback paramIndicatorLongPressCallback)
  {
    this.i = paramIndicatorLongPressCallback;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      Object localObject;
      if (m != 1)
      {
        if (m == 2)
        {
          float f2 = this.b;
          float f3 = paramMotionEvent.getRawX();
          float f4 = this.d;
          float f1 = CaptureOperateTouchLayout.b(this.a);
          f2 = Math.min(Math.max(f2 + (f3 - f4), 0.0F), f1);
          paramView.setX(f2);
          f1 = f2 / f1;
          localObject = this.a;
          ((CaptureOperateTouchLayout)localObject).a(f1, CaptureOperateTouchLayout.h((CaptureOperateTouchLayout)localObject));
          if ((!CaptureOperateTouchLayout.h(this.a)) && ((Math.abs(this.f - paramView.getX()) > 10.0F) || (Math.abs(this.g - paramView.getY()) > 10.0F)))
          {
            this.f = paramView.getX();
            this.g = paramView.getY();
            ThreadManager.getUIHandler().removeCallbacks(this.k);
            ThreadManager.getUIHandler().removeCallbacks(this.j);
            ThreadManager.getUIHandler().postDelayed(this.k, 300L);
            ThreadManager.getUIHandler().postDelayed(this.j, 1000L);
            this.i.c();
          }
        }
      }
      else
      {
        if (CaptureOperateTouchLayout.h(this.a))
        {
          CaptureOperateTouchLayout.a(this.a, false);
          m = (int)(Math.abs(paramView.getX() - this.f) / CaptureOperateTouchLayout.b(this.a) * 400.0F);
          localObject = ValueAnimator.ofFloat(new float[] { paramView.getScrollX(), this.f }).setDuration(m);
          ((ValueAnimator)localObject).addUpdateListener(new CaptureOperateTouchLayout.IndicatorTouchListener.3(this, paramView));
          ((ValueAnimator)localObject).start();
          this.i.a(true);
        }
        else
        {
          this.i.a(false);
        }
        CaptureOperateTouchLayout.e(this.a).abortAnimation();
        CaptureOperateTouchLayout.a(this.a, CaptureOperateTouchLayout.a());
        CaptureOperateTouchLayout.a(this.a, CaptureOperateTouchLayout.a());
        CaptureOperateTouchLayout.g(this.a).removeCallbacks(this.j);
        CaptureOperateTouchLayout.g(this.a).removeCallbacks(this.k);
      }
    }
    else
    {
      this.b = paramView.getX();
      this.c = paramView.getY();
      this.d = paramMotionEvent.getRawX();
      this.e = paramMotionEvent.getRawY();
      this.f = paramView.getX();
      this.g = paramView.getY();
      CaptureOperateTouchLayout.a(this.a, false);
      CaptureOperateTouchLayout.e(this.a).setFinalX((int)CaptureOperateTouchLayout.f(this.a).getX());
      CaptureOperateTouchLayout.g(this.a).postDelayed(this.k, 300L);
      CaptureOperateTouchLayout.g(this.a).postDelayed(this.j, 1000L);
    }
    this.h = paramMotionEvent.getRawX();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout.IndicatorTouchListener
 * JD-Core Version:    0.7.0.1
 */