package com.tencent.mobileqq.surfaceviewaction.action;

public class FlowerAction
  extends Action
{
  private float d;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public FlowerAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    super(paramInt1, 11, 0);
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    this.i = paramInt5;
    this.d = paramFloat;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    float f1 = paramInt;
    this.jdField_c_of_type_Float = (f1 * 0.8F / this.jdField_c_of_type_Int);
    if (this.jdField_c_of_type_Float > 0.8F) {
      this.jdField_c_of_type_Float = 0.8F;
    }
    this.jdField_b_of_type_Int = ((int)(360.0F * f1 * f1 / (this.jdField_c_of_type_Int * this.jdField_c_of_type_Int)));
    int j = this.f;
    this.a = (j + (this.h - j) * paramInt / this.jdField_c_of_type_Int);
    double d1 = this.g;
    double d2 = this.i;
    double d3 = Math.sin(this.d * this.a);
    Double.isNaN(d2);
    Double.isNaN(d1);
    this.jdField_b_of_type_Float = ((int)(d1 + d2 * d3));
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.FlowerAction
 * JD-Core Version:    0.7.0.1
 */