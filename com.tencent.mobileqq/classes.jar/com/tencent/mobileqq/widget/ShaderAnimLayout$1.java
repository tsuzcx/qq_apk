package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ShaderAnimLayout$1
  extends Animation
{
  ShaderAnimLayout$1(ShaderAnimLayout paramShaderAnimLayout) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.a.jdField_a_of_type_Boolean == true) {
      this.a.jdField_a_of_type_Float = (1.0F - paramFloat);
    } else {
      this.a.jdField_a_of_type_Float = paramFloat;
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ShaderAnimLayout.1
 * JD-Core Version:    0.7.0.1
 */