package com.vivo.push.c;

import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.l;

final class c
  extends l
{
  c(com.vivo.push.o paramo)
  {
    super(paramo);
  }
  
  protected final void a(com.vivo.push.o paramo)
  {
    com.vivo.push.util.o.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.c
 * JD-Core Version:    0.7.0.1
 */