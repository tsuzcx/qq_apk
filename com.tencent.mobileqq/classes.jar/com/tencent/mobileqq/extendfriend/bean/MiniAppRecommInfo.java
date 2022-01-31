package com.tencent.mobileqq.extendfriend.bean;

import ajjy;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anpn;
import anpv;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MiniAppRecommInfo
  extends anpv
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<MiniAppRecommInfo> CREATOR = new anpn();
  public List<MiniAppRecommInfo.MiniApp> appInfoList = new ArrayList();
  public long cacheValidTime = System.currentTimeMillis() / 1000L + 3600L;
  public String headDesc = ajjy.a(2131641046);
  
  public MiniAppRecommInfo() {}
  
  public MiniAppRecommInfo(Parcel paramParcel)
  {
    this.headDesc = paramParcel.readString();
    this.appInfoList = paramParcel.createTypedArrayList(MiniAppRecommInfo.MiniApp.CREATOR);
    this.cacheValidTime = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.headDesc);
    paramParcel.writeTypedList(this.appInfoList);
    paramParcel.writeLong(this.cacheValidTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo
 * JD-Core Version:    0.7.0.1
 */