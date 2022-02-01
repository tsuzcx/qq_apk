package com.tencent.mtt.hippy.bridge.bundleloader;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.bridge.NativeCallback;

public class HippyAssetBundleLoader
  implements HippyBundleLoader
{
  private static final String ASSETS_STR = "assets://";
  private String mAssetPath;
  private boolean mCanUseCodeCache;
  private String mCodeCacheTag;
  private Context mContext;
  
  public HippyAssetBundleLoader(Context paramContext, String paramString)
  {
    this(paramContext, paramString, false, "");
  }
  
  public HippyAssetBundleLoader(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mContext = paramContext;
    this.mAssetPath = paramString1;
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
    Object localObject = this.mAssetPath;
    if ((localObject != null) && (!((String)localObject).startsWith("assets://")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("assets://");
      ((StringBuilder)localObject).append(this.mAssetPath);
      return ((StringBuilder)localObject).toString();
    }
    return this.mAssetPath;
  }
  
  public String getRawPath()
  {
    return this.mAssetPath;
  }
  
  public boolean load(HippyBridge paramHippyBridge, NativeCallback paramNativeCallback)
  {
    if (TextUtils.isEmpty(this.mAssetPath)) {
      return false;
    }
    AssetManager localAssetManager = this.mContext.getAssets();
    String str2 = this.mAssetPath;
    String str1 = "asset:";
    Object localObject = str2;
    if (!str2.startsWith("asset:"))
    {
      if (this.mAssetPath.startsWith("/"))
      {
        localObject = new StringBuilder();
      }
      else
      {
        localObject = new StringBuilder();
        str1 = "asset:/";
      }
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(this.mAssetPath);
      localObject = ((StringBuilder)localObject).toString();
    }
    return paramHippyBridge.runScriptFromUri((String)localObject, localAssetManager, this.mCanUseCodeCache, this.mCodeCacheTag, paramNativeCallback);
  }
  
  public void setCodeCache(boolean paramBoolean, String paramString)
  {
    this.mCanUseCodeCache = paramBoolean;
    this.mCodeCacheTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.bundleloader.HippyAssetBundleLoader
 * JD-Core Version:    0.7.0.1
 */