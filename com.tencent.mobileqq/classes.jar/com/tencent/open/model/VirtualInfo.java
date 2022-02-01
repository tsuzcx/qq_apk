package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VirtualInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VirtualInfo> CREATOR = new VirtualInfo.1();
  public long a;
  public String a;
  public String b;
  
  public VirtualInfo() {}
  
  protected VirtualInfo(Parcel paramParcel)
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
    localStringBuilder.append("virtualId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",");
    localStringBuilder.append("nickName=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append("avatarUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.VirtualInfo
 * JD-Core Version:    0.7.0.1
 */