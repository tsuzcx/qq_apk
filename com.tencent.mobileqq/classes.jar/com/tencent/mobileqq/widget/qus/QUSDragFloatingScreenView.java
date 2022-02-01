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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bhmu;
import bhmv;
import com.tencent.qphone.base.util.QLog;

public class QUSDragFloatingScreenView
  extends FrameLayout
{
  private byte jdField_a_of_type_Byte = 0;
  private float jdField_a_of_type_Float = getContext().getResources().getDisplayMetrics().density;
  private int jdField_a_of_type_Int = a(36);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
  private bhmu jdField_a_of_type_Bhmu;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = a(60);
  private int c;
  private int d = 0;
  private int e;
  private int f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  
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
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.topMargin = a(60);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839470);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramInt = a(36);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, paramInt);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    paramContext = new FrameLayout.LayoutParams(paramInt, paramInt);
    paramContext.gravity = 17;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849587);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    setOnClickListener(new bhmv(this));
  }
  
  private int a()
  {
    int j = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Bhmu == null) {}
    for (int i = this.jdField_a_of_type_Int;; i = this.jdField_a_of_type_Bhmu.a()) {
      return Math.max(j, Math.min(i, this.c - this.jdField_b_of_type_Int));
    }
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt * this.jdField_a_of_type_Float + 0.5F);
  }
  
  private void a(float paramFloat)
  {
    paramFloat -= this.jdField_b_of_type_Float;
    if (Math.abs(paramFloat) > this.f)
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
  
  private void a(int paramInt)
  {
    ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "y", new float[] { this.jdField_a_of_type_AndroidWidgetLinearLayout.getY(), paramInt }).setDuration(250L).start();
    this.jdField_a_of_type_Boolean = false;
    a(false);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawY();
    a(f1);
    f1 -= this.jdField_b_of_type_Float;
    float f2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getY();
    float f3 = f2 + f1;
    if (f3 < this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom((int)(this.jdField_b_of_type_Int - f2));
    }
    for (;;)
    {
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      return;
      if (f3 > this.c - this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom((int)(this.c - this.jdField_a_of_type_Int - f2));
      } else {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom((int)f1);
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
  
  private void d()
  {
    float f1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getY();
    if (f1 < this.c - a()) {
      if (this.e <= 1) {
        if ((f1 < (this.c - a()) / 2.0F) || (this.jdField_a_of_type_Byte == 2)) {
          a();
        }
      }
    }
    do
    {
      do
      {
        return;
        b();
        return;
      } while (this.e != 2);
      if ((f1 > (this.c - a()) / 2.0F) || (this.jdField_a_of_type_Byte == 1))
      {
        b();
        return;
      }
      a();
      return;
      if (this.e >= 1)
      {
        if ((f1 >= this.c - this.jdField_a_of_type_Int - (a() - this.jdField_a_of_type_Int) / 2) || (this.jdField_a_of_type_Byte == 1))
        {
          c();
          return;
        }
        b();
        return;
      }
    } while (this.e != 0);
    if ((f1 <= this.c - this.jdField_a_of_type_Int - (a() - this.jdField_a_of_type_Int) / 2) || (this.jdField_a_of_type_Byte == 2))
    {
      b();
      return;
    }
    c();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showTotal");
    }
    this.e = 2;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849588);
    a(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Bhmu != null) {
      this.jdField_a_of_type_Bhmu.a();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showDefaultHeight");
    }
    if (this.c - a() > this.jdField_b_of_type_Int)
    {
      this.e = 1;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849587);
      a(this.c - a());
      if (this.jdField_a_of_type_Bhmu != null) {
        this.jdField_a_of_type_Bhmu.b();
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showMinHeight");
    }
    this.e = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849587);
    a(this.c - this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bhmu != null) {
      this.jdField_a_of_type_Bhmu.c();
    }
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
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getGlobalVisibleRect(localRect);
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
          d();
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c <= 0)
    {
      this.c = getMeasuredHeight();
      if ((this.jdField_a_of_type_Bhmu != null) && (this.jdField_a_of_type_Bhmu.b() > 0)) {
        this.jdField_b_of_type_Int = Math.max(this.jdField_b_of_type_Int, this.c - this.jdField_a_of_type_Bhmu.b());
      }
      paramInt2 = this.c;
      if (this.d == 0) {}
      for (paramInt1 = a();; paramInt1 = 0)
      {
        paramInt2 -= paramInt1;
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
  }
  
  public void setQUSDragFloatController(bhmu parambhmu)
  {
    int j = 0;
    this.jdField_a_of_type_Bhmu = parambhmu;
    if (parambhmu != null)
    {
      View localView = parambhmu.a();
      if (localView != null)
      {
        if (localView.getParent() != null) {
          ((ViewGroup)localView.getParent()).removeView(localView);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
      this.d = parambhmu.d();
      if (this.d != 0) {
        break label107;
      }
    }
    label107:
    for (int i = Math.max(this.jdField_a_of_type_Int, parambhmu.c());; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      i = j;
      if (this.d == 0) {
        i = 1;
      }
      this.e = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenView
 * JD-Core Version:    0.7.0.1
 */