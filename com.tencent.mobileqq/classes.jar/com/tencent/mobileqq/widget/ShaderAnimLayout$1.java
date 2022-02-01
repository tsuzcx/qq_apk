package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ShaderAnimLayout$1
  extends Animation
{
  ShaderAnimLayout$1(ShaderAnimLayout paramShaderAnimLayout) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.this$0.mHide == true) {}
    for (this.this$0.mAnimFactor = (1.0F - paramFloat);; this.this$0.mAnimFactor = paramFloat)
    {
      this.this$0.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ShaderAnimLayout.1
 * JD-Core Version:    0.7.0.1
 */