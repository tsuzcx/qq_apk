package com.tencent.mobileqq.gamecenter.msginfo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GameCenterSessionInfo$1
  implements Parcelable.Creator<GameCenterSessionInfo>
{
  public GameCenterSessionInfo a(Parcel paramParcel)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = new GameCenterSessionInfo();
    localGameCenterSessionInfo.a = paramParcel.readInt();
    localGameCenterSessionInfo.b = paramParcel.readString();
    localGameCenterSessionInfo.c = paramParcel.readInt();
    localGameCenterSessionInfo.d = paramParcel.readString();
    localGameCenterSessionInfo.e = paramParcel.readString();
    localGameCenterSessionInfo.f = paramParcel.readString();
    localGameCenterSessionInfo.g = paramParcel.readString();
    localGameCenterSessionInfo.h = paramParcel.readString();
    localGameCenterSessionInfo.i = paramParcel.readString();
    localGameCenterSessionInfo.j = paramParcel.readString();
    localGameCenterSessionInfo.k = paramParcel.readLong();
    localGameCenterSessionInfo.l = paramParcel.readInt();
    localGameCenterSessionInfo.m = paramParcel.readString();
    localGameCenterSessionInfo.n = paramParcel.readLong();
    localGameCenterSessionInfo.o = paramParcel.readInt();
    localGameCenterSessionInfo.p = paramParcel.readInt();
    localGameCenterSessionInfo.q = paramParcel.readString();
    localGameCenterSessionInfo.r = paramParcel.readString();
    localGameCenterSessionInfo.s = paramParcel.readString();
    localGameCenterSessionInfo.t = paramParcel.readString();
    localGameCenterSessionInfo.v = paramParcel.readLong();
    localGameCenterSessionInfo.w = paramParcel.readLong();
    paramParcel = paramParcel.readParcelableArray(GameCenterSessionInfo.SimpleMessage.class.getClassLoader());
    if (paramParcel != null)
    {
      localGameCenterSessionInfo.x = new GameCenterSessionInfo.SimpleMessage[paramParcel.length];
      int i = 0;
      while (i < paramParcel.length)
      {
        localGameCenterSessionInfo.x[i] = ((GameCenterSessionInfo.SimpleMessage)paramParcel[i]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo.1
 * JD-Core Version:    0.7.0.1
 */