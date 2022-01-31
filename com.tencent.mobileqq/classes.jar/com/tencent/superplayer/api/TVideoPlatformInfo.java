package com.tencent.superplayer.api;

import com.tencent.qqlive.tvkplayer.vinfo.TVKPlatformInfo;

public class TVideoPlatformInfo
{
  private String mAppKey;
  private String mPkgName;
  private int mPlatform;
  private String mSdtfrom;
  
  public TVideoPlatformInfo(TVideoPlatformInfo.Builder paramBuilder)
  {
    this.mPlatform = TVideoPlatformInfo.Builder.access$000(paramBuilder);
    this.mSdtfrom = TVideoPlatformInfo.Builder.access$100(paramBuilder);
    this.mAppKey = TVideoPlatformInfo.Builder.access$200(paramBuilder);
    this.mPkgName = TVideoPlatformInfo.Builder.access$300(paramBuilder);
  }
  
  public static TVKPlatformInfo convert(TVideoPlatformInfo paramTVideoPlatformInfo)
  {
    if (paramTVideoPlatformInfo == null) {
      return null;
    }
    TVKPlatformInfo localTVKPlatformInfo = new TVKPlatformInfo();
    localTVKPlatformInfo.setPlatform(paramTVideoPlatformInfo.mPlatform);
    localTVKPlatformInfo.setSdtfrom(paramTVideoPlatformInfo.mSdtfrom);
    localTVKPlatformInfo.setAppKey(paramTVideoPlatformInfo.mAppKey);
    localTVKPlatformInfo.setPackageName(paramTVideoPlatformInfo.mPkgName);
    return localTVKPlatformInfo;
  }
  
  public String getAppKey()
  {
    return this.mAppKey;
  }
  
  public String getPackageName()
  {
    return this.mPkgName;
  }
  
  public int getPlatform()
  {
    return this.mPlatform;
  }
  
  public String getSdtFrom()
  {
    return this.mSdtfrom;
  }
  
  public void setAppKey(String paramString)
  {
    this.mAppKey = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.mPkgName = paramString;
  }
  
  public void setPlatform(int paramInt)
  {
    this.mPlatform = paramInt;
  }
  
  public void setSdtfrom(String paramString)
  {
    this.mSdtfrom = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.api.TVideoPlatformInfo
 * JD-Core Version:    0.7.0.1
 */