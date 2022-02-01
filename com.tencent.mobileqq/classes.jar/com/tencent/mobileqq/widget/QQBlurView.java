package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.qphone.base.util.QLog;

@TargetApi(19)
public class QQBlurView
  extends View
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ViewTreeObserver.OnPreDrawListener jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new QQBlurView.1(this);
  private QQBlur jdField_a_of_type_ComTencentMobileqqWidgetQQBlur = new QQBlur();
  private boolean jdField_a_of_type_Boolean = true;
  
  public QQBlurView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public QQBlurView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public QQBlurView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString(), new Throwable());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.b();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a(paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a(paramDrawable);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a(paramView);
  }
  
  public void a(QQBlur.OnDrawBgListener paramOnDrawBgListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a(paramOnDrawBgListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.c();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause() called");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.b(paramInt);
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.b(paramView);
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy() called");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    getViewTreeObserver().removeOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.c();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.c(paramInt);
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    getViewTreeObserver().removeOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!a()) {
      super.dispatchDraw(paramCanvas);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!a())
    {
      super.draw(paramCanvas);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.d();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAttachedToWindow() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    getViewTreeObserver().removeOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur != null) {
      a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetachedFromWindow() called ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("QQBlurView", 2, localStringBuilder.toString());
    }
    getViewTreeObserver().removeOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur != null) {
      b();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!a())
    {
      if (this.jdField_a_of_type_Boolean)
      {
        setBackgroundDrawable(null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a(this, paramCanvas);
        super.onDraw(paramCanvas);
        return;
      }
      setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      super.onDraw(paramCanvas);
    }
  }
  
  public void setDebugTag(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a(paramString);
  }
  
  public void setDirtyListener(QQBlur.BackgroundViewDirtyListener paramBackgroundViewDirtyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur.a(paramBackgroundViewDirtyListener);
  }
  
  public void setDisableBlurDrawableRes(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
  }
  
  public void setEnableBlur(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlurView
 * JD-Core Version:    0.7.0.1
 */