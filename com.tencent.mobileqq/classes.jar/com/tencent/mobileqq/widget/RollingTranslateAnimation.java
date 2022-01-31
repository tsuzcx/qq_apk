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
    float f1 = this.i + (this.j - this.i) * paramFloat;
    if ((this.m == 0.0F) && (this.n == 0.0F)) {
      paramTransformation.getMatrix().setRotate(f1);
    }
    for (;;)
    {
      f1 = this.jdField_e_of_type_Float;
      float f2 = this.g;
      if (this.jdField_e_of_type_Float != this.jdField_f_of_type_Float) {
        f1 = this.jdField_e_of_type_Float + (this.jdField_f_of_type_Float - this.jdField_e_of_type_Float) * paramFloat;
      }
      if (this.g != this.h) {
        f2 = this.g + (this.h - this.g) * paramFloat;
      }
      paramTransformation.getMatrix().postTranslate(f1, f2);
      return;
      paramTransformation.getMatrix().setRotate(f1, this.m, this.n);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RollingTranslateAnimation
 * JD-Core Version:    0.7.0.1
 */