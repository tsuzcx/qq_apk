package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.a;
import com.vivo.push.model.UnvarnishedMessage;

public final class o
  extends v
{
  protected UnvarnishedMessage a;
  
  public o()
  {
    super(3);
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    parama.a("msg_v1", this.a.unpackToJson());
  }
  
  public final String d()
  {
    UnvarnishedMessage localUnvarnishedMessage = this.a;
    if (localUnvarnishedMessage == null) {
      return null;
    }
    return localUnvarnishedMessage.unpackToJson();
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    parama = parama.a("msg_v1");
    if (!TextUtils.isEmpty(parama))
    {
      this.a = new UnvarnishedMessage(parama);
      this.a.setMsgId(f());
    }
  }
  
  public final UnvarnishedMessage e()
  {
    return this.a;
  }
  
  public final String toString()
  {
    return "OnMessageCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.o
 * JD-Core Version:    0.7.0.1
 */