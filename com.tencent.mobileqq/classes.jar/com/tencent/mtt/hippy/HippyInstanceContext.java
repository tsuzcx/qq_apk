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
    if (this.mModuleParams != null) {
      return this.mModuleParams.nativeParams;
    }
    return null;
  }
  
  void notifyInstanceDestroy()
  {
    Object localObject;
    if (this.mModuleParams != null)
    {
      localObject = this.mModuleParams.nativeParams;
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    if ((this.mDestroyListeners != null) && (this.mDestroyListeners.size() > 0))
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
    if ((paramInstanceDestroyListener != null) && (this.mDestroyListeners != null)) {
      this.mDestroyListeners.registerListener(paramInstanceDestroyListener);
    }
  }
  
  public void setEngineContext(HippyEngineContext paramHippyEngineContext)
  {
    this.mEngineContext = paramHippyEngineContext;
  }
  
  public void setModuleParams(HippyEngine.ModuleLoadParams paramModuleLoadParams)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    this.mModuleParams = paramModuleLoadParams;
    if ((this.mModuleParams != null) && (this.mModuleParams.bundleLoader != null)) {
      this.mBundleLoader = this.mModuleParams.bundleLoader;
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramModuleLoadParams.jsAssetsPath))
      {
        localObject = paramModuleLoadParams.context;
        String str = paramModuleLoadParams.jsAssetsPath;
        if (!TextUtils.isEmpty(paramModuleLoadParams.codeCacheTag)) {}
        for (;;)
        {
          this.mBundleLoader = new HippyAssetBundleLoader((Context)localObject, str, bool1, paramModuleLoadParams.codeCacheTag);
          return;
          bool1 = false;
        }
      }
    } while (TextUtils.isEmpty(paramModuleLoadParams.jsFilePath));
    Object localObject = paramModuleLoadParams.jsFilePath;
    if (!TextUtils.isEmpty(paramModuleLoadParams.codeCacheTag)) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.mBundleLoader = new HippyFileBundleLoader((String)localObject, bool1, paramModuleLoadParams.codeCacheTag);
      return;
    }
  }
  
  public void unregisterInstanceDestroyListener(HippyInstanceContext.InstanceDestroyListener paramInstanceDestroyListener)
  {
    if ((paramInstanceDestroyListener != null) && (this.mDestroyListeners != null)) {
      this.mDestroyListeners.unregisterListener(paramInstanceDestroyListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyInstanceContext
 * JD-Core Version:    0.7.0.1
 */