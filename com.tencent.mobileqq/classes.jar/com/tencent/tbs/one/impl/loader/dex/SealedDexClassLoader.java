package com.tencent.tbs.one.impl.loader.dex;

import dalvik.system.BaseDexClassLoader;

public class SealedDexClassLoader
  extends BaseDexClassLoader
{
  private String mSealedPackage;
  
  public SealedDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, String paramString4) {}
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if ((this.mSealedPackage == null) || (paramString == null) || (!paramString.startsWith(this.mSealedPackage))) {
      localObject1 = super.loadClass(paramString, paramBoolean);
    }
    label55:
    do
    {
      Object localObject2;
      do
      {
        do
        {
          return localObject1;
          localObject2 = findLoadedClass(paramString);
          localObject1 = localObject2;
        } while (localObject2 != null);
        try
        {
          localObject1 = findClass(paramString);
          localObject2 = localObject1;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          ClassLoader localClassLoader;
          break label55;
        }
        localObject1 = localObject2;
      } while (localObject2 != null);
      localClassLoader = getParent();
      localObject1 = localObject2;
    } while (localClassLoader == null);
    return localClassLoader.loadClass(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.SealedDexClassLoader
 * JD-Core Version:    0.7.0.1
 */