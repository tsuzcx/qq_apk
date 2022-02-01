package com.vivo.push.c;

import com.vivo.push.a.a;
import com.vivo.push.b.d;
import com.vivo.push.b.y;
import com.vivo.push.l;
import com.vivo.push.o;
import com.vivo.push.util.s;

final class b
  extends l
{
  b(o paramo)
  {
    super(paramo);
  }
  
  protected final void a(o paramo)
  {
    Object localObject = (d)paramo;
    paramo = s.a(this.a);
    if (((d)localObject).d()) {}
    try
    {
      boolean bool = f.a(this.a);
      break label39;
      bool = f.b(this.a);
      label39:
      if (bool)
      {
        localObject = s.a(this.a);
        if ((paramo != null) && (localObject != null) && (((com.vivo.push.model.b)localObject).a() != null) && (((com.vivo.push.model.b)localObject).a().equals(paramo.a()))) {
          return;
        }
        if ((paramo != null) && (paramo.a() != null))
        {
          y localy = new y(paramo.a());
          a.a(this.a, paramo.a(), localy);
        }
        if ((localObject != null) && (((com.vivo.push.model.b)localObject).a() != null))
        {
          paramo = new com.vivo.push.b.f();
          a.a(this.a, ((com.vivo.push.model.b)localObject).a(), paramo);
        }
      }
      return;
    }
    catch (Exception paramo)
    {
      paramo.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.b
 * JD-Core Version:    0.7.0.1
 */