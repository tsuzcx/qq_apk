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
    Object localObject2;
    if (paramString.startsWith("com.tencent.xaction.openapi.")) {
      try
      {
        localObject3 = super.loadClass(paramString, paramBoolean);
        Object localObject1 = localObject3;
        if (localObject3 == null) {
          break label51;
        }
        return localObject3;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        localClassNotFoundException1.printStackTrace();
      }
    } else {
      localObject2 = null;
    }
    try
    {
      label51:
      localObject3 = findClass(paramString);
      localObject2 = localObject3;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      label61:
      break label61;
    }
    Object localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = super.loadClass(paramString, paramBoolean);
    }
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.DynamicClassLoader
 * JD-Core Version:    0.7.0.1
 */