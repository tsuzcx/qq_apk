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
  private QUSDragFloatController jdField_a_of_type_ComTencentMobileqqWidgetQusQUSDragFloatController;
  private boolean jdField_a_of_type_Boolean = false;
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839428);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850001);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    setOnClickListener(new QUSDragFloatingScreenView.1(this));
  }
  
  private int a()
  {
    int j = this.jdField_a_of_type_Int;
    QUSDragFloatController localQUSDragFloatController = this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSDragFloatController;
    int i;
    if (localQUSDragFloatController == null) {
      i = j;
    } else {
      i = localQUSDragFloatController.a();
    }
    return Math.max(j, Math.min(i, this.c - this.jdField_b_of_type_Int));
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt * this.jdField_a_of_type_Float + 0.5F);
  }
  
  private void a(float paramFloat)
  {
    paramFloat -= this.jdField_b_of_type_Float;
    if (Math.abs(paramFloat) > this.f) {
      if (paramFloat > 0.0F) {
        this.jdField_a_of_type_Byte = 1;
      } else if (paramFloat < 0.0F) {
        this.jdField_a_of_type_Byte = 2;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("swipeDirectionJudge : mSlideStartDir -> ");
      localStringBuilder.append(this.jdField_a_of_type_Byte);
      QLog.d("QUSDragFloatingScreenView", 2, localStringBuilder.toString());
    }
  }
  
  private void a(int paramInt)
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    ObjectAnimator.ofFloat(localLinearLayout, "y", new float[] { localLinearLayout.getY(), paramInt }).setDuration(250L).start();
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
    int i = this.jdField_b_of_type_Int;
    if (f3 < i)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom((int)(i - f2));
    }
    else
    {
      i = this.c;
      int j = this.jdField_a_of_type_Int;
      if (f3 > i - j) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom((int)(i - j - f2));
      } else {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom((int)f1);
      }
    }
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
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
    int i;
    if (f1 < this.c - a())
    {
      i = this.e;
      if (i <= 1)
      {
        if ((f1 >= (this.c - a()) / 2.0F) && (this.jdField_a_of_type_Byte != 2))
        {
          b();
          return;
        }
        a();
        return;
      }
      if (i == 2)
      {
        if ((f1 <= (this.c - a()) / 2.0F) && (this.jdField_a_of_type_Byte != 1))
        {
          a();
          return;
        }
        b();
      }
    }
    else
    {
      i = this.e;
      if (i >= 1)
      {
        if ((f1 < this.c - this.jdField_a_of_type_Int - (a() - this.jdField_a_of_type_Int) / 2) && (this.jdField_a_of_type_Byte != 1))
        {
          b();
          return;
        }
        c();
        return;
      }
      if (i == 0)
      {
        if ((f1 > this.c - this.jdField_a_of_type_Int - (a() - this.jdField_a_of_type_Int) / 2) && (this.jdField_a_of_type_Byte != 2))
        {
          c();
          return;
        }
        b();
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showTotal");
    }
    this.e = 2;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850002);
    a(this.jdField_b_of_type_Int);
    QUSDragFloatController localQUSDragFloatController = this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSDragFloatController;
    if (localQUSDragFloatController != null) {
      localQUSDragFloatController.a();
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850001);
      a(this.c - a());
      QUSDragFloatController localQUSDragFloatController = this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSDragFloatController;
      if (localQUSDragFloatController != null) {
        localQUSDragFloatController.b();
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showMinHeight");
    }
    this.e = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850001);
    a(this.c - this.jdField_a_of_type_Int);
    QUSDragFloatController localQUSDragFloatController = this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSDragFloatController;
    if (localQUSDragFloatController != null) {
      localQUSDragFloatController.c();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dispatchTouchEvent : ");
      ((StringBuilder)localObject).append(paramMotionEvent);
      QLog.d("QUSDragFloatingScreenView", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i == 2) && (this.jdField_a_of_type_Boolean))
        {
          a(paramMotionEvent);
          return true;
        }
      }
      else if (this.jdField_a_of_type_Boolean) {
        d();
      }
    }
    else
    {
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      localObject = new Rect();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getGlobalVisibleRect((Rect)localObject);
      boolean bool;
      if ((!((Rect)localObject).isEmpty()) && (((Rect)localObject).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        a(true);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mConsumeTouchEvent : ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.d("QUSDragFloatingScreenView", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c <= 0)
    {
      this.c = getMeasuredHeight();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSDragFloatController;
      if ((localObject != null) && (((QUSDragFloatController)localObject).b() > 0)) {
        this.jdField_b_of_type_Int = Math.max(this.jdField_b_of_type_Int, this.c - this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSDragFloatController.b());
      }
      paramInt2 = this.c;
      if (this.d == 0) {
        paramInt1 = a();
      } else {
        paramInt1 = 0;
      }
      paramInt2 -= paramInt1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        localObject = getChildAt(paramInt1);
        ((View)localObject).layout(0, paramInt2, ((View)localObject).getMeasuredWidth(), ((View)localObject).getMeasuredHeight() + paramInt2);
        ((View)localObject).setTag("QUSDragFloatingScreenView");
        paramInt1 += 1;
      }
    }
  }
  
  public void setQUSDragFloatController(QUSDragFloatController paramQUSDragFloatController)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSDragFloatController = paramQUSDragFloatController;
    if (paramQUSDragFloatController != null)
    {
      View localView = paramQUSDragFloatController.a();
      if (localView != null)
      {
        if (localView.getParent() != null) {
          ((ViewGroup)localView.getParent()).removeView(localView);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
      this.d = paramQUSDragFloatController.d();
      int i = this.d;
      int j = 0;
      if (i == 0) {
        i = Math.max(this.jdField_a_of_type_Int, paramQUSDragFloatController.c());
      } else {
        i = 0;
      }
      this.jdField_a_of_type_Int = i;
      i = j;
      if (this.d == 0) {
        i = 1;
      }
      this.e = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenView
 * JD-Core Version:    0.7.0.1
 */