package com.tencent.qqmini.v8rt.engine;

import android.util.Log;

final class Logger$1
  implements ILog
{
  public static final String TAG = "TV8RT";
  
  public int d(String paramString1, String paramString2)
  {
    return Log.d("TV8RT/" + paramString1, paramString2);
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.d("TV8RT/" + paramString1, paramString2, paramThrowable);
  }
  
  public int e(String paramString1, String paramString2)
  {
    return Log.e("TV8RT/" + paramString1, paramString2);
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.e("TV8RT/" + paramString1, paramString2, paramThrowable);
  }
  
  public int i(String paramString1, String paramString2)
  {
    return Log.i("TV8RT/" + paramString1, paramString2);
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.i("TV8RT/" + paramString1, paramString2, paramThrowable);
  }
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = "TV8RT/" + paramString1;
    int i;
    if (paramInt >= 100)
    {
      i = paramInt - 100 + 3;
      if (i > 3) {
        break label59;
      }
      Log.d(paramString1, paramString2);
    }
    for (;;)
    {
      if (paramInt >= 100) {}
      return;
      i = paramInt;
      break;
      label59:
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
    return Log.w("TV8RT/" + paramString1, paramString2);
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.w("TV8RT/" + paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.Logger.1
 * JD-Core Version:    0.7.0.1
 */