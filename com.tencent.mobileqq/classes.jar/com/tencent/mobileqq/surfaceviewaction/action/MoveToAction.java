package com.tencent.mobileqq.surfaceviewaction.action;

public class MoveToAction
  extends Action
{
  private float m;
  private float n;
  private float o;
  private float p;
  
  public MoveToAction(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramInt, 1, 0);
    this.m = paramFloat1;
    this.n = paramFloat2;
    this.o = paramFloat3;
    this.p = paramFloat4;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    float f1 = this.m;
    float f2 = this.o;
    this.a = ((f2 - f1) * paramFloat + f1);
    float f3 = this.n;
    this.b = (f3 + (this.p - f3) * paramFloat);
    if (f2 - f1 > 0.0F)
    {
      f1 = this.a;
      f2 = this.o;
      if (f1 >= f2) {
        this.a = f2;
      }
    }
    else
    {
      f1 = this.a;
      f2 = this.o;
      if (f1 <= f2) {
        this.a = f2;
      }
    }
    if (this.p - this.n > 0.0F)
    {
      f1 = this.b;
      f2 = this.p;
      if (f1 >= f2) {
        this.b = f2;
      }
    }
    else
    {
      f1 = this.b;
      f2 = this.p;
      if (f1 <= f2) {
        this.b = f2;
      }
    }
    if (paramInt >= this.f)
    {
      this.a = this.o;
      this.b = this.p;
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.MoveToAction
 * JD-Core Version:    0.7.0.1
 */