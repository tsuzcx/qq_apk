package com.tencent.tbs.one.impl.e;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.common.c;

final class g$4
  extends c<Void>
{
  g$4(g paramg, TBSOneCallback paramTBSOneCallback) {}
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.a.onProgressChanged(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.a.onError(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.g.4
 * JD-Core Version:    0.7.0.1
 */