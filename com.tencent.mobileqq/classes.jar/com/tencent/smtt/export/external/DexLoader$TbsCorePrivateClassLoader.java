package com.tencent.smtt.export.external;

import android.util.Log;
import dalvik.system.DexClassLoader;

class DexLoader$TbsCorePrivateClassLoader
  extends DexClassLoader
{
  public DexLoader$TbsCorePrivateClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      boolean bool2 = paramString.startsWith("org.chromium");
      boolean bool1 = bool2;
      Object localObject1;
      if (DexLoader.access$000())
      {
        if ((bool2) || (paramString.startsWith("com.tencent")) || (paramString.startsWith("com.taf"))) {
          bool1 = true;
        }
      }
      else
      {
        if (bool1) {
          break label66;
        }
        localObject1 = super.loadClass(paramString, paramBoolean);
      }
      label66:
      do
      {
        Object localObject2;
        do
        {
          do
          {
            return localObject1;
            bool1 = false;
            break;
            localObject2 = findLoadedClass(paramString);
            localObject1 = localObject2;
          } while (localObject2 != null);
          try
          {
            Log.d("DexLoader", "WebCoreClassLoader - loadClass(" + paramString + "," + paramBoolean + ")...");
            localObject1 = findClass(paramString);
            localObject2 = localObject1;
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            ClassLoader localClassLoader;
            break label132;
          }
          localObject1 = localObject2;
        } while (localObject2 != null);
        localClassLoader = getParent();
        localObject1 = localObject2;
      } while (localClassLoader == null);
      label132:
      return localClassLoader.loadClass(paramString);
    }
    else
    {
      return super.loadClass(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexLoader.TbsCorePrivateClassLoader
 * JD-Core Version:    0.7.0.1
 */