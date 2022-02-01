package com.tencent.mtt.hippy.bridge.bundleloader;

import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.bridge.NativeCallback;
import com.tencent.mtt.hippy.utils.LogUtils;

public class HippyRemoteBundleLoader
  implements HippyBundleLoader
{
  private boolean mCanUseCodeCache;
  private String mCodeCacheTag;
  boolean mIsDebugMode = false;
  final String mUrl;
  
  public HippyRemoteBundleLoader(String paramString)
  {
    this(paramString, false, "");
  }
  
  public HippyRemoteBundleLoader(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mUrl = paramString1;
    this.mCanUseCodeCache = paramBoolean;
    this.mCodeCacheTag = paramString2;
  }
  
  public boolean canUseCodeCache()
  {
    return this.mCanUseCodeCache;
  }
  
  public String getBundleUniKey()
  {
    return getPath();
  }
  
  public String getCodeCacheTag()
  {
    return this.mCodeCacheTag;
  }
  
  public String getPath()
  {
    return this.mUrl;
  }
  
  public String getRawPath()
  {
    return this.mUrl;
  }
  
  public void load(HippyBridge paramHippyBridge, NativeCallback paramNativeCallback)
  {
    if (TextUtils.isEmpty(this.mUrl)) {
      return;
    }
    boolean bool = paramHippyBridge.runScriptFromUri(this.mUrl, null, this.mCanUseCodeCache, this.mCodeCacheTag, paramNativeCallback);
    paramHippyBridge = new StringBuilder();
    paramHippyBridge.append("load: ret");
    paramHippyBridge.append(bool);
    LogUtils.d("HippyRemoteBundleLoader", paramHippyBridge.toString());
  }
  
  public void setCodeCache(boolean paramBoolean, String paramString)
  {
    this.mCanUseCodeCache = paramBoolean;
    this.mCodeCacheTag = paramString;
  }
  
  public void setIsDebugMode(boolean paramBoolean)
  {
    this.mIsDebugMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.bundleloader.HippyRemoteBundleLoader
 * JD-Core Version:    0.7.0.1
 */