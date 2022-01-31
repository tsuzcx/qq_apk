package com.tencent.mobileqq.jsp;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class UiApiPlugin$ReduceAnimation
  extends Animation
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramTransformation.height = ((int)(this.jdField_a_of_type_Int * (1.0F - paramFloat)));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramTransformation);
    if (paramFloat == 1.0F)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramTransformation.height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramTransformation);
    }
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.ReduceAnimation
 * JD-Core Version:    0.7.0.1
 */