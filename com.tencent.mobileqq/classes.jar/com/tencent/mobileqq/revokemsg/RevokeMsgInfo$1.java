package com.tencent.mobileqq.revokemsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RevokeMsgInfo$1
  implements Parcelable.Creator<RevokeMsgInfo>
{
  public RevokeMsgInfo a(Parcel paramParcel)
  {
    boolean bool = true;
    RevokeMsgInfo localRevokeMsgInfo = new RevokeMsgInfo();
    localRevokeMsgInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localRevokeMsgInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localRevokeMsgInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localRevokeMsgInfo.d = paramParcel.readString();
    localRevokeMsgInfo.b = paramParcel.readLong();
    localRevokeMsgInfo.c = paramParcel.readLong();
    localRevokeMsgInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localRevokeMsgInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localRevokeMsgInfo.jdField_f_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localRevokeMsgInfo.jdField_a_of_type_Boolean = bool;
      localRevokeMsgInfo.g = paramParcel.readInt();
      localRevokeMsgInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
      return localRevokeMsgInfo;
      bool = false;
    }
  }
  
  public RevokeMsgInfo[] a(int paramInt)
  {
    return new RevokeMsgInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.revokemsg.RevokeMsgInfo.1
 * JD-Core Version:    0.7.0.1
 */