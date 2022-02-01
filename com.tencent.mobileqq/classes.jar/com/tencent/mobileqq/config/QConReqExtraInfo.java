package com.tencent.mobileqq.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

public class QConReqExtraInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QConReqExtraInfo> CREATOR = new QConReqExtraInfo.1();
  public int a;
  public boolean b;
  
  public QConReqExtraInfo(int paramInt, boolean paramBoolean)
  {
    this.a = 0;
    this.b = false;
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  protected QConReqExtraInfo(Parcel paramParcel)
  {
    boolean bool = false;
    this.a = 0;
    this.b = false;
    this.a = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.b = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", reset:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeByte((byte)this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConReqExtraInfo
 * JD-Core Version:    0.7.0.1
 */