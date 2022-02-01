package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InviteToGroupInfo$UinInfo
  implements Parcelable
{
  public static final Parcelable.Creator<UinInfo> CREATOR = new InviteToGroupInfo.UinInfo.1();
  public String a;
  public String b;
  public String c;
  
  public InviteToGroupInfo$UinInfo() {}
  
  protected InviteToGroupInfo$UinInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UinInfo{uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", groupCode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", confCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.InviteToGroupInfo.UinInfo
 * JD-Core Version:    0.7.0.1
 */