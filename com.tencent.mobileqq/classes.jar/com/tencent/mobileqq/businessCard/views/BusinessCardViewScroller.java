package com.tencent.mobileqq.businessCard.views;

import abhv;
import abhw;
import abhx;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.widget.OverScroller;
import com.tencent.mobileqq.businessCard.helpers.PathInterpolatorDonut;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.qphone.base.util.QLog;

public class BusinessCardViewScroller
{
  public static int a;
  public static final PathInterpolatorDonut a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  float jdField_a_of_type_Float;
  public ObjectAnimator a;
  OverScroller jdField_a_of_type_AndroidWidgetOverScroller;
  BusinessCardViewLayoutAlgorithm jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm;
  public BusinessCardViewScroller.DeckViewScrollerCallbacks a;
  float b;
  
  static
  {
    jdField_a_of_type_Int = 1;
    c = -1;
    d = 225;
    e = 750;
    jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersPathInterpolatorDonut = new PathInterpolatorDonut(0.0F, 0.0F, 0.2F, 1.0F);
  }
  
  @TargetApi(9)
  public BusinessCardViewScroller(Context paramContext, BusinessCardViewLayoutAlgorithm paramBusinessCardViewLayoutAlgorithm, BusinessCardViewScroller.DeckViewScrollerCallbacks paramDeckViewScrollerCallbacks)
  {
    this.jdField_a_of_type_AndroidWidgetOverScroller = new OverScroller(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm = paramBusinessCardViewLayoutAlgorithm;
    a(a());
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller$DeckViewScrollerCallbacks = paramDeckViewScrollerCallbacks;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  float a(float paramFloat)
  {
    return Math.max(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_a_of_type_Float, Math.min(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_b_of_type_Float, paramFloat));
  }
  
  float a(int paramInt)
  {
    return paramInt / this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_b_of_type_AndroidGraphicsRect.height();
  }
  
  int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_b_of_type_AndroidGraphicsRect.height() * paramFloat);
  }
  
  ObjectAnimator a()
  {
    float f1 = a();
    float f2 = a(f1);
    if (Float.compare(f2, f1) != 0) {
      a(f1, f2, null, d);
    }
    return this.jdField_a_of_type_AndroidAnimationObjectAnimator;
  }
  
  @TargetApi(11)
  void a()
  {
    BusinessCardUtils.a(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller$DeckViewScrollerCallbacks != null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller$DeckViewScrollerCallbacks.a(this.jdField_a_of_type_Float);
    }
  }
  
  @TargetApi(10)
  void a(float paramFloat1, float paramFloat2, Runnable paramRunnable)
  {
    this.jdField_b_of_type_Float = paramFloat2;
    a(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetOverScroller.startScroll(0, a(this.jdField_b_of_type_Float), 0, 0, 0);
  }
  
  @TargetApi(11)
  public void a(float paramFloat1, float paramFloat2, Runnable paramRunnable, int paramInt)
  {
    if (BusinessCardUtils.a(11))
    {
      if ((this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) && (this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()))
      {
        a(this.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidWidgetOverScroller.startScroll(0, a(this.jdField_b_of_type_Float), 0, 0, 0);
      }
      b();
      a();
      this.jdField_b_of_type_Float = paramFloat2;
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "stackScroll", new float[] { paramFloat1, paramFloat2 });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(paramInt);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersPathInterpolatorDonut);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new abhv(this));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new abhw(this, paramRunnable));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      return;
    }
    a(paramFloat1, paramFloat2, paramRunnable);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard", 2, "scrollToStickPosition direction:" + paramInt);
    }
    if (paramInt == c) {}
    abhx localabhx;
    do
    {
      return;
      localabhx = null;
      if (paramInt == jdField_a_of_type_Int) {
        localabhx = new abhx(this, paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller$DeckViewScrollerCallbacks == null);
    float f = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller$DeckViewScrollerCallbacks.a(a(), paramInt, false);
    if (paramInt == jdField_a_of_type_Int) {}
    for (paramInt = e - d;; paramInt = e)
    {
      a(a(), f + a(), localabhx, paramInt);
      return;
    }
  }
  
  public boolean a()
  {
    float f1 = a();
    float f2 = a(f1);
    if (Float.compare(f2, f1) != 0)
    {
      a(f2);
      return true;
    }
    return false;
  }
  
  float b(float paramFloat)
  {
    if (paramFloat < this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_a_of_type_Float) {
      return Math.abs(paramFloat - this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_a_of_type_Float);
    }
    if (paramFloat > this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_b_of_type_Float) {
      return Math.abs(paramFloat - this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewLayoutAlgorithm.jdField_b_of_type_Float);
    }
    return 0.0F;
  }
  
  @TargetApi(9)
  void b()
  {
    if (!this.jdField_a_of_type_AndroidWidgetOverScroller.isFinished()) {
      this.jdField_a_of_type_AndroidWidgetOverScroller.abortAnimation();
    }
  }
  
  void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  boolean b()
  {
    return Float.compare(b(this.jdField_a_of_type_Float), 0.0F) != 0;
  }
  
  @TargetApi(9)
  boolean c()
  {
    if (this.jdField_a_of_type_AndroidWidgetOverScroller.computeScrollOffset())
    {
      float f = a(this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY());
      b(f);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller$DeckViewScrollerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller$DeckViewScrollerCallbacks.a(f);
      }
      return true;
    }
    return false;
  }
  
  @TargetApi(9)
  boolean d()
  {
    return !this.jdField_a_of_type_AndroidWidgetOverScroller.isFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.BusinessCardViewScroller
 * JD-Core Version:    0.7.0.1
 */