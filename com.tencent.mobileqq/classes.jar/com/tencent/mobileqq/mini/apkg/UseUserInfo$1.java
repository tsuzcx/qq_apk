package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UseUserInfo$1
  implements Parcelable.Creator<UseUserInfo>
{
  public UseUserInfo createFromParcel(Parcel paramParcel)
  {
    UseUserInfo localUseUserInfo = new UseUserInfo();
    localUseUserInfo.uin = paramParcel.readString();
    localUseUserInfo.avatar = paramParcel.readString();
    localUseUserInfo.nick = paramParcel.readString();
    return localUseUserInfo;
  }
  
  public UseUserInfo[] newArray(int paramInt)
  {
    return new UseUserInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.UseUserInfo.1
 * JD-Core Version:    0.7.0.1
 */