package com.vivo.push.b;

import com.vivo.push.a;
import com.vivo.push.o;

public final class h
  extends o
{
  private String a;
  
  public h()
  {
    super(2013);
  }
  
  public h(String paramString)
  {
    this();
    this.a = paramString;
  }
  
  protected final void c(a parama)
  {
    parama.a("MsgArriveCommand.MSG_TAG", this.a);
  }
  
  protected final void d(a parama)
  {
    this.a = parama.a("MsgArriveCommand.MSG_TAG");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.h
 * JD-Core Version:    0.7.0.1
 */