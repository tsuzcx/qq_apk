package com.tencent.mobileqq.surfaceviewaction.action;

public class OpacityAction
  extends Action
{
  private int m;
  private int n;
  
  public OpacityAction(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 4, 0);
    this.m = paramInt2;
    this.n = paramInt3;
  }
  
  public OpacityAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, 4, paramInt4);
    this.m = paramInt2;
    this.n = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    int i = this.m;
    float f = i;
    int j = this.n;
    this.d = ((int)(f + (j - i) * paramFloat));
    if (j - i > 0)
    {
      i = this.d;
      j = this.n;
      if (i >= j) {
        this.d = j;
      }
    }
    else
    {
      i = this.d;
      j = this.n;
      if (i <= j) {
        this.d = j;
      }
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.OpacityAction
 * JD-Core Version:    0.7.0.1
 */