package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class IPSiteModel$ComicRich$1
  implements Parcelable.Creator
{
  public IPSiteModel.ComicRich a(Parcel paramParcel)
  {
    IPSiteModel.ComicRich localComicRich = new IPSiteModel.ComicRich();
    localComicRich.extCover = paramParcel.readString();
    localComicRich.extName = paramParcel.readString();
    localComicRich.extTitle = paramParcel.readString();
    localComicRich.extUrl = paramParcel.readString();
    return localComicRich;
  }
  
  public IPSiteModel.ComicRich[] a(int paramInt)
  {
    return new IPSiteModel.ComicRich[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.ComicRich.1
 * JD-Core Version:    0.7.0.1
 */