package com.tencent.mobileqq.soso.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class SosoWifi
  implements Parcelable
{
  public static final Parcelable.Creator<SosoWifi> CREATOR = new SosoWifi.1();
  public long mMac;
  public String mMacStr;
  public int mRssi;
  
  protected SosoWifi(Parcel paramParcel)
  {
    this.mRssi = paramParcel.readInt();
    this.mMac = paramParcel.readLong();
    this.mMacStr = paramParcel.readString();
  }
  
  public SosoWifi(String paramString, int paramInt)
  {
    this.mRssi = paramInt;
    this.mMacStr = paramString;
    this.mMac = macToLong(paramString);
  }
  
  public static long macToLong(String paramString)
  {
    long l1 = 0L;
    try
    {
      paramString = paramString.split(":");
      if (paramString.length == 6)
      {
        int i = 0;
        l1 = 0L;
        int j = 40;
        while (i < paramString.length)
        {
          long l3 = Long.parseLong(paramString[i], 16);
          long l2 = l3;
          if (j > 0) {
            l2 = l3 << j;
          }
          l1 += l2;
          j -= 8;
          i += 1;
        }
      }
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mRssi);
    paramParcel.writeLong(this.mMac);
    paramParcel.writeString(this.mMacStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.data.SosoWifi
 * JD-Core Version:    0.7.0.1
 */