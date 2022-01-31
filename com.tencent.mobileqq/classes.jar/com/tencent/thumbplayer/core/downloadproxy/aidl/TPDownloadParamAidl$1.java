package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TPDownloadParamAidl$1
  implements Parcelable.Creator<TPDownloadParamAidl>
{
  public TPDownloadParamAidl createFromParcel(Parcel paramParcel)
  {
    return new TPDownloadParamAidl(paramParcel);
  }
  
  public TPDownloadParamAidl[] newArray(int paramInt)
  {
    return new TPDownloadParamAidl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl.1
 * JD-Core Version:    0.7.0.1
 */