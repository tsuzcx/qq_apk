package com.tencent.mobileqq.kandian.biz.hippy.provider;

import com.tencent.hippy.qq.view.tkd.doublescrollview.HippyTKDDoubleScrollViewController;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDImageViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewController;
import com.tencent.hippy.qq.view.tkd.text.HippyTKDTextViewController;
import com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroupController;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDAccountModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDAladdinConfigModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDAlertModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDBiuModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDDataReportModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDDebugModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDDeviceModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDNativeProxyModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDSearchStatModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDSsoModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDToastModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDWindowModule;
import com.tencent.mobileqq.kandian.biz.hippy.module.TKDWupModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TKDApiProvider
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(HippyTKDListViewController.class);
    localArrayList.add(HippyTKDDoubleScrollViewController.class);
    localArrayList.add(HippyTKDTextViewController.class);
    localArrayList.add(HippyTKDViewGroupController.class);
    localArrayList.add(HippyTKDImageViewController.class);
    localArrayList.add(HippyTKDGifImageViewController.class);
    return localArrayList;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new ArrayList();
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDAladdinConfigModule.class, new TKDAladdinConfigModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDDataReportModule.class, new TKDDataReportModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDToastModule.class, new TKDToastModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDNativeProxyModule.class, new TKDNativeProxyModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDDeviceModule.class, new TKDDeviceModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDWupModule.class, new TKDWupModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDSearchStatModule.class, new TKDSearchStatModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDAccountModule.class, new TKDAccountModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDAlertModule.class, new TKDAlertModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDDebugModule.class, new TKDDebugModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDSsoModule.class, new TKDSsoModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDWindowModule.class, new TKDWindowModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDCommentBizModule.class, new TKDCommentBizModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDBiuModule.class, new TKDBiuModule(paramHippyEngineContext)));
    paramHippyEngineContext = ((List)localObject).iterator();
    while (paramHippyEngineContext.hasNext())
    {
      localObject = (TKDApiProvider.NativeModule)paramHippyEngineContext.next();
      localHashMap.put(((TKDApiProvider.NativeModule)localObject).getModuleClass(), new TKDApiProvider.1(this, (TKDApiProvider.NativeModule)localObject));
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.provider.TKDApiProvider
 * JD-Core Version:    0.7.0.1
 */