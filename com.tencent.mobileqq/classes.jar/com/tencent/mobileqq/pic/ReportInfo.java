package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ReportInfo> CREATOR = new ReportInfo.1();
  public int a = -1;
  public long b = -1L;
  public int c = -1;
  public int d = -1;
  public int e = -1;
  public long f = -1L;
  public int g = -1;
  public long h = -1L;
  public int i = -1;
  
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
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpMsgRecvTime:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpMsgNetwork:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpThumbNetwork:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpThumbDownMode:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpThumbTimeDiff:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpBigDownMode:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpBigTimeDiff:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rpBigNetwork:");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.g);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.f);
    paramParcel.writeLong(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.ReportInfo
 * JD-Core Version:    0.7.0.1
 */