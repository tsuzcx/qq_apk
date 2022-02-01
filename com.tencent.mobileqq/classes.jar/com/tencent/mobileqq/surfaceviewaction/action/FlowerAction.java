package com.tencent.mobileqq.surfaceviewaction.action;

public class FlowerAction
  extends Action
{
  private int m;
  private int n;
  private int o;
  private int p;
  private float q;
  
  public FlowerAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    super(paramInt1, 11, 0);
    this.m = paramInt2;
    this.n = paramInt3;
    this.o = paramInt4;
    this.p = paramInt5;
    this.q = paramFloat;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    float f = paramInt;
    this.c = (f * 0.8F / this.f);
    if (this.c > 0.8F) {
      this.c = 0.8F;
    }
    this.e = ((int)(360.0F * f * f / (this.f * this.f)));
    int i = this.m;
    this.a = (i + (this.o - i) * paramInt / this.f);
    double d1 = this.n;
    double d2 = this.p;
    double d3 = Math.sin(this.q * this.a);
    Double.isNaN(d2);
    Double.isNaN(d1);
    this.b = ((int)(d1 + d2 * d3));
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.FlowerAction
 * JD-Core Version:    0.7.0.1
 */