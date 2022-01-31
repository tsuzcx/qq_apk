package com.tencent.mobileqq.msf.core.c;

public class k$d
{
  private int a = 0;
  private int b = 0;
  
  public void a()
  {
    this.a = 0;
    this.b = 0;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.a == 0) {
      if (paramInt1 >= 20) {
        this.a = paramInt1;
      }
    }
    for (;;)
    {
      return false;
      if (paramInt1 >= this.a)
      {
        this.a = paramInt1;
        this.b += 1;
        if (this.b >= 20) {
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
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.k.d
 * JD-Core Version:    0.7.0.1
 */