package com.tencent.mobileqq.widget.bounce;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator
  implements Interpolator
{
  private final float jdField_a_of_type_Float;
  private final float[] jdField_a_of_type_ArrayOfFloat;
  
  public LookupTableInterpolator(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
    this.jdField_a_of_type_Float = (1.0F / (this.jdField_a_of_type_ArrayOfFloat.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.jdField_a_of_type_ArrayOfFloat.length - 1) * paramFloat), this.jdField_a_of_type_ArrayOfFloat.length - 2);
    paramFloat = (paramFloat - i * this.jdField_a_of_type_Float) / this.jdField_a_of_type_Float;
    float f = this.jdField_a_of_type_ArrayOfFloat[i];
    return (this.jdField_a_of_type_ArrayOfFloat[(i + 1)] - this.jdField_a_of_type_ArrayOfFloat[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.bounce.LookupTableInterpolator
 * JD-Core Version:    0.7.0.1
 */