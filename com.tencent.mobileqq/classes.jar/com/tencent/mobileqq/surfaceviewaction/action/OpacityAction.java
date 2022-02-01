package com.tencent.mobileqq.surfaceviewaction.action;

public class OpacityAction
  extends Action
{
  private int f;
  private int g;
  
  public OpacityAction(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 4, 0);
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public OpacityAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, 4, paramInt4);
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    int i = this.f;
    float f1 = i;
    int j = this.g;
    this.a = ((int)(f1 + (j - i) * paramFloat));
    if (j - i > 0)
    {
      i = this.a;
      j = this.g;
      if (i >= j) {
        this.a = j;
      }
    }
    else
    {
      i = this.a;
      j = this.g;
      if (i <= j) {
        this.a = j;
      }
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.OpacityAction
 * JD-Core Version:    0.7.0.1
 */