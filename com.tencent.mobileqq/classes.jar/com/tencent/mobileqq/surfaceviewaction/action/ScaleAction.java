package com.tencent.mobileqq.surfaceviewaction.action;

public class ScaleAction
  extends Action
{
  private float m;
  private float n;
  
  public ScaleAction(int paramInt, float paramFloat1, float paramFloat2)
  {
    super(paramInt, 2, 0);
    this.m = paramFloat1;
    this.n = paramFloat2;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    float f1 = this.m;
    float f2 = this.n;
    this.c = ((f2 - f1) * paramFloat + f1);
    if (f2 - f1 > 0.0F)
    {
      f1 = this.c;
      f2 = this.n;
      if (f1 >= f2) {
        this.c = f2;
      }
    }
    else
    {
      f1 = this.c;
      f2 = this.n;
      if (f1 <= f2) {
        this.c = f2;
      }
    }
    if (paramInt >= this.f) {
      this.c = this.n;
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.ScaleAction
 * JD-Core Version:    0.7.0.1
 */