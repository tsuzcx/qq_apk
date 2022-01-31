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
import bbml;
import bbmm;
import bbmn;
import bbmo;
import com.tencent.qphone.base.util.QLog;

@TargetApi(19)
public class QQBlurView
  extends View
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ViewTreeObserver.OnPreDrawListener jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new bbmo(this);
  private bbml jdField_a_of_type_Bbml = new bbml();
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
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "init() called " + Integer.toHexString(System.identityHashCode(this)), new Throwable());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onResume() called " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_a_of_type_Bbml.b();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Bbml.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bbml.a(paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_Bbml.a(paramDrawable);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_Bbml.a(paramView);
  }
  
  public void a(bbmn parambbmn)
  {
    this.jdField_a_of_type_Bbml.a(parambbmn);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bbml.c();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onPause() called" + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_a_of_type_Bbml.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bbml.b(paramInt);
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_Bbml.b(paramView);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onDestroy() called" + Integer.toHexString(System.identityHashCode(this)));
    }
    getViewTreeObserver().removeOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    this.jdField_a_of_type_Bbml.c();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Bbml.c(paramInt);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onCreate() called " + Integer.toHexString(System.identityHashCode(this)));
    }
    getViewTreeObserver().removeOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    if (!this.jdField_a_of_type_Bbml.a()) {
      this.jdField_a_of_type_Bbml.a();
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
    this.jdField_a_of_type_Bbml.d();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onAttachedToWindow() called " + Integer.toHexString(System.identityHashCode(this)));
    }
    if (this.jdField_a_of_type_Bbml != null) {
      a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      QLog.d("QQBlurView", 2, "onDetachedFromWindow() called " + Integer.toHexString(System.identityHashCode(this)));
    }
    if (this.jdField_a_of_type_Bbml != null) {
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
        this.jdField_a_of_type_Bbml.a(this, paramCanvas);
        super.onDraw(paramCanvas);
      }
    }
    else {
      return;
    }
    setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    super.onDraw(paramCanvas);
  }
  
  public void setDebugTag(String paramString)
  {
    this.jdField_a_of_type_Bbml.a(paramString);
  }
  
  public void setDirtyListener(bbmm parambbmm)
  {
    this.jdField_a_of_type_Bbml.a(parambbmm);
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