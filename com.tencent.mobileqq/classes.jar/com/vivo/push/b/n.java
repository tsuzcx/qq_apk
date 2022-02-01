package com.vivo.push.b;

import com.vivo.push.a;

public final class n
  extends s
{
  private String a;
  private int b = 0;
  private boolean c = false;
  
  public n()
  {
    super(7);
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void b(String paramString)
  {
    this.a = paramString;
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    parama.a("content", this.a);
    parama.a("log_level", this.b);
    parama.a("is_server_log", this.c);
  }
  
  public final String d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    this.a = parama.a("content");
    this.b = parama.b("log_level", 0);
    this.c = parama.e("is_server_log");
  }
  
  public final int e()
  {
    return this.b;
  }
  
  public final boolean f()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return "OnLogCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.n
 * JD-Core Version:    0.7.0.1
 */