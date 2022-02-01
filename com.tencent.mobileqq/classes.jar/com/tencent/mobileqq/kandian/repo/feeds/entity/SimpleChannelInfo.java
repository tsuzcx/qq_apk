package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SimpleChannelInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleChannelInfo> CREATOR = new SimpleChannelInfo.1();
  public long a;
  public String a;
  public long b;
  
  public SimpleChannelInfo() {}
  
  protected SimpleChannelInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.b = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.SimpleChannelInfo
 * JD-Core Version:    0.7.0.1
 */