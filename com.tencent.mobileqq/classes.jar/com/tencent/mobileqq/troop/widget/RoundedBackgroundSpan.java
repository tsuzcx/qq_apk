package com.tencent.mobileqq.troop.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

public class RoundedBackgroundSpan
  extends ReplacementSpan
{
  private int jdField_a_of_type_Int = 8;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int b = 0;
  private int c = 0;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public RoundedBackgroundSpan(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
    this.d = paramInt5;
    this.e = paramInt4;
  }
  
  private float a(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + this.d + this.e;
  }
  
  public void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.g = paramInt1;
    this.h = paramInt2;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.g, this.h);
    }
    this.f = paramInt3;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    RectF localRectF = new RectF(paramFloat, paramInt3, a(paramPaint, paramCharSequence, paramInt1, paramInt2) + paramFloat, paramInt5);
    paramPaint.setColor(this.b);
    paramCanvas.drawRoundRect(localRectF, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, paramPaint);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      paramCanvas.save();
      f1 = (localRectF.height() - this.h) / 2.0F;
      paramCanvas.translate(this.f, f1);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramPaint.setColor(this.c);
    paramCanvas.save();
    paramCanvas.translate(this.e, 0.0F);
    Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
    float f1 = (localFontMetrics.bottom - localFontMetrics.top) / 2.0F;
    float f2 = localFontMetrics.bottom;
    paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, localRectF.centerY() + (f1 - f2), paramPaint);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return Math.round(a(paramPaint, paramCharSequence, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RoundedBackgroundSpan
 * JD-Core Version:    0.7.0.1
 */