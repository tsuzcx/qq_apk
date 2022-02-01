package com.vivo.push.c;

import com.vivo.push.a.a;
import com.vivo.push.b.c;
import com.vivo.push.l;
import com.vivo.push.model.b;
import com.vivo.push.o;
import com.vivo.push.util.r;
import com.vivo.push.util.s;

final class ah
  extends l
{
  ah(o paramo)
  {
    super(paramo);
  }
  
  protected final void a(o paramo)
  {
    c localc = (c)paramo;
    b localb = s.a(this.a);
    if (localb == null)
    {
      com.vivo.push.e.a().a(localc.h(), 1005, new Object[0]);
      return;
    }
    String str = localb.a();
    if (localb.c())
    {
      com.vivo.push.e.a().a(localc.h(), 1004, new Object[0]);
      paramo = new com.vivo.push.b.e();
    }
    else
    {
      int i = r.a(localc);
      if (i != 0)
      {
        com.vivo.push.e.a().a(localc.h(), i, new Object[0]);
        return;
      }
    }
    a.a(this.a, str, paramo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.ah
 * JD-Core Version:    0.7.0.1
 */