package com.tencent.mobileqq.soso.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class SosoLbsInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SosoLbsInfo> CREATOR = new SosoLbsInfo.1();
  public SosoAttribute mAttr;
  public ArrayList<SosoCell> mCells = new ArrayList();
  public SosoLocation mLocation;
  public long mSource;
  public String mVersion;
  public ArrayList<SosoWifi> mWifis = new ArrayList();
  public String provider;
  public byte[] rawData;
  
  public SosoLbsInfo() {}
  
  protected SosoLbsInfo(Parcel paramParcel)
  {
    this.rawData = paramParcel.createByteArray();
    this.mVersion = paramParcel.readString();
    this.mSource = paramParcel.readLong();
    this.mAttr = ((SosoAttribute)paramParcel.readParcelable(SosoAttribute.class.getClassLoader()));
    this.mLocation = ((SosoLocation)paramParcel.readParcelable(SosoLocation.class.getClassLoader()));
    this.provider = paramParcel.readString();
    this.mCells = paramParcel.createTypedArrayList(SosoCell.CREATOR);
    this.mWifis = paramParcel.createTypedArrayList(SosoWifi.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.rawData);
    paramParcel.writeString(this.mVersion);
    paramParcel.writeLong(this.mSource);
    paramParcel.writeParcelable(this.mAttr, paramInt);
    paramParcel.writeParcelable(this.mLocation, paramInt);
    paramParcel.writeString(this.provider);
    paramParcel.writeTypedList(this.mCells);
    paramParcel.writeTypedList(this.mWifis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.data.SosoLbsInfo
 * JD-Core Version:    0.7.0.1
 */