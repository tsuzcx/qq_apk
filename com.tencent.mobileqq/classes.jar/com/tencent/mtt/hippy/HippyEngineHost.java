package com.tencent.mtt.hippy;

import android.app.Application;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.utils.ContextHolder;
import java.util.List;

@Deprecated
public abstract class HippyEngineHost
{
  private final Application mApplication;
  
  public HippyEngineHost(Application paramApplication)
  {
    this.mApplication = paramApplication;
    ContextHolder.initAppContext(this.mApplication);
  }
  
  public HippyEngineManager createDebugHippyEngineManager(String paramString)
  {
    HippyEngineManager.Builder localBuilder = new HippyEngineManager.Builder();
    localBuilder.setHippyGlobalConfigs(getHippyGlobalConfigs()).setCoreBundleLoader(null).setPackages(getPackages()).setSupportDev(true).setDebugJs(paramString).setGroupId(getGroupId());
    return localBuilder.build();
  }
  
  protected boolean enableHippyBufferBridge()
  {
    return false;
  }
  
  protected HippyBundleLoader getCoreBundleLoader()
  {
    return null;
  }
  
  protected int getGroupId()
  {
    return -1;
  }
  
  public HippyGlobalConfigs getHippyGlobalConfigs()
  {
    return new HippyGlobalConfigs.Builder().setContext(this.mApplication).build();
  }
  
  protected abstract List<HippyAPIProvider> getPackages();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineHost
 * JD-Core Version:    0.7.0.1
 */