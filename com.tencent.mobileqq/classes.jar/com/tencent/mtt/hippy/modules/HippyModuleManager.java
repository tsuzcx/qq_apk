package com.tencent.mtt.hippy.modules;

import com.tencent.mtt.hippy.bridge.c;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

public abstract interface HippyModuleManager
{
  public abstract void callNatives(c paramc);
  
  public abstract void destroy();
  
  public abstract <T extends HippyJavaScriptModule> T getJavaScriptModule(Class<T> paramClass);
  
  public abstract <T extends HippyNativeModuleBase> T getNativeModule(Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.HippyModuleManager
 * JD-Core Version:    0.7.0.1
 */