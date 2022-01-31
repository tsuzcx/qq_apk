package com.tencent.mobileqq.triton.jni;

import com.tencent.mobileqq.triton.bridge.TTJSBridge;

public final class JNICaller$TTJSBridge
{
  public static boolean nativeEvaluateCallbackJs(TTJSBridge paramTTJSBridge, long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    try
    {
      boolean bool = paramTTJSBridge.nativeEvaluateCallbackJs(paramLong, paramInt1, paramString1, paramInt2, paramString2);
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTJSBridge.nativeEvaluateCallbackJs(paramLong, paramInt1, paramString1, paramInt2, paramString2);
  }
  
  public static void nativeEvaluateJs(TTJSBridge paramTTJSBridge, long paramLong, int paramInt, String paramString)
  {
    try
    {
      paramTTJSBridge.nativeEvaluateJs(paramLong, paramInt, paramString);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      paramTTJSBridge.nativeEvaluateJs(paramLong, paramInt, paramString);
    }
  }
  
  public static boolean nativeEvaluateSubscribeJs(TTJSBridge paramTTJSBridge, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = paramTTJSBridge.nativeEvaluateSubscribeJs(paramLong, paramInt, paramString1, paramString2, paramString3);
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTJSBridge.nativeEvaluateSubscribeJs(paramLong, paramInt, paramString1, paramString2, paramString3);
  }
  
  public static byte[] nativeGetNativeBuffer(TTJSBridge paramTTJSBridge, long paramLong, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramTTJSBridge.nativeGetNativeBuffer(paramLong, paramInt);
      return arrayOfByte;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTJSBridge.nativeGetNativeBuffer(paramLong, paramInt);
  }
  
  public static int nativeNewNativeBuffer(TTJSBridge paramTTJSBridge, long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      int i = paramTTJSBridge.nativeNewNativeBuffer(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramTTJSBridge.nativeNewNativeBuffer(paramLong, paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.jni.JNICaller.TTJSBridge
 * JD-Core Version:    0.7.0.1
 */