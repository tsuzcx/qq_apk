package com.tencent.qqmini.sdk.launcher.dynamic;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
      Class localClass = super.findClass(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QMLog.w("MiniAppClassloader", "ClassNotFoundException, load class from old loader: " + paramString);
      return this.originClassLoader.loadClass(paramString);
    }
    catch (InternalError localInternalError)
    {
      QMLog.w("MiniAppClassloader", "InternalError, load class from old loader: " + paramString);
    }
    return this.originClassLoader.loadClass(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniAppClassloader
 * JD-Core Version:    0.7.0.1
 */