package com.tencent.mobileqq.guild.profilecard.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GuildHeaderData
  implements Parcelable
{
  public static final Parcelable.Creator<GuildHeaderData> CREATOR = new GuildHeaderData.1();
  private String a;
  private String b;
  private int c;
  private byte d;
  private String e;
  private long f;
  private int g;
  
  public GuildHeaderData() {}
  
  protected GuildHeaderData(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readByte();
    this.e = paramParcel.readString();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readInt();
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(byte paramByte)
  {
    this.d = paramByte;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public byte d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public long f()
  {
    return this.f;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeByte(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeInt(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.main.GuildHeaderData
 * JD-Core Version:    0.7.0.1
 */