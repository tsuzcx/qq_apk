package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class FavFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FavFileInfo> CREATOR = new FavFileInfo.1();
  public long a;
  public String b;
  public String c;
  public String d;
  public String e;
  public long f;
  public long g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public long o = -1L;
  public long p = -1L;
  public String q = "";
  public long r = -1L;
  public String s = "";
  public String t;
  public String u;
  public boolean v;
  long[] w = new long[5];
  
  public FavFileInfo() {}
  
  public FavFileInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readLong();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.t = paramParcel.readString();
    this.u = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.v = bool;
    this.o = paramParcel.readLong();
    this.p = paramParcel.readLong();
    this.q = paramParcel.readString();
    this.r = paramParcel.readLong();
    this.s = paramParcel.readString();
  }
  
  public long a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5)) {
      return this.w[paramInt];
    }
    return 0L;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.i)) {
      return this.i;
    }
    if (!TextUtils.isEmpty(this.n)) {
      this.i = this.n;
    } else if (!TextUtils.isEmpty(this.m)) {
      this.i = this.m;
    } else if (!TextUtils.isEmpty(this.l)) {
      this.i = this.l;
    } else if (!TextUtils.isEmpty(this.k)) {
      this.i = this.k;
    } else if (!TextUtils.isEmpty(this.j)) {
      this.i = this.j;
    }
    return this.i;
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= 5) {
        return;
      }
      this.w[paramInt] = paramLong;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeByte((byte)this.v);
    paramParcel.writeLong(this.o);
    paramParcel.writeLong(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeLong(this.r);
    paramParcel.writeString(this.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FavFileInfo
 * JD-Core Version:    0.7.0.1
 */