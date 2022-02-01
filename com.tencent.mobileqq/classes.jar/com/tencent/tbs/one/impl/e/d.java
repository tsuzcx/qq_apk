package com.tencent.tbs.one.impl.e;

import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.b;
import com.tencent.tbs.one.impl.a.c;
import java.io.File;

public final class d
  extends b<e<com.tencent.tbs.one.impl.common.d>>
{
  private boolean e;
  private a<e<com.tencent.tbs.one.impl.common.d>> f;
  private File g;
  
  public d(boolean paramBoolean, a<e<com.tencent.tbs.one.impl.common.d>> parama, File paramFile)
  {
    super(com.tencent.tbs.one.impl.common.f.e(paramFile, ".lock"));
    this.e = paramBoolean;
    this.f = parama;
    this.g = paramFile;
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    File localFile = this.g;
    c.c(localFile);
    f.f(localFile);
    super.a(paramInt, paramString, paramThrowable);
  }
  
  public final void a(e<com.tencent.tbs.one.impl.common.d> parame)
  {
    f.f(this.g);
    super.a(parame);
  }
  
  public final void a(Exception paramException)
  {
    a(301, "Failed to wait for DEPS installation lock " + this.g, paramException);
  }
  
  public final void b()
  {
    super.b();
    this.f.b();
  }
  
  public final void c()
  {
    File localFile = this.g;
    if (f.g(localFile))
    {
      if (localFile.exists())
      {
        if (!this.e) {
          try
          {
            com.tencent.tbs.one.impl.common.d locald = com.tencent.tbs.one.impl.common.d.a(localFile);
            a(e.a(e.a.a, locald));
            return;
          }
          catch (TBSOneException localTBSOneException) {}
        }
        c.c(localFile);
      }
      f.e(localFile);
    }
    for (;;)
    {
      this.f.a(new d.1(this));
      return;
      if (localFile.exists()) {
        c.c(localFile);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.d
 * JD-Core Version:    0.7.0.1
 */