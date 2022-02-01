package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MedalItem
  implements Parcelable
{
  public static final Parcelable.Creator<MedalItem> CREATOR = new MedalItem.1();
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  public int f;
  public long g;
  public long h;
  public int i;
  public String j;
  public String k;
  public int l;
  public int m;
  public int n;
  
  public MedalItem() {}
  
  protected MedalItem(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readLong();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readInt();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 != null)) {
      return false;
    }
    if ((paramString1 != null) && (paramString2 == null)) {
      return false;
    }
    return (paramString1 == null) || (paramString1.equals(paramString2));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MedalItem)) {
      return false;
    }
    paramObject = (MedalItem)paramObject;
    if (paramObject.a != this.a) {
      return false;
    }
    return a(paramObject.c, this.c);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.MedalItem
 * JD-Core Version:    0.7.0.1
 */