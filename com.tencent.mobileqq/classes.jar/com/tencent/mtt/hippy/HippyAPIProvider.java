package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.List;
import java.util.Map;

public abstract interface HippyAPIProvider
{
  public abstract List<Class<? extends HippyViewController>> getControllers();
  
  public abstract List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules();
  
  public abstract Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyAPIProvider
 * JD-Core Version:    0.7.0.1
 */