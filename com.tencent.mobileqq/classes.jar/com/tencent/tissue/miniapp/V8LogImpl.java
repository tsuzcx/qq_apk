package com.tencent.tissue.miniapp;

import android.util.Log;
import com.tencent.tissue.v8rt.engine.ILog;

public class V8LogImpl
  implements ILog
{
  String TAG = "MIV8RT";
  
  public int d(String paramString1, String paramString2)
  {
    Log.d(this.TAG + "/" + paramString1, paramString2, null);
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.d(this.TAG + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    Log.e(this.TAG + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(this.TAG + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    Log.i(this.TAG + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(this.TAG + "/" + paramString1, paramString2, paramThrowable);
    return 0;
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
    Log.w(this.TAG + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(this.TAG + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.V8LogImpl
 * JD-Core Version:    0.7.0.1
 */