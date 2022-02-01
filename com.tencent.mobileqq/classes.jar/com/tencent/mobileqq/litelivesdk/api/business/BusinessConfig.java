package com.tencent.mobileqq.litelivesdk.api.business;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.ilive.LiveConfig.SDKType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BusinessConfig
  implements Parcelable
{
  public static final Parcelable.Creator<BusinessConfig> CREATOR = new BusinessConfig.1();
  public String a = "";
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public String g;
  public int h;
  public String i;
  public String j;
  public boolean k;
  public boolean l;
  public HashMap<String, String> m;
  public List<String> n;
  
  public BusinessConfig()
  {
    this.k = true;
    this.l = true;
    this.m = new HashMap();
    this.n = new ArrayList();
  }
  
  protected BusinessConfig(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.k = true;
    this.l = true;
    this.m = new HashMap();
    this.n = new ArrayList();
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    this.m = paramParcel.readHashMap(getClass().getClassLoader());
    if (this.m == null) {
      this.m = new HashMap();
    }
    paramParcel.readStringList(this.n);
    if (this.n == null) {
      this.n = new ArrayList();
    }
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.l = bool1;
  }
  
  public LiveConfig.SDKType a()
  {
    int i1 = this.h;
    if (i1 == 0) {
      return LiveConfig.SDKType.AUDIENCE;
    }
    if (i1 == 1) {
      return LiveConfig.SDKType.ANCHOR;
    }
    return LiveConfig.SDKType.FULL;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeByte((byte)this.k);
    paramParcel.writeMap(this.m);
    paramParcel.writeStringList(this.n);
    paramParcel.writeByte((byte)this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig
 * JD-Core Version:    0.7.0.1
 */