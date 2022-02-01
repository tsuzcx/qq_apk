package com.tencent.mobileqq.surfaceviewaction.action;

public class MoveYToAction
  extends Action
{
  private int m;
  private int n;
  
  public MoveYToAction(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 16, 0);
    this.m = paramInt2;
    this.n = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    int i = this.m;
    float f = i;
    int j = this.n;
    this.b = ((int)(f + (j - i) * paramFloat));
    if (j - i > 0)
    {
      f = this.b;
      i = this.n;
      if (f >= i) {
        this.b = i;
      }
    }
    else
    {
      f = this.b;
      i = this.n;
      if (f <= i) {
        this.b = i;
      }
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.MoveYToAction
 * JD-Core Version:    0.7.0.1
 */