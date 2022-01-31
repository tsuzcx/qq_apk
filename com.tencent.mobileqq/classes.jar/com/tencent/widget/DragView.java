package com.tencent.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import bhsw;
import bhvw;
import bhvx;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DragView
  extends RelativeLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, GestureDetector.OnGestureListener
{
  private float jdField_a_of_type_Float;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this);
  private View jdField_a_of_type_AndroidViewView;
  private bhvw jdField_a_of_type_Bhvw;
  private bhvx jdField_a_of_type_Bhvx;
  public boolean a;
  private float jdField_b_of_type_Float;
  private AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean;
  private float f = 0.25F;
  private float g;
  
  public DragView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bhvx != null) {
      this.jdField_a_of_type_Bhvx.a(paramFloat);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setupStartValues();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setScaleX(1.0F);
    this.jdField_a_of_type_AndroidViewView.setScaleY(1.0F);
    this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
    this.jdField_a_of_type_AndroidViewView.setTranslationY(0.0F);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationX", new float[] { 0.0F });
    paramLayoutParams = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 1.0F });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { paramView, paramLayoutParams, localObjectAnimator1, localObjectAnimator2 });
    localObjectAnimator2.addUpdateListener(this);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(this);
    paramView = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationX", new float[] { 0.0F });
    paramLayoutParams = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0.0F });
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 0.0F });
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 0.0F });
    this.jdField_b_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { paramView, paramLayoutParams, localObjectAnimator1, localObjectAnimator2 });
    localObjectAnimator2.addUpdateListener(this);
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.addListener(this);
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramAnimator == this.jdField_b_of_type_AndroidAnimationAnimatorSet)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bhvx != null) {
        this.jdField_a_of_type_Bhvx.F();
      }
    }
    while ((paramAnimator != this.jdField_a_of_type_AndroidAnimationAnimatorSet) || (this.jdField_a_of_type_Bhvx == null)) {
      return;
    }
    this.jdField_a_of_type_Bhvx.G();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Float localFloat2 = (Float)paramValueAnimator.getAnimatedValue();
    Float localFloat1 = localFloat2;
    if (this.jdField_b_of_type_AndroidAnimationAnimatorSet.getChildAnimations().contains(paramValueAnimator))
    {
      if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
        break label128;
      }
      f1 = getHeight() / this.jdField_a_of_type_AndroidViewView.getHeight();
      paramValueAnimator = Float.valueOf(f1 / localFloat2.floatValue());
      if (paramValueAnimator.floatValue() <= 1.0F) {
        break label157;
      }
    }
    label128:
    label157:
    for (float f1 = 1.0F;; f1 = paramValueAnimator.floatValue())
    {
      localFloat1 = Float.valueOf(1.0F - Float.valueOf(f1).floatValue());
      if (QLog.isColorLevel()) {
        QLog.d("DragView", 2, "onAnimationUpdate : " + localFloat1);
      }
      a(localFloat1.floatValue() - this.g);
      return;
      f1 = (this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top) / this.jdField_a_of_type_AndroidViewView.getHeight();
      break;
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = paramMotionEvent.getX();
    this.jdField_e_of_type_Float = paramMotionEvent.getY();
    this.jdField_a_of_type_Float = 1.0F;
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    paramMotionEvent1 = this.jdField_b_of_type_AndroidAnimationAnimatorSet.getChildAnimations();
    int k;
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidViewView != null) && (paramMotionEvent1 != null) && (paramMotionEvent1.size() == 4))
    {
      k = this.jdField_a_of_type_AndroidViewView.getWidth();
      int m = this.jdField_a_of_type_AndroidViewView.getHeight();
      int j = m;
      int i = k;
      if (this.jdField_a_of_type_Bhvw != null)
      {
        paramMotionEvent2 = this.jdField_a_of_type_Bhvw.a();
        j = m;
        i = k;
        if (paramMotionEvent2 != null)
        {
          i = paramMotionEvent2[0];
          j = paramMotionEvent2[1];
        }
      }
      paramMotionEvent2 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect);
      if (this.jdField_e_of_type_Boolean) {
        paramFloat1 = i / j;
      }
      try
      {
        paramFloat2 = this.jdField_a_of_type_AndroidGraphicsRect.width() / this.jdField_a_of_type_AndroidGraphicsRect.height();
        if (QLog.isColorLevel()) {
          QLog.d("DragView", 2, "sonRatio : " + paramFloat2 + "  parentRatio : " + paramFloat1 + " getWidth() : " + getWidth() + " getHeight() : " + getHeight() + " oriHeight :" + this.jdField_a_of_type_AndroidGraphicsRect.height() + " oriWidth : " + this.jdField_a_of_type_AndroidGraphicsRect.width());
        }
        if (paramFloat2 >= paramFloat1) {
          break label505;
        }
        k = (int)(paramFloat1 * this.jdField_a_of_type_AndroidGraphicsRect.height() - this.jdField_a_of_type_AndroidGraphicsRect.width()) / 2;
        paramMotionEvent2.left -= k;
        paramMotionEvent2.right = (k + paramMotionEvent2.right);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          float f1;
          float f2;
          if (QLog.isColorLevel()) {
            QLog.d("DragView", 2, bhsw.a(localException));
          }
        }
      }
      paramFloat1 = (paramMotionEvent2.left + paramMotionEvent2.right) / 2 - getWidth() / 2;
      paramFloat2 = (paramMotionEvent2.top + paramMotionEvent2.bottom) / 2 - getHeight() / 2;
      f1 = (paramMotionEvent2.right - paramMotionEvent2.left) / i;
      f2 = (paramMotionEvent2.bottom - paramMotionEvent2.top) / j;
      ((ObjectAnimator)paramMotionEvent1.get(0)).setFloatValues(new float[] { paramFloat1 });
      ((ObjectAnimator)paramMotionEvent1.get(1)).setFloatValues(new float[] { paramFloat2 });
      ((ObjectAnimator)paramMotionEvent1.get(2)).setFloatValues(new float[] { f1 });
      ((ObjectAnimator)paramMotionEvent1.get(3)).setFloatValues(new float[] { f2 });
      this.jdField_a_of_type_AndroidViewView.setPivotX(this.jdField_a_of_type_AndroidViewView.getWidth() / 2);
      this.jdField_a_of_type_AndroidViewView.setPivotY(this.jdField_a_of_type_AndroidViewView.getHeight() / 2);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.setupStartValues();
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.start();
      return true;
      label505:
      if (paramFloat2 <= paramFloat1) {
        break;
      }
      k = (int)(this.jdField_a_of_type_AndroidGraphicsRect.width() / paramFloat1 - this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2;
      paramMotionEvent2.top -= k;
      paramMotionEvent2.bottom = (k + paramMotionEvent2.bottom);
      break;
      this.jdField_a_of_type_AndroidViewView.setPivotX(getWidth() / 2);
      this.jdField_a_of_type_AndroidViewView.setPivotY(getHeight() / 2);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    this.jdField_b_of_type_Float -= paramFloat1;
    this.jdField_c_of_type_Float -= paramFloat2;
    if (this.jdField_c_of_type_Float < 0.0F)
    {
      paramFloat1 = f1;
      f1 = 1.0F - paramFloat1 / getHeight();
      this.jdField_a_of_type_AndroidViewView.setPivotX(this.jdField_d_of_type_Float - this.jdField_a_of_type_AndroidViewView.getLeft());
      this.jdField_a_of_type_AndroidViewView.setPivotY(this.jdField_e_of_type_Float - this.jdField_a_of_type_AndroidViewView.getTop());
      if (f1 <= this.f) {
        break label178;
      }
    }
    label178:
    for (paramFloat2 = f1;; paramFloat2 = this.f)
    {
      this.jdField_a_of_type_Float = paramFloat2;
      this.jdField_a_of_type_AndroidViewView.setScaleX(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidViewView.setScaleY(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidViewView.setTranslationX(this.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidViewView.setTranslationY(paramFloat1);
      a(f1 - this.g);
      return false;
      paramFloat1 = this.jdField_c_of_type_Float;
      break;
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bhvx != null) {
      this.jdField_a_of_type_Bhvx.H();
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if (j == 0) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() == 1) {
        i = 1;
      }
      if ((!this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent)) && (i != 0)) {
        a(paramMotionEvent);
      }
      return true;
      if (j == 1)
      {
        this.jdField_c_of_type_Boolean = false;
      }
      else if ((j == 2) && (!this.jdField_c_of_type_Boolean))
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(0);
        this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(localMotionEvent);
        this.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void setDragChangeListener(bhvw parambhvw)
  {
    this.jdField_a_of_type_Bhvw = parambhvw;
  }
  
  public void setEnableDrag(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setGestureChangeListener(bhvx parambhvx)
  {
    this.jdField_a_of_type_Bhvx = parambhvx;
  }
  
  public void setOriginRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public void setRatioModify(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.DragView
 * JD-Core Version:    0.7.0.1
 */