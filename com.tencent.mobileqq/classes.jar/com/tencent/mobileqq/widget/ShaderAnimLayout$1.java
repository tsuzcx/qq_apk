package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ShaderAnimLayout$1
  extends Animation
{
  ShaderAnimLayout$1(ShaderAnimLayout paramShaderAnimLayout) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.a.b == true) {
      this.a.a = (1.0F - paramFloat);
    } else {
      this.a.a = paramFloat;
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ShaderAnimLayout.1
 * JD-Core Version:    0.7.0.1
 */