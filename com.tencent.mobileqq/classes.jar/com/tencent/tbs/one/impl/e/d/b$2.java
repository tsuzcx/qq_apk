package com.tencent.tbs.one.impl.e.d;

import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;

final class b$2
  extends TBSOneCallback<Void>
{
  b$2(b paramb, String paramString, File paramFile) {}
  
  public final void onError(int paramInt, String paramString)
  {
    b localb = this.c;
    localb.c = 0;
    localb.a(paramInt, paramString, null);
  }
  
  public final void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.c.a(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.d.b.2
 * JD-Core Version:    0.7.0.1
 */