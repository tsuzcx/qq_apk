package com.tencent.mtt.hippy.bridge;

import android.content.res.AssetManager;

public abstract interface HippyBridge
{
  public abstract void callFunction(String paramString1, String paramString2, NativeCallback paramNativeCallback);
  
  public abstract void callFunction(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, NativeCallback paramNativeCallback);
  
  public abstract void destroy(NativeCallback paramNativeCallback);
  
  public abstract void initJSBridge(String paramString, NativeCallback paramNativeCallback, int paramInt);
  
  public abstract boolean runScriptFromAssets(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, NativeCallback paramNativeCallback);
  
  public abstract boolean runScriptFromFile(String paramString1, String paramString2, boolean paramBoolean, String paramString3, NativeCallback paramNativeCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridge
 * JD-Core Version:    0.7.0.1
 */