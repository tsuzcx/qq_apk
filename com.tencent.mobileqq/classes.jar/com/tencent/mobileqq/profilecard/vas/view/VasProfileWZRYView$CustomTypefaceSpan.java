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
    if (localTypeface == null) {}
    for (int i = 0;; i = localTypeface.getStyle())
    {
      i &= (paramTypeface.getStyle() ^ 0xFFFFFFFF);
      if ((i & 0x1) != 0) {
        paramPaint.setFakeBoldText(true);
      }
      if ((i & 0x2) != 0) {
        paramPaint.setTextSkewX(-0.25F);
      }
      paramPaint.setTypeface(paramTypeface);
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.mTypeface != null)
    {
      apply(paramTextPaint, this.mTypeface);
      return;
    }
    super.updateDrawState(paramTextPaint);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    if (this.mTypeface != null)
    {
      apply(paramTextPaint, this.mTypeface);
      return;
    }
    super.updateMeasureState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView.CustomTypefaceSpan
 * JD-Core Version:    0.7.0.1
 */