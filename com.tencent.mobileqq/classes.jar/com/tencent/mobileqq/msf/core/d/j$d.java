package com.tencent.mobileqq.msf.core.d;

public class j$d
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
    paramInt2 = this.a;
    if (paramInt2 == 0)
    {
      if (paramInt1 >= 20) {
        this.a = paramInt1;
      }
    }
    else if (paramInt1 >= paramInt2)
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
    return false;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.j.d
 * JD-Core Version:    0.7.0.1
 */