package com.tencent.tbs.one.impl.e;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.a.j;
import com.tencent.tbs.one.impl.common.c;
import com.tencent.tbs.one.impl.common.d;

final class g$3
  extends c<Void>
{
  g$3(g paramg, TBSOneCallback paramTBSOneCallback, i parami, j paramj) {}
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.a.onProgressChanged(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    d locald = this.b.l;
    int i;
    if (locald != null) {
      i = locald.a;
    } else {
      i = -1;
    }
    com.tencent.tbs.one.impl.common.h.a(i, "", -1, paramInt, paramString, paramThrowable);
    g.a(this.d, this.c);
    this.a.onError(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.g.3
 * JD-Core Version:    0.7.0.1
 */