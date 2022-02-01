package com.tencent.mtt.hippy.dom.node;

import android.annotation.TargetApi;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

@TargetApi(21)
public class d
  extends MetricAffectingSpan
{
  final float a;
  
  public d(float paramFloat)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.d
 * JD-Core Version:    0.7.0.1
 */