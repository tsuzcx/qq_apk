package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bcxw;

public class HeadRequest
  implements Parcelable
{
  public static final Parcelable.Creator<HeadRequest> CREATOR = new bcxw();
  public int a;
  public QQHeadInfo a;
  public String a;
  public int b;
  
  public void a(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.jdField_a_of_type_AvatarInfoQQHeadInfo = ((QQHeadInfo)paramParcel.readParcelable(getClass().getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeParcelable(this.jdField_a_of_type_AvatarInfoQQHeadInfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.HeadRequest
 * JD-Core Version:    0.7.0.1
 */