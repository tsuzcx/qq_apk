package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ReportInfo$1
  implements Parcelable.Creator<ReportInfo>
{
  public ReportInfo a(Parcel paramParcel)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.a = paramParcel.readInt();
    localReportInfo.c = paramParcel.readInt();
    localReportInfo.d = paramParcel.readInt();
    localReportInfo.i = paramParcel.readInt();
    localReportInfo.e = paramParcel.readInt();
    localReportInfo.g = paramParcel.readInt();
    localReportInfo.b = paramParcel.readLong();
    localReportInfo.f = paramParcel.readLong();
    localReportInfo.h = paramParcel.readLong();
    return localReportInfo;
  }
  
  public ReportInfo[] a(int paramInt)
  {
    return new ReportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.ReportInfo.1
 * JD-Core Version:    0.7.0.1
 */