package com.tencent.viola.ui.dom;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public class VLineHeightSpan
  implements LineHeightSpan
{
  private int lineHeight;
  
  public VLineHeightSpan(int paramInt)
  {
    this.lineHeight = paramInt;
  }
  
  public void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramInt2 = (this.lineHeight - (paramFontMetricsInt.descent - paramFontMetricsInt.ascent)) / 2;
    paramFontMetricsInt.top -= paramInt2;
    if (paramInt1 == 0) {}
    paramFontMetricsInt.bottom += paramInt2;
    paramFontMetricsInt.ascent -= paramInt2;
    paramFontMetricsInt.descent = (paramInt2 + paramFontMetricsInt.descent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.dom.VLineHeightSpan
 * JD-Core Version:    0.7.0.1
 */