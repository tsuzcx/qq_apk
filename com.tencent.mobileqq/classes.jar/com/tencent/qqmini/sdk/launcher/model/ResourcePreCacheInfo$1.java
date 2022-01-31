package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ResourcePreCacheInfo$1
  implements Parcelable.Creator<ResourcePreCacheInfo>
{
  public ResourcePreCacheInfo createFromParcel(Parcel paramParcel)
  {
    ResourcePreCacheInfo localResourcePreCacheInfo = new ResourcePreCacheInfo();
    localResourcePreCacheInfo.getDataUrl = paramParcel.readString();
    return localResourcePreCacheInfo;
  }
  
  public ResourcePreCacheInfo[] newArray(int paramInt)
  {
    return new ResourcePreCacheInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo.1
 * JD-Core Version:    0.7.0.1
 */