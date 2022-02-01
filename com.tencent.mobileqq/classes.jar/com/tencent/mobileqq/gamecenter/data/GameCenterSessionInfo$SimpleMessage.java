package com.tencent.mobileqq.gamecenter.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avbw;

public class GameCenterSessionInfo$SimpleMessage
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleMessage> CREATOR = new avbw();
  public final long a;
  public final String a;
  
  public GameCenterSessionInfo$SimpleMessage(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GameCenterSessionInfo$SimpleMessage(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo.SimpleMessage
 * JD-Core Version:    0.7.0.1
 */