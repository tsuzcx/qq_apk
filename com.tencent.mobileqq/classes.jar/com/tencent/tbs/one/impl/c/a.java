package com.tencent.tbs.one.impl.c;

import android.content.Context;
import com.tencent.tbs.one.TBSOneComponent;
import java.io.File;

public final class a
  implements TBSOneComponent
{
  Context a;
  ClassLoader b;
  Object c;
  private String d;
  private String e;
  private int f;
  private File g;
  
  public a(String paramString1, String paramString2, int paramInt, File paramFile)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramInt;
    this.g = paramFile;
  }
  
  public final ClassLoader getEntryClassLoader()
  {
    return this.b;
  }
  
  public final Object getEntryObject()
  {
    return this.c;
  }
  
  public final File getInstallationDirectory()
  {
    return this.g;
  }
  
  public final String getName()
  {
    return this.d;
  }
  
  public final Context getResourcesContext()
  {
    return this.a;
  }
  
  public final int getVersionCode()
  {
    return this.f;
  }
  
  public final String getVersionName()
  {
    return this.e;
  }
  
  public final String toString()
  {
    String str1 = this.d;
    String str2 = this.e;
    int i = this.f;
    File localFile = this.g;
    Context localContext = this.a;
    ClassLoader localClassLoader = this.b;
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = localObject.getClass().getName();
    }
    return String.format("{name: '%s', versionName: '%s', versionCode: %d, installationDirectory: '%s', apkContext: '%s', entryClassLoader: '%s', entryObject: '%s'}", new Object[] { str1, str2, Integer.valueOf(i), localFile, localContext, localClassLoader, localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a
 * JD-Core Version:    0.7.0.1
 */