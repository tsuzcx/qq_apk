package com.tencent.mobileqq.vas.hippy.api.impl;

import com.tencent.hippy.qq.module.vas.QQTenPayModule;
import com.tencent.hippy.qq.module.vas.VasModule;
import com.tencent.hippy.qq.module.vas.VasPersonalizedModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VasApiProvider
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    return new ArrayList();
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(QQTenPayModule.class, new VasApiProvider.1(this, paramHippyEngineContext));
    localHashMap.put(VasModule.class, new VasApiProvider.2(this, paramHippyEngineContext));
    localHashMap.put(VasPersonalizedModule.class, new VasApiProvider.3(this, paramHippyEngineContext));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.api.impl.VasApiProvider
 * JD-Core Version:    0.7.0.1
 */