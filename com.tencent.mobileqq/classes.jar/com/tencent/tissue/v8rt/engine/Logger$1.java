package com.tencent.tissue.v8rt.engine;

import android.util.Log;

final class Logger$1
  implements ILog
{
  String TAG = "TV8RT";
  
  public int d(String paramString1, String paramString2)
  {
    return Log.d(this.TAG + "/" + paramString1, paramString2);
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.d(this.TAG + "/" + paramString1, paramString2, paramThrowable);
  }
  
  public int e(String paramString1, String paramString2)
  {
    return Log.e(this.TAG + "/" + paramString1, paramString2);
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.e(this.TAG + "/" + paramString1, paramString2, paramThrowable);
  }
  
  public int i(String paramString1, String paramString2)
  {
    return Log.i(this.TAG + "/" + paramString1, paramString2);
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.i(this.TAG + "/" + paramString1, paramString2, paramThrowable);
  }
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = this.TAG + "/" + paramString1;
    int i;
    if (paramInt >= 100)
    {
      i = paramInt - 100 + 3;
      if (i > 3) {
        break label66;
      }
      Log.d(paramString1, paramString2);
    }
    for (;;)
    {
      if (paramInt >= 100) {}
      return;
      i = paramInt;
      break;
      label66:
      if (i == 4) {
        Log.i(paramString1, paramString2);
      } else if (i == 5) {
        Log.w(paramString1, paramString2);
      } else if (i == 6) {
        Log.e(paramString1, paramString2);
      }
    }
  }
  
  public int w(String paramString1, String paramString2)
  {
    return Log.w(this.TAG + "/" + paramString1, paramString2);
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.w(this.TAG + "/" + paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.Logger.1
 * JD-Core Version:    0.7.0.1
 */