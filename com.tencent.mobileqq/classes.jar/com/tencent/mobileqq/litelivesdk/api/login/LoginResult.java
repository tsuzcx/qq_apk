package com.tencent.mobileqq.litelivesdk.api.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LoginResult
  implements Parcelable
{
  public static final Parcelable.Creator<LoginResult> CREATOR = new LoginResult.1();
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public LoginResult()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public LoginResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.api.login.LoginResult
 * JD-Core Version:    0.7.0.1
 */