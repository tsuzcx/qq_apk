package com.tencent.mtt.hippy.dom.node;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public class d
  implements LineHeightSpan
{
  private int a;
  
  public d(float paramFloat)
  {
    this.a = ((int)Math.ceil(paramFloat));
  }
  
  public void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt.descent > this.a)
    {
      paramInt1 = Math.min(this.a, paramFontMetricsInt.descent);
      paramFontMetricsInt.descent = paramInt1;
      paramFontMetricsInt.bottom = paramInt1;
      paramFontMetricsInt.ascent = 0;
      paramFontMetricsInt.top = 0;
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent > this.a)
    {
      paramFontMetricsInt.bottom = paramFontMetricsInt.descent;
      paramInt1 = -this.a + paramFontMetricsInt.descent;
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.bottom > this.a)
    {
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = (paramFontMetricsInt.ascent + this.a);
      return;
    }
    if (-paramFontMetricsInt.top + paramFontMetricsInt.bottom > this.a)
    {
      paramFontMetricsInt.top = (paramFontMetricsInt.bottom - this.a);
      return;
    }
    paramInt1 = this.a - (-paramFontMetricsInt.top + paramFontMetricsInt.bottom);
    paramFontMetricsInt.top = ((int)(paramFontMetricsInt.top - Math.ceil(paramInt1 / 2.0F)));
    double d = paramFontMetricsInt.bottom;
    paramFontMetricsInt.bottom = ((int)(Math.floor(paramInt1 / 2.0F) + d));
    paramFontMetricsInt.ascent = paramFontMetricsInt.top;
    paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.d
 * JD-Core Version:    0.7.0.1
 */