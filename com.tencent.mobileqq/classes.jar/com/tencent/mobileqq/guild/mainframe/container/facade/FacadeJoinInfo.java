package com.tencent.mobileqq.guild.mainframe.container.facade;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FacadeJoinInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FacadeJoinInfo> CREATOR = new FacadeJoinInfo.1();
  public int a;
  public String b;
  public String c;
  public Bundle d;
  
  public FacadeJoinInfo() {}
  
  protected FacadeJoinInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.d = paramParcel.readBundle();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FacadeJoinInfo{from=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", joinSignture='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extras=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeBundle(this.d);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.FacadeJoinInfo
 * JD-Core Version:    0.7.0.1
 */