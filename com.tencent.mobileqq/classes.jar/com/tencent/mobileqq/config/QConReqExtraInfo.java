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
  public boolean a;
  
  public QConReqExtraInfo(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected QConReqExtraInfo(Parcel paramParcel)
  {
    boolean bool = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", reset:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConReqExtraInfo
 * JD-Core Version:    0.7.0.1
 */