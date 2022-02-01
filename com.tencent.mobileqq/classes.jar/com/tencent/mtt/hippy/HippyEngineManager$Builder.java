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
    HippyBundleLoader localHippyBundleLoader = this.mCoreBundleLoader;
    if ((localHippyBundleLoader instanceof HippyAssetBundleLoader)) {
      localEngineInitParams.coreJSAssetsPath = localHippyBundleLoader.getRawPath();
    } else if ((localHippyBundleLoader instanceof HippyFileBundleLoader)) {
      localEngineInitParams.coreJSFilePath = localHippyBundleLoader.getRawPath();
    } else {
      if (localHippyBundleLoader != null) {
        break label229;
      }
    }
    localEngineInitParams.providers = this.mPackages;
    localEngineInitParams.enableBuffer = this.mBridgeHippyBuffer;
    localHippyBundleLoader = this.mCoreBundleLoader;
    if (localHippyBundleLoader != null) {
      localEngineInitParams.codeCacheTag = localHippyBundleLoader.getCodeCacheTag();
    }
    localEngineInitParams.groupId = this.mGroupId;
    localEngineInitParams.check();
    if (this.mGroupId == -1) {
      return new HippyNormalEngineManager(localEngineInitParams, this.mPreloadBundleLoader);
    }
    return new HippySingleThreadEngineManager(localEngineInitParams, this.mPreloadBundleLoader);
    label229:
    throw new RuntimeException("Hippy: CoreBundleLoader is neither a HippyAssetBundleLoader nor a HippyFileBundleLoader!");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManager.Builder
 * JD-Core Version:    0.7.0.1
 */