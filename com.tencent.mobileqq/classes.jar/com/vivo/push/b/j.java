package com.vivo.push.b;

import com.vivo.push.a;

public final class j
  extends s
{
  private int a = -1;
  private int b = -1;
  
  public j()
  {
    super(12);
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    parama.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
    parama.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
  }
  
  public final int d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    this.a = parama.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
    this.b = parama.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
  }
  
  public final int e()
  {
    return this.b;
  }
  
  public final String toString()
  {
    return "OnChangePushStatusCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.j
 * JD-Core Version:    0.7.0.1
 */