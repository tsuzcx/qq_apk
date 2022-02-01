package com.tencent.mobileqq.videoplatform.imp;

import android.util.Log;
import com.tencent.mobileqq.videoplatform.api.ILog;

public class LogImp
  implements ILog
{
  public void d(String paramString1, int paramInt, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void e(String paramString1, int paramInt, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, int paramInt, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public boolean isColorLevel()
  {
    return true;
  }
  
  public void v(String paramString1, int paramInt, String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public void w(String paramString1, int paramInt, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.imp.LogImp
 * JD-Core Version:    0.7.0.1
 */