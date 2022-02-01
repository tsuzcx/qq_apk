package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HeadRequest
  implements Parcelable
{
  public static final Parcelable.Creator<HeadRequest> CREATOR = new HeadRequest.1();
  public String a;
  public int b;
  public int c;
  public QQHeadInfo d;
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = ((QQHeadInfo)paramParcel.readParcelable(getClass().getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeParcelable(this.d, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.HeadRequest
 * JD-Core Version:    0.7.0.1
 */