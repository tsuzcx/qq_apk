package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class AudioAnimationView
  extends View
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  volatile boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt;
  private Rect[] jdField_a_of_type_ArrayOfAndroidGraphicsRect;
  private int b;
  private int c;
  private int d = 7;
  private int e = 1;
  
  public AudioAnimationView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static int a(int paramInt, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    this.jdField_a_of_type_Int = a(2, getResources());
    this.b = a(2, getResources());
    this.c = a(12, getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(4.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(204);
  }
  
  void b()
  {
    int j = (int)(this.c * 0.6777F);
    int i = 0;
    while (i < this.d)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      double d1 = j;
      double d2 = Math.random();
      Double.isNaN(d1);
      arrayOfInt[i] = ((int)(d1 * d2));
      i += 1;
    }
  }
  
  public void c()
  {
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startAnimation(), mRunning= ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("AudioAnimationView", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new AudioAnimationView.Animator(this, null));
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopAnimation(), mRunning= ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("AudioAnimationView", 2, localStringBuilder.toString());
    }
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      requestLayout();
      invalidate();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      int k;
      for (int i = 0; i < this.d; i = k)
      {
        localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i];
        int n = this.jdField_a_of_type_Int;
        int i1 = this.b;
        int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        int i2 = arrayOfInt[i];
        k = i + 1;
        int m = this.c;
        int j = m;
        if (this.e == 1) {
          j = m - arrayOfInt[i];
        }
        ((Rect)localObject).set((n + i1) * i, i2, n * k + i1 * i, j);
        paramCanvas.drawRect((Rect)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null) {
      ((Drawable)localObject).draw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    boolean bool = this.jdField_a_of_type_Boolean;
    paramInt2 = 0;
    if (bool)
    {
      paramInt1 = this.d;
      paramInt2 = this.jdField_a_of_type_Int * paramInt1 + (paramInt1 - 1) * this.b;
      paramInt1 = this.c;
    }
    else
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        paramInt2 = localDrawable.getIntrinsicWidth();
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      }
      else
      {
        paramInt1 = 0;
      }
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setColor(int paramInt)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setColor(paramInt);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    paramDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (paramDrawable != null) {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    }
    requestLayout();
    invalidate();
  }
  
  public void setRectCount(int paramInt)
  {
    this.d = paramInt;
    paramInt = this.d;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRect = new Rect[paramInt];
    this.jdField_a_of_type_ArrayOfInt = new int[paramInt];
    paramInt = 0;
    while (paramInt <= this.d - 1)
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt] = new Rect();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
      paramInt += 1;
    }
    b();
    requestLayout();
    invalidate();
  }
  
  public void setRectHeightMax(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setRectInterval(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setRectWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setSyle(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AudioAnimationView
 * JD-Core Version:    0.7.0.1
 */