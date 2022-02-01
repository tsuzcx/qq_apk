package com.tencent.mobileqq.troop.troopsetting.ui;

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
  private int a = 8;
  private int b = 0;
  private int c = 0;
  private int d;
  private int e;
  private Drawable f;
  private int g;
  private int h;
  private int i;
  
  public RoundedBackgroundSpan(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = paramInt3;
    this.d = paramInt5;
    this.e = paramInt4;
  }
  
  private float a(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + this.d + this.e;
  }
  
  public void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramDrawable;
    this.h = paramInt1;
    this.i = paramInt2;
    paramDrawable = this.f;
    if (paramDrawable != null) {
      paramDrawable.setBounds(0, 0, this.h, this.i);
    }
    this.g = paramInt3;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    RectF localRectF = new RectF(paramFloat, paramInt3, a(paramPaint, paramCharSequence, paramInt1, paramInt2) + paramFloat, paramInt5);
    paramPaint.setColor(this.b);
    paramInt3 = this.a;
    paramCanvas.drawRoundRect(localRectF, paramInt3, paramInt3, paramPaint);
    if (this.f != null)
    {
      paramCanvas.save();
      f1 = (localRectF.height() - this.i) / 2.0F;
      paramCanvas.translate(this.g, f1);
      this.f.draw(paramCanvas);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.ui.RoundedBackgroundSpan
 * JD-Core Version:    0.7.0.1
 */