package com.tencent.tbs.one.impl.e.c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.e.e.a;
import java.io.File;

public final class a
  extends b
{
  public a(Context paramContext, String paramString, d.a parama, File paramFile, Bundle paramBundle)
  {
    super(paramContext, paramString, parama, paramFile, paramBundle);
  }
  
  final File a(String paramString)
  {
    try
    {
      paramString = this.b.createPackageContext(paramString, 2);
      if (paramString != null)
      {
        paramString = com.tencent.tbs.one.impl.common.f.a(this.b, paramString, this.c, this.d.a, this.d.c);
        com.tencent.tbs.one.impl.a.f.a("installFromSdcardPkg,backup dir=%s", new Object[] { paramString });
        if (paramString == null) {
          return null;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.d.a);
        localStringBuilder.append(".tbs");
        paramString = new File(paramString, localStringBuilder.toString());
        return paramString;
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return null;
  }
  
  protected final e.a c()
  {
    return e.a.g;
  }
  
  final void d()
  {
    h.a("TBSOneAction", 2002, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.c.a
 * JD-Core Version:    0.7.0.1
 */