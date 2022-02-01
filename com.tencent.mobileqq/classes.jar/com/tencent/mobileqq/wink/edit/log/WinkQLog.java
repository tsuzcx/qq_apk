package com.tencent.mobileqq.wink.edit.log;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class WinkQLog
{
  public static void a(@NonNull String paramString1, @NonNull String paramString2) {}
  
  public static void a(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_WINK :");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
  
  public static void b(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_WINK :");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2);
  }
  
  public static void c(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_WINK :");
    localStringBuilder.append(paramString1);
    QLog.w(localStringBuilder.toString(), 1, paramString2);
  }
  
  public static void d(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_WINK :");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.log.WinkQLog
 * JD-Core Version:    0.7.0.1
 */