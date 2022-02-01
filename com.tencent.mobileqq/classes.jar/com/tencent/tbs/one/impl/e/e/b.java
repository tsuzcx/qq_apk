package com.tencent.tbs.one.impl.e.e;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import java.io.File;

public class b
  extends a<e<File>>
{
  d.a b;
  String c;
  private Context d;
  private String e;
  private File f;
  private Bundle g;
  private String[] h;
  
  public b(Context paramContext, String paramString, d.a parama, File paramFile, Bundle paramBundle)
  {
    this.d = paramContext;
    this.e = paramString;
    this.b = parama;
    this.f = paramFile;
    this.g = paramBundle;
    this.h = com.tencent.tbs.one.impl.common.b.a;
    this.c = parama.a;
  }
  
  private boolean a(String paramString)
  {
    String str1 = this.e;
    String str2 = this.c;
    int i = this.b.c;
    File localFile1 = this.f;
    try
    {
      File localFile2 = a(this.d.createPackageContext(paramString, 2));
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} copyFromSharableApplication,path=%s", new Object[] { str1, str2, localFile2.getAbsolutePath() });
      if ((localFile2 != null) && (localFile2.exists()) && (com.tencent.tbs.one.impl.e.f.g(localFile2)))
      {
        c.b(localFile2, localFile1);
        com.tencent.tbs.one.impl.e.f.a(localFile1, i);
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished copy component from %s", new Object[] { str1, str2, paramString });
        d();
        return true;
      }
    }
    catch (Exception localException)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Failed copy component from %s,exception is", new Object[] { str1, str2, paramString, localException.toString() });
      c.a(localFile1);
    }
    return false;
  }
  
  File a(Context paramContext)
  {
    return com.tencent.tbs.one.impl.common.f.a(com.tencent.tbs.one.impl.common.f.a(paramContext.getDir("tbs", 0), this.e), this.c, this.b.c);
  }
  
  public final void a()
  {
    m.b(new b.1(this));
  }
  
  protected e.a c()
  {
    return e.a.h;
  }
  
  public void d()
  {
    h.a(2003, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.e.b
 * JD-Core Version:    0.7.0.1
 */