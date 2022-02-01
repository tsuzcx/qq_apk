package com.tencent.mobileqq.surfaceviewaction.action;

public class MoveToAction
  extends Action
{
  private float d;
  private float e;
  private float f;
  private float g;
  
  public MoveToAction(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramInt, 1, 0);
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramFloat3;
    this.g = paramFloat4;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    float f1 = this.d;
    float f2 = this.f;
    this.a = ((f2 - f1) * paramFloat + f1);
    float f3 = this.e;
    this.b = (f3 + (this.g - f3) * paramFloat);
    if (f2 - f1 > 0.0F)
    {
      f1 = this.a;
      f2 = this.f;
      if (f1 >= f2) {
        this.a = f2;
      }
    }
    else
    {
      f1 = this.a;
      f2 = this.f;
      if (f1 <= f2) {
        this.a = f2;
      }
    }
    if (this.g - this.e > 0.0F)
    {
      f1 = this.b;
      f2 = this.g;
      if (f1 >= f2) {
        this.b = f2;
      }
    }
    else
    {
      f1 = this.b;
      f2 = this.g;
      if (f1 <= f2) {
        this.b = f2;
      }
    }
    if (paramInt >= this.c)
    {
      this.a = this.f;
      this.b = this.g;
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.MoveToAction
 * JD-Core Version:    0.7.0.1
 */