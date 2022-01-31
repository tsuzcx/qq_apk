package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bbks;
import java.util.Arrays;

public class JoinGroupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<JoinGroupInfo> CREATOR = new bbks();
  public int a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public JoinGroupInfo() {}
  
  public JoinGroupInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_ArrayOfByte = paramParcel.createByteArray();
    this.e = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "JoinGroupInfo{groupCode='" + this.jdField_a_of_type_JavaLangString + '\'' + ", reason='" + this.jdField_b_of_type_JavaLangString + '\'' + ", statOption='" + this.jdField_a_of_type_Int + '\'' + ", authKey='" + this.c + '\'' + ", authSig='" + this.d + '\'' + ", newMemberMsg=" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte) + ", picUrl='" + this.e + '\'' + ", verifyType=" + this.jdField_b_of_type_Int + ", verifyToken='" + this.f + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeByteArray(this.jdField_a_of_type_ArrayOfByte);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.JoinGroupInfo
 * JD-Core Version:    0.7.0.1
 */