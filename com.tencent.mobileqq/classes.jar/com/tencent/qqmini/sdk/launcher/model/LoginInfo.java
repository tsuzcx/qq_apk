package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import beru;

public class LoginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LoginInfo> CREATOR = new beru();
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public LoginInfo() {}
  
  public LoginInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, String paramString6)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    if (paramArrayOfByte != null)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    this.c = paramString3;
    this.f = paramString6;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeByteArray(this.jdField_a_of_type_ArrayOfByte);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.LoginInfo
 * JD-Core Version:    0.7.0.1
 */