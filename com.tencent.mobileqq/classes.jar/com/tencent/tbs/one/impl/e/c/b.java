package com.tencent.tbs.one.impl.e.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import java.io.File;

public class b
  extends a<e<File>>
{
  Context b;
  String c;
  d.a d;
  private File e;
  private Bundle f;
  
  public b(Context paramContext, String paramString, d.a parama, File paramFile, Bundle paramBundle)
  {
    this.b = paramContext;
    this.c = paramString;
    this.d = parama;
    this.e = paramFile;
    this.f = paramBundle;
  }
  
  File a(String paramString)
  {
    File localFile = Environment.getExternalStorageDirectory();
    return new File(localFile + File.separator + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString, "x5.tbs.org");
  }
  
  public final void a()
  {
    m.b(new b.1(this));
  }
  
  protected e.a c()
  {
    return e.a.f;
  }
  
  void d()
  {
    h.a("TBSOneAction", 2004, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.c.b
 * JD-Core Version:    0.7.0.1
 */