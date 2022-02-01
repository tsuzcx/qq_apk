package com.tencent.mtt.hippy.adapter.thirdparty;

public abstract class HippyThirdPartyAdapter
{
  protected Object mExternalData;
  
  public HippyThirdPartyAdapter()
  {
    this.mExternalData = null;
  }
  
  public HippyThirdPartyAdapter(Object paramObject)
  {
    this.mExternalData = paramObject;
  }
  
  public abstract void SetHippyBridgeId(long paramLong);
  
  public abstract String getAppVersion();
  
  public abstract String getPackageName();
  
  public abstract String getPageUrl();
  
  public abstract void setPageUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
 * JD-Core Version:    0.7.0.1
 */