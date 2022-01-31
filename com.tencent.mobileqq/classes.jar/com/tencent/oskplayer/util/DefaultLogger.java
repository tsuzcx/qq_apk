package com.tencent.oskplayer.util;

import android.util.Log;

public class DefaultLogger
  implements QLog
{
  public static final String TAG = "OskPlayer";
  
  public int d(String paramString1, String paramString2)
  {
    return Log.d("OskPlayer/" + paramString1, paramString2);
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.d("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int e(String paramString1, String paramString2)
  {
    return Log.e("OskPlayer/" + paramString1, paramString2);
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.e("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int i(String paramString1, String paramString2)
  {
    return Log.i("OskPlayer/" + paramString1, paramString2);
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.i("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int v(String paramString1, String paramString2)
  {
    return Log.v("OskPlayer/" + paramString1, paramString2);
  }
  
  public int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.v("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int w(String paramString1, String paramString2)
  {
    return Log.w("OskPlayer/" + paramString1, paramString2);
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.w("OskPlayer/" + paramString1, paramString2, paramThrowable);
  }
  
  public int w(String paramString, Throwable paramThrowable)
  {
    return Log.w("OskPlayer/" + paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.util.DefaultLogger
 * JD-Core Version:    0.7.0.1
 */