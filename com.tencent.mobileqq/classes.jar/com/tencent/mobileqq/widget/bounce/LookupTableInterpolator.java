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
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    int i = Math.min((int)((arrayOfFloat.length - 1) * paramFloat), arrayOfFloat.length - 2);
    float f1 = i;
    float f2 = this.jdField_a_of_type_Float;
    paramFloat = (paramFloat - f1 * f2) / f2;
    arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    return arrayOfFloat[i] + paramFloat * (arrayOfFloat[(i + 1)] - arrayOfFloat[i]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.bounce.LookupTableInterpolator
 * JD-Core Version:    0.7.0.1
 */