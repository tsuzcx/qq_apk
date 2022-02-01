package com.vivo.push.b;

import com.vivo.push.a;

public final class u
  extends v
{
  private long a = -1L;
  private int b;
  
  public u()
  {
    super(20);
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    parama.a("undo_msg_v1", this.a);
    parama.a("undo_msg_type_v1", this.b);
  }
  
  public final long d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    this.a = parama.b("undo_msg_v1", this.a);
    this.b = parama.b("undo_msg_type_v1", 0);
  }
  
  public final String e()
  {
    long l = this.a;
    if (l != -1L) {
      return String.valueOf(l);
    }
    return null;
  }
  
  public final String toString()
  {
    return "OnUndoMsgCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.u
 * JD-Core Version:    0.7.0.1
 */