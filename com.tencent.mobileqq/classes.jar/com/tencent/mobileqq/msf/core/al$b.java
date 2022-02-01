package com.tencent.mobileqq.msf.core;

public class al$b
  implements Runnable
{
  long a = 0L;
  long b = 0L;
  
  public al$b(al paramal) {}
  
  public void run()
  {
    if (this.c.i.a)
    {
      long l = this.b;
      if ((l > 0L) && (this.a > 0L)) {
        this.c.a(l, System.currentTimeMillis() - this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.al.b
 * JD-Core Version:    0.7.0.1
 */