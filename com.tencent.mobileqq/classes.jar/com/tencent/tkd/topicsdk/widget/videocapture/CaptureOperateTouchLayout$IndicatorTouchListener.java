package com.tencent.tkd.topicsdk.widget.videocapture;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Scroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$IndicatorTouchListener;", "Landroid/view/View$OnTouchListener;", "indicatorLongClickCallback", "Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$IndicatorLongPressCallback;", "(Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout;Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$IndicatorLongPressCallback;)V", "initialTouchX", "", "initialTouchY", "initialX", "initialY", "lastX", "runnable", "Ljava/lang/Runnable;", "shortLongPressRunnable", "touchStartX", "touchStartY", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CaptureOperateTouchLayout$IndicatorTouchListener
  implements View.OnTouchListener
{
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private final Runnable i;
  private final Runnable j;
  private final CaptureOperateTouchLayout.IndicatorLongPressCallback k;
  
  public CaptureOperateTouchLayout$IndicatorTouchListener(CaptureOperateTouchLayout.IndicatorLongPressCallback paramIndicatorLongPressCallback)
  {
    this.k = localObject;
    this.i = ((Runnable)new CaptureOperateTouchLayout.IndicatorTouchListener.runnable.1(this));
    this.j = ((Runnable)new CaptureOperateTouchLayout.IndicatorTouchListener.shortLongPressRunnable.1(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
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
          float f1 = CaptureOperateTouchLayout.e(this.a);
          f2 = Math.min(Math.max(f2 + (f3 - f4), 0.0F), f1);
          paramView.setX(f2);
          f1 = f2 / f1;
          localObject = this.a;
          ((CaptureOperateTouchLayout)localObject).a(f1, CaptureOperateTouchLayout.a((CaptureOperateTouchLayout)localObject));
          localObject = this.a.getOnIndicatorPressCallback();
          if (localObject != null) {
            ((CaptureOperateTouchLayout.OnIndicatorPressCallback)localObject).c();
          }
          if (!CaptureOperateTouchLayout.a(this.a))
          {
            f1 = Math.abs(this.f - paramView.getX());
            f2 = 10;
            if ((f1 > f2) || (Math.abs(this.g - paramView.getY()) > f2))
            {
              this.f = paramView.getX();
              this.g = paramView.getY();
              CaptureOperateTouchLayout.d(this.a).removeCallbacks(this.j);
              CaptureOperateTouchLayout.d(this.a).removeCallbacks(this.i);
              CaptureOperateTouchLayout.d(this.a).postDelayed(this.j, 300L);
              CaptureOperateTouchLayout.d(this.a).postDelayed(this.i, 1000L);
              this.k.c();
            }
          }
        }
      }
      else
      {
        if (CaptureOperateTouchLayout.a(this.a))
        {
          CaptureOperateTouchLayout.a(this.a, false);
          m = (int)(Math.abs(paramView.getX() - this.f) / CaptureOperateTouchLayout.e(this.a) * 400);
          localObject = ValueAnimator.ofFloat(new float[] { paramView.getScrollX(), this.f }).setDuration(m);
          ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CaptureOperateTouchLayout.IndicatorTouchListener.onTouch.1(this, paramView));
          ((ValueAnimator)localObject).start();
          this.k.a(true);
        }
        else
        {
          this.k.a(false);
        }
        paramView = this.a.getOnIndicatorPressCallback();
        if (paramView != null) {
          paramView.b();
        }
        CaptureOperateTouchLayout.b(this.a).abortAnimation();
        CaptureOperateTouchLayout.a(this.a, -1);
        CaptureOperateTouchLayout.a(this.a, -1);
        CaptureOperateTouchLayout.d(this.a).removeCallbacks(this.i);
        CaptureOperateTouchLayout.d(this.a).removeCallbacks(this.j);
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
      CaptureOperateTouchLayout.b(this.a).setFinalX((int)CaptureOperateTouchLayout.c(this.a).getX());
      paramView = this.a.getOnIndicatorPressCallback();
      if (paramView != null) {
        paramView.a();
      }
      CaptureOperateTouchLayout.d(this.a).postDelayed(this.j, 300L);
      CaptureOperateTouchLayout.d(this.a).postDelayed(this.i, 1000L);
    }
    this.h = paramMotionEvent.getRawX();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.IndicatorTouchListener
 * JD-Core Version:    0.7.0.1
 */