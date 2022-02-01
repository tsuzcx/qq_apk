package com.tencent.mobileqq.remind.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Transformation;
import com.tencent.widget.VerticalGallery;

public class WheelView
  extends VerticalGallery
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { -15658735, 11184810, 11184810 };
  private float jdField_a_of_type_Float = -0.1F;
  private int jdField_a_of_type_Int;
  private Camera jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 0.8F;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private GradientDrawable jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable;
  private boolean jdField_b_of_type_Boolean;
  private float c = -25.0F;
  private boolean d;
  private int h = 80;
  private int i = -80;
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(View paramView)
  {
    int j = c(paramView);
    float f1;
    float f2;
    if (this.jdField_b_of_type_Boolean)
    {
      f1 = (this.jdField_a_of_type_Int - j) / (float)(2.2D * this.jdField_a_of_type_Int) * this.h;
      if (f1 <= this.h) {
        break label82;
      }
      f2 = this.h;
    }
    label82:
    do
    {
      return f2;
      f1 = (this.jdField_a_of_type_Int - j) / this.jdField_a_of_type_Int * this.h;
      break;
      f2 = f1;
    } while (f1 >= -this.h);
    return -this.h;
  }
  
  private int a()
  {
    return (getHeight() - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop();
  }
  
  private void a(Context paramContext)
  {
    setVerticalScrollBarEnabled(false);
    setSlotInCenter(true);
    setOrientation(2);
    setGravity(1);
    setUnselectedAlpha(0.5F);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, jdField_a_of_type_ArrayOfInt);
    this.jdField_b_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, jdField_a_of_type_ArrayOfInt);
    setSoundEffectsEnabled(true);
    setStaticTransformationsEnabled(true);
    setChildrenDrawingOrderEnabled(true);
    if (getResources().getDisplayMetrics().densityDpi <= 160) {
      this.i = -40;
    }
    ViewCompat.setImportantForAccessibility(this, 2);
  }
  
  private void a(Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      paramMatrix.preTranslate(-paramInt1 / 2, -paramInt2 / 2);
      paramMatrix.postTranslate(paramInt1 / 2, paramInt2 / 2);
      return;
    }
    if (this.d)
    {
      paramMatrix.preTranslate(-paramInt1 * 5.0F / 6.0F, -paramInt2 / 2);
      paramMatrix.postTranslate(paramInt1 * 5.0F / 6.0F, paramInt2 / 2);
      return;
    }
    paramMatrix.preTranslate(0.0F, -paramInt2 / 2);
    paramMatrix.postTranslate(0.0F, paramInt2 / 2);
  }
  
  private void a(View paramView, Transformation paramTransformation, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramTransformation.clear();
    paramTransformation.setTransformationType(3);
    Matrix localMatrix = paramTransformation.getMatrix();
    int j = paramView.getWidth();
    int k = paramView.getHeight();
    this.jdField_a_of_type_AndroidGraphicsCamera.save();
    this.jdField_a_of_type_AndroidGraphicsCamera.translate(0.0F, 0.0F, 100.0F);
    paramTransformation.setAlpha(paramFloat4);
    if ((!Build.MODEL.equals("HUAWEI Y325-T00")) && (!Build.MODEL.equals("Lenovo A318t")) && (!Build.MODEL.equals("Lenovo A308t")) && (!Build.MODEL.equals("Lenovo A269")) && (!Build.MODEL.equals("PRA-TL10")) && (!Build.MODEL.equals("HUAWEI CAZ-TL10")) && (!Build.MODEL.equals("BLN-TL10")) && (!a())) {
      this.jdField_a_of_type_AndroidGraphicsCamera.rotateX(paramFloat1);
    }
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsCamera.translate(0.0F, 0.0F, paramFloat2);
    }
    this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(localMatrix);
    if (!this.jdField_b_of_type_Boolean) {
      localMatrix.preSkew(paramFloat3, 0.0F);
    }
    localMatrix.preTranslate(paramFloat5, 0.0F);
    a(localMatrix, j, k);
    this.jdField_a_of_type_AndroidGraphicsCamera.restore();
  }
  
  public static boolean a()
  {
    if ((Build.MODEL.equals("VKY-AL00")) && (Build.VERSION.SDK_INT == 24)) {}
    while ((Build.MODEL.equals("NXT-AL10")) && (Build.VERSION.SDK_INT == 24)) {
      return true;
    }
    return false;
  }
  
  private float b(View paramView)
  {
    int j = c(paramView);
    if (j < this.jdField_a_of_type_Int) {
      return j / this.jdField_a_of_type_Int * this.i;
    }
    if (j > this.jdField_a_of_type_Int) {
      return (this.jdField_a_of_type_Int * 2 - j) / this.jdField_a_of_type_Int * this.i;
    }
    return this.i;
  }
  
  private float c(View paramView)
  {
    float f = this.jdField_b_of_type_Float;
    return (1.0F - Math.abs(c(paramView) - this.jdField_a_of_type_Int) / this.jdField_a_of_type_Int) * this.jdField_b_of_type_Float;
  }
  
  private int c(View paramView)
  {
    return paramView.getTop() + paramView.getHeight() / 2;
  }
  
  private float d(View paramView)
  {
    int j = c(paramView);
    if (this.jdField_a_of_type_Float == -0.1F) {
      return (this.jdField_a_of_type_Int - j) / this.jdField_a_of_type_Int * this.jdField_a_of_type_Float;
    }
    return (this.jdField_a_of_type_Int - j) / this.jdField_a_of_type_Int * this.jdField_a_of_type_Float;
  }
  
  private float e(View paramView)
  {
    float f = 0.0F;
    int j = c(paramView);
    if (this.jdField_a_of_type_Boolean) {
      f = Math.abs(this.jdField_a_of_type_Int - j) / this.jdField_a_of_type_Int * this.c;
    }
    return f;
  }
  
  public boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    float f1 = a(paramView);
    float f2 = b(paramView);
    float f3 = d(paramView);
    float f4 = e(paramView);
    a(paramView, paramTransformation, f1, f2, f3, c(paramView), f4);
    return true;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = a();
    paramInt2 = b();
    View localView = getChildAt(0);
    if (localView != null) {}
    for (paramInt1 = localView.getMeasuredHeight();; paramInt1 = 50)
    {
      paramInt2 -= paramInt1 / 2;
      this.jdField_b_of_type_AndroidGraphicsRect.set(getPaddingLeft(), paramInt2, getWidth() - getPaddingRight(), paramInt1 + paramInt2);
      return;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = a();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = a();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      getParent().requestDisallowInterceptTouchEvent(false);
    }
  }
  
  public void selectionChanged()
  {
    super.selectionChanged();
    playSoundEffect(0);
  }
  
  public void setNeedTranslate(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setNeedTranslateCenter(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setNeedTranslateCenterToRight(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setmMaxRotationAngle(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setmMaxSkew(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.WheelView
 * JD-Core Version:    0.7.0.1
 */