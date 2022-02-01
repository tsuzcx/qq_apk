package com.vivo.push.b;

import com.vivo.push.a;
import com.vivo.push.o;

public final class y
  extends o
{
  private String a;
  
  public y()
  {
    super(2008);
  }
  
  public y(String paramString)
  {
    super(2008);
    this.a = paramString;
  }
  
  protected final void c(a parama)
  {
    parama.a("package_name", this.a);
  }
  
  protected final void d(a parama)
  {
    this.a = parama.a("package_name");
  }
  
  public final String toString()
  {
    return "StopServiceCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.y
 * JD-Core Version:    0.7.0.1
 */