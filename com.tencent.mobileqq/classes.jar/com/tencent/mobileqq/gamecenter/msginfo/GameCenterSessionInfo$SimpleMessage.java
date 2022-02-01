package com.tencent.mobileqq.gamecenter.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameCenterSessionInfo$SimpleMessage
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleMessage> CREATOR = new GameCenterSessionInfo.SimpleMessage.1();
  public final long a;
  public final String b;
  
  public GameCenterSessionInfo$SimpleMessage(long paramLong, String paramString)
  {
    this.a = paramLong;
    this.b = paramString;
  }
  
  protected GameCenterSessionInfo$SimpleMessage(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo.SimpleMessage
 * JD-Core Version:    0.7.0.1
 */