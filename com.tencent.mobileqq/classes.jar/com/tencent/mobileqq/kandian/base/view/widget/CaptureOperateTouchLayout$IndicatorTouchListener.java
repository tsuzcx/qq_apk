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
  private float jdField_a_of_type_Float = 0.0F;
  private CaptureOperateTouchLayout.IndicatorLongPressCallback jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$IndicatorLongPressCallback;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CaptureOperateTouchLayout.IndicatorTouchListener.1(this);
  private float jdField_b_of_type_Float = 0.0F;
  private Runnable jdField_b_of_type_JavaLangRunnable = new CaptureOperateTouchLayout.IndicatorTouchListener.2(this);
  private float c = 0.0F;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  
  public CaptureOperateTouchLayout$IndicatorTouchListener(CaptureOperateTouchLayout paramCaptureOperateTouchLayout, CaptureOperateTouchLayout.IndicatorLongPressCallback paramIndicatorLongPressCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$IndicatorLongPressCallback = paramIndicatorLongPressCallback;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
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
          float f1 = CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout);
          f2 = Math.min(Math.max(f2 + (f3 - f4), 0.0F), f1);
          paramView.setX(f2);
          f1 = f2 / f1;
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout;
          ((CaptureOperateTouchLayout)localObject).a(f1, CaptureOperateTouchLayout.a((CaptureOperateTouchLayout)localObject));
          if ((!CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout)) && ((Math.abs(this.e - paramView.getX()) > 10.0F) || (Math.abs(this.f - paramView.getY()) > 10.0F)))
          {
            this.e = paramView.getX();
            this.f = paramView.getY();
            ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
            ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300L);
            ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$IndicatorLongPressCallback.c();
          }
        }
      }
      else
      {
        if (CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout))
        {
          CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout, false);
          i = (int)(Math.abs(paramView.getX() - this.e) / CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout) * 400.0F);
          localObject = ValueAnimator.ofFloat(new float[] { paramView.getScrollX(), this.e }).setDuration(i);
          ((ValueAnimator)localObject).addUpdateListener(new CaptureOperateTouchLayout.IndicatorTouchListener.3(this, paramView));
          ((ValueAnimator)localObject).start();
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$IndicatorLongPressCallback.a(true);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout$IndicatorLongPressCallback.a(false);
        }
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout).abortAnimation();
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout, CaptureOperateTouchLayout.b());
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout, CaptureOperateTouchLayout.b());
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
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
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout, false);
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout).setFinalX((int)CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout).getX());
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout).postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300L);
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    this.g = paramMotionEvent.getRawX();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout.IndicatorTouchListener
 * JD-Core Version:    0.7.0.1
 */