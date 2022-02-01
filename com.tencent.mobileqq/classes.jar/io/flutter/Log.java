package io.flutter;

import androidx.annotation.NonNull;

public class Log
{
  private static int logLevel = 3;
  
  public static void d(@NonNull String paramString1, @NonNull String paramString2) {}
  
  public static void d(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {}
  
  public static void e(@NonNull String paramString1, @NonNull String paramString2)
  {
    android.util.Log.e(paramString1, paramString2);
  }
  
  public static void e(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable)
  {
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(@NonNull String paramString1, @NonNull String paramString2) {}
  
  public static void i(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {}
  
  public static void setLogLevel(int paramInt)
  {
    logLevel = paramInt;
  }
  
  public static void v(@NonNull String paramString1, @NonNull String paramString2) {}
  
  public static void v(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {}
  
  public static void w(@NonNull String paramString1, @NonNull String paramString2)
  {
    android.util.Log.w(paramString1, paramString2);
  }
  
  public static void w(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable)
  {
    android.util.Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void wtf(@NonNull String paramString1, @NonNull String paramString2)
  {
    android.util.Log.wtf(paramString1, paramString2);
  }
  
  public static void wtf(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable)
  {
    android.util.Log.wtf(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.Log
 * JD-Core Version:    0.7.0.1
 */