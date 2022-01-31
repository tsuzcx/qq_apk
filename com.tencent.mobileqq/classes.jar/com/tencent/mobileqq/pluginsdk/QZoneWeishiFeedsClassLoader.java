package com.tencent.mobileqq.pluginsdk;

import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;

public class QZoneWeishiFeedsClassLoader
  extends DexClassLoader
{
  private ClassLoader mGrandParent;
  private final String[] mInterceptPackageNames = new String[0];
  
  public QZoneWeishiFeedsClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    this.mGrandParent = paramClassLoader.getParent().getParent();
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    int j = 0;
    int i = paramString.lastIndexOf('.');
    if (i != -1) {}
    Object localObject2;
    for (Object localObject1 = paramString.substring(0, i);; localObject1 = "")
    {
      localObject2 = this.mInterceptPackageNames;
      int k = localObject2.length;
      i = 0;
      while (i < k)
      {
        if (((String)localObject1).startsWith(localObject2[i]))
        {
          QLog.d("rays", 1, "intercept class=" + paramString);
          j = 1;
        }
        i += 1;
      }
    }
    if (j == 0) {
      localObject1 = super.loadClass(paramString, paramBoolean);
    }
    Throwable localThrowable;
    label142:
    do
    {
      do
      {
        return localObject1;
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
        break label142;
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    try
    {
      paramString = this.mGrandParent.loadClass(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.QZoneWeishiFeedsClassLoader
 * JD-Core Version:    0.7.0.1
 */