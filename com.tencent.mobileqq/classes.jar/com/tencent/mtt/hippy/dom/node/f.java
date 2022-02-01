package com.tencent.mtt.hippy.dom.node;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

public class f
  extends CharacterStyle
{
  private final float a;
  private final float b;
  private final float c;
  private final int d;
  
  public f(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramInt;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setShadowLayer(this.c, this.a, this.b, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.f
 * JD-Core Version:    0.7.0.1
 */