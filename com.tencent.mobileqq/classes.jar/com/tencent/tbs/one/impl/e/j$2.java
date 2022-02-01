package com.tencent.tbs.one.impl.e;

import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.c;
import java.io.File;

final class j$2
  extends c<e<File>>
{
  j$2(j paramj, String paramString1, String paramString2, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    f.c("[%s] Failed to update component %s#%d, error: [%d] %s", new Object[] { this.a, this.b, Integer.valueOf(this.c), Integer.valueOf(paramInt), paramString, paramThrowable });
    this.d.a(paramInt, "Failed to update component " + this.b + ", error: " + paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.j.2
 * JD-Core Version:    0.7.0.1
 */