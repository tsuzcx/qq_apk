package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class IPSiteModel$Gxzb$1
  implements Parcelable.Creator
{
  public IPSiteModel.Gxzb a(Parcel paramParcel)
  {
    IPSiteModel.Gxzb localGxzb = new IPSiteModel.Gxzb();
    localGxzb.appid = paramParcel.readInt();
    localGxzb.appName = paramParcel.readString();
    localGxzb.cover = paramParcel.readString();
    localGxzb.feeType = paramParcel.readInt();
    localGxzb.id = paramParcel.readString();
    localGxzb.name = paramParcel.readString();
    return localGxzb;
  }
  
  public IPSiteModel.Gxzb[] a(int paramInt)
  {
    return new IPSiteModel.Gxzb[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Gxzb.1
 * JD-Core Version:    0.7.0.1
 */