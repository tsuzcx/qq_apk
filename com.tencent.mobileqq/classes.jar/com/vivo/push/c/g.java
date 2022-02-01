package com.vivo.push.c;

import android.content.Context;

final class g
  extends y
{
  g(com.vivo.push.o paramo)
  {
    super(paramo);
  }
  
  protected final void a(com.vivo.push.o paramo)
  {
    paramo = new StringBuilder("delete push info ");
    paramo.append(this.a.getPackageName());
    com.vivo.push.util.o.d("OnClearCacheTask", paramo.toString());
    com.vivo.push.util.y.b(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.g
 * JD-Core Version:    0.7.0.1
 */