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
    catch (InternalError localInternalError)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("InternalError, load class from old loader: ");
      localStringBuilder2.append(paramString);
      QMLog.w("MiniAppClassloader", localStringBuilder2.toString(), localInternalError);
      return this.originClassLoader.loadClass(paramString);
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("ClassNotFoundException, load class from old loader: ");
      localStringBuilder1.append(paramString);
      QMLog.w("MiniAppClassloader", localStringBuilder1.toString());
      return this.originClassLoader.loadClass(paramString);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label49:
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniAppClassloader
 * JD-Core Version:    0.7.0.1
 */