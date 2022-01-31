package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bfra;

public class VirtualInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VirtualInfo> CREATOR = new bfra();
  public long a;
  public String a;
  public String b;
  
  public VirtualInfo() {}
  
  public VirtualInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("VirtualInfo={");
    localStringBuilder.append("virtualId=").append(this.jdField_a_of_type_Long).append(",");
    localStringBuilder.append("nickName=").append(this.jdField_a_of_type_JavaLangString).append(",");
    localStringBuilder.append("avatarUrl=").append(this.b).append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.model.VirtualInfo
 * JD-Core Version:    0.7.0.1
 */