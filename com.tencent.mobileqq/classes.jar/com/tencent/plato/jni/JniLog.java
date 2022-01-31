package com.tencent.plato.jni;

import android.util.Log;
import com.tencent.plato.core.utils.Ev;

public class JniLog
{
  private static final int Log_D = 1;
  private static final int Log_E = 4;
  private static final int Log_I = 2;
  private static final int Log_V = 0;
  private static final int Log_W = 3;
  private static JniLogPrinter sLogPrinter = ;
  
  public static void jniLog(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    if (sLogPrinter != null)
    {
      printLog(paramInt, paramString, paramArrayOfByte);
      return;
    }
    switch (paramInt)
    {
    default: 
      Log.e(paramString, paramArrayOfByte);
      return;
    case 0: 
    case 1: 
      Log.d(paramString, paramArrayOfByte);
      return;
    case 2: 
      Log.i(paramString, paramArrayOfByte);
      return;
    }
    Log.w(paramString, paramArrayOfByte);
  }
  
  private static void printLog(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      sLogPrinter.e(paramString1, paramString2);
      return;
    case 0: 
    case 1: 
      sLogPrinter.d(paramString1, paramString2);
      return;
    case 2: 
      sLogPrinter.i(paramString1, paramString2);
      return;
    }
    sLogPrinter.w(paramString1, paramString2);
  }
  
  public static abstract interface JniLogPrinter
  {
    public abstract int d(String paramString1, String paramString2);
    
    public abstract int e(String paramString1, String paramString2);
    
    public abstract int i(String paramString1, String paramString2);
    
    public abstract int w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.jni.JniLog
 * JD-Core Version:    0.7.0.1
 */