package com.tencent.mobileqq.triton.engine;

import android.util.Log;
import com.tencent.mobileqq.triton.sdk.ITLog;

final class TTLog$1
  implements ITLog
{
  public int d(String paramString1, String paramString2)
  {
    return Log.d(paramString1, paramString2);
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public int e(String paramString1, String paramString2)
  {
    return Log.e(paramString1, paramString2);
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public int i(String paramString1, String paramString2)
  {
    return Log.i(paramString1, paramString2);
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    int i;
    if (paramInt >= 100)
    {
      i = paramInt - 100 + 3;
      if (i > 3) {
        break label55;
      }
      Log.d(paramString1, paramString2);
      label26:
      if (paramInt >= 100)
      {
        paramInt -= 100;
        if (paramInt > 3) {
          break label101;
        }
        Log.d(paramString1, paramString2);
      }
    }
    label55:
    label101:
    do
    {
      return;
      i = paramInt;
      break;
      if (i == 4)
      {
        Log.i(paramString1, paramString2);
        break label26;
      }
      if (i == 5)
      {
        Log.w(paramString1, paramString2);
        break label26;
      }
      if (i != 6) {
        break label26;
      }
      Log.e(paramString1, paramString2);
      break label26;
      if (paramInt == 4)
      {
        Log.i(paramString1, paramString2);
        return;
      }
      if (paramInt == 5)
      {
        Log.w(paramString1, paramString2);
        return;
      }
    } while (paramInt != 6);
    Log.e(paramString1, paramString2);
  }
  
  public int w(String paramString1, String paramString2)
  {
    return Log.w(paramString1, paramString2);
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTLog.1
 * JD-Core Version:    0.7.0.1
 */