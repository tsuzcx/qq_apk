package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResourcePreCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ResourcePreCacheInfo> CREATOR = new ResourcePreCacheInfo.1();
  public String getDataUrl;
  
  public ResourcePreCacheInfo() {}
  
  public ResourcePreCacheInfo(String paramString)
  {
    this.getDataUrl = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "getDataUrl:" + this.getDataUrl;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.getDataUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo
 * JD-Core Version:    0.7.0.1
 */