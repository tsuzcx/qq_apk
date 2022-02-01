package com.tencent.mobileqq.kandian.repo.diandian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ExtraInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ExtraInfo> CREATOR = new ExtraInfo.1();
  public String a;
  
  public ExtraInfo() {}
  
  public ExtraInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtraInfo ExtraInfo {reportStr : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.diandian.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */