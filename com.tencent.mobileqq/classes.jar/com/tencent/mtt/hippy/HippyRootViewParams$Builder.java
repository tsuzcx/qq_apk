package com.tencent.mtt.hippy;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.Map;

public class HippyRootViewParams$Builder
{
  private Activity mActivity;
  private HippyBundleLoader mBundleLoader;
  private HippyInstanceContext mHippyInstanceContext;
  private HippyMap mLaunchParams;
  private String mName;
  private Map mNativeParams;
  
  public HippyRootViewParams build()
  {
    if (this.mActivity != null)
    {
      if (!TextUtils.isEmpty(this.mName))
      {
        if (this.mLaunchParams == null) {
          this.mLaunchParams = new HippyMap();
        }
        HippyBundleLoader localHippyBundleLoader = this.mBundleLoader;
        if (localHippyBundleLoader != null) {
          this.mLaunchParams.pushString("sourcePath", localHippyBundleLoader.getPath());
        }
        return new HippyRootViewParams(this.mName, this.mBundleLoader, this.mActivity, this.mLaunchParams, this.mNativeParams, this.mHippyInstanceContext, null);
      }
      throw new IllegalArgumentException("HippyInstance must set name!");
    }
    throw new IllegalArgumentException("HippyInstance must set activity!");
  }
  
  public Builder setActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    return this;
  }
  
  public Builder setBundleLoader(HippyBundleLoader paramHippyBundleLoader)
  {
    this.mBundleLoader = paramHippyBundleLoader;
    return this;
  }
  
  public Builder setInstanceContext(HippyInstanceContext paramHippyInstanceContext)
  {
    this.mHippyInstanceContext = paramHippyInstanceContext;
    return this;
  }
  
  public Builder setLaunchParams(HippyMap paramHippyMap)
  {
    this.mLaunchParams = paramHippyMap;
    return this;
  }
  
  public Builder setName(String paramString)
  {
    this.mName = paramString;
    return this;
  }
  
  public Builder setNativeParams(Map paramMap)
  {
    this.mNativeParams = paramMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyRootViewParams.Builder
 * JD-Core Version:    0.7.0.1
 */