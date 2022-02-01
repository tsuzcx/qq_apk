package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;

public abstract interface a
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, HippyBundleLoader paramHippyBundleLoader, HippyEngine.ModuleListener paramModuleListener, HippyRootView paramHippyRootView);
  
  public abstract void a(Callback<Boolean> paramCallback);
  
  public abstract void a(HippyJsException paramHippyJsException);
  
  public abstract void a(Object paramObject);
  
  public abstract void a(String paramString, int paramInt, HippyMap paramHippyMap);
  
  public abstract void a(String paramString1, String paramString2, Object paramObject);
  
  public abstract void b(int paramInt);
  
  public abstract void c(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.a
 * JD-Core Version:    0.7.0.1
 */