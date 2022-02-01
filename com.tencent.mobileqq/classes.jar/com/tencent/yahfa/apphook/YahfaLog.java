package com.tencent.yahfa.apphook;

import android.util.Log;

public class YahfaLog
{
  public static final String TAG = "yahfaHook";
  
  public static int d(String paramString)
  {
    return Log.d("yahfaHook", paramString);
  }
  
  public static int e(String paramString)
  {
    return Log.e("yahfaHook", paramString);
  }
  
  public static int e(String paramString, Throwable paramThrowable)
  {
    return Log.e("yahfaHook", paramString, paramThrowable);
  }
  
  public static int i(String paramString)
  {
    return Log.i("yahfaHook", paramString);
  }
  
  public static int v(String paramString)
  {
    return Log.v("yahfaHook", paramString);
  }
  
  public static int w(String paramString)
  {
    return Log.w("yahfaHook", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.yahfa.apphook.YahfaLog
 * JD-Core Version:    0.7.0.1
 */