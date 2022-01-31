package com.tencent.mobileqq.jsp;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class UiApiPlugin$ExpandAnimation
  extends Animation
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramTransformation.height = ((int)(this.jdField_a_of_type_Int * paramFloat));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.ExpandAnimation
 * JD-Core Version:    0.7.0.1
 */