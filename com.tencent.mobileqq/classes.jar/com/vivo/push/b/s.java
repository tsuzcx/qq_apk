package com.vivo.push.b;

import com.vivo.push.a;
import com.vivo.push.o;

public class s
  extends o
{
  private String a = null;
  private int b = 0;
  
  public s(int paramInt)
  {
    super(paramInt);
  }
  
  protected void c(a parama)
  {
    parama.a("req_id", this.a);
    parama.a("status_msg_code", this.b);
  }
  
  protected void d(a parama)
  {
    this.a = parama.a("req_id");
    this.b = parama.b("status_msg_code", this.b);
  }
  
  public final String g()
  {
    return this.a;
  }
  
  public final int h()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "OnReceiveCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.s
 * JD-Core Version:    0.7.0.1
 */