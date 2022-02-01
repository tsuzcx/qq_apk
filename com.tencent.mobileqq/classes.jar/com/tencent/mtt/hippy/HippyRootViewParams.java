package com.tencent.mtt.hippy;

import android.app.Activity;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.Map;

@Deprecated
public class HippyRootViewParams
{
  private final Activity mActivity;
  private final HippyBundleLoader mBundleLoader;
  private HippyInstanceContext mHippyInstanceContext;
  private final HippyMap mLaunchParams;
  private final String mName;
  private final Map mNativeParams;
  
  private HippyRootViewParams(String paramString, HippyBundleLoader paramHippyBundleLoader, Activity paramActivity, HippyMap paramHippyMap, Map paramMap, HippyInstanceContext paramHippyInstanceContext)
  {
    this.mName = paramString;
    this.mBundleLoader = paramHippyBundleLoader;
    this.mActivity = paramActivity;
    this.mLaunchParams = paramHippyMap;
    this.mNativeParams = paramMap;
    this.mHippyInstanceContext = paramHippyInstanceContext;
  }
  
  public void clearHippyInstanceContext()
  {
    this.mHippyInstanceContext = null;
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public HippyBundleLoader getBundleLoader()
  {
    return this.mBundleLoader;
  }
  
  HippyInstanceContext getInstanceContext()
  {
    return this.mHippyInstanceContext;
  }
  
  public HippyMap getLaunchParams()
  {
    return this.mLaunchParams;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public Map getNativeParams()
  {
    return this.mNativeParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyRootViewParams
 * JD-Core Version:    0.7.0.1
 */