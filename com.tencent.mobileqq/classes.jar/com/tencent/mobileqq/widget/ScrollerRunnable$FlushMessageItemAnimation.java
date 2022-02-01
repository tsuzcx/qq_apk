package com.tencent.mobileqq.widget;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ScrollerRunnable$FlushMessageItemAnimation
  extends Animation
{
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private float b;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.jdField_a_of_type_AndroidViewView;
    if (paramTransformation == null) {
      return;
    }
    float f = this.jdField_a_of_type_Float;
    paramTransformation.setBackgroundColor(Color.argb((int)((f + (this.b - f) * paramFloat) * 255.0F), 255, 255, 255));
  }
  
  public boolean willChangeBounds()
  {
    return false;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable.FlushMessageItemAnimation
 * JD-Core Version:    0.7.0.1
 */