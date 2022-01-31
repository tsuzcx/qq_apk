package com.tencent.mobileqq.triton.sdk;

import android.util.Log;
import dalvik.system.PathClassLoader;

public class GameEngineClassloader
  extends PathClassLoader
{
  private static final String TAG = "GameEngineClassloader";
  private ClassLoader originClassLoader;
  
  public GameEngineClassloader(String paramString1, String paramString2, ClassLoader paramClassLoader)
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
      Log.w("GameEngineClassloader", "ClassNotFoundException, load class from old loader: " + paramString);
      return this.originClassLoader.loadClass(paramString);
    }
    catch (InternalError localInternalError)
    {
      Log.w("GameEngineClassloader", "InternalError, load class from old loader: " + paramString);
    }
    return this.originClassLoader.loadClass(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.GameEngineClassloader
 * JD-Core Version:    0.7.0.1
 */