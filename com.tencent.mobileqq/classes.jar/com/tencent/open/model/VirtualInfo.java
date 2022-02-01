package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VirtualInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VirtualInfo> CREATOR = new VirtualInfo.1();
  public long a;
  public String b;
  public String c;
  
  public VirtualInfo() {}
  
  protected VirtualInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("VirtualInfo={");
    localStringBuilder.append("virtualId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append("nickName=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append("avatarUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.model.VirtualInfo
 * JD-Core Version:    0.7.0.1
 */