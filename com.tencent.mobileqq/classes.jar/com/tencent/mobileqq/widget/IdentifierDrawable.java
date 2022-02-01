package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;

public class IdentifierDrawable
  extends Drawable
{
  public static int a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  public int b = Color.argb(255, 137, 208, 67);
  public int c = Color.argb(255, 255, 66, 34);
  private int d;
  private int e = -872415232;
  private int f = 0;
  private int g;
  private int h;
  private int i;
  private int j = Color.argb(127, 255, 255, 255);
  private int k = -1;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new IdentifierDrawable.1(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(3000L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void c(int paramInt)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()) && (paramInt == 7)) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      paramInt = this.g;
      if (paramInt == 6)
      {
        a();
        return;
      }
      c(paramInt);
      this.k = -1;
      invalidateSelf();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Object localObject = getBounds();
    paramCanvas.save();
    int i1 = ((Rect)localObject).centerX();
    int i2 = ((Rect)localObject).centerY();
    int i3 = this.h;
    paramCanvas.clipRect((Rect)localObject);
    paramCanvas.drawColor(this.e);
    if (this.g > jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      float f1 = i1;
      float f2 = i2;
      float f3 = i3;
      paramCanvas.drawCircle(f1, f2, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      int i4 = this.g;
      if (i4 > 1)
      {
        int n = this.b;
        int m = n;
        switch (i4)
        {
        default: 
          m = n;
          break;
        case 7: 
          m = -1;
          break;
        case 5: 
        case 6: 
          m = this.j;
          break;
        case 2: 
        case 4: 
          m = this.c;
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(m);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.i);
        paramCanvas.drawCircle(f1, f2, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (this.k != -1)
        {
          localObject = new RectF(i1 - i3, i2 - i3, i1 + i3, i2 + i3);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.i);
          paramCanvas.drawArc((RectF)localObject, 270.0F, this.k / 100.0F * 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
    }
    paramCanvas.restore();
  }
  
  public int getOpacity()
  {
    return this.d;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IdentifierDrawable
 * JD-Core Version:    0.7.0.1
 */