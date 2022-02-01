package com.tencent.mobileqq.litelivesdk.api.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BizLoginRequest
  implements Parcelable
{
  public static final Parcelable.Creator<BizLoginRequest> CREATOR = new BizLoginRequest.1();
  public int a;
  public String a;
  public byte[] a;
  public String b;
  public String c = "";
  public String d = "";
  public String e;
  public String f;
  public String g;
  
  public BizLoginRequest() {}
  
  protected BizLoginRequest(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_ArrayOfByte = paramParcel.createByteArray();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeByteArray(this.jdField_a_of_type_ArrayOfByte);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest
 * JD-Core Version:    0.7.0.1
 */