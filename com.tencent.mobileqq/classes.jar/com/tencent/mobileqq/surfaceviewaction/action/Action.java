package com.tencent.mobileqq.surfaceviewaction.action;

public abstract class Action
{
  public float a;
  public int a;
  protected long a;
  private Action.OnActionEndListener a;
  public boolean a;
  public float b;
  public int b;
  protected long b;
  public boolean b;
  public float c;
  public int c;
  public int d;
  public int e = 0;
  
  public Action(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 255;
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    if ((paramInt >= this.jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction$OnActionEndListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction$OnActionEndListener.a();
    }
  }
  
  public void a(Action.OnActionEndListener paramOnActionEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionActionAction$OnActionEndListener = paramOnActionEndListener;
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    int i = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    float f = i / this.jdField_c_of_type_Int;
    if (this.e == 1) {
      f = i * i / (this.jdField_c_of_type_Int * this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      a(i, f);
      if (i >= this.jdField_c_of_type_Int) {
        b();
      }
      return true;
      if (this.e == 2)
      {
        f = i / this.jdField_c_of_type_Int;
        f *= (2.0F - f);
      }
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.Action
 * JD-Core Version:    0.7.0.1
 */