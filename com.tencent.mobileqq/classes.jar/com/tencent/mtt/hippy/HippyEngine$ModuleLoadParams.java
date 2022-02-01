package com.tencent.mtt.hippy;

import android.content.Context;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.Map;

public class HippyEngine$ModuleLoadParams
{
  @Deprecated
  public HippyBundleLoader bundleLoader;
  public String codeCacheTag = "";
  public String componentName;
  public Context context;
  public HippyInstanceContext hippyContext;
  public String jsAssetsPath;
  public String jsFilePath;
  public HippyMap jsParams;
  public Map nativeParams;
  
  public HippyEngine$ModuleLoadParams() {}
  
  public HippyEngine$ModuleLoadParams(ModuleLoadParams paramModuleLoadParams)
  {
    this.context = paramModuleLoadParams.context;
    this.jsAssetsPath = paramModuleLoadParams.jsAssetsPath;
    this.jsFilePath = paramModuleLoadParams.jsFilePath;
    this.componentName = paramModuleLoadParams.componentName;
    this.jsParams = paramModuleLoadParams.jsParams;
    this.nativeParams = paramModuleLoadParams.nativeParams;
    this.hippyContext = paramModuleLoadParams.hippyContext;
    this.codeCacheTag = paramModuleLoadParams.codeCacheTag;
    this.bundleLoader = paramModuleLoadParams.bundleLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams
 * JD-Core Version:    0.7.0.1
 */