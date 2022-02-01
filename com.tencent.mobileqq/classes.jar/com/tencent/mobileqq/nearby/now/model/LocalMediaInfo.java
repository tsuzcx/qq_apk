package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LocalMediaInfo
  implements Parcelable, Comparable<LocalMediaInfo>
{
  public static final Parcelable.Creator<LocalMediaInfo> CREATOR = new LocalMediaInfo.1();
  public String a = "";
  public int b = 2;
  public long c;
  public String d;
  public long e;
  public long f;
  public long g;
  public int h;
  public long i;
  public int j;
  public int k;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public int o;
  public int p;
  public int q;
  public Integer r = Integer.valueOf(-1);
  public String s;
  public String t = "";
  public String u = "";
  public String v = "";
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i1 = -1;
    if (paramLocalMediaInfo == null) {
      return -1;
    }
    long l1 = paramLocalMediaInfo.g;
    long l2 = this.g;
    if (l1 > l2) {
      return 1;
    }
    if (l1 == l2) {
      i1 = 0;
    }
    return i1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalMediaInfo{_id=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", addedDate=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", modifiedDate=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", orientation=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mDuration=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", selectStatus=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", rotation=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", thumbWidth=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", thumbHeight=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", index=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", mMimeType='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mediaWidth=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mediaHeight=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.l);
    paramParcel.writeLong(this.i);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.p);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.r.intValue());
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.t);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.n);
    paramParcel.writeInt(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */