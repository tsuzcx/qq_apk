package com.tencent.mobileqq.guild.channel.create;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CreateSubChannelInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CreateSubChannelInfo> CREATOR = new CreateSubChannelInfo.1();
  public final String a;
  public final long b;
  public final String c;
  public int d;
  public Bundle e;
  
  protected CreateSubChannelInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readBundle();
  }
  
  public CreateSubChannelInfo(String paramString1, long paramLong, String paramString2)
  {
    this.a = paramString1;
    this.b = paramLong;
    this.c = paramString2;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    this.e = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeBundle(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo
 * JD-Core Version:    0.7.0.1
 */