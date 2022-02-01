package com.tencent.qa.apphook;

import android.util.Log;

public class GalileoHookLog
{
  private static final String TAG = "androidHook";
  
  public static int d(String paramString)
  {
    return Log.d("androidHook", paramString);
  }
  
  public static int e(String paramString)
  {
    return Log.e("androidHook", paramString);
  }
  
  public static int e(String paramString, Throwable paramThrowable)
  {
    return Log.e("androidHook", paramString, paramThrowable);
  }
  
  public static int i(String paramString)
  {
    return Log.i("androidHook", paramString);
  }
  
  public static int v(String paramString)
  {
    return Log.v("androidHook", paramString);
  }
  
  public static int w(String paramString)
  {
    return Log.w("androidHook", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.GalileoHookLog
 * JD-Core Version:    0.7.0.1
 */