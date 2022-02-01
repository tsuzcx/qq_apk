package com.tencent.mobileqq.newnearby.hippy;

import com.tencent.mobileqq.newnearby.hippy.module.NearbyHippyAppModule;
import com.tencent.mobileqq.newnearby.hippy.module.NearbyHippyDataModule;
import com.tencent.mobileqq.newnearby.hippy.module.NearbyHippySSOModule;
import com.tencent.mobileqq.newnearby.hippy.module.NearbyHippyUIModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearbyHippyApiProvider
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    return null;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(NearbyHippySSOModule.class, new NearbyHippyApiProvider.1(this, paramHippyEngineContext));
    localHashMap.put(NearbyHippyUIModule.class, new NearbyHippyApiProvider.2(this, paramHippyEngineContext));
    localHashMap.put(NearbyHippyAppModule.class, new NearbyHippyApiProvider.3(this, paramHippyEngineContext));
    localHashMap.put(NearbyHippyDataModule.class, new NearbyHippyApiProvider.4(this, paramHippyEngineContext));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.NearbyHippyApiProvider
 * JD-Core Version:    0.7.0.1
 */