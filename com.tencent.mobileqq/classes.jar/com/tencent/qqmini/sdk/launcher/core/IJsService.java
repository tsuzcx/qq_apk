package com.tencent.qqmini.sdk.launcher.core;

import android.webkit.ValueCallback;

public abstract interface IJsService
{
  public abstract int createNativeBuffer(byte[] paramArrayOfByte, long paramLong1, long paramLong2);
  
  public abstract void evaluateCallbackJs(int paramInt, String paramString);
  
  public abstract void evaluateJs(String paramString, ValueCallback paramValueCallback);
  
  public abstract void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt);
  
  public abstract byte[] getNativeBuffer(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.IJsService
 * JD-Core Version:    0.7.0.1
 */