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
    paramInt1 = (this.lineHeight - (paramFontMetricsInt.descent - paramFontMetricsInt.ascent)) / 2;
    paramFontMetricsInt.top -= paramInt1;
    paramFontMetricsInt.bottom += paramInt1;
    paramFontMetricsInt.ascent -= paramInt1;
    paramFontMetricsInt.descent += paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.VLineHeightSpan
 * JD-Core Version:    0.7.0.1
 */