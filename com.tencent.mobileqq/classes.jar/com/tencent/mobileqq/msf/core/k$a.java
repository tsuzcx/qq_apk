package com.tencent.mobileqq.msf.core;

public class k$a
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  
  public k$a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a()
  {
    this.a = 0;
    this.b = 0;
  }
  
  public boolean a(int paramInt)
  {
    int i = this.a;
    if (i == 0)
    {
      if (paramInt >= this.c) {
        this.a = paramInt;
      }
    }
    else if (paramInt >= i)
    {
      this.a = paramInt;
      this.b += 1;
      if (this.b >= 40) {
        return true;
      }
    }
    else
    {
      a();
    }
    return false;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.k.a
 * JD-Core Version:    0.7.0.1
 */