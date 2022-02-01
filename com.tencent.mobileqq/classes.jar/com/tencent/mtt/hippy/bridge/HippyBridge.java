package com.tencent.mtt.hippy.bridge;

import android.content.res.AssetManager;

public abstract interface HippyBridge
{
  public static final String URI_SCHEME_ASSETS = "asset:";
  public static final String URI_SCHEME_FILE = "file:";
  
  public abstract void callFunction(String paramString1, String paramString2, NativeCallback paramNativeCallback);
  
  public abstract void callFunction(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, NativeCallback paramNativeCallback);
  
  public abstract void destroy(NativeCallback paramNativeCallback);
  
  public abstract void initJSBridge(String paramString, NativeCallback paramNativeCallback, int paramInt);
  
  public abstract void onDestroy();
  
  public abstract boolean runScriptFromUri(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, NativeCallback paramNativeCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridge
 * JD-Core Version:    0.7.0.1
 */