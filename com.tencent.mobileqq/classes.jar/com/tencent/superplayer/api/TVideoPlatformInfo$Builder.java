package com.tencent.superplayer.api;

public class TVideoPlatformInfo$Builder
{
  private String mAppKey;
  private String mPkgName;
  private int mPlatform;
  private String mSdtfrom;
  
  public Builder appKey(String paramString)
  {
    this.mAppKey = paramString;
    return this;
  }
  
  public TVideoPlatformInfo build()
  {
    return new TVideoPlatformInfo(this);
  }
  
  public Builder pkgName(String paramString)
  {
    this.mPkgName = paramString;
    return this;
  }
  
  public Builder platform(int paramInt)
  {
    this.mPlatform = paramInt;
    return this;
  }
  
  public Builder sdtfrom(String paramString)
  {
    this.mSdtfrom = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.api.TVideoPlatformInfo.Builder
 * JD-Core Version:    0.7.0.1
 */