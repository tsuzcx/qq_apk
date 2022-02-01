package com.tencent.mobileqq.wink.edit.log;

import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.render.log.ILogProxy;
import com.tencent.tavcut.render.log.TavLogger;

public class TavCutQLog
{
  public static final ILogProxy a = new TavCutQLog.1();
  
  public static void a(int paramInt)
  {
    TavLogger.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDebugVersion()) {
      a(paramInt1);
    } else {
      a(paramInt2);
    }
    TavLogger.a(a);
  }
  
  public static void a(@NonNull String paramString1, @NonNull String paramString2) {}
  
  public static void b(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_TAVCUT :");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2);
  }
  
  public static void c(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_TAVCUT :");
    localStringBuilder.append(paramString1);
    QLog.w(localStringBuilder.toString(), 1, paramString2);
  }
  
  public static void d(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_TAVCUT :");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.log.TavCutQLog
 * JD-Core Version:    0.7.0.1
 */