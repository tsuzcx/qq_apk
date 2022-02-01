package com.tencent.mobileqq.surfaceviewaction.action;

public class MoveYToAction
  extends Action
{
  private int f;
  private int g;
  
  public MoveYToAction(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 16, 0);
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    int i = this.f;
    float f1 = i;
    int j = this.g;
    this.b = ((int)(f1 + (j - i) * paramFloat));
    if (j - i > 0)
    {
      f1 = this.b;
      i = this.g;
      if (f1 >= i) {
        this.b = i;
      }
    }
    else
    {
      f1 = this.b;
      i = this.g;
      if (f1 <= i) {
        this.b = i;
      }
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.MoveYToAction
 * JD-Core Version:    0.7.0.1
 */