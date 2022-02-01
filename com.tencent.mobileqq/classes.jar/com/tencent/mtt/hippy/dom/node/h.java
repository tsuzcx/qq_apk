package com.tencent.mtt.hippy.dom.node;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class h
  extends MetricAffectingSpan
{
  private final int a;
  private final int b;
  private final String c;
  
  public h(int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    TypeFaceUtil.apply(paramTextPaint, this.a, this.b, this.c);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    TypeFaceUtil.apply(paramTextPaint, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.h
 * JD-Core Version:    0.7.0.1
 */