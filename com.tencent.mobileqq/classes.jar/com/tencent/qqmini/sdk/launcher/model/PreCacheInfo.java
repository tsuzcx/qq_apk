package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PreCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PreCacheInfo> CREATOR = new PreCacheInfo.1();
  public int cacheType;
  public long expireTime;
  public String getDataUrl;
  public String preCacheKey;
  public int useProxy;
  
  public PreCacheInfo() {}
  
  public PreCacheInfo(String paramString1, String paramString2, long paramLong)
  {
    this.getDataUrl = paramString1;
    this.preCacheKey = paramString2;
    this.expireTime = paramLong;
  }
  
  public PreCacheInfo(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
  {
    this.getDataUrl = paramString1;
    this.preCacheKey = paramString2;
    this.expireTime = paramLong;
    this.cacheType = paramInt1;
    this.useProxy = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDataUrl:");
    localStringBuilder.append(this.getDataUrl);
    localStringBuilder.append("  preCacheKey:");
    localStringBuilder.append(this.preCacheKey);
    localStringBuilder.append("  expireTime:");
    localStringBuilder.append(this.expireTime);
    localStringBuilder.append("  cacheType:");
    localStringBuilder.append(this.cacheType);
    localStringBuilder.append("  useProxy:");
    localStringBuilder.append(this.useProxy);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.getDataUrl);
    paramParcel.writeString(this.preCacheKey);
    paramParcel.writeLong(this.expireTime);
    paramParcel.writeInt(this.cacheType);
    paramParcel.writeInt(this.useProxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.PreCacheInfo
 * JD-Core Version:    0.7.0.1
 */