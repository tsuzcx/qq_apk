package com.tencent.mobileqq.troop.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

public class BgTextSpan
  extends ReplacementSpan
{
  private int a;
  private String b;
  private float c;
  private float d;
  private float e;
  private float f;
  private int g;
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = new Paint();
    paramCharSequence.setColor(this.a);
    paramCharSequence.setStyle(Paint.Style.FILL);
    paramCharSequence.setAntiAlias(true);
    paramPaint = paramPaint.getFontMetrics();
    float f1 = paramPaint.descent;
    float f2 = paramPaint.ascent;
    f1 = paramInt4 + (f1 - f2 - this.c) / 2.0F + paramPaint.ascent;
    paramCanvas.drawRoundRect(new RectF(paramFloat, f1, this.d + paramFloat, this.c + f1), 0.0F, 0.0F, paramCharSequence);
    paramCharSequence = new TextPaint();
    paramCharSequence.setColor(this.g);
    paramCharSequence.setTextSize(this.f);
    paramCharSequence.setAntiAlias(true);
    paramCharSequence.setTextAlign(Paint.Align.CENTER);
    paramPaint = paramCharSequence.getFontMetrics();
    f2 = paramPaint.bottom;
    float f3 = paramPaint.top;
    paramCanvas.drawText(this.b, paramFloat + this.d / 2.0F, f1 + (this.c - (f2 - f3)) / 2.0F - paramPaint.top, paramCharSequence);
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return (int)(this.d + this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.BgTextSpan
 * JD-Core Version:    0.7.0.1
 */