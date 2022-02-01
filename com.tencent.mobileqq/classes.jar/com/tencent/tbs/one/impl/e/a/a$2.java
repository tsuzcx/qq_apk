package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import com.tencent.tbs.one.impl.a.d;
import com.tencent.tbs.one.impl.common.h;

final class a$2
  implements Runnable
{
  a$2(a parama, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public final void run()
  {
    if ((!this.e.c()) && (!d.e(this.a)))
    {
      a.a(this.e, "current network is unavialable,no need sendrequest to server");
      return;
    }
    if (this.e.d()) {
      h.a(1013, this.e.e);
    } else {
      h.a(1003, this.e.e);
    }
    int i = com.tencent.tbs.one.impl.e.f.c(com.tencent.tbs.one.impl.common.f.b(com.tencent.tbs.one.impl.common.f.a(this.a.getDir("tbs", 0), this.b), this.c));
    a locala = this.e;
    a.a(locala, this.a, this.b, this.c, this.d, locala.d, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.a.2
 * JD-Core Version:    0.7.0.1
 */