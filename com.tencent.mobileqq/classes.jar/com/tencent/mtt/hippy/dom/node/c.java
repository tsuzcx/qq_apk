package com.tencent.mtt.hippy.dom.node;

import android.annotation.TargetApi;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

@TargetApi(21)
public class c
  extends MetricAffectingSpan
{
  float a;
  
  public c(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (!Float.isNaN(this.a)) {
      paramTextPaint.setLetterSpacing(this.a / paramTextPaint.getTextSize());
    }
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    if (!Float.isNaN(this.a)) {
      paramTextPaint.setLetterSpacing(this.a / paramTextPaint.getTextSize());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.c
 * JD-Core Version:    0.7.0.1
 */