package com.tencent.xaction.openapi;

import dalvik.system.DexClassLoader;

public class DynamicClassLoader
  extends DexClassLoader
{
  public DynamicClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    if (!paramString.startsWith("com.tencent.xaction.")) {
      return super.loadClass(paramString, paramBoolean);
    }
    if (paramString.startsWith("com.tencent.xaction.openapi.")) {
      return super.loadClass(paramString, paramBoolean);
    }
    Object localObject1 = null;
    try
    {
      localObject2 = findClass(paramString);
      localObject1 = localObject2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject2;
      label44:
      break label44;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = super.loadClass(paramString, paramBoolean);
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.openapi.DynamicClassLoader
 * JD-Core Version:    0.7.0.1
 */