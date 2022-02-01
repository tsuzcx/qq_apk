package com.vivo.push.c;

import com.vivo.push.b.l;
import com.vivo.push.o;
import com.vivo.push.util.w;

public final class k
  extends y
{
  k(o paramo)
  {
    super(paramo);
  }
  
  protected final void a(o paramo)
  {
    paramo = (l)paramo;
    int i = paramo.d();
    int j = paramo.e();
    w.b().a("key_dispatch_environment", i);
    w.b().a("key_dispatch_area", j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.k
 * JD-Core Version:    0.7.0.1
 */