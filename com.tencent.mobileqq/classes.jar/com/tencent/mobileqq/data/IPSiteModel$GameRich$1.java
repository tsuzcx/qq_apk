package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class IPSiteModel$GameRich$1
  implements Parcelable.Creator
{
  public IPSiteModel.GameRich a(Parcel paramParcel)
  {
    IPSiteModel.GameRich localGameRich = new IPSiteModel.GameRich();
    localGameRich.anchorFaceUrl = paramParcel.readString();
    localGameRich.anchorId = paramParcel.readString();
    localGameRich.anchorName = paramParcel.readString();
    localGameRich.coverUrl = paramParcel.readString();
    localGameRich.online = paramParcel.readString();
    localGameRich.title = paramParcel.readString();
    localGameRich.richJumpUrl = paramParcel.readString();
    return localGameRich;
  }
  
  public IPSiteModel.GameRich[] a(int paramInt)
  {
    return new IPSiteModel.GameRich[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.GameRich.1
 * JD-Core Version:    0.7.0.1
 */