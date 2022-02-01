package com.tencent.mobileqq.msf.core;

public class aq$b
  implements Runnable
{
  long a = 0L;
  long b = 0L;
  
  public aq$b(aq paramaq) {}
  
  public void run()
  {
    if ((this.c.i.a) && (this.b > 0L) && (this.a > 0L)) {
      this.c.a(this.b, System.currentTimeMillis() - this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aq.b
 * JD-Core Version:    0.7.0.1
 */