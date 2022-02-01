package com.tencent.mtt.hippy.dom.node;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;

public class h
  extends MetricAffectingSpan
{
  private final int a;
  private final int b;
  private final String c;
  private final HippyFontScaleAdapter d;
  
  public h(int paramInt1, int paramInt2, String paramString, HippyFontScaleAdapter paramHippyFontScaleAdapter)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
    this.d = paramHippyFontScaleAdapter;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    TypeFaceUtil.apply(paramTextPaint, this.a, this.b, this.c, this.d);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    TypeFaceUtil.apply(paramTextPaint, this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.h
 * JD-Core Version:    0.7.0.1
 */