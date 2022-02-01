package com.tencent.mtt.hippy.bridge.bundleloader;

import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.bridge.NativeCallback;

public abstract interface HippyBundleLoader
{
  public abstract boolean canUseCodeCache();
  
  public abstract String getBundleUniKey();
  
  public abstract String getCodeCacheTag();
  
  public abstract String getPath();
  
  public abstract String getRawPath();
  
  public abstract boolean load(HippyBridge paramHippyBridge, NativeCallback paramNativeCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
 * JD-Core Version:    0.7.0.1
 */