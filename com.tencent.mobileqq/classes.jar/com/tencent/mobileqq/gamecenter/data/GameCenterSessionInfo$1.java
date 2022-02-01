package com.tencent.mobileqq.gamecenter.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GameCenterSessionInfo$1
  implements Parcelable.Creator<GameCenterSessionInfo>
{
  public GameCenterSessionInfo a(Parcel paramParcel)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = new GameCenterSessionInfo();
    localGameCenterSessionInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localGameCenterSessionInfo.f = paramParcel.readString();
    localGameCenterSessionInfo.g = paramParcel.readString();
    localGameCenterSessionInfo.h = paramParcel.readString();
    localGameCenterSessionInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localGameCenterSessionInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.i = paramParcel.readString();
    localGameCenterSessionInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localGameCenterSessionInfo.jdField_d_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localGameCenterSessionInfo.j = paramParcel.readString();
    localGameCenterSessionInfo.k = paramParcel.readString();
    localGameCenterSessionInfo.l = paramParcel.readString();
    localGameCenterSessionInfo.m = paramParcel.readString();
    localGameCenterSessionInfo.jdField_c_of_type_Long = paramParcel.readLong();
    localGameCenterSessionInfo.jdField_d_of_type_Long = paramParcel.readLong();
    paramParcel = paramParcel.readParcelableArray(GameCenterSessionInfo.SimpleMessage.class.getClassLoader());
    if (paramParcel != null)
    {
      localGameCenterSessionInfo.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage = new GameCenterSessionInfo.SimpleMessage[paramParcel.length];
      int i = 0;
      while (i < paramParcel.length)
      {
        localGameCenterSessionInfo.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage[i] = ((GameCenterSessionInfo.SimpleMessage)paramParcel[i]);
        i += 1;
      }
    }
    return localGameCenterSessionInfo;
  }
  
  public GameCenterSessionInfo[] a(int paramInt)
  {
    return new GameCenterSessionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo.1
 * JD-Core Version:    0.7.0.1
 */