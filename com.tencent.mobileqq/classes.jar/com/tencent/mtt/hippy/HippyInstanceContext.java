package com.tencent.mtt.hippy;

import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyAssetBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.supportui.utils.struct.WeakEventHub;
import java.util.Iterator;
import java.util.Map;

public final class HippyInstanceContext
  extends ContextWrapper
{
  private static final String TAG = "HippyInstanceContext";
  private HippyBundleLoader mBundleLoader;
  private WeakEventHub<HippyInstanceContext.InstanceDestroyListener> mDestroyListeners;
  private HippyEngineContext mEngineContext;
  HippyEngine mHippyEngineManager;
  HippyEngine.ModuleLoadParams mModuleParams;
  
  public HippyInstanceContext(Context paramContext)
  {
    super(paramContext);
    this.mDestroyListeners = new WeakEventHub();
  }
  
  public HippyInstanceContext(Context paramContext, HippyEngine.ModuleLoadParams paramModuleLoadParams)
  {
    super(paramContext);
    setModuleParams(paramModuleLoadParams);
    this.mDestroyListeners = new WeakEventHub();
  }
  
  public void attachEngineManager(HippyEngine paramHippyEngine)
  {
    this.mHippyEngineManager = paramHippyEngine;
  }
  
  public HippyBundleLoader getBundleLoader()
  {
    return this.mBundleLoader;
  }
  
  public HippyEngineContext getEngineContext()
  {
    return this.mEngineContext;
  }
  
  public HippyEngine getEngineManager()
  {
    return this.mHippyEngineManager;
  }
  
  public HippyEngine.ModuleLoadParams getModuleParams()
  {
    return this.mModuleParams;
  }
  
  public Map getNativeParams()
  {
    HippyEngine.ModuleLoadParams localModuleLoadParams = this.mModuleParams;
    if (localModuleLoadParams != null) {
      return localModuleLoadParams.nativeParams;
    }
    return null;
  }
  
  void notifyInstanceDestroy()
  {
    Object localObject = this.mModuleParams;
    if (localObject != null)
    {
      localObject = ((HippyEngine.ModuleLoadParams)localObject).nativeParams;
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    localObject = this.mDestroyListeners;
    if ((localObject != null) && (((WeakEventHub)localObject).size() > 0))
    {
      localObject = this.mDestroyListeners.getNotifyListeners().iterator();
      while (((Iterator)localObject).hasNext())
      {
        HippyInstanceContext.InstanceDestroyListener localInstanceDestroyListener = (HippyInstanceContext.InstanceDestroyListener)((Iterator)localObject).next();
        if (localInstanceDestroyListener != null) {
          try
          {
            localInstanceDestroyListener.onInstanceDestroy();
          }
          catch (Exception localException)
          {
            LogUtils.e("HippyInstanceContext", localException.getCause().toString());
          }
        }
      }
    }
    this.mDestroyListeners = null;
  }
  
  public void registerInstanceDestroyListener(HippyInstanceContext.InstanceDestroyListener paramInstanceDestroyListener)
  {
    if (paramInstanceDestroyListener != null)
    {
      WeakEventHub localWeakEventHub = this.mDestroyListeners;
      if (localWeakEventHub != null) {
        localWeakEventHub.registerListener(paramInstanceDestroyListener);
      }
    }
  }
  
  public void setEngineContext(HippyEngineContext paramHippyEngineContext)
  {
    this.mEngineContext = paramHippyEngineContext;
  }
  
  public void setModuleParams(HippyEngine.ModuleLoadParams paramModuleLoadParams)
  {
    this.mModuleParams = paramModuleLoadParams;
    HippyEngine.ModuleLoadParams localModuleLoadParams = this.mModuleParams;
    if ((localModuleLoadParams != null) && (localModuleLoadParams.bundleLoader != null))
    {
      this.mBundleLoader = this.mModuleParams.bundleLoader;
      return;
    }
    if (!TextUtils.isEmpty(paramModuleLoadParams.jsAssetsPath)) {}
    for (paramModuleLoadParams = new HippyAssetBundleLoader(paramModuleLoadParams.context, paramModuleLoadParams.jsAssetsPath, TextUtils.isEmpty(paramModuleLoadParams.codeCacheTag) ^ true, paramModuleLoadParams.codeCacheTag);; paramModuleLoadParams = new HippyFileBundleLoader(paramModuleLoadParams.jsFilePath, TextUtils.isEmpty(paramModuleLoadParams.codeCacheTag) ^ true, paramModuleLoadParams.codeCacheTag))
    {
      this.mBundleLoader = paramModuleLoadParams;
      return;
      if (TextUtils.isEmpty(paramModuleLoadParams.jsFilePath)) {
        break;
      }
    }
  }
  
  public void unregisterInstanceDestroyListener(HippyInstanceContext.InstanceDestroyListener paramInstanceDestroyListener)
  {
    if (paramInstanceDestroyListener != null)
    {
      WeakEventHub localWeakEventHub = this.mDestroyListeners;
      if (localWeakEventHub != null) {
        localWeakEventHub.unregisterListener(paramInstanceDestroyListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyInstanceContext
 * JD-Core Version:    0.7.0.1
 */