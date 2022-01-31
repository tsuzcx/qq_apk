package com.tencent.mobileqq.profile.view;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class VipProfileWZRYView$CustomTypefaceSpan
  extends TypefaceSpan
{
  Typeface a;
  
  public VipProfileWZRYView$CustomTypefaceSpan(String paramString, Typeface paramTypeface)
  {
    super(paramString);
    this.a = paramTypeface;
  }
  
  private void a(Paint paramPaint, Typeface paramTypeface)
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
    if (this.a != null)
    {
      a(paramTextPaint, this.a);
      return;
    }
    super.updateDrawState(paramTextPaint);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    if (this.a != null)
    {
      a(paramTextPaint, this.a);
      return;
    }
    super.updateMeasureState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipProfileWZRYView.CustomTypefaceSpan
 * JD-Core Version:    0.7.0.1
 */