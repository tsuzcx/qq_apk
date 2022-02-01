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
    float f1 = (localFontMetricsInt.top + paramInt4 + paramInt4 + localFontMetricsInt.bottom) / 2 - (paramInt5 + paramInt3) / 2;
    float f2 = this.offset;
    if (f2 != 0.0F) {
      f1 = f2;
    }
    paramCanvas.drawText(paramCharSequence.toString(), paramFloat, paramInt4 - f1, paramPaint);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    return (int)getCustomTextPaint(paramPaint).measureText(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView.VerticalCenterTextSpan
 * JD-Core Version:    0.7.0.1
 */