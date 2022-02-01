package com.tencent.vas.update.factory.impl;

import android.util.Log;
import com.tencent.vas.update.factory.api.IVasLog;

public class DefaultVasLogImpl
  implements IVasLog
{
  public void a(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.factory.impl.DefaultVasLogImpl
 * JD-Core Version:    0.7.0.1
 */