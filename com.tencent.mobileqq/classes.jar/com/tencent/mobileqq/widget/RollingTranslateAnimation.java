package com.tencent.mobileqq.widget;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RollingTranslateAnimation
  extends Animation
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.i;
    f1 += (this.j - f1) * paramFloat;
    if ((this.m == 0.0F) && (this.n == 0.0F)) {
      paramTransformation.getMatrix().setRotate(f1);
    } else {
      paramTransformation.getMatrix().setRotate(f1, this.m, this.n);
    }
    float f3 = this.jdField_e_of_type_Float;
    float f2 = this.g;
    float f4 = this.jdField_f_of_type_Float;
    f1 = f3;
    if (f3 != f4) {
      f1 = f3 + (f4 - f3) * paramFloat;
    }
    f3 = this.g;
    f4 = this.h;
    if (f3 != f4) {
      f2 = f3 + (f4 - f3) * paramFloat;
    }
    paramTransformation.getMatrix().postTranslate(f1, f2);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_e_of_type_Float = resolveSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float, paramInt1, paramInt3);
    this.jdField_f_of_type_Float = resolveSize(this.jdField_b_of_type_Int, this.jdField_b_of_type_Float, paramInt1, paramInt3);
    this.g = resolveSize(this.jdField_c_of_type_Int, this.jdField_c_of_type_Float, paramInt2, paramInt4);
    this.h = resolveSize(this.jdField_d_of_type_Int, this.jdField_d_of_type_Float, paramInt2, paramInt4);
    this.m = resolveSize(this.jdField_e_of_type_Int, this.k, paramInt1, paramInt3);
    this.n = resolveSize(this.jdField_f_of_type_Int, this.l, paramInt2, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RollingTranslateAnimation
 * JD-Core Version:    0.7.0.1
 */