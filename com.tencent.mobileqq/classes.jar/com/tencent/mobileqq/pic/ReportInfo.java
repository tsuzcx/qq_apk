package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ReportInfo> CREATOR = new ReportInfo.1();
  public int a;
  public long a;
  public int b;
  public long b;
  public int c;
  public long c;
  public int d = -1;
  public int e = -1;
  public int f = -1;
  
  public ReportInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = -1L;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nReportInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpStep:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpMsgRecvTime:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpMsgNetwork:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpThumbNetwork:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpThumbDownMode:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpThumbTimeDiff:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpBigDownMode:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpBigTimeDiff:");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpBigNetwork:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.ReportInfo
 * JD-Core Version:    0.7.0.1
 */