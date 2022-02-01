package com.tencent.mtt.hippy.bridge.bundleloader;

import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.bridge.NativeCallback;

public class HippyFileBundleLoader
  implements HippyBundleLoader
{
  private static final String FILE_STR = "file://";
  private boolean mCanUseCodeCache;
  private String mCodeCacheTag;
  String mFilePath;
  boolean mIsDebugMode = false;
  
  public HippyFileBundleLoader(String paramString)
  {
    this(paramString, false, "");
  }
  
  public HippyFileBundleLoader(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mFilePath = paramString1;
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
    Object localObject = this.mFilePath;
    if ((localObject != null) && (!((String)localObject).startsWith("file://")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file://");
      ((StringBuilder)localObject).append(this.mFilePath);
      return ((StringBuilder)localObject).toString();
    }
    return this.mFilePath;
  }
  
  public String getRawPath()
  {
    return this.mFilePath;
  }
  
  public boolean load(HippyBridge paramHippyBridge, NativeCallback paramNativeCallback)
  {
    if (TextUtils.isEmpty(this.mFilePath)) {
      return false;
    }
    Object localObject;
    if (!this.mFilePath.startsWith("file:"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file:");
      ((StringBuilder)localObject).append(this.mFilePath);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = this.mFilePath;
    }
    return paramHippyBridge.runScriptFromUri((String)localObject, null, this.mCanUseCodeCache, this.mCodeCacheTag, paramNativeCallback);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader
 * JD-Core Version:    0.7.0.1
 */