package com.vivo.push.b;

import com.vivo.push.a;

public final class l
  extends s
{
  private int a = -1;
  private int b = -1;
  
  public l()
  {
    super(2016);
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    parama.a("key_dispatch_environment", this.a);
    parama.a("key_dispatch_area", this.b);
  }
  
  public final int d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    this.a = parama.b("key_dispatch_environment", 1);
    this.b = parama.b("key_dispatch_area", 1);
  }
  
  public final int e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.l
 * JD-Core Version:    0.7.0.1
 */