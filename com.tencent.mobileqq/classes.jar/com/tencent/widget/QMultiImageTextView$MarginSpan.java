package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

class QMultiImageTextView$MarginSpan
  extends ReplacementSpan
{
  private int mMarginPix;
  
  public QMultiImageTextView$MarginSpan(int paramInt)
  {
    this.mMarginPix = paramInt;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint) {}
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return this.mMarginPix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.QMultiImageTextView.MarginSpan
 * JD-Core Version:    0.7.0.1
 */