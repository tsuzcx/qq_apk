package com.tencent.mobileqq.guild.mainframe.container.facade;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FacadeArgsData
  implements Parcelable
{
  public static final Parcelable.Creator<FacadeArgsData> CREATOR = new FacadeArgsData.1();
  public int a;
  public String b;
  public FacadeJoinInfo c;
  public Bundle d;
  
  public FacadeArgsData() {}
  
  protected FacadeArgsData(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = ((FacadeJoinInfo)paramParcel.readParcelable(FacadeJoinInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FacadeArgsData{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", guildId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", extra=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.FacadeArgsData
 * JD-Core Version:    0.7.0.1
 */