package com.tencent.mobileqq.litelivesdk.api.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BizLoginRequest
  implements Parcelable
{
  public static final Parcelable.Creator<BizLoginRequest> CREATOR = new BizLoginRequest.1();
  public String a;
  public int b;
  public String c;
  public String d = "";
  public String e = "";
  public byte[] f;
  public String g;
  public String h;
  public String i;
  
  public BizLoginRequest() {}
  
  protected BizLoginRequest(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.createByteArray();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeByteArray(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest
 * JD-Core Version:    0.7.0.1
 */