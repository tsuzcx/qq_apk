package com.tencent.shadow.proguard;

import android.os.Build.VERSION;
import com.tencent.shadow.core.common.InstalledApk;
import dalvik.system.DexClassLoader;

final class b
  extends DexClassLoader
{
  private ClassLoader a;
  private final String[] b;
  
  b(InstalledApk paramInstalledApk, ClassLoader paramClassLoader, String[] paramArrayOfString)
  {
    super(paramInstalledApk.apkFilePath, paramInstalledApk.oDexPath, paramInstalledApk.libraryPath, paramClassLoader);
    int i = 0;
    while (i <= 0)
    {
      paramClassLoader = paramClassLoader.getParent();
      i += 1;
    }
    this.a = paramClassLoader;
    this.b = paramArrayOfString;
  }
  
  final Object a(Class paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.cast(loadClass(paramString).newInstance());
      return paramClass;
    }
    catch (ClassNotFoundException paramClass)
    {
      throw new Exception(paramClass);
    }
    catch (ClassCastException paramClass)
    {
      break label16;
    }
    catch (InstantiationException paramClass)
    {
      break label16;
    }
    catch (IllegalAccessException paramClass)
    {
      label16:
      break label16;
    }
  }
  
  protected final Class loadClass(String paramString, boolean paramBoolean)
  {
    int i = paramString.lastIndexOf('.');
    Object localObject1;
    Object localObject2;
    if (i != -1)
    {
      localObject1 = paramString.substring(0, i);
      localObject2 = this.b;
      int j = localObject2.length;
      i = 0;
      label33:
      if (i >= j) {
        break label154;
      }
      if (!((String)localObject1).equals(localObject2[i])) {
        break label75;
      }
    }
    label154:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localObject1 = super.loadClass(paramString, paramBoolean);
      }
      label75:
      Throwable localThrowable;
      label112:
      do
      {
        do
        {
          return localObject1;
          localObject1 = "";
          break;
          i += 1;
          break label33;
          localObject2 = findLoadedClass(paramString);
          localObject1 = localObject2;
        } while (localObject2 != null);
        localThrowable = null;
        try
        {
          localObject1 = findClass(paramString);
          localObject2 = localObject1;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          break label112;
        }
        localObject1 = localObject2;
      } while (localObject2 != null);
      try
      {
        paramString = this.a.loadClass(paramString);
        return paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        if (Build.VERSION.SDK_INT >= 19) {
          paramString.addSuppressed(localThrowable);
        }
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.shadow.proguard.b
 * JD-Core Version:    0.7.0.1
 */