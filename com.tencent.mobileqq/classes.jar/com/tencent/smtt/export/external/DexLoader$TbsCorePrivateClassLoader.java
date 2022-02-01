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
    Object localObject2;
    if (paramString != null)
    {
      boolean bool2 = paramString.startsWith("org.chromium");
      boolean bool1 = bool2;
      if (DexLoader.access$000()) {
        if ((!bool2) && (!paramString.startsWith("com.tencent")) && (!paramString.startsWith("com.taf"))) {
          bool1 = false;
        } else {
          bool1 = true;
        }
      }
      if (!bool1) {
        return super.loadClass(paramString, paramBoolean);
      }
      localObject2 = findLoadedClass(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("WebCoreClassLoader - loadClass(");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(")...");
      Log.d("DexLoader", ((StringBuilder)localObject1).toString());
      localObject1 = findClass(paramString);
      localObject2 = localObject1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label150:
      ClassLoader localClassLoader;
      break label150;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localClassLoader = getParent();
      localObject1 = localObject2;
      if (localClassLoader != null) {
        localObject1 = localClassLoader.loadClass(paramString);
      }
    }
    return localObject1;
    return super.loadClass(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexLoader.TbsCorePrivateClassLoader
 * JD-Core Version:    0.7.0.1
 */