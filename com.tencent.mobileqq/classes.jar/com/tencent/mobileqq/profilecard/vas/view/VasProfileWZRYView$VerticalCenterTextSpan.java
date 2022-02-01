package com.tencent.mobileqq.profilecard.vas.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

public class VasProfileWZRYView$VerticalCenterTextSpan
  extends ReplacementSpan
{
  private float fontSize;
  private float offset = -1.0F;
  
  public VasProfileWZRYView$VerticalCenterTextSpan(float paramFloat1, float paramFloat2)
  {
    this.fontSize = paramFloat1;
    this.offset = paramFloat2;
  }
  
  private TextPaint getCustomTextPaint(Paint paramPaint)
  {
    paramPaint = new TextPaint(paramPaint);
    paramPaint.setTextSize(this.fontSize);
    return paramPaint;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    paramPaint = getCustomTextPaint(paramPaint);
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = localFontMetricsInt.top;
    float f = (localFontMetricsInt.bottom + (paramInt1 + paramInt4 + paramInt4)) / 2 - (paramInt5 + paramInt3) / 2;
    if (this.offset != 0.0F) {
      f = this.offset;
    }
    paramCanvas.drawText(paramCharSequence.toString(), paramFloat, paramInt4 - f, paramPaint);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    return (int)getCustomTextPaint(paramPaint).measureText(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView.VerticalCenterTextSpan
 * JD-Core Version:    0.7.0.1
 */