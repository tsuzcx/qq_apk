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
  private float jdField_a_of_type_Float;
  private final CaptureOperateTouchLayout.IndicatorLongPressCallback jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$IndicatorLongPressCallback;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private float jdField_b_of_type_Float;
  private final Runnable jdField_b_of_type_JavaLangRunnable;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  
  public CaptureOperateTouchLayout$IndicatorTouchListener(CaptureOperateTouchLayout.IndicatorLongPressCallback paramIndicatorLongPressCallback)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$IndicatorLongPressCallback = localObject;
    this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new CaptureOperateTouchLayout.IndicatorTouchListener.runnable.1(this));
    this.jdField_b_of_type_JavaLangRunnable = ((Runnable)new CaptureOperateTouchLayout.IndicatorTouchListener.shortLongPressRunnable.1(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      Object localObject;
      if (i != 1)
      {
        if (i == 2)
        {
          float f2 = this.jdField_a_of_type_Float;
          float f3 = paramMotionEvent.getRawX();
          float f4 = this.c;
          float f1 = CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout);
          f2 = Math.min(Math.max(f2 + (f3 - f4), 0.0F), f1);
          paramView.setX(f2);
          f1 = f2 / f1;
          localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
          ((CaptureOperateTouchLayout)localObject).a(f1, CaptureOperateTouchLayout.a((CaptureOperateTouchLayout)localObject));
          localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout.a();
          if (localObject != null) {
            ((CaptureOperateTouchLayout.OnIndicatorPressCallback)localObject).c();
          }
          if (!CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout))
          {
            f1 = Math.abs(this.e - paramView.getX());
            f2 = 10;
            if ((f1 > f2) || (Math.abs(this.f - paramView.getY()) > f2))
            {
              this.e = paramView.getX();
              this.f = paramView.getY();
              CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
              CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300L);
              CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
              this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$IndicatorLongPressCallback.c();
            }
          }
        }
      }
      else
      {
        if (CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout))
        {
          CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout, false);
          i = (int)(Math.abs(paramView.getX() - this.e) / CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout) * 400);
          localObject = ValueAnimator.ofFloat(new float[] { paramView.getScrollX(), this.e }).setDuration(i);
          ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CaptureOperateTouchLayout.IndicatorTouchListener.onTouch.1(this, paramView));
          ((ValueAnimator)localObject).start();
          this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$IndicatorLongPressCallback.a(true);
        }
        else
        {
          this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$IndicatorLongPressCallback.a(false);
        }
        paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout.a();
        if (paramView != null) {
          paramView.b();
        }
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).abortAnimation();
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout, -1);
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout, -1);
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramView.getX();
      this.jdField_b_of_type_Float = paramView.getY();
      this.c = paramMotionEvent.getRawX();
      this.d = paramMotionEvent.getRawY();
      this.e = paramView.getX();
      this.f = paramView.getY();
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout, false);
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).setFinalX((int)CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).getX());
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout.a();
      if (paramView != null) {
        paramView.a();
      }
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300L);
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    this.g = paramMotionEvent.getRawX();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.IndicatorTouchListener
 * JD-Core Version:    0.7.0.1
 */