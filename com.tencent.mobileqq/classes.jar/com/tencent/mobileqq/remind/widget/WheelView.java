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
  private static final int[] d = { -15658735, 11184810, 11184810 };
  private Rect a = new Rect();
  private GradientDrawable b = null;
  private GradientDrawable c = null;
  private Camera e = new Camera();
  private int f = 0;
  private int g = 80;
  private int h = -80;
  private float i = -0.1F;
  private float j = 0.8F;
  private float k = -25.0F;
  private boolean l;
  private boolean m;
  private boolean n;
  
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
  
  private int a(View paramView)
  {
    return paramView.getTop() + paramView.getHeight() / 2;
  }
  
  private void a(Context paramContext)
  {
    setVerticalScrollBarEnabled(false);
    setSlotInCenter(true);
    setOrientation(2);
    setGravity(1);
    setUnselectedAlpha(0.5F);
    setWillNotDraw(false);
    this.b = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, d);
    this.c = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, d);
    setSoundEffectsEnabled(true);
    setStaticTransformationsEnabled(true);
    setChildrenDrawingOrderEnabled(true);
    if (getResources().getDisplayMetrics().densityDpi <= 160) {
      this.h = -40;
    }
    ViewCompat.setImportantForAccessibility(this, 2);
  }
  
  private void a(Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    if (!this.m)
    {
      paramMatrix.preTranslate(-paramInt1 / 2, -paramInt2 / 2);
      paramMatrix.postTranslate(paramInt1 / 2, paramInt2 / 2);
      return;
    }
    if (this.n)
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
    int i1 = paramView.getWidth();
    int i2 = paramView.getHeight();
    this.e.save();
    this.e.translate(0.0F, 0.0F, 100.0F);
    paramTransformation.setAlpha(paramFloat4);
    if ((!Build.MODEL.equals("HUAWEI Y325-T00")) && (!Build.MODEL.equals("Lenovo A318t")) && (!Build.MODEL.equals("Lenovo A308t")) && (!Build.MODEL.equals("Lenovo A269")) && (!Build.MODEL.equals("PRA-TL10")) && (!Build.MODEL.equals("HUAWEI CAZ-TL10")) && (!Build.MODEL.equals("BLN-TL10")) && (!a())) {
      this.e.rotateX(paramFloat1);
    }
    if (!this.m) {
      this.e.translate(0.0F, 0.0F, paramFloat2);
    }
    this.e.getMatrix(localMatrix);
    if (!this.m) {
      localMatrix.preSkew(paramFloat3, 0.0F);
    }
    localMatrix.preTranslate(paramFloat5, 0.0F);
    a(localMatrix, i1, i2);
    this.e.restore();
  }
  
  public static boolean a()
  {
    if ((Build.MODEL.equals("VKY-AL00")) && (Build.VERSION.SDK_INT == 24)) {
      return true;
    }
    return (Build.MODEL.equals("NXT-AL10")) && (Build.VERSION.SDK_INT == 24);
  }
  
  private float b(View paramView)
  {
    int i1 = a(paramView);
    int i2;
    if (this.m)
    {
      i2 = this.f;
      f1 = i2 - i1;
      double d1 = i2;
      Double.isNaN(d1);
      f1 /= (float)(d1 * 2.2D);
      i1 = this.g;
    }
    else
    {
      i2 = this.f;
      f1 = (i2 - i1) / i2;
      i1 = this.g;
    }
    float f2 = f1 * i1;
    i1 = this.g;
    if (f2 > i1) {
      return i1;
    }
    float f1 = f2;
    if (f2 < -i1) {
      f1 = -i1;
    }
    return f1;
  }
  
  private float c(View paramView)
  {
    int i1 = a(paramView);
    int i2 = this.f;
    float f1;
    if (i1 < i2) {
      f1 = i1 / i2;
    }
    for (i1 = this.h;; i1 = this.h)
    {
      return f1 * i1;
      if (i1 <= i2) {
        break;
      }
      f1 = (i2 * 2 - i1) / i2;
    }
    return this.h;
  }
  
  private float d(View paramView)
  {
    float f1 = this.j;
    return (1.0F - Math.abs(a(paramView) - this.f) / this.f) * this.j;
  }
  
  private float e(View paramView)
  {
    int i2 = a(paramView);
    float f1 = this.i;
    int i1;
    if (f1 == -0.1F) {
      i1 = this.f;
    } else {
      i1 = this.f;
    }
    return (i1 - i2) / i1 * f1;
  }
  
  private float f(View paramView)
  {
    int i1 = a(paramView);
    if (this.l) {
      return Math.abs(this.f - i1) / this.f * this.k;
    }
    return 0.0F;
  }
  
  private int getCenterOfCoverflow()
  {
    return (getHeight() - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop();
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    float f1 = b(paramView);
    float f2 = c(paramView);
    float f3 = e(paramView);
    float f4 = f(paramView);
    a(paramView, paramTransformation, f1, f2, f3, d(paramView), f4);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = getCenterOfCoverflow();
    paramInt2 = getCenterOfGallery();
    View localView = getChildAt(0);
    if (localView != null) {
      paramInt1 = localView.getMeasuredHeight();
    } else {
      paramInt1 = 50;
    }
    paramInt2 -= paramInt1 / 2;
    this.a.set(getPaddingLeft(), paramInt2, getWidth() - getPaddingRight(), paramInt1 + paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.f = getCenterOfCoverflow();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = getCenterOfCoverflow();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 != 3) {
          break label46;
        }
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        break label46;
      }
    }
    getParent().requestDisallowInterceptTouchEvent(false);
    label46:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void selectionChanged()
  {
    super.selectionChanged();
    playSoundEffect(0);
  }
  
  public void setNeedTranslate(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setNeedTranslateCenter(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setNeedTranslateCenterToRight(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setmMaxRotationAngle(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setmMaxSkew(float paramFloat)
  {
    this.i = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.WheelView
 * JD-Core Version:    0.7.0.1
 */