package com.tencent.mobileqq.surfaceviewaction.action;

import java.io.PrintStream;

public class RotateAction
  extends Action
{
  private int m;
  private int n;
  
  public RotateAction(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 8, 0);
    this.m = paramInt2;
    this.n = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", percent = ");
    localStringBuilder.append(paramFloat);
    localPrintStream.println(localStringBuilder.toString());
    int i = this.m;
    float f = i;
    int j = this.n;
    this.e = ((int)(f + (j - i) * paramFloat));
    if (j - i > 0)
    {
      i = this.e;
      j = this.n;
      if (i >= j) {
        this.e = j;
      }
    }
    else
    {
      i = this.e;
      j = this.n;
      if (i <= j) {
        this.e = j;
      }
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.RotateAction
 * JD-Core Version:    0.7.0.1
 */