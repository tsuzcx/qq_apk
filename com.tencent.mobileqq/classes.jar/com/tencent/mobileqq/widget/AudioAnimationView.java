package com.tencent.mobileqq.widget;

import alak;
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
  public volatile boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private Rect[] jdField_a_of_type_ArrayOfAndroidGraphicsRect;
  private int b;
  private int c;
  private int d = 7;
  private int e = 1;
  
  public AudioAnimationView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
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
  
  public void b()
  {
    int j = (int)(this.c * 0.6777F);
    int i = 0;
    while (i < this.d)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((int)(j * Math.random()));
      i += 1;
    }
  }
  
  public void c()
  {
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioAnimationView", 2, "startAnimation(), mRunning= " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new alak(this, null));
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioAnimationView", 2, "stopAnimation(), mRunning= " + this.jdField_a_of_type_Boolean);
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
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      if (i < this.d)
      {
        Rect localRect = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i];
        int k = this.jdField_a_of_type_Int;
        int m = this.b;
        int n = this.jdField_a_of_type_ArrayOfInt[i];
        int i1 = this.jdField_a_of_type_Int;
        int i2 = this.b;
        int j = this.c;
        if (this.e == 1) {}
        for (j = this.c - this.jdField_a_of_type_ArrayOfInt[i];; j = this.c)
        {
          localRect.set((k + m) * i, n, i2 * i + i1 * (i + 1), j);
          paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          i += 1;
          break;
        }
      }
    }
    else if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt1 = this.d;
      paramInt2 = this.jdField_a_of_type_Int;
      paramInt2 = (this.d - 1) * this.b + paramInt1 * paramInt2;
      paramInt1 = this.c;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        paramInt2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      }
      else
      {
        paramInt2 = 0;
        paramInt1 = i;
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    }
    requestLayout();
    invalidate();
  }
  
  public void setRectCount(int paramInt)
  {
    this.d = paramInt;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRect = new Rect[this.d];
    this.jdField_a_of_type_ArrayOfInt = new int[this.d];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AudioAnimationView
 * JD-Core Version:    0.7.0.1
 */