package com.tencent.mobileqq.profilecard.vas.view;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class VasProfileWZRYView$CustomTypefaceSpan
  extends TypefaceSpan
{
  Typeface mTypeface;
  
  public VasProfileWZRYView$CustomTypefaceSpan(String paramString, Typeface paramTypeface)
  {
    super(paramString);
    this.mTypeface = paramTypeface;
  }
  
  private void apply(Paint paramPaint, Typeface paramTypeface)
  {
    Typeface localTypeface = paramPaint.getTypeface();
    int i;
    if (localTypeface == null) {
      i = 0;
    } else {
      i = localTypeface.getStyle();
    }
    i &= (paramTypeface.getStyle() ^ 0xFFFFFFFF);
    if ((i & 0x1) != 0) {
      paramPaint.setFakeBoldText(true);
    }
    if ((i & 0x2) != 0) {
      paramPaint.setTextSkewX(-0.25F);
    }
    paramPaint.setTypeface(paramTypeface);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    Typeface localTypeface = this.mTypeface;
    if (localTypeface != null)
    {
      apply(paramTextPaint, localTypeface);
      return;
    }
    super.updateDrawState(paramTextPaint);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    Typeface localTypeface = this.mTypeface;
    if (localTypeface != null)
    {
      apply(paramTextPaint, localTypeface);
      return;
    }
    super.updateMeasureState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView.CustomTypefaceSpan
 * JD-Core Version:    0.7.0.1
 */