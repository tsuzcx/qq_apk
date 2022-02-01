package com.tencent.mobileqq.filemanageraux.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeiYunFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeiYunFileInfo> CREATOR = new WeiYunFileInfo.1();
  public String a;
  public String b;
  public String c;
  public long d;
  public long e;
  public int f;
  public String g;
  public int h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public boolean o;
  
  public WeiYunFileInfo()
  {
    this.f = 0;
  }
  
  public WeiYunFileInfo(Parcel paramParcel)
  {
    boolean bool = false;
    this.f = 0;
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.o = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeByte((byte)this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo
 * JD-Core Version:    0.7.0.1
 */