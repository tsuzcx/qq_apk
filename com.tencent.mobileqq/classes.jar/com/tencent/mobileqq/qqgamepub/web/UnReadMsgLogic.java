package com.tencent.mobileqq.qqgamepub.web;

public class UnReadMsgLogic
{
  private int a;
  private int b;
  private int c;
  
  public UnReadMsgLogic(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a()
  {
    this.b = 1;
    this.a -= 1;
    this.c = this.a;
  }
  
  public void a(int paramInt)
  {
    this.b += paramInt;
  }
  
  public void b()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0;
  }
  
  public void b(int paramInt)
  {
    this.c += paramInt;
  }
  
  public void c()
  {
    this.a = (this.c - this.b + 1);
  }
  
  public boolean c(int paramInt)
  {
    int i = this.b;
    if (paramInt >= i)
    {
      int j = this.c;
      if ((i <= j) && (paramInt <= j)) {
        return true;
      }
    }
    return false;
  }
  
  public int d()
  {
    return this.a;
  }
  
  public boolean e()
  {
    int i = this.a;
    return (i > 0) && (i <= 3);
  }
  
  public boolean f()
  {
    return this.a > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.UnReadMsgLogic
 * JD-Core Version:    0.7.0.1
 */