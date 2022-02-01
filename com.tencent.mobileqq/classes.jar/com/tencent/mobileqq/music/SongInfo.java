package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SongInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SongInfo> CREATOR = new SongInfo.1();
  public long a;
  public String b;
  public long c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public long k;
  public int l;
  public int m;
  public boolean n;
  public BroadcastMusicInfo o;
  public long p;
  
  public SongInfo() {}
  
  public SongInfo(long paramLong, String paramString1, String paramString2)
  {
    this.a = paramLong;
    this.i = paramString1;
    this.d = paramString2;
    this.o = null;
  }
  
  private SongInfo(Parcel paramParcel)
  {
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.a = paramParcel.readLong();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.m = paramParcel.readInt();
    this.k = paramParcel.readLong();
    this.o = ((BroadcastMusicInfo)paramParcel.readParcelable(BroadcastMusicInfo.class.getClassLoader()));
    this.l = paramParcel.readInt();
    boolean bool;
    if (paramParcel.readFloat() != 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    this.n = bool;
    this.p = paramParcel.readLong();
    this.c = paramParcel.readLong();
    this.b = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.m);
    paramParcel.writeLong(this.k);
    paramParcel.writeParcelable(this.o, paramInt);
    paramParcel.writeInt(this.l);
    float f1;
    if (this.n) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    paramParcel.writeFloat(f1);
    paramParcel.writeLong(this.p);
    paramParcel.writeLong(this.c);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.SongInfo
 * JD-Core Version:    0.7.0.1
 */