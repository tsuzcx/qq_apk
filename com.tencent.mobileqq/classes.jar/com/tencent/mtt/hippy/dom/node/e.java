package com.tencent.mtt.hippy.dom.node;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public class e
  implements LineHeightSpan
{
  private final int a;
  
  public e(float paramFloat)
  {
    this.a = ((int)Math.ceil(paramFloat));
  }
  
  public void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramInt1 = paramFontMetricsInt.descent;
    paramInt2 = this.a;
    if (paramInt1 > paramInt2)
    {
      paramInt1 = Math.min(paramInt2, paramFontMetricsInt.descent);
      paramFontMetricsInt.descent = paramInt1;
      paramFontMetricsInt.bottom = paramInt1;
      paramInt1 = 0;
      paramFontMetricsInt.ascent = paramInt1;
    }
    for (;;)
    {
      paramFontMetricsInt.top = paramInt1;
      return;
      if (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent > this.a)
      {
        paramFontMetricsInt.bottom = paramFontMetricsInt.descent;
        paramInt1 = -this.a + paramFontMetricsInt.descent;
        break;
      }
      if (-paramFontMetricsInt.ascent + paramFontMetricsInt.bottom > this.a)
      {
        paramFontMetricsInt.top = paramFontMetricsInt.ascent;
        paramFontMetricsInt.bottom = (paramFontMetricsInt.ascent + this.a);
        return;
      }
      paramInt2 = -paramFontMetricsInt.top;
      paramInt3 = paramFontMetricsInt.bottom;
      paramInt1 = this.a;
      if (paramInt2 + paramInt3 <= paramInt1) {
        break label183;
      }
      paramInt1 = paramFontMetricsInt.bottom - this.a;
    }
    label183:
    paramInt2 = -paramFontMetricsInt.top;
    paramInt3 = paramFontMetricsInt.bottom;
    double d2 = paramFontMetricsInt.top;
    double d1 = (paramInt1 - (paramInt2 + paramInt3)) / 2.0F;
    double d3 = Math.ceil(d1);
    Double.isNaN(d2);
    paramFontMetricsInt.top = ((int)(d2 - d3));
    d2 = paramFontMetricsInt.bottom;
    d1 = Math.floor(d1);
    Double.isNaN(d2);
    paramFontMetricsInt.bottom = ((int)(d2 + d1));
    paramFontMetricsInt.ascent = paramFontMetricsInt.top;
    paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.e
 * JD-Core Version:    0.7.0.1
 */