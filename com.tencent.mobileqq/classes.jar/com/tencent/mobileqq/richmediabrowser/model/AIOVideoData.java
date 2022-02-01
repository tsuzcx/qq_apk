package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public class AIOVideoData
  extends AIOBrowserBaseData
{
  public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new AIOVideoData.1();
  public String A;
  public int B;
  public int C;
  public String j = "I:N";
  public String k = "I:N";
  public int l;
  public int m;
  public boolean n;
  public boolean o;
  public int p;
  public int q;
  public long r;
  public String s = "";
  public int t;
  public String u = null;
  public boolean v = false;
  public boolean w = false;
  public long x;
  public boolean y;
  public String z;
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getType()
  {
    return 101;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.r = paramParcel.readLong();
    this.s = paramParcel.readString();
    this.t = paramParcel.readInt();
    this.z = paramParcel.readString();
    this.A = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.p);
    paramParcel.writeInt(this.q);
    paramParcel.writeLong(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeString(this.z);
    paramParcel.writeString(this.A);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOVideoData
 * JD-Core Version:    0.7.0.1
 */