package com.tencent.qqmusic.mediaplayer.util;

import android.util.Log;
import com.tencent.qqmusic.mediaplayer.ILog;

final class Logger$1
  implements ILog
{
  public void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    Log.e(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    Log.e(paramString, "an error occurred", paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Logger.1
 * JD-Core Version:    0.7.0.1
 */