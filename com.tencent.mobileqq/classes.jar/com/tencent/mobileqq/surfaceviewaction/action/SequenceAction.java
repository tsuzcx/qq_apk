package com.tencent.mobileqq.surfaceviewaction.action;

public class SequenceAction
  extends Action
{
  private Action m;
  private int n = 0;
  private Action[] o;
  private int[] p;
  
  public SequenceAction(Action... paramVarArgs)
  {
    super(0, 0, 0);
    this.o = paramVarArgs;
    this.p = new int[paramVarArgs.length];
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      if (i == 0) {
        this.p[i] = 0;
      } else {
        this.p[i] = j;
      }
      j += paramVarArgs[i].f;
      i += 1;
    }
    this.f = j;
    if (paramVarArgs.length > 0) {
      this.m = paramVarArgs[this.n];
    }
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    int i = this.n;
    if ((i + 1 < this.o.length) && (paramInt > this.p[(i + 1)]))
    {
      this.m.c();
      Action[] arrayOfAction = this.o;
      i = this.n + 1;
      this.n = i;
      this.m = arrayOfAction[i];
    }
    this.g = this.m.g;
    i = paramInt - this.p[this.n];
    float f2 = i;
    float f1 = f2 / this.m.f;
    if (this.m.h == 1)
    {
      f1 = i * i / (this.m.f * this.m.f);
    }
    else if (this.m.h == 2)
    {
      f1 = f2 / this.m.f;
      f1 = (2.0F - f1) * f1;
    }
    this.m.a(i, f1);
    if ((this.m.g & 0x1) != 0)
    {
      this.a = this.m.a;
      this.b = this.m.b;
    }
    if ((this.m.g & 0x10) != 0) {
      this.b = this.m.b;
    }
    if ((this.m.g & 0x2) != 0) {
      this.c = this.m.c;
    }
    if ((this.m.g & 0x4) != 0) {
      this.d = this.m.d;
    }
    if ((this.m.g & 0x8) != 0) {
      this.e = this.m.e;
    }
    super.a(paramInt, paramFloat);
  }
  
  public void b()
  {
    super.b();
    this.n = 0;
    Action[] arrayOfAction = this.o;
    if (arrayOfAction.length > 0) {
      this.m = arrayOfAction[this.n];
    }
  }
  
  public void e()
  {
    super.e();
    int i = 0;
    while (i < this.o.length)
    {
      this.p[i] = ((int)(System.currentTimeMillis() - this.l));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.SequenceAction
 * JD-Core Version:    0.7.0.1
 */