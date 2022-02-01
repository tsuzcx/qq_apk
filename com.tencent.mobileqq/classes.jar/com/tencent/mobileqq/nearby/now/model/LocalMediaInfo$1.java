package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LocalMediaInfo$1
  implements Parcelable.Creator<LocalMediaInfo>
{
  public LocalMediaInfo a(Parcel paramParcel)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localLocalMediaInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localLocalMediaInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localLocalMediaInfo.jdField_c_of_type_Long = paramParcel.readLong();
    localLocalMediaInfo.jdField_d_of_type_Long = paramParcel.readLong();
    localLocalMediaInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localLocalMediaInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localLocalMediaInfo.jdField_e_of_type_Long = paramParcel.readLong();
    localLocalMediaInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localLocalMediaInfo.h = paramParcel.readInt();
    localLocalMediaInfo.i = paramParcel.readInt();
    localLocalMediaInfo.j = paramParcel.readInt();
    localLocalMediaInfo.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramParcel.readInt());
    localLocalMediaInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localLocalMediaInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localLocalMediaInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localLocalMediaInfo.jdField_d_of_type_Int = paramParcel.readInt();
    localLocalMediaInfo.g = paramParcel.readInt();
    localLocalMediaInfo.f = paramParcel.readInt();
    return localLocalMediaInfo;
  }
  
  public LocalMediaInfo[] a(int paramInt)
  {
    return new LocalMediaInfo[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.LocalMediaInfo.1
 * JD-Core Version:    0.7.0.1
 */