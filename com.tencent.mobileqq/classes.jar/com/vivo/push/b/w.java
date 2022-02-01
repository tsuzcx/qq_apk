package com.vivo.push.b;

import com.vivo.push.a;
import com.vivo.push.o;

public final class w
  extends o
{
  private int a = 0;
  
  public w()
  {
    super(2011);
  }
  
  protected final void c(a parama)
  {
    parama.a("com.bbk.push.ikey.MODE_TYPE", this.a);
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public final int d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    this.a = parama.b("com.bbk.push.ikey.MODE_TYPE", 0);
  }
  
  public final String toString()
  {
    return "PushModeCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.w
 * JD-Core Version:    0.7.0.1
 */