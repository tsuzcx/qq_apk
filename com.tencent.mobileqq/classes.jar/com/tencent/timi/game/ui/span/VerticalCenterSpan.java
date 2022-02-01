package com.tencent.timi.game.ui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import androidx.annotation.ColorInt;

public class VerticalCenterSpan
  extends ReplacementSpan
{
  private float a;
  private int b = 0;
  
  public VerticalCenterSpan(float paramFloat, @ColorInt int paramInt)
  {
    this.a = paramFloat;
    this.b = paramInt;
  }
  
  private TextPaint a(Paint paramPaint)
  {
    paramPaint = new TextPaint(paramPaint);
    paramPaint.setTextSize(this.a);
    int i = this.b;
    if (i != 0) {
      paramPaint.setColor(i);
    }
    return paramPaint;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    paramPaint = a(paramPaint);
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramCanvas.drawText(paramCharSequence.toString(), paramFloat, paramInt4 - ((localFontMetricsInt.descent + paramInt4 + paramInt4 + localFontMetricsInt.ascent) / 2 - (paramInt5 + paramInt3) / 2), paramPaint);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    return (int)a(paramPaint).measureText(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.span.VerticalCenterSpan
 * JD-Core Version:    0.7.0.1
 */