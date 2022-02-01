package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.b;
import com.tencent.tbs.one.impl.common.d.a;
import java.io.File;

public final class c
  extends b<e<File>>
{
  private d.a e;
  private a<e<File>> f;
  private File g;
  private Context h;
  
  public c(Context paramContext, d.a parama, a<e<File>> parama1, File paramFile)
  {
    super(com.tencent.tbs.one.impl.common.f.e(paramFile, ".lock"));
    this.e = parama;
    this.f = parama1;
    this.g = paramFile;
    this.h = paramContext;
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    File localFile = this.g;
    com.tencent.tbs.one.impl.a.c.c(localFile);
    f.f(localFile);
    super.a(paramInt, paramString, paramThrowable);
  }
  
  public final void a(e<File> parame)
  {
    File localFile = (File)parame.b;
    try
    {
      String str = this.e.a;
      Object localObject = com.tencent.tbs.one.impl.common.e.a(new File(localFile, "MANIFEST")).c;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File(localFile, (String)localObject);
        com.tencent.tbs.one.impl.a.f.a("do dexopt for component %s,entryClass=%s,installDir=%s", new Object[] { str, localObject, localFile });
        com.tencent.tbs.one.impl.c.a.c.a(this.h, (File)localObject, localFile.getAbsolutePath(), localFile.getAbsolutePath(), null, false, null, false);
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tbs.one.impl.a.f.c("exception occured in dex2oat,exception=%s", new Object[] { Log.getStackTraceString(localThrowable) });
    }
    f.f(this.g);
    super.a(parame);
  }
  
  protected final void a(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder("Failed to wait for component installation lock ");
    localStringBuilder.append(this.g);
    a(311, localStringBuilder.toString(), paramException);
  }
  
  public final void b()
  {
    super.b();
    this.f.b();
  }
  
  protected final void c()
  {
    File localFile = this.g;
    if (f.g(localFile))
    {
      if (localFile.exists())
      {
        a(e.a(e.a.a, localFile));
        return;
      }
      f.e(localFile);
    }
    else if (localFile.exists())
    {
      com.tencent.tbs.one.impl.a.c.c(localFile);
    }
    this.f.a(new c.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.c
 * JD-Core Version:    0.7.0.1
 */