package com.tencent.util;

public class Thrower<T>
{
  private long a = 0L;
  private long b;
  private Thrower.Action<T> c;
  
  private Thrower(Thrower.Action<T> paramAction)
  {
    this.c = paramAction;
  }
  
  public static <T> Thrower<T> a(Thrower.Action<T> paramAction)
  {
    return new Thrower(paramAction);
  }
  
  public Thrower<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public Thrower<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.a > this.b)
    {
      this.a = l;
      Thrower.Action localAction = this.c;
      if (localAction != null) {
        localAction.a(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.Thrower
 * JD-Core Version:    0.7.0.1
 */