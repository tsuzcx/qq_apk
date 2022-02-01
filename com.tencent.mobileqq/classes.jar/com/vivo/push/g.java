package com.vivo.push;

import com.vivo.push.util.b;
import com.vivo.push.util.o;

final class g
  implements IPushActionListener
{
  g(e parame, e.a parama) {}
  
  public final void onStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      Object[] arrayOfObject = this.a.b();
      if ((arrayOfObject != null) && (arrayOfObject.length != 0))
      {
        this.b.a((String)this.a.b()[0]);
        return;
      }
      o.a("PushClientManager", "bind app result is null");
      return;
    }
    e.a(this.b, null);
    e.b(this.b).b("APP_TOKEN");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.g
 * JD-Core Version:    0.7.0.1
 */