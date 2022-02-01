package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ReportInfo$1
  implements Parcelable.Creator<ReportInfo>
{
  public ReportInfo a(Parcel paramParcel)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localReportInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localReportInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localReportInfo.f = paramParcel.readInt();
    localReportInfo.d = paramParcel.readInt();
    localReportInfo.e = paramParcel.readInt();
    localReportInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localReportInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localReportInfo.jdField_c_of_type_Long = paramParcel.readLong();
    return localReportInfo;
  }
  
  public ReportInfo[] a(int paramInt)
  {
    return new ReportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.ReportInfo.1
 * JD-Core Version:    0.7.0.1
 */