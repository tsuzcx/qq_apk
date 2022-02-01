package com.vivo.push.b;

import com.vivo.push.a;

public final class i
  extends s
{
  private String a;
  private String b;
  private String c;
  
  public i(int paramInt)
  {
    super(paramInt);
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    parama.a("app_id", this.a);
    parama.a("client_id", this.b);
    parama.a("client_token", this.c);
  }
  
  public final String d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    this.a = parama.a("app_id");
    this.b = parama.a("client_id");
    this.c = parama.a("client_token");
  }
  
  public final String e()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return "OnBindCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.i
 * JD-Core Version:    0.7.0.1
 */