package com.tencent.rmonitor.jvmti;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class JvmtiNative
{
  public static native void attachJvmtiAgent(boolean paramBoolean, String paramString, ClassLoader paramClassLoader);
  
  public static native long[] getGcInfo();
  
  public static native boolean loadSym(boolean paramBoolean);
  
  public static native boolean nativeDoHook(boolean paramBoolean);
  
  public static native void openJdwp();
  
  static void proxyAttachJvmtiAgent(boolean paramBoolean, @NonNull String paramString1, @Nullable String paramString2, @Nullable ClassLoader paramClassLoader)
  {
    if (paramString2 == null)
    {
      attachJvmtiAgent(paramBoolean, paramString1, paramClassLoader);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString2);
    attachJvmtiAgent(paramBoolean, localStringBuilder.toString(), paramClassLoader);
  }
  
  public static native void setThreadThreshold(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.jvmti.JvmtiNative
 * JD-Core Version:    0.7.0.1
 */