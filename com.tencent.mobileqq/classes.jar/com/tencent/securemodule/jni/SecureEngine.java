package com.tencent.securemodule.jni;

import android.content.Context;

public class SecureEngine
{
  private int object;
  
  public SecureEngine(Context paramContext)
  {
    try
    {
      this.object = newObject(paramContext);
      if (this.object != 0) {
        return;
      }
      throw new VerifyError();
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean checkSecureStatus(Context paramContext)
  {
    try
    {
      boolean bool = nativeCheckSecureStatus(paramContext);
      return bool;
    }
    catch (Throwable paramContext)
    {
      label7:
      break label7;
    }
    return false;
  }
  
  private static native void deleteObject(int paramInt);
  
  public static String getEngineVersion(Context paramContext)
  {
    try
    {
      paramContext = nativeGetEngineVersion(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label7:
      break label7;
    }
    return "";
  }
  
  private static native boolean nativeCheckSecureStatus(Context paramContext);
  
  private static native String nativeGetEngineVersion(Context paramContext);
  
  private static native int newObject(Context paramContext);
  
  private static native int scanThreatens(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  protected void finalize()
  {
    int i = this.object;
    if (i != 0) {
      deleteObject(i);
    }
  }
  
  public int scanThreatens(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      paramInt = scanThreatens(this.object, paramInt, paramArrayOfByte);
      return paramInt;
    }
    catch (Throwable paramArrayOfByte)
    {
      label12:
      break label12;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.jni.SecureEngine
 * JD-Core Version:    0.7.0.1
 */