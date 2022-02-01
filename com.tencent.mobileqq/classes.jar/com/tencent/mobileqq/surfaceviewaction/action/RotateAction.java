package com.tencent.mobileqq.surfaceviewaction.action;

import java.io.PrintStream;

public class RotateAction
  extends Action
{
  private int f;
  private int g;
  
  public RotateAction(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 8, 0);
    this.f = paramInt2;
    this.g = paramInt3;
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
    int i = this.f;
    float f1 = i;
    int j = this.g;
    this.b = ((int)(f1 + (j - i) * paramFloat));
    if (j - i > 0)
    {
      i = this.b;
      j = this.g;
      if (i >= j) {
        this.b = j;
      }
    }
    else
    {
      i = this.b;
      j = this.g;
      if (i <= j) {
        this.b = j;
      }
    }
    super.a(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.action.RotateAction
 * JD-Core Version:    0.7.0.1
 */