package com.tencent.mtt.hippy;

import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyAssetBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import java.util.ArrayList;
import java.util.List;

class HippyEngineManager$Builder
{
  private boolean mBridgeHippyBuffer = false;
  private HippyBundleLoader mCoreBundleLoader;
  private String mDebugJs;
  private HippyEngine.EngineMode mEngineMode;
  private HippyGlobalConfigs mGlobalConfigs;
  private int mGroupId = -1;
  private List<HippyAPIProvider> mPackages;
  private HippyBundleLoader mPreloadBundleLoader;
  private boolean mSupportDev = false;
  
  HippyEngineManager build()
  {
    if ((this.mCoreBundleLoader == null) && (!this.mSupportDev)) {
      throw new RuntimeException("In non-debug mode, it must be set core bundle loader!");
    }
    if ((this.mSupportDev) && (TextUtils.isEmpty(this.mDebugJs))) {
      throw new RuntimeException("In debug mode, it must be set debug js!");
    }
    if (this.mPackages == null) {
      this.mPackages = new ArrayList();
    }
    HippyEngine.EngineInitParams localEngineInitParams = new HippyEngine.EngineInitParams();
    this.mGlobalConfigs.to(localEngineInitParams);
    localEngineInitParams.debugMode = this.mSupportDev;
    localEngineInitParams.engineMode = this.mEngineMode;
    if ((this.mCoreBundleLoader instanceof HippyAssetBundleLoader)) {
      localEngineInitParams.coreJSAssetsPath = this.mCoreBundleLoader.getRawPath();
    }
    label232:
    do
    {
      for (;;)
      {
        localEngineInitParams.providers = this.mPackages;
        localEngineInitParams.enableBuffer = this.mBridgeHippyBuffer;
        if (this.mCoreBundleLoader != null) {
          localEngineInitParams.codeCacheTag = this.mCoreBundleLoader.getCodeCacheTag();
        }
        localEngineInitParams.groupId = this.mGroupId;
        localEngineInitParams.check();
        switch (HippyEngineManager.1.$SwitchMap$com$tencent$mtt$hippy$HippyEngine$EngineMode[this.mEngineMode.ordinal()])
        {
        default: 
          return null;
          if (!(this.mCoreBundleLoader instanceof HippyFileBundleLoader)) {
            break label232;
          }
          localEngineInitParams.coreJSFilePath = this.mCoreBundleLoader.getRawPath();
        }
      }
    } while (this.mCoreBundleLoader == null);
    throw new RuntimeException("Hippy: CoreBundleLoader is neither a HippyAssetBundleLoader nor a HippyFileBundleLoader!");
    return new HippyNormalEngineManager(localEngineInitParams, this.mPreloadBundleLoader);
    return new HippySingleThreadEngineManager(localEngineInitParams, this.mPreloadBundleLoader);
  }
  
  Builder setCoreBundleLoader(HippyBundleLoader paramHippyBundleLoader)
  {
    this.mCoreBundleLoader = paramHippyBundleLoader;
    return this;
  }
  
  Builder setDebugJs(String paramString)
  {
    this.mDebugJs = paramString;
    return this;
  }
  
  Builder setEnableHippyBuffer(boolean paramBoolean)
  {
    this.mBridgeHippyBuffer = paramBoolean;
    return this;
  }
  
  Builder setEngineMode(HippyEngine.EngineMode paramEngineMode)
  {
    this.mEngineMode = paramEngineMode;
    return this;
  }
  
  public void setGroupId(int paramInt)
  {
    this.mGroupId = paramInt;
  }
  
  Builder setHippyGlobalConfigs(HippyGlobalConfigs paramHippyGlobalConfigs)
  {
    this.mGlobalConfigs = paramHippyGlobalConfigs;
    return this;
  }
  
  Builder setPackages(List<HippyAPIProvider> paramList)
  {
    this.mPackages = paramList;
    return this;
  }
  
  Builder setPreloadBundleLoader(HippyBundleLoader paramHippyBundleLoader)
  {
    this.mPreloadBundleLoader = paramHippyBundleLoader;
    return this;
  }
  
  Builder setSupportDev(boolean paramBoolean)
  {
    this.mSupportDev = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManager.Builder
 * JD-Core Version:    0.7.0.1
 */