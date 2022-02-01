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
    this.a = ((int)(this.f + (this.g - this.f) * paramFloat));
    if (this.g - this.f > 0) {
      if (this.a >= this.g) {
        this.a = this.g;
      }
    }
    for (;;)
    {
      super.a(paramInt, paramFloat);
      return;
      if (this.a <= this.g) {
        this.a = this.g;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.OpacityAction
 * JD-Core Version:    0.7.0.1
 */