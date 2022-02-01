package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjzd;

public class CreateVirtualResult
  implements Parcelable
{
  public static final Parcelable.Creator<CreateVirtualResult> CREATOR = new bjzd();
  public long a;
  public String a;
  
  public CreateVirtualResult() {}
  
  public CreateVirtualResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CreateVirtualResult={");
    localStringBuilder.append("virtualId=").append(this.jdField_a_of_type_Long).append(",");
    localStringBuilder.append("headUrl=").append(this.jdField_a_of_type_JavaLangString).append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.CreateVirtualResult
 * JD-Core Version:    0.7.0.1
 */