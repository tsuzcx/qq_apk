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
    this.jdField_c_of_type_Float = (this.d + (this.e - this.d) * paramFloat);
    if (this.e - this.d > 0.0F) {
      if (this.jdField_c_of_type_Float >= this.e) {
        this.jdField_c_of_type_Float = this.e;
      }
    }
    for (;;)
    {
      if (paramInt >= this.jdField_c_of_type_Int) {
        this.jdField_c_of_type_Float = this.e;
      }
      super.a(paramInt, paramFloat);
      return;
      if (this.jdField_c_of_type_Float <= this.e) {
        this.jdField_c_of_type_Float = this.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.ScaleAction
 * JD-Core Version:    0.7.0.1
 */