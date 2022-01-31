package com.tencent.mobileqq.msf.core;

public class p$a
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  
  public p$a(int paramInt)
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
    if (this.a == 0) {
      if (paramInt >= this.c) {
        this.a = paramInt;
      }
    }
    for (;;)
    {
      return false;
      if (paramInt >= this.a)
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
    }
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.p.a
 * JD-Core Version:    0.7.0.1
 */