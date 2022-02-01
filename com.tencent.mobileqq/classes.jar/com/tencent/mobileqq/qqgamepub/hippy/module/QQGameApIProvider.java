package com.tencent.mobileqq.qqgamepub.hippy.module;

import com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountMsgViewController;
import com.tencent.mobileqq.qqgamepub.hippy.view.GpArkViewController;
import com.tencent.mobileqq.qqgamepub.hippy.view.GpMsgHelperViewController;
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

public class QQGameApIProvider
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(GamePubAccountMsgViewController.class);
    localArrayList.add(GpMsgHelperViewController.class);
    localArrayList.add(GpArkViewController.class);
    return localArrayList;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(QQWadlModule.class, new QQGameApIProvider.1(this, paramHippyEngineContext));
    localHashMap.put(GamePubAccountModule.class, new QQGameApIProvider.2(this, paramHippyEngineContext));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.module.QQGameApIProvider
 * JD-Core Version:    0.7.0.1
 */