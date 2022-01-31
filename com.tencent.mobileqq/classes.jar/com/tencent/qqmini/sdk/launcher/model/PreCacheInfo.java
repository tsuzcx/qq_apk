package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PreCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PreCacheInfo> CREATOR = new PreCacheInfo.1();
  public long expireTime;
  public String getDataUrl;
  public String preCacheKey;
  
  public PreCacheInfo() {}
  
  public PreCacheInfo(String paramString1, String paramString2, long paramLong)
  {
    this.getDataUrl = paramString1;
    this.preCacheKey = paramString2;
    this.expireTime = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "getDataUrl:" + this.getDataUrl + "  preCacheKey:" + this.preCacheKey + "  expireTime:" + this.expireTime;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.getDataUrl);
    paramParcel.writeString(this.preCacheKey);
    paramParcel.writeLong(this.expireTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.PreCacheInfo
 * JD-Core Version:    0.7.0.1
 */