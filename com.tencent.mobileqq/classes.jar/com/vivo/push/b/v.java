package com.vivo.push.b;

import com.vivo.push.a;

public abstract class v
  extends s
{
  private String a;
  private long b;
  
  public v(int paramInt)
  {
    super(paramInt);
  }
  
  protected void c(a parama)
  {
    super.c(parama);
    parama.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.a);
    parama.a("notify_id", this.b);
  }
  
  protected void d(a parama)
  {
    super.d(parama);
    this.a = parama.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
    this.b = parama.b("notify_id", -1L);
  }
  
  public final long f()
  {
    return this.b;
  }
  
  public final String i()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.v
 * JD-Core Version:    0.7.0.1
 */