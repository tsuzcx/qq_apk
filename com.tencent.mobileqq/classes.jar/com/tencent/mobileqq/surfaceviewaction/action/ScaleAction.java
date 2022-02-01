package com.tencent.mobileqq.surfaceviewaction.action;

public class ScaleAction
  extends Action
{
  private float d;
  private float e;
  
  public ScaleAction(int paramInt, float paramFloat1, float paramFloat2)
  {
    super(paramInt, 2, 0);
    this.d = paramFloat1;
    this.e = paramFloat2;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    float f1 = this.d;
    float f2 = this.e;
    this.jdField_c_of_type_Float = ((f2 - f1) * paramFloat + f1);
    if (f2 - f1 > 0.0F)
    {
      f1 = this.jdField_c_of_type_Float;
      f2 = this.e;
      if (f1 >= f2) {
        this.jdField_c_of_type_Float = f2;
      }
    }
    else
    {
      f1 = this.jdField_c_of_type_Float;
      f2 = this.e;
      if (f1 <= f2) {
        this.jdField_c_of_type_Float = f2;
      }
    }
    if (paramInt >= this.jdField_c_of_type_Int) {
      this.jdField_c_of_type_Float = this.e;
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.ScaleAction
 * JD-Core Version:    0.7.0.1
 */