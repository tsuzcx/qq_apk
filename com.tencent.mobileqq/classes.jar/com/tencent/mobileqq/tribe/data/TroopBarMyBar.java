package com.tencent.mobileqq.tribe.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TroopBarMyBar
  implements Parcelable
{
  public static final Parcelable.Creator<TroopBarMyBar> CREATOR = new TroopBarMyBar.1();
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String h;
  public int i;
  public int j;
  public String k;
  public String l;
  public int m;
  public String n;
  public int o;
  public String p;
  
  public TroopBarMyBar(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString1, int paramInt8, int paramInt9, String paramString2, String paramString3, int paramInt10, String paramString4, int paramInt11, String paramString5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.h = paramString1;
    this.i = paramInt8;
    this.j = paramInt9;
    this.k = paramString2;
    this.l = paramString3;
    this.m = paramInt10;
    this.n = paramString4;
    this.o = paramInt11;
    this.p = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopBarMyBar)) {
      return ((TroopBarMyBar)paramObject).l.equals(this.l);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    String str2 = this.h;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    str2 = this.k;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
    str2 = this.l;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
    paramParcel.writeInt(this.m);
    str2 = this.n;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
    paramParcel.writeInt(this.o);
    str2 = this.p;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.data.TroopBarMyBar
 * JD-Core Version:    0.7.0.1
 */