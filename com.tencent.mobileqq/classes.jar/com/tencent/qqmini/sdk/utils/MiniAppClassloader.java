package com.tencent.qqmini.sdk.utils;

import android.util.Log;
import dalvik.system.PathClassLoader;

public class MiniAppClassloader
  extends PathClassLoader
{
  private static final String TAG = "MiniAppClassloader";
  private ClassLoader originClassLoader;
  
  public MiniAppClassloader(String paramString1, String paramString2, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramClassLoader.getParent());
    this.originClassLoader = paramClassLoader;
  }
  
  public Class<?> findClass(String paramString)
  {
    try
    {
      localObject = super.findClass(paramString);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      break label48;
    }
    catch (InternalError localInternalError)
    {
      label8:
      label48:
      break label8;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("InternalError, load class from old loader: ");
    ((StringBuilder)localObject).append(paramString);
    Log.w("MiniAppClassloader", ((StringBuilder)localObject).toString());
    return this.originClassLoader.loadClass(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ClassNotFoundException, load class from old loader: ");
    ((StringBuilder)localObject).append(paramString);
    Log.w("MiniAppClassloader", ((StringBuilder)localObject).toString());
    return this.originClassLoader.loadClass(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniAppClassloader
 * JD-Core Version:    0.7.0.1
 */