package com.tencent.mtt.hippy;

import android.content.Context;
import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule.InvokeDefaultBackPress;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Deprecated
public abstract class HippyEngineManager
  extends HippyEngine
{
  final HashMap mExtendDatas = new HashMap();
  
  public void addEngineEventListener(HippyEngine.EngineListener paramEngineListener)
  {
    if (paramEngineListener != null) {
      listen(paramEngineListener);
    }
  }
  
  public void destroyInstance(HippyRootView paramHippyRootView)
  {
    destroyModule(paramHippyRootView);
  }
  
  public abstract HippyEngineContext getCurrentEngineContext();
  
  public HippyEngine.EngineState getCurrentEngineState()
  {
    return this.mCurrentState;
  }
  
  public Object getExtendData(String paramString)
  {
    return this.mExtendDatas.get(paramString);
  }
  
  public void initEngineInBackground()
  {
    initEngine(null);
  }
  
  public abstract HippyRootView loadInstance(HippyRootViewParams paramHippyRootViewParams);
  
  public abstract HippyRootView loadInstance(HippyRootViewParams paramHippyRootViewParams, HippyEngine.ModuleListener paramModuleListener);
  
  public abstract HippyRootView loadInstance(HippyRootViewParams paramHippyRootViewParams, HippyEngine.ModuleListener paramModuleListener, HippyRootView.OnLoadCompleteListener paramOnLoadCompleteListener);
  
  public abstract boolean onBackPress(DeviceEventModule.InvokeDefaultBackPress paramInvokeDefaultBackPress);
  
  public abstract HippyInstanceContext preCreateInstanceContext(Context paramContext);
  
  public void putExtendData(String paramString, Object paramObject)
  {
    this.mExtendDatas.put(paramString, paramObject);
  }
  
  public void removeEngineEventListener(HippyEngine.EngineListener paramEngineListener)
  {
    this.mEventListeners.remove(paramEngineListener);
  }
  
  public void removeExtendData(String paramString)
  {
    this.mExtendDatas.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManager
 * JD-Core Version:    0.7.0.1
 */