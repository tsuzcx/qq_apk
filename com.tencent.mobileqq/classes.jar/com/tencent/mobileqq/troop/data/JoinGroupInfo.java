package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class JoinGroupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<JoinGroupInfo> CREATOR = new JoinGroupInfo.1();
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
  
  protected JoinGroupInfo(Parcel paramParcel)
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JoinGroupInfo{groupCode='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reason='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", statOption='");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authKey='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authSig='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", newMemberMsg=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(", picUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", verifyType=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", verifyToken='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.JoinGroupInfo
 * JD-Core Version:    0.7.0.1
 */