package com.tencent.vas.update.module.impl;

import android.util.Log;
import com.tencent.vas.update.callback.IVasLog;

public class DefaultVasLogImpl
  implements IVasLog
{
  public void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public boolean isColorLevel()
  {
    return true;
  }
  
  public boolean isDebugVersion()
  {
    return true;
  }
  
  public void v(String paramString1, String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DefaultVasLogImpl
 * JD-Core Version:    0.7.0.1
 */