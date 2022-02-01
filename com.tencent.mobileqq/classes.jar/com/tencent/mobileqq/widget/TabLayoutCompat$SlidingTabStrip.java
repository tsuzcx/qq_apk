package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.widget.FastOutSlowInInterpolator;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.view.ViewCompat;

class TabLayoutCompat$SlidingTabStrip
  extends LinearLayout
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f;
  private int g;
  private int h;
  
  TabLayoutCompat$SlidingTabStrip(TabLayoutCompat paramTabLayoutCompat, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  private void a()
  {
    View localView = getChildAt(this.jdField_a_of_type_Int);
    int i;
    int j;
    if ((localView != null) && (localView.getWidth() > 0))
    {
      int m = localView.getLeft();
      int k = localView.getRight();
      i = k;
      j = m;
      if (this.jdField_a_of_type_Float > 0.0F)
      {
        i = k;
        j = m;
        if (this.jdField_a_of_type_Int < getChildCount() - 1)
        {
          localView = getChildAt(this.jdField_a_of_type_Int + 1);
          float f1 = this.jdField_a_of_type_Float;
          float f2 = localView.getLeft();
          float f3 = this.jdField_a_of_type_Float;
          j = (int)(f1 * f2 + (1.0F - f3) * m);
          i = (int)(f3 * localView.getRight() + (1.0F - this.jdField_a_of_type_Float) * k);
        }
      }
    }
    else
    {
      j = -1;
      i = -1;
    }
    a(j, i);
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint.getColor() != paramInt)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void a(int paramInt, float paramFloat)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat;
    a();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.d) || (paramInt2 != this.e))
    {
      this.d = paramInt1;
      this.e = paramInt2;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  boolean a()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (getChildAt(i).getWidth() <= 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  void b(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    int i;
    if (ViewCompat.getLayoutDirection(this) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = getChildAt(paramInt1);
    if (localObject == null)
    {
      a();
      return;
    }
    int k = ((View)localObject).getLeft();
    int m = ((View)localObject).getRight();
    int j;
    if (Math.abs(paramInt1 - this.jdField_a_of_type_Int) <= 1)
    {
      i = this.d;
      j = this.e;
    }
    else
    {
      j = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.a(24);
      if (paramInt1 < this.jdField_a_of_type_Int ? i == 0 : i != 0) {
        i = j + m;
      } else {
        i = k - j;
      }
      j = i;
    }
    if ((i != k) || (j != m))
    {
      localObject = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setInterpolator(new FastOutSlowInInterpolator());
      ((ValueAnimator)localObject).setDuration(paramInt2);
      ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).addUpdateListener(new TabLayoutCompat.SlidingTabStrip.1(this, i, k, j, m));
      ((ValueAnimator)localObject).addListener(new TabLayoutCompat.SlidingTabStrip.2(this, paramInt1));
      ((ValueAnimator)localObject).start();
    }
  }
  
  void c(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void d(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = this.d;
    if ((i >= 0) && (this.e > i)) {
      paramCanvas.drawRect(i + this.f, getHeight() - this.b - this.h, this.e - this.g, getHeight() - this.h, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void e(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      long l = this.jdField_a_of_type_AndroidAnimationValueAnimator.getDuration();
      b(this.jdField_a_of_type_Int, Math.round((1.0F - this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedFraction()) * (float)l));
      return;
    }
    a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.i;
    int n = 1;
    if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.h == 1))
    {
      int i1 = getChildCount();
      int m = 0;
      i = 0;
      Object localObject;
      int k;
      for (int j = 0; i < i1; j = k)
      {
        localObject = getChildAt(i);
        k = j;
        if (((View)localObject).getVisibility() == 0) {
          k = Math.max(j, ((View)localObject).getMeasuredWidth());
        }
        i += 1;
      }
      if (j <= 0) {
        return;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.a(16);
      if (j * i1 <= getMeasuredWidth() - i * 2)
      {
        i = 0;
        k = m;
        while (k < i1)
        {
          localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
          if ((((LinearLayout.LayoutParams)localObject).width != j) || (((LinearLayout.LayoutParams)localObject).weight != 0.0F))
          {
            ((LinearLayout.LayoutParams)localObject).width = j;
            ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
            i = 1;
          }
          k += 1;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat;
        ((TabLayoutCompat)localObject).h = 0;
        ((TabLayoutCompat)localObject).c(false);
        i = n;
      }
      if (i != 0) {
        super.onMeasure(paramInt1, paramInt2);
      }
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if ((Build.VERSION.SDK_INT < 23) && (this.c != paramInt))
    {
      requestLayout();
      this.c = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.SlidingTabStrip
 * JD-Core Version:    0.7.0.1
 */