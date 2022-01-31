package com.tencent.mobileqq.widget.qus;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class QUSDragFloatingScreenView
  extends FrameLayout
{
  private byte jdField_a_of_type_Byte = 0;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  
  public QUSDragFloatingScreenView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QUSDragFloatingScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QUSDragFloatingScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt * this.jdField_a_of_type_Float + 0.5F);
  }
  
  private void a(float paramFloat)
  {
    paramFloat -= this.jdField_c_of_type_Float;
    if (Math.abs(paramFloat) > this.e)
    {
      if (paramFloat <= 0.0F) {
        break label66;
      }
      this.jdField_a_of_type_Byte = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QUSDragFloatingScreenView", 2, "swipeDirectionJudge : mSlideStartDir -> " + this.jdField_a_of_type_Byte);
      }
      return;
      label66:
      if (paramFloat < 0.0F) {
        this.jdField_a_of_type_Byte = 2;
      }
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawY();
    a(f1);
    f1 -= this.jdField_c_of_type_Float;
    float f2 = this.jdField_b_of_type_AndroidViewView.getY();
    float f3 = f2 + f1;
    if (f3 < this.jdField_c_of_type_Int) {
      this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom((int)(this.jdField_c_of_type_Int - f2));
    }
    for (;;)
    {
      this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
      return;
      if (f3 > this.d - this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom((int)(this.d - this.jdField_b_of_type_Int - f2));
      } else {
        this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom((int)f1);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f = this.jdField_b_of_type_AndroidViewView.getY();
    int i;
    if (f >= this.d - this.jdField_b_of_type_Int - (this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2)
    {
      i = this.d - this.jdField_b_of_type_Int;
      d();
    }
    for (;;)
    {
      ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "y", new float[] { f, i }).setDuration(250L).start();
      this.jdField_a_of_type_Boolean = false;
      a(false);
      return;
      if (f >= this.d / 2.0F)
      {
        i = this.d - this.jdField_a_of_type_Int;
        c();
      }
      else if (this.jdField_a_of_type_Byte == 1)
      {
        i = this.d - this.jdField_a_of_type_Int;
        c();
      }
      else
      {
        i = this.jdField_c_of_type_Int;
        b();
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Float = getContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = a(84);
    this.jdField_b_of_type_Int = a(36);
    this.jdField_c_of_type_Int = a(60);
    this.e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368597));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365395);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131364722);
  }
  
  public void a()
  {
    e();
    f();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848611);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848610);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848610);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "dispatchTouchEvent : " + paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.jdField_a_of_type_Boolean)
    {
      return true;
      float f = paramMotionEvent.getRawY();
      this.jdField_b_of_type_Float = f;
      this.jdField_c_of_type_Float = f;
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidViewView.getGlobalVisibleRect(localRect);
      if ((!localRect.isEmpty()) && (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        if (this.jdField_a_of_type_Boolean) {
          a(true);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QUSDragFloatingScreenView", 2, "mConsumeTouchEvent : " + this.jdField_a_of_type_Boolean);
        break;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a(paramMotionEvent);
        return true;
        if (this.jdField_a_of_type_Boolean) {
          b(paramMotionEvent);
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = getMeasuredHeight();
    paramInt2 = this.d - this.jdField_a_of_type_Int;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      View localView = getChildAt(paramInt1);
      localView.layout(0, paramInt2, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
      localView.setTag("QUSDragFloatingScreenView");
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenView
 * JD-Core Version:    0.7.0.1
 */