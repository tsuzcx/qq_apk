package com.tencent.mobileqq.litelivesdk.api.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LoginResult
  implements Parcelable
{
  public static final Parcelable.Creator<LoginResult> CREATOR = new LoginResult.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public long e = 0L;
  public String f;
  public String g;
  public long h = 0L;
  public int i;
  
  public LoginResult() {}
  
  public LoginResult(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.i = paramParcel.readInt();
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
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.api.login.LoginResult
 * JD-Core Version:    0.7.0.1
 */