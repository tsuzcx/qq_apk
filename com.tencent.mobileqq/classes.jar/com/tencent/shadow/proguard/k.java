package com.tencent.shadow.proguard;

import android.content.Context;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.dynamic.host.ManagerFactory;
import com.tencent.shadow.dynamic.host.PluginManagerImpl;
import java.io.File;

public final class k
  extends i
{
  private static final String[] a = { "com.tencent.shadow.core.common", "com.tencent.shadow.dynamic.host", "com.tencent.shadow.core.runtime.container" };
  private final Context b;
  private final InstalledApk c;
  
  public k(Context paramContext, File paramFile)
  {
    this.b = paramContext.getApplicationContext();
    paramContext = new File(new File(this.b.getFilesDir(), "ManagerImplLoader"), Long.toString(paramFile.lastModified(), 36));
    paramContext.mkdirs();
    this.c = new InstalledApk(paramFile.getAbsolutePath(), paramContext.getAbsolutePath(), null);
  }
  
  final String[] a()
  {
    return a;
  }
  
  public final PluginManagerImpl b()
  {
    Object localObject = new b(this.c, getClass().getClassLoader(), a(this.c));
    f localf = new f(this.b, this.c.apkFilePath, (ClassLoader)localObject);
    try
    {
      localObject = ((ManagerFactory)((b)localObject).a(ManagerFactory.class, "com.tencent.shadow.dynamic.impl.ManagerFactoryImpl")).buildManager(localf);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.shadow.proguard.k
 * JD-Core Version:    0.7.0.1
 */