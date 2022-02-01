package com.tencent.mobileqq.surfaceviewaction.action;

public abstract class Action
{
  public float a = 0.0F;
  public float b = 0.0F;
  public float c = 1.0F;
  public int d = 255;
  public int e = 0;
  public int f;
  public int g;
  public int h = 0;
  public boolean i = false;
  public boolean j = false;
  protected long k;
  protected long l;
  private Action.OnActionEndListener m;
  
  public Action(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    if (paramInt >= this.f)
    {
      Action.OnActionEndListener localOnActionEndListener = this.m;
      if (localOnActionEndListener != null) {
        localOnActionEndListener.a();
      }
    }
  }
  
  public void a(Action.OnActionEndListener paramOnActionEndListener)
  {
    this.m = paramOnActionEndListener;
  }
  
  public boolean a()
  {
    if (this.j) {
      return false;
    }
    int n = (int)(System.currentTimeMillis() - this.k);
    float f2 = n;
    int i1 = this.f;
    float f1 = f2 / i1;
    int i2 = this.h;
    if (i2 == 1)
    {
      f1 = n * n / (i1 * i1);
    }
    else if (i2 == 2)
    {
      f1 = f2 / i1;
      f1 *= (2.0F - f1);
    }
    a(n, f1);
    if (n >= this.f) {
      c();
    }
    return true;
  }
  
  public void b()
  {
    this.j = false;
    this.k = System.currentTimeMillis();
  }
  
  public void c()
  {
    this.j = true;
  }
  
  public void d()
  {
    this.l = System.currentTimeMillis();
  }
  
  public void e()
  {
    this.k += System.currentTimeMillis() - this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.Action
 * JD-Core Version:    0.7.0.1
 */